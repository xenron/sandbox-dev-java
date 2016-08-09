package tuning.struct;

public class TernarySearchTree3
{

    TernarySearchTreeNode3 root;
    char buff[];

    public static void dummy(){TernarySearchTreeNode3.dummy();}
    public Object get(String s)
    {
        if(root == null)
        {
            return null;
        }
        else
        {
            s.getChars(0, s.length(), buff, 0);
            return root.search(buff, 0, s.length() - 1);
        }
    }

    public Object put(String s, Object obj)
    {
        s.getChars(0, s.length(), buff, 0);
        if(root == null)
            root = TernarySearchTreeNode3.newNode(buff[0]);
        return root.insert(buff, 0, s.length() - 1, obj);
    }

    public void release()
    {
        if(root != null)
        {
            root.clean();
            root = null;
        }
    }

    public TernarySearchTree3()
    {
        buff = new char[5000];
    }
}

class TernarySearchTreeNode3
{

    char splitchar;
    TernarySearchTreeNode3 low;
    TernarySearchTreeNode3 high;
    TernarySearchTreeNode3 equal;
    Object value;
    static TernarySearchTreeNode3 pool;
    static
    {
	TernarySearchTreeNode3 last;
	for (int i = 400000; i > 0; i--)
	{
	  last = pool;
	  pool = new TernarySearchTreeNode3();
	  pool.equal=last;
	}
    }

    public static void dummy(){System.out.println("dummy called");}

    public Object search(char ac[], int i, int j)
    {
        char c;
        for(TernarySearchTreeNode3 ternarysearchtreenode3 = this; ternarysearchtreenode3 != null;)
            if((c = ac[i]) < ternarysearchtreenode3.splitchar)
                ternarysearchtreenode3 = ternarysearchtreenode3.low;
            else
            if(c == ternarysearchtreenode3.splitchar)
            {
                if(i == j)
                    return ternarysearchtreenode3.value;
                i++;
                ternarysearchtreenode3 = ternarysearchtreenode3.equal;
            }
            else
            {
                ternarysearchtreenode3 = ternarysearchtreenode3.high;
            }

        return null;
    }

    public Object insert(char ac[], int i, int j, Object obj)
    {
        TernarySearchTreeNode3 ternarysearchtreenode3 = this;
        do
        {
            char c;
            for(c = ac[i]; c < ternarysearchtreenode3.splitchar; ternarysearchtreenode3 = ternarysearchtreenode3.low)
                if(ternarysearchtreenode3.low == null)
                    ternarysearchtreenode3.low = newNode(c);

            if(c == ternarysearchtreenode3.splitchar)
            {
                if(i == j)
                {
                    Object obj1 = ternarysearchtreenode3.value;
                    ternarysearchtreenode3.value = obj;
                    return obj1;
                }
                i++;
                c = ac[i];
                if(ternarysearchtreenode3.equal == null)
                    ternarysearchtreenode3.equal = newNode(c);
                ternarysearchtreenode3 = ternarysearchtreenode3.equal;
            }
            else
            {
                if(ternarysearchtreenode3.high == null)
                    ternarysearchtreenode3.high = newNode(c);
                ternarysearchtreenode3 = ternarysearchtreenode3.high;
            }
        }
        while(true);
    }

    public static TernarySearchTreeNode3 newNode(char c)
    {
	TernarySearchTreeNode3 ternarysearchtreenode3 = pool;
	pool = pool.equal;
	ternarysearchtreenode3.splitchar = c;
        ternarysearchtreenode3.low = ternarysearchtreenode3.equal = ternarysearchtreenode3.high = null;
        return ternarysearchtreenode3;
    }

    public void clean()
    {
        if(low != null)
        {
            low.clean();
            low = null;
        }
        if(high != null)
        {
            high.clean();
            high = null;
        }
        if(equal != null)
        {
            equal.clean();
            equal = null;
        }
        value = null;
    }
}
