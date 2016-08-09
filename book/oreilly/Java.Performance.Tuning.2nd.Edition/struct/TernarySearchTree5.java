package tuning.struct;

public class TernarySearchTree5
{
  final static int LOW_OFFSET = 1;
  final static int HIGH_OFFSET = 2;
  final static int EQUAL_OFFSET = 3;
  final static int VALUE_OFFSET = 4;
  final static int NODE_SIZE = 5;
  final static int INITIAL_TRIE_NODE = 1 + NODE_SIZE;
  final static int INITIAL_NODE = 1;

  char[] buff = new char[5000];
  int[] nodes;
  Object[] objects;
  int nextNode = INITIAL_TRIE_NODE;
  int nextObject = 0;
  int initial = -1;
  Object[] trie1Objects;
  int[][] trie2;
  Object[][] trie2Objects;

  public TernarySearchTree5()
  {
    this(500000);
  }

  public TernarySearchTree5(int size)
  {
    trie1Objects = new Object[256];
    trie2 = new int[256][256];
    trie2Objects = new Object[256][256];
    nodes = new int[NODE_SIZE*size+1];
    objects = new Object[size];
  }

  public Object get(String key)
  {
    int len = key.length();
    key.getChars(0, len, buff, 0);
    int first = buff[0];
    int second = buff[1];
    if (len == 1 && (first < 256))
    {
      return trie1Objects[first];
    }
    else if (len == 2 && (first < 256) && (second < 256))
    {
      return trie2Objects[first][second];
    }
    else if ((first < 256) && (second < 256))
    {
      int nodep = trie2[first][second];
      if (nodep == 0)
      {
        return null;
      }
      return search(buff, 2, len-1, nodep);
    }
    else
    {
      //Use node[0] as a flag to determine if enetered here
      if (nodes[0] == 0)
      {
        return null;
      }
      return search(buff, 0, len-1, INITIAL_NODE);
    }
  }

  public void release()
  {
    nodes = null;
    objects = null;
  }

  public Object search(char[] str, int strIdx, int strMaxIdx, int p)
  {
//    int p = INITIAL_NODE;
    int c;
    while (p != 0)
    {
      if ( (c = str[strIdx]) < nodes[p])
        p = nodes[p+LOW_OFFSET];
      else if (c == nodes[p])
      {
        if (strIdx == strMaxIdx)
	  return objects[nodes[p+VALUE_OFFSET]];
        else
        {
          strIdx++;
	  p = nodes[p+EQUAL_OFFSET];
        }
      }
      else
	p = nodes[p+HIGH_OFFSET];
    }
    return null;
  }

  public Object put(String key, Object value)
  {
    int len = key.length();
    key.getChars(0, len, buff, 0);
    int first = buff[0];
    int second = buff[1];
    if (len == 1 && (first < 256))
    {
      Object old = trie1Objects[first];
      trie1Objects[first] = value;
      return old;
    }
    else if (len == 2 && (first < 256) && (second < 256))
    {
      Object old = trie2Objects[first][second];
      trie2Objects[first][second] = value;
      return old;
    }
    else if ((first < 256) && (second < 256))
    {
      int nodep = trie2[first][second];
      if (nodep == 0)
      {
        nodep = trie2[first][second] = nextNode;
        nodes[nextNode] = buff[2];
        nextNode+=NODE_SIZE;
      }
      return insert(buff, 2, len-1, value, nodep);
    }
    else
    {
      //Use node[0] as a flag to determine if enetered here
      if (nodes[0] == 0)
      {
        nodes[0] = 1;
        nodes[INITIAL_NODE] = first;
      }
      return insert(buff, 0, len-1, value, INITIAL_NODE);
    }
  }

  public Object insert(char[] str, int strIdx, int strMaxIdx, Object value, int p)
  {
//    int p = INITIAL_NODE;
    int c = str[strIdx];
    int cdiff;
    Object old;
    for(;;)
    {
      if ( (cdiff = c - nodes[p]) < 0)
      {
	if (nodes[p+LOW_OFFSET] == 0)
	{
	  nodes[p+LOW_OFFSET] = nextNode;
	  nodes[nextNode] = c;
	  nextNode+=NODE_SIZE;
	}
        p = nodes[p+LOW_OFFSET];
      }
      else if (cdiff == 0)
      {
	if (strIdx == strMaxIdx)
	{
	  if (nodes[p+VALUE_OFFSET] == 0)
	  {
	    nodes[p+VALUE_OFFSET] = nextObject;
	    nextObject++;
	  }
	  old = objects[nodes[p+VALUE_OFFSET]];
	  objects[nodes[p+VALUE_OFFSET]] = value;
	  return old;
	}
        else
        {
          strIdx++;
	  c=str[strIdx];
	  if (nodes[p+EQUAL_OFFSET] == 0)
	  {
	    nodes[p+EQUAL_OFFSET] = nextNode;
	    nodes[nextNode] = c;
	    nextNode+=NODE_SIZE;
	  }
          p = nodes[p+EQUAL_OFFSET];
        }
      }
      else
      {
	if (nodes[p+HIGH_OFFSET] == 0)
	{
	  nodes[p+HIGH_OFFSET] = nextNode;
	  nodes[nextNode] = c;
	  nextNode+=NODE_SIZE;
	}
        p = nodes[p+HIGH_OFFSET];
      }
    }
  }
}
