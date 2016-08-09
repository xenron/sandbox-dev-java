package tuning.stringconvert;

class CharArrayAppender
	implements AppendConverter
{

public void appendObj(AppenderHelper h, StringBuffer s, Object o, int depth)
{
	h.append(s, (char[]) o);
}
}