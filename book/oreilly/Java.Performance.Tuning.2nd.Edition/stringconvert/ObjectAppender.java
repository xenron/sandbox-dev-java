package tuning.stringconvert;

class ObjectAppender
	implements AppendConverter
{

public void appendObj(AppenderHelper h, StringBuffer s, Object o, int depth)
{
	h.appendDepth0To(s, o);
}
}