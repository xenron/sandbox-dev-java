package tuning.distrib.rmi;

import java.net.*;
import java.io.*;
import java.util.zip.*;
import java.rmi.server.*;

public class CodecServerSocketFactory
  implements RMIServerSocketFactory, Serializable
{
  public CodecServerSocketFactory(){}

  public ServerSocket createServerSocket(int port)
    throws IOException
  {
System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIIII");
    return new CodecServerSocket(port);
  }
}
