package tuning.dict;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import java.util.Hashtable;

public class Dict
{
  static int SEED = 1234567890;
  public static String[] DICT;
  public static String[] RAND_DICT;

  public static void main(String[] args)
  {
    try
    {
      initialize(false);
      System.out.println(DICT.length);
      System.out.println(RAND_DICT.length);
      Hashtable h = new Hashtable();
      for (int i = 0; i < DICT.length; i++)
      {
        if (DICT[i] == null) throw new Exception("DICT[i] == null");
	h.put(DICT[i],Boolean.TRUE);
      }
      Object o;
      for (int i = 0; i < RAND_DICT.length; i++)
      {
        if (RAND_DICT[i] == null) throw new Exception("DICT[i] == null");
	if ( (o=h.put(DICT[i],Boolean.FALSE)) != Boolean.TRUE ) throw new Exception("h.put");
      }
    }
    catch(Exception e){e.printStackTrace();}
  }

  public static void initialize(boolean garbageCollect)
    throws IOException
  {
    BufferedReader r = new BufferedReader(new FileReader("C:\\Jacks\\Ongoing\\Tuning\\tuning\\dict\\ENGLISH.MED"));
    Vector v = new Vector(500000);
    String line;
    while( (line = r.readLine()) != null)
    {
      v.addElement(line);
    }
    r.close();

    DICT = new String[v.size()];
    for (int i = 0; i < DICT.length; i++)
      DICT[i] = (String) v.elementAt(i);

    RAND_DICT = new String[v.size()];
    Random rand = new Random(SEED);
    int idx;
    for (int i = DICT.length-1; i >= 0 ; i--)
    {
	idx = (int) ((Math.abs(rand.nextInt()) * (long) i)/Integer.MAX_VALUE);
	RAND_DICT[i] = (String) v.elementAt(idx);
	v.setElementAt(v.elementAt(i), idx);
	v.setElementAt(null, i);
    }
    v = null;
    r = null;
    line = null;
    rand = null;
    if (garbageCollect)
      System.gc();
  }
}
