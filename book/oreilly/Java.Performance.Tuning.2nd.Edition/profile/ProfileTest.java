package tuning.profile;
import java.util.*;

public class ProfileTest
{

  public static void main(String[] args)
  {
    //Repeat the loop this many times
    int repeat = 2000;

    //Two arrays of numbers, eight doubles and ten longs
    double[] ds = {Double.MAX_VALUE, -3.14e-200D, Double.NEGATIVE_INFINITY,
	567.89023D, 123e199D, -0.000456D, -1.234D, 1e55D};
    long[] ls = {2283911683699007717L, -8007630872066909262L, 4536503365853551745L,
      548519563869L, 45L, Long.MAX_VALUE, 1L, -9999L, 7661314123L, 0L};

    //initializations
    long time;
    StringBuffer s = new StringBuffer();
    Hashtable h = new Hashtable();
    System.out.println("Starting test");
    time = System.currentTimeMillis();

    //Repeatedly add all the numbers to a stringbuffer, and also
    //put them into a hash table
    for (int i = repeat; i > 0; i--)
    {
        s.setLength(0);
        for (int j = ds.length-1; j >= 0; j--)
        {
            s.append(ds[j]);
            h.put(new Double(ds[j]), Boolean.TRUE);
        }
        for (int j = ls.length-1; j >= 0; j--)
        {
            s.append(ls[j]);
            h.put(new Long(ls[j]), Boolean.FALSE);
        }
    }
    time = System.currentTimeMillis() - time;
    System.out.println("  The test took " + time + " milliseconds");
  }
}
