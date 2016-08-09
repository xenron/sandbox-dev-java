package tuning.distrib.custom;

import java.net.Socket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface GenericServerObject
{
  public void setRealServerObject(Object server);
  public void setSocket(Socket client) throws IOException;
  public void setSocket(Socket client, ObjectInputStream in, ObjectOutputStream out) throws IOException;
  public void serviceRequest() throws IOException;
  public void setId(int i);
}
