package tuning.threads;

public class Counter2
{
  //For simplicity make just 10 counters
  static long[] vec = new long[10]; 

  public static synchronized void initialize(int key)
  {
    vec[key] = 0;
  }

  //An also make the just make key the index into the array
  public static synchronized void addAmount(int key, long amount)
  {
    //Now the method is synchronized, so we will always
    //complete any particular update
    vec[key] += amount;
  }
  public static synchronized long getAmount(int key)
  {
    return vec[key];
  }
}
