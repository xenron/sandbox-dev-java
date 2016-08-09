package tuning.exception;

public class VariableTest3
{
  static int cntr;
  static int[] actr = {0};
  public static void main(String[] args)
  {
    int REPEAT = 500000000;
    int ctr;

    int tot = 0;
    long time = System.currentTimeMillis();
    for (int i = -REPEAT; i < 0; i++)
      tot += i;
    time = System.currentTimeMillis() - time;
    System.out.println("Loop local took " + time);

    tot = 0;
    time = System.currentTimeMillis();
    for (ctr = -REPEAT; ctr < 0; ctr++)
      tot += ctr;
    time = System.currentTimeMillis() - time;
    System.out.println("Method local took " + time);

    tot = 0;
    time = System.currentTimeMillis();
    for (actr[0] = -REPEAT; actr[0] < 0; actr[0]++)
      tot += actr[0];
    time = System.currentTimeMillis() - time;
    System.out.println("Loop static array took " + time);

    tot = 0;
    time = System.currentTimeMillis();
    for (cntr = -REPEAT; cntr < 0; cntr++)
      tot += cntr;
    time = System.currentTimeMillis() - time;
    System.out.println("Loop static took " + time);

  }

  public static void test1(int REPEAT)
  {
    for (int i = REPEAT; i > 0; i--)
    {
      Point p = new Point(i, i+1);
      p.x = i;
      p.y = i+1;
    }
  }
}
