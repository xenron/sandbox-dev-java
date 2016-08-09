package tuning.string;

import java.io.*;

public class WordCountComparison
{
  static char[] NewLine;

  static
  {
    String NewLineStr = System.getProperty("line.separator");
    NewLine = new char[NewLineStr.length()];
    NewLineStr.getChars(0, NewLine.length, NewLine, 0);
  }
  public static void main(String[] args)
  {
    maintest(args);
    if (args.length > 1)
      maintest(args);
  }

  public static void maintest(String[] args)
  {
    try
    {
      long time = System.currentTimeMillis();
      wordcount(args[0]);
      time = System.currentTimeMillis() - time;
      System.out.println("wordcount time (millis) = " + time);

      System.gc();
      System.gc();
      System.gc();
      System.gc();

      time = System.currentTimeMillis();
      cwordcount(args[0]);
      time = System.currentTimeMillis() - time;
      System.out.println("cwordcount time (millis) = " + time);

      System.gc();
      System.gc();
      System.gc();
      System.gc();
    }
    catch(Exception e){e.printStackTrace();}
  }

public static void wordcount(String filename)
  throws IOException
{
  int count = 0;
  FileReader r = new FileReader(filename);
  StreamTokenizer rdr = new StreamTokenizer(r);
  rdr.resetSyntax();
  rdr.wordChars('a', 'z');
  rdr.wordChars('A', 'Z');
  rdr.wordChars('0','9');
  rdr.whitespaceChars(0, '0'-1);
  rdr.whitespaceChars('9'+1, 'A'-1);
  rdr.whitespaceChars('z'+1, '\uffff');
  int token;
  while( (token = rdr.nextToken()) != StreamTokenizer.TT_EOF)
  {
    if ( token == StreamTokenizer.TT_WORD)
    {
      count++;
    }
  }
  System.out.println(count + " words found.");
  r.close();
}

public static void cwordcount(String filename)
  throws IOException
{
  int count = 0;
  FileReader rdr = new FileReader(filename);
  char[] buf = new char[8192];
  int len;
  int idx = 0;
  char c = ' ';
  while( (len = rdr.read(buf, 0, buf.length)) != -1)
  {
    idx = 0;
    int start;
    //if we are already in a word, then skip the rest of it
    if (Character.isLetterOrDigit(c))
      while( (idx < len) && Character.isLetterOrDigit(buf[idx]) ) {idx++;}
    while(idx < len)
    {
      //skip non alphanumeric
      while( (idx < len) && !Character.isLetterOrDigit(buf[idx]) ) {idx++;}
      //skip word
      start = idx;
      while( (idx < len) && Character.isLetterOrDigit(buf[idx]) ) {idx++;}
      if (start < len)
      {
        count++; //count word
      }
    }
    c = buf[idx-1]; //get last character so we know whether to carry on a word
  }
  System.out.println(count + " words found.");
}
}