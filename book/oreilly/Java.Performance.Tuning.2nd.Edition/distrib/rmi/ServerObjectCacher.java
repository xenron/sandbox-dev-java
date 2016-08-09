package tuning.distrib.rmi;

import java.rmi.RemoteException;

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
    throws RemoteException
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
    throws RemoteException
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
    throws RemoteException
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
    throws RemoteException
  {
    bInit = false;
    stub.setBoolean(flag);
  }

  public void setNumber (int i)
    throws RemoteException
  {
    iInit = false;
    stub.setNumber(i);
  }

  public void setString(String obj)
    throws RemoteException
  {
    sInit = false;
    stub.setString(obj);
  }

  public void setAll(boolean flag, int i, String obj)
    throws RemoteException
  {
    bInit = iInit = sInit = false;
    stub.setAll(flag, i, obj);
  }

  public String[] getQueryArray(){return null;}
  public String[] getRemoteQuery(String obj){return null;}
}
