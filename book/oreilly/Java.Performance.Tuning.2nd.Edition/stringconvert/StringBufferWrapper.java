package tuning.stringconvert;

import java.util.Vector;

/**
 * Class to replace StringBuffer for optimized appends.
 * <p>
 * StringBufferWrapper can be used in a very similar way to StringBuffer, e.g.
 * <pre>
 * StringBufferWrapper s = new StringBufferWrapper();
 * s.append(567).append(" is ").append(33.5).append('%');
 * </pre>
 * You can access the underlying StringBuffer directly as the instance
 * variable s is public.
 * @see AppenderHelper
 */
public class StringBufferWrapper
{
	private static final AppenderHelper HELPER = AppenderHelper.SINGLETON;
	/**
	 * Instance variable holding the underlying StringBuffer.
	 */
	public StringBuffer s;

/**
 * Empty argument constructor creates a new StringBuffer for the internal
 * <code>s</code> instance variable.
 */
public StringBufferWrapper()
{
	s = new StringBuffer();
}
/**
 * One argument constructor sets the internal
 * <code>s</code> instance variable to the StringBuffer.
 * @param buf the StringBuffer.
 */
public StringBufferWrapper(StringBuffer buf)
{
	s = buf;
}
/**
 * Appends the string representation of the
 * char array argument to the string buffer.
 * @param c the characters to be appended.
 * @return this StringBufferWrapper
 */
public StringBufferWrapper append(char[] c)
{
	HELPER.append(s,c);
	return this;
}
/**
 * Appends the string representation of a subarray of the
 * char array argument to the string buffer.
 * @param c the characters to be appended.
 * @param   offset   the index of the first character to append.
 * @param   len      the number of characters to append.
 * @return this StringBufferWrapper
 */
public StringBufferWrapper append(char[] c, int offset, int len)
{
	HELPER.append(s,c,offset,len);
	return this;
}
/**
 * Appends the character to the string buffer.
 * @param c the character to be appended.
 * @return this StringBufferWrapper
 * @see StringBuffer#append(char)
 */
public StringBufferWrapper append(char c)
{
	HELPER.append(s,c);
	return this;
}
/**
 * Appends the string representation of the
 * double argument to the string buffer.
 * @param d the double to be appended.
 * @return this StringBufferWrapper
 * @see StringBuffer#append(double)
 */
public StringBufferWrapper append(double d)
{
	HELPER.append(s,d);
	return this;
}
/**
 * Appends the string representation of the
 * float argument to the string buffer.
 * @param d the float to be appended.
 * @return this StringBufferWrapper
 * @see StringBuffer#append(float)
 */
public StringBufferWrapper append(float d)
{
	HELPER.append(s,d);
	return this;
}
/**
 * Appends the string representation of the
 * long argument to the string buffer.
 * @param i the long to be appended.
 * @return this StringBufferWrapper
 * @see StringBuffer#append(long)
 */
public StringBufferWrapper append(long i)
{
	HELPER.append(s,i);
	return this;
}
/**
 * Appends the string representation of the
 * Appendable argument to the string buffer. Does so by calling the
 * <code>appendTo</code> method of the Appendable.
 * @param o the Appendable to be appended.
 * @return this StringBufferWrapper
 * @see Appendable
 */
public StringBufferWrapper append(Appendable o)
{
	HELPER.append(s,o);
	return this;
}
/**
 * Appends the string representation of the
 * Appendable argument to the string buffer. Does so by calling the
 * <code>appendTo</code> method of the Appendable.
 * @param o the Appendable to be appended.
 * @param depth the depth with which to display the Appendable.
 * @return this StringBufferWrapper
 * @see Appendable
 */
public StringBufferWrapper append(Appendable o, int depth)
{
	HELPER.append(s,o);
	return this;
}
/**
 * Appends the string representation of the
 * Boolean argument to the string buffer.
 * @param o the Boolean to be appended.
 * @return this StringBufferWrapper
 */
public StringBufferWrapper append(Boolean o)
{
	HELPER.append(s,o);
	return this;
}
/**
 * Appends the string representation of the
 * Byte argument to the string buffer.
 * @param o the Byte to be appended.
 * @return this StringBufferWrapper
 */
public StringBufferWrapper append(Byte o)
{
	HELPER.append(s,o);
	return this;
}
/**
 * Appends the string representation of the
 * Character argument to the string buffer.
 * @param o the Character to be appended.
 * @return this StringBufferWrapper
 */
public StringBufferWrapper append(Character o)
{
	HELPER.append(s,o);
	return this;
}
/**
 * Appends the string representation of the
 * Double argument to the string buffer.
 * @param o the Double to be appended.
 * @return this StringBufferWrapper
 */
public StringBufferWrapper append(Double o)
{
	HELPER.append(s,o);
	return this;
}
/**
 * Appends the string representation of the
 * Float argument to the string buffer.
 * @param o the Float to be appended.
 * @return this StringBufferWrapper
 */
public StringBufferWrapper append(Float o)
{
	HELPER.append(s,o);
	return this;
}
/**
 * Appends the string representation of the
 * Integer argument to the string buffer.
 * @param o the Integer to be appended.
 * @return this StringBufferWrapper
 */
public StringBufferWrapper append(Integer o)
{
	HELPER.append(s,o);
	return this;
}
/**
 * Appends the string representation of the
 * Long argument to the string buffer.
 * @param o the Long to be appended.
 * @return this StringBufferWrapper
 */
public StringBufferWrapper append(Long o)
{
	HELPER.append(s,o);
	return this;
}
/**
 * Appends the string representation of the
 * Object argument to the string buffer. If o is an Appendable, this will
 * delegate the append to the <code>appendTo</code> method.
 * If o has a registered append mapping, then this will delegate the append
 * to the registered AppendConverter object.
 * @param o the Object to be appended.
 * @return this StringBufferWrapper
 * @see Appendable
 * @see AppendConverter
 */
public StringBufferWrapper append(Object o)
{
	HELPER.append(s,o);
	return this;
}
/**
 * Appends the string representation of the
 * Object argument to the string buffer. If o is an Appendable, this will
 * delegate the append to the <code>appendTo</code> method.
 * If o has a registered append mapping, then this will delegate the append
 * to the registered AppendConverter object.
 * @param o the Object to be appended.
 * @param depth the depth with which to display the object.
 * @return this StringBufferWrapper
 * @see Appendable
 * @see AppendConverter
 */
public StringBufferWrapper append(Object o, int depth)
{
	HELPER.append(s,o);
	return this;
}
/**
 * Appends the string representation of the
 * Short argument to the string buffer.
 * @param o the Short to be appended.
 * @return this StringBufferWrapper
 */
public StringBufferWrapper append(Short o)
{
	HELPER.append(s,o);
	return this;
}
/**
 * Appends the string representation of the
 * String argument to the string buffer.
 * @param o the String to be appended.
 * @return this StringBufferWrapper
 */
public StringBufferWrapper append(String o)
{
	HELPER.append(s,o);
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
 * @param o the Vector who's display is to be appended.
 */
public StringBufferWrapper append(Vector o)
{
	HELPER.append(s,o);
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
 * @param o the Vector who's display is to be appended.
 * @param depth depth of display for the Vector.
 */
public StringBufferWrapper append(Vector o, int depth)
{
	HELPER.append(s,o);
	return this;
}
/**
 * Appends the string representation of the
 * boolean argument to the string buffer.
 * @param o the boolean to be appended.
 * @return this StringBufferWrapper
 */
public StringBufferWrapper append(boolean b)
{
	HELPER.append(s,b);
	return this;
}
}