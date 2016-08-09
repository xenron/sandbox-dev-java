package tuning.nio;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.net.*;


public class Transfer3
  implements Runnable
{
  static int NUM_FLOATS = 200000;
  static float[] FloatArray = new float[NUM_FLOATS];
  static int BYTE_SIZE = NUM_FLOATS*4;
  static byte[] ByteArray = new byte[BYTE_SIZE];
  static byte[] ByteArray2 = new byte[BYTE_SIZE];
  static ByteBuffer inByteBuffer = ByteBuffer.wrap(ByteArray);
  static ByteBuffer outByteBuffer = ByteBuffer.wrap(ByteArray);
  static FloatBuffer inFloatBuffer = inByteBuffer.asFloatBuffer();
  static FloatBuffer outFloatBuffer = outByteBuffer.asFloatBuffer();

  static int PORT = 34573;

  public static void main(String[] args)
    throws Exception
  {
    createFloats();
    test(args);
  }

  public static void createFloats()
  {
    for (int i =0; i < FloatArray.length; i++)
      FloatArray[i] = ((float) i)/3.2567F;
  }

  public static void test(String[] args)
    throws Exception
  {
    (new Thread(new Transfer3())).start();
    serverTest();
  }

  public void run()
  {
    try{clientTest();}
    catch(Exception e){e.printStackTrace();}
  }

  public static void clientTest()
    throws Exception
  {
    niotestClient();
    pause();
    oldtestClient2();
    pause();
    oldtestClient();
    pause();
    niotestClient();
    pause();
    oldtestClient2();
    pause();
    oldtestClient();
  }

  public static void pause()
    throws Exception
  {
    Thread.sleep(5000);
  }

  public static void serverTest()
    throws Exception
  {
    niotestServer();
    pause();
    oldtestServer2();
    pause();
    oldtestServer();
    pause();
    niotestServer();
    pause();
    oldtestServer2();
    pause();
    oldtestServer();
  }

  public static void oldtestServer()
    throws Exception
  {
    ServerSocket server = new ServerSocket(PORT);
    Socket client = server.accept();

    InputStream istream = client.getInputStream();

    long time = System.currentTimeMillis();
    DataInputStream rdr = new DataInputStream(istream);
    int len = rdr.readInt();
    float[] allFloats = new float[len];
    for (int i = 0; i < len ; i++)
    {
      allFloats[i] = rdr.readFloat();
    }
    rdr.close();
    time = System.currentTimeMillis() - time;
    client.close();
    server.close();
    System.out.println("Looped reading of floats from socket: " + time);

    allFloats = null;
    System.gc();
  }

  public static void oldtestClient()
    throws Exception
  {
    Socket client = new Socket("localhost", PORT);
    OutputStream out = client.getOutputStream();
 
    long time = System.currentTimeMillis();
    DataOutputStream wrtr = new DataOutputStream(out);
    wrtr.writeInt(FloatArray.length);
    for (int i = 0; i < FloatArray.length ; i++)
    {
      wrtr.writeFloat(FloatArray[i]);
    }
    wrtr.flush();
    wrtr.close();
    client.close();
    time = System.currentTimeMillis() - time;
    System.out.println("Looped writing of floats to socket: " + time);
  }

  public static void oldtestServer2()
    throws Exception
  {
    ServerSocket server = new ServerSocket(PORT);
    Socket client = server.accept();

    InputStream istream = client.getInputStream();

    long time = System.currentTimeMillis();
    ObjectInputStream rdr = new ObjectInputStream(istream);
    float[] allFloats = (float[]) rdr.readObject();
    rdr.close();
    time = System.currentTimeMillis() - time;
    client.close();
    server.close();
    System.out.println("reading of float array from socket: " + time);

    allFloats = null;
    System.gc();
  }

  public static void oldtestClient2()
    throws Exception
  {
    Socket client = new Socket("localhost", PORT);
    OutputStream out = client.getOutputStream();
 
    long time = System.currentTimeMillis();
    ObjectOutputStream wrtr = new ObjectOutputStream(out);
    wrtr.writeObject(FloatArray);
    wrtr.flush();
    wrtr.close();
    client.close();
    time = System.currentTimeMillis() - time;
    System.out.println("writing of float array to socket: " + time);
  }

  public static void niotestServer()
    throws Exception
  {
    inFloatBuffer.clear();
    ServerSocket server = new ServerSocket(PORT);
    Socket client = server.accept();
    InputStream istream = client.getInputStream();
 
    long time = System.currentTimeMillis();
    DataInputStream rdr = new DataInputStream(istream);
    int len = rdr.readInt();
    float[] allFloats = new float[len];
    rdr.readFully(ByteArray, 0, len*4);
    inFloatBuffer.get(allFloats, 0, len);
    time = System.currentTimeMillis() - time;
    rdr.close();
    client.close();
    server.close();
    System.out.println("Reading of floats into buffer: " + time);

    allFloats = null;
    System.gc();
  }

  public static void niotestClient()
    throws Exception
  {
    outFloatBuffer.clear();
    Socket client = new Socket("localhost", PORT);
    OutputStream out = client.getOutputStream();

    long time = System.currentTimeMillis();
    DataOutputStream wrtr = new DataOutputStream(out);
    outFloatBuffer.put(FloatArray, 0, FloatArray.length);
    wrtr.writeInt(FloatArray.length);
    wrtr.write(ByteArray, 0, FloatArray.length*4);
    wrtr.flush();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    client.close();
    System.out.println("Writing of objects to buffer: " + time);
  }


}
