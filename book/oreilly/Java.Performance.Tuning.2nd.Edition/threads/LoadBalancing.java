package tuning.threads;

import java.io.*;
import java.net.*;
import java.util.*;

public class LoadBalancing
  implements Runnable
{

  public static final boolean DEBUG = true;

  public static String[] getFileNames(String directory)
  {
//    String[] names = {
//      "c:\\temp\\01.txt", "http://news.bbc.co.uk"}
    String[] names = new String[1500];
    String file1 = "c:\\temp\\";
    String file2 = ".txt";
    int count = 1;
    String url = "http://localhost:" + SillyHttpServer.SERVER_PORT;
    for (int i = 1; i < names.length; i+=2, count++)
    {
      names[i-1] = file1 + count + file2;
      names[i] = url;
    }
    return names;
  }

  public static void main(String args[])
  {
    try
    {
      int roughlyParallelTestDelay = Integer.parseInt(args[0]);
      int loadBalancedTestNumThreads = Integer.parseInt(args[1]);
      boolean runAllTests = args.length > 2;
      String[] files = getFileNames(args[1]);
      SillyHttpServer.serve();
      loadBalancedTest(files, loadBalancedTestNumThreads);
      if (runAllTests)
        massivelyParallelTest(files);
      roughlyParallelTest(files, roughlyParallelTestDelay);
      if (runAllTests)
        iterativeTest(files);

      SillyHttpServer.stop();
      System.exit(0);
    }
    catch (Exception e) {e.printStackTrace();}
  }

  /* Two args, the local file to put the downloaded page into,
   * and the url where the page to download is.
   */
  public static void dowload(String file, String url)
    throws IOException
  {
    URL u = new URL(url);
    InputStream in = null;
    //Try repeatedly to get the page opened. Note that catching
    //all exceptions is not such a good idea here. It would be
    //much better to catch individual execption types and handle
    //them separately. Some exceptions should not lead to a repeated
    //attempt to access the page. But this definition is okay for testing.
    while(in == null)
      try{in = u.openStream();}
      catch(Exception e){try {Thread.sleep(500);}catch(Exception e2){}}
    FileOutputStream out = new FileOutputStream(file);
    byte[] buffer = new byte[8192];

    //read until the connection terminates (this is not a
    //keep-alive connection), and write to the file.
    int len = in.read(buffer);
    while(len != -1)
    {
      out.write(buffer, 0, len);
      len = in.read(buffer);
    }
    out.close();
    in.close();
  }

  public static void iterativeTest(String[] files)
    throws IOException
  {
    long time = System.currentTimeMillis();
    for (int i = 0; i < files.length; i+=2)
      dowload(files[i], files[i+1]);
    System.out.println("iterativeTest: " + (System.currentTimeMillis()-time));
  }  

  static int parallelCount;
  static long parallelStartTime;
  static int parallelThreadCount;
  String url;
  String localfilename;
  public static void massivelyParallelTest(String[] files)
    throws IOException
  {
    parallelStartTime = System.currentTimeMillis();
    parallelThreadCount = files.length/2;
    parallelCount = 0;
    for (int i = 0; i < files.length; i+=2)
      (new Thread(new LoadBalancing(files[i], files[i+1]))).start();

    //Wait for the threads to finish, so the next test doesn't
    //run until this one is fully finished.
    while(parallelThreadCount > 0)
      try{Thread.sleep(2000);}catch(InterruptedException e){}
  }

  public static void roughlyParallelTest(String[] files, int delay)
    throws IOException
  {
    parallelStartTime = System.currentTimeMillis();
    parallelThreadCount = files.length/2;
    parallelCount = 0;
    for (int i = 0; i < files.length; i+=2)
    {
      (new Thread(new LoadBalancing(files[i], files[i+1]))).start();
      try{Thread.sleep(delay);}catch(InterruptedException e){}
    }

    //Wait for the threads to finish, so the next test doesn't
    //run until this one is fully finished.
    while(parallelThreadCount > 0)
      try{Thread.sleep(2000);}catch(InterruptedException e){}
  }

  public LoadBalancing(String f, String u)
  {
    localfilename = f;
    url = u;
  }

  public synchronized static int decThreadCount() {return --parallelThreadCount;}
  public synchronized static void incCount(int i) {parallelCount += i;}
  public void run()
  {
      try
      {
        dowload(localfilename, url);
        incCount(0);
      }
      catch(Exception e) {e.printStackTrace();}
      if (decThreadCount() == 0)
        System.out.println("parallelTest: " + 
          (System.currentTimeMillis()-parallelStartTime));
  }

  public static void loadBalancedTest(String[] files, int numThreads)
    throws IOException
  {
    long time = System.currentTimeMillis();
    ActiveRequestQueue server = new ActiveRequestQueue(numThreads);
    for (int i = 0; i < files.length; i+=2)
    {
      server.acceptRequest(new Request(files[i], files[i+1]));
    }

    while(RequestResult.resultCount() < files.length/2)
      try{Thread.sleep(2000);}catch(InterruptedException e){}
        System.out.println("loadBalancedTest: " + (RequestResult.lastResultTime()-time));

    server.niceShutdown();
  }
}

class FIFO_Queue {
  java.util.Stack v = new java.util.Stack();
  public void add(Object o){v.push(o);}
  public Object pop(){return v.pop();}
  public boolean isEmpty(){return v.isEmpty();}
}

class RequestProcessor {
  public RequestResult processRequest(Request r)
  {
//    System.out.println("Processing request: " + r);
    int count = 0;
    String localfilename = r.localfilename;
    try
    {
      LoadBalancing.dowload(localfilename, r.url);
    }
    catch(Exception e) {e.printStackTrace();}
    return new RequestResult(count);
  }
}

class RequestResult
{
  static int totalCount;
  static int resultCount;
  static long lastResultTime;
  public RequestResult(int i)
  {
    totalCount += i;
    resultCount++;
    lastResultTime = System.currentTimeMillis();
  }
  public static int resultCount() {return resultCount;}
  public static int totalCount() {return totalCount;}
  public static long lastResultTime() {return lastResultTime;}
}

class Request
{
  String localfilename;
  String url;
  public Request(String f, String u)
  {
    localfilename = f;
    url = u;
  }
}

class SillyHttpServer
  implements Runnable
{
  static String HEADER = "HTTP/1.1 200 OK\r\n" +
    "Server: SillyHttpServer\r\n" + 
    "Content-type: text/text\r\n" + 
    "Expires: Tue, 29 Feb 2000 23:59:59 GMT\r\n\r\n";
  static byte[] HEADER_BYTES = HEADER.getBytes(); 

  public static final int SERVER_PORT = 15869;
  public static final int NUM_THREADS = 10;

  static ServerSocket serverSocket;
  static boolean notTerminated = true;
  static byte[] alwaysTheSame;
  static Random Rand = new Random();
  
  public static int rand1000()
  {
    return Rand.nextInt(500);
  }
  
  public static void stop()
    throws IOException
  {
    notTerminated = false;
    serverSocket.close();
  }

  public static void serve()
    throws IOException
  {
    serverSocket = new ServerSocket(SERVER_PORT);
    File f = new File("tuning");
    f = new File(f, "threads");
    f = new File(f, "LoadBalancing.java");
    int len = (int) f.length();
    alwaysTheSame = new byte[len];
    FileInputStream in = new FileInputStream(f);
    int readlen = 0;
    len = 0;
    while(readlen < alwaysTheSame.length)
    {
      len = in.read(alwaysTheSame, readlen, alwaysTheSame.length-readlen);
      if (len == -1)
        break;
      readlen += len;
    }
    in.close();

    for (int i = NUM_THREADS; i > 0; i--)
    {
      (new Thread(new SillyHttpServer())).start();
    }
  }

  public SillyHttpServer(){}

  public void run()
  {
    while(notTerminated)
    {
      try
      {
        //Simulate Internet connection latency
        try{Thread.sleep(rand1000());}catch(InterruptedException ie){}
        Socket s = serverSocket.accept();
        OutputStream out = s.getOutputStream();

        //First write the header
        try{Thread.sleep(rand1000());}catch(InterruptedException ie){}
        out.write(HEADER_BYTES);

        //serve up a random amount of 2k bytes, from half to full,
        //in 2k chunks with a random delay of 0 to 2 seconds
        int toWrite = alwaysTheSame.length/2;
        toWrite += (alwaysTheSame.length*Rand.nextInt(1000))/2000;
        toWrite = Math.min(alwaysTheSame.length, toWrite);
        int written = 0;
        while(written < toWrite)
        {
          try{Thread.sleep(rand1000());}catch(InterruptedException ie){}
          out.write(alwaysTheSame, written, (toWrite-written>2048)?2048:toWrite-written);
          written += 2048;
        }
        out.close();
        try{s.close();}catch(Exception es){}
      }
      catch(Exception e){System.out.println("SillyHttpServer: " + e);e.printStackTrace();}
    }
  }
}