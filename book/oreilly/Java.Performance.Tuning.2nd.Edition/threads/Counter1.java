package tuning.threads;

public class Counter1
{
  //For simplicity make just 10 counters
  static long[] vec = new long[10]; 

  public static void initialize(int key)
  {
    vec[key] = 0;
  }

  //And also make the just make key the index into the array
  public static void addAmount(int key, long amount)
  {
    //This is not atomically synchronized since we do an array
    //access together with an update, which are two operations.
    vec[key] += amount;
  }

  public static long getAmount(int key)
  {
    return vec[key];
  }
}
