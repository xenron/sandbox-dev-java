package tuning.distrib.rmi;

import java.util.Vector;
import java.io.PrintStream;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerObjectImpl
  extends UnicastRemoteObject
  implements ServerObject
{
  static String[] forQuery;
  static {init();}

  boolean bool;
  int number;
  String string;

  public static void init()
  {
    System.out.println("Starting class initialization");
    forQuery = new String[26*26*26*5];
//    forQuery = new String[26*26*26*26];
    int idx = 0;
    StringBuffer sb = new StringBuffer(4);
    for (int i = 'a'; i <= 'e'; i++)
      for (int j = 'a'; j <= 'z'; j++)
        for (int k = 'a'; k <= 'z'; k++)
          for (int l = 'a'; l <= 'z'; l++)
          {
            sb.setLength(0);
            sb.append((char) i).append((char) j).append((char) k).append((char) l);
//            sb.append((char) j).append((char) k).append((char) l);
            forQuery[idx++] = sb.toString();
          }
    System.out.println("Finished class initialization");
  }

  public ServerObjectImpl()
    throws RemoteException
  {
  }

  //just add a dummy variable to distinguish the constructor
  public ServerObjectImpl(boolean useCodec)
    throws RemoteException
  {
    super(0, new CodecClientSocketFactory(), new CodecServerSocketFactory());
  }

  public boolean getBoolean()
    throws RemoteException
  {
    return bool;
  }

  public int getNumber()
    throws RemoteException
  {
    return number;
  }

  public String getString()
    throws RemoteException
  {
    return string;
  }

  public void setBoolean(boolean flag)
    throws RemoteException
  {
    bool = flag;
  }

  public void setNumber(int i)
    throws RemoteException
  {
    number = i;
  }

  public void setString(String s)
    throws RemoteException
  {
    string = s;
  }

  public void setAll(boolean flag, int i, String s)
    throws RemoteException
  {
    bool = flag;
    number = i;
    string = s;
  }

  public String[] getQueryArray()
    throws RemoteException
  {
    return forQuery;
  }

  public String[] getRemoteQuery(String obj)
    throws RemoteException
  {
    return getQuery(obj, forQuery);
  }

  public static String[] getQuery(String obj, String[] array)
  {
    Vector v = new Vector();
    for (int i = 0; i < array.length; i++)
      if (array[i].indexOf(obj) != -1)
        v.addElement(array[i]);
    String[] result = new String[v.size()];
    for (int i = 0; i < result.length; i++)
      result[i] = (String) v.elementAt(i);
    return result;
  }

  public static void main(String args[])
  {
    if(System.getSecurityManager() == null)
      System.setSecurityManager(new RMISecurityManager());
    try
    {
      System.out.println("Creating ServerObj");
      ServerObjectImpl serverobjectimpl = 
        args.length > 0 ? new ServerObjectImpl(true) : new ServerObjectImpl();
      System.out.println("Binding ServerObj in registry");
      Naming.rebind("/ServerObj", serverobjectimpl);
      System.out.println("ServerObj bound in registry");
      return;
    }
    catch(Exception exception)
    {
      System.out.println("ServerObj err: " + exception.getMessage());
      exception.printStackTrace();
      return;
    }
  }
}
