package tuning.socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;

public class SockInStreamLogger extends InputStream
{
  Socket s;
  InputStream in;
  byte[] one_byte = new byte[1];
  public SockInStreamLogger(Socket so, InputStream i){in = i; s = so;}
  public int available() throws IOException {return in.available();}
  public void close() throws IOException {in.close();}
  public void mark(int readlimit) {in.mark(readlimit);}
  public boolean markSupported() {return in.markSupported();}
  public int read() throws IOException {
    int ret = in.read();
    one_byte[0] = (byte) ret;
    //SockStreamLogger.read(s, 1, one_byte, 0);
    return ret;
  }
  public int read(byte b[]) throws IOException {
    int sz = in.read(b);
    SockStreamLogger.read(s, sz, b, 0);
    return sz;
  }
  public int read(byte b[], int off, int len) throws IOException {
    int sz = in.read(b, off, len);
    SockStreamLogger.read(s, sz, b, off);
    return sz;
  }
  public void reset() throws IOException {in.reset();}
  public long skip(long n) throws IOException {return in.skip(n);}
}
