package hjapp.com.hjclass_mobile.f;

import android.content.Context;
import android.text.TextUtils;
import hjapp.com.core.RegisterLogicProvider;
import hjapp.com.hjclass_mobile.d.r;
import hjapp.com.hjclass_mobile.h.u;
import java.io.IOException;
import java.net.Proxy;
import java.net.URLEncoder;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  private static c b = null;
  private static String c = null;
  private static String d = null;
  private static String e = "";
  private static String f = "";
  private static int g;
  private static String h;
  private static Context k;
  Proxy a = null;
  private int i = 5000;
  private int j = 10000;

  private static r a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool1 = true;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString1);
      r localr = new r();
      boolean bool2;
      boolean bool3;
      if (localJSONObject.getInt("IsLogin") > 0)
      {
        bool2 = bool1;
        localr.b(bool2);
        localr.b(localJSONObject.getString("Token"));
        localr.a(localJSONObject.getString("Key"));
        localr.a(localJSONObject.getInt("UserID"));
        localr.b(localJSONObject.getInt("ClassNum"));
        localr.d(paramString2);
        localr.a(new Date().getTime());
        if (localJSONObject.getInt("MaxClient") != 101)
          break label165;
        bool3 = bool1;
        label125: localr.a(bool3);
        if (localJSONObject.getInt("MaxClient") != 102)
          break label171;
      }
      while (true)
      {
        localr.c(bool1);
        localr.c(paramString3);
        return localr;
        bool2 = false;
        break;
        label165: bool3 = false;
        break label125;
        label171: bool1 = false;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }

  public static c a(Context paramContext)
  {
    if (b == null)
      b = new c();
    k = paramContext;
    return b;
  }

  public static String a()
  {
    return c;
  }

  // ERROR //
  private String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 111	com/hjclass_mobile/f/c:k	Landroid/content/Context;
    //   3: ldc 117
    //   5: invokevirtual 123	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   8: checkcast 125	android/net/ConnectivityManager
    //   11: invokevirtual 129	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnull +61 -> 77
    //   19: aload_3
    //   20: invokevirtual 135	android/net/NetworkInfo:isAvailable	()Z
    //   23: ifeq +54 -> 77
    //   26: aload_3
    //   27: invokevirtual 139	android/net/NetworkInfo:getType	()I
    //   30: ifne +47 -> 77
    //   33: invokestatic 144	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   36: astore 13
    //   38: invokestatic 147	android/net/Proxy:getDefaultPort	()I
    //   41: istore 14
    //   43: aload 13
    //   45: ifnull +32 -> 77
    //   48: new 149	java/net/InetSocketAddress
    //   51: dup
    //   52: aload 13
    //   54: iload 14
    //   56: invokespecial 152	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   59: astore 15
    //   61: aload_0
    //   62: new 154	java/net/Proxy
    //   65: dup
    //   66: getstatic 160	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   69: aload 15
    //   71: invokespecial 163	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   74: putfield 43	com/hjclass_mobile/f/c:a	Ljava/net/Proxy;
    //   77: new 165	java/util/ArrayList
    //   80: dup
    //   81: invokespecial 166	java/util/ArrayList:<init>	()V
    //   84: new 168	org/apache/http/message/BasicNameValuePair
    //   87: dup
    //   88: ldc 170
    //   90: aload_1
    //   91: invokespecial 173	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: invokevirtual 177	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   97: pop
    //   98: new 179	java/net/URL
    //   101: dup
    //   102: aload_2
    //   103: invokespecial 180	java/net/URL:<init>	(Ljava/lang/String;)V
    //   106: astore 5
    //   108: aload_0
    //   109: getfield 43	com/hjclass_mobile/f/c:a	Ljava/net/Proxy;
    //   112: ifnull +132 -> 244
    //   115: aload 5
    //   117: aload_0
    //   118: getfield 43	com/hjclass_mobile/f/c:a	Ljava/net/Proxy;
    //   121: invokevirtual 184	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   124: checkcast 186	java/net/HttpURLConnection
    //   127: astore 12
    //   129: aload 12
    //   131: astore 7
    //   133: aload 7
    //   135: aload_0
    //   136: getfield 39	com/hjclass_mobile/f/c:i	I
    //   139: invokevirtual 189	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   142: aload 7
    //   144: aload_0
    //   145: getfield 41	com/hjclass_mobile/f/c:j	I
    //   148: invokevirtual 192	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   151: aload 7
    //   153: iconst_1
    //   154: invokevirtual 195	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   157: aload 7
    //   159: iconst_1
    //   160: invokevirtual 198	java/net/HttpURLConnection:setDoInput	(Z)V
    //   163: aload 7
    //   165: ldc 200
    //   167: invokevirtual 203	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   170: aload 7
    //   172: iconst_0
    //   173: invokevirtual 206	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   176: aload 7
    //   178: iconst_1
    //   179: invokevirtual 209	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   182: aload 7
    //   184: ldc 211
    //   186: ldc 213
    //   188: invokevirtual 216	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload 7
    //   193: invokevirtual 219	java/net/HttpURLConnection:connect	()V
    //   196: new 221	java/io/DataOutputStream
    //   199: dup
    //   200: aload 7
    //   202: invokevirtual 225	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   205: invokespecial 228	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   208: astore 10
    //   210: aload 10
    //   212: aload_1
    //   213: invokevirtual 231	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   216: aload 10
    //   218: invokevirtual 234	java/io/DataOutputStream:flush	()V
    //   221: aload 10
    //   223: invokevirtual 237	java/io/DataOutputStream:close	()V
    //   226: aload 7
    //   228: invokevirtual 241	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   231: invokestatic 246	com/hjclass_mobile/a/b:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   234: astore 11
    //   236: aload 7
    //   238: invokevirtual 249	java/net/HttpURLConnection:disconnect	()V
    //   241: aload 11
    //   243: areturn
    //   244: aload 5
    //   246: invokevirtual 252	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   249: checkcast 186	java/net/HttpURLConnection
    //   252: astore 9
    //   254: aload 9
    //   256: astore 7
    //   258: goto -125 -> 133
    //   261: astore 8
    //   263: aconst_null
    //   264: astore 7
    //   266: aload 8
    //   268: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   271: aload 7
    //   273: invokevirtual 249	java/net/HttpURLConnection:disconnect	()V
    //   276: aconst_null
    //   277: areturn
    //   278: astore 6
    //   280: aconst_null
    //   281: astore 7
    //   283: aload 7
    //   285: invokevirtual 249	java/net/HttpURLConnection:disconnect	()V
    //   288: aload 6
    //   290: athrow
    //   291: astore 6
    //   293: goto -10 -> 283
    //   296: astore 8
    //   298: goto -32 -> 266
    //
    // Exception table:
    //   from	to	target	type
    //   98	129	261	java/io/IOException
    //   244	254	261	java/io/IOException
    //   98	129	278	finally
    //   244	254	278	finally
    //   133	236	291	finally
    //   266	271	291	finally
    //   133	236	296	java/io/IOException
  }

  public static void a(int paramInt)
  {
    g = paramInt;
  }

  public static void a(RegisterLogicProvider paramRegisterLogicProvider, int paramInt1, int paramInt2)
  {
    try
    {
      paramRegisterLogicProvider.verificationMobileCode(paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void a(RegisterLogicProvider paramRegisterLogicProvider, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramRegisterLogicProvider.setAction(paramString5);
    paramRegisterLogicProvider.setUserName(paramString1);
    paramRegisterLogicProvider.setMethod("POST");
    paramRegisterLogicProvider.setSource("android_hjclass_mobile");
    paramRegisterLogicProvider.setTimeOut(50000);
    paramRegisterLogicProvider.setUserPwd(paramString2);
    paramRegisterLogicProvider.setEmail(paramString4);
    if (paramString5.equals("register_by_mobile"))
      paramRegisterLogicProvider.setMobile(paramString3);
    paramRegisterLogicProvider.register();
  }

  public static void a(String paramString)
  {
    c = paramString;
  }

  public static int b()
  {
    return g;
  }

  public static void b(String paramString)
  {
    d = paramString;
  }

  public static String c()
  {
    return f;
  }

  public static void c(String paramString)
  {
    f = paramString;
  }

  public static String d()
  {
    return h;
  }

  public static void d(String paramString)
  {
    h = paramString;
  }

  public static String e()
  {
    return e;
  }

  public static void e(String paramString)
  {
    e = paramString;
  }

  public final r a(String paramString1, String paramString2, String paramString3, String paramString4, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString3))
      paramString3 = "";
    String str1 = b.a(paramContext);
    try
    {
      String str2 = "username=" + URLEncoder.encode(paramString1, "UTF-8") + "&userpwd=" + URLEncoder.encode(paramString2, "UTF-8") + "&key=" + paramString3 + "&uid=" + str1 + "&os=android&devicename=" + paramString4 + "&versionNumber=4";
      u.c("content:", str2);
      String str3 = a(str2, "http://class.swfplayer.net/api/mobile/login.php");
      if (str3 != null)
      {
        u.c("result:", str3);
        String str4 = new String(str3);
        if (!TextUtils.isEmpty(str4))
        {
          r localr = a(str4, paramString1, paramString2);
          return localr;
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return null;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     c
 * JD-Core Version:    0.6.2
 */