package tuning.struct;

/*
 * Straightforward implementation from article
 */

public class TernarySearchTree0
{
  TernarySearchTreeNode0 root;

  public Object get(String key)
  {
    return TernarySearchTreeNode0.search(root, key, 0);
  }

  public Object put(String key, Object value)
  {
    root = TernarySearchTreeNode0.insert(root, key, 0, value);
    return null; //fake it for now
  }

  public void release() {if (root != null) {root.clean(); root = null;}}

}

class TernarySearchTreeNode0
{
  char splitchar;
  TernarySearchTreeNode0 low;
  TernarySearchTreeNode0 high;
  TernarySearchTreeNode0 equal;
  Object value;

  public static Object search(TernarySearchTreeNode0 p, String str, int strIdx)
  {
    char c;
    if (p == null)
      return null;
    else if ( (c=str.charAt(strIdx)) < p.splitchar)
      return search(p.low, str, strIdx);
    else if (c > p.splitchar)
      return search(p.high, str, strIdx);
    else
    {
      if (strIdx == (str.length()-1))
	return p.value;
      else
	return search(p.equal, str, strIdx+1);
    }
  }

  public static TernarySearchTreeNode0 insert(TernarySearchTreeNode0 p, String str, int strIdx, Object o)
  {
    char c;
    if (p == null)
    {
      p = new TernarySearchTreeNode0(str.charAt(strIdx));
    }
    if ( (c = str.charAt(strIdx)) < p.splitchar)
      p.low = insert(p.low, str, strIdx, o);
    else if (c == p.splitchar)
    {
      if (strIdx == (str.length()-1))
	p.value = o;
      else
	p.equal = insert(p.equal, str, strIdx+1, o);
    }
    else
      p.high = insert(p.high , str, strIdx, o);
    return p;
  }

  public TernarySearchTreeNode0(char c)
  {
    splitchar = c;
  }

  public void clean()
  {
    if (low != null) {low.clean(); low = null;}
    if (high != null) {high.clean(); high = null;}
    if (equal != null) {equal.clean(); equal = null;}
    value = null;
  }
}
