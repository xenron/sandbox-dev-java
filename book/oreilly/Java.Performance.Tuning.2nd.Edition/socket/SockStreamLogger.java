package tuning.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;

public class SockStreamLogger
{
  public static boolean LOG_SIZE = true;
  public static boolean LOG_MESSAGE = true;
  public static long DELAY = -1;
  public static long READ_DELAY = -1;
  public static int WriteCount=0;
  public static int ReadCount=0;
  public static int WriteSize=0;
  public static int ReadSize=0;
  public static void log(boolean isWritten, Socket so, int sz, byte[] buf, int off)
  {
	if (LOG_SIZE)
	{
		System.err.print("Message of size ");
		System.err.print(sz);
		System.err.print(isWritten ? " written" : " read");
		System.err.print(" by Socket ");
		System.err.println(so);
	}
	if (LOG_MESSAGE)
	  System.err.println(new String(buf, off, sz));
  }  
  public static void read(Socket so, int sz, byte[] buf, int off)
  {
    log(false, so, sz, buf, off);
    ReadCount++;
    ReadSize += sz;
    if(READ_DELAY != -1) try{Thread.sleep(READ_DELAY);}catch(Exception e){}
  }    
  public static void written(Socket so, int sz, byte[] buf, int off)
  {
    log(true, so, sz, buf, off);
    WriteCount++;
    WriteSize += sz;
    if(DELAY != -1) try{Thread.sleep(DELAY);}catch(Exception e){}
  }    
}
