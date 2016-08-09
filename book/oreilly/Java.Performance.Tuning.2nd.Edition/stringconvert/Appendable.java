package tuning.stringconvert;

/**
 * Classes which implement this interface can be appended directly to a StringBuffer
 * without first having to create a string representation.
 * <p>
 * This allows the elimination of intermediate strings when creating a
 * string representation of the object for display purposes. This is not the same
 * as Serializable - this is for human readable display purposes. It is the
 * same as the call to <code>toString()</code>, but appended to StringBuffers
 * without the intermediate String being created.
 * <p>
 * Any class which implements this should probably also override its
 * <code>toString()</code> method to something like
 *<pre>
 * public String toString()
 * {
 * 		StringBuffer s = new StringBuffer();
 *		appendTo(s,2);
 *		return s.toString();
 * }
 *</pre><p>
 * And may also want to use the AppenderHelper class for any internal objects
 * <pre>
 * 	jack.basics.AppenderHelper.SINGLETON.append(s,obj,1);
 * </pre>
 * in the appendTo method. This
 * will cut down on extraneous string production. The rationale is that
 * string production is seriously overdone, and the reduction of unnecessary
 * string creation is more likely to improve performance than the overheads
 * in the above call (especially as the AppenderHelper class is much faster than
 * StringBuffer in appending most data types).
 * @see jack.basics.AppenderHelper
 */
public interface Appendable
{

/**
 * Appends a representation of <code>this</code> onto the string
 * buffer <code>s</code>.
 * <p>
 * The <code>depth</code> parameter specifies the depth of the representation.
 * A value of zero means that the string representation should be that given
 * by the <code>Object.toString()</code> method, i.e. the class name, an "@"
 * character, followed by the hash code of this object (the 
 * <code>AppenderHelper.appendDepth0To()</code> method does this efficiently).
 * <p>
 * A value of 1 corresponds to the object being represented in its standard
 * way, but any embedded objects that are represented are displayed as depth
 * zero objects (for example a collection could be square brackets surrounding
 * comma separated level zero representations of all its elements).
 *
 * @param s the string buffer to append <code>this</code> to.
 * @param depth the depth of the respresentation.
 */
public void appendTo(StringBuffer s, int depth);
}