package tuning.distrib.custom;

public class ServerObjectImpl
  implements ServerObject
{
  boolean bool;
  int number;
  String string;

  public ServerObjectImpl()
  {
  }

  public boolean getBoolean()
  {
    return bool;
  }

  public int getNumber()
  {
    return number;
  }

  public String getString()
  {
    return string;
  }

  public void setBoolean(boolean flag)
  {
    bool = flag;
  }

  public void setNumber(int i)
  {
    number = i;
  }

  public void setString(String s)
  {
    string = s;
  }

  public void setAll(boolean flag, int i, String s)
  {
    bool = flag;
    number = i;
    string = s;
  }

  public static void main(String args[])
  {
    try
    {
      ServerObjectImpl serverobjectimpl = new ServerObjectImpl();
      System.out.println("Starting server");
      Generate.addServer("ServerObject", serverobjectimpl);
      Generate.runServer(20992);
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
