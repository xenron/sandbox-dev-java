package tuning.loop;

public class Factorial
{

  public static final long FACTORIAL20 = 2432902008176640000L;

  public static long factorial1(int n)
  {
    if (n < 2) return 1L;
    else return n*factorial1(n-1);
  }

  public static long factorial1a(int n)
  {
    if (n < 2) return 1L;
    else return factorial1b(n, 1L);
  }

  public static long factorial1b(int n, long result)
  {
    //No need to consider n < 2, as factorial1a handles that
    if (n == 2) return 2L*result;
    else return factorial1b(n-1, result*n);
  }

  public static long factorial1c(int n, long result)
  {
//    if (n < 2) return 1L;
    //else
 if (n == 2) return 2L*result;
    else return factorial1c(n-1, result*n);
  }

  public static final long[] factorial3Cache = new long[15];
  public static long factorial3(int n)
  {
    if (n < 2) return 1L;
    else if (n < 15)
    {
      if (factorial3Cache[n] == 0)
        factorial3Cache[n] = n*factorial3(n-1);
      return factorial3Cache[n];
    }
    else return n*factorial3(n-1);
  }

  public static final long[] factorial4Cache = {
    1L,
    1L,
    2L,
    6L,
    24L,
    120L,
    720L,
    5040L,
    40320L,
    362880L,
    3628800L,
    39916800L,
    479001600L,
    6227020800L,
    87178291200L
  };

  public static long factorial4(int n)
  {
    if (n < 15)
      return factorial4Cache[n];
    else return n*factorial4(n-1);
  }

  public static long factorial2(int n)
  {
    long result = 1;
    while(n>1)
    {
      result *= n--;
    }
    return result;
  }

  public static final long[] factorial5Cache = new long[21];
  public static long factorial5(int n)
  {
    if (n < 2) return 1L;
    else if (n < 21)
    {
      if (factorial5Cache[n] == 0)
        factorial5Cache[n] = n*factorial2(n-1);
      return factorial5Cache[n];
    }
    else return n*factorial2(n-1);
  }

  public static void main(String[] args)
  {
    maintest(args);
    if (args.length > 1)
      maintest(args);
  }

  public static void maintest(String[] args)
  {
    int REPEAT = Integer.parseInt(args[0]);
    long res;
    long time = System.currentTimeMillis();
    for (int i = REPEAT; i > 0 ; i--)
    {
      res = factorial1(20);
      if (res != FACTORIAL20)
        System.out.println("oh dear: " + res);
    }
    time = System.currentTimeMillis() - time;
    System.out.println("factorial1 took " + time);

    time = System.currentTimeMillis();
    for (int i = REPEAT; i > 0 ; i--)
    {
      res = factorial1a(20);
      if (res != FACTORIAL20)
        System.out.println("oh dear: " + res);
    }
    time = System.currentTimeMillis() - time;
    System.out.println("factorial1a took " + time);

    time = System.currentTimeMillis();
    for (int i = REPEAT; i > 0 ; i--)
    {
      res = factorial1c(20, 1L);
      if (res != FACTORIAL20)
        System.out.println("oh dear: " + res);
    }
    time = System.currentTimeMillis() - time;
    System.out.println("factorial1c took " + time);

    time = System.currentTimeMillis();
    for (int i = REPEAT; i > 0 ; i--)
    {
      res = factorial2(20);
      if (res != FACTORIAL20)
        System.out.println("oh dear: " + res);
    }
    time = System.currentTimeMillis() - time;
    System.out.println("factorial2 took " + time);

    time = System.currentTimeMillis();
    for (int i = REPEAT; i > 0 ; i--)
    {
      res = factorial3(20);
      if (res != FACTORIAL20)
        System.out.println("oh dear: " + res);
    }
    time = System.currentTimeMillis() - time;
    System.out.println("factorial3 took " + time);

    time = System.currentTimeMillis();
    for (int i = REPEAT; i > 0 ; i--)
    {
      res = factorial4(20);
      if (res != FACTORIAL20)
        System.out.println("oh dear: " + res);
    }
    time = System.currentTimeMillis() - time;
    System.out.println("factorial4 took " + time);

    time = System.currentTimeMillis();
    for (int i = REPEAT; i > 0 ; i--)
    {
      res = factorial5(20);
      if (res != FACTORIAL20)
        System.out.println("oh dear: " + res);
    }
    time = System.currentTimeMillis() - time;
    System.out.println("factorial5 took " + time);


  }
}