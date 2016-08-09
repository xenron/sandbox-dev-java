package tuning.profile;
import java.util.*;
import java.io.*;
import java.lang.reflect.*;

public class ObjectCreationMonitoring
{
  private static int MonitoringMode = 0;
  private static int StackModeCount = -1;
  public static final int VERBOSE_MODE = 1;
  public static final int TALLY_MODE = 2;
  public static final int GET_STACK_MODE = 3;

  public static void main(String args[])
  {
    try
    {
      //First argument is the option specifying which type of monitoring
      if(args[0].startsWith("-v"))
        //verbose creation - just prints every object's class as its created
        MonitoringMode = VERBOSE_MODE;
      else if(args[0].startsWith("-t"))
        //tally mode. Tally classes and print results at end
        MonitoringMode = TALLY_MODE;
      else if(args[0].startsWith("-s"))
      {
        //stack mode. Print stacks of objects as they are created
        MonitoringMode = GET_STACK_MODE;
        if(args[0].length() > 2)
          StackModeCount = Integer.parseInt(args[0].substring(2));
      }
      else
        throw new IllegalArgumentException("First command line argument must be one of -v/-t/-s");

      //Remaining arguments are the class with the main() method, and its arguments
      String classname = args[1];
      String[] argz = new String[args.length-2];
      System.arraycopy(args, 2, argz, 0, argz.length);
      Class clazz = Class.forName(classname);

      //main has one parameter, a String array.
      Class[] mainParamType = {args.getClass()}; 
      Method main = clazz.getMethod("main", mainParamType);
      Object[] mainParams = {argz};

      //start monitoring
      ObjectCreationMonitoringFlag.monitoring = true;
      main.invoke(null, mainParams);
      //stop monitoring
      ObjectCreationMonitoringFlag.monitoring = false;
      if (MonitoringMode == TALLY_MODE)
        printTally();
      else if (MonitoringMode == GET_STACK_MODE)
        printStacks();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  public static void monitor(Object o)
  {
    //Disable object creation monitoring while we report
    ObjectCreationMonitoringFlag.monitoring = false;

    switch(MonitoringMode)
    {
      case 1: justPrint(o); break;
      case 2: tally(o); break;
      case 3: getStack(o); break;
      default: System.out.println("Undefined mode for ObjectCreationMonitoring class"); break;
    }

    //Re-enable object creation monitoring
    ObjectCreationMonitoringFlag.monitoring = true;
  }

  public static void justPrint(Object o)
  {
    System.out.println(o.getClass().getName());
  }

  private static Hashtable Hash = new Hashtable();
  public static void tally(Object o)
  {
    //You need to print the tally from printTally()
    //at the end of the application
    Integer i = (Integer) Hash.get(o.getClass());
    if (i == null)
      i = new Integer(1);
    else
      i = new Integer(i.intValue() + 1);
    Hash.put(o.getClass(), i);
  }
  public static void printTally()
  {
    //should really sort the elements in order of the
    //number of objects created, butI will just print them
    //out inany order here.
    Enumeration e = Hash.keys();
    Class c;
    String s;
    while(e.hasMoreElements())
    {
      c = (Class) e.nextElement();
      System.out.print(s = c.getName());
      for (int i = 31-s.length(); i >= 0; i--)
        System.out.print(' ');
      System.out.print("\t");
      System.out.println(Hash.get(c));
    }
  }

  private static Exception Ex = new Exception();
  private static ByteArrayOutputStream MyByteStream = new ByteArrayOutputStream();
  private static PrintStream MyPrintStream = new PrintStream(MyByteStream);
  public static void getStack(Object o)
  {
    if (StackModeCount > 0)
	StackModeCount--;
    else if (StackModeCount != -1)
        return;
    Ex.fillInStackTrace();
    MyPrintStream.flush();
    MyByteStream.reset();
    MyPrintStream.print("Creating object of type ");
    MyPrintStream.println(o.getClass().getName());
    //Note that the first two lines of the stack will be getStack() and monitor()
    //and these can be ignored.
    Ex.printStackTrace(MyPrintStream);
    MyPrintStream.flush();
    String trace = new String(MyByteStream.toByteArray());
    Integer i = (Integer) Hash.get(trace);
    if (i == null)
      i = new Integer(1);
    else
      i = new Integer(i.intValue() + 1);
    Hash.put(trace, i);
  }

  public static void printStacks()
  {
    Enumeration e = Hash.keys();
    String s;
    while(e.hasMoreElements())
    {
      s = (String) e.nextElement();
      System.out.print("Following stack contructed ");
      System.out.print(Hash.get(s));
      System.out.println(" times:");
      System.out.println(s);
      System.out.println();
    }
  }

}
