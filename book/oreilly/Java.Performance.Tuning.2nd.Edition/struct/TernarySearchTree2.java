package tuning.struct;

public class TernarySearchTree2
{

    TernarySearchTreeNode2 root;
    char buff[];

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
            root = TernarySearchTreeNode2.newNode(buff[0]);
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

    public TernarySearchTree2()
    {
        buff = new char[5000];
    }
}

class TernarySearchTreeNode2
{

    char splitchar;
    TernarySearchTreeNode2 low;
    TernarySearchTreeNode2 high;
    TernarySearchTreeNode2 equal;
    Object value;

    public Object search(char ac[], int i, int j)
    {
        char c;
        for(TernarySearchTreeNode2 ternarysearchtreenode2 = this; ternarysearchtreenode2 != null;)
            if((c = ac[i]) < ternarysearchtreenode2.splitchar)
                ternarysearchtreenode2 = ternarysearchtreenode2.low;
            else
            if(c == ternarysearchtreenode2.splitchar)
            {
                if(i == j)
                    return ternarysearchtreenode2.value;
                i++;
                ternarysearchtreenode2 = ternarysearchtreenode2.equal;
            }
            else
            {
                ternarysearchtreenode2 = ternarysearchtreenode2.high;
            }

        return null;
    }

    public Object insert(char ac[], int i, int j, Object obj)
    {
        TernarySearchTreeNode2 ternarysearchtreenode2 = this;
        do
        {
            char c;
            for(c = ac[i]; c < ternarysearchtreenode2.splitchar; ternarysearchtreenode2 = ternarysearchtreenode2.low)
                if(ternarysearchtreenode2.low == null)
                    ternarysearchtreenode2.low = newNode(c);

            if(c == ternarysearchtreenode2.splitchar)
            {
                if(i == j)
                {
                    Object obj1 = ternarysearchtreenode2.value;
                    ternarysearchtreenode2.value = obj;
                    return obj1;
                }
                i++;
                c = ac[i];
                if(ternarysearchtreenode2.equal == null)
                    ternarysearchtreenode2.equal = newNode(c);
                ternarysearchtreenode2 = ternarysearchtreenode2.equal;
            }
            else
            {
                if(ternarysearchtreenode2.high == null)
                    ternarysearchtreenode2.high = newNode(c);
                ternarysearchtreenode2 = ternarysearchtreenode2.high;
            }
        }
        while(true);
    }

    public static TernarySearchTreeNode2 newNode(char c)
    {
        TernarySearchTreeNode2 ternarysearchtreenode2 = new TernarySearchTreeNode2();
        ternarysearchtreenode2.splitchar = c;
        ternarysearchtreenode2.low = ternarysearchtreenode2.equal = ternarysearchtreenode2.high = null;
        return ternarysearchtreenode2;
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
