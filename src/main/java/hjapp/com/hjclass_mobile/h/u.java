package hjapp.com.hjclass_mobile.h;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class u
{
  public static boolean a = true;
  private static String b = u.class.getName();
  private static ArrayList c = new ArrayList();

  static
  {
    for (Method localMethod : u.class.getDeclaredMethods())
      c.add(localMethod.getName());
  }

  public static void a(String paramString)
  {
    if (a)
    {
      String[] arrayOfString = e(paramString);
      Log.e(arrayOfString[0], arrayOfString[1]);
    }
  }

  public static void a(String paramString1, String paramString2)
  {
    if (a)
      Log.d(paramString1, d(paramString2));
  }

  public static void b(String paramString)
  {
    if (a)
    {
      String[] arrayOfString = e(paramString);
      Log.i(arrayOfString[0], arrayOfString[1]);
    }
  }

  public static void b(String paramString1, String paramString2)
  {
    if (a)
      Log.e(paramString1, d(paramString2));
  }

  public static void c(String paramString)
  {
    if (a)
    {
      String[] arrayOfString = e(paramString);
      Log.v(arrayOfString[0], arrayOfString[1]);
    }
  }

  public static void c(String paramString1, String paramString2)
  {
    if (a)
      Log.i(paramString1, d(paramString2));
  }

  private static String d(String paramString)
  {
    try
    {
      StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
      int i = arrayOfStackTraceElement.length;
      for (int j = 0; ; j++)
        if (j < i)
        {
          StackTraceElement localStackTraceElement = arrayOfStackTraceElement[j];
          if ((!b.equals(localStackTraceElement.getClassName())) && (!c.contains(localStackTraceElement.getMethodName())))
          {
            int k = 1 + localStackTraceElement.getClassName().lastIndexOf(".");
            String str1 = localStackTraceElement.getClassName().substring(k);
            String str2 = str1 + "->" + localStackTraceElement.getMethodName() + "():" + localStackTraceElement.getLineNumber() + "->" + paramString;
            paramString = str2;
          }
        }
        else
        {
          return paramString;
        }
    }
    catch (Exception localException)
    {
    }
    return paramString;
  }

  public static void d(String paramString1, String paramString2)
  {
    if (a)
      Log.v(paramString1, d(paramString2));
  }

  private static String[] e(String paramString)
  {
    // Byte code:
    //   0: new 68	java/lang/Throwable
    //   3: dup
    //   4: invokespecial 69	java/lang/Throwable:<init>	()V
    //   7: invokevirtual 73	java/lang/Throwable:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   10: astore_2
    //   11: aload_2
    //   12: arraylength
    //   13: istore_3
    //   14: iconst_0
    //   15: istore 4
    //   17: iload 4
    //   19: iload_3
    //   20: if_icmpge +123 -> 143
    //   23: aload_2
    //   24: iload 4
    //   26: aaload
    //   27: astore 5
    //   29: getstatic 22	com/hjclass_mobile/h/u:b	Ljava/lang/String;
    //   32: aload 5
    //   34: invokevirtual 78	java/lang/StackTraceElement:getClassName	()Ljava/lang/String;
    //   37: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifne +96 -> 136
    //   43: getstatic 29	com/hjclass_mobile/h/u:c	Ljava/util/ArrayList;
    //   46: aload 5
    //   48: invokevirtual 86	java/lang/StackTraceElement:getMethodName	()Ljava/lang/String;
    //   51: invokevirtual 89	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   54: ifne +82 -> 136
    //   57: iconst_1
    //   58: aload 5
    //   60: invokevirtual 78	java/lang/StackTraceElement:getClassName	()Ljava/lang/String;
    //   63: ldc 91
    //   65: invokevirtual 95	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   68: iadd
    //   69: istore 6
    //   71: iconst_2
    //   72: anewarray 80	java/lang/String
    //   75: dup
    //   76: iconst_0
    //   77: aload 5
    //   79: invokevirtual 78	java/lang/StackTraceElement:getClassName	()Ljava/lang/String;
    //   82: iload 6
    //   84: invokevirtual 99	java/lang/String:substring	(I)Ljava/lang/String;
    //   87: aastore
    //   88: dup
    //   89: iconst_1
    //   90: new 101	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   97: aload 5
    //   99: invokevirtual 86	java/lang/StackTraceElement:getMethodName	()Ljava/lang/String;
    //   102: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc 110
    //   107: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 5
    //   112: invokevirtual 114	java/lang/StackTraceElement:getLineNumber	()I
    //   115: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: ldc 108
    //   120: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_0
    //   124: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: aastore
    //   131: astore 7
    //   133: aload 7
    //   135: areturn
    //   136: iinc 4 1
    //   139: goto -122 -> 17
    //   142: astore_1
    //   143: iconst_2
    //   144: anewarray 80	java/lang/String
    //   147: dup
    //   148: iconst_0
    //   149: ldc 122
    //   151: aastore
    //   152: dup
    //   153: iconst_1
    //   154: aload_0
    //   155: aastore
    //   156: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	14	142	java/lang/Exception
    //   23	133	142	java/lang/Exception
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     u
 * JD-Core Version:    0.6.2
 */