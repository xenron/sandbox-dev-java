package tuning.stringconvert;


import java.util.Hashtable;
import java.util.Vector;

/**
 * The AppenderHelper class works around several inefficencies
 * in the Java distribution.
 * <p>
 * The following items really need to be added to Java to eliminate
 * the use of AppenderHelper:
 * <ul>
 *  <li>Object needs the method <code>appendTo(StringBuffer,int)</code>
 *  <li>The classes in the Java distribution need to improve their conversions to Strings
 * </ul>
 * (As an aside, there should really be an <code>Appender</code> interface, which
 * StringBuffer implements with all the <code>append</code> methods defined.)
 * <p>
 * Instead, AppenderHelper supports the efficient appending of object's string
 * representation to a StringBuffer. Basically this means that all the basic
 * data types have their own conversion algorithms in this class which are
 * considerably more efficient than the Java ones (except char which, of course,
 * doesn't need conversion) and, in addition, several classes also have
 * specialized conversion algorithms.
 * <p>
 * In addition, the whole thing is fully extensible (though I would prefer that
 * it were made redundant by correct implementations in Java).
 * <p>
 * As an example
 * <pre>
 * StringBuffer s = new StringBuffer();
 * s.append(567);
 * </pre>
 * maps to
 * <pre>
 * StringBuffer s = new StringBuffer();
 * AppenderHelper a = AppenderHelper.SINGLETON;
 * a.append(s,567);
 * </pre>
 * The difference is that in the first StringBuffer append, the StringBuffer
 * append first asks Integer to convert the int 567 into a String. This conversion
 * is not very efficient, and apart from being not as fast as it could be, also
 * creates another temporary StringBuffer during the conversion (which in turn creates
 * another internal char array). So for appending one int to the StringBuffer
 * we get three temporary objects, the space they use, and a not particularly
 * optimized conversion algorithm.
 * <p>
 * On the other hand, in the second AppenderHelper example, we create no extra
 * objects at all, and use an optimized conversion algorithm. Which means that even
 * though we have to call the StringBuffer append(char) lots of times, it is
 * still faster and uses less resources from the VM (and yes, the two are related,
 * one reason it is faster is because it uses less VM resources).
 * <p>
 * The easisest way to add support for using AppenderHelper with classes
 * you have control over is to implement the Appendable interface.
 * <p>
 * For classes you do not control, you need to implement an AppendConverter
 * class, and register it with the AppenderHelper.
 * <p>
 * But NOTE that if you do not need efficient conversion of objects (because
 * you do not do much StringBuffer appending, or it happens in a part of the
 * application that has plenty of spare time and resources), then there is no
 * need to change the way you do things at the moment.
 * <p>
 * AppenderHelper can be used in a very similar way to StringBuffer, e.g.
 * <pre>
 * StringBuffer s = new StringBuffer();
 * AppenderHelper a = AppenderHelper.SINGLETON;
 * a.append(s,567).append(s," is ").append(s,33.5).append(s,'%');
 * </pre>
 * and there is also a StringBufferWrapper class if you are feeling really lazy.
 * <p>
 * All data type conversions are specifically optimized by AppenderHelper.
 * In addition, the classes specifically optimized by AppenderHelper (and so
 * which do not need AppendConverter classes for them) are: all the classes
 * coresponding to the basic datatypes (e.g. Integer, etc.); Object; java.util.Vector.
 * <p>
 * Note however that subclasses of these types are not specially optimized unless
 * the correct overloaded append method is called, i.e. if java.util.Stack were not
 * registered (which it is) then
 * <pre>
 * StringBuffer s = new StringBuffer();
 * AppenderHelper a = AppenderHelper.SINGLETON;
 * java.util.Stack stack = new java.util.Stack();
 * a.append(s,stack);
 * </pre>
 * <em>would</em> be optimized because that calls the 
 * <code>AppenderHelper.append(StringBuffer,java.util.Vector)</code> method, but
 * <pre>
 * StringBuffer s = new StringBuffer();
 * AppenderHelper a = AppenderHelper.SINGLETON;
 * java.util.Stack stack = new java.util.Stack();
 * a.append(s,(Object) stack);
 * </pre>
 * would <em>not</em> be optimized because that calls the 
 * <code>AppenderHelper.append(StringBuffer,Object)</code> method, which
 * requires the passed object's class to be registered for the correct AppendConverter
 * to be used.
 * <p>
 * AppenderHelper is an application (i.e. has a runnable <code>main</code> method)
 * which can be run to see examples of the improvements it brings.
 * @see main()
 * @see Appendable
 * @see AppendConverter
 * @see StringBufferWrapper
 * @see StringBuffer
 */
public class AppenderHelper
{
	public static AppenderHelper SINGLETON = new AppenderHelper();
	public static int DEFAULT_DEPTH = Integer.MAX_VALUE;
	/**
	 * char array holding the characters for the string "true".
	 */
	public static final char[] TRUE = {'t','r','u','e'};
	/**
	 * char array holding the characters for the string "false".
	 */
	public static final char[] FALSE = {'f','a','l','s','e'};
	/**
	 * char array holding the characters for the string "null".
	 */
	public static final char[] NULL = {'n','u','l','l'};
	/**
	 * char array holding the characters for the string "-Infinity".
	 */
	public static final char[] NEGATIVE_INFINITY = {'-','I','n','f','i','n','i','t','y'};
	/**
	 * char array holding the characters for the string "Infinity".
	 */
	public static final char[] POSITIVE_INFINITY = {'I','n','f','i','n','i','t','y'};
	/**
	 * char array holding the characters for the string "NaN".
	 */
	public static final char[] NaN = {'N','a','N'};
	/**
	 * char array holding the characters for the string "0.0".
	 */
	public static final char[] DOUBLE_ZERO = {'0','.','0'};
	/**
	 * char array holding the characters for the string "0.00".
	 */
	public static final char[] DOUBLE_ZERO2 = {'0','.','0','0'};
	/**
	 * char array holding the characters for the string "0.".
	 */
	public static final char[] DOUBLE_ZERO0 = {'0','.'};
	/**
	 * char array holding the characters for the string ".0".
	 */
	public static final char[] DOT_ZERO = {'.','0'};
	/**
	 * char array holding the characters for the string ", ".
	 */
	public static final char[] COMMA_SPACE = {',',' '};

	private static final long	doubleSignMask = 0x8000000000000000L;
	private static final long	doubleExpMask  = 0x7ff0000000000000L;
	private static final long	doubleFractMask= ~(doubleSignMask|doubleExpMask);
	private static final int	doubleExpShift = 52;
	private static final int	doubleExpBias = 1023;
	private static final int	floatSignMask = 0x80000000;
	private static final int	floatExpMask  = 0x7f800000;
	private static final int	floatFractMask= ~(floatSignMask|floatExpMask);
	private static final int	floatExpShift = 23;
	private static final int	floatExpBias = 127;

	private static final Hashtable append_map = new Hashtable();
	private static final Hashtable clsname_cache = new Hashtable();
	static
	{
		initializeMaps();
	}

	private static final char[] charForDigit = {
		'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h',
		'i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
	};

	private static final float[] f_magnitudes = {
1e-44F, 1e-43F, 1e-42F, 1e-41F, 1e-40F,
1e-39F, 1e-38F, 1e-37F, 1e-36F, 1e-35F, 1e-34F, 1e-33F, 1e-32F, 1e-31F, 1e-30F,
1e-29F, 1e-28F, 1e-27F, 1e-26F, 1e-25F, 1e-24F, 1e-23F, 1e-22F, 1e-21F, 1e-20F,
1e-19F, 1e-18F, 1e-17F, 1e-16F, 1e-15F, 1e-14F, 1e-13F, 1e-12F, 1e-11F, 1e-10F,
1e-9F, 1e-8F, 1e-7F, 1e-6F, 1e-5F, 1e-4F, 1e-3F, 1e-2F, 1e-1F,
1e0F, 1e1F, 1e2F, 1e3F, 1e4F, 1e5F, 1e6F, 1e7F, 1e8F, 1e9F,
1e10F, 1e11F, 1e12F, 1e13F, 1e14F, 1e15F, 1e16F, 1e17F, 1e18F, 1e19F,
1e20F, 1e21F, 1e22F, 1e23F, 1e24F, 1e25F, 1e26F, 1e27F, 1e28F, 1e29F,
1e30F, 1e31F, 1e32F, 1e33F, 1e34F, 1e35F, 1e36F, 1e37F, 1e38F
	};


	private static final double[] d_magnitudes = {
1e-323D, 1e-322D, 1e-321D, 1e-320D, 1e-319D, 1e-318D, 1e-317D, 1e-316D, 1e-315D, 1e-314D, 
1e-313D, 1e-312D, 1e-311D, 1e-310D, 1e-309D, 1e-308D, 1e-307D, 1e-306D, 1e-305D, 1e-304D, 
1e-303D, 1e-302D, 1e-301D, 1e-300D, 1e-299D, 1e-298D, 1e-297D, 1e-296D, 1e-295D, 1e-294D, 
1e-293D, 1e-292D, 1e-291D, 1e-290D, 1e-289D, 1e-288D, 1e-287D, 1e-286D, 1e-285D, 1e-284D, 
1e-283D, 1e-282D, 1e-281D, 1e-280D, 1e-279D, 1e-278D, 1e-277D, 1e-276D, 1e-275D, 1e-274D, 
1e-273D, 1e-272D, 1e-271D, 1e-270D, 1e-269D, 1e-268D, 1e-267D, 1e-266D, 1e-265D, 1e-264D, 
1e-263D, 1e-262D, 1e-261D, 1e-260D, 1e-259D, 1e-258D, 1e-257D, 1e-256D, 1e-255D, 1e-254D, 
1e-253D, 1e-252D, 1e-251D, 1e-250D, 1e-249D, 1e-248D, 1e-247D, 1e-246D, 1e-245D, 1e-244D, 
1e-243D, 1e-242D, 1e-241D, 1e-240D, 1e-239D, 1e-238D, 1e-237D, 1e-236D, 1e-235D, 1e-234D, 
1e-233D, 1e-232D, 1e-231D, 1e-230D, 1e-229D, 1e-228D, 1e-227D, 1e-226D, 1e-225D, 1e-224D, 
1e-223D, 1e-222D, 1e-221D, 1e-220D, 1e-219D, 1e-218D, 1e-217D, 1e-216D, 1e-215D, 1e-214D, 
1e-213D, 1e-212D, 1e-211D, 1e-210D, 1e-209D, 1e-208D, 1e-207D, 1e-206D, 1e-205D, 1e-204D, 
1e-203D, 1e-202D, 1e-201D, 1e-200D, 1e-199D, 1e-198D, 1e-197D, 1e-196D, 1e-195D, 1e-194D, 
1e-193D, 1e-192D, 1e-191D, 1e-190D, 1e-189D, 1e-188D, 1e-187D, 1e-186D, 1e-185D, 1e-184D, 
1e-183D, 1e-182D, 1e-181D, 1e-180D, 1e-179D, 1e-178D, 1e-177D, 1e-176D, 1e-175D, 1e-174D, 
1e-173D, 1e-172D, 1e-171D, 1e-170D, 1e-169D, 1e-168D, 1e-167D, 1e-166D, 1e-165D, 1e-164D, 
1e-163D, 1e-162D, 1e-161D, 1e-160D, 1e-159D, 1e-158D, 1e-157D, 1e-156D, 1e-155D, 1e-154D, 
1e-153D, 1e-152D, 1e-151D, 1e-150D, 1e-149D, 1e-148D, 1e-147D, 1e-146D, 1e-145D, 1e-144D, 
1e-143D, 1e-142D, 1e-141D, 1e-140D, 1e-139D, 1e-138D, 1e-137D, 1e-136D, 1e-135D, 1e-134D, 
1e-133D, 1e-132D, 1e-131D, 1e-130D, 1e-129D, 1e-128D, 1e-127D, 1e-126D, 1e-125D, 1e-124D, 
1e-123D, 1e-122D, 1e-121D, 1e-120D, 1e-119D, 1e-118D, 1e-117D, 1e-116D, 1e-115D, 1e-114D, 
1e-113D, 1e-112D, 1e-111D, 1e-110D, 1e-109D, 1e-108D, 1e-107D, 1e-106D, 1e-105D, 1e-104D, 
1e-103D, 1e-102D, 1e-101D, 1e-100D, 1e-99D, 1e-98D, 1e-97D, 1e-96D, 1e-95D, 1e-94D, 
1e-93D, 1e-92D, 1e-91D, 1e-90D, 1e-89D, 1e-88D, 1e-87D, 1e-86D, 1e-85D, 1e-84D, 
1e-83D, 1e-82D, 1e-81D, 1e-80D, 1e-79D, 1e-78D, 1e-77D, 1e-76D, 1e-75D, 1e-74D, 
1e-73D, 1e-72D, 1e-71D, 1e-70D, 1e-69D, 1e-68D, 1e-67D, 1e-66D, 1e-65D, 1e-64D, 
1e-63D, 1e-62D, 1e-61D, 1e-60D, 1e-59D, 1e-58D, 1e-57D, 1e-56D, 1e-55D, 1e-54D, 
1e-53D, 1e-52D, 1e-51D, 1e-50D, 1e-49D, 1e-48D, 1e-47D, 1e-46D, 1e-45D, 1e-44D, 
1e-43D, 1e-42D, 1e-41D, 1e-40D, 1e-39D, 1e-38D, 1e-37D, 1e-36D, 1e-35D, 1e-34D, 
1e-33D, 1e-32D, 1e-31D, 1e-30D, 1e-29D, 1e-28D, 1e-27D, 1e-26D, 1e-25D, 1e-24D, 
1e-23D, 1e-22D, 1e-21D, 1e-20D, 1e-19D, 1e-18D, 1e-17D, 1e-16D, 1e-15D, 1e-14D, 
1e-13D, 1e-12D, 1e-11D, 1e-10D, 1e-9D, 1e-8D, 1e-7D, 1e-6D, 1e-5D, 1e-4D, 
1e-3D, 1e-2D, 1e-1D, 1e0D, 1e1D, 1e2D, 1e3D, 1e4D, 
1e5D, 1e6D, 1e7D, 1e8D, 1e9D, 1e10D, 1e11D, 1e12D, 1e13D, 1e14D, 
1e15D, 1e16D, 1e17D, 1e18D, 1e19D, 1e20D, 1e21D, 1e22D, 1e23D, 1e24D, 
1e25D, 1e26D, 1e27D, 1e28D, 1e29D, 1e30D, 1e31D, 1e32D, 1e33D, 1e34D, 
1e35D, 1e36D, 1e37D, 1e38D, 1e39D, 1e40D, 1e41D, 1e42D, 1e43D, 1e44D, 
1e45D, 1e46D, 1e47D, 1e48D, 1e49D, 1e50D, 1e51D, 1e52D, 1e53D, 1e54D, 
1e55D, 1e56D, 1e57D, 1e58D, 1e59D, 1e60D, 1e61D, 1e62D, 1e63D, 1e64D, 
1e65D, 1e66D, 1e67D, 1e68D, 1e69D, 1e70D, 1e71D, 1e72D, 1e73D, 1e74D, 
1e75D, 1e76D, 1e77D, 1e78D, 1e79D, 1e80D, 1e81D, 1e82D, 1e83D, 1e84D, 
1e85D, 1e86D, 1e87D, 1e88D, 1e89D, 1e90D, 1e91D, 1e92D, 1e93D, 1e94D, 
1e95D, 1e96D, 1e97D, 1e98D, 1e99D, 1e100D, 1e101D, 1e102D, 1e103D, 1e104D, 
1e105D, 1e106D, 1e107D, 1e108D, 1e109D, 1e110D, 1e111D, 1e112D, 1e113D, 1e114D, 
1e115D, 1e116D, 1e117D, 1e118D, 1e119D, 1e120D, 1e121D, 1e122D, 1e123D, 1e124D, 
1e125D, 1e126D, 1e127D, 1e128D, 1e129D, 1e130D, 1e131D, 1e132D, 1e133D, 1e134D, 
1e135D, 1e136D, 1e137D, 1e138D, 1e139D, 1e140D, 1e141D, 1e142D, 1e143D, 1e144D, 
1e145D, 1e146D, 1e147D, 1e148D, 1e149D, 1e150D, 1e151D, 1e152D, 1e153D, 1e154D, 
1e155D, 1e156D, 1e157D, 1e158D, 1e159D, 1e160D, 1e161D, 1e162D, 1e163D, 1e164D, 
1e165D, 1e166D, 1e167D, 1e168D, 1e169D, 1e170D, 1e171D, 1e172D, 1e173D, 1e174D, 
1e175D, 1e176D, 1e177D, 1e178D, 1e179D, 1e180D, 1e181D, 1e182D, 1e183D, 1e184D, 
1e185D, 1e186D, 1e187D, 1e188D, 1e189D, 1e190D, 1e191D, 1e192D, 1e193D, 1e194D, 
1e195D, 1e196D, 1e197D, 1e198D, 1e199D, 1e200D, 1e201D, 1e202D, 1e203D, 1e204D, 
1e205D, 1e206D, 1e207D, 1e208D, 1e209D, 1e210D, 1e211D, 1e212D, 1e213D, 1e214D, 
1e215D, 1e216D, 1e217D, 1e218D, 1e219D, 1e220D, 1e221D, 1e222D, 1e223D, 1e224D, 
1e225D, 1e226D, 1e227D, 1e228D, 1e229D, 1e230D, 1e231D, 1e232D, 1e233D, 1e234D, 
1e235D, 1e236D, 1e237D, 1e238D, 1e239D, 1e240D, 1e241D, 1e242D, 1e243D, 1e244D, 
1e245D, 1e246D, 1e247D, 1e248D, 1e249D, 1e250D, 1e251D, 1e252D, 1e253D, 1e254D, 
1e255D, 1e256D, 1e257D, 1e258D, 1e259D, 1e260D, 1e261D, 1e262D, 1e263D, 1e264D, 
1e265D, 1e266D, 1e267D, 1e268D, 1e269D, 1e270D, 1e271D, 1e272D, 1e273D, 1e274D, 
1e275D, 1e276D, 1e277D, 1e278D, 1e279D, 1e280D, 1e281D, 1e282D, 1e283D, 1e284D, 
1e285D, 1e286D, 1e287D, 1e288D, 1e289D, 1e290D, 1e291D, 1e292D, 1e293D, 1e294D, 
1e295D, 1e296D, 1e297D, 1e298D, 1e299D, 1e300D, 1e301D, 1e302D, 1e303D, 1e304D, 
1e305D, 1e306D, 1e307D, 1e308D
		};


/**
 * AppenderHelper is a singleton, so the constructor is just narrowed
 * in scope to disallow external classes to create further instances.
 * <p>
 * Subclasses can create new instances (required in order to allow them
 * to create instances of themselves), but should refrain from doing so.
 */
protected AppenderHelper()
{
}
/**
 * Appends the string representation of the
 * char array argument to the string buffer.
 * @param s the StringBuffer to append the object to.
 * @param c the characters to be appended.
 * @param   offset   the index of the first character to append.
 * @param   len      the number of characters to append.
 * @return this AppenderHelper
 * @see StringBuffer#append(char[])
 */
public AppenderHelper append(StringBuffer s, char[] c)
{
	if (c == null)
	{
		s.append(NULL);
		return this;
	}
	s.append(c);
	return this;
}
/**
 * Appends the string representation of a subarray of the
 * char array argument to the string buffer.
 * @param s the StringBuffer to append the object to.
 * @param c the characters to be appended.
 * @param   offset   the index of the first character to append.
 * @param   len      the number of characters to append.
 * @return this AppenderHelper
 * @see StringBuffer#append(char[], int, int)
 */
public AppenderHelper append(StringBuffer s, char[] c, int offset, int len)
{
	if (c == null)
	{
		s.append(NULL);
		return this;
	}
	s.append(c,offset,len);
	return this;
}
/**
 * Appends the character to the string buffer.
 * @param s the StringBuffer to append the object to.
 * @param c the character to be appended.
 * @return this AppenderHelper
 * @see StringBuffer#append(char)
 */
public AppenderHelper append(StringBuffer s, char c)
{
	s.append(c);
	return this;
}
/**
 * Appends the string representation of the
 * double argument to the string buffer.
 * @param s the StringBuffer to append the object to.
 * @param d the double to be appended.
 * @return this AppenderHelper
 * @see StringBuffer#append(double)
 */
public AppenderHelper append(StringBuffer s, double d)
{
	if (d == Double.NEGATIVE_INFINITY)
		s.append(NEGATIVE_INFINITY);
	else if (d == Double.POSITIVE_INFINITY)
		s.append(POSITIVE_INFINITY);
	else if (d != d)
		s.append(NaN);
	else if (d == 0.0)
	{
		if ( (Double.doubleToLongBits(d) & doubleSignMask) != 0)
			s.append('-');
		s.append(DOUBLE_ZERO);
	}
	else
	{
		if (d < 0)
		{
			s.append('-');
			d = -d;
		}
		if (d >= 0.001 && d < 0.01)
		{
			long i = (long) (d * 1E20);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			s.append(DOUBLE_ZERO2);
			appendFractDigits(s, i,-1);
		}
		else if (d >= 0.01 && d < 0.1)
		{
			long i = (long) (d * 1E19);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			s.append(DOUBLE_ZERO);
			appendFractDigits(s, i,-1);
		}
		else if (d >= 0.1 && d < 1)
		{
			long i = (long) (d * 1E18);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			s.append(DOUBLE_ZERO0);
			appendFractDigits(s, i,-1);
		}
		else if (d >= 1 && d < 10)
		{
			long i = (long) (d * 1E17);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			appendFractDigits(s, i,1);
		}
		else if (d >= 10 && d < 100)
		{
			long i = (long) (d * 1E16);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			appendFractDigits(s, i,2);
		}
		else if (d >= 100 && d < 1000)
		{
			long i = (long) (d * 1E15);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			appendFractDigits(s, i,3);
		}
		else if (d >= 1000 && d < 10000)
		{
			long i = (long) (d * 1E14);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			appendFractDigits(s, i,4);
		}
		else if (d >= 10000 && d < 100000)
		{
			long i = (long) (d * 1E13);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			appendFractDigits(s, i,5);
		}
		else if (d >= 100000 && d < 1000000)
		{
			long i = (long) (d * 1E12);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			appendFractDigits(s, i,6);
		}
		else if (d >= 1000000 && d < 10000000)
		{
			long i = (long) (d * 1E11);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			appendFractDigits(s, i,7);
		}
		else
		{
			int magnitude = magnitude(d);
			long i;
			if (magnitude < -305)
				i = (long) (d*1E18 / d_magnitudes[magnitude + 324]);
			else
				i = (long) (d / d_magnitudes[magnitude + 323 - 17]);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			appendFractDigits(s, i, 1);
			s.append('E');
			append(s,magnitude);
		}
	}
	return this;
}
/**
 * Appends the string representation of the
 * float argument to the string buffer.
 * @param s the StringBuffer to append the object to.
 * @param d the float to be appended.
 * @return this AppenderHelper
 * @see StringBuffer#append(float)
 */
public AppenderHelper append(StringBuffer s, float d)
{
	if (d == Float.NEGATIVE_INFINITY)
		s.append(NEGATIVE_INFINITY);
	else if (d == Float.POSITIVE_INFINITY)
		s.append(POSITIVE_INFINITY);
	else if (d != d)
		s.append(NaN);
	else if (d == 0.0)
	{
		if ( (Float.floatToIntBits(d) & floatSignMask) != 0)
			s.append('-');
		s.append(DOUBLE_ZERO);
	}
	else
	{
		if (d < 0)
		{
			s.append('-');
			d = -d;
		}
		if (d >= 0.001F && d < 0.01F)
		{
			long i = (long) (d * 1E12F);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			s.append(DOUBLE_ZERO2);
			appendFractDigits(s, i,-1);
		}
		else if (d >= 0.01F && d < 0.1F)
		{
			long i = (long) (d * 1E11F);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			s.append(DOUBLE_ZERO);
			appendFractDigits(s, i,-1);
		}
		else if (d >= 0.1F && d < 1F)
		{
			long i = (long) (d * 1E10F);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			s.append(DOUBLE_ZERO0);
			appendFractDigits(s, i,-1);
		}
		else if (d >= 1F && d < 10F)
		{
			long i = (long) (d * 1E9F);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			appendFractDigits(s, i,1);
		}
		else if (d >= 10F && d < 100F)
		{
			long i = (long) (d * 1E8F);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			appendFractDigits(s, i,2);
		}
		else if (d >= 100F && d < 1000F)
		{
			long i = (long) (d * 1E7F);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			appendFractDigits(s, i,3);
		}
		else if (d >= 1000F && d < 10000F)
		{
			long i = (long) (d * 1E6F);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			appendFractDigits(s, i,4);
		}
		else if (d >= 10000F && d < 100000F)
		{
			long i = (long) (d * 1E5F);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			appendFractDigits(s, i,5);
		}
		else if (d >= 100000F && d < 1000000F)
		{
			long i = (long) (d * 1E4F);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			appendFractDigits(s, i,6);
		}
		else if (d >= 1000000F && d < 10000000F)
		{
			long i = (long) (d * 1E3F);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			appendFractDigits(s, i,7);
		}
		else
		{
			int magnitude = magnitude(d);
			long i;
			if (magnitude < -35)
				i = (long) (d*1E10F / f_magnitudes[magnitude + 45]);
			else
				i = (long) (d / f_magnitudes[magnitude + 44 - 9]);
			i = i%100 >= 50 ? (i/100) + 1 : i/100;
			appendFractDigits(s, i, 1);
			s.append('E');
			append(s,magnitude);
		}
	}
	return this;
}
/**
 * Appends the string representation of the
 * long argument to the string buffer.
 * @param s the StringBuffer to append the object to.
 * @param i the long to be appended.
 * @return this AppenderHelper
 * @see StringBuffer#append(long)
 */
public AppenderHelper append(StringBuffer s, long i)
{
	if (i < 0)
	{
		if (i == Long.MIN_VALUE)
		{
			//cannot make this positive due to integer overflow
			s.append("-9223372036854775808");
			return this;
		}
		s.append('-');
		i = -i;
	}
	long mag = magnitude(i);
	long c;
	while ( mag > 1 )
	{
		c = i/mag;
		s.append(charForDigit[(int) c]);
		c *= mag;
		if ( c <= i)
			i -= c;
		mag /= 10;
	}
	s.append(charForDigit[(int) i]);
	return this;
}

public AppenderHelper append(StringBuffer s, int i)
{
	if (i < 0)
	{
		if (i == Integer.MIN_VALUE)
		{
			//cannot make this positive due to integer overflow
			s.append("-2147483648");
			return this;
		}
		s.append('-');
		i = -i;
	}
	int mag;
	int c;
	if (i < 10)
	{
		//one digit
		s.append(charForDigit[i]);
		return this;
	}
	else if (i < 100)
	{
		//two digits
		s.append(charForDigit[i/10]);
		s.append(charForDigit[i%10]);
		return this;
	}
	else if (i < 1000)
	{
		//three digits
		s.append(charForDigit[i/100]);
		s.append(charForDigit[(c=i%100)/10]);
		s.append(charForDigit[c%10]);
		return this;
	}
	else if (i < 10000)
	{
		//four digits
		s.append(charForDigit[i/1000]);
		s.append(charForDigit[(c=i%1000)/100]);
		s.append(charForDigit[(c%=100)/10]);
		s.append(charForDigit[c%10]);
		return this;
	}
	else if (i < 100000)
	{
		//five digits
		s.append(charForDigit[i/10000]);
		s.append(charForDigit[(c=i%10000)/1000]);
		s.append(charForDigit[(c%=1000)/100]);
		s.append(charForDigit[(c%=100)/10]);
		s.append(charForDigit[c%10]);
		return this;
	}
	else if (i < 1000000)
	{
		//six digits
		s.append(charForDigit[i/100000]);
		s.append(charForDigit[(c=i%100000)/10000]);
		s.append(charForDigit[(c%=10000)/1000]);
		s.append(charForDigit[(c%=1000)/100]);
		s.append(charForDigit[(c%=100)/10]);
		s.append(charForDigit[c%10]);
		return this;
	}
	else if (i < 10000000)
	{
		//seven digits
		s.append(charForDigit[i/1000000]);
		s.append(charForDigit[(c=i%1000000)/100000]);
		s.append(charForDigit[(c%=100000)/10000]);
		s.append(charForDigit[(c%=10000)/1000]);
		s.append(charForDigit[(c%=1000)/100]);
		s.append(charForDigit[(c%=100)/10]);
		s.append(charForDigit[c%10]);
		return this;
	}
	else if (i < 100000000)
	{
		//eight digits
		s.append(charForDigit[i/10000000]);
		s.append(charForDigit[(c=i%10000000)/1000000]);
		s.append(charForDigit[(c%=1000000)/100000]);
		s.append(charForDigit[(c%=100000)/10000]);
		s.append(charForDigit[(c%=10000)/1000]);
		s.append(charForDigit[(c%=1000)/100]);
		s.append(charForDigit[(c%=100)/10]);
		s.append(charForDigit[c%10]);
		return this;
	}
	else if (i < 1000000000)
	{
		//nine digits
		s.append(charForDigit[i/100000000]);
		s.append(charForDigit[(c=i%100000000)/10000000]);
		s.append(charForDigit[(c%=10000000)/1000000]);
		s.append(charForDigit[(c%=1000000)/100000]);
		s.append(charForDigit[(c%=100000)/10000]);
		s.append(charForDigit[(c%=10000)/1000]);
		s.append(charForDigit[(c%=1000)/100]);
		s.append(charForDigit[(c%=100)/10]);
		s.append(charForDigit[c%10]);
		return this;
	}
	else
	{
		//ten digits
		s.append(charForDigit[i/1000000000]);
		s.append(charForDigit[(c=i%1000000000)/100000000]);
		s.append(charForDigit[(c%=100000000)/10000000]);
		s.append(charForDigit[(c%=10000000)/1000000]);
		s.append(charForDigit[(c%=1000000)/100000]);
		s.append(charForDigit[(c%=100000)/10000]);
		s.append(charForDigit[(c%=10000)/1000]);
		s.append(charForDigit[(c%=1000)/100]);
		s.append(charForDigit[(c%=100)/10]);
		s.append(charForDigit[c%10]);
		return this;
	}
}
private static int magnitude_i(int i)
{
	if (i < 10) return 1;
	else if (i < 100) return 10;
	else if (i < 1000) return 100;
	else if (i < 10000) return 1000;
	else if (i < 100000) return 10000;
	else if (i < 1000000) return 100000;
	else if (i < 10000000) return 1000000;
	else if (i < 100000000) return 10000000;
	else if (i < 1000000000) return 100000000;
	else return  1000000000;
}
/**
 * Appends the string representation of the
 * Appendable argument to the string buffer. Does so by calling the
 * <code>appendTo</code> method of the Appendable.
 * @param s the StringBuffer to append the object to.
 * @param o the Appendable to be appended.
 * @return this AppenderHelper
 * @see Appendable
 */
public AppenderHelper append(StringBuffer s, Appendable o)
{
	if (o == null)
	{
		s.append(NULL);
		return this;
	}
	o.appendTo(s, DEFAULT_DEPTH);
	return this;
}
/**
 * Appends the string representation of the
 * Appendable argument to the string buffer. Does so by calling the
 * <code>appendTo</code> method of the Appendable.
 * @param s the StringBuffer to append the object to.
 * @param o the Appendable to be appended.
 * @param depth the depth with which to display the Appendable.
 * @return this AppenderHelper
 * @see Appendable
 */
public AppenderHelper append(StringBuffer s, Appendable o, int depth)
{
	if (o == null)
	{
		s.append(NULL);
		return this;
	}
	if (depth <= 0)
		appendDepth0To(s,o);
	else
		o.appendTo(s, depth);
	return this;
}
/**
 * Appends the string representation of the
 * Boolean argument to the string buffer.
 * @param s the StringBuffer to append the object to.
 * @param o the Boolean to be appended.
 * @return this AppenderHelper
 */
public AppenderHelper append(StringBuffer s, Boolean o)
{
	if (o == null)
	{
		s.append(NULL);
		return this;
	}
	return append(s,o.booleanValue());
}
/**
 * Appends the string representation of the
 * Byte argument to the string buffer.
 * @param s the StringBuffer to append the object to.
 * @param o the Byte to be appended.
 * @return this AppenderHelper
 */
public AppenderHelper append(StringBuffer s, Byte o)
{
	if (o == null)
	{
		s.append(NULL);
		return this;
	}
	return append(s,o.byteValue());
}
/**
 * Appends the string representation of the
 * Character argument to the string buffer.
 * @param s the StringBuffer to append the object to.
 * @param o the Character to be appended.
 * @return this AppenderHelper
 */
public AppenderHelper append(StringBuffer s, Character o)
{
	if (o == null)
	{
		s.append(NULL);
		return this;
	}
	return append(s,o.charValue());
}
/**
 * Appends the string representation of the
 * Double argument to the string buffer.
 * @param s the StringBuffer to append the object to.
 * @param o the Double to be appended.
 * @return this AppenderHelper
 */
public AppenderHelper append(StringBuffer s, Double o)
{
	return append(s,o.doubleValue());
}
/**
 * Appends the string representation of the
 * Float argument to the string buffer.
 * @param s the StringBuffer to append the object to.
 * @param o the Float to be appended.
 * @return this AppenderHelper
 */
public AppenderHelper append(StringBuffer s, Float o)
{
	if (o == null)
	{
		s.append(NULL);
		return this;
	}
	return append(s,o.floatValue());
}
/**
 * Appends the string representation of the
 * Integer argument to the string buffer.
 * @param s the StringBuffer to append the object to.
 * @param o the Integer to be appended.
 * @return this AppenderHelper
 */
public AppenderHelper append(StringBuffer s, Integer o)
{
	if (o == null)
	{
		s.append(NULL);
		return this;
	}
	return append(s,o.intValue());
}
/**
 * Appends the string representation of the
 * Long argument to the string buffer.
 * @param s the StringBuffer to append the object to.
 * @param o the Long to be appended.
 * @return this AppenderHelper
 */
public AppenderHelper append(StringBuffer s, Long o)
{
	if (o == null)
	{
		s.append(NULL);
		return this;
	}
	return append(s,o.longValue());
}
/**
 * Appends the string representation of the
 * Object argument to the string buffer. If o is an Appendable, this will
 * delegate the append to the <code>appendTo</code> method.
 * If o has a registered append mapping, then this will delegate the append
 * to the registered AppendConverter object.
 * @param s the StringBuffer to append the object to.
 * @param o the Object to be appended.
 * @return this AppenderHelper
 * @see Appendable
 * @see AppendConverter
 */
public AppenderHelper append(StringBuffer s, Object o)
{
	return append(s, o, DEFAULT_DEPTH);
}
/**
 * Appends the string representation of the
 * Object argument to the string buffer. If o is an Appendable, this will
 * delegate the append to the <code>appendTo</code> method.
 * If o has a registered append mapping, then this will delegate the append
 * to the registered AppendConverter object.
 * @param s the StringBuffer to append the object to.
 * @param o the Object to be appended.
 * @param depth the depth with which to display the object.
 * @return this AppenderHelper
 * @see Appendable
 * @see AppendConverter
 */
public AppenderHelper append(StringBuffer s, Object o, int depth)
{
	if (o == null)
	{
		s.append(NULL);
		return this;
	}
	if (depth <= 0)
		appendDepth0To(s,o);
	else if (o instanceof Appendable)
		((Appendable) o).appendTo(s, depth);
	else
	{
		AppendConverter h = (AppendConverter) append_map.get(o.getClass());
		if (h == null)
			s.append(o);
		else
			h.appendObj(this, s, o, depth);
	}
	return this;
}
/**
 * Appends the string representation of the
 * Short argument to the string buffer.
 * @param s the StringBuffer to append the object to.
 * @param o the Short to be appended.
 * @return this AppenderHelper
 */
public AppenderHelper append(StringBuffer s, Short o)
{
	if (o == null)
	{
		s.append(NULL);
		return this;
	}
	return append(s,o.shortValue());
}
/**
 * Appends the string representation of the
 * String argument to the string buffer.
 * @param s the StringBuffer to append the object to.
 * @param o the String to be appended.
 * @return this AppenderHelper
 */
public AppenderHelper append(StringBuffer s, String o)
{
	if (o == null)
	{
		s.append(NULL);
		return this;
	}
	s.append(o);
	return this;
}
/**
 * Appends a java.util.Vector to a StringBuffer.
 * <p>
 * Since Vector is an object containing other objects, the contained objects
 * are also appended to the StringBuffer. These appended objects are also asked
 * to be appended by the AppenderHelper object.
 * <p>
 *
 * @param s the StringBuffer to append the object to.
 * @param o the Vector who's display is to be appended.
 */
public AppenderHelper append(StringBuffer s, Vector o)
{
	append(s, o, DEFAULT_DEPTH);
	return this;
}
/**
 * Appends a java.util.Vector to a StringBuffer.
 * <p>
 * Since Vector is an object containing other objects, the contained objects
 * are also appended to the StringBuffer. These appended objects are also asked
 * to be appended by the AppenderHelper object.
 * <p>
 * The <code>depth</code> parameter specifies how deep the contained objects
 * network should be asked to appended to the StringBuffer. A depth of 0
 * means just use a default representation of the object with no further
 * contained objects asked to rpresent themselves.
 *
 * @param s the StringBuffer to append the object to.
 * @param o the Vector who's display is to be appended.
 * @param depth depth of display for the Vector.
 */
public AppenderHelper append(StringBuffer s, Vector o, int depth)
{
	if (o == null)
	{
		s.append(NULL);
		return this;
	}
	if (depth <= 0)
	{
		appendDepth0To(s,o);
	}
	else
	{
		depth--;
		int size = o.size();
		s.append('[');
		if (size != 0)
		{
			this.append(s, o.elementAt(0), depth);
			for (int i = 1; i < size; i++)
			{
				s.append(COMMA_SPACE);
				this.append(s, o.elementAt(i), depth);
			}
		}
		s.append(']');
	}
	return this;
}
/**
 * Appends the string representation of the
 * boolean argument to the string buffer.
 * @param s the StringBuffer to append the object to.
 * @param o the boolean to be appended.
 * @return this AppenderHelper
 */
public AppenderHelper append(StringBuffer s, boolean b)
{
	if (b)
		s.append(TRUE);
	else
		s.append(FALSE);
	return this;
}
private static void appendAsUnsignedHexadecimal(StringBuffer s, int iin)
{
	long i = iin;
	if (i < 0)
		i += 4294967296L;

	long mag = magnitude16(i);
	long c;
	while ( mag > 1 )
	{
		c = i/mag;
		s.append(charForDigit[(int) c]);
		c *= mag;
		if ( c <= i)
			i -= c;
		mag = mag/16;
	}
	s.append(charForDigit[(int) i]);
}
/**
 * Appends the default string representation of the object as given in 
 * <code>Object.toString()</code>.
 * (The <code>toString</code> method for class <code>Object</code> 
 * returns a string consisting of the name of the class of which the 
 * object is an instance, the at-sign character `<code>@</code>', and 
 * the unsigned hexadecimal representation of the hash code of the 
 * object.)
 * <p>
 * Of course, this is quicker and more efficient than that method, and
 * does not create any extra extraneous objects.
 * @param s the StringBuffer to append the object representation to.
 * @param o the object who's default string representation is to appended.
 */
public final static void appendDepth0To(StringBuffer s, Object o)
{
	if (o == null)
	{
		s.append(NULL);
		return;
	}
	Class cls = o.getClass();
	String nme = (String) clsname_cache.get(cls);
	if (nme == null)
	{
		nme = cls.getName();
		clsname_cache.put(cls,nme);
	}
	s.append(nme).append('@');
	appendAsUnsignedHexadecimal(s,o.hashCode());
}
  public static final char[][] ZEROS = {
    {},
    {'0'},
    {'0','0'},
    {'0','0','0'},
    {'0','0','0','0'},
    {'0','0','0','0','0'},
    {'0','0','0','0','0','0'},
    {'0','0','0','0','0','0','0'},
    {'0','0','0','0','0','0','0','0'},
    {'0','0','0','0','0','0','0','0','0'},
    {'0','0','0','0','0','0','0','0','0','0'},
    {'0','0','0','0','0','0','0','0','0','0','0'},
    {'0','0','0','0','0','0','0','0','0','0','0','0'},
    {'0','0','0','0','0','0','0','0','0','0','0','0','0'},
    {'0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
    {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
    {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
    {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
    {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
    {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
    {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
  };
private static void appendFractDigits(StringBuffer s, long i, int decimalOffset)
{
	long mag = magnitude(i);
	long c;
	while ( i > 0 )
	{
		c = i/mag;
		s.append(charForDigit[(int) c]);
		decimalOffset--;
		if (decimalOffset == 0)
			s.append('.');
		c *= mag;
		if ( c <= i)
			i -= c;
		mag = mag/10;
	}
	if (i != 0)
		s.append(charForDigit[(int) i]);
	else if (decimalOffset > 0)
	{
		s.append(ZEROS[decimalOffset]);
		decimalOffset = 1;
	}

	decimalOffset--;
	if (decimalOffset == 0)
		s.append(DOT_ZERO);
	else if (decimalOffset == -1)
		s.append('0');
}
/**
 * Initializes the maps in the DisplayHelper with the InternalDisplayHelper's
 * known classes.
 */
private static void initializeMaps()
{
	try
	{
		putInAppendMap(new BooleanAppender(),"java.lang.Boolean");
		putInAppendMap(new ByteAppender(),"java.lang.Byte");
		putInAppendMap(new CharacterAppender(),"java.lang.Character");
		putInAppendMap(new DoubleAppender(),"java.lang.Double");
		putInAppendMap(new FloatAppender(),"java.lang.Float");
		putInAppendMap(new IntegerAppender(),"java.lang.Integer");
		putInAppendMap(new LongAppender(),"java.lang.Long");
		putInAppendMap(new ShortAppender(),"java.lang.Short");
		putInAppendMap(new StringAppender(),"java.lang.String");
		putInAppendMap(new VectorAppender(),"java.util.Vector");
		putInAppendMap(new VectorAppender(),"java.util.Stack");
		char[] c = new char[0];
		putInAppendMap(new CharArrayAppender(),c.getClass());
		putInAppendMap(new ObjectAppender(),"java.lang.Object");
	}
	catch(ClassNotFoundException e){}
}
private static int magnitude(double d)
{
	return magnitude(d,Double.doubleToLongBits(d));
}
private static int magnitude(double d, long doubleToLongBits)
{
	int magnitude = 
		(int) ((((doubleToLongBits & doubleExpMask) >> doubleExpShift) - doubleExpBias) * 0.301029995663981);

	if (magnitude < -323)
		magnitude = -323;
	else if (magnitude > 308)
		magnitude = 308;

	if (d >= d_magnitudes[magnitude+323])
	{
		while(magnitude < 309 && d >= d_magnitudes[magnitude+323])
			magnitude++;
		magnitude--;
		return magnitude;
	}
	else
	{
		while(magnitude > -324 && d < d_magnitudes[magnitude+323])
			magnitude--;
		return magnitude;
	}
}
private static int magnitude(float d)
{
	return magnitude(d,Float.floatToIntBits(d));
}
private static int magnitude(float d, int floatToIntBits)
{
	int magnitude = 
		(int) ((((floatToIntBits & floatExpMask) >> floatExpShift) - floatExpBias) * 0.301029995663981);

	if (magnitude < -44)
		magnitude = -44;
	else if (magnitude > 38)
		magnitude = 38;

	if (d >= f_magnitudes[magnitude+44])
	{
		while(magnitude < 39 && d >= f_magnitudes[magnitude+44])
			magnitude++;
		magnitude--;
		return magnitude;
	}
	else
	{
		while(magnitude > -45 && d < f_magnitudes[magnitude+44])
			magnitude--;
		return magnitude;
	}
}
/**
 * Assumes i is positive. Returns the magnitude of i in base 10.
 */
private static long magnitude(long i)
{
	if (i < 10L) return 1;
	else if (i < 100L) return 10L;
	else if (i < 1000L) return 100L;
	else if (i < 10000L) return 1000L;
	else if (i < 100000L) return 10000L;
	else if (i < 1000000L) return 100000L;
	else if (i < 10000000L) return 1000000L;
	else if (i < 100000000L) return 10000000L;
	else if (i < 1000000000L) return 100000000L;
	else if (i < 10000000000L) return 1000000000L;
	else if (i < 100000000000L) return 10000000000L;
	else if (i < 1000000000000L) return 100000000000L;
	else if (i < 10000000000000L) return 1000000000000L;
	else if (i < 100000000000000L) return 10000000000000L;
	else if (i < 1000000000000000L) return 100000000000000L;
	else if (i < 10000000000000000L) return 1000000000000000L;
	else if (i < 100000000000000000L) return 10000000000000000L;
	else if (i < 1000000000000000000L) return 100000000000000000L;
	else return  1000000000000000000L;
}
/**
 * Assumes i is positive. Returns the magnitude of i in base 16.
 */
private static long magnitude16(long i)
{
	if (i < 16L) return 1;
	else if (i < 256L) return 16L;
	else if (i < 4096L) return 256L;
	else if (i < 65536L) return 4096L;
	else if (i < 1048576L) return 65536L;
	else if (i < 16777216L) return 1048576L;
	else if (i < 268435456L) return 16777216L;
	else if (i < 4294967296L) return 268435456L;
	else if (i < 68719476736L) return 4294967296L;
	else if (i < 1099511627776L) return 68719476736L;
	else if (i < 17592186044416L) return 1099511627776L;
	else if (i < 281474976710656L) return 17592186044416L;
	else if (i < 4503599627370496L) return 281474976710656L;
	else if (i < 72057594037927936L) return 4503599627370496L;
	else if (i < 1152921504606846976L) return 72057594037927936L;
	else return 1152921504606846976L;
}
/**
 * Test cases. Worth running as
 * <pre>
 * java -verbosegc -ms4000000 jacks.basics.Appender
 * </pre>
 * to see the effects of object creation vs. optimized conversions.
 * <p>
 * If run this way, note that a garbage collection is run immediately before and
 * after each test, so you see exactly which tests create how many objects. Garbage
 * collections run during a test are due to the test itself creating so many objects
 * that the vm has to reclaim space. Because each test starts with the default
 * empty string buffer, each test will have a large amount of memory to be garbage
 * collected from just a few objects - these are the char arrays inside the StringBuffers
 * being copied over as they expand. What is interesting to note is the difference
 * in objects and space reclaimed between the Appender test and the StringBuffer
 * test.
 * @param args java.lang.String[]
 */
public static void main(String args[])
{
  if (args.length > 0)
  {
    maintest(args);
    maintest(args);
  }
  else
    maintest(args);
}

public static void maintest(String args[])
{
		long time1, time2;
		boolean[] bools = {true,false,true,false,true,true,false,true,false,false};
		double[] ds = {Double.MAX_VALUE, -3.14e-200D, Double.NEGATIVE_INFINITY, 100,
			567.89023D, 123e199D, -0.000456D, -1.234D, 1e55D, 99999};
		float[] fs = {-3.14F, Float.POSITIVE_INFINITY, 99999, 100,
			567.89023F, 123e33F, -0.000456F, -1.23456789e-2F, 1e-12F, Float.MIN_VALUE};
		long[] ls = {2283911683699007717L, -8007630872066909262L, 4536503365853551745L,
			 548519563869L, 45L, Long.MAX_VALUE, 1L, -9999L, 7661314123L, 0L};
		int[] is = {1147173962, 828789888, -337681747, 940436254, -20385232,
			83, -1154302556, 1975989662, -515020324, Integer.MIN_VALUE};
		char[] cs = {'a', '*', 12345, 9999, Character.MAX_VALUE};
		short[] ss = {Short.MIN_VALUE, (short) 34567, (short) 23, (short) -5555, (short) 256};
		byte[] bs = {Byte.MIN_VALUE, (byte) 99, (byte) 23, (byte) -100, (byte) -11};
		Object[] os = {new Object(), new Object(), new Object()};

		int repeat = 1000;

		main_adj(repeat*100,"booleans",bools,
			"true, false, true, false, true, true, false, true, false, false");
		main_adj(repeat*5,"floats",fs,
			"-3.14F, Float.POSITIVE_INFINITY, 567.89023F, 123e33F, -0.000456F, -1.23456789e-2F, 1e-12F, Float.MIN_VALUE");
		main_adj(repeat*5,"doubles",ds,
			"Double.MAX_VALUE, -3.14e-200D, Double.NEGATIVE_INFINITY,	567.89023D, 123e199D, -0.000456D, -1.234D, 1e55D");
		main_adj(repeat*5,"longs",ls,
			"2283911683699007717L, -8007630872066909262L, 4536503365853551745L, 548519563869L, 45L, Long.MAX_VALUE, 1L, -9999L, 7661314123L, 0L");
		main_adj(repeat*50,"ints",is,
			"1147173962, 828789888, -337681747, 940436254, -20385232, 83, -1154302556, 1975989662, -515020324, Integer.MIN_VALUE");
		main_adj(repeat*500,"chars",cs,
			"'a', '*', 12345, 9999, Character.MAX_VALUE");
		main_adj(repeat*50,"shorts",ss,
			"Short.MIN_VALUE, 34567, 23, -5555, 256");
		main_adj(repeat*50,"bytes",bs,
			"Byte.MIN_VALUE, 99, 23, -100, 245");
		main_adj(repeat*20,"Objects",os,
			"new Object(), new Object(), new Object()");
}
private static void main_adj(int repeat,String name,byte[] arr, String list)
{
	long time1, time2;
	StringBuffer s;
	AppenderHelper a = SINGLETON;

	System.out.println("The " + name);
	System.out.println("    " + list);
	System.out.println("are appended to a StringBuffer one by one " + repeat + " times.");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("Starting test");
	time1 = System.currentTimeMillis();
	for (int i = repeat; i > 0; i--)
		for (int j = arr.length-1; j >= 0; j--)
			a.append(s,arr[j]);
	time1 = System.currentTimeMillis() - time1;
	System.out.println("  The Appender     took " + time1 + " milliseconds");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("Starting test");
	time2 = System.currentTimeMillis();
	for (int i = repeat; i > 0; i--)
		for (int j = arr.length-1; j >= 0; j--)
			s.append(arr[j]);
	time2 = System.currentTimeMillis() - time2;
	System.out.println("  The StringBuffer took " + time2 + " milliseconds");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("    For checking purposes, the StringBuffer & Appender output of one iteration is (respectively):");
	for (int j = 0; j < arr.length; j++)
		s.append(arr[j]).append(", ");
	System.out.println("    " + s);
	s = new StringBuffer();
	for (int j = 0; j < arr.length; j++)
		a.append(s,arr[j]).append(s,", ");
	System.out.println("    " + s);
	System.out.println();
}
private static void main_adj(int repeat,String name,char[] arr, String list)
{
	long time1, time2;
	StringBuffer s;
	AppenderHelper a = SINGLETON;

	System.out.println("The " + name);
	System.out.println("    " + list);
	System.out.println("are appended to a StringBuffer one by one " + repeat + " times.");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("Starting test");
	time1 = System.currentTimeMillis();
	for (int i = repeat; i > 0; i--)
		for (int j = arr.length-1; j >= 0; j--)
			a.append(s,arr[j]);
	time1 = System.currentTimeMillis() - time1;
	System.out.println("  The Appender     took " + time1 + " milliseconds");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("Starting test");
	time2 = System.currentTimeMillis();
	for (int i = repeat; i > 0; i--)
		for (int j = arr.length-1; j >= 0; j--)
			s.append(arr[j]);
	time2 = System.currentTimeMillis() - time2;
	System.out.println("  The StringBuffer took " + time2 + " milliseconds");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("    For checking purposes, the StringBuffer & Appender output of one iteration is (respectively):");
	for (int j = 0; j < arr.length; j++)
		s.append(arr[j]).append(", ");
	System.out.println("    " + s);
	s = new StringBuffer();
	for (int j = 0; j < arr.length; j++)
		a.append(s,arr[j]).append(s,", ");
	System.out.println("    " + s);
	System.out.println();
}
private static void main_adj(int repeat,String name,double[] arr, String list)
{
	long time1, time2;
	StringBuffer s;
	AppenderHelper a = SINGLETON;

	System.out.println("The " + name);
	System.out.println("    " + list);
	System.out.println("are appended to a StringBuffer one by one " + repeat + " times.");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("Starting test");
	time1 = System.currentTimeMillis();
	for (int i = repeat; i > 0; i--)
		for (int j = arr.length-1; j >= 0; j--)
			a.append(s,arr[j]);
	time1 = System.currentTimeMillis() - time1;
	System.out.println("  The Appender     took " + time1 + " milliseconds");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("Starting test");
	time2 = System.currentTimeMillis();
	for (int i = repeat; i > 0; i--)
		for (int j = arr.length-1; j >= 0; j--)
			s.append(arr[j]);
	time2 = System.currentTimeMillis() - time2;
	System.out.println("  The StringBuffer took " + time2 + " milliseconds");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("    For checking purposes, the StringBuffer & Appender output of one iteration is (respectively):");
	for (int j = 0; j < arr.length; j++)
		s.append(arr[j]).append(", ");
	System.out.println("    " + s);
	s = new StringBuffer();
	for (int j = 0; j < arr.length; j++)
		a.append(s,arr[j]).append(s,", ");
	System.out.println("    " + s);
	System.out.println();
}
private static void main_adj(int repeat,String name,float[] arr, String list)
{
	long time1, time2;
	StringBuffer s;
	AppenderHelper a = SINGLETON;

	System.out.println("The " + name);
	System.out.println("    " + list);
	System.out.println("are appended to a StringBuffer one by one " + repeat + " times.");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("Starting test");
	time1 = System.currentTimeMillis();
	for (int i = repeat; i > 0; i--)
		for (int j = arr.length-1; j >= 0; j--)
			a.append(s,arr[j]);
	time1 = System.currentTimeMillis() - time1;
	System.out.println("  The Appender     took " + time1 + " milliseconds");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("Starting test");
	time2 = System.currentTimeMillis();
	for (int i = repeat; i > 0; i--)
		for (int j = arr.length-1; j >= 0; j--)
			s.append(arr[j]);
	time2 = System.currentTimeMillis() - time2;
	System.out.println("  The StringBuffer took " + time2 + " milliseconds");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("    For checking purposes, the StringBuffer & Appender output of one iteration is (respectively):");
	for (int j = 0; j < arr.length; j++)
		s.append(arr[j]).append(", ");
	System.out.println("    " + s);
	s = new StringBuffer();
	for (int j = 0; j < arr.length; j++)
		a.append(s,arr[j]).append(s,", ");
	System.out.println("    " + s);
	System.out.println();
}
private static void main_adj(int repeat,String name,int[] arr, String list)
{
	long time1, time2;
	StringBuffer s;
	AppenderHelper a = SINGLETON;

	System.out.println("The " + name);
	System.out.println("    " + list);
	System.out.println("are appended to a StringBuffer one by one " + repeat + " times.");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("Starting test");
	time1 = System.currentTimeMillis();
	for (int i = repeat; i > 0; i--)
		for (int j = arr.length-1; j >= 0; j--)
			a.append(s,arr[j]);
	time1 = System.currentTimeMillis() - time1;
	System.out.println("  The Appender     took " + time1 + " milliseconds");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("Starting test");
	time2 = System.currentTimeMillis();
	for (int i = repeat; i > 0; i--)
		for (int j = arr.length-1; j >= 0; j--)
			s.append(arr[j]);
	time2 = System.currentTimeMillis() - time2;
	System.out.println("  The StringBuffer took " + time2 + " milliseconds");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("    For checking purposes, the StringBuffer & Appender output of one iteration is (respectively):");
	for (int j = 0; j < arr.length; j++)
		s.append(arr[j]).append(", ");
	System.out.println("    " + s);
	s = new StringBuffer();
	for (int j = 0; j < arr.length; j++)
		a.append(s,arr[j]).append(s,", ");
	System.out.println("    " + s);
	System.out.println();
}
private static void main_adj(int repeat,String name,long[] arr, String list)
{
	long time1, time2;
	StringBuffer s;
	AppenderHelper a = SINGLETON;

	System.out.println("The " + name);
	System.out.println("    " + list);
	System.out.println("are appended to a StringBuffer one by one " + repeat + " times.");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("Starting test");
	time1 = System.currentTimeMillis();
	for (int i = repeat; i > 0; i--)
		for (int j = arr.length-1; j >= 0; j--)
			a.append(s,arr[j]);
	time1 = System.currentTimeMillis() - time1;
	System.out.println("  The Appender     took " + time1 + " milliseconds");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("Starting test");
	time2 = System.currentTimeMillis();
	for (int i = repeat; i > 0; i--)
		for (int j = arr.length-1; j >= 0; j--)
			s.append(arr[j]);
	time2 = System.currentTimeMillis() - time2;
	System.out.println("  The StringBuffer took " + time2 + " milliseconds");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("    For checking purposes, the StringBuffer & Appender output of one iteration is (respectively):");
	for (int j = 0; j < arr.length; j++)
		s.append(arr[j]).append(", ");
	System.out.println("    " + s);
	s = new StringBuffer();
	for (int j = 0; j < arr.length; j++)
		a.append(s,arr[j]).append(s,", ");
	System.out.println("    " + s);
	System.out.println();
}
private static void main_adj(int repeat,String name,Object[] arr, String list)
{
	long time1, time2;
	StringBuffer s;
	AppenderHelper a = SINGLETON;

	System.out.println("The " + name);
	System.out.println("    " + list);
	System.out.println("are appended to a StringBuffer one by one " + repeat + " times.");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("Starting test");
	time1 = System.currentTimeMillis();
	for (int i = repeat; i > 0; i--)
		for (int j = arr.length-1; j >= 0; j--)
			a.append(s,arr[j]);
	time1 = System.currentTimeMillis() - time1;
	System.out.println("  The Appender     took " + time1 + " milliseconds");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("Starting test");
	time2 = System.currentTimeMillis();
	for (int i = repeat; i > 0; i--)
		for (int j = arr.length-1; j >= 0; j--)
			s.append(arr[j]);
	time2 = System.currentTimeMillis() - time2;
	System.out.println("  The StringBuffer took " + time2 + " milliseconds");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("    For checking purposes, the StringBuffer & Appender output of one iteration is (respectively):");
	for (int j = 0; j < arr.length; j++)
		s.append(arr[j]).append(", ");
	System.out.println("    " + s);
	s = new StringBuffer();
	for (int j = 0; j < arr.length; j++)
		a.append(s,arr[j]).append(s,", ");
	System.out.println("    " + s);
	System.out.println();
}
private static void main_adj(int repeat,String name,short[] arr, String list)
{
	long time1, time2;
	StringBuffer s;
	AppenderHelper a = SINGLETON;

	System.out.println("The " + name);
	System.out.println("    " + list);
	System.out.println("are appended to a StringBuffer one by one " + repeat + " times.");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("Starting test");
	time1 = System.currentTimeMillis();
	for (int i = repeat; i > 0; i--)
		for (int j = arr.length-1; j >= 0; j--)
			a.append(s,arr[j]);
	time1 = System.currentTimeMillis() - time1;
	System.out.println("  The Appender     took " + time1 + " milliseconds");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("Starting test");
	time2 = System.currentTimeMillis();
	for (int i = repeat; i > 0; i--)
		for (int j = arr.length-1; j >= 0; j--)
			s.append(arr[j]);
	time2 = System.currentTimeMillis() - time2;
	System.out.println("  The StringBuffer took " + time2 + " milliseconds");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("    For checking purposes, the StringBuffer & Appender output of one iteration is (respectively):");
	for (int j = 0; j < arr.length; j++)
		s.append(arr[j]).append(", ");
	System.out.println("    " + s);
	s = new StringBuffer();
	for (int j = 0; j < arr.length; j++)
		a.append(s,arr[j]).append(s,", ");
	System.out.println("    " + s);
	System.out.println();
}
private static void main_adj(int repeat,String name,boolean[] arr, String list)
{
	long time1, time2;
	StringBuffer s;
	AppenderHelper a = SINGLETON;

	System.out.println("The " + name);
	System.out.println("    " + list);
	System.out.println("are appended to a StringBuffer one by one " + repeat + " times.");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("Starting test");
	time1 = System.currentTimeMillis();
	for (int i = repeat; i > 0; i--)
		for (int j = arr.length-1; j >= 0; j--)
			a.append(s,arr[j]);
	time1 = System.currentTimeMillis() - time1;
	System.out.println("  The Appender     took " + time1 + " milliseconds");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("Starting test");
	time2 = System.currentTimeMillis();
	for (int i = repeat; i > 0; i--)
		for (int j = arr.length-1; j >= 0; j--)
			s.append(arr[j]);
	time2 = System.currentTimeMillis() - time2;
	System.out.println("  The StringBuffer took " + time2 + " milliseconds");
	s = new StringBuffer();
	Runtime.getRuntime().gc();
	System.out.println("    For checking purposes, the StringBuffer & Appender output of one iteration is (respectively):");
	for (int j = 0; j < arr.length; j++)
		s.append(arr[j]).append(", ");
	System.out.println("    " + s);
	s = new StringBuffer();
	for (int j = 0; j < arr.length; j++)
		a.append(s,arr[j]).append(s,", ");
	System.out.println("    " + s);
	System.out.println();
}
/**
 * Classes needing to add append support for a particular class must add themselves
 * into the append map.
 * <p>
 * Basically, this means that when an object of class c is passed to the Appender
 * to be appended to the StringBuffer, the AppenderHelper looks up that class in the append
 * map. If there is an AppendConverter object registered for that class, then the task
 * of appending the original object (of class c) to the StringBuffer is delegated
 * to the registered AppendConverter object, by calling it with the method
 * <pre>
 * AppendConverter.appendObj(AppenderHelper a, StringBuffer s, Object o, int depth)
 * </pre>
 * @see appendObj()
 * @param h the AppendConverter to be registered for the given class.
 * @param c the class.
 */
public static void putInAppendMap(AppendConverter h, Class c)
{
	append_map.put(c, h);
}
/**
 * Convenience method so that classes can be registered by class name.
 * @see putInAppendMap(AppenderHelper,Class)
 * @param h the AppendConverter to be registered for the given class.
 * @param c the class.
 */
public static void putInAppendMap(AppendConverter h, String classname)
	throws ClassNotFoundException
{
	append_map.put(Class.forName(classname), h);
}
}