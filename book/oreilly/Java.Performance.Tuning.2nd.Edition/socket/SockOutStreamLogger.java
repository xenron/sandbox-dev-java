package tuning.socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;

public class SockOutStreamLogger extends OutputStream
{
  Socket s;
  OutputStream out;
  byte[] one_byte = new byte[1];
  public SockOutStreamLogger(Socket so, OutputStream o){out = o; s = so;}
  public void write(int b) throws IOException {
    out.write(b);
    one_byte[0] = (byte) b;
    SockStreamLogger.written(s, 1, one_byte, 0);
  }
  public void write(byte b[]) throws IOException {
    out.write(b);
    SockStreamLogger.written(s, b.length, b, 0);
  }
  public void write(byte b[], int off, int len) throws IOException {
    out.write(b, off, len);
    SockStreamLogger.written(s, len, b, off);
  }
  public void flush() throws IOException {out.flush();}
  public void close() throws IOException {out.close();}
}
