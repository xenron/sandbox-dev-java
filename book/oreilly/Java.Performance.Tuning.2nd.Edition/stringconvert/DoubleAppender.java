package tuning.stringconvert;

class DoubleAppender
	implements AppendConverter
{

public void appendObj(AppenderHelper h, StringBuffer s, Object o, int depth)
{
	h.append(s, (Double) o);
}
}