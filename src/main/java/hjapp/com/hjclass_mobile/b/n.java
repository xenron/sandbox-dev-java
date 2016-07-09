package hjapp.com.hjclass_mobile.b;

import android.os.AsyncTask;
import android.widget.ImageView;
import hjapp.com.hjclass_mobile.c.o;

import java.io.File;

public final class n extends AsyncTask
{
  private o a;
  private ImageView b;
  private int c;
  private File d;
  private File e;

  public n(o paramo, ImageView paramImageView, int paramInt)
  {
    this.a = paramo;
    this.b = paramImageView;
    this.c = paramInt;
    if (hjapp.com.hjclass_mobile.h.z.d())
    {
      File localFile = new File(hjapp.com.hjclass_mobile.h.z.e);
      if (!localFile.exists())
        localFile.mkdir();
    }
  }

  // ERROR //
  private android.graphics.Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 51	com/hjclass_mobile/h/y:d	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore_2
    //   5: aload_0
    //   6: new 31	java/io/File
    //   9: dup
    //   10: new 53	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   17: getstatic 34	com/hjclass_mobile/h/z:e	Ljava/lang/String;
    //   20: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_2
    //   24: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 60
    //   29: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: putfield 66	com/hjclass_mobile/b/n:e	Ljava/io/File;
    //   41: aload_0
    //   42: getfield 66	com/hjclass_mobile/b/n:e	Ljava/io/File;
    //   45: invokevirtual 40	java/io/File:exists	()Z
    //   48: ifeq +32 -> 80
    //   51: new 53	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   58: getstatic 34	com/hjclass_mobile/h/z:e	Ljava/lang/String;
    //   61: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_2
    //   65: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 60
    //   70: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 71	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   79: areturn
    //   80: aload_1
    //   81: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   84: ifeq +5 -> 89
    //   87: aconst_null
    //   88: areturn
    //   89: new 79	java/net/URL
    //   92: dup
    //   93: aload_1
    //   94: invokespecial 80	java/net/URL:<init>	(Ljava/lang/String;)V
    //   97: invokevirtual 84	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   100: checkcast 86	java/net/HttpURLConnection
    //   103: astore 6
    //   105: aload 6
    //   107: ldc 88
    //   109: ldc 90
    //   111: invokevirtual 94	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: aload 6
    //   116: invokevirtual 98	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   119: astore 7
    //   121: getstatic 102	com/hjclass_mobile/h/z:h	Z
    //   124: ifeq +78 -> 202
    //   127: aload_0
    //   128: new 31	java/io/File
    //   131: dup
    //   132: new 53	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   139: getstatic 34	com/hjclass_mobile/h/z:e	Ljava/lang/String;
    //   142: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_2
    //   146: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc 104
    //   151: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   160: putfield 106	com/hjclass_mobile/b/n:d	Ljava/io/File;
    //   163: aload_0
    //   164: getfield 106	com/hjclass_mobile/b/n:d	Ljava/io/File;
    //   167: invokevirtual 40	java/io/File:exists	()Z
    //   170: ifeq +11 -> 181
    //   173: aload_0
    //   174: getfield 106	com/hjclass_mobile/b/n:d	Ljava/io/File;
    //   177: invokevirtual 109	java/io/File:delete	()Z
    //   180: pop
    //   181: aload_0
    //   182: getfield 106	com/hjclass_mobile/b/n:d	Ljava/io/File;
    //   185: invokevirtual 112	java/io/File:createNewFile	()Z
    //   188: pop
    //   189: aload 7
    //   191: aload_0
    //   192: getfield 66	com/hjclass_mobile/b/n:e	Ljava/io/File;
    //   195: aload_0
    //   196: getfield 106	com/hjclass_mobile/b/n:d	Ljava/io/File;
    //   199: invokestatic 115	com/hjclass_mobile/h/z:a	(Ljava/io/InputStream;Ljava/io/File;Ljava/io/File;)V
    //   202: aload_0
    //   203: getfield 66	com/hjclass_mobile/b/n:e	Ljava/io/File;
    //   206: invokevirtual 118	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   209: invokestatic 71	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   212: astore 8
    //   214: aload 6
    //   216: invokevirtual 121	java/net/HttpURLConnection:disconnect	()V
    //   219: aload 8
    //   221: areturn
    //   222: astore_3
    //   223: aconst_null
    //   224: astore 4
    //   226: aload_3
    //   227: astore 5
    //   229: aload 5
    //   231: invokevirtual 124	java/lang/Exception:printStackTrace	()V
    //   234: aload 4
    //   236: areturn
    //   237: astore 9
    //   239: aload 8
    //   241: astore 4
    //   243: aload 9
    //   245: astore 5
    //   247: goto -18 -> 229
    //
    // Exception table:
    //   from	to	target	type
    //   89	181	222	java/lang/Exception
    //   181	202	222	java/lang/Exception
    //   202	214	222	java/lang/Exception
    //   214	219	237	java/lang/Exception
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     n
 * JD-Core Version:    0.6.2
 */