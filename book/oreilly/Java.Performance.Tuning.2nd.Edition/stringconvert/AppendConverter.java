package tuning.stringconvert;

/**
 * For classes you do not control the source code for, you need to implement
 * an AppendConverter class, and register it with the AppenderHelper if you
 * want to have efficient appending of the string representation of objects
 * in that class. This is most easily demonstrated with an example. The following would
 * be an AppendConverter implementation for the java.util.Vector (not actually
 * needed as this is already handled by the AppenderHelper).
 * <pre>
 * import java.util.Vector;
 * import jack.basics.AppenderHelper;
 * 
 * public class VectorAppender implements AppendConverter
 * {
 *   private static final char[] COMMA_SPACE = {',',' '};
 *   static {AppenderHelper.putInAppendMap(new VectorAppender(),"java.util.Vector");}
 *   public void appendObj(AppenderHelper h, StringBuffer s, Object o, int depth)
 *   {
 * 			if (depth <= 0)
 *				AppenderHelper.appendDepth0To(s,o);
 *			else
 *			{
 *				depth--;
 *				int size = o.size();
 *				s.append('[');
 *				if (size != 0)
 *				{
 *					h.append(s, o.elementAt(0), depth);
 *					for (int i = 1; i < size; i++)
 *					{
 *						s.append(COMMA_SPACE);
 *						h.append(s, o.elementAt(i), depth);
 *					}
 *				}
 *				s.append(']');
 * 			}
 *		}
 * }
 * </pre>
 * Note that unfortunately the AppenderHelper relies on the class of objects
 * passed to determine the converter object to use, and this does not carry
 * over to subclasses of that class if the object is passed in as type Object.
 * Objects of classes that are not registered
 * have their append call defaulted to the default StringBuffer append, so the
 * string representation will always be correct, but not necessarily the most
 * efficient append. For example, if there is a subclass of java.util.Vector
 * that you want to use the above example for, you should register that separately.
 */
public interface AppendConverter
{

/**
 * This method was created by a SmartGuide.
 * @param h jack.basics.Appender
 * @param s java.lang.StringBuffer
 * @param o java.lang.Object
 * @param depth int
 */
public void appendObj(AppenderHelper h, StringBuffer s, Object o, int depth);
}