package tuning. threads;

public class Counter3
{
  //support up to 10 threads of ten counters
  static long vec[][] = new long[10][];

  public static synchronized void initialize(CounterTest t)
  {
    //For simplicity make just 10 counters per thread
    vec[t.num] = new long[10];
  }

  public static void addAmount(int key, long amount)
  {
    //Use our own threads to make the mapping easier,
    //and to illustrate the technique of customizing threads.
    //For generic Thread objects, could use an unsynchronized 
    //HashMap or other Map,
    //Or use ThreadLocal if JDK 1.2 is available

    //We use the num instance variable of the CounterTest
    //object to determine which array we are going to increment.
    //Sonce each thread is different, here is no conflict.
    //Each thread updates its own counter.
    long[] arr =  vec[((CounterTest) Thread.currentThread()).num];
    arr[key] += amount;
  }
  public static synchronized long getAmount(int key)
  {
    //The current amount must be aggregated across the thread
    //storage arrays. This needs to be synchronized, but
    //does not matter here as I just call it at the end.
    long amount = 0;
    for (int threadnum = vec.length-1; threadnum >= 0 ; threadnum--)
    {
      long[] arr = vec[threadnum];
      if (arr != null)
        amount += arr[key];
    }
    return amount;
  }
}
