package tuning.distrib.rmi;

import java.io.*;
import java.net.*;
import java.util.zip.*;

public class CodecOutputStream
  extends FilterOutputStream
{
  Deflater compressor;

  public CodecOutputStream(OutputStream out)
  {
    super(out);
    compressor = new Deflater(Deflater.BEST_SPEED);
  }

  public void write(int x)
    throws IOException
  {
    throw new IOException("CodeOutputStream.write(int) unsuppported");
  }

  public void write(byte[] b, int off, int len)
    throws IOException
  {
    int newlen = compressor.deflate(b, off, len);
    out.write(len);
    out.write(newlen);
System.out.println("Writing " + newlen);
    out.write(b, off, newlen);
    out.flush();
System.out.println("Flushed");
  }
}
