package tuning.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FilterComparison
{
  static char[] NewLine;
  static int count;

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
      long time = System.currentTimeMillis();
      filter(args[0], args[1], false);
      time = System.currentTimeMillis() - time;
      System.out.println("filter time (millis) = " + time);

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

      if (args.length > 2)
        return;

      time = System.currentTimeMillis();
      filter(args[0], args[1], true);
      time = System.currentTimeMillis() - time;
      System.out.println("filter time (millis) = " + time);

      System.gc();
      System.gc();
      System.gc();
      System.gc();

      time = System.currentTimeMillis();
      cfilter(args[0], args[1], true);
      time = System.currentTimeMillis() - time;
      System.out.println("cfilter time (millis) = " + time);

      System.gc();
      System.gc();
      System.gc();
      System.gc();
    }
    catch(Exception e){e.printStackTrace();}
  }

public static void filter(String filter, String filename, boolean print)
  throws IOException
{
  count = 0;
  BufferedReader rdr = new BufferedReader(new FileReader(filename));
  String line;
  while( (line = rdr.readLine()) != null)
  {
    if (line.indexOf(filter) != -1)
    {
      count++;
      if (print)
        System.out.println(line);
    }
  }
  System.out.println(count + " lines matched.");
  rdr.close();
}

public static void cfilter(String filter, String filename, boolean print)
  throws IOException
{
  count = 0;
  //use an OutputStreamWriter to write to System.out so that we can write directly from the char array.
  OutputStreamWriter writer = print ? new OutputStreamWriter(System.out) : null;
  FileReader rdr = new FileReader(filename);
  char[] cfilter = new char[filter.length()];
  filter.getChars(0, cfilter.length, cfilter, 0);
  char[] buf = new char[8192];
  int len;
  int start = 0;    //start of the buffer for filling purposes
  int idx = 0;      //current index during parsing
  int startOfLine;  //the start of the current line
  int endOfLine;    //the end of the current line
  //read until there is nothing left
  while( (len = rdr.read(buf, start, buf.length-start)) != -1)
  {
    start = printMatchingLines(buf, 0, len, cfilter, writer);
  }
  //no more to read, but we may still have some lines left in the buffer
  if ( (len > 0) && (start = printMatchingLines(buf, 0, len, cfilter, writer)) != 0)
  {
    //unterminated line left
    if (indexOfChars(buf, 0, start, cfilter) != -1)
    {
      //Last unterminated line contains match
      printLine(buf, 0, start, writer);
    }
  }
  if (writer != null)
    writer.flush();
  System.out.println(count + " lines matched.");
}

public static int printMatchingLines(char[] buf, int idx, int len, char[] filter, Writer writer)
    throws IOException
{
  int startOfLine;
  int endOfLine;
  while( idx < len )
  {
    //If there are no more matches in the buffer
    if ( (idx = indexOfChars(buf, idx, len, filter)) == -1)
    {
      //then reset the buffer, and return the buffer size
      return resetBuffer(buf, len);
    }
    //otherwise we found a match. Find the beginning and end of the surrounding line
    else if ( (endOfLine = indexOfNewline(buf, idx, len)) == -1)
    {
      //unterminated line - possibly just because the buffer needs filling further
      //then reset the buffer, and return the buffer size
      return resetBuffer(buf, len);
    }
    else
    {
      //print the line
      startOfLine = lastIndexOfNewline(buf, idx, len);
      printLine(buf, startOfLine, endOfLine, writer);
      idx = endOfLine + 1;
    }
  }
  return resetBuffer(buf, len);
}

public static void printLine(char[] buf, int startOfLine, int endOfLine, Writer writer)
  throws IOException
{
  //print the line from startOfLine up to (including) endOfLine
  count++;
  if (writer != null)
  {
    writer.write(buf, startOfLine, endOfLine - startOfLine + 1);
    writer.write(NewLine);
    writer.flush();
  }
}

public static int resetBuffer(char[] buf, int len)
{
  //copy from the start of the last line into the beginning of the buffer
  int startOfLine = lastIndexOfNewline(buf, len-1, len);
  System.arraycopy(buf, startOfLine, buf, 0, len-startOfLine);
  //and return the size of the buffer.
  return len-startOfLine;
}

public static int indexOfNewline(char[] buf, int startIdx, int len)
{
  while( (startIdx < len) && (buf[startIdx] != '\n') && (buf[startIdx] != '\r') )
    startIdx++;
  if ( (buf[startIdx] != '\n') && (buf[startIdx] != '\r') )
    return -1;
  else
    return startIdx-1;
}

public static int lastIndexOfNewline(char[] buf, int startIdx, int len)
{
  while( (startIdx > 0) && (buf[startIdx] != '\n') && (buf[startIdx] != '\r') )
    startIdx--;
  if ( (buf[startIdx] != '\n') && (buf[startIdx] != '\r') )
    return 0;
  else
    return startIdx+1;
}

public static int indexOfChars(char[] buf, int startIdx, int bufLen, char[] match)
{
  //Simple linear search
  int j;
  for (int i = startIdx; i < bufLen; i++)
  {
    if (matches(buf, i, bufLen, match))
      return i;
  }
  return -1;
}

public static boolean matches(char[] buf, int startIdx, int bufLen, char[] match)
{
  if (startIdx + match.length > bufLen)
    return false;
  else
  {
    for(int j = match.length-1; j >= 0 ; j--)
      if(buf[startIdx+j] != match[j])
        return false;
    return true;
  }
}

}