package tuning.distrib.corba;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import tuning.socket.SockStreamLogger;

public class ClientMain
{
  public static void main(String args[])
  {
    SockStreamLogger.LOG_MESSAGE = false;
    SockStreamLogger.LOG_SIZE = false;
    try
    {
      // create and initialize the ORB
      ORB orb = ORB.init(args, null);

      // get the root naming context
      org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
      NamingContext ncRef = NamingContextHelper.narrow(objRef);

      // resolve the Object Reference in Naming
      NameComponent nc = new NameComponent("ServerObject", "");
      NameComponent path[] = {nc};
      ServerObject serverRef = ServerObjectHelper.narrow(ncRef.resolve(path));

      System.out.println("Pausing 10 seconds");
      try{Thread.sleep(10000);}catch(Exception e){}
      System.out.println("Starting tests");
      // call the Hello server object and print results
      test(serverRef, Integer.parseInt(args[3]), Integer.parseInt(args[2]));
      test(serverRef, Integer.parseInt(args[3]), Integer.parseInt(args[2]));

    }
    catch (Exception e)
    {
      System.out.println("ERROR : " + e) ;
      e.printStackTrace(System.out);
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
