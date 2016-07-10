package hjapp.com.hjclass_mobile.pkg_b;

import android.os.AsyncTask;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

public final class k extends AsyncTask
{
  private String b;
  private final WeakReference c;

  public k(h paramh, ImageView paramImageView)
  {
    this.c = new WeakReference(paramImageView);
  }

  // ERROR //
  private static android.graphics.Bitmap a(String paramString)
  {
    // Byte code:
    //   0: new 31	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 34	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 38	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   13: checkcast 40	java/net/HttpURLConnection
    //   16: astore 8
    //   18: aload 8
    //   20: ldc 42
    //   22: ldc 44
    //   24: invokevirtual 48	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload 8
    //   29: astore_3
    //   30: new 50	com/hjclass_mobile/b/m
    //   33: dup
    //   34: aload_3
    //   35: invokevirtual 54	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   38: invokespecial 57	com/hjclass_mobile/b/m:<init>	(Ljava/io/InputStream;)V
    //   41: invokestatic 63	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   44: astore 7
    //   46: aload 7
    //   48: astore 5
    //   50: aload_3
    //   51: invokevirtual 66	java/net/HttpURLConnection:disconnect	()V
    //   54: aload 5
    //   56: areturn
    //   57: astore 10
    //   59: aload 10
    //   61: invokevirtual 69	java/net/MalformedURLException:printStackTrace	()V
    //   64: aconst_null
    //   65: astore_1
    //   66: goto -57 -> 9
    //   69: astore_2
    //   70: aconst_null
    //   71: astore_3
    //   72: aload_2
    //   73: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   76: goto -46 -> 30
    //   79: astore 4
    //   81: aconst_null
    //   82: astore 5
    //   84: aload 4
    //   86: astore 6
    //   88: aload 6
    //   90: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   93: aload 5
    //   95: areturn
    //   96: astore 6
    //   98: goto -10 -> 88
    //   101: astore 9
    //   103: aload 8
    //   105: astore_3
    //   106: aload 9
    //   108: astore_2
    //   109: goto -37 -> 72
    //
    // Exception table:
    //   from	to	target	type
    //   0	9	57	java/net/MalformedURLException
    //   9	18	69	java/io/IOException
    //   30	46	79	java/io/IOException
    //   50	54	96	java/io/IOException
    //   18	27	101	java/io/IOException
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     k
 * JD-Core Version:    0.6.2
 */