package tuning.threads;

public class CounterTest
  extends Thread
{
  private static Object LOCK1 = new Object();
  private static Object LOCK2 = new Object();
  private static long startTime = -1;
  static int REPEAT;
  static int numThreads = 0;
  static boolean Go = false;
  private static int NUMBER_OF_THREADS = 4;

  //instance variable to specify which thread we are.
  int num;

  //Create a thread, assigning a unique value for the thread.
  //The value is used to index into the global array of counters
  //in Counter3 class.
  public CounterTest(int threadnum)
  {
    super();
    num = threadnum;
  }
  synchronized static void incThreads() {numThreads++;}
  synchronized static void decThreads() {numThreads--;}
  static int getNumThreads() {return numThreads;}
  //And main which forks four threads, and run() which adds the value 1 to the Counter,
  //500,000 times consecutively, with timing code to determine how long from start of first
  //thread to termination of the last.
  public static void main(String[] args)
  {
    int tmpREPEAT = (args.length > 0) ? Integer.parseInt(args[0]) : 10000000;
    if (args.length < 2)
    {
      //don't use this if we have two or more args
      REPEAT = 10000;
      test();
    }
    REPEAT = tmpREPEAT;
    test();
  }

  public static void test()
  {
    for (int i = 0; i < NUMBER_OF_THREADS; i++)
      (new CounterTest(i)).start();

    runOneTest();
    runOneTest();
    runOneTest();
  }

  public static void runOneTest()
  {
    //wait until all threads are ready to run
    while(getNumThreads() < NUMBER_OF_THREADS)
      try{Thread.sleep(10);}catch(InterruptedException e){}

    //tell the threads to go
    synchronized (LOCK1) {LOCK1.notifyAll();}

    //wait for them all to stop
    while(getNumThreads() > 0)
      try{Thread.sleep(100);}catch(InterruptedException e){}

    //reset the start time
    startTime = -1;

    //All threads have stopped now, so we can release them
    synchronized (LOCK2) {LOCK2.notifyAll();}
  }

  public static void waitForGo(String mess)
  {
    //Register that we are ready to run
    incThreads();

    //wait until told to start, so that we can start all
    //the threads at approximately the same time.
    synchronized(LOCK1)
    {
      try {LOCK1.wait();}
      catch (InterruptedException e) {}
    }
    System.out.println("Starting test for " + mess);

    //Set the start time only once at the beginning
    //of the first thread to start.
    setStartTime();
  }
  public synchronized static void setStartTime()
  {
    //only sets the start time once
    if (startTime == -1)
      startTime = System.currentTimeMillis();
  }
  public static void stop(String mess)
  {
    //print time and count for every thread.
    //Only the last thread to terminate gives full values.
    System.out.println(mess + " time: " + (System.currentTimeMillis()-startTime));
    decThreads();

    //Wait until the main threads knows that we've finished
    synchronized(LOCK2)
    {
      try {LOCK2.wait();}
      catch (InterruptedException e) {}
    }
  }
  public void run()
  {
    Counter1.initialize(0);
    waitForGo("Counter1");
    for (int i = REPEAT; i > 0; i--)
      Counter1.addAmount(0, 1);
    stop("Counter1 count: " + Counter1.getAmount(0));

    Counter2.initialize(0);
    waitForGo("Counter2");
    for (int i = REPEAT; i > 0; i--)
      Counter2.addAmount(0, 1);
    stop("Counter2 count: " + Counter2.getAmount(0));

    Counter3.initialize(this);
    waitForGo("Counter3");
    for (int i = REPEAT; i > 0; i--)
      Counter3.addAmount(0, 1);
    stop("Counter3 count: " + Counter3.getAmount(0));
  }
}
