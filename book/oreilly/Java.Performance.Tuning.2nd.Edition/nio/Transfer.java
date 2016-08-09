package tuning.nio;

import java.io.*;
import java.nio.*;


public class Transfer
  implements Runnable
{
  public static void main(String[] args)
    throws Exception
  {
    createFloats();
    test();
  }
  public static void test()
    throws Exception
  {
    niotest();
    oldtest();
    oldtest2();
  }

  static int BYTE_SIZE = 4000000;
  static float[] FloatArray = new float[1000000];
  static byte[] ByteArray = new byte[BYTE_SIZE];
  static FloatBuffer inFloatBuffer = ByteBuffer.wrap(ByteArray).asFloatBuffer();
  public static void createFloats()
  {
    for (int i =0; i < FloatArray.length; i++)
      FloatArray[i] = ((float) i)/3.2567F;
  }

  public static void niotest()
    throws Exception
  {
    System.out.println("Testing nio write");
    MyByteArrayOutputStream buf = Buff;
    buf.reset();
    inFloatBuffer.clear();

    long time = System.currentTimeMillis();
    DataOutputStream wrtr = new DataOutputStream(buf);
    inFloatBuffer.put(FloatArray, 0, FloatArray.length);
    wrtr.writeInt(FloatArray.length);
    wrtr.write(ByteArray);
    wrtr.flush();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("Writing of objects to buffer: " + time);

    InputStream istream = new ByteArrayInputStream(buf.getBuffer());
    System.out.println(" buffer size: " + buf.getBuffer().length);

    time = System.currentTimeMillis();
    DataInputStream rdr = new DataInputStream(istream);
    inFloatBuffer.clear();
    int len = rdr.readInt();
    float[] allFloats = new float[len];
    rdr.readFully(ByteArray, 0, len*4);
    inFloatBuffer.get(allFloats, 0, len);
    rdr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("Reading of objects from buffer: " + time);
    System.out.println("Reading idx 17: " + allFloats [17]);

    buf = null;
    wrtr = null;
    istream = null;
    rdr = null;
    allFloats = null;
    System.gc();
  }

  static MyByteArrayOutputStream Buff = new MyByteArrayOutputStream(BYTE_SIZE);
  public static void oldtest()
    throws Exception
  {
    System.out.println("Testing iterative write");
    MyByteArrayOutputStream buf = Buff;
    buf.reset();

    long time = System.currentTimeMillis();
    DataOutputStream wrtr = new DataOutputStream(buf);
    wrtr.writeInt(FloatArray.length);
    for (int i = 0; i < FloatArray.length ; i++)
      wrtr.writeFloat(FloatArray[i]);
    wrtr.flush();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("Writing of objects to buffer: " + time);

    InputStream istream = new ByteArrayInputStream(buf.getBuffer());
    System.out.println(" buffer size: " + buf.getBuffer().length);

    time = System.currentTimeMillis();
    DataInputStream rdr = new DataInputStream(istream);
    int len = rdr.readInt();
    float[] allFloats = new float[len];
    for (int i = 0; i < len ; i++)
    {
      allFloats[i] = rdr.readFloat();
    }
    rdr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("Reading of objects from buffer: " + time);
    System.out.println("Reading idx 17: " + allFloats [17]);

    buf = null;
    wrtr = null;
    istream = null;
    rdr = null;
    allFloats = null;
    System.gc();
  }

  public static void oldtest2()
    throws Exception
  {
    System.out.println("Testing object write");
    MyByteArrayOutputStream buf = Buff;
    buf.reset();

    long time = System.currentTimeMillis();
    ObjectOutputStream wrtr = new ObjectOutputStream(buf);
    wrtr.writeObject(FloatArray);
    wrtr.flush();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("Writing of objects to buffer: " + time);

    InputStream istream = new ByteArrayInputStream(buf.getBuffer());
    System.out.println(" buffer size: " + buf.getBuffer().length);

    time = System.currentTimeMillis();
    ObjectInputStream rdr = new ObjectInputStream(istream);
    float[] allFloats = (float[]) rdr.readObject();
    rdr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("Reading of objects from buffer: " + time);
    System.out.println("Reading idx 17: " + allFloats [17]);

    buf = null;
    wrtr = null;
    istream = null;
    rdr = null;
    allFloats = null;
    System.gc();
  }
}

class MyByteArrayOutputStream
  extends ByteArrayOutputStream
{
  public MyByteArrayOutputStream(int size){super(size);}
  public byte[] getBuffer() {return buf;}
}

