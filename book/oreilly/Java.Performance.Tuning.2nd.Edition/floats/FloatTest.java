package tuning.floats;

public class FloatTest
{
  public static void main(String[] args)
  {
    int REPEAT = Integer.parseInt(args[0]);
    double x = 0;
    long time = System.currentTimeMillis();
    for (int i = REPEAT; i > 0; i--)
      x = runtest(i);
    System.out.println(x + " in time " + (System.currentTimeMillis()-time));
  }
  public static double runtest(int i)
  {
    return Math.sqrt(i);
  }
}
