package tuning.string;

import java.nio.*;
import java.io.*;
import java.util.regex.*;

public class FilterComparison2
{
  static char[] NewLine;
  static int count;
  public static char[] buf;

  static
  {
    String NewLineStr = System.getProperty("line.separator");
    NewLine = new char[NewLineStr.length()];
    NewLineStr.getChars(0, NewLine.length, NewLine, 0);
  }
  public static void main(String[] args)
  {
    test(args);
    if (args.length > 2)
      test(args);
  }

  public static void test(String[] args)
  {
    try
    {
      if (buf == null)
      {
        File f = new File(args[1]);
        buf = new char[(int) f.length()];
        FileReader r = new FileReader(args[1]);
        int len = 0, len2;
        while( (len2 = r.read(buf,len,buf.length-len)) > 0) {len+=len2;}
        if (len != buf.length) throw new Exception("Didn't read the whole file");
        r.close();
      }

      long time = System.currentTimeMillis();
      filter3(args[0], args[1], false);
      time = System.currentTimeMillis() - time;
      System.out.println("filter3 time (millis) = " + time);

      System.gc();
      System.gc();
      System.gc();
      System.gc();

      time = System.currentTimeMillis();
      filter1(args[0], args[1], false);
      time = System.currentTimeMillis() - time;
      System.out.println("filter1 time (millis) = " + time);

      System.gc();
      System.gc();
      System.gc();
      System.gc();

      time = System.currentTimeMillis();
      filter2(args[0], args[1], false);
      time = System.currentTimeMillis() - time;
      System.out.println("filter2 time (millis) = " + time);

      System.gc();
      System.gc();
      System.gc();
      System.gc();

      time = System.currentTimeMillis();
      cfilter(args[0], args[1], false);
      time = System.currentTimeMillis() - time;
      System.out.println("cfilter time (millis) = " + time);

      System.gc();
      System.gc();
      System.gc();
      System.gc();


    }
    catch(Exception e){e.printStackTrace();}
  }

  public static void filter1(String filter, String filename, boolean print)
    throws IOException
  {
    count = 0;
//    BufferedReader rdr = new BufferedReader(new FileReader(filename));
    BufferedReader rdr = new BufferedReader(new CharArrayReader(buf));
    String line;
    String ufilter = filter.toUpperCase();
    while( (line = rdr.readLine()) != null)
    {
      if (line.toUpperCase().indexOf(ufilter) != -1)
      {
        count++;
        if (print)
          System.out.println(line);
      }
    }
    System.out.println(count + " lines matched.");
    rdr.close();
  }

  public static void filter2(String filter, String filename, boolean print)
    throws IOException
  {
    count = 0;
//    BufferedReader rdr = new BufferedReader(new FileReader(filename));
    BufferedReader rdr = new BufferedReader(new CharArrayReader(buf));
    String line;
    int filterLength = filter.length();
    while( (line = rdr.readLine()) != null)
    {
      for(int i = 0; i < line.length(); i++)
        if (line.regionMatches(true, i, filter, 0, filterLength))
        {
          count++;
          if (print)
            System.out.println(line);
          break;
        }
    }
    System.out.println(count + " lines matched.");
    rdr.close();
  }

  public static void filter3(String filter, String filename, boolean print)
    throws IOException
  {
    count = 0;
    Pattern p = Pattern.compile("^.*" + filter + ".*$", Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
    CharBuffer cbuff = CharBuffer.wrap(buf);
    Matcher m = p.matcher(cbuff);
    while( m.find() )
    {
      count++;
      if (print)
        System.out.println(m.group());
    }
    System.out.println(count + " lines matched.");
  }

  public static void cfilter(String filter, String filename, boolean print)
    throws IOException
  {
    MatchReader2.filter(filter, filename, print);
  }
}

class MatchReader2
{

  public static void filter(String filter, String filename, boolean print)
    throws IOException
  {
//    MatchReader2 rdr = new MatchReader2(new FileReader(filename), filter);
    MatchReader2 rdr = new MatchReader2(new CharArrayReader(FilterComparison2.buf), filter);
    rdr.filter(print);
  }

  static final int BUFFER_SIZE = 8192;
  char[] buffer;
  int bufferSize;
  int bufferPos;
  char[] matchString;
  Reader reader;
  Writer sysout;

  public MatchReader2(Reader rdr, String match)
    throws IOException
  {
    reader = rdr;
    matchString = new char[match.length()];
    match.toUpperCase().getChars(0, match.length(), matchString, 0);
    buffer = new char[BUFFER_SIZE];
    bufferSize = 0;
    bufferPos = 0;
    sysout = new OutputStreamWriter(System.out);
    fillBuffer();
  }

  /* return true if more characters were read, otherwise false */
  private boolean fillBuffer()
    throws IOException
  {
    int len;
    boolean added = false;
    while(bufferSize < buffer.length)
    {
      len = reader.read(buffer, bufferSize, buffer.length-bufferSize);
      if (len <= 0)
        return added;
      else
        bufferSize += len;
      added = true;
    }
    return added;
  }

  public void filter(boolean print)
    throws IOException
  {
    int count = 0;
    while( nextMatchedLine() )
    {
      count++;
      if (print)
        printCurrentLine();
      else
        nextLine();
    }
    System.out.println(count + " lines matched.");
    close();
  }

  public void close()
    throws IOException
  {
    buffer = null;
    matchString = null;
    reader.close();
  }

  /* Return true if we matched a line,
   * false if there were no more matches
   */
  public boolean nextMatchedLine()
    throws IOException
  {
    while(!scrollToNextMatchInCurrentBuffer())
    {
      if (!refillBuffer())
      {
        //No more characters to read, just make sure
        //that no more lines are left in the buffer
        return scrollToNextMatchInCurrentBuffer();
      }
    }
    return true;
  }

  private boolean scrollToNextMatchInCurrentBuffer()
  {
    //Simple linear search
    //No need to try to match beyond the end of the buffer
    int highIdx = bufferSize-matchString.length;
    for (; bufferPos <= highIdx; bufferPos++)
    {
      if (matches())
        return true;
    }
    return false;
  }

  private boolean matches()
  {
    //Assume that this is only called if the match
    //characters can fit into the remaining buffer
    for(int j = 0; j < matchString.length ; j++)
      if(Character.toUpperCase(buffer[bufferPos+j]) != matchString[j])
        return false;
    return true;
  }

  private boolean refillBuffer()
    throws IOException
  {
    return refillBuffer(bufferSize - 1);
  }

  private boolean refillBuffer(int lastIdx)
    throws IOException
  {
    //Find the start of the last line in the buffer,
    //move that to the start of the buffer,
    //then append some more to the buffer.
    while( (lastIdx > 0) && (buffer[lastIdx] != '\n') && (buffer[lastIdx] != '\r') )
      lastIdx--;
    if ( (buffer[lastIdx] == '\n') || (buffer[lastIdx] == '\r') )
    {
      //Found the most recent newline character
      bufferSize -= lastIdx+1;
      System.arraycopy(buffer, lastIdx+1, buffer, 0, bufferSize);
      bufferPos = 0; //be safe
      return fillBuffer();
    }
    else
    {
      //reached the beginning of the buffer and we still don't have a newline
      return fillBuffer();
    }
  }

  /* Scroll to just after the next newline character */
  public void nextLine()
    throws IOException
  {
    while(!scrollToNextLineInCurrentBuffer())
    {
      if (!refillBuffer())
      {
        //No more characters to read, just make sure
        //that no more lines are left in the buffer
        scrollToNextLineInCurrentBuffer();
      }
    }
  }

  private boolean scrollToNextLineInCurrentBuffer()
  {
    //Simple linear search
    //No need to try to match beyond the end of the buffer
    int highIdx = bufferSize-1;
    for (; bufferPos <= highIdx; bufferPos++)
    {
      if ( (buffer[bufferPos] == '\n') || (buffer[bufferPos] == '\r') )
      {
        bufferPos++;
        return true;
      }
    }
    return false;
  }

  private void printCurrentLine()
    throws IOException
  {
    //Move the start of the current line back to beginning of
    //the buffer, fill it up, and find the next line
    refillBuffer(bufferPos);
    scrollToNextLineInCurrentBuffer();
    sysout.write(buffer, 0, bufferPos-1);
    sysout.write(FilterComparison.NewLine);
    sysout.flush();
  }
}
