package tuning.profile;
import java.util.*;
import java.io.*;

public class ProfileTest2
{

  public static void main(String[] args)
  {
    try
    {
    int repeat = 2000;
    double[] ds = {Double.MAX_VALUE, -3.14e-200D, Double.NEGATIVE_INFINITY,
	567.89023D, 123e199D, -0.000456D, -1.234D, 1e55D};
    long[] ls = {2283911683699007717L, -8007630872066909262L, 4536503365853551745L,
      548519563869L, 45L, Long.MAX_VALUE, 1L, -9999L, 7661314123L, 0L};
    long time;
    System.out.println("Starting test");
    time = System.currentTimeMillis();

    for (int i = repeat; i > 0; i--)
    {
      ByteArrayOutputStream buf = new ByteArrayOutputStream();
      ObjectOutputStream wrtr = new ObjectOutputStream(buf);
      wrtr.writeObject(ds);
      wrtr.writeObject(ls);
      wrtr.flush();
      wrtr.close();

      InputStream istream = new ByteArrayInputStream(buf.toByteArray());
      ObjectInputStream rdr = new ObjectInputStream(istream);
      ds = (double[]) rdr.readObject();
      ls = (long[]) rdr.readObject();
      rdr.close();
    }
    time = System.currentTimeMillis() - time;
    System.out.println("  The test took " + time + " milliseconds");
    }
    catch(Exception e){e.printStackTrace();}
  }
}
