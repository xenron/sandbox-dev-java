package tuning.stringconvert;

import java.util.Vector;

class VectorAppender
	implements AppendConverter
{

public void appendObj(AppenderHelper h, StringBuffer s, Object o, int depth)
{
	h.append(s, (Vector) o, depth);
}
}