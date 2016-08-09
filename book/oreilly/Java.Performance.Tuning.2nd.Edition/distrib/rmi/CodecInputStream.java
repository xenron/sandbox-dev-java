package tuning.distrib.rmi;

import java.io.*;
import java.net.*;
import java.util.zip.*;

public class CodecInputStream
  extends FilterInputStream
{
  byte[] buffer;
  int bufferSize;
  int bufferOffset;
  Inflater decompressor;

  public CodecInputStream(InputStream in)
  {
    super(in);
    decompressor = new Inflater();
    buffer = new byte[8192];
    bufferSize = 0;
    bufferOffset = 0;
  }

  public int available()
    throws IOException
  {
System.out.println("r0");
    if (bufferOffset >= bufferSize)
      return in.available();
    else
      return bufferSize - bufferOffset;
  }

  public int read(int x)
    throws IOException
  {
    if (bufferOffset >= bufferSize)
      getNextChunk();
    return buffer[bufferOffset++];
  }

  public int read(byte[] b, int off, int len)
    throws IOException
  {
    if (bufferOffset >= bufferSize)
      getNextChunk();
    if (bufferSize-bufferOffset < len)
      len = bufferSize-bufferOffset;
    System.arraycopy(buffer, bufferOffset, b, off, len);
    bufferOffset += len;
    return len;
  }

  private void getNextChunk()
    throws IOException
  {
System.out.println("r1");
    //Buffer is empty if this method gets called
    int oldlen = in.read();
System.out.println("r2");
    //assume buffer is big enough.
    //I should test and grow it if its larger than oldlen
    if (buffer.length < oldlen)
      throw new IOException("buffer too small");
    int newlen = in.read();
System.out.println("r3");
    int readlen = 0;
    int len;
    while(readlen < newlen)
    {
System.out.println(readlen + " of " + newlen);
      len = in.read(buffer, readlen, newlen-readlen);
      if (len == -1)
        throw new IOException("End of stream");
      else
        readlen += len;
    }
System.out.println(readlen + " of " + newlen);
    int deflateLen = 0;
    try
    {
      deflateLen = decompressor.inflate(buffer, 0, readlen);
    }
    catch (DataFormatException e){throw new IOException(e.toString());}
System.out.println("deflated");
    //deflateLen should be the same as oldlen
    if (deflateLen != oldlen)
      throw new IOException("codec size error");

    bufferSize = deflateLen;
    bufferOffset = 0;
  }
}
