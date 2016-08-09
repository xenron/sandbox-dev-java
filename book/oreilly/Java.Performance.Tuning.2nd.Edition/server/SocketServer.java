package tuning.server;

import java.net.*;
import java.io.*;


public class SocketServer
  implements Runnable
{
  static ServerSocket sock;

  public static void main(String[] args)
  {
    try
    {
    sock = new ServerSocket(12345);
    (new Thread(new SocketServer())).start();
    (new Thread(new SocketServer())).start();
    }
    catch (Exception e)    { System.out.println(e);}

  }

  public void run()
  {
  for (;;)
  {
    try
    {
      Socket client = sock.accept();
      Thread.sleep(10000);
      client.close();
	System.out.println("Closed from " + Thread.currentThread());
    }
    catch (Exception e)    { System.out.println(e);}
  }
  }
}
