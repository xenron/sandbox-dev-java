package tuning.sorting;
import java.util.HashMap;
import java.util.Arrays;

public class Magnitudes
{
  public static void main(String[] args)
  {
    int SIZE = 10;
    for (int i = SIZE; i < 1000 ; i+=SIZE)
      test(i, 1000);
    SIZE = 1000;
    for (int i = SIZE; ; i+=SIZE)
      test(i,1);
  }
  public static Object access(Integer[] arr, Integer in, Object[] os)
  {
    for (int i = arr.length-1; i >= 0; i--)
    {
      if (arr[i].equals(in))
        return os[i];
    }
    System.out.println("Warning: no element found");
    return null;
  }
  public static void test(int SIZE, int repeat)
  {
    System.out.println("SIZE = " + SIZE);
    Object o = new Object();
    Object[] os = new Object[SIZE];
    HashMap hash = new HashMap();
    Integer[] arr = new Integer[SIZE];
    Integer in;
    for (int i = 0; i < SIZE; i++)
    {
      in = new Integer(i);
      hash.put(in, o);
      arr[i] = in;
    }
    long time;

    time = System.currentTimeMillis();
  for (int i = 0; i < SIZE; i++)
    for (int j = repeat; j > 0 ; j--)
    {
      in = new Integer(i);
      os[i] = hash.get(in);
    }
    time = System.currentTimeMillis() - time;
    System.out.println("Hash accessed in " + (time));

    time = System.currentTimeMillis();
  for (int i = 0; i < SIZE; i++)
    for (int j = repeat; j > 0 ; j--)
    {
      in = new Integer(i);
      os[i] = access(arr, in, os);
    }
    time = System.currentTimeMillis() - time;
    System.out.println("array accessed in " + (time));
  }

}
