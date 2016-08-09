package tuning.distrib;

import java.io.*;
import java.net.*;


class RelayServer
  implements Runnable
{
  //Simple input and output sockets
  Socket in_s;
  Socket out_s;

  //A string message to printout for logging identification
  String message;

  //Simple constructor just assigns the three parameters
  public RelayServer(Socket in, Socket out, String msg)
  {
    in_s = in;
    out_s = out;
    message = msg;
  }

  //The required method for Runnable.
  //Simply repeatedly reads from socket input, logs the read data
  //to System.out, and then relays that data on to the socket output
  public void run()
  {
    try
    {
      InputStream in = in_s.getInputStream();
      OutputStream out = out_s.getOutputStream();
      byte[] buf = new byte[8192];
      int len;
      for(;;)
      {
        len = in.read(buf);
        System.out.print(message);
        System.out.println(new String(buf, 0, len));
        out.write(buf, 0, len);
      }
    }
    catch (Exception e)
    {
      System.out.print(message);
      System.out.println(" TERMINATED");
      System.out.flush();
      try{in_s.close();}catch(Exception e2){}
      try{out_s.close();}catch(Exception e2){}
    }
  }

  //Basic main takes two arguments, a host and port. All incoming
  //connections will be relayed to the given host and port.
  public static void main(String[] args)
  {
    ServerSocket srvr = null;
    try
    {
      //Start a server socket on the localhost at the given port 
      srvr = new ServerSocket(Integer.parseInt(args[1]));
      for(;;)
      {
        //Block until a connection is made to us.
        Socket sclient = srvr.accept();
        System.out.println("Trying to connect to " + args[0]);
        //Connect to the 'real' server
        Socket ssrvr = new Socket(args[0], Integer.parseInt(args[1]));
        System.out.println("Connected to " + args[0]);
        //Start two threads, one to relay client to server communications,
        //and one to relay server to client communications.
        (new Thread(new RelayServer(sclient, ssrvr, "CLIENT->SERVER"))).start();
        (new Thread(new RelayServer(ssrvr, sclient, "SERVER->CLIENT"))).start();
      }
    }
    catch (Exception e)
    {
      System.out.println("SERVER TERMINATED: " + e.getMessage());
      try{srvr.close();}catch(Exception e2){}
    }
  }
}
