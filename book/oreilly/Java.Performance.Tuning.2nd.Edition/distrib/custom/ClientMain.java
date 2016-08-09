package tuning.distrib.custom;

import tuning.socket.SockStreamLogger;

public class ClientMain
{
  public static void main(String args[])
  {
    SockStreamLogger.LOG_MESSAGE = false;
    SockStreamLogger.LOG_SIZE = false;
    int DELAY = args.length > 1 ? Integer.parseInt(args[1]) : -1;
    try
    {
      ServerObject obj = (ServerObject) Generate.resolveServer("ServerObject", "localhost", 20992);
      int REPEAT = args.length > 0 ? Integer.parseInt(args[0]) : 1000;
      System.out.println("Pausing 10 seconds");
      try{Thread.sleep(10000);}catch(Exception e){}
      System.out.println("Starting tests");
      test(obj, REPEAT, DELAY);
      test(obj, REPEAT, DELAY);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public static void test(ServerObject serverRef, int repeat, int delay)
  {
    reinitLogger(delay);
    long time = System.currentTimeMillis();
    for (int i = repeat; i > 0; i--)
    {
      serverRef.setString("hello");
      serverRef.setBoolean(true);
      serverRef.setNumber(33);
    }
    System.out.println("Writing three methods, Time: " + (System.currentTimeMillis()-time)) ;
    reportLogger();

    reinitLogger(delay);
    time = System.currentTimeMillis();
    for (int i = repeat; i > 0; i--)
    {
      serverRef.setAll(true, 33, "hello");
    }
    System.out.println("Writing one   method , Time: " + (System.currentTimeMillis()-time)) ;
    reportLogger();

    reinitLogger(delay);
    String s;
    int i1;
    boolean b;
    time = System.currentTimeMillis();
    for (int i = repeat; i > 0; i--)
    {
      s = serverRef.getString();
      b = serverRef.getBoolean();
      i1 = serverRef.getNumber();
    }
    System.out.println("Reading uncached     , Time: " + (System.currentTimeMillis()-time)) ;
    reportLogger();

    reinitLogger(delay);
    ServerObjectCacher wrapper = new ServerObjectCacher(serverRef);
    time = System.currentTimeMillis();
    for (int i = repeat; i > 0; i--)
    {
      s = wrapper.getString();
      b = wrapper.getBoolean();
      i1 = wrapper.getNumber();
    }
    System.out.println("Reading cached       , Time: " + (System.currentTimeMillis()-time)) ;
    reportLogger();
  }      

  public static void reinitLogger(int delay)
  {
    SockStreamLogger.DELAY = delay*2;
    SockStreamLogger.READ_DELAY = -1;
    SockStreamLogger.ReadSize = 0;
    SockStreamLogger.WriteSize = 0;
    SockStreamLogger.ReadCount = 0;
    SockStreamLogger.WriteCount = 0;
  }

  public static void reportLogger()
  {
    System.out.print("Delay: ");
    System.out.print(SockStreamLogger.DELAY);
    System.out.print(" ReadSize: ");
    System.out.print(SockStreamLogger.ReadSize);
    System.out.print(" WriteSize: ");
    System.out.print(SockStreamLogger.WriteSize);
    System.out.print(" ReadCount: ");
    System.out.print(SockStreamLogger.ReadCount);
    System.out.print(" Writecount: ");
    System.out.print(SockStreamLogger.WriteCount);
    System.out.println();
  }
}