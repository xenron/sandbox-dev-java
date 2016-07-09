package hjapp.com.umeng.fb.util;

import android.content.Context;
import android.util.Log;
import hjapp.com.umeng.fb.a.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

public class a
{
  static final String a = "Helper";
  private static final int b = 30000;

  public static c a(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    return new hjapp.com.umeng.fb.a.a().a(new hjapp.com.umeng.fb.a.b(paramString2, paramJSONObject, paramString1));
  }

  public static String a()
  {
    String str = String.valueOf(System.currentTimeMillis());
    return "RP" + str + String.valueOf((int)(1000.0D + 9000.0D * Math.random()));
  }

  public static String a(String paramString)
  {
    return b(paramString, null, null);
  }

  public static String a(String paramString1, String paramString2, String paramString3)
  {
    String str = String.valueOf(System.currentTimeMillis());
    return paramString1 + "[" + paramString2 + "_" + paramString3 + "]" + str + String.valueOf((int)(1000.0D + 9000.0D * Math.random()));
  }

  public static String a(Date paramDate, Context paramContext)
  {
    if (paramDate == null)
      return "";
    Locale localLocale = paramContext.getResources().getConfiguration().locale;
    if (Locale.CHINA.equals(localLocale));
    for (SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("M月d日", localLocale); ; localSimpleDateFormat = new SimpleDateFormat("dd MMMM", localLocale))
      return localSimpleDateFormat.format(paramDate);
  }

  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool = true;
    Log.i("Helper", "[reply_id_of_b]" + paramString2);
    if ((paramString1 == null) || (paramString2 == null))
      bool = false;
    while (true)
    {
      return bool;
      try
      {
        double d1 = Double.parseDouble(paramString1.substring(2));
        double d2 = Double.parseDouble(paramString2.substring(2));
        if (d1 < d2)
          return false;
      }
      catch (Exception localException)
      {
        Log.w("Helper", "reply id invalid.LocalMaxReplyId:" + paramString1 + "reply_id_of_b:" + paramString2);
      }
    }
    return bool;
  }

  // ERROR //
  private static String b(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +182 -> 183
    //   4: new 153	java/util/ArrayList
    //   7: dup
    //   8: iconst_1
    //   9: invokespecial 156	java/util/ArrayList:<init>	(I)V
    //   12: astore_3
    //   13: aload_3
    //   14: new 158	org/apache/http/message/BasicNameValuePair
    //   17: dup
    //   18: aload_1
    //   19: aload_2
    //   20: invokevirtual 161	org/json/JSONObject:toString	()Ljava/lang/String;
    //   23: invokespecial 164	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: invokeinterface 169 2 0
    //   31: pop
    //   32: new 171	org/apache/http/client/entity/UrlEncodedFormEntity
    //   35: dup
    //   36: aload_3
    //   37: ldc 173
    //   39: invokespecial 176	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   42: astore 5
    //   44: new 178	org/apache/http/client/methods/HttpPost
    //   47: dup
    //   48: aload_0
    //   49: invokespecial 179	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   52: astore 6
    //   54: aload 6
    //   56: aload 5
    //   58: invokeinterface 185 1 0
    //   63: invokeinterface 191 2 0
    //   68: aload 6
    //   70: checkcast 178	org/apache/http/client/methods/HttpPost
    //   73: aload 5
    //   75: invokevirtual 195	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   78: aload 6
    //   80: astore 7
    //   82: new 197	org/apache/http/impl/client/DefaultHttpClient
    //   85: dup
    //   86: invokespecial 198	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   89: astore 8
    //   91: aload 8
    //   93: invokeinterface 204 1 0
    //   98: astore 9
    //   100: aload 9
    //   102: sipush 30000
    //   105: invokestatic 210	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   108: aload 9
    //   110: sipush 30000
    //   113: invokestatic 213	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   116: aload 9
    //   118: ldc2_w 214
    //   121: invokestatic 221	org/apache/http/conn/params/ConnManagerParams:setTimeout	(Lorg/apache/http/params/HttpParams;J)V
    //   124: aload 8
    //   126: aload 7
    //   128: checkcast 223	org/apache/http/client/methods/HttpUriRequest
    //   131: invokeinterface 227 2 0
    //   136: astore 11
    //   138: aload 11
    //   140: invokeinterface 233 1 0
    //   145: invokeinterface 239 1 0
    //   150: sipush 200
    //   153: if_icmpne +50 -> 203
    //   156: aload 11
    //   158: invokeinterface 243 1 0
    //   163: invokestatic 248	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   166: astore 12
    //   168: aload 12
    //   170: areturn
    //   171: astore 13
    //   173: new 250	java/lang/AssertionError
    //   176: dup
    //   177: aload 13
    //   179: invokespecial 253	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   182: athrow
    //   183: new 255	org/apache/http/client/methods/HttpGet
    //   186: dup
    //   187: aload_0
    //   188: invokespecial 256	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   191: astore 7
    //   193: goto -111 -> 82
    //   196: astore 10
    //   198: aload 10
    //   200: invokevirtual 259	java/lang/Exception:printStackTrace	()V
    //   203: aconst_null
    //   204: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   32	44	171	java/io/UnsupportedEncodingException
    //   124	168	196	java/lang/Exception
  }

  public static String b(Date paramDate, Context paramContext)
  {
    if (paramDate == null)
      return "";
    return new SimpleDateFormat("yyyy-M-d HH:mm", paramContext.getResources().getConfiguration().locale).format(paramDate);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     a
 * JD-Core Version:    0.6.2
 */