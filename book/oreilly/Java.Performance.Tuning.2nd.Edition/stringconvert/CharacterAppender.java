package tuning.stringconvert;

class CharacterAppender
	implements AppendConverter
{

public void appendObj(AppenderHelper h, StringBuffer s, Object o, int depth)
{
	h.append(s, (Character) o);
}
}