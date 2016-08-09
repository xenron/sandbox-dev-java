package tuning.struct;

/*
 * Straightforward implementation from article
 */

public class TernarySearchTree1
{
  TernarySearchTreeNode1 root;
  char[] buff = new char[5000];

  public Object get(String key)
  {
    key.getChars(0, key.length(), buff, 0);
    return TernarySearchTreeNode1.search(root, buff, 0, key.length()-1);
  }

  public Object put(String key, Object value)
  {
    key.getChars(0, key.length(), buff, 0);
    root = TernarySearchTreeNode1.insert(root, buff, 0, key.length()-1, value);
    return null; //fake it for now
  }

  public void release() {if (root != null) {root.clean(); root = null;}}

}

class TernarySearchTreeNode1
{
  char splitchar;
  TernarySearchTreeNode1 low;
  TernarySearchTreeNode1 high;
  TernarySearchTreeNode1 equal;
  Object value;

  public static Object search(TernarySearchTreeNode1 p, char[] str, int strIdx, int strMaxIdx)
  {
    char c;
    if (p == null)
      return null;
    else if ( (c=str[strIdx]) < p.splitchar)
      return search(p.low, str, strIdx, strMaxIdx);
    else if (c > p.splitchar)
      return search(p.high, str, strIdx, strMaxIdx);
    else
    {
      if (strIdx == strMaxIdx)
	return p.value;
      else
	return search(p.equal, str, strIdx+1, strMaxIdx);
    }
  }

  public static TernarySearchTreeNode1 insert(TernarySearchTreeNode1 p, char[] str, int strIdx, int strMaxIdx, Object o)
  {
    char c;
    if (p == null)
    {
      p = newNode(str[strIdx]);
    }
    if ( (c = str[strIdx]) < p.splitchar)
      p.low = insert(p.low, str, strIdx, strMaxIdx, o);
    else if (c == p.splitchar)
    {
      if (strIdx == strMaxIdx)
	p.value = o;
      else
	p.equal = insert(p.equal, str, strIdx+1, strMaxIdx, o);
    }
    else
      p.high = insert(p.high , str, strIdx, strMaxIdx, o);
    return p;
  }

  public static TernarySearchTreeNode1 newNode(char c)
  {
    TernarySearchTreeNode1 p = new TernarySearchTreeNode1();
    p.splitchar = c;
    p.low = p.equal = p.high = null;
    return p;
  }

  public void clean()
  {
    if (low != null) {low.clean(); low = null;}
    if (high != null) {high.clean(); high = null;}
    if (equal != null) {equal.clean(); equal = null;}
    value = null;
  }
}
