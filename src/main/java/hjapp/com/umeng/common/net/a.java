package hjapp.com.umeng.common.net;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.widget.RemoteViews;

import java.io.File;

final class a extends Thread
{
  private Context b;
  private String c;
  private Notification d;
  private int e;
  private int f = 0;
  private int g = -1;
  private int h = -1;
  private d i;
  private Handler j = new h(this);

  public a(DownloadingService paramDownloadingService, Context paramContext, d paramd)
  {
    try
    {
      this.b = paramContext;
      this.i = paramd;
      if (b.b())
      {
        this.c = Environment.getExternalStorageDirectory().getCanonicalPath();
        new File(this.c).mkdirs();
      }
      while (true)
      {
        this.c += "/download/.um/apk";
        new File(this.c).mkdirs();
        this.d = new Notification(17301633, "正在下载应用", 1L);
        String str = this.b.getPackageName();
        c.a(this.b);
        RemoteViews localRemoteViews = new RemoteViews(str, c.c("umeng_common_download_notification"));
        localRemoteViews.setProgressBar(hjapp.com.umeng.common.a.a.b(this.b), 100, 0, false);
        localRemoteViews.setTextViewText(hjapp.com.umeng.common.a.a.a(this.b), "0%");
        localRemoteViews.setTextViewText(hjapp.com.umeng.common.a.a.c(this.b), "正在下载应用" + this.i.b);
        c.a(this.b);
        localRemoteViews.setTextViewText(c.a("umeng_common_description"), "");
        c.a(this.b);
        localRemoteViews.setImageViewResource(c.a("umeng_common_appIcon"), 17301633);
        this.d.contentView = localRemoteViews;
        this.d.contentIntent = PendingIntent.getActivity(this.b, 0, new Intent(), 134217728);
        this.e = ((int)System.currentTimeMillis());
        if (this.e < 0)
          this.e = (-this.e);
        DownloadingService.a(paramDownloadingService).notify(this.e, this.d);
        return;
        this.c = this.b.getFilesDir().getAbsolutePath();
      }
    }
    catch (Exception localException)
    {
      hjapp.com.umeng.common.a.c(DownloadingService.a(), localException.getMessage(), localException);
      DownloadingService.a(paramDownloadingService).cancel(this.e);
    }
  }

  private void a(Exception paramException)
  {
    hjapp.com.umeng.common.a.b(DownloadingService.a(), "can not install. " + paramException.getMessage());
    this.d.contentView.setTextViewText(hjapp.com.umeng.common.a.a.c(this.b), this.i.b + " 下载失败，请检查网络。");
    DownloadingService.a(this.a).notify(this.e, this.d);
    DownloadingService.a(this.a).cancel(this.e);
    DownloadingService.b().remove(this.i);
  }

  // ERROR //
  private void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 74	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   9: aload_0
    //   10: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   13: getfield 235	com/umeng/common/net/d:c	Ljava/lang/String;
    //   16: invokestatic 240	com/umeng/common/b/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc 242
    //   24: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: astore 29
    //   32: invokestatic 52	com/umeng/common/b:b	()Z
    //   35: ifeq +504 -> 539
    //   38: new 60	java/io/File
    //   41: dup
    //   42: aload_0
    //   43: getfield 66	com/umeng/common/net/a:c	Ljava/lang/String;
    //   46: aload 29
    //   48: invokespecial 244	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: astore 30
    //   53: new 246	java/io/FileOutputStream
    //   56: dup
    //   57: aload 30
    //   59: iconst_1
    //   60: invokespecial 249	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   63: astore 5
    //   65: aload 30
    //   67: astore 31
    //   69: invokestatic 195	com/umeng/common/net/DownloadingService:a	()Ljava/lang/String;
    //   72: astore 33
    //   74: iconst_2
    //   75: anewarray 251	java/lang/Object
    //   78: astore 34
    //   80: aload 34
    //   82: iconst_0
    //   83: aload_0
    //   84: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   87: getfield 235	com/umeng/common/net/d:c	Ljava/lang/String;
    //   90: aastore
    //   91: aload 34
    //   93: iconst_1
    //   94: aload 31
    //   96: invokevirtual 193	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   99: aastore
    //   100: aload 33
    //   102: ldc 253
    //   104: aload 34
    //   106: invokestatic 259	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   109: invokestatic 261	com/umeng/common/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: new 263	java/net/URL
    //   115: dup
    //   116: aload_0
    //   117: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   120: getfield 235	com/umeng/common/net/d:c	Ljava/lang/String;
    //   123: invokespecial 264	java/net/URL:<init>	(Ljava/lang/String;)V
    //   126: invokevirtual 268	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   129: checkcast 270	java/net/HttpURLConnection
    //   132: astore 35
    //   134: aload 35
    //   136: ldc_w 272
    //   139: invokevirtual 275	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   142: aload 35
    //   144: ldc_w 277
    //   147: ldc_w 279
    //   150: invokevirtual 282	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload 35
    //   155: ldc_w 284
    //   158: ldc_w 286
    //   161: invokevirtual 289	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload 35
    //   166: sipush 5000
    //   169: invokevirtual 292	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   172: aload 35
    //   174: sipush 10000
    //   177: invokevirtual 295	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   180: aload 31
    //   182: invokevirtual 298	java/io/File:exists	()Z
    //   185: istore 36
    //   187: aconst_null
    //   188: astore_2
    //   189: iload 36
    //   191: ifeq +48 -> 239
    //   194: aload 31
    //   196: invokevirtual 301	java/io/File:length	()J
    //   199: lconst_0
    //   200: lcmp
    //   201: ifle +38 -> 239
    //   204: aload 35
    //   206: ldc_w 303
    //   209: new 74	java/lang/StringBuilder
    //   212: dup
    //   213: ldc_w 305
    //   216: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   219: aload 31
    //   221: invokevirtual 301	java/io/File:length	()J
    //   224: invokevirtual 308	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   227: ldc_w 310
    //   230: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokevirtual 282	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload 35
    //   241: invokevirtual 313	java/net/HttpURLConnection:connect	()V
    //   244: aload 35
    //   246: invokevirtual 317	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   249: astore 37
    //   251: aload 37
    //   253: astore_2
    //   254: iload_1
    //   255: ifne +52 -> 307
    //   258: aload_0
    //   259: iconst_0
    //   260: putfield 34	com/umeng/common/net/a:g	I
    //   263: aload_0
    //   264: aload 35
    //   266: invokevirtual 321	java/net/HttpURLConnection:getContentLength	()I
    //   269: putfield 36	com/umeng/common/net/a:h	I
    //   272: invokestatic 195	com/umeng/common/net/DownloadingService:a	()Ljava/lang/String;
    //   275: astore 71
    //   277: iconst_1
    //   278: anewarray 251	java/lang/Object
    //   281: astore 72
    //   283: aload 72
    //   285: iconst_0
    //   286: aload_0
    //   287: getfield 36	com/umeng/common/net/a:h	I
    //   290: invokestatic 327	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   293: aastore
    //   294: aload 71
    //   296: ldc_w 329
    //   299: aload 72
    //   301: invokestatic 259	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   304: invokestatic 261	com/umeng/common/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: sipush 4096
    //   310: newarray byte
    //   312: astore 39
    //   314: invokestatic 195	com/umeng/common/net/DownloadingService:a	()Ljava/lang/String;
    //   317: new 74	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   324: aload_0
    //   325: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   328: getfield 138	com/umeng/common/net/d:b	Ljava/lang/String;
    //   331: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: ldc_w 331
    //   337: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: aload_0
    //   341: getfield 36	com/umeng/common/net/a:h	I
    //   344: invokestatic 334	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   347: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokestatic 261	com/umeng/common/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload_0
    //   357: getfield 45	com/umeng/common/net/a:b	Landroid/content/Context;
    //   360: invokestatic 339	com/umeng/common/net/e:a	(Landroid/content/Context;)Lcom/umeng/common/net/e;
    //   363: aload_0
    //   364: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   367: getfield 341	com/umeng/common/net/d:a	Ljava/lang/String;
    //   370: aload_0
    //   371: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   374: getfield 235	com/umeng/common/net/d:c	Ljava/lang/String;
    //   377: invokevirtual 344	com/umeng/common/net/e:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   380: pop
    //   381: iconst_0
    //   382: istore 41
    //   384: aload_2
    //   385: aload 39
    //   387: invokevirtual 350	java/io/InputStream:read	([B)I
    //   390: istore 42
    //   392: iload 42
    //   394: ifle +1342 -> 1736
    //   397: aload 5
    //   399: aload 39
    //   401: iconst_0
    //   402: iload 42
    //   404: invokevirtual 354	java/io/FileOutputStream:write	([BII)V
    //   407: aload_0
    //   408: iload 42
    //   410: aload_0
    //   411: getfield 34	com/umeng/common/net/a:g	I
    //   414: iadd
    //   415: putfield 34	com/umeng/common/net/a:g	I
    //   418: iload 41
    //   420: iconst_1
    //   421: iadd
    //   422: istore 43
    //   424: iload 41
    //   426: bipush 50
    //   428: irem
    //   429: ifne +1300 -> 1729
    //   432: aload_0
    //   433: getfield 45	com/umeng/common/net/a:b	Landroid/content/Context;
    //   436: invokestatic 357	com/umeng/common/b:h	(Landroid/content/Context;)Z
    //   439: ifne +150 -> 589
    //   442: iconst_0
    //   443: istore 44
    //   445: aload_2
    //   446: invokevirtual 360	java/io/InputStream:close	()V
    //   449: aload 5
    //   451: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   454: iload 44
    //   456: ifne +585 -> 1041
    //   459: aload_0
    //   460: getfield 27	com/umeng/common/net/a:a	Lcom/umeng/common/net/DownloadingService;
    //   463: invokestatic 181	com/umeng/common/net/DownloadingService:a	(Lcom/umeng/common/net/DownloadingService;)Landroid/app/NotificationManager;
    //   466: aload_0
    //   467: getfield 176	com/umeng/common/net/a:e	I
    //   470: invokevirtual 207	android/app/NotificationManager:cancel	(I)V
    //   473: invokestatic 195	com/umeng/common/net/DownloadingService:a	()Ljava/lang/String;
    //   476: ldc_w 363
    //   479: invokestatic 214	com/umeng/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   482: invokestatic 219	com/umeng/common/net/DownloadingService:b	()Ljava/util/Map;
    //   485: aload_0
    //   486: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   489: invokeinterface 366 2 0
    //   494: checkcast 368	android/os/Messenger
    //   497: aconst_null
    //   498: iconst_5
    //   499: iconst_0
    //   500: iconst_0
    //   501: invokestatic 374	android/os/Message:obtain	(Landroid/os/Handler;III)Landroid/os/Message;
    //   504: invokevirtual 378	android/os/Messenger:send	(Landroid/os/Message;)V
    //   507: invokestatic 219	com/umeng/common/net/DownloadingService:b	()Ljava/util/Map;
    //   510: aload_0
    //   511: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   514: invokeinterface 225 2 0
    //   519: pop
    //   520: aload_2
    //   521: ifnull +7 -> 528
    //   524: aload_2
    //   525: invokevirtual 360	java/io/InputStream:close	()V
    //   528: aload 5
    //   530: ifnull +8 -> 538
    //   533: aload 5
    //   535: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   538: return
    //   539: aload_0
    //   540: aload_0
    //   541: getfield 45	com/umeng/common/net/a:b	Landroid/content/Context;
    //   544: invokevirtual 190	android/content/Context:getFilesDir	()Ljava/io/File;
    //   547: invokevirtual 193	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   550: putfield 66	com/umeng/common/net/a:c	Ljava/lang/String;
    //   553: aload_0
    //   554: getfield 45	com/umeng/common/net/a:b	Landroid/content/Context;
    //   557: aload 29
    //   559: ldc_w 379
    //   562: invokevirtual 383	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   565: astore 73
    //   567: aload 73
    //   569: astore 5
    //   571: aload_0
    //   572: getfield 45	com/umeng/common/net/a:b	Landroid/content/Context;
    //   575: aload 29
    //   577: invokevirtual 387	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   580: astore 74
    //   582: aload 74
    //   584: astore 31
    //   586: goto -517 -> 69
    //   589: ldc_w 388
    //   592: aload_0
    //   593: getfield 34	com/umeng/common/net/a:g	I
    //   596: i2f
    //   597: fmul
    //   598: aload_0
    //   599: getfield 36	com/umeng/common/net/a:h	I
    //   602: i2f
    //   603: fdiv
    //   604: f2i
    //   605: istore 64
    //   607: aload_0
    //   608: getfield 94	com/umeng/common/net/a:d	Landroid/app/Notification;
    //   611: getfield 154	android/app/Notification:contentView	Landroid/widget/RemoteViews;
    //   614: aload_0
    //   615: getfield 45	com/umeng/common/net/a:b	Landroid/content/Context;
    //   618: invokestatic 119	com/umeng/common/a/a:b	(Landroid/content/Context;)I
    //   621: bipush 100
    //   623: iload 64
    //   625: iconst_0
    //   626: invokevirtual 123	android/widget/RemoteViews:setProgressBar	(IIIZ)V
    //   629: aload_0
    //   630: getfield 94	com/umeng/common/net/a:d	Landroid/app/Notification;
    //   633: getfield 154	android/app/Notification:contentView	Landroid/widget/RemoteViews;
    //   636: aload_0
    //   637: getfield 45	com/umeng/common/net/a:b	Landroid/content/Context;
    //   640: invokestatic 125	com/umeng/common/a/a:a	(Landroid/content/Context;)I
    //   643: new 74	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   650: iload 64
    //   652: invokestatic 334	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   655: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: ldc_w 390
    //   661: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: invokevirtual 131	android/widget/RemoteViews:setTextViewText	(ILjava/lang/CharSequence;)V
    //   670: aload_0
    //   671: getfield 27	com/umeng/common/net/a:a	Lcom/umeng/common/net/DownloadingService;
    //   674: invokestatic 181	com/umeng/common/net/DownloadingService:a	(Lcom/umeng/common/net/DownloadingService;)Landroid/app/NotificationManager;
    //   677: aload_0
    //   678: getfield 176	com/umeng/common/net/a:e	I
    //   681: aload_0
    //   682: getfield 94	com/umeng/common/net/a:d	Landroid/app/Notification;
    //   685: invokevirtual 187	android/app/NotificationManager:notify	(ILandroid/app/Notification;)V
    //   688: invokestatic 195	com/umeng/common/net/DownloadingService:a	()Ljava/lang/String;
    //   691: astore 65
    //   693: iconst_3
    //   694: anewarray 251	java/lang/Object
    //   697: astore 66
    //   699: aload 66
    //   701: iconst_0
    //   702: aload_0
    //   703: getfield 176	com/umeng/common/net/a:e	I
    //   706: invokestatic 327	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   709: aastore
    //   710: aload 66
    //   712: iconst_1
    //   713: iload 64
    //   715: invokestatic 327	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   718: aastore
    //   719: aload 66
    //   721: iconst_2
    //   722: aload_0
    //   723: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   726: getfield 138	com/umeng/common/net/d:b	Ljava/lang/String;
    //   729: aastore
    //   730: aload 65
    //   732: ldc_w 392
    //   735: aload 66
    //   737: invokestatic 259	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   740: invokestatic 261	com/umeng/common/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   743: invokestatic 219	com/umeng/common/net/DownloadingService:b	()Ljava/util/Map;
    //   746: aload_0
    //   747: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   750: invokeinterface 366 2 0
    //   755: ifnull +29 -> 784
    //   758: invokestatic 219	com/umeng/common/net/DownloadingService:b	()Ljava/util/Map;
    //   761: aload_0
    //   762: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   765: invokeinterface 366 2 0
    //   770: checkcast 368	android/os/Messenger
    //   773: aconst_null
    //   774: iconst_3
    //   775: iload 64
    //   777: iconst_0
    //   778: invokestatic 374	android/os/Message:obtain	(Landroid/os/Handler;III)Landroid/os/Message;
    //   781: invokevirtual 378	android/os/Messenger:send	(Landroid/os/Message;)V
    //   784: aload_0
    //   785: getfield 45	com/umeng/common/net/a:b	Landroid/content/Context;
    //   788: invokestatic 339	com/umeng/common/net/e:a	(Landroid/content/Context;)Lcom/umeng/common/net/e;
    //   791: aload_0
    //   792: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   795: getfield 341	com/umeng/common/net/d:a	Ljava/lang/String;
    //   798: aload_0
    //   799: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   802: getfield 235	com/umeng/common/net/d:c	Ljava/lang/String;
    //   805: iload 64
    //   807: invokevirtual 395	com/umeng/common/net/e:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   810: iload 43
    //   812: istore 41
    //   814: goto -430 -> 384
    //   817: astore 67
    //   819: invokestatic 195	com/umeng/common/net/DownloadingService:a	()Ljava/lang/String;
    //   822: astore 68
    //   824: iconst_1
    //   825: anewarray 251	java/lang/Object
    //   828: astore 69
    //   830: aload 69
    //   832: iconst_0
    //   833: aload_0
    //   834: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   837: getfield 138	com/umeng/common/net/d:b	Ljava/lang/String;
    //   840: aastore
    //   841: aload 68
    //   843: ldc_w 397
    //   846: aload 69
    //   848: invokestatic 259	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   851: invokestatic 214	com/umeng/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   854: invokestatic 219	com/umeng/common/net/DownloadingService:b	()Ljava/util/Map;
    //   857: aload_0
    //   858: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   861: aconst_null
    //   862: invokeinterface 401 3 0
    //   867: pop
    //   868: goto -84 -> 784
    //   871: astore 38
    //   873: aload_2
    //   874: astore 6
    //   876: aload 38
    //   878: astore 4
    //   880: invokestatic 195	com/umeng/common/net/DownloadingService:a	()Ljava/lang/String;
    //   883: aload 4
    //   885: invokevirtual 402	java/io/IOException:getMessage	()Ljava/lang/String;
    //   888: aload 4
    //   890: invokestatic 203	com/umeng/common/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    //   893: iconst_1
    //   894: aload_0
    //   895: getfield 32	com/umeng/common/net/a:f	I
    //   898: iadd
    //   899: istore 13
    //   901: aload_0
    //   902: iload 13
    //   904: putfield 32	com/umeng/common/net/a:f	I
    //   907: iload 13
    //   909: iconst_3
    //   910: if_icmple +491 -> 1401
    //   913: invokestatic 195	com/umeng/common/net/DownloadingService:a	()Ljava/lang/String;
    //   916: ldc_w 363
    //   919: invokestatic 214	com/umeng/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   922: invokestatic 219	com/umeng/common/net/DownloadingService:b	()Ljava/util/Map;
    //   925: aload_0
    //   926: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   929: invokeinterface 366 2 0
    //   934: checkcast 368	android/os/Messenger
    //   937: aconst_null
    //   938: iconst_5
    //   939: iconst_0
    //   940: iconst_0
    //   941: invokestatic 374	android/os/Message:obtain	(Landroid/os/Handler;III)Landroid/os/Message;
    //   944: invokevirtual 378	android/os/Messenger:send	(Landroid/os/Message;)V
    //   947: aload_0
    //   948: aload 4
    //   950: invokespecial 404	com/umeng/common/net/a:a	(Ljava/lang/Exception;)V
    //   953: aload 6
    //   955: ifnull +8 -> 963
    //   958: aload 6
    //   960: invokevirtual 360	java/io/InputStream:close	()V
    //   963: aload 5
    //   965: ifnull -427 -> 538
    //   968: aload 5
    //   970: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   973: return
    //   974: astore 15
    //   976: aload 15
    //   978: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   981: return
    //   982: astore 46
    //   984: aload 46
    //   986: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   989: return
    //   990: astore 49
    //   992: aload 49
    //   994: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   997: aload 5
    //   999: ifnull -461 -> 538
    //   1002: aload 5
    //   1004: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   1007: return
    //   1008: astore 50
    //   1010: aload 50
    //   1012: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   1015: return
    //   1016: astore 47
    //   1018: aload 5
    //   1020: ifnull +8 -> 1028
    //   1023: aload 5
    //   1025: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   1028: aload 47
    //   1030: athrow
    //   1031: astore 48
    //   1033: aload 48
    //   1035: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   1038: goto -10 -> 1028
    //   1041: aload_0
    //   1042: getfield 27	com/umeng/common/net/a:a	Lcom/umeng/common/net/DownloadingService;
    //   1045: invokestatic 410	com/umeng/common/net/DownloadingService:b	(Lcom/umeng/common/net/DownloadingService;)[Ljava/lang/String;
    //   1048: ifnull +13 -> 1061
    //   1051: aload_0
    //   1052: getfield 27	com/umeng/common/net/a:a	Lcom/umeng/common/net/DownloadingService;
    //   1055: invokestatic 410	com/umeng/common/net/DownloadingService:b	(Lcom/umeng/common/net/DownloadingService;)[Ljava/lang/String;
    //   1058: invokestatic 413	com/umeng/common/net/DownloadingService:a	([Ljava/lang/String;)V
    //   1061: aload_0
    //   1062: getfield 94	com/umeng/common/net/a:d	Landroid/app/Notification;
    //   1065: getfield 154	android/app/Notification:contentView	Landroid/widget/RemoteViews;
    //   1068: aload_0
    //   1069: getfield 45	com/umeng/common/net/a:b	Landroid/content/Context;
    //   1072: invokestatic 125	com/umeng/common/a/a:a	(Landroid/content/Context;)I
    //   1075: ldc_w 415
    //   1078: invokevirtual 131	android/widget/RemoteViews:setTextViewText	(ILjava/lang/CharSequence;)V
    //   1081: aload_0
    //   1082: getfield 45	com/umeng/common/net/a:b	Landroid/content/Context;
    //   1085: invokestatic 339	com/umeng/common/net/e:a	(Landroid/content/Context;)Lcom/umeng/common/net/e;
    //   1088: aload_0
    //   1089: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   1092: getfield 341	com/umeng/common/net/d:a	Ljava/lang/String;
    //   1095: aload_0
    //   1096: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   1099: getfield 235	com/umeng/common/net/d:c	Ljava/lang/String;
    //   1102: bipush 100
    //   1104: invokevirtual 395	com/umeng/common/net/e:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1107: new 60	java/io/File
    //   1110: dup
    //   1111: aload 31
    //   1113: invokevirtual 418	java/io/File:getParent	()Ljava/lang/String;
    //   1116: aload 31
    //   1118: invokevirtual 421	java/io/File:getName	()Ljava/lang/String;
    //   1121: ldc_w 423
    //   1124: ldc 144
    //   1126: invokevirtual 427	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1129: invokespecial 244	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1132: astore 51
    //   1134: aload 31
    //   1136: aload 51
    //   1138: invokevirtual 431	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1141: pop
    //   1142: aload 51
    //   1144: invokevirtual 193	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1147: astore 53
    //   1149: new 433	android/os/Bundle
    //   1152: dup
    //   1153: invokespecial 434	android/os/Bundle:<init>	()V
    //   1156: astore 54
    //   1158: aload 54
    //   1160: ldc_w 436
    //   1163: aload 53
    //   1165: invokevirtual 439	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1168: invokestatic 442	android/os/Message:obtain	()Landroid/os/Message;
    //   1171: astore 55
    //   1173: aload 55
    //   1175: iconst_5
    //   1176: putfield 445	android/os/Message:what	I
    //   1179: aload 55
    //   1181: iconst_1
    //   1182: putfield 448	android/os/Message:arg1	I
    //   1185: aload 55
    //   1187: aload 54
    //   1189: invokevirtual 452	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1192: aload_0
    //   1193: getfield 43	com/umeng/common/net/a:j	Landroid/os/Handler;
    //   1196: aload 55
    //   1198: invokevirtual 458	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   1201: pop
    //   1202: invokestatic 442	android/os/Message:obtain	()Landroid/os/Message;
    //   1205: astore 57
    //   1207: aload 57
    //   1209: iconst_5
    //   1210: putfield 445	android/os/Message:what	I
    //   1213: aload 57
    //   1215: iconst_1
    //   1216: putfield 448	android/os/Message:arg1	I
    //   1219: aload 57
    //   1221: aload 54
    //   1223: invokevirtual 452	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1226: invokestatic 219	com/umeng/common/net/DownloadingService:b	()Ljava/util/Map;
    //   1229: aload_0
    //   1230: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   1233: invokeinterface 366 2 0
    //   1238: ifnull +23 -> 1261
    //   1241: invokestatic 219	com/umeng/common/net/DownloadingService:b	()Ljava/util/Map;
    //   1244: aload_0
    //   1245: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   1248: invokeinterface 366 2 0
    //   1253: checkcast 368	android/os/Messenger
    //   1256: aload 57
    //   1258: invokevirtual 378	android/os/Messenger:send	(Landroid/os/Message;)V
    //   1261: invokestatic 219	com/umeng/common/net/DownloadingService:b	()Ljava/util/Map;
    //   1264: aload_0
    //   1265: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   1268: invokeinterface 225 2 0
    //   1273: pop
    //   1274: aload_2
    //   1275: ifnull +7 -> 1282
    //   1278: aload_2
    //   1279: invokevirtual 360	java/io/InputStream:close	()V
    //   1282: aload 5
    //   1284: ifnull -746 -> 538
    //   1287: aload 5
    //   1289: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   1292: return
    //   1293: astore 59
    //   1295: aload 59
    //   1297: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   1300: return
    //   1301: astore 62
    //   1303: aload 62
    //   1305: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   1308: aload 5
    //   1310: ifnull -772 -> 538
    //   1313: aload 5
    //   1315: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   1318: return
    //   1319: astore 63
    //   1321: aload 63
    //   1323: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   1326: return
    //   1327: astore 60
    //   1329: aload 5
    //   1331: ifnull +8 -> 1339
    //   1334: aload 5
    //   1336: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   1339: aload 60
    //   1341: athrow
    //   1342: astore 61
    //   1344: aload 61
    //   1346: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   1349: goto -10 -> 1339
    //   1352: astore 20
    //   1354: aload 20
    //   1356: invokevirtual 459	android/os/RemoteException:printStackTrace	()V
    //   1359: invokestatic 219	com/umeng/common/net/DownloadingService:b	()Ljava/util/Map;
    //   1362: aload_0
    //   1363: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   1366: invokeinterface 225 2 0
    //   1371: pop
    //   1372: goto -425 -> 947
    //   1375: astore 7
    //   1377: aload 6
    //   1379: astore_2
    //   1380: aload_2
    //   1381: ifnull +7 -> 1388
    //   1384: aload_2
    //   1385: invokevirtual 360	java/io/InputStream:close	()V
    //   1388: aload 5
    //   1390: ifnull +8 -> 1398
    //   1393: aload 5
    //   1395: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   1398: aload 7
    //   1400: athrow
    //   1401: invokestatic 195	com/umeng/common/net/DownloadingService:a	()Ljava/lang/String;
    //   1404: new 74	java/lang/StringBuilder
    //   1407: dup
    //   1408: ldc_w 461
    //   1411: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1414: aload_0
    //   1415: getfield 32	com/umeng/common/net/a:f	I
    //   1418: invokevirtual 464	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1421: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1424: invokestatic 261	com/umeng/common/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1427: ldc2_w 465
    //   1430: invokestatic 470	java/lang/Thread:sleep	(J)V
    //   1433: aload_0
    //   1434: getfield 36	com/umeng/common/net/a:h	I
    //   1437: ifgt +22 -> 1459
    //   1440: aload_0
    //   1441: iconst_0
    //   1442: invokespecial 472	com/umeng/common/net/a:a	(Z)V
    //   1445: goto -492 -> 953
    //   1448: astore 14
    //   1450: aload_0
    //   1451: aload 14
    //   1453: invokespecial 404	com/umeng/common/net/a:a	(Ljava/lang/Exception;)V
    //   1456: goto -503 -> 953
    //   1459: aload_0
    //   1460: iconst_1
    //   1461: invokespecial 472	com/umeng/common/net/a:a	(Z)V
    //   1464: goto -511 -> 953
    //   1467: astore 18
    //   1469: aload 18
    //   1471: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   1474: aload 5
    //   1476: ifnull -938 -> 538
    //   1479: aload 5
    //   1481: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   1484: return
    //   1485: astore 19
    //   1487: aload 19
    //   1489: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   1492: return
    //   1493: astore 16
    //   1495: aload 5
    //   1497: ifnull +8 -> 1505
    //   1500: aload 5
    //   1502: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   1505: aload 16
    //   1507: athrow
    //   1508: astore 17
    //   1510: aload 17
    //   1512: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   1515: goto -10 -> 1505
    //   1518: astore 22
    //   1520: aconst_null
    //   1521: astore 5
    //   1523: invokestatic 219	com/umeng/common/net/DownloadingService:b	()Ljava/util/Map;
    //   1526: aload_0
    //   1527: getfield 47	com/umeng/common/net/a:i	Lcom/umeng/common/net/d;
    //   1530: invokeinterface 225 2 0
    //   1535: pop
    //   1536: aload 22
    //   1538: invokevirtual 459	android/os/RemoteException:printStackTrace	()V
    //   1541: aload_2
    //   1542: ifnull +7 -> 1549
    //   1545: aload_2
    //   1546: invokevirtual 360	java/io/InputStream:close	()V
    //   1549: aload 5
    //   1551: ifnull -1013 -> 538
    //   1554: aload 5
    //   1556: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   1559: return
    //   1560: astore 24
    //   1562: aload 24
    //   1564: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   1567: return
    //   1568: astore 27
    //   1570: aload 27
    //   1572: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   1575: aload 5
    //   1577: ifnull -1039 -> 538
    //   1580: aload 5
    //   1582: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   1585: return
    //   1586: astore 28
    //   1588: aload 28
    //   1590: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   1593: return
    //   1594: astore 25
    //   1596: aload 5
    //   1598: ifnull +8 -> 1606
    //   1601: aload 5
    //   1603: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   1606: aload 25
    //   1608: athrow
    //   1609: astore 26
    //   1611: aload 26
    //   1613: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   1616: goto -10 -> 1606
    //   1619: astore 8
    //   1621: aload 8
    //   1623: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   1626: goto -228 -> 1398
    //   1629: astore 11
    //   1631: aload 11
    //   1633: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   1636: aload 5
    //   1638: ifnull -240 -> 1398
    //   1641: aload 5
    //   1643: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   1646: goto -248 -> 1398
    //   1649: astore 12
    //   1651: aload 12
    //   1653: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   1656: goto -258 -> 1398
    //   1659: astore 9
    //   1661: aload 5
    //   1663: ifnull +8 -> 1671
    //   1666: aload 5
    //   1668: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   1671: aload 9
    //   1673: athrow
    //   1674: astore 10
    //   1676: aload 10
    //   1678: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   1681: goto -10 -> 1671
    //   1684: astore 7
    //   1686: aconst_null
    //   1687: astore_2
    //   1688: aconst_null
    //   1689: astore 5
    //   1691: goto -311 -> 1380
    //   1694: astore 7
    //   1696: goto -316 -> 1380
    //   1699: astore 22
    //   1701: goto -178 -> 1523
    //   1704: astore_3
    //   1705: aload_3
    //   1706: astore 4
    //   1708: aconst_null
    //   1709: astore 5
    //   1711: aconst_null
    //   1712: astore 6
    //   1714: goto -834 -> 880
    //   1717: astore 32
    //   1719: aload 32
    //   1721: astore 4
    //   1723: aconst_null
    //   1724: astore 6
    //   1726: goto -846 -> 880
    //   1729: iload 43
    //   1731: istore 41
    //   1733: goto -1349 -> 384
    //   1736: iconst_1
    //   1737: istore 44
    //   1739: goto -1294 -> 445
    //
    // Exception table:
    //   from	to	target	type
    //   743	784	817	android/os/DeadObjectException
    //   258	307	871	java/io/IOException
    //   307	381	871	java/io/IOException
    //   384	392	871	java/io/IOException
    //   397	418	871	java/io/IOException
    //   432	442	871	java/io/IOException
    //   445	454	871	java/io/IOException
    //   459	520	871	java/io/IOException
    //   589	743	871	java/io/IOException
    //   743	784	871	java/io/IOException
    //   784	810	871	java/io/IOException
    //   819	868	871	java/io/IOException
    //   1041	1061	871	java/io/IOException
    //   1061	1261	871	java/io/IOException
    //   1261	1274	871	java/io/IOException
    //   968	973	974	java/io/IOException
    //   533	538	982	java/io/IOException
    //   524	528	990	java/io/IOException
    //   1002	1007	1008	java/io/IOException
    //   524	528	1016	finally
    //   992	997	1016	finally
    //   1023	1028	1031	java/io/IOException
    //   1287	1292	1293	java/io/IOException
    //   1278	1282	1301	java/io/IOException
    //   1313	1318	1319	java/io/IOException
    //   1278	1282	1327	finally
    //   1303	1308	1327	finally
    //   1334	1339	1342	java/io/IOException
    //   913	947	1352	android/os/RemoteException
    //   880	907	1375	finally
    //   913	947	1375	finally
    //   947	953	1375	finally
    //   1354	1372	1375	finally
    //   1401	1427	1375	finally
    //   1427	1445	1375	finally
    //   1450	1456	1375	finally
    //   1459	1464	1375	finally
    //   1427	1445	1448	java/lang/InterruptedException
    //   1459	1464	1448	java/lang/InterruptedException
    //   958	963	1467	java/io/IOException
    //   1479	1484	1485	java/io/IOException
    //   958	963	1493	finally
    //   1469	1474	1493	finally
    //   1500	1505	1508	java/io/IOException
    //   2	65	1518	android/os/RemoteException
    //   539	567	1518	android/os/RemoteException
    //   1554	1559	1560	java/io/IOException
    //   1545	1549	1568	java/io/IOException
    //   1580	1585	1586	java/io/IOException
    //   1545	1549	1594	finally
    //   1570	1575	1594	finally
    //   1601	1606	1609	java/io/IOException
    //   1393	1398	1619	java/io/IOException
    //   1384	1388	1629	java/io/IOException
    //   1641	1646	1649	java/io/IOException
    //   1384	1388	1659	finally
    //   1631	1636	1659	finally
    //   1666	1671	1674	java/io/IOException
    //   2	65	1684	finally
    //   539	567	1684	finally
    //   69	187	1694	finally
    //   194	239	1694	finally
    //   239	251	1694	finally
    //   258	307	1694	finally
    //   307	381	1694	finally
    //   384	392	1694	finally
    //   397	418	1694	finally
    //   432	442	1694	finally
    //   445	454	1694	finally
    //   459	520	1694	finally
    //   571	582	1694	finally
    //   589	743	1694	finally
    //   743	784	1694	finally
    //   784	810	1694	finally
    //   819	868	1694	finally
    //   1041	1061	1694	finally
    //   1061	1261	1694	finally
    //   1261	1274	1694	finally
    //   1523	1541	1694	finally
    //   69	187	1699	android/os/RemoteException
    //   194	239	1699	android/os/RemoteException
    //   239	251	1699	android/os/RemoteException
    //   258	307	1699	android/os/RemoteException
    //   307	381	1699	android/os/RemoteException
    //   384	392	1699	android/os/RemoteException
    //   397	418	1699	android/os/RemoteException
    //   432	442	1699	android/os/RemoteException
    //   445	454	1699	android/os/RemoteException
    //   459	520	1699	android/os/RemoteException
    //   571	582	1699	android/os/RemoteException
    //   589	743	1699	android/os/RemoteException
    //   743	784	1699	android/os/RemoteException
    //   784	810	1699	android/os/RemoteException
    //   819	868	1699	android/os/RemoteException
    //   1041	1061	1699	android/os/RemoteException
    //   1061	1261	1699	android/os/RemoteException
    //   1261	1274	1699	android/os/RemoteException
    //   2	65	1704	java/io/IOException
    //   539	567	1704	java/io/IOException
    //   69	187	1717	java/io/IOException
    //   194	239	1717	java/io/IOException
    //   239	251	1717	java/io/IOException
    //   571	582	1717	java/io/IOException
  }

  public final void run()
  {
    this.f = 0;
    try
    {
      a(false);
      DownloadingService.b().remove(this.i);
      if (DownloadingService.b().size() <= 0)
        this.a.stopSelf();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     a
 * JD-Core Version:    0.6.2
 */