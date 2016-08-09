package tuning.distrib.rmi;

import java.io.*;
import java.net.*;
import java.util.zip.*;

public class CodecServerSocket
  extends ServerSocket
{
  public CodecServerSocket(int port)
    throws IOException
  {
    super(port);
  }

  public Socket accept()
    throws IOException
  {
    //see the ServerSocket.implAccept() docs for this weird implementation
    Socket s = new CodecSocket();
    implAccept(s);
    return s;
  }

}
