package tuning.distrib.rmi;

import java.rmi.*;
import tuning.socket.SockStreamLogger;

public class ClientMain3
{
  public static void main(String args[])
  {
    SockStreamLogger.LOG_MESSAGE = false;
    SockStreamLogger.LOG_SIZE = false;
    int DELAY = args.length > 1 ? Integer.parseInt(args[1]) : -1;
    if (System.getSecurityManager() == null)
      System.setSecurityManager(new RMISecurityManager());
    try
    {
      ServerObject obj = (ServerObject) Naming.lookup("/ServerObj");
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
    throws RemoteException
  {
    reinitLogger(delay);
    long time = System.currentTimeMillis();
    String[] results = serverRef.getRemoteQuery("a");
    System.out.println("Remote query gained " + results.length +
      " results for time: " + (System.currentTimeMillis()-time)) ;
    reportLogger();

    reinitLogger(delay);
    time = System.currentTimeMillis();
    results = serverRef.getQueryArray();
    results = ServerObjectImpl.getQuery("a", results);
    System.out.println("Local query gained " + results.length +
      " results for time: " + (System.currentTimeMillis()-time)) ;
    reportLogger();
  }      

  public static void reinitLogger(int delay)
  {
    SockStreamLogger.DELAY = delay;
    SockStreamLogger.READ_DELAY = delay;
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