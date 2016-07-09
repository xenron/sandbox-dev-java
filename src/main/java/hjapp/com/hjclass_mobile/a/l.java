package hjapp.com.hjclass_mobile.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public final class l
{
  java.net.Proxy a = null;
  Context b;
  private int c = 30000;
  private int d = 30000;

  public l(Context paramContext)
  {
    this.b = paramContext;
    HttpsURLConnection.setDefaultHostnameVerifier(new m(this));
  }

  private void a()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.b.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()) && (localNetworkInfo.getType() == 0))
    {
      String str = android.net.Proxy.getDefaultHost();
      int i = android.net.Proxy.getDefaultPort();
      if (str != null)
      {
        InetSocketAddress localInetSocketAddress = new InetSocketAddress(str, i);
        this.a = new java.net.Proxy(Proxy.Type.HTTP, localInetSocketAddress);
      }
    }
  }

  // ERROR //
  public final String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 89	com/hjclass_mobile/a/l:a	()V
    //   4: new 91	java/util/ArrayList
    //   7: dup
    //   8: invokespecial 92	java/util/ArrayList:<init>	()V
    //   11: astore_3
    //   12: aload_3
    //   13: new 94	org/apache/http/message/BasicNameValuePair
    //   16: dup
    //   17: ldc 96
    //   19: aload_1
    //   20: invokespecial 99	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: invokevirtual 103	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   26: pop
    //   27: new 105	org/apache/http/client/entity/UrlEncodedFormEntity
    //   30: dup
    //   31: aload_3
    //   32: ldc 107
    //   34: invokespecial 110	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   37: astore 5
    //   39: new 112	java/net/URL
    //   42: dup
    //   43: aload_2
    //   44: invokespecial 115	java/net/URL:<init>	(Ljava/lang/String;)V
    //   47: astore 6
    //   49: aload_0
    //   50: getfield 22	com/hjclass_mobile/a/l:a	Ljava/net/Proxy;
    //   53: ifnull +96 -> 149
    //   56: aload 6
    //   58: aload_0
    //   59: getfield 22	com/hjclass_mobile/a/l:a	Ljava/net/Proxy;
    //   62: invokevirtual 119	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   65: checkcast 121	java/net/HttpURLConnection
    //   68: astore 13
    //   70: aload 13
    //   72: astore 8
    //   74: aload 8
    //   76: aload_0
    //   77: getfield 18	com/hjclass_mobile/a/l:c	I
    //   80: invokevirtual 125	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   83: aload 8
    //   85: aload_0
    //   86: getfield 20	com/hjclass_mobile/a/l:d	I
    //   89: invokevirtual 128	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   92: aload 8
    //   94: iconst_1
    //   95: invokevirtual 132	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   98: aload 8
    //   100: ldc 134
    //   102: ldc 136
    //   104: invokevirtual 139	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload 8
    //   109: invokevirtual 142	java/net/HttpURLConnection:connect	()V
    //   112: aload 8
    //   114: invokevirtual 146	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   117: astore 11
    //   119: aload 5
    //   121: aload 11
    //   123: invokevirtual 150	org/apache/http/client/entity/UrlEncodedFormEntity:writeTo	(Ljava/io/OutputStream;)V
    //   126: aload 11
    //   128: invokevirtual 155	java/io/OutputStream:flush	()V
    //   131: aload 8
    //   133: invokevirtual 159	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   136: invokestatic 164	com/hjclass_mobile/a/b:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   139: astore 12
    //   141: aload 8
    //   143: invokevirtual 167	java/net/HttpURLConnection:disconnect	()V
    //   146: aload 12
    //   148: areturn
    //   149: aload 6
    //   151: invokevirtual 170	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   154: checkcast 121	java/net/HttpURLConnection
    //   157: astore 10
    //   159: aload 10
    //   161: astore 8
    //   163: goto -89 -> 74
    //   166: astore 9
    //   168: aconst_null
    //   169: astore 8
    //   171: aload 9
    //   173: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   176: aload 8
    //   178: invokevirtual 167	java/net/HttpURLConnection:disconnect	()V
    //   181: aconst_null
    //   182: areturn
    //   183: astore 7
    //   185: aconst_null
    //   186: astore 8
    //   188: aload 8
    //   190: invokevirtual 167	java/net/HttpURLConnection:disconnect	()V
    //   193: aload 7
    //   195: athrow
    //   196: astore 7
    //   198: goto -10 -> 188
    //   201: astore 9
    //   203: goto -32 -> 171
    //
    // Exception table:
    //   from	to	target	type
    //   27	70	166	java/io/IOException
    //   149	159	166	java/io/IOException
    //   27	70	183	finally
    //   149	159	183	finally
    //   74	141	196	finally
    //   171	176	196	finally
    //   74	141	201	java/io/IOException
  }

  public final boolean b(String paramString1, String paramString2)
  {
    a();
    InputStream localInputStream;
    FileOutputStream localFileOutputStream;
    while (true)
    {
      URL localURL;
      try
      {
        localURL = new URL(paramString1);
        if (this.a != null)
        {
          localHttpURLConnection = (HttpURLConnection)localURL.openConnection(this.a);
          localHttpURLConnection.setConnectTimeout(this.c);
          localHttpURLConnection.setReadTimeout(this.d);
          localHttpURLConnection.setDoInput(true);
          localHttpURLConnection.connect();
          localInputStream = localHttpURLConnection.getInputStream();
          File localFile = new File(paramString2);
          localFile.createNewFile();
          localFileOutputStream = new FileOutputStream(localFile);
          byte[] arrayOfByte = new byte[1024];
          int i = localInputStream.read(arrayOfByte);
          if (i <= 0)
            break;
          localFileOutputStream.write(arrayOfByte, 0, i);
          continue;
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return false;
      }
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)localURL.openConnection();
    }
    localFileOutputStream.close();
    localInputStream.close();
    return true;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     l
 * JD-Core Version:    0.6.2
 */