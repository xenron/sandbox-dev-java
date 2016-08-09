package tuning.console;

  public class PrintWrapper
  extends java.io.PrintStream
{
  java.io.PrintStream wrappedOut;
  public static boolean TUNING = false;

  public static void install()
  {
    System.setOut(new PrintWrapper(System.out));
    System.setErr(new PrintWrapper(System.err));
  }

  public PrintWrapper(java.io.PrintStream out)
  {
    super(out);
    wrappedOut = out;
  }

  public boolean checkError() {return wrappedOut.checkError();}
  public void close() {wrappedOut.close();}
  public void flush() {wrappedOut.flush();}
  public void print(boolean x) {if (!TUNING) if (!TUNING) wrappedOut.print(x);}
  public void print(char x) {if (!TUNING) wrappedOut.print(x);}
  public void print(char[] x) {if (!TUNING) wrappedOut.print(x);}
  public void print(double x) {if (!TUNING) wrappedOut.print(x);}
  public void print(float x) {if (!TUNING) wrappedOut.print(x);}
  public void print(int x) {if (!TUNING) wrappedOut.print(x);}
  public void print(long x) {if (!TUNING) wrappedOut.print(x);}
  public void print(Object x) {if (!TUNING) wrappedOut.print(x);}
  public void print(String x) {if (!TUNING) wrappedOut.print(x);}
  public void println() {if (!TUNING) wrappedOut.println();}
  public void println(boolean x) {if (!TUNING) wrappedOut.println(x);}
  public void println(char x) {if (!TUNING) wrappedOut.println(x);}
  public void println(char[] x) {if (!TUNING) wrappedOut.println(x);}
  public void println(double x) {if (!TUNING) wrappedOut.println(x);}
  public void println(float x) {if (!TUNING) wrappedOut.println(x);}
  public void println(int x) {if (!TUNING) wrappedOut.println(x);}
  public void println(long x) {if (!TUNING) wrappedOut.println(x);}
  public void println(Object x) {if (!TUNING) wrappedOut.println(x);}
  public void println(String x) {if (!TUNING) wrappedOut.println(x);}
  public void write(byte[] x, int y, int z) {if (!TUNING) wrappedOut.write(x,y,z);}
  public void write(int  x) {if (!TUNING) wrappedOut.write(x);}
}
