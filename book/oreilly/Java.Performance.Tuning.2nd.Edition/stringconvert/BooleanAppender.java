package tuning.stringconvert;

class BooleanAppender
	implements AppendConverter
{

public void appendObj(AppenderHelper h, StringBuffer s, Object o, int depth)
{
	h.append(s, (Boolean) o);
}
}