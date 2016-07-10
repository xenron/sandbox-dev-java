package hjapp.com.hjclass_mobile.pkg_h;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.util.Log;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class z
{
  public static int a = 1;
  public static int b = 0;
  public static final String c = str;
  public static final String d = str;
  public static final String e = c + "temp/";
  public static String f = "http://m.yeshj.com/android/meiriyiju.apk";
  public static List g = new ArrayList();
  public static boolean h = false;
  public static boolean i = false;
  public static boolean j = false;
  public static boolean k = false;
  private static Handler l = new Handler();
  private static Runnable m = new aa();

  static
  {
    String str = Environment.getExternalStorageDirectory().getPath() + "/hjclass/";
  }

  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int n = 1;
    double d1 = paramOptions.outWidth;
    double d2 = paramOptions.outHeight;
    int i1;
    int i2;
    if (paramInt2 == -1)
    {
      i1 = n;
      if (paramInt1 != -1)
        break label81;
      i2 = 128;
      label34: if (i2 >= i1)
        break label106;
    }
    while (true)
    {
      if (i1 > 8)
        break label134;
      while (n < i1)
        n <<= 1;
      i1 = (int)Math.ceil(Math.sqrt(d1 * d2 / paramInt2));
      break;
      label81: i2 = (int)Math.min(Math.floor(d1 / paramInt1), Math.floor(d2 / paramInt1));
      break label34;
      label106: if ((paramInt2 == -1) && (paramInt1 == -1))
        i1 = n;
      else if (paramInt1 != -1)
        i1 = i2;
    }
    label134: n = 8 * ((i1 + 7) / 8);
    return n;
  }

  public static int a(String paramString)
  {
    if (paramString == null);
    String[] arrayOfString;
    do
    {
      return 0;
      arrayOfString = y.b(paramString).split(":");
    }
    while (arrayOfString.length == 1);
    return 60 * Integer.parseInt(arrayOfString[0]) + Double.valueOf(arrayOfString[1]).intValue();
  }

  public static ProgressDialog a(Context paramContext, CharSequence paramCharSequence)
  {
    ProgressDialog localProgressDialog = new ProgressDialog(paramContext);
    localProgressDialog.setMessage(paramCharSequence);
    localProgressDialog.setIndeterminate(true);
    return localProgressDialog;
  }

  public static NetworkInfo a(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()))
      return localNetworkInfo;
    return null;
  }

  public static String a(float paramFloat)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("0.00");
    if (paramFloat < 1024.0F)
      return localDecimalFormat.format(paramFloat) + "KB";
    float f1 = paramFloat / 1024.0F;
    return localDecimalFormat.format(f1) + "MB";
  }

  public static String a(int paramInt)
  {
    int n = paramInt / 1000;
    int i1 = n % 60;
    int i2 = n / 60;
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject1;
    StringBuilder localStringBuilder2;
    if (i2 < 10)
    {
      localObject1 = "0" + i2;
      localStringBuilder2 = localStringBuilder1.append(localObject1).append(":");
      if (i1 >= 10)
        break label107;
    }
    label107: for (Object localObject2 = "0" + i1; ; localObject2 = Integer.valueOf(i1))
    {
      return localObject2;
      localObject1 = Integer.valueOf(i2);
      break;
    }
  }

  public static void a()
  {
    l.postDelayed(m, 1000L);
  }

  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    File localFile1 = new File(c + File.separator + paramInt1 + File.separator + paramInt2 + File.separator + paramInt3);
    File localFile2 = new File(c + File.separator + paramInt1 + File.separator + paramString);
    if (localFile2.exists())
      localFile2.delete();
    if (localFile1.exists())
      a(localFile1);
  }

  public static void a(Activity paramActivity)
  {
    if (!g.contains(paramActivity))
      g.add(paramActivity);
  }

  public static void a(Context paramContext, int paramInt)
  {
    Toast.makeText(paramContext, paramInt, 0).show();
  }

  public static void a(Context paramContext, String paramString)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
    localBuilder.setTitle("提示").setMessage(paramString).setPositiveButton("确定", new ab());
    localBuilder.show();
  }

  private static void a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      int n = 0;
      if (n < arrayOfString.length)
      {
        File localFile = new File(paramFile, arrayOfString[n]);
        if (localFile.isDirectory())
          a(localFile);
        while (true)
        {
          n++;
          break;
          if (!localFile.delete())
            Log.d("DeleteRecursive", "DELETE FAIL");
        }
      }
      paramFile.delete();
    }
  }

  // ERROR //
  public static void a(File paramFile, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: new 42	java/io/File
    //   3: dup
    //   4: new 31	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   11: getstatic 57	com/hjclass_mobile/h/z:c	Ljava/lang/String;
    //   14: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc_w 299
    //   20: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: ldc_w 299
    //   30: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_2
    //   34: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: ldc_w 299
    //   40: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_3
    //   44: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore 4
    //   55: aload 4
    //   57: invokevirtual 276	java/io/File:isDirectory	()Z
    //   60: ifne +9 -> 69
    //   63: aload 4
    //   65: invokevirtual 302	java/io/File:mkdirs	()Z
    //   68: pop
    //   69: new 304	java/io/FileInputStream
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 306	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   77: astore 9
    //   79: new 308	java/util/zip/ZipInputStream
    //   82: dup
    //   83: aload 9
    //   85: invokespecial 311	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   88: astore 10
    //   90: aload 10
    //   92: invokevirtual 315	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   95: astore 16
    //   97: aload 16
    //   99: ifnull +294 -> 393
    //   102: ldc_w 317
    //   105: new 31	java/lang/StringBuilder
    //   108: dup
    //   109: ldc_w 319
    //   112: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: aload 16
    //   117: invokevirtual 324	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   120: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 327	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   129: pop
    //   130: aload 16
    //   132: invokevirtual 328	java/util/zip/ZipEntry:isDirectory	()Z
    //   135: ifeq +126 -> 261
    //   138: aload 16
    //   140: invokevirtual 324	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   143: astore 21
    //   145: new 42	java/io/File
    //   148: dup
    //   149: new 31	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   156: getstatic 57	com/hjclass_mobile/h/z:c	Ljava/lang/String;
    //   159: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc_w 299
    //   165: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: iload_1
    //   169: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: ldc_w 299
    //   175: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload_2
    //   179: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: ldc_w 299
    //   185: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: iload_3
    //   189: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: ldc_w 299
    //   195: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload 21
    //   200: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   209: astore 22
    //   211: aload 22
    //   213: invokevirtual 276	java/io/File:isDirectory	()Z
    //   216: ifne -126 -> 90
    //   219: aload 22
    //   221: invokevirtual 302	java/io/File:mkdirs	()Z
    //   224: pop
    //   225: goto -135 -> 90
    //   228: astore 5
    //   230: aload 10
    //   232: astore 6
    //   234: aload 9
    //   236: astore 7
    //   238: ldc_w 317
    //   241: ldc_w 330
    //   244: aload 5
    //   246: invokestatic 333	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   249: pop
    //   250: aload 7
    //   252: invokevirtual 336	java/io/FileInputStream:close	()V
    //   255: aload 6
    //   257: invokevirtual 337	java/util/zip/ZipInputStream:close	()V
    //   260: return
    //   261: new 339	java/io/FileOutputStream
    //   264: dup
    //   265: new 31	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   272: getstatic 57	com/hjclass_mobile/h/z:c	Ljava/lang/String;
    //   275: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc_w 299
    //   281: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: iload_1
    //   285: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   288: ldc_w 299
    //   291: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: iload_2
    //   295: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   298: ldc_w 299
    //   301: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: iload_3
    //   305: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   308: ldc_w 299
    //   311: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload 16
    //   316: invokevirtual 324	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   319: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokespecial 340	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   328: astore 18
    //   330: sipush 16384
    //   333: newarray byte
    //   335: astore 19
    //   337: aload 10
    //   339: aload 19
    //   341: invokevirtual 344	java/util/zip/ZipInputStream:read	([B)I
    //   344: istore 20
    //   346: iload 20
    //   348: iconst_m1
    //   349: if_icmpeq +31 -> 380
    //   352: aload 18
    //   354: aload 19
    //   356: iconst_0
    //   357: iload 20
    //   359: invokevirtual 348	java/io/FileOutputStream:write	([BII)V
    //   362: goto -25 -> 337
    //   365: astore 8
    //   367: aload 9
    //   369: invokevirtual 336	java/io/FileInputStream:close	()V
    //   372: aload 10
    //   374: invokevirtual 337	java/util/zip/ZipInputStream:close	()V
    //   377: aload 8
    //   379: athrow
    //   380: aload 10
    //   382: invokevirtual 351	java/util/zip/ZipInputStream:closeEntry	()V
    //   385: aload 18
    //   387: invokevirtual 352	java/io/FileOutputStream:close	()V
    //   390: goto -300 -> 90
    //   393: aload 9
    //   395: invokevirtual 336	java/io/FileInputStream:close	()V
    //   398: aload 10
    //   400: invokevirtual 337	java/util/zip/ZipInputStream:close	()V
    //   403: aload 9
    //   405: invokevirtual 336	java/io/FileInputStream:close	()V
    //   408: aload 10
    //   410: invokevirtual 337	java/util/zip/ZipInputStream:close	()V
    //   413: return
    //   414: astore 25
    //   416: aload 25
    //   418: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   421: return
    //   422: astore 24
    //   424: aload 24
    //   426: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   429: goto -21 -> 408
    //   432: astore 14
    //   434: aload 14
    //   436: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   439: goto -184 -> 255
    //   442: astore 15
    //   444: aload 15
    //   446: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   449: return
    //   450: astore 11
    //   452: aload 11
    //   454: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   457: goto -85 -> 372
    //   460: astore 12
    //   462: aload 12
    //   464: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   467: goto -90 -> 377
    //   470: astore 8
    //   472: aconst_null
    //   473: astore 10
    //   475: aconst_null
    //   476: astore 9
    //   478: goto -111 -> 367
    //   481: astore 8
    //   483: aconst_null
    //   484: astore 10
    //   486: goto -119 -> 367
    //   489: astore 8
    //   491: aload 7
    //   493: astore 9
    //   495: aload 6
    //   497: astore 10
    //   499: goto -132 -> 367
    //   502: astore 5
    //   504: aconst_null
    //   505: astore 6
    //   507: aconst_null
    //   508: astore 7
    //   510: goto -272 -> 238
    //   513: astore 5
    //   515: aload 9
    //   517: astore 7
    //   519: aconst_null
    //   520: astore 6
    //   522: goto -284 -> 238
    //
    // Exception table:
    //   from	to	target	type
    //   90	97	228	java/lang/Exception
    //   102	225	228	java/lang/Exception
    //   261	337	228	java/lang/Exception
    //   337	346	228	java/lang/Exception
    //   352	362	228	java/lang/Exception
    //   380	390	228	java/lang/Exception
    //   393	403	228	java/lang/Exception
    //   90	97	365	finally
    //   102	225	365	finally
    //   261	337	365	finally
    //   337	346	365	finally
    //   352	362	365	finally
    //   380	390	365	finally
    //   393	403	365	finally
    //   408	413	414	java/io/IOException
    //   403	408	422	java/io/IOException
    //   250	255	432	java/io/IOException
    //   255	260	442	java/io/IOException
    //   367	372	450	java/io/IOException
    //   372	377	460	java/io/IOException
    //   0	69	470	finally
    //   69	79	470	finally
    //   79	90	481	finally
    //   238	250	489	finally
    //   0	69	502	java/lang/Exception
    //   69	79	502	java/lang/Exception
    //   79	90	513	java/lang/Exception
  }

  public static void a(InputStream paramInputStream, File paramFile1, File paramFile2)
  {
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(paramFile2);
      byte[] arrayOfByte = new byte[1024];
      while (true)
      {
        int n = paramInputStream.read(arrayOfByte);
        if (n <= 0)
          break;
        localFileOutputStream.write(arrayOfByte, 0, n);
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    paramFile2.renameTo(paramFile1);
  }

  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return new File(c + paramInt1 + File.separator + paramInt2 + File.separator + paramInt3 + File.separator + "index.xml").exists();
  }

  public static boolean a(int paramInt, String paramString)
  {
    return new File(c + File.separator + paramInt + File.separator + paramString).exists();
  }

  public static String b(int paramInt)
  {
    int n = paramInt / 1000 / 60;
    return n + "分钟";
  }

  public static String b(int paramInt, String paramString)
  {
    int n = 2;
    if (paramString == null)
      paramString = null;
    String[] arrayOfString;
    do
    {
      return paramString;
      arrayOfString = paramString.split("/");
    }
    while (arrayOfString.length <= 3);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 1)
      arrayOfString[n] = "http://jk1.c.hjfile.cn";
    while (true)
    {
      int i1 = arrayOfString.length;
      while (n < i1)
      {
        localStringBuilder.append(arrayOfString[n]);
        if (n < i1 - 1)
          localStringBuilder.append("/");
        n++;
      }
      if (paramInt == n)
        arrayOfString[n] = "http://jk3.c.hjfile.cn";
      else if (paramInt == 3)
        arrayOfString[n] = "http://jk2.c.hjfile.cn";
    }
    return localStringBuilder.toString();
  }

  public static String b(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      byte[] arrayOfByte = localMessageDigest.digest();
      StringBuffer localStringBuffer = new StringBuffer(2 * arrayOfByte.length);
      for (int n = 0; n < arrayOfByte.length; n++)
      {
        localStringBuffer.append(Character.forDigit((0xF0 & arrayOfByte[n]) >> 4, 16));
        localStringBuffer.append(Character.forDigit(0xF & arrayOfByte[n], 16));
      }
      String str = localStringBuffer.toString().substring(8, 24);
      return str;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  public static void b()
  {
    l.removeCallbacks(m);
  }

  public static void b(Activity paramActivity)
  {
    g.remove(paramActivity);
  }

  public static void b(Context paramContext, String paramString)
  {
    Editor localEditor = paramContext.getSharedPreferences("prefs_hjclass", 0).edit();
    localEditor.putString("prefs_cardpwd", paramString);
    localEditor.commit();
  }

  public static boolean b(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localConnectivityManager == null);
    while (true)
    {
      return false;
      NetworkInfo[] arrayOfNetworkInfo = localConnectivityManager.getAllNetworkInfo();
      if (arrayOfNetworkInfo != null)
        for (int n = 0; n < arrayOfNetworkInfo.length; n++)
          if (arrayOfNetworkInfo[n].isConnected())
            return true;
    }
  }

  public static String c(int paramInt, String paramString)
  {
    int n = 2;
    String[] arrayOfString = paramString.split("/");
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 1)
      arrayOfString[n] = "http://mn1.c.hjfile.cn";
    while (true)
    {
      int i1 = arrayOfString.length;
      while (n < i1)
      {
        localStringBuilder.append(arrayOfString[n]);
        if (n < i1 - 1)
          localStringBuilder.append("/");
        n++;
      }
      if (paramInt == n)
        arrayOfString[n] = "http://mn2.c.hjfile.cn";
      else if (paramInt == 3)
        arrayOfString[n] = "http:/mn3.c.hjfile.cn";
    }
    return localStringBuilder.toString();
  }

  public static String c(String paramString)
  {
    int n = 4;
    int i1 = paramString.length();
    if (i1 < n)
      paramString = new DecimalFormat("0000").format(Long.parseLong(paramString));
    while (true)
    {
      String str1 = paramString.substring(n - 2, n);
      String str2 = paramString.substring(n - 4, n - 2);
      return "http://i2.hjfile.cn/f48/" + str2 + "/" + str1 + "/" + paramString + ".jpg";
      n = i1;
    }
  }

  public static void c()
  {
    File localFile1 = new File(c);
    if (!localFile1.exists())
      localFile1.mkdir();
    File localFile2 = new File(e);
    if (!localFile2.exists())
      localFile2.mkdir();
  }

  public static void c(int paramInt)
  {
    File localFile = new File(c + File.separator + paramInt);
    if (localFile.exists())
      a(localFile);
  }

  public static void c(Context paramContext)
  {
    Toast.makeText(paramContext, 2131493117, 1).show();
  }

  public static String d(Context paramContext)
  {
    return paramContext.getSharedPreferences("prefs_hjclass", 0).getString("prefs_cardpwd", "");
  }

  public static String d(String paramString)
  {
    if (y.c(paramString))
      return "";
    return Pattern.compile("<.+?>").matcher(paramString).replaceAll("");
  }

  public static void d(int paramInt)
  {
    File localFile1 = new File(c + File.separator + paramInt);
    if ((localFile1.exists()) && (localFile1.isDirectory()))
    {
      String[] arrayOfString = localFile1.list();
      for (int n = 0; n < arrayOfString.length; n++)
      {
        File localFile2 = new File(localFile1, arrayOfString[n]);
        if ((!localFile2.isDirectory()) && (!localFile2.delete()))
          Log.d("clear task", "DELETE FAIL");
      }
    }
  }

  public static void d(int paramInt, String paramString)
  {
    File localFile = new File(c + File.separator + paramInt + File.separator + paramString);
    if (localFile.exists())
      localFile.delete();
  }

  public static boolean d()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }

  public static long e()
  {
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      return localStatFs.getBlockSize() * localStatFs.getAvailableBlocks();
    }
    return 0L;
  }

  public static String e(String paramString)
  {
    if (y.c(paramString))
      return "";
    String str = paramString.replace("</P>", "\r\n");
    return Pattern.compile("<.+?>").matcher(str).replaceAll("");
  }

  public static List e(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    for (int n = 0; n < paramInt; n++)
      localArrayList.add(Integer.valueOf(n));
    return localArrayList;
  }

  public static List f(int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    ArrayList localArrayList = new ArrayList();
    for (int n = 0; n < paramInt; n++)
      arrayOfInt[n] = n;
    int i1 = paramInt;
    while (i1 > 0)
    {
      int i2 = (int)Math.floor(Math.random() * paramInt);
      if (arrayOfInt[i2] >= 0)
      {
        localArrayList.add(Integer.valueOf(i2));
        arrayOfInt[i2] = -1;
        i1--;
      }
    }
    return localArrayList;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     z
 * JD-Core Version:    0.6.2
 */