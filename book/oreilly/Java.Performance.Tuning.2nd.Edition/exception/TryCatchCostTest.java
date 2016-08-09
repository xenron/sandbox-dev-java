package tuning.exception;

public class TryCatchCostTest
{
  public static void main(String[] args)
  {
    maintest(args);
    if (args.length > 0)
      maintest(args);
  }

  public static void maintest(String[] args)
  {
    Integer i1 = new Integer(3);
    Integer i2 = new Integer(4);
    Boolean b1 = new Boolean(true);
    Boolean b2 = new Boolean(false);
    int REPEAT = 50000;
    int FACTOR = 1000;
    boolean res = false;

    System.out.println(test1(i1));
    System.out.println(test1(b1));
    System.out.println(test2(i1));
    System.out.println(test2(b1));

    long time = System.currentTimeMillis();
    for (int j = REPEAT*FACTOR; j > 0 ; j--)
      res = test1(res ? i1 : i2);
    time = System.currentTimeMillis() - time;
    System.out.println("test1(i) took " + time);

    time = System.currentTimeMillis();
    for (int j = REPEAT; j > 0 ; j--)
      res = test1(res ? b1 : b2);
    time = System.currentTimeMillis() - time;
    System.out.println("test1(b) took " + time);
    System.out.println("Note that test1(b) was executed " + FACTOR + " times less than the other tests");

    time = System.currentTimeMillis();
    for (int j = REPEAT*FACTOR; j > 0 ; j--)
      res = test2(res ? i1 : i2);
    time = System.currentTimeMillis() - time;
    System.out.println("test2(i) took " + time);

    time = System.currentTimeMillis();
    for (int j = REPEAT*FACTOR; j > 0 ; j--)
      res = test2(res ? b1 : b2);
    time = System.currentTimeMillis() - time;
    System.out.println("test2(b) took " + time);
  }

  public static boolean test1(Object o)
  {
    try
    {
      Integer i = (Integer) o;
      return false;
    }
    catch (Exception e)
    {
      return true;
    }
  }

  public static boolean test2(Object o)
  {
    if (o instanceof Number)
      return false;
    else
      return true;
  }
}
