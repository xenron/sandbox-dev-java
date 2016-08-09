// Decompiled by JAD v1.5.5.1. Copyright 1997-98 Pavel Kouznetsov.
// JAD Home Page:      http://web.unicom.com.cy/~kpd/jad.html
// Decompiler options: packimports(100) fieldsfirst 
// Source File Name:   IOTest.java

package tuning.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class IOTest
{

    static int nlines;
    static int tchars;
    public static final char MAP3[] = {
        '\200', '\201', '\202', '\203', '\204', '\205', '\206', '\207', '\210', '\211', 
        '\212', '\213', '\214', '\215', '\216', '\217', '\220', '\221', '\222', '\223', 
        '\224', '\225', '\226', '\227', '\230', '\231', '\232', '\233', '\234', '\235', 
        '\236', '\237', '\240', '\241', '\242', '\243', '\244', '\245', '\246', '\247', 
        '\250', '\251', '\252', '\253', '\254', '\255', '\256', '\257', '\260', '\261', 
        '\262', '\263', '\264', '\265', '\266', '\267', '\270', '\271', '\272', '\273', 
        '\274', '\275', '\276', '\277', '\300', '\301', '\302', '\303', '\304', '\305', 
        '\306', '\307', '\310', '\311', '\312', '\313', '\314', '\315', '\316', '\317', 
        '\320', '\321', '\322', '\323', '\324', '\325', '\326', '\327', '\330', '\331', 
        '\332', '\333', '\334', '\335', '\336', '\337', '\340', '\341', '\342', '\343', 
        '\344', '\345', '\346', '\347', '\350', '\351', '\352', '\353', '\354', '\355', 
        '\356', '\357', '\360', '\361', '\362', '\363', '\364', '\365', '\366', '\367', 
        '\370', '\371', '\372', '\373', '\374', '\375', '\376', '\377', 0, '\001', 
        '\002', '\003', '\004', '\005', '\006', '\007', '\b', '\t', '\n', '\013', 
        '\f', '\r', '\016', '\017', '\020', '\021', '\022', '\023', '\024', '\025', 
        '\026', '\027', '\030', '\031', '\032', '\033', '\034', '\035', '\036', '\037', 
        ' ', '!', '"', '#', '$', '%', '&', '\'', '(', ')', 
        '*', '+', ',', '-', '.', '/', '0', '1', '2', '3', 
        '4', '5', '6', '7', '8', '9', ':', ';', '<', '=', 
        '>', '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 
        'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 
        'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', 
        '\\', ']', '^', '_', '`', 'a', 'b', 'c', 'd', 'e', 
        'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 
        'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 
        'z', '{', '|', '}', '~', '\177'
    };

    public static void main(String args[])
    {
//        System.out.println(System.getProperties());
        try
        {
            unbufferedInputStream(args[0]);
            reset();
            bufferedInputStream(args[0]);
            reset();
            buffered8192InputStream(args[0]);
            reset();
            bufferedReader(args[0]);
            reset();
            myReader(args[0]);
            reset();
            myReader2(args[0]);
            reset();
            unbufferedInputStream(args[0]);
            reset();
            bufferedInputStream(args[0]);
            reset();
            buffered8192InputStream(args[0]);
            reset();
            bufferedReader(args[0]);
            reset();
            myReader(args[0]);
            reset();
            myReader2(args[0]);
            reset();
            return;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static void reset()
    {
        nlines = 0;
        tchars = 0;
    }

    public static void doSomethingWith(char ac[], int i, int j)
    {
        nlines++;
        tchars += (j - i) + 1;
    }

    public static void doSomethingWith(String s)
    {
        nlines++;
        tchars += s.length();
    }

    public static void unbufferedInputStream(String s)
        throws Exception
    {
        DataInputStream datainputstream = new DataInputStream(new FileInputStream(s));
        long l = System.currentTimeMillis();
        String s1;
        while((s1 = datainputstream.readLine()) != null) 
            doSomethingWith(s1);

        l = System.currentTimeMillis() - l;
        datainputstream.close();
        System.out.println("Time for reading " + nlines + " lines (chars " + tchars + ") using unbufferedInputStream: " + l);
    }

    public static void bufferedInputStream(String s)
        throws Exception
    {
        DataInputStream datainputstream = new DataInputStream(new BufferedInputStream(new FileInputStream(s)));
        long l = System.currentTimeMillis();
        String s1;
        while((s1 = datainputstream.readLine()) != null) 
            doSomethingWith(s1);

        l = System.currentTimeMillis() - l;
        datainputstream.close();
        System.out.println("Time for reading " + nlines + " lines (chars " + tchars + ") using bufferedInputStream  : " + l);
    }

    public static void buffered8192InputStream(String s)
        throws Exception
    {
        DataInputStream datainputstream = new DataInputStream(new BufferedInputStream(new FileInputStream(s), 8192));
        long l = System.currentTimeMillis();
        String s1;
        while((s1 = datainputstream.readLine()) != null) 
            doSomethingWith(s1);

        l = System.currentTimeMillis() - l;
        datainputstream.close();
        System.out.println("Time for reading " + nlines + " lines (chars " + tchars + ") using buffered8KInputStream: " + l);
    }

    public static void bufferedReader(String s)
        throws Exception
    {
        BufferedReader bufferedreader = new BufferedReader(new FileReader(s));
        long l = System.currentTimeMillis();
        String s1;
        while((s1 = bufferedreader.readLine()) != null) 
            doSomethingWith(s1);

        l = System.currentTimeMillis() - l;
        bufferedreader.close();
        System.out.println("Time for reading " + nlines + " lines (chars " + tchars + ") using bufferedReader       : " + l);
    }

  public static void myReader(String string)
    throws IOException
  {
    //Do the processing myself, directly from a FileReader
    //But don’t create strings for each line, just leave it
    //as a char array
    FileReader in = new FileReader(string);
    int defaultBufferSize = 8192;
    int nextChar = 0;
    char[] buffer = new char[defaultBufferSize];

    char c;    
    int leftover;
    int length_read;
    int startLineIdx = 0;
    long l1 = System.currentTimeMillis();

    //First fill the buffer once before we start
    int nChars = in.read(buffer, 0, defaultBufferSize);
    boolean checkFirstOfChunk = false;

    for(;;)
    {
      //Work through the buffer looking for end of line (eol) characters.
      //Note that the JDK does the eol search as follows:
      //It hard codes both of the characters \r and \n as end
      //of line characters, and considers either to signify the
      //end of the line. In addition, if the end of line character
      //is determined to be \r, and the next character is \n,
      //it winds past the \n. This way it allows the reading of
      //lines from files written on any of the three systems
      //currently supported (Unix with \n, Windows with \r\n,
      //and Mac with \r), even if you are not running on any of these.
      for (; nextChar < nChars; nextChar++)
      {
        if (((c = buffer[nextChar]) == '\n') || (c == '\r'))
        {
          //We found a line, so pass it for processing
          doSomethingWith(buffer, startLineIdx, nextChar-1);

          //And then increment the cursors. nextChar is
          //automatically incremented by the loop,
          //so only need to worry if ‘c’ is \r
          if (c == '\r')
          {
            //need to consider if we are at end of buffer
            if (nextChar == (nChars - 1) )
              checkFirstOfChunk = true;
            else if (buffer[nextChar+1] == '\n')
              nextChar++;
          }
          startLineIdx = nextChar + 1;
        }
      }

      leftover = 0;
      if (startLineIdx < nChars)
      {
        //We have some characters left over at the end of the chunk.
        //So carry them over to the beginning of the next chunk.
        leftover = nChars - startLineIdx;
        System.arraycopy(buffer, startLineIdx, buffer, 0, leftover);
      }
      do
      {
        length_read = in.read(buffer, leftover,
              buffer.length-leftover );
      } while (length_read == 0);
      if (length_read > 0)
      {
        nextChar -= nChars;
        nChars = leftover + length_read;
        startLineIdx = nextChar;
        if (checkFirstOfChunk)
        {
          checkFirstOfChunk = false;
          if (buffer[0] == '\n')
          {
            nextChar++;
            startLineIdx = nextChar;
          }
        }
      }
      else
      { /* EOF */
        l1 = System.currentTimeMillis() - l1;
        in.close();
        System.out.println("Time for reading " + nlines + " lines (chars " + tchars + ") using myReader             : " + l1);
        return;
      }
    }
  }

  public static void myReader2(String string)
    throws Exception
  {
    //Do the processing myself, directly from a FileReader
    //But don’t create strings for each line, just leave it
    //as a char array
//    FileReader in = new FileReader(string);
//this last line becomes
    FileInputStream in = new FileInputStream(string);
    int defaultBufferSize = 8192;
//and add the byte array buffer
    byte[] byte_buffer = new byte[defaultBufferSize];
    int nextChar = 0;
    char[] buffer = new char[defaultBufferSize];

    char c;    
    int leftover;
    int length_read;
    int startLineIdx = 0;
    long l1 = System.currentTimeMillis();

    //First fill the buffer once before we start
//  this next line becomes a byte read followed by convert() call
//  int nChars = in.read(buffer, 0, defaultBufferSize); 
    int nChars = in.read(byte_buffer, 0, defaultBufferSize);
    convert(byte_buffer, 0, nChars, buffer, 0, nChars, MAP3);
    boolean checkFirstOfChunk = false;

    for(;;)
    {
      //Work through the buffer looking for end of line (eol) characters.
      //Note that the JDK does the eol search as follows:
      //It hard codes both of the characters \r and \n as end
      //of line characters, and considers either to signify the
      //end of the line. In addition, if the end of line character
      //is determined to be \r, and the next character is \n,
      //it winds past the \n. This way it allows the reading of
      //lines from files written on any of the three systems
      //currently supported (Unix with \n, Windows with \r\n,
      //and Mac with \r), even if you are not running on any of these.
      for (; nextChar < nChars; nextChar++)
      {
        if (((c = buffer[nextChar]) == '\n') || (c == '\r'))
        {
          //We found a line, so pass it for processing
          doSomethingWith(buffer, startLineIdx, nextChar-1);

          //And then increment the cursors. nextChar is
          //automatically incremented by the loop,
          //so only need to worry if ‘c’ is \r
          if (c == '\r')
          {
            //need to consider if we are at end of buffer
            if (nextChar == (nChars - 1) )
              checkFirstOfChunk = true;
            else if (buffer[nextChar+1] == '\n')
              nextChar++;
          }
          startLineIdx = nextChar + 1;
        }
      }

      leftover = 0;
      if (startLineIdx < nChars)
      {
        //We have some characters left over at the end of the chunk.
        //So carry them over to the beginning of the next chunk.
        leftover = nChars - startLineIdx;
        System.arraycopy(buffer, startLineIdx, buffer, 0, leftover);
      }
      do
      {
//      length_read = in.read(buffer, leftover,
//              buffer.length-leftover );
//becomes
        length_read = in.read(byte_buffer, leftover,
              buffer.length-leftover);
      } while (length_read == 0);
      if (length_read > 0)
      {
        nextChar -= nChars;
        nChars = leftover + length_read;
        startLineIdx = nextChar;
//And add the conversion here
        convert(byte_buffer, leftover, nChars, buffer,
              leftover, nChars, MAP3);
        if (checkFirstOfChunk)
        {
          checkFirstOfChunk = false;
          if (buffer[0] == '\n')
          {
            nextChar++;
            startLineIdx = nextChar;
          }
        }
      }
      else
      { /* EOF */
        l1 = System.currentTimeMillis() - l1;
        in.close();
        System.out.println("Time for reading " + nlines + " lines (chars " + tchars + ") using myReader             : " + l1);
        return;
      }
    }
  }


    public static int convert(byte abyte0[], int i, int j, char ac[], int k, int l, char ac1[])
        throws Exception
    {
        int i1 = j;
        boolean flag = false;
        if(j - i > l - k)
        {
            i1 = i + (l - k);
            flag = true;
        }
        int j1 = k;
        if(i1 - i > 10)
        {
            i1 -= 10;
            int k1;
            for(k1 = i; k1 < i1;)
            {
                ac[j1++] = ac1[abyte0[k1++] + 128];
                ac[j1++] = ac1[abyte0[k1++] + 128];
                ac[j1++] = ac1[abyte0[k1++] + 128];
                ac[j1++] = ac1[abyte0[k1++] + 128];
                ac[j1++] = ac1[abyte0[k1++] + 128];
                ac[j1++] = ac1[abyte0[k1++] + 128];
                ac[j1++] = ac1[abyte0[k1++] + 128];
                ac[j1++] = ac1[abyte0[k1++] + 128];
                ac[j1++] = ac1[abyte0[k1++] + 128];
                ac[j1++] = ac1[abyte0[k1++] + 128];
            }

            for(i1 += 10; k1 < i1;)
                ac[j1++] = ac1[abyte0[k1++] + 128];

        }
        else
        {
            for(int l1 = i; l1 < i1;)
                ac[j1++] = ac1[abyte0[l1++] + 128];

        }
        if(flag)
            throw new Exception();
        else
            return j1 - k;
    }

    public IOTest()
    {
    }

}
