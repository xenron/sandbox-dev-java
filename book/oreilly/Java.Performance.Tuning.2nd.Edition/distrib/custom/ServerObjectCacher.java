package tuning.distrib.custom;

public class ServerObjectCacher
  implements ServerObject
{
  ServerObject stub;
  boolean b;
  boolean bInit;
  int i;
  boolean iInit;
  String s;
  boolean sInit;

  public ServerObjectCacher(ServerObject stub)
  {
    super ();
    this.stub = stub;
  }

  public boolean getBoolean()
  {
    if (bInit)
      return b;
    else
    {
      b = stub.getBoolean();
      bInit = true;
      return b;
    }
  }

  public int getNumber()
  {
    if (iInit)
      return i;
    else
    {
      i = stub.getNumber();
      iInit = true;
      return i;
    }
  }

  public String getString ()
  {
    if (sInit)
      return s;
    else
    {
      s = stub.getString();
      sInit = true;
      return s;
    }
  }

  public void setBoolean(boolean flag)
  {
    bInit = false;
    stub.setBoolean(flag);
  }

  public void setNumber (int i)
  {
    iInit = false;
    stub.setNumber(i);
  }

  public void setString(String obj)
  {
    sInit = false;
    stub.setString(obj);
  }

  public void setAll(boolean flag, int i, String obj)
  {
    bInit = iInit = sInit = false;
    stub.setAll(flag, i, obj);
  }
}
