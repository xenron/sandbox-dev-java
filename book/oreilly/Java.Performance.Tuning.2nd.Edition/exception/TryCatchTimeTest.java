package tuning.exception;

public class TryCatchTimeTest
{
  public static void main(String[] args)
  {
    int REPEAT = 10000000;
    if (args.length == 1)
      REPEAT = Integer.parseInt(args[0]);
    System.out.println("Using a repeat value (number of loop iterations) of " + REPEAT);

    Object[] xyz = {new Integer(3), new Integer(10101), new Integer(67)};
    boolean res;
    long time = System.currentTimeMillis();
    res = try_catch_in_loop(REPEAT, xyz);
    System.out.println("try catch in loop took     " + (System.currentTimeMillis() - time));

    time = System.currentTimeMillis();
    res = try_catch_not_in_loop(REPEAT, xyz);
    System.out.println("try catch not in loop took " + (System.currentTimeMillis() - time));

    time = System.currentTimeMillis();
    res = try_catch_not_in_loop(REPEAT, xyz);
    System.out.println("try catch not in loop took " + (System.currentTimeMillis() - time));

    time = System.currentTimeMillis();
    res = try_catch_in_loop(REPEAT, xyz);
    System.out.println("try catch in loop took     " + (System.currentTimeMillis() - time));

    time = System.currentTimeMillis();
    res = try_catch_not_in_loop(REPEAT, xyz);
    System.out.println("try catch not in loop took " + (System.currentTimeMillis() - time));

    time = System.currentTimeMillis();
    res = try_catch_in_loop(REPEAT, xyz);
    System.out.println("try catch in loop took     " + (System.currentTimeMillis() - time));
  }

  public static boolean try_catch_not_in_loop(int repeat, Object[] o)
  {
    Integer i[] = new Integer[3];
    try
    {
      for (int j = repeat; j > 0; j--)
      {
        i[0] = (Integer) o[(j+1)%2];
        i[1] = (Integer) o[j%2];
        i[2] = (Integer) o[(j+2)%2];
      }
      return false;
    }
    catch (Exception e)
    {
      return true;
    }
  }

  public static boolean try_catch_in_loop(int repeat, Object[] o)
  {
    Integer i[] = new Integer[3];
    for (int j = repeat; j > 0; j--)
    {
      try
      {
        i[0] = (Integer) o[(j+1)%2];
        i[1] = (Integer) o[j%2];
        i[2] = (Integer) o[(j+2)%2];
      }
      catch (Exception e)
      {
        return true;
      }
    }
    return false;
  }
}
