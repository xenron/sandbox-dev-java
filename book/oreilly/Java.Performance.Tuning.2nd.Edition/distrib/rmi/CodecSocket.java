package tuning.distrib.rmi;

import java.io.*;
import java.net.*;
import java.util.zip.*;

public class CodecSocket
  extends Socket
{
  InputStream in = null;
  OutputStream out = null;
  public CodecSocket() throws IOException {super();}
  public CodecSocket(String host, int port)
    throws IOException
  {
    super(host,port);
  }

  public synchronized InputStream getInputStream()
    throws IOException
  {
    if (in == null)
      in = new CodecInputStream(super.getInputStream());
    return in;
  }

  public synchronized OutputStream getOutputStream()
    throws IOException
  {
    if (out == null)
      out = new CodecOutputStream(super.getOutputStream());
    return out;
  }

  public synchronized void close()
    throws IOException
  {
    getOutputStream().flush();
    getOutputStream().close();
  }
}
