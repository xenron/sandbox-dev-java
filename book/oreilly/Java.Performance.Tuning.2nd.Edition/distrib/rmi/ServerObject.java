package tuning.distrib.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerObject
    extends Remote
{
  public abstract boolean getBoolean()
    throws RemoteException;
  public abstract int getNumber()
    throws RemoteException;
  public abstract String getString()
    throws RemoteException;
  public abstract void setBoolean(boolean flag)
    throws RemoteException;
  public abstract void setNumber(int i)
    throws RemoteException;
  public abstract void setString(String obj)
    throws RemoteException;
  public abstract void setAll(boolean flag, int i, String obj)
    throws RemoteException;
  public abstract String[] getQueryArray()
    throws RemoteException;
  public abstract String[] getRemoteQuery(String obj)
    throws RemoteException;
}
