package tuning.stringconvert;

class ByteAppender
	implements AppendConverter
{

public void appendObj(AppenderHelper h, StringBuffer s, Object o, int depth)
{
	h.append(s, (Byte) o);
}
}