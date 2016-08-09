package tuning.distrib.rmi;

import java.net.*;
import java.io.*;
import java.util.zip.*;
import java.rmi.server.*;

public class CodecClientSocketFactory
  implements RMIClientSocketFactory, Serializable
{
  public CodecClientSocketFactory(){}

  public Socket createSocket(String host, int port)
    throws IOException
  {
System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHH");
    return new CodecSocket(host, port);
  }
}
