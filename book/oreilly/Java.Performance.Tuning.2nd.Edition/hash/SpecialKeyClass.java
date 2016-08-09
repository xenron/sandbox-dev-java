package tuning.hash;

import java.util.Hashtable;
import java.io.FileInputStream;
import tuning.dict.Dict;

public class SpecialKeyClass
{

  public static void main(String[] args)
  {
    maintest(args);
    if (args.length > 0)
      maintest(args);
  }

  public static void maintest(String[] args)
  {
    int REPEAT = 50;
    //Initialize the dictionary
    try{Dict.initialize(true);}catch(Exception e){}
    System.out.println("Started Test");

    //Build the two hashtables. Keep references to the StringWrapper objects
    //for later use as accessors.
    Hashtable h1 = new Hashtable();
    Hashtable h2 = new Hashtable();
    StringWrapper[] dict = new StringWrapper[Dict.DICT.length];
    for (int i = 0; i < Dict.DICT.length; i++)
    {
      h1.put(Dict.DICT[i], Boolean.TRUE);
      h2.put(dict[i] = new StringWrapper(Dict.DICT[i]), Boolean.TRUE);
    }
    System.out.println("Finished building");

    Object[] o = new Object[Dict.DICT.length];

    //Time the access for normal String keys
    long time1 = System.currentTimeMillis();
  for (int j = 0; j < REPEAT; j++)
    for (int i = 0; i < Dict.DICT.length; i++)
      o[i] = h1.get(Dict.DICT[i]);
    time1 = System.currentTimeMillis() - time1;
    System.out.println("Time1 = " + time1);

    //Time the access for StringWrapper keys
    long time2 = System.currentTimeMillis();
  for (int j = 0; j < REPEAT; j++)
    for (int i = 0; i < Dict.DICT.length; i++)
      o[i] = h2.get(dict[i]);
    time2 = System.currentTimeMillis() - time2;
    System.out.println("Time2 = " + time2);

  }
}

final class StringWrapper
{
  private int hash;
  private String string;
  public StringWrapper(String str)
  {
    string = str;
    hash = str.hashCode();
  }
  public final int hashCode()
  {
    return hash;
  }
  public final boolean equals(Object o)
  {
    //The fastest possible equality check
    return o == this;

/*
    //This would be the more generic equality check if we allowed
    //access of the same String value from different StringWrapper objects.
    //This is still faster than the plain Strings as keys.
    if(o instanceof StringWrapper)
    {
       StringWrapper s = (StringWrapper) o;
       return s.hash == hash && string.equals(s.string);
    }
    else
      return false;
*/
  }
}
