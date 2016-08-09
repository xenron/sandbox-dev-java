package tuning.stringconvert;

class IntegerAppender
	implements AppendConverter
{

public void appendObj(AppenderHelper h, StringBuffer s, Object o, int depth)
{
	h.append(s, (Integer) o);
}
}