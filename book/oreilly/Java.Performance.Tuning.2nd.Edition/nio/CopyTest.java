package tuning.nio;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.net.*;

public class CopyTest
{
  public static void main(String[] args)
    throws Exception
  {
    String f1 = args[0];
    String f2 = args[1];
    test(f1,f2);
    test(f1,f2+'a');
  }

  public static void test(String f1 , String f2)
    throws Exception
  {
    bufferedReaderCopy(f1, f2+'1');
    bufferedInputStreamCopy(f1, f2+'2');
    explicitBufferInputStreamCopy(f1, f2+'3');
    nonDirectBufferCopy(f1, f2+'4');
    directBufferCopy(f1, f2+'5');
    mappedBufferCopy(f1, f2+'6');
    directTransferCopy(f1, f2+'7');
  }

  public static void bufferedReaderCopy(String f1, String f2)
    throws Exception
  {
    long time = System.currentTimeMillis();
    BufferedReader rdr = new BufferedReader(new FileReader(f1), 16*1024);
    BufferedWriter wrtr = new BufferedWriter(new FileWriter(f2), 16*1024);
    int c;
    while( (c = rdr.read()) != -1)
    {
      wrtr.write(c);
    }
    rdr.close();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    System.out.println(" bufferedReaderCopy time: " + time);
  }

  public static void bufferedInputStreamCopy(String f1, String f2)
    throws Exception
  {
    long time = System.currentTimeMillis();
    BufferedInputStream rdr = new BufferedInputStream(new FileInputStream(f1), 16*1024);
    BufferedOutputStream wrtr = new BufferedOutputStream(new FileOutputStream(f2), 16*1024);
    int c;
    while( (c = rdr.read()) != -1)
    {
      wrtr.write(c);
    }
    rdr.close();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    System.out.println(" bufferedInputStreamCopy time: " + time);
  }

  public static void explicitBufferInputStreamCopy(String f1, String f2)
    throws Exception
  {
    long time = System.currentTimeMillis();
    byte[] buffer = new byte[1024*16];
    FileInputStream rdr = new FileInputStream(f1);
    FileOutputStream wrtr = new FileOutputStream(f2);
    int readLen;
    while( (readLen = rdr.read(buffer)) != -1)
    {
      wrtr.write(buffer, 0, readLen);
    }
    rdr.close();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    System.out.println(" explicitBufferInputStreamCopy time: " + time);
  }

  public static void nonDirectBufferCopy(String f1, String f2)
    throws Exception
  {
    long time = System.currentTimeMillis();
    ByteBuffer buffer = ByteBuffer.allocate(16*1024);
    FileChannel rdr = (new FileInputStream(f1)).getChannel();
    FileChannel wrtr = (new FileOutputStream(f2)).getChannel();
    while( rdr.read(buffer) > 0)
    {
      buffer.flip();
      wrtr.write(buffer);
      buffer.clear();
    }
    rdr.close();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    System.out.println(" nonDirectBufferCopy time: " + time);
  }

  public static void directBufferCopy(String f1, String f2)
    throws Exception
  {
    long time = System.currentTimeMillis();
    ByteBuffer buffer = ByteBuffer.allocateDirect(16*1024);
    FileChannel rdr = (new FileInputStream(f1)).getChannel();
    FileChannel wrtr = (new FileOutputStream(f2)).getChannel();
    while( rdr.read(buffer) > 0)
    {
      buffer.flip();
      wrtr.write(buffer);
      buffer.clear();
    }
    rdr.close();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    System.out.println(" directBufferCopy time: " + time);
  }

  public static void mappedBufferCopy(String f1, String f2)
    throws Exception
  {
    long time = System.currentTimeMillis();
    FileChannel rdr = (new FileInputStream(f1)).getChannel();
    FileChannel wrtr = (new FileOutputStream(f2)).getChannel();
    ByteBuffer buffer = rdr.map(FileChannel.MapMode.READ_ONLY, 0, (int) rdr.size());
    wrtr.write(buffer);
    rdr.close();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    System.out.println(" mappedBufferCopy time: " + time);
  }

  public static void directTransferCopy(String f1, String f2)
    throws Exception
  {
    long time = System.currentTimeMillis();
    FileChannel rdr = (new FileInputStream(f1)).getChannel();
    FileChannel wrtr = (new FileOutputStream(f2)).getChannel();
    rdr.transferTo(0, (int) rdr.size(), wrtr);
    rdr.close();
    wrtr.close();
    time = System.currentTimeMillis() - time;
    System.out.println(" directTransferCopy time: " + time);
  }

}

