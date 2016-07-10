package hjapp.com.hjclass_mobile.pkg_f;

import android.text.TextUtils;
import android.util.Log;
import hjapp.com.hjclass_mobile.pkg_d.n;
import hjapp.com.hjclass_mobile.pkg_d.p;
import hjapp.com.hjclass_mobile.pkg_d.q;
import hjapp.com.hjclass_mobile.pkg_d.t;
import hjapp.com.hjclass_mobile.pkg_d.w;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import hjapp.com.hjclass_mobile.pkg_d.*;
import hjapp.com.hjclass_mobile.pkg_d.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static b f = null;
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private int d = 30000;
  private int e = 30000;

  public static u a(String paramString1, String paramString2)
  {
    try
    {
      URL localURL = new URL("http://class.swfplayer.net/api/mobile/getuserhome.php?token=" + paramString1 + "&v=4&device=" + paramString2);
      hjapp.com.hjclass_mobile.pkg_h.u.b("url=http://class.swfplayer.net/api/mobile/getuserhome.php?token=" + paramString1 + "&v=4");
      HttpURLConnection localHttpURLConnection = a(localURL);
      String str = new String(a(localHttpURLConnection.getInputStream()));
      localHttpURLConnection.disconnect();
      if (!d(str))
      {
        u localu1 = new u();
        localu1.k();
        return localu1;
      }
      u localu2 = e(str.replace("\r\n", "{br}"));
      return localu2;
    }
    catch (Exception localException)
    {
      hjapp.com.hjclass_mobile.pkg_h.u.a("Download Resource Task", localException.getMessage());
    }
    return null;
  }

  public static b a()
  {
    if (f == null)
      f = new b();
    return f;
  }

  private static HttpURLConnection a(URL paramURL)
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    localHttpURLConnection.setConnectTimeout(50000);
    localHttpURLConnection.setRequestMethod("GET");
    localHttpURLConnection.setRequestProperty("Connection", "Closed");
    localHttpURLConnection.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
    return localHttpURLConnection;
  }

  public static List a(String paramString1, int paramInt, String paramString2)
  {
    int i = 0;
    if (paramInt == 2);
    String str;
    try
    {
      URL localURL = new URL("http://hxjiang.duapp.com/api/mobile/mobile_getclasslist.ashx?token=" + paramString1 + "&isreserve=1&os=android&v=4&device=" + paramString2);
      Log.i("==url", "http://hxjiang.duapp.com/api/mobile/mobile_getclasslist.ashx?token=" + paramString1 + "&isreserve=1&os=android&v=4&device=" + paramString2);
      while (true)
      {
        HttpURLConnection localHttpURLConnection = a(localURL);
        str = new String(a(localHttpURLConnection.getInputStream()));
        localHttpURLConnection.disconnect();
        if (!TextUtils.isEmpty(str))
          break;
        return null;
        localURL = new URL("http://hxjiang.duapp.com/api/mobile/mobile_getclasslist.ashx?token=" + paramString1 + "&isexpired=" + paramInt + "&os=android&v=4&device=" + paramString2);
        Log.i("==url", "http://hxjiang.duapp.com/api/mobile/mobile_getclasslist.ashx?token=" + paramString1 + "&isExpired=" + paramInt + "&os=android&v=4&device=" + paramString2);
      }
    }
    catch (Exception localException)
    {
      Log.d("Download Resource Task", localException.getMessage());
      return null;
    }
    JSONArray localJSONArray = new JSONObject(str.replace("\r\n", "{br}")).getJSONArray("ClassList");
    ArrayList localArrayList = new ArrayList();
    int j = localJSONArray.length();
    while (i < j)
    {
      JSONObject localJSONObject = localJSONArray.getJSONObject(i);
      q localq = new q();
      localq.a(localJSONObject.getInt("ClassID"));
      localq.b(localJSONObject.getString("ClassName"));
      localq.b(localJSONObject.getInt("LessonNum"));
      localq.c(localJSONObject.getInt("StudyNum"));
      localq.d(0);
      localq.a(localJSONObject.getString("LastLesson"));
      localq.c(localJSONObject.getString("OpenTime"));
      localq.d(localJSONObject.getString("EndTime"));
      localq.h(String.valueOf(localJSONObject.getInt("Chargehb")));
      localq.e(localJSONObject.getString("IconName"));
      localq.g(localJSONObject.getString("Teacher"));
      localq.f(localJSONObject.getString("Summary").replace("{br}", "\n"));
      localq.e(c.b());
      if (localJSONObject.has("Key"))
        localq.k(localJSONObject.getString("Key"));
      if (localJSONObject.has("ClassType"))
        localq.h(localJSONObject.getInt("ClassType"));
      if (localJSONObject.has("IsEnsurePass"))
        localq.i(localJSONObject.getInt("IsEnsurePass"));
      if (localJSONObject.has("IsEnsurePassUser"))
        localq.j(localJSONObject.getInt("IsEnsurePassUser"));
      localq.f(paramInt);
      if (localJSONObject.has("Spell"))
        localq.j(localJSONObject.getString("Spell"));
      localq.g(1);
      localArrayList.add(localq);
      i++;
    }
    return localArrayList;
  }

  public static List a(String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    try
    {
      URL localURL = new URL("http://hxjiang.duapp.com/api/mobile/mobile_getcourse_v2.ashx?token=" + paramString1 + "&cate=" + paramString2 + "&v=4&device=" + paramString3);
      Log.i("==url", "http://hxjiang.duapp.com/api/mobile/mobile_getcourse_v2.ashx?token=" + paramString1 + "&cate=" + paramString2 + "&v=4&device=" + paramString3);
      HttpURLConnection localHttpURLConnection = a(localURL);
      String str = new String(a(localHttpURLConnection.getInputStream()));
      localHttpURLConnection.disconnect();
      if (TextUtils.isEmpty(str))
        return null;
      JSONArray localJSONArray = new JSONObject(str.replace("\r\n", "{br}")).getJSONArray("ClassList");
      ArrayList localArrayList = new ArrayList();
      int j = localJSONArray.length();
      while (i < j)
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        q localq = new q();
        localq.a(localJSONObject.getInt("ClassID"));
        localq.b(localJSONObject.getString("ClassName"));
        localq.b(0);
        localq.c(0);
        localq.d(0);
        localq.a("");
        localq.c(localJSONObject.getString("OpenTime"));
        localq.d(localJSONObject.getString("EndTime"));
        localq.h(String.valueOf(localJSONObject.getInt("Chargehb")));
        localq.e(localJSONObject.getString("IconName"));
        localq.g(localJSONObject.getString("Teacher"));
        localq.f(localJSONObject.getString("Summary").replace("{br}", "\n"));
        localq.e(c.b());
        localq.g(localJSONObject.getInt("IsOpen"));
        localq.j(localJSONObject.getString("Spell"));
        localq.i(paramString2);
        localq.f(0);
        localq.i(paramString2);
        if (localJSONObject.has("Key"))
          localq.k(localJSONObject.getString("Key"));
        if (localJSONObject.has("ClassType"))
          localq.h(localJSONObject.getInt("ClassType"));
        if (localJSONObject.has("IsEnsurePass"))
          localq.i(localJSONObject.getInt("IsEnsurePass"));
        if (localJSONObject.has("IsEnsurePassUser"))
          localq.j(localJSONObject.getInt("IsEnsurePassUser"));
        localq.j(localJSONObject.getString("Spell"));
        localArrayList.add(localq);
        i++;
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      Log.d("Download Resource Task", localException.getMessage());
    }
    return null;
  }

  public static JSONObject a(String paramString1, String paramString2, int paramInt)
  {
    String str = "http://hxjiang.duapp.com/api/mobile/mobile_exchange.ashx?username=" + paramString1 + "&userpwd=" + paramString2 + "&classid=" + paramInt;
    Log.i("====", str);
    return f(str);
  }

  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder("rnd=1");
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      localStringBuilder.append("&user=");
    try
    {
      localStringBuilder.append(URLEncoder.encode(paramString1, "UTF-8"));
      localStringBuilder.append("&userid=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("&mac=");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("&phonename=");
      localStringBuilder.append(URLEncoder.encode(paramString4));
      localStringBuilder.append("&ostype=1");
      localStringBuilder.append("&apptype=4");
      str1 = localStringBuilder.toString();
      Log.i("postLog==", str1);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      try
      {
        String str1;
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("http://1bulo.hujiang.com/app/api/client_Utility.ashx").openConnection();
        localHttpURLConnection.setDoOutput(true);
        localHttpURLConnection.setDoInput(true);
        localHttpURLConnection.setRequestMethod("POST");
        localHttpURLConnection.setUseCaches(false);
        localHttpURLConnection.setInstanceFollowRedirects(true);
        localHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        localHttpURLConnection.connect();
        DataOutputStream localDataOutputStream = new DataOutputStream(localHttpURLConnection.getOutputStream());
        localDataOutputStream.writeBytes(str1);
        localDataOutputStream.flush();
        localDataOutputStream.close();
        String str2 = new String(a(localHttpURLConnection.getInputStream()));
        Log.i("postLog==", "value=" + str2);
        localHttpURLConnection.disconnect();
        return;
        localUnsupportedEncodingException = localUnsupportedEncodingException;
        localUnsupportedEncodingException.printStackTrace();
        localStringBuilder.append(URLEncoder.encode(paramString1));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }

  public static boolean a(String paramString)
  {
    try
    {
      URL localURL = new URL("http://hxjiang.duapp.com/api/mobile/mobile_action.ashx?action=card&token=" + paramString + "&v=4");
      Log.i("==url", "http://hxjiang.duapp.com/api/mobile/mobile_action.ashx?token=" + paramString + "&v=4");
      HttpURLConnection localHttpURLConnection = null;
      try
      {
        localHttpURLConnection = a(localURL);
        boolean bool = new String(a(localHttpURLConnection.getInputStream())).equals("打卡成功");
        if (bool)
          return true;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        localHttpURLConnection.disconnect();
      }
      return false;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  private static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        break;
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    localByteArrayOutputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }

  public static List b(String paramString)
  {
    try
    {
      HttpURLConnection localHttpURLConnection = a(new URL("http://1bulo.hujiang.com/app/api/mobile_BuloUtility.ashx?action=get_more_app&alias=" + paramString));
      String str = new String(a(localHttpURLConnection.getInputStream()));
      localHttpURLConnection.disconnect();
      if (TextUtils.isEmpty(str))
        return null;
      JSONArray localJSONArray = new JSONArray(str);
      ArrayList localArrayList = new ArrayList();
      int i = localJSONArray.length();
      for (int j = 0; j < i; j++)
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(j);
        p localp = new p();
        localp.a(localJSONObject.getString("appname"));
        localp.b(localJSONObject.getString("appicon"));
        localp.c(localJSONObject.getString("desc"));
        localp.d(localJSONObject.getString("linkurl"));
        localArrayList.add(localp);
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  public static List b(String paramString1, String paramString2)
  {
    try
    {
      URL localURL = new URL("http://hxjiang.duapp.com/api/mobile/mobile_card.ashx?action=6nu19l&token=" + paramString2 + "&card=" + paramString1 + "&v=4");
      hjapp.com.hjclass_mobile.pkg_h.u.c("==url", "http://hxjiang.duapp.com/api/mobile/mobile_card.ashx?action=6nu19l&token=" + paramString2 + "&card=" + paramString1 + "&v=4");
      HttpURLConnection localHttpURLConnection = a(localURL);
      String str = new String(a(localHttpURLConnection.getInputStream()));
      localHttpURLConnection.disconnect();
      if (TextUtils.isEmpty(str))
        return null;
      hjapp.com.hjclass_mobile.pkg_h.u.d("学习卡获取的返回JSON为：", str);
      JSONObject localJSONObject1 = new JSONObject(str.replace("\r\n", "{br}"));
      if (Integer.parseInt(localJSONObject1.getString("code")) == 0)
      {
        ArrayList localArrayList1 = new ArrayList();
        w localw1 = new w();
        localw1.j(localJSONObject1.getString("msg"));
        hjapp.com.hjclass_mobile.pkg_h.u.d("学习卡返回的错误信息：", localw1.j());
        localArrayList1.add(localw1);
        return localArrayList1;
      }
      JSONArray localJSONArray = localJSONObject1.getJSONArray("list");
      ArrayList localArrayList2 = new ArrayList();
      int i = localJSONArray.length();
      for (int j = 0; j < i; j++)
      {
        JSONObject localJSONObject2 = localJSONArray.getJSONObject(j);
        w localw2 = new w();
        localw2.a(localJSONObject2.getString("ClassID"));
        localw2.b(localJSONObject2.getString("ClassName"));
        localw2.c("http://res.c.hjfile.cn/images/lesson/" + localJSONObject2.getString("IconName"));
        localw2.d(localJSONObject2.getString("ChargeHB"));
        localw2.e(localJSONObject2.getString("Teacher"));
        localw2.f(localJSONObject2.getString("BeginDate"));
        localw2.g(localJSONObject2.getString("EndDate"));
        localw2.h(localJSONObject2.getString("Summary"));
        localw2.i(localJSONObject2.getString("Langs"));
        localArrayList2.add(localw2);
      }
      return localArrayList2;
    }
    catch (Exception localException)
    {
      Log.d("Download Resource Task", localException.getMessage());
    }
    return null;
  }

  public static JSONObject b(String paramString1, String paramString2, String paramString3)
  {
    String str = "http://hxjiang.duapp.com/api/mobile/mobile_card.ashx?action=1f0q13&token=" + paramString1 + "&classid=" + paramString2 + "&card=" + paramString3;
    hjapp.com.hjclass_mobile.pkg_h.u.a("学习卡开课请求的详细数据：", str);
    return f(str);
  }

  public static JSONObject b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = "http://1pay.hujiang.com/api/mobile/GetOrder.ashx?user=" + paramString1 + "&pwd=" + paramString2 + "&xb=" + paramString3 + "&phone=" + paramString4;
    hjapp.com.hjclass_mobile.pkg_h.u.c("====", str);
    return f(str);
  }

  // ERROR //
  public static java.util.HashMap c(String paramString)
  {
    // Byte code:
    //   0: new 36	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 507
    //   7: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: aload_0
    //   11: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc_w 509
    //   17: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: astore_1
    //   24: ldc_w 312
    //   27: aload_1
    //   28: invokestatic 149	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   31: pop
    //   32: aload_1
    //   33: invokestatic 315	com/hjclass_mobile/f/b:f	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   36: astore_3
    //   37: aload_3
    //   38: ifnull +82 -> 120
    //   41: new 511	java/util/HashMap
    //   44: dup
    //   45: invokespecial 512	java/util/HashMap:<init>	()V
    //   48: astore 4
    //   50: aload 4
    //   52: ldc_w 514
    //   55: new 36	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   62: aload_3
    //   63: ldc_w 516
    //   66: invokevirtual 197	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   69: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokevirtual 520	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   78: pop
    //   79: aload 4
    //   81: ldc_w 522
    //   84: aload_3
    //   85: ldc_w 524
    //   88: invokevirtual 205	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   91: invokevirtual 520	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   94: pop
    //   95: aload 4
    //   97: areturn
    //   98: astore 8
    //   100: aconst_null
    //   101: astore 4
    //   103: aload 8
    //   105: astore 5
    //   107: aload 5
    //   109: invokevirtual 525	org/json/JSONException:printStackTrace	()V
    //   112: aload 4
    //   114: areturn
    //   115: astore 5
    //   117: goto -10 -> 107
    //   120: aconst_null
    //   121: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   41	50	98	org/json/JSONException
    //   50	95	115	org/json/JSONException
  }

  public static JSONObject c(String paramString1, String paramString2)
  {
    String str = "http://1pay.hujiang.com/api/mobile/getuserinfo.ashx?user=" + paramString1 + "&pwd=" + paramString2;
    Log.i("====", str);
    return f(str);
  }

  public static Boolean d(String paramString1, String paramString2)
  {
    String str1 = "http://class.swfplayer.net/api/mobile/mobile_unbinddevice.php?uid=" + paramString1 + "&token=" + paramString2;
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(str1).openConnection();
      localHttpURLConnection.setConnectTimeout(5000);
      localHttpURLConnection.setRequestMethod("GET");
      localHttpURLConnection.setRequestProperty("Connection", "Closed");
      localHttpURLConnection.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
      String str2 = new String(a(localHttpURLConnection.getInputStream()));
      localHttpURLConnection.disconnect();
      Boolean localBoolean = Boolean.valueOf(str2.toLowerCase().equals("true"));
      return localBoolean;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return Boolean.valueOf(false);
  }

  private static boolean d(String paramString)
  {
    boolean bool1 = true;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("Binded"))
      {
        boolean bool2 = localJSONObject.getBoolean("Binded");
        bool1 = bool2;
      }
      return bool1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return bool1;
  }

  private static u e(String paramString)
  {
    int i = 1;
    int k = 0;
    while (true)
    {
      u localu;
      String str;
      ArrayList localArrayList;
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        localu = new u();
        localu.c(localJSONObject1.getInt("TotalLesson"));
        localu.d(localJSONObject1.getInt("TotalMark"));
        localu.b(localJSONObject1.getInt("TotalTime"));
        localu.a(Float.parseFloat(String.valueOf(localJSONObject1.getDouble("Totalxb"))));
        localu.a(localJSONObject1.getInt("UserID"));
        if (localJSONObject1.getInt("IsCard") != i)
          break label583;
        localu.a(i);
        localu.a(c.c());
        localu.b("E999");
        if (localJSONObject1.has("IsShowMore"))
        {
          localu.b(localJSONObject1.getBoolean("IsShowMore"));
          if (localJSONObject1.has("MoreType"))
          {
            str = localJSONObject1.getString("MoreType");
            if (!str.equals("process"))
              continue;
            localu.e(0);
          }
        }
        JSONArray localJSONArray = localJSONObject1.getJSONArray("ClassList");
        localArrayList = new ArrayList();
        if (localJSONArray == null)
          break label573;
        int m = localJSONArray.length();
        if (k >= m)
          break label573;
        JSONObject localJSONObject2 = localJSONArray.getJSONObject(k);
        q localq = new q();
        localq.a(localJSONObject2.getInt("ClassID"));
        localq.b(localJSONObject2.getString("ClassName"));
        localq.b(localJSONObject2.getInt("LessonNum"));
        localq.c(localJSONObject2.getInt("StudyNum"));
        localq.d(0);
        localq.a(localJSONObject2.getString("LastLesson"));
        localq.c(localJSONObject2.getString("OpenTime"));
        localq.d(localJSONObject2.getString("EndTime"));
        localq.h(String.valueOf(localJSONObject2.getInt("Chargehb")));
        localq.e(localJSONObject2.getString("IconName"));
        localq.g(localJSONObject2.getString("Teacher"));
        localq.f(localJSONObject2.getString("Summary").replace("{br}", "\n"));
        localq.e(c.b());
        if (localJSONObject2.has("Key"))
          localq.k(localJSONObject2.getString("Key"));
        if (localJSONObject2.has("ClassType"))
          localq.h(localJSONObject2.getInt("ClassType"));
        if (localJSONObject2.has("IsEnsurePass"))
          localq.i(localJSONObject2.getInt("IsEnsurePass"));
        if (localJSONObject2.has("IsEnsurePassUser"))
          localq.j(localJSONObject2.getInt("IsEnsurePassUser"));
        localq.g(1);
        localq.f(0);
        localArrayList.add(localq);
        k++;
        continue;
        if (str.equals("reserve"))
        {
          localu.e(2);
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return null;
      }
      if (str.equals("expired"))
      {
        localu.e(1);
        continue;
        label573: localu.a(localArrayList);
        return localu;
        label583: int j = 0;
      }
    }
  }

  private static JSONObject f(String paramString)
  {
    try
    {
      String str = new String(a(a(new URL(paramString)).getInputStream()), "utf-8");
      hjapp.com.hjclass_mobile.pkg_h.u.a("jsonString=", str);
      if (TextUtils.isEmpty(str))
        return null;
      localJSONObject = new JSONObject(str);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        JSONObject localJSONObject = null;
      }
    }
  }

  public final List a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      URL localURL = new URL("http://hxjiang.duapp.com/api/mobile/mobile_getfeed.ashx?token=" + paramString + "&page=" + paramInt1 + "&type=" + paramInt2 + "&v=4");
      Log.i("==url", "http://hxjiang.duapp.com/api/mobile/mobile_getfeed.ashx?token=" + paramString + "&page=" + paramInt1 + "&type=" + paramInt2 + "&v=4");
      HttpURLConnection localHttpURLConnection = a(localURL);
      String str = new String(a(localHttpURLConnection.getInputStream()));
      localHttpURLConnection.disconnect();
      if (TextUtils.isEmpty(str))
        return null;
      JSONObject localJSONObject1 = new JSONObject(str.replace("\r\n", "{br}"));
      this.c = localJSONObject1.getInt("IngCount");
      JSONArray localJSONArray = localJSONObject1.getJSONArray("FeedList");
      ArrayList localArrayList = new ArrayList();
      int i = localJSONArray.length();
      for (int j = 0; j < i; j++)
      {
        JSONObject localJSONObject2 = localJSONArray.getJSONObject(j);
        n localn = new n();
        localn.l(String.valueOf(localJSONObject2.getInt("CommentCount")));
        localn.c(localJSONObject2.getString("Content"));
        localn.b(localJSONObject2.getString("DateAdded"));
        localn.a(String.valueOf(localJSONObject2.getInt("IngID")));
        localn.i(localJSONObject2.getString("PicUrlS"));
        localn.k(localJSONObject2.getString("PicUrl"));
        localn.j(localJSONObject2.getString("PicUrlM"));
        localn.d(String.valueOf(localJSONObject2.getInt("PublicFlag")));
        localn.f(String.valueOf(localJSONObject2.getInt("SourceID")));
        localn.e(localJSONObject2.getString("SendFrom"));
        localn.g(localJSONObject2.getString("UrlFrom"));
        localn.a(localJSONObject2.getInt("UserID"));
        localn.h(localJSONObject2.getString("UrlTag"));
        localn.m(hjapp.com.hjclass_mobile.pkg_h.z.c(String.valueOf(localn.h())));
        localn.n(localn.d());
        localArrayList.add(localn);
      }
      Log.i("return list", localArrayList.size());
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  public final List a(String paramString, int paramInt1, int paramInt2, Hashtable paramHashtable, boolean paramBoolean)
  {
    ArrayList localArrayList2;
    int k;
    int n;
    while (true)
    {
      JSONObject localJSONObject2;
      t localt2;
      t localt3;
      try
      {
        URL localURL = new URL("http://class.swfplayer.net/api/mobile/getlessonlist.php?token=" + paramString + "&classid=" + paramInt1 + "&page=" + paramInt2 + "&v=4");
        Log.i("==url", "http://class.swfplayer.net/api/mobile/getlessonlist.php?token=" + paramString + "&classid=" + paramInt1 + "&page=" + paramInt2);
        HttpURLConnection localHttpURLConnection = a(localURL);
        String str1 = new String(a(localHttpURLConnection.getInputStream()));
        localHttpURLConnection.disconnect();
        if (!d(str1))
        {
          ArrayList localArrayList1 = new ArrayList();
          t localt1 = new t();
          localt1.z();
          localArrayList1.add(localt1);
          return localArrayList1;
        }
        if (TextUtils.isEmpty(str1))
          return null;
        JSONObject localJSONObject1 = new JSONObject(str1.replace("\r\n", "{br}"));
        this.b = localJSONObject1.getInt("LessonNum");
        String str2 = localJSONObject1.getString("LessonUrl");
        int i = localJSONObject1.getInt("ClassID");
        JSONArray localJSONArray = localJSONObject1.getJSONArray("LessonList");
        localArrayList2 = new ArrayList();
        int j = localJSONArray.length();
        k = 1;
        int m = 0;
        if (m >= j)
          break;
        localJSONObject2 = localJSONArray.getJSONObject(m);
        localt2 = new t();
        localt2.d(i);
        localt2.c(localJSONObject2.getInt("LessonID"));
        localt2.b(localJSONObject2.getString("Title"));
        localt2.c("");
        localt2.a(c.b());
        localt2.h(localJSONObject2.getInt("SerialNum"));
        localt2.g(localJSONObject2.getInt("IsStudy"));
        String str3 = localJSONObject2.getString("PackUrl");
        if (localJSONObject2.has("LessonVersion"))
          localt2.l(localJSONObject2.getInt("LessonVersion"));
        String[] arrayOfString;
        if (str3 != null)
        {
          localt2.h(str2);
          arrayOfString = str3.split("/");
          if (arrayOfString.length == 1)
          {
            str4 = arrayOfString[0];
            localt2.a(localJSONObject2.getInt("MobileSize"));
            localt2.g(str3);
            localt2.d(str4);
          }
        }
        else
        {
          if (localJSONObject2.has("MediaType"))
            localt2.k(localJSONObject2.getInt("MediaType"));
          if (localJSONObject2.has("isLast"))
            localt2.c(localJSONObject2.getBoolean("isLast"));
          if (localJSONObject2.has("isCommpent"))
            localt2.b(localJSONObject2.getBoolean("isCommpent"));
          if ((localt2.n() != 1) && (localt2.n() != 0))
            continue;
          localt2.a(false);
          if (paramHashtable == null)
            break label911;
          localt3 = (t)paramHashtable.get(Integer.valueOf(localt2.c()));
          if (localt3 == null)
            break label889;
          localt2.b(localt3.b());
          localt2.j(localt3.u());
          localt2.e(localt3.f());
          localt2.i(localt3.s());
          if (localt3.j() <= 0)
            break label860;
          localt2.g(localt3.j());
          if ((paramBoolean) && (localt2.n() > 1))
          {
            if ((localt2.j() <= 0) || (localt2.n() <= 0))
              break label876;
            localt2.e(localt2.j());
            localt2.a(localt3.k());
            localt2.a(false);
          }
          if ((localt2.t()) || (localt2.j() != 0) || (localt2.n() <= 0))
            break label1082;
          n = 0;
          if (localt2.n() == 0)
            localt2.a(false);
          localt2.e(localt2.d() + "_" + localt2.c() + "_" + localt2.a());
          localArrayList2.add(localt2);
          m++;
          k = n;
          continue;
        }
        String str4 = arrayOfString[1];
        continue;
        if (!paramBoolean)
          continue;
        if ((localt2.j() > 0) && (localt2.n() > 0))
        {
          localt2.a(false);
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      localt2.a(true);
      continue;
      label860: localt2.g(localJSONObject2.getInt("IsStudy"));
      continue;
      label876: localt2.a(localt3.t());
      continue;
      label889: localt2.g(localJSONObject2.getInt("IsStudy"));
      localt2.a(0.0D);
      continue;
      label911: localt2.b(6);
      localt2.e(0);
      localt2.g(localJSONObject2.getInt("IsStudy"));
      localt2.a(0.0D);
    }
    int i1;
    int i2;
    int i3;
    if (k != 0)
    {
      Log.i("==", "无法学习。死课程");
      i1 = 0;
      i2 = localArrayList2.size();
      i3 = 0;
    }
    while (true)
    {
      if (i3 < i2)
      {
        t localt4 = (t)localArrayList2.get(i3);
        if ((!localt4.t()) && (localt4.j() > 0) && (localt4.n() > 0) && (i3 + 1 < i2))
        {
          i4 = i3 + 1;
          break label1089;
        }
      }
      else
      {
        if ((i1 > 0) && (i1 < localArrayList2.size()))
          ((t)localArrayList2.get(i1)).a(false);
        return localArrayList2;
      }
      int i4 = i1;
      break label1089;
      label1082: n = k;
      break;
      label1089: i3++;
      i1 = i4;
    }
  }

  public final List a(Hashtable paramHashtable)
  {
    while (true)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      ArrayList localArrayList3;
      int j;
      JSONObject localJSONObject2;
      t localt1;
      try
      {
        URL localURL = new URL("http://hxjiang.duapp.com/api/mobile/mobile_getdemo.ashx?v=4");
        Log.i("==url", "http://hxjiang.duapp.com/api/mobile/mobile_getdemo.ashx?v=4");
        HttpURLConnection localHttpURLConnection = a(localURL);
        String str1 = new String(a(localHttpURLConnection.getInputStream()));
        localHttpURLConnection.disconnect();
        if (TextUtils.isEmpty(str1))
          return null;
        JSONObject localJSONObject1 = new JSONObject(str1.replace("\r\n", "{br}"));
        this.b = localJSONObject1.getInt("LessonNum");
        String str2 = localJSONObject1.getString("LessonUrl");
        JSONArray localJSONArray = localJSONObject1.getJSONArray("LessonList");
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localArrayList3 = new ArrayList();
        int i = localJSONArray.length();
        j = 0;
        if (j >= i)
          break label614;
        localJSONObject2 = localJSONArray.getJSONObject(j);
        localt1 = new t();
        localt1.d(1);
        localt1.c(localJSONObject2.getInt("LessonID"));
        localt1.b(localJSONObject2.getString("Title"));
        localt1.c("");
        localt1.a(1);
        localt1.h(localJSONObject2.getInt("SerialNum"));
        localt1.g(localJSONObject2.getInt("IsStudy"));
        String str3 = localJSONObject2.getString("PackUrl");
        if (localJSONObject2.has("LessonVersion"))
          localt1.l(localJSONObject2.getInt("LessonVersion"));
        String[] arrayOfString;
        if (str3 != null)
        {
          localt1.h(str2);
          arrayOfString = str3.split("/");
          if (arrayOfString.length == 1)
          {
            str4 = arrayOfString[0];
            localt1.g(str3);
            localt1.d(str4);
          }
        }
        else
        {
          if (localJSONObject2.has("MediaType"))
            localt1.k(localJSONObject2.getInt("MediaType"));
          localt1.f(localJSONObject2.getString("ImgUrl"));
          if (paramHashtable == null)
            break label566;
          t localt2 = (t)paramHashtable.get(Integer.valueOf(localt1.c()));
          if (localt2 != null)
          {
            localt1.b(localt2.b());
            localt1.e(localt2.f());
            localt1.i(localt2.s());
          }
          if ((localt2 == null) || (localt1.j() <= 0))
            continue;
          localt1.e(localt2.j());
          localt1.a(localt2.k());
          localt1.e(localt1.d() + "_" + localt1.c() + "_" + localt1.a());
          if (!localt1.o().equals(""))
            break label601;
          localArrayList3.add(localt1);
          break label637;
        }
        String str4 = arrayOfString[1];
        continue;
        localt1.g(localJSONObject2.getInt("IsStudy"));
        localt1.a(0.0D);
        continue;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      label566: localt1.b(6);
      localt1.e(0);
      localt1.g(localJSONObject2.getInt("IsStudy"));
      localt1.a(0.0D);
      continue;
      label601: localArrayList2.add(localt1);
      break label637;
      label614: localArrayList1.add(localArrayList2);
      localArrayList1.add(localArrayList3);
      return localArrayList1;
      label637: j++;
    }
  }

  // ERROR //
  public final void a(String paramString, x paramx, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 810	com/hjclass_mobile/d/x:d	()J
    //   4: lconst_0
    //   5: lcmp
    //   6: ifne +4 -> 10
    //   9: return
    //   10: new 177	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 178	java/util/ArrayList:<init>	()V
    //   17: astore 4
    //   19: aload 4
    //   21: new 812	org/apache/http/message/BasicNameValuePair
    //   24: dup
    //   25: ldc_w 814
    //   28: ldc_w 816
    //   31: invokespecial 818	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: invokevirtual 819	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   37: pop
    //   38: aload 4
    //   40: new 812	org/apache/http/message/BasicNameValuePair
    //   43: dup
    //   44: ldc_w 821
    //   47: aload_1
    //   48: invokespecial 818	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: invokevirtual 819	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   54: pop
    //   55: aload 4
    //   57: new 812	org/apache/http/message/BasicNameValuePair
    //   60: dup
    //   61: ldc_w 823
    //   64: aload_2
    //   65: invokevirtual 824	com/hjclass_mobile/d/x:a	()I
    //   68: invokestatic 234	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   71: invokespecial 818	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: invokevirtual 819	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   77: pop
    //   78: aload 4
    //   80: new 812	org/apache/http/message/BasicNameValuePair
    //   83: dup
    //   84: ldc_w 826
    //   87: aload_2
    //   88: invokevirtual 827	com/hjclass_mobile/d/x:b	()I
    //   91: invokestatic 234	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   94: invokespecial 818	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: invokevirtual 819	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: aload 4
    //   103: new 812	org/apache/http/message/BasicNameValuePair
    //   106: dup
    //   107: ldc_w 829
    //   110: aload_2
    //   111: invokevirtual 810	com/hjclass_mobile/d/x:d	()J
    //   114: invokestatic 832	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   117: invokespecial 818	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: invokevirtual 819	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   123: pop
    //   124: iload_3
    //   125: iconst_4
    //   126: if_icmplt +68 -> 194
    //   129: aload 4
    //   131: new 812	org/apache/http/message/BasicNameValuePair
    //   134: dup
    //   135: ldc_w 834
    //   138: aload_2
    //   139: invokevirtual 836	com/hjclass_mobile/d/x:e	()D
    //   142: invokestatic 566	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   145: invokespecial 818	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: invokevirtual 819	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   151: pop
    //   152: aload 4
    //   154: new 812	org/apache/http/message/BasicNameValuePair
    //   157: dup
    //   158: ldc_w 838
    //   161: aload_2
    //   162: invokevirtual 839	com/hjclass_mobile/d/x:c	()Ljava/lang/String;
    //   165: invokestatic 842	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   168: invokespecial 818	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: invokevirtual 819	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   174: pop
    //   175: aload 4
    //   177: new 812	org/apache/http/message/BasicNameValuePair
    //   180: dup
    //   181: ldc_w 844
    //   184: ldc_w 846
    //   187: invokespecial 818	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: invokevirtual 819	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   193: pop
    //   194: aconst_null
    //   195: astore 10
    //   197: new 848	org/apache/http/client/entity/UrlEncodedFormEntity
    //   200: dup
    //   201: aload 4
    //   203: ldc_w 606
    //   206: invokespecial 851	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   209: astore 11
    //   211: new 34	java/net/URL
    //   214: dup
    //   215: ldc_w 853
    //   218: invokespecial 52	java/net/URL:<init>	(Ljava/lang/String;)V
    //   221: invokevirtual 115	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   224: checkcast 67	java/net/HttpURLConnection
    //   227: astore 14
    //   229: aload 14
    //   231: aload_0
    //   232: getfield 27	com/hjclass_mobile/f/b:d	I
    //   235: invokevirtual 120	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   238: aload 14
    //   240: aload_0
    //   241: getfield 29	com/hjclass_mobile/f/b:e	I
    //   244: invokevirtual 856	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   247: aload 14
    //   249: ldc_w 355
    //   252: invokevirtual 125	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   255: aload 14
    //   257: iconst_1
    //   258: invokevirtual 350	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   261: aload 14
    //   263: ldc_w 858
    //   266: ldc_w 860
    //   269: invokevirtual 863	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   272: aload 14
    //   274: invokevirtual 366	java/net/HttpURLConnection:connect	()V
    //   277: aload 14
    //   279: invokevirtual 372	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   282: astore 17
    //   284: aload 11
    //   286: aload 17
    //   288: invokevirtual 866	org/apache/http/client/entity/UrlEncodedFormEntity:writeTo	(Ljava/io/OutputStream;)V
    //   291: aload 17
    //   293: invokevirtual 869	java/io/OutputStream:flush	()V
    //   296: aload 17
    //   298: invokevirtual 870	java/io/OutputStream:close	()V
    //   301: ldc_w 872
    //   304: new 65	java/lang/String
    //   307: dup
    //   308: aload 14
    //   310: invokevirtual 71	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   313: invokestatic 74	com/hjclass_mobile/f/b:a	(Ljava/io/InputStream;)[B
    //   316: invokespecial 77	java/lang/String:<init>	([B)V
    //   319: invokestatic 149	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   322: pop
    //   323: aload 14
    //   325: invokevirtual 80	java/net/HttpURLConnection:disconnect	()V
    //   328: return
    //   329: astore 13
    //   331: aload 13
    //   333: invokevirtual 390	java/lang/Exception:printStackTrace	()V
    //   336: aload 10
    //   338: invokevirtual 80	java/net/HttpURLConnection:disconnect	()V
    //   341: return
    //   342: astore 12
    //   344: aload 10
    //   346: invokevirtual 80	java/net/HttpURLConnection:disconnect	()V
    //   349: aload 12
    //   351: athrow
    //   352: astore 16
    //   354: aload 14
    //   356: astore 10
    //   358: aload 16
    //   360: astore 12
    //   362: goto -18 -> 344
    //   365: astore 15
    //   367: aload 14
    //   369: astore 10
    //   371: aload 15
    //   373: astore 13
    //   375: goto -44 -> 331
    //
    // Exception table:
    //   from	to	target	type
    //   197	229	329	java/lang/Exception
    //   197	229	342	finally
    //   331	336	342	finally
    //   229	323	352	finally
    //   229	323	365	java/lang/Exception
  }

  public final int b()
  {
    return this.c;
  }

  // ERROR //
  public final void e(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 874
    //   3: aload_1
    //   4: invokestatic 149	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   7: pop
    //   8: new 177	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 178	java/util/ArrayList:<init>	()V
    //   15: astore 4
    //   17: aload 4
    //   19: new 812	org/apache/http/message/BasicNameValuePair
    //   22: dup
    //   23: ldc_w 876
    //   26: aload_1
    //   27: invokespecial 818	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: invokevirtual 819	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   33: pop
    //   34: aload 4
    //   36: new 812	org/apache/http/message/BasicNameValuePair
    //   39: dup
    //   40: ldc_w 821
    //   43: aload_2
    //   44: invokespecial 818	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: invokevirtual 819	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   50: pop
    //   51: aload 4
    //   53: new 812	org/apache/http/message/BasicNameValuePair
    //   56: dup
    //   57: ldc_w 844
    //   60: ldc_w 846
    //   63: invokespecial 818	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: invokevirtual 819	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   69: pop
    //   70: aconst_null
    //   71: astore 8
    //   73: new 848	org/apache/http/client/entity/UrlEncodedFormEntity
    //   76: dup
    //   77: aload 4
    //   79: ldc_w 606
    //   82: invokespecial 851	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   85: astore 9
    //   87: new 34	java/net/URL
    //   90: dup
    //   91: ldc_w 878
    //   94: invokespecial 52	java/net/URL:<init>	(Ljava/lang/String;)V
    //   97: invokevirtual 115	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   100: checkcast 67	java/net/HttpURLConnection
    //   103: astore 11
    //   105: aload 11
    //   107: aload_0
    //   108: getfield 27	com/hjclass_mobile/f/b:d	I
    //   111: invokevirtual 120	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   114: aload 11
    //   116: aload_0
    //   117: getfield 29	com/hjclass_mobile/f/b:e	I
    //   120: invokevirtual 856	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   123: aload 11
    //   125: ldc_w 355
    //   128: invokevirtual 125	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   131: aload 11
    //   133: iconst_1
    //   134: invokevirtual 350	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   137: aload 11
    //   139: ldc_w 858
    //   142: ldc_w 860
    //   145: invokevirtual 863	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload 11
    //   150: invokevirtual 366	java/net/HttpURLConnection:connect	()V
    //   153: aload 11
    //   155: invokevirtual 372	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   158: astore 13
    //   160: aload 9
    //   162: aload 13
    //   164: invokevirtual 866	org/apache/http/client/entity/UrlEncodedFormEntity:writeTo	(Ljava/io/OutputStream;)V
    //   167: aload 13
    //   169: invokevirtual 869	java/io/OutputStream:flush	()V
    //   172: aload 13
    //   174: invokevirtual 870	java/io/OutputStream:close	()V
    //   177: ldc_w 872
    //   180: new 65	java/lang/String
    //   183: dup
    //   184: aload 11
    //   186: invokevirtual 71	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   189: invokestatic 74	com/hjclass_mobile/f/b:a	(Ljava/io/InputStream;)[B
    //   192: invokespecial 77	java/lang/String:<init>	([B)V
    //   195: invokestatic 149	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   198: pop
    //   199: aload 11
    //   201: invokevirtual 80	java/net/HttpURLConnection:disconnect	()V
    //   204: return
    //   205: astore 10
    //   207: aload 8
    //   209: invokevirtual 80	java/net/HttpURLConnection:disconnect	()V
    //   212: aload 10
    //   214: athrow
    //   215: astore 12
    //   217: aload 11
    //   219: astore 8
    //   221: aload 12
    //   223: astore 10
    //   225: goto -18 -> 207
    //
    // Exception table:
    //   from	to	target	type
    //   73	105	205	finally
    //   105	199	215	finally
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     b
 * JD-Core Version:    0.6.2
 */