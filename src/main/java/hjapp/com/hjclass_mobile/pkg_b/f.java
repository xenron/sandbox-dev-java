package hjapp.com.hjclass_mobile.pkg_b;

import android.os.Handler;
import hjapp.com.hjclass_mobile.pkg_c.a;

import java.io.File;

public final class f
{
  private boolean a = false;
  private boolean b = false;
  private boolean c = false;
  private boolean d = true;
  private boolean e = false;
  private boolean f = false;
  private e g = null;
  private hjapp.com.hjclass_mobile.pkg_d.o h = null;
  private File i = null;
  private long j = 0L;
  private Handler k = new Handler();
  private long l = 0L;
  private a m = null;
  private Runnable n = new g(this);

  // ERROR //
  private int h()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 75	java/net/URL
    //   5: dup
    //   6: aload_0
    //   7: getfield 46	com/hjclass_mobile/b/f:h	Lcom/hjclass_mobile/d/o;
    //   10: invokevirtual 80	com/hjclass_mobile/d/o:d	()Ljava/lang/String;
    //   13: invokespecial 83	java/net/URL:<init>	(Ljava/lang/String;)V
    //   16: astore_2
    //   17: aload_2
    //   18: invokevirtual 87	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   21: checkcast 89	java/net/HttpURLConnection
    //   24: astore 4
    //   26: aload 4
    //   28: ldc 90
    //   30: invokevirtual 94	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   33: aload 4
    //   35: ldc 96
    //   37: invokevirtual 99	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   40: aload 4
    //   42: ldc 101
    //   44: ldc 103
    //   46: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload 4
    //   51: ldc 109
    //   53: ldc 111
    //   55: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload 4
    //   60: ldc 113
    //   62: aload_2
    //   63: invokevirtual 116	java/net/URL:toString	()Ljava/lang/String;
    //   66: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload 4
    //   71: ldc 118
    //   73: ldc 120
    //   75: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload 4
    //   80: ldc 122
    //   82: ldc 124
    //   84: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload 4
    //   89: ldc 126
    //   91: ldc 128
    //   93: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload 4
    //   98: invokevirtual 131	java/net/HttpURLConnection:connect	()V
    //   101: aload 4
    //   103: invokevirtual 134	java/net/HttpURLConnection:getContentLength	()I
    //   106: istore 6
    //   108: aload 4
    //   110: invokevirtual 137	java/net/HttpURLConnection:disconnect	()V
    //   113: iload 6
    //   115: ireturn
    //   116: astore_3
    //   117: aload_3
    //   118: invokevirtual 140	java/lang/Exception:printStackTrace	()V
    //   121: aload_1
    //   122: invokevirtual 137	java/net/HttpURLConnection:disconnect	()V
    //   125: iconst_0
    //   126: ireturn
    //   127: astore 5
    //   129: aload 4
    //   131: astore_1
    //   132: aload 5
    //   134: astore_3
    //   135: goto -18 -> 117
    //
    // Exception table:
    //   from	to	target	type
    //   2	26	116	java/lang/Exception
    //   26	101	127	java/lang/Exception
  }

  private void i()
  {
    if (this.m != null)
    {
      double d1 = this.h.b() / 1024L;
      Double localDouble = Double.valueOf(this.h.a() / 1024.0D / d1);
      this.m.a((int)(100.0D * localDouble.doubleValue()), this.h.f(), this.j, (int)d1);
    }
  }

  // ERROR //
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/hjclass_mobile/b/f:h	Lcom/hjclass_mobile/d/o;
    //   4: invokevirtual 147	com/hjclass_mobile/d/o:a	()J
    //   7: aload_0
    //   8: getfield 46	com/hjclass_mobile/b/f:h	Lcom/hjclass_mobile/d/o;
    //   11: invokevirtual 143	com/hjclass_mobile/d/o:b	()J
    //   14: lcmp
    //   15: ifne +37 -> 52
    //   18: aload_0
    //   19: getfield 46	com/hjclass_mobile/b/f:h	Lcom/hjclass_mobile/d/o;
    //   22: invokevirtual 143	com/hjclass_mobile/d/o:b	()J
    //   25: lconst_0
    //   26: lcmp
    //   27: ifle +25 -> 52
    //   30: ldc 172
    //   32: invokestatic 176	com/hjclass_mobile/h/u:b	(Ljava/lang/String;)V
    //   35: aload_0
    //   36: invokespecial 70	com/hjclass_mobile/b/f:i	()V
    //   39: aload_0
    //   40: getfield 42	com/hjclass_mobile/b/f:f	Z
    //   43: ifne +8 -> 51
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 34	com/hjclass_mobile/b/f:b	Z
    //   51: return
    //   52: aload_0
    //   53: getfield 46	com/hjclass_mobile/b/f:h	Lcom/hjclass_mobile/d/o;
    //   56: invokevirtual 143	com/hjclass_mobile/d/o:b	()J
    //   59: lconst_0
    //   60: lcmp
    //   61: ifne +20 -> 81
    //   64: aload_0
    //   65: getfield 55	com/hjclass_mobile/b/f:k	Landroid/os/Handler;
    //   68: aload_0
    //   69: getfield 66	com/hjclass_mobile/b/f:n	Ljava/lang/Runnable;
    //   72: invokevirtual 180	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   75: aload_0
    //   76: iconst_1
    //   77: invokevirtual 183	com/hjclass_mobile/b/f:a	(Z)V
    //   80: return
    //   81: new 75	java/net/URL
    //   84: dup
    //   85: aload_0
    //   86: getfield 46	com/hjclass_mobile/b/f:h	Lcom/hjclass_mobile/d/o;
    //   89: invokevirtual 80	com/hjclass_mobile/d/o:d	()Ljava/lang/String;
    //   92: invokespecial 83	java/net/URL:<init>	(Ljava/lang/String;)V
    //   95: astore_1
    //   96: aload_1
    //   97: invokevirtual 87	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   100: checkcast 89	java/net/HttpURLConnection
    //   103: astore_3
    //   104: aload_3
    //   105: ldc 90
    //   107: invokevirtual 94	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   110: aload_3
    //   111: ldc 96
    //   113: invokevirtual 99	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   116: aload_3
    //   117: ldc 101
    //   119: ldc 103
    //   121: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_3
    //   125: ldc 109
    //   127: ldc 111
    //   129: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_3
    //   133: ldc 113
    //   135: aload_1
    //   136: invokevirtual 116	java/net/URL:toString	()Ljava/lang/String;
    //   139: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_3
    //   143: ldc 118
    //   145: ldc 120
    //   147: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload_3
    //   151: ldc 185
    //   153: new 187	java/lang/StringBuilder
    //   156: dup
    //   157: ldc 189
    //   159: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   162: aload_0
    //   163: getfield 46	com/hjclass_mobile/b/f:h	Lcom/hjclass_mobile/d/o;
    //   166: invokevirtual 147	com/hjclass_mobile/d/o:a	()J
    //   169: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   172: ldc 196
    //   174: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: getfield 46	com/hjclass_mobile/b/f:h	Lcom/hjclass_mobile/d/o;
    //   181: invokevirtual 143	com/hjclass_mobile/d/o:b	()J
    //   184: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   187: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload_3
    //   194: ldc 122
    //   196: ldc 124
    //   198: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload_3
    //   202: ldc 126
    //   204: ldc 128
    //   206: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: aload_3
    //   210: invokevirtual 131	java/net/HttpURLConnection:connect	()V
    //   213: aload_0
    //   214: aload_0
    //   215: getfield 46	com/hjclass_mobile/b/f:h	Lcom/hjclass_mobile/d/o;
    //   218: invokevirtual 147	com/hjclass_mobile/d/o:a	()J
    //   221: putfield 50	com/hjclass_mobile/b/f:j	J
    //   224: aload_0
    //   225: getfield 55	com/hjclass_mobile/b/f:k	Landroid/os/Handler;
    //   228: aload_0
    //   229: getfield 66	com/hjclass_mobile/b/f:n	Ljava/lang/Runnable;
    //   232: invokevirtual 180	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   235: aload_0
    //   236: getfield 55	com/hjclass_mobile/b/f:k	Landroid/os/Handler;
    //   239: aload_0
    //   240: getfield 66	com/hjclass_mobile/b/f:n	Ljava/lang/Runnable;
    //   243: invokevirtual 204	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   246: pop
    //   247: aload_3
    //   248: invokevirtual 208	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   251: astore 5
    //   253: new 210	java/io/RandomAccessFile
    //   256: dup
    //   257: aload_0
    //   258: getfield 48	com/hjclass_mobile/b/f:i	Ljava/io/File;
    //   261: ldc 212
    //   263: invokespecial 215	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   266: astore 6
    //   268: aload 6
    //   270: aload_0
    //   271: getfield 46	com/hjclass_mobile/b/f:h	Lcom/hjclass_mobile/d/o;
    //   274: invokevirtual 147	com/hjclass_mobile/d/o:a	()J
    //   277: invokevirtual 219	java/io/RandomAccessFile:seek	(J)V
    //   280: ldc 220
    //   282: newarray byte
    //   284: astore 7
    //   286: aload 5
    //   288: aload 7
    //   290: invokevirtual 226	java/io/InputStream:read	([B)I
    //   293: istore 8
    //   295: iload 8
    //   297: iconst_m1
    //   298: if_icmpeq +109 -> 407
    //   301: aload_0
    //   302: getfield 32	com/hjclass_mobile/b/f:a	Z
    //   305: istore 9
    //   307: iload 9
    //   309: ifeq +14 -> 323
    //   312: aload_0
    //   313: getfield 42	com/hjclass_mobile/b/f:f	Z
    //   316: istore 11
    //   318: iload 11
    //   320: ifeq +68 -> 388
    //   323: aload_0
    //   324: getfield 42	com/hjclass_mobile/b/f:f	Z
    //   327: ifne +80 -> 407
    //   330: aload 6
    //   332: aload 7
    //   334: iconst_0
    //   335: iload 8
    //   337: invokevirtual 230	java/io/RandomAccessFile:write	([BII)V
    //   340: aload_0
    //   341: aload_0
    //   342: getfield 50	com/hjclass_mobile/b/f:j	J
    //   345: iload 8
    //   347: i2l
    //   348: ladd
    //   349: putfield 50	com/hjclass_mobile/b/f:j	J
    //   352: aload_0
    //   353: getfield 46	com/hjclass_mobile/b/f:h	Lcom/hjclass_mobile/d/o;
    //   356: aload_0
    //   357: getfield 50	com/hjclass_mobile/b/f:j	J
    //   360: invokevirtual 232	com/hjclass_mobile/d/o:a	(J)V
    //   363: goto -77 -> 286
    //   366: astore_2
    //   367: aload_0
    //   368: getfield 55	com/hjclass_mobile/b/f:k	Landroid/os/Handler;
    //   371: aload_0
    //   372: getfield 66	com/hjclass_mobile/b/f:n	Ljava/lang/Runnable;
    //   375: invokevirtual 180	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   378: aload_0
    //   379: iconst_1
    //   380: invokevirtual 183	com/hjclass_mobile/b/f:a	(Z)V
    //   383: aload_2
    //   384: invokevirtual 140	java/lang/Exception:printStackTrace	()V
    //   387: return
    //   388: ldc2_w 233
    //   391: invokestatic 239	java/lang/Thread:sleep	(J)V
    //   394: goto -93 -> 301
    //   397: astore 10
    //   399: aload 10
    //   401: invokevirtual 240	java/lang/InterruptedException:printStackTrace	()V
    //   404: goto -103 -> 301
    //   407: new 187	java/lang/StringBuilder
    //   410: dup
    //   411: ldc 242
    //   413: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   416: aload_0
    //   417: getfield 48	com/hjclass_mobile/b/f:i	Ljava/io/File;
    //   420: invokevirtual 247	java/io/File:length	()J
    //   423: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   426: ldc 249
    //   428: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: aload_0
    //   432: getfield 46	com/hjclass_mobile/b/f:h	Lcom/hjclass_mobile/d/o;
    //   435: invokevirtual 143	com/hjclass_mobile/d/o:b	()J
    //   438: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   441: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 176	com/hjclass_mobile/h/u:b	(Ljava/lang/String;)V
    //   447: new 187	java/lang/StringBuilder
    //   450: dup
    //   451: ldc 251
    //   453: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   456: aload_0
    //   457: getfield 48	com/hjclass_mobile/b/f:i	Ljava/io/File;
    //   460: invokevirtual 247	java/io/File:length	()J
    //   463: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   466: ldc 249
    //   468: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: aload_0
    //   472: getfield 46	com/hjclass_mobile/b/f:h	Lcom/hjclass_mobile/d/o;
    //   475: invokevirtual 143	com/hjclass_mobile/d/o:b	()J
    //   478: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   481: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 176	com/hjclass_mobile/h/u:b	(Ljava/lang/String;)V
    //   487: aload 5
    //   489: invokevirtual 254	java/io/InputStream:close	()V
    //   492: aload 6
    //   494: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   497: aload_0
    //   498: getfield 55	com/hjclass_mobile/b/f:k	Landroid/os/Handler;
    //   501: aload_0
    //   502: getfield 66	com/hjclass_mobile/b/f:n	Ljava/lang/Runnable;
    //   505: invokevirtual 180	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   508: aload_0
    //   509: invokespecial 70	com/hjclass_mobile/b/f:i	()V
    //   512: aload_0
    //   513: getfield 42	com/hjclass_mobile/b/f:f	Z
    //   516: ifne -465 -> 51
    //   519: aload_0
    //   520: iconst_1
    //   521: putfield 34	com/hjclass_mobile/b/f:b	Z
    //   524: return
    //
    // Exception table:
    //   from	to	target	type
    //   81	286	366	java/lang/Exception
    //   286	295	366	java/lang/Exception
    //   301	307	366	java/lang/Exception
    //   312	318	366	java/lang/Exception
    //   323	363	366	java/lang/Exception
    //   388	394	366	java/lang/Exception
    //   399	404	366	java/lang/Exception
    //   407	524	366	java/lang/Exception
    //   312	318	397	java/lang/InterruptedException
    //   388	394	397	java/lang/InterruptedException
  }

  public final void a(a parama)
  {
    this.m = parama;
  }

  public final void a(hjapp.com.hjclass_mobile.pkg_d.o paramo, e parame)
  {
    this.h = paramo;
    this.g = parame;
    String str = this.h.d().substring(1 + this.h.d().lastIndexOf('/'));
    this.i = new File(paramo.e(), str);
    int i1 = h();
    if (this.i.exists())
    {
      paramo.a(this.i.length());
      paramo.b(i1);
      hjapp.com.hjclass_mobile.pkg_h.u.b("上次文件下载文件大小" + paramo.a());
      hjapp.com.hjclass_mobile.pkg_h.u.b("文件总大小" + paramo.b());
    }
    while (true)
    {
      File localFile = new File(this.h.e());
      if (!localFile.exists())
        localFile.mkdirs();
      return;
      paramo.a(0L);
      paramo.b(i1);
      long[] arrayOfLong = new long[2];
      arrayOfLong[0] = i1;
      arrayOfLong[1] = 0L;
      this.g.a(this.h.d(), arrayOfLong, this.h.c());
    }
  }

  public final void a(boolean paramBoolean)
  {
    this.k.removeCallbacks(this.n);
    this.c = paramBoolean;
  }

  public final void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }

  public final boolean b()
  {
    return this.c;
  }

  public final void c()
  {
    if (this.g != null)
    {
      this.g.b(this.h.d(), this.h.c());
      if (this.i != null)
        this.i.deleteOnExit();
    }
    this.k.removeCallbacks(this.n);
  }

  public final void c(boolean paramBoolean)
  {
    if (this.g != null)
    {
      long[] arrayOfLong = new long[2];
      arrayOfLong[0] = this.h.b();
      arrayOfLong[1] = this.h.a();
      this.g.b(this.h.d(), arrayOfLong, this.h.c());
    }
    if (paramBoolean)
      this.k.removeCallbacks(this.n);
    while (true)
    {
      this.a = paramBoolean;
      return;
      this.k.removeCallbacks(this.n);
      this.k.post(this.n);
    }
  }

  public final void d(boolean paramBoolean)
  {
    c(paramBoolean);
    this.d = paramBoolean;
  }

  public final boolean d()
  {
    return this.e;
  }

  public final boolean e()
  {
    return this.a;
  }

  public final boolean f()
  {
    return this.d;
  }

  public final void g()
  {
    this.k.removeCallbacks(this.n);
    this.f = true;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     f
 * JD-Core Version:    0.6.2
 */