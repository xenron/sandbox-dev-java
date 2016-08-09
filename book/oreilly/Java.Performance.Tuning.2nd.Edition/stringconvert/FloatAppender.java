package tuning.stringconvert;

class FloatAppender
	implements AppendConverter
{

public void appendObj(AppenderHelper h, StringBuffer s, Object o, int depth)
{
	h.append(s, (Float) o);
}
}