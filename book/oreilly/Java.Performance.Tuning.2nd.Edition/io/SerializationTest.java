package tuning.io;

//lazy init

import java.io.*;
import java.util.*;

class Foo1
  implements Serializable
{
  int one;
  String two;
  Bar1[] four;

  public Foo1()
  {
//    try{Thread.sleep(100);}catch(Exception e){}
    two = new String("START");
    one = two.length();
    four = new Bar1[2];
    four[0] = new Bar1();
    four[1] = new Bar1();
  }
}

class Bar1
  implements Serializable
{
  float one;
  String two;
  public Bar1()
  {
    two = new String("hello");
    one = 3.14F;
  }
}


class Foo2
  implements Serializable
{
  int one;
  String two;
  Bar2[] four;

  public Foo2()
  {
    two = new String("START");
    one = two.length();
    four = new Bar2[2];
    four[0] = new Bar2();
    four[1] = new Bar2();
  }
  private void writeObject(java.io.ObjectOutputStream out)
    throws IOException
  {
    out.writeUTF(two);
    out.writeInt(one);
    out.writeObject(four);
  }
  private void readObject(java.io.ObjectInputStream in)
    throws IOException, ClassNotFoundException
  {
    two = in.readUTF();
    one = in.readInt();
    four = (Bar2[]) in.readObject();
  }
}

class Bar2
  implements Serializable
{
  float one;
  String two;
  public Bar2()
  {
    two = new String("hello");
    one = 3.14F;
  }
  private void writeObject(java.io.ObjectOutputStream out)
    throws IOException
  {
    out.writeUTF(two);
    out.writeFloat(one);
  }
  private void readObject(java.io.ObjectInputStream in)
    throws IOException, ClassNotFoundException
  {
    two = in.readUTF();
    one = in.readFloat();
  }
}

class Foo3
  implements Serializable
{
  int one;
  String two;
  Bar3[] four;

  public Foo3()
  {
  }
  public Foo3(boolean init)
  {
    this();
    if (init)
      init();
  }
  public void init()
  {
    two = new String("START");
    one = two.length();
    four = new Bar3[2];
    four[0] = new Bar3();
    four[1] = new Bar3();
  }
  private void writeObject(java.io.ObjectOutputStream out)
    throws IOException
  {
    out.writeUTF(two);
    out.writeInt(one);
    out.writeUTF(four[0].two);
    out.writeFloat(four[0].one);
    out.writeUTF(four[1].two);
    out.writeFloat(four[1].one);
  }
  private void readObject(java.io.ObjectInputStream in)
    throws IOException, ClassNotFoundException
  {
    two = in.readUTF();
    one = in.readInt();
    four = new Bar3[2];
    four[0] = new Bar3();
    four[1] = new Bar3();
    four[0].two = in.readUTF();
    four[0].one = in.readFloat();
    four[1].two = in.readUTF();
    four[1].one = in.readFloat();
  }
}

class Bar3
  implements Serializable
{
  float one;
  String two;
  public Bar3()
  {
    two = new String("hello");
    one = 3.14F;
  }
}


class Foo4
  implements Externalizable
{
  int one;
  String two;
  Bar4[] four;

  public Foo4()
  {
  }
  public Foo4(boolean init)
  {
    this();
    if (init)
      init();
  }
  public void init()
  {
    two = new String("START");
    one = two.length();
    four = new Bar4[2];
    four[0] = new Bar4();
    four[1] = new Bar4();
  }
  public void writeExternal(java.io.ObjectOutput out)
    throws IOException
  {
    out.writeUTF(two);
    out.writeInt(one);
    out.writeUTF(four[0].two);
    out.writeFloat(four[0].one);
    out.writeUTF(four[1].two);
    out.writeFloat(four[1].one);
  }
  public void readExternal(java.io.ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    two = in.readUTF();
    one = in.readInt();
    four = new Bar4[2];
    four[0] = new Bar4();
    four[1] = new Bar4();
    four[0].two = in.readUTF();
    four[0].one = in.readFloat();
    four[1].two = in.readUTF();
    four[1].one = in.readFloat();
  }
}

class Bar4
  implements Serializable
{
  float one;
  String two;
  public Bar4()
  {
    two = new String("hello");
    one = 3.14F;
  }
}

class MyDataOutputStream extends DataOutputStream
{
  public MyDataOutputStream(OutputStream out){super(out);}
  public int written(){return written;}
}

class Foo5
{
  int one;
  String two;
  Bar5[] four;
  byte[] buffer;

  public Foo5()
  {
  }
  public Foo5(boolean init)
  {
    this();
    if (init)
      init();
  }
  public void init()
  {
    two = new String("START");
    one = two.length();
    four = new Bar5[2];
    four[0] = new Bar5();
    four[1] = new Bar5();
  }
  public void writeExternal(MyDataOutputStream out, DataOutputStream outSizes)
    throws IOException
  {
    int size = out.written();
    out.writeUTF(two);
    out.writeInt(one);
    out.writeUTF(four[0].two);
    out.writeFloat(four[0].one);
    out.writeUTF(four[1].two);
    out.writeFloat(four[1].one);
    size = out.written() - size;
    outSizes.writeInt(size);
  }
  public void readExternal(InputStream in, DataInputStream inSizes)
    throws IOException
  {
    int size = inSizes.readInt();
    buffer = new byte[size];
    int len;
    int readlen = in.read(buffer);
    if (readlen == -1)
      throw new IOException("expected more bytes");
    else
      while(readlen < buffer.length)
      {
        len = in.read(buffer, readlen, buffer.length-readlen);
        if (len < 1)
          throw new IOException("expected more bytes");
        else
          readlen += len;
      }
  }
  public void convert()
    throws IOException
  {
    DataInputStream in = new DataInputStream(new ByteArrayInputStream(buffer));
    two = in.readUTF();
    one = in.readInt();
    four = new Bar5[2];
    four[0] = new Bar5();
    four[1] = new Bar5();
    four[0].two = in.readUTF();
    four[0].one = in.readFloat();
    four[1].two = in.readUTF();
    four[1].one = in.readFloat();
    buffer = null;
  }
}

class Bar5
  implements Serializable
{
  float one;
  String two;
  public Bar5()
  {
    two = new String("hello");
    one = 3.14F;
  }
}


class MyByteArrayOutputStream
  extends ByteArrayOutputStream
{
  public MyByteArrayOutputStream(int size){super(size);}
  public byte[] getBuffer() {return buf;}
}

public class SerializationTest
{

  static Foo1[] lotsOfFoo1s;
  static Foo2[] lotsOfFoo2s;
  static Foo3[] lotsOfFoo3s;
  static Foo4[] lotsOfFoo4s;
  static Foo5[] lotsOfFoo5s;
  public static void createFoos(int numFoos)
  {
    lotsOfFoo1s = new Foo1[numFoos];
    lotsOfFoo2s = new Foo2[numFoos];
    lotsOfFoo3s = new Foo3[numFoos];
    lotsOfFoo4s = new Foo4[numFoos];
    lotsOfFoo5s = new Foo5[numFoos];
    for (int i = numFoos-1; i >= 0; i--)
    {
      lotsOfFoo1s[i] = new Foo1();
      lotsOfFoo2s[i] = new Foo2();
      lotsOfFoo3s[i] = new Foo3(true);
      lotsOfFoo4s[i] = new Foo4(true);
      lotsOfFoo5s[i] = new Foo5(true);
    }
  }

  public static void main(String[] args)
  {
    try
    {
      MyByteArrayOutputStream buf = new MyByteArrayOutputStream(2500000);
      createFoos(Integer.parseInt(args[0]));
      test1a(buf);
      test1b();
      System.out.println("---------------------------------------------------");

      test5a(buf);
      test5b();
      test4c(buf);
      test4d();
      test4a(buf);
      test4b();
      test3a(buf);
      test3b();
      test2a(buf);
      test2b();
      test1a(buf);
      test1b();
    }
    catch(Exception e){e.printStackTrace();}
  }

  public static void test1a(MyByteArrayOutputStream buf)
    throws Exception
  {
    System.out.println("test1a: stream array to byte array");
    buf.reset();
    ObjectOutputStream wrtr = new ObjectOutputStream(buf);

    long time = System.currentTimeMillis();
    wrtr.writeObject(lotsOfFoo1s);
    wrtr.flush();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test1a: Writing of objects to buffer: " + time);

    InputStream istream = new ByteArrayInputStream(buf.getBuffer());
    ObjectInputStream rdr = new ObjectInputStream(istream);

    time = System.currentTimeMillis();
    Foo1[] allFoos = (Foo1[]) rdr.readObject();
    rdr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test1a: Reading of objects from buffer: " + time);
    System.gc();
  }

  public static void test1b()
    throws Exception
  {
    System.out.println("test1b: stream array to disk with buffering");
    FileOutputStream ostream = new FileOutputStream("t.tmp");
    ObjectOutputStream wrtr = new ObjectOutputStream(new BufferedOutputStream(ostream));

    long time = System.currentTimeMillis();
    wrtr.writeObject(lotsOfFoo1s);
    wrtr.flush();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test1b: Writing of objects to buffered disk: " + time);

    FileInputStream istream = new FileInputStream("t.tmp");
    ObjectInputStream rdr = new ObjectInputStream(new BufferedInputStream(istream));

    time = System.currentTimeMillis();
    Foo1[] allFoos = (Foo1[]) rdr.readObject();
    rdr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test1b: Reading of objects from buffered disk: " + time);
    System.gc();
  }

  public static void test2a(MyByteArrayOutputStream buf)
    throws Exception
  {
    System.out.println("test2a: stream array to byte array with customized read/write object");
    buf.reset();
    ObjectOutputStream wrtr = new ObjectOutputStream(buf);

    long time = System.currentTimeMillis();
    wrtr.writeObject(lotsOfFoo2s);
    wrtr.flush();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test2a: Writing of objects to buffer: " + time);

    InputStream istream = new ByteArrayInputStream(buf.getBuffer());
    ObjectInputStream rdr = new ObjectInputStream(istream);

    time = System.currentTimeMillis();
    Foo2[] allFoos = (Foo2[]) rdr.readObject();
    rdr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test2a: Reading of objects from buffer: " + time);
    System.gc();
  }

  public static void test2b()
    throws Exception
  {
    System.out.println("test2b: stream array to disk with buffering and customized read/write object");
    FileOutputStream ostream = new FileOutputStream("t.tmp");
    ObjectOutputStream wrtr = new ObjectOutputStream(new BufferedOutputStream(ostream));

    long time = System.currentTimeMillis();
    wrtr.writeObject(lotsOfFoo2s);
    wrtr.flush();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test2b: Writing of objects to buffered disk: " + time);

    FileInputStream istream = new FileInputStream("t.tmp");
    ObjectInputStream rdr = new ObjectInputStream(new BufferedInputStream(istream));

    time = System.currentTimeMillis();
    Foo2[] allFoos = (Foo2[]) rdr.readObject();
    rdr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test2b: Reading of objects from buffered disk: " + time);
    System.gc();
  }

  public static void test3a(MyByteArrayOutputStream buf)
    throws Exception
  {
    System.out.println("test3a: stream array to byte array with customized read/write object");
    buf.reset();
    ObjectOutputStream wrtr = new ObjectOutputStream(buf);

    long time = System.currentTimeMillis();
    wrtr.writeObject(lotsOfFoo3s);
    wrtr.flush();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test3a: Writing of objects to buffer: " + time);

    InputStream istream = new ByteArrayInputStream(buf.getBuffer());
    ObjectInputStream rdr = new ObjectInputStream(istream);

    time = System.currentTimeMillis();
    Foo3[] allFoos = (Foo3[]) rdr.readObject();
    rdr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test3a: Reading of objects from buffer: " + time);
    System.gc();
  }

  public static void test3b()
    throws Exception
  {
    System.out.println("test3b: stream array to disk with buffering and customized read/write object");
    FileOutputStream ostream = new FileOutputStream("t.tmp");
    ObjectOutputStream wrtr = new ObjectOutputStream(new BufferedOutputStream(ostream));

    long time = System.currentTimeMillis();
    wrtr.writeObject(lotsOfFoo3s);
    wrtr.flush();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test3b: Writing of objects to buffered disk: " + time);

    FileInputStream istream = new FileInputStream("t.tmp");
    ObjectInputStream rdr = new ObjectInputStream(new BufferedInputStream(istream));

    time = System.currentTimeMillis();
    Foo3[] allFoos = (Foo3[]) rdr.readObject();
    rdr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test3b: Reading of objects from buffered disk: " + time);
    System.gc();
  }

  public static void test4a(MyByteArrayOutputStream buf)
    throws Exception
  {
    System.out.println("test4a: stream array to byte array with customized read/write object");
    buf.reset();
    ObjectOutputStream wrtr = new ObjectOutputStream(buf);

    long time = System.currentTimeMillis();
    wrtr.writeObject(lotsOfFoo4s);
    wrtr.flush();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test4a: Writing of objects to buffer: " + time);

    InputStream istream = new ByteArrayInputStream(buf.getBuffer());
    ObjectInputStream rdr = new ObjectInputStream(istream);

    time = System.currentTimeMillis();
    Foo4[] allFoos = (Foo4[]) rdr.readObject();
    rdr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test4a: Reading of objects from buffer: " + time);
    System.gc();
  }

  public static void test4b()
    throws Exception
  {
    System.out.println("test4b: stream array to disk with buffering and customized read/write object");
    FileOutputStream ostream = new FileOutputStream("t.tmp");
    ObjectOutputStream wrtr = new ObjectOutputStream(new BufferedOutputStream(ostream));

    long time = System.currentTimeMillis();
    wrtr.writeObject(lotsOfFoo4s);
    wrtr.flush();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test4b: Writing of objects to buffered disk: " + time);

    FileInputStream istream = new FileInputStream("t.tmp");
    ObjectInputStream rdr = new ObjectInputStream(new BufferedInputStream(istream));

    time = System.currentTimeMillis();
    Foo4[] allFoos = (Foo4[]) rdr.readObject();
    rdr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test4b: Reading of objects from buffered disk: " + time);
    System.gc();
  }

  public static void test4c(MyByteArrayOutputStream buf)
    throws Exception
  {
    System.out.println("test4c: stream array to byte array with customized read/write object");
    buf.reset();
    ObjectOutputStream wrtr = new ObjectOutputStream(buf);

    long time = System.currentTimeMillis();
    wrtr.writeInt(lotsOfFoo4s.length);
    for (int i = 0; i < lotsOfFoo4s.length ; i++)
      lotsOfFoo4s[i].writeExternal(wrtr);
    wrtr.flush();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test4c: Writing of objects to buffer: " + time);

    InputStream istream = new ByteArrayInputStream(buf.getBuffer());
    ObjectInputStream rdr = new ObjectInputStream(istream);

    time = System.currentTimeMillis();
    int len = rdr.readInt();
    Foo4[] allFoos = new Foo4[len];
    Foo4 foo;
    for (int i = 0; i < len ; i++)
    {
      foo = new Foo4();
      foo.readExternal(rdr);
      allFoos[i] = foo;
    }
    rdr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test4c: Reading of objects from buffer: " + time);
    System.gc();
  }

  public static void test4d()
    throws Exception
  {
    System.out.println("test4d: stream array to disk with buffering and customized read/write object");
    FileOutputStream ostream = new FileOutputStream("t.tmp");
    ObjectOutputStream wrtr = new ObjectOutputStream(new BufferedOutputStream(ostream));

    long time = System.currentTimeMillis();
    wrtr.writeInt(lotsOfFoo4s.length);
    for (int i = 0; i < lotsOfFoo4s.length ; i++)
      lotsOfFoo4s[i].writeExternal(wrtr);
    wrtr.flush();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test4d: Writing of objects to buffered disk: " + time);

    FileInputStream istream = new FileInputStream("t.tmp");
    ObjectInputStream rdr = new ObjectInputStream(new BufferedInputStream(istream));

    time = System.currentTimeMillis();
    int len = rdr.readInt();
    Foo4[] allFoos = new Foo4[len];
    Foo4 foo;
    for (int i = 0; i < len ; i++)
    {
      foo = new Foo4();
      foo.readExternal(rdr);
      allFoos[i] = foo;
    }
    rdr.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test4d: Reading of objects from buffered disk: " + time);
    System.gc();
  }

  public static void test5a(MyByteArrayOutputStream buf)
    throws Exception
  {
    System.out.println("test5a: stream array to byte array with customized read/write object");
    buf.reset();
    MyDataOutputStream wrtr = new MyDataOutputStream(buf);
    MyByteArrayOutputStream buf2 = new MyByteArrayOutputStream(100);
    DataOutputStream wrtr2 = new DataOutputStream(buf2);

    long time = System.currentTimeMillis();
    wrtr.writeInt(lotsOfFoo5s.length);
    for (int i = 0; i < lotsOfFoo5s.length ; i++)
      lotsOfFoo5s[i].writeExternal(wrtr, wrtr2);
    wrtr.flush();
    wrtr.close();
    wrtr2.flush();
    wrtr2.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test5a: Writing of objects to buffer: " + time);

    InputStream istream = new ByteArrayInputStream(buf.getBuffer());
    DataInputStream rdr = new DataInputStream(istream);
    istream = new ByteArrayInputStream(buf2.getBuffer());
    DataInputStream rdr2 = new DataInputStream(istream);

    time = System.currentTimeMillis();
    int len = rdr.readInt();
    Foo5[] allFoos = new Foo5[len];
    Foo5 foo;
    for (int i = 0; i < len ; i++)
    {
      foo = new Foo5();
      foo.readExternal(rdr, rdr2);
      allFoos[i] = foo;
    }
    rdr.close();
    rdr2.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test5a: Reading of objects from buffer: " + time);

    for (int i = 0; i < len ; i++)
      allFoos[i].convert();
    System.gc();
  }

  public static void test5b()
    throws Exception
  {
    System.out.println("test5b: stream array to disk with buffering and customized read/write object");
    FileOutputStream ostream = new FileOutputStream("t.tmp");
    MyDataOutputStream wrtr = new MyDataOutputStream(new BufferedOutputStream(ostream));
    ostream = new FileOutputStream("t2.tmp");
    DataOutputStream wrtr2 = new DataOutputStream(new BufferedOutputStream(ostream));

    long time = System.currentTimeMillis();
    wrtr.writeInt(lotsOfFoo5s.length);
    for (int i = 0; i < lotsOfFoo5s.length ; i++)
      lotsOfFoo5s[i].writeExternal(wrtr, wrtr2);
    wrtr.flush();
    wrtr.close();
    wrtr2.flush();
    wrtr2.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test5b: Writing of objects to buffered disk: " + time);

    FileInputStream istream = new FileInputStream("t.tmp");
    DataInputStream rdr = new DataInputStream(new BufferedInputStream(istream));
    istream = new FileInputStream("t2.tmp");
    DataInputStream rdr2 = new DataInputStream(new BufferedInputStream(istream));

    time = System.currentTimeMillis();
    int len = rdr.readInt();
    Foo5[] allFoos = new Foo5[len];
    Foo5 foo;
    for (int i = 0; i < len ; i++)
    {
      foo = new Foo5();
      foo.readExternal(rdr, rdr2);
      allFoos[i] = foo;
    }
    rdr.close();
    rdr2.close();
    time = System.currentTimeMillis() - time;
    System.out.println("test4d: Reading of objects from buffered disk: " + time);

    for (int i = 0; i < len ; i++)
      allFoos[i].convert();
    System.gc();
  }

}
