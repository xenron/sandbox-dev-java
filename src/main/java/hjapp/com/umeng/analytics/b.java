package hjapp.com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class b
{
  private final String A = "session_id";
  private final String B = "date";
  private final String C = "time";
  private final String D = "start_millis";
  private final String E = "end_millis";
  private final String F = "duration";
  private final String G = "activities";
  private final String H = "header";
  private final String I = "uptr";
  private final String J = "dntr";
  private final String K = "acc";
  private final String L = "tag";
  private final String M = "label";
  private final String N = "id";
  private final String O = "ts";
  private final String P = "du";
  private final String Q = "context";
  private final String R = "last_config_time";
  private final String S = "report_policy";
  private final String T = "online_params";
  String a = null;
  String b = null;
  UmengOnlineConfigureListener c = null;
  String d = "";
  String e = "";
  private final a f = new a();
  private int g = 1;
  private Context h;
  private final Handler i;
  private final int j = 0;
  private final int k = 1;
  private final int l = 2;
  private final int m = 3;
  private final int n = 4;
  private final int o = 5;
  private final int p = 6;
  private final String q = "type";
  private final String r = "error";
  private final String s = "event";
  private final String t = "ekv";
  private final String u = "launch";
  private final String v = "flush";
  private final String w = "terminate";
  private final String x = "online_config";
  private final String y = "appkey";
  private final String z = "body";

  b()
  {
    HandlerThread localHandlerThread = new HandlerThread("MobclickAgent");
    localHandlerThread.start();
    this.i = new Handler(localHandlerThread.getLooper());
  }

  private String a(Context paramContext, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong).append(paramString).append(hjapp.com.umeng.common.b.b.b(hjapp.com.umeng.common.b.c(paramContext)));
    return hjapp.com.umeng.common.b.b.a(localStringBuilder.toString());
  }

  private String a(Context paramContext, String paramString, SharedPreferences paramSharedPreferences)
  {
    d(paramContext, paramSharedPreferences);
    long l1 = System.currentTimeMillis();
    String str = a(paramContext, paramString, l1);
    Editor localEditor = paramSharedPreferences.edit();
    localEditor.putString("appkey", paramString);
    localEditor.putString("session_id", str);
    localEditor.putLong("start_millis", l1);
    localEditor.putLong("end_millis", -1L);
    localEditor.putLong("duration", 0L);
    localEditor.putString("activities", "");
    localEditor.remove("last_terminate_location_time");
    localEditor.commit();
    c(paramContext, paramSharedPreferences);
    return str;
  }

  private String a(Context paramContext, JSONObject paramJSONObject, String paramString1, boolean paramBoolean, String paramString2)
  {
    HttpPost localHttpPost = new HttpPost(paramString1);
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(localBasicHttpParams);
    localHttpPost.addHeader("X-Umeng-Sdk", l(paramContext));
    try
    {
      String str1 = e.a(paramContext);
      if (str1 != null)
      {
        HttpHost localHttpHost = new HttpHost(str1, 80);
        localDefaultHttpClient.getParams().setParameter("http.route.default-proxy", localHttpHost);
      }
      String str2 = paramJSONObject.toString();
      hjapp.com.umeng.common.a.a("MobclickAgent", str2);
      if ((d.q) && (!paramBoolean))
      {
        byte[] arrayOfByte = hjapp.com.umeng.common.b.a.a("content=" + str2, "utf-8");
        localHttpPost.addHeader("Content-Encoding", "deflate");
        localHttpPost.setEntity(new InputStreamEntity(new ByteArrayInputStream(arrayOfByte), hjapp.com.umeng.common.b.a.a));
      }
      while (true)
      {
        localEditor = f.c(paramContext).edit();
        Date localDate = new Date();
        HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
        long l1 = new Date().getTime() - localDate.getTime();
        if (localHttpResponse.getStatusLine().getStatusCode() != 200)
          break;
        hjapp.com.umeng.common.a.a("MobclickAgent", "Sent message to " + paramString1);
        localEditor.putLong("req_time", l1);
        localEditor.commit();
        HttpEntity localHttpEntity = localHttpResponse.getEntity();
        if (localHttpEntity == null)
          break label415;
        return a(localHttpEntity.getContent());
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(new BasicNameValuePair("content", str2));
        localHttpPost.setEntity(new UrlEncodedFormEntity(localArrayList, "UTF-8"));
      }
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      Editor localEditor;
      hjapp.com.umeng.common.a.a("MobclickAgent", "ClientProtocolException,Failed to send message.", localClientProtocolException);
      return null;
      localEditor.putLong("req_time", -1L);
      return null;
    }
    catch (IOException localIOException)
    {
      hjapp.com.umeng.common.a.a("MobclickAgent", "IOException,Failed to send message.", localIOException);
    }
    label415: return null;
  }

  private String a(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 8192);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      while (true)
      {
        String str = localBufferedReader.readLine();
        if (str == null)
          break;
        localStringBuilder.append(str + "\n");
      }
    }
    catch (IOException localIOException2)
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "Caught IOException in convertStreamToString()", localIOException2);
      try
      {
        paramInputStream.close();
        return null;
        try
        {
          paramInputStream.close();
          return localStringBuilder.toString();
        }
        catch (IOException localIOException4)
        {
          hjapp.com.umeng.common.a.b("MobclickAgent", "Caught IOException in convertStreamToString()", localIOException4);
          return null;
        }
      }
      catch (IOException localIOException3)
      {
        hjapp.com.umeng.common.a.b("MobclickAgent", "Caught IOException in convertStreamToString()", localIOException3);
        return null;
      }
    }
    finally
    {
      try
      {
        paramInputStream.close();
        throw localObject;
      }
      catch (IOException localIOException1)
      {
        hjapp.com.umeng.common.a.b("MobclickAgent", "Caught IOException in convertStreamToString()", localIOException1);
      }
    }
    return null;
  }

  private JSONArray a(JSONObject paramJSONObject, JSONArray paramJSONArray)
  {
    while (true)
    {
      try
      {
        String str1 = paramJSONObject.getString("tag");
        if (!paramJSONObject.has("label"))
          break label250;
        str2 = paramJSONObject.getString("label");
        String str3 = paramJSONObject.getString("date");
        int i1 = -1 + paramJSONArray.length();
        if (i1 >= 0)
        {
          JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i1);
          if ((str2 == null) && (!localJSONObject.has("label")))
          {
            if ((str1.equals(localJSONObject.get("tag"))) && (str3.equals(localJSONObject.get("date"))))
            {
              localJSONObject.put("acc", 1 + localJSONObject.getInt("acc"));
              i2 = 1;
              if (i2 != 0)
                break label248;
              paramJSONArray.put(paramJSONObject);
              return paramJSONArray;
            }
          }
          else if ((str2 != null) && (localJSONObject.has("label")) && (str1.equals(localJSONObject.get("tag"))) && (str2.equals(localJSONObject.get("label"))) && (str3.equals(localJSONObject.get("date"))))
          {
            localJSONObject.put("acc", 1 + localJSONObject.getInt("acc"));
            i2 = 1;
            continue;
          }
          i1--;
          continue;
        }
      }
      catch (Exception localException)
      {
        hjapp.com.umeng.common.a.a("MobclickAgent", "custom log merge error in tryToSendMessage", localException);
        paramJSONArray.put(paramJSONObject);
        return paramJSONArray;
      }
      int i2 = 0;
      continue;
      label248: return paramJSONArray;
      label250: String str2 = null;
    }
  }

  private void a(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    long l1 = System.currentTimeMillis();
    if ((d.g) && (l1 - paramSharedPreferences.getLong("last_terminate_location_time", 0L) > 10000L))
    {
      Location localLocation = hjapp.com.umeng.common.b.g(paramContext);
      if (localLocation != null)
      {
        long l2 = paramSharedPreferences.getLong("gps_time", 0L);
        if (localLocation.getTime() != l2)
          paramSharedPreferences.edit().putFloat("lng", (float)localLocation.getLongitude()).putFloat("lat", (float)localLocation.getLatitude()).putLong("gps_time", localLocation.getTime()).putLong("last_terminate_location_time", l1).commit();
      }
    }
  }

  private void a(Context paramContext, SharedPreferences paramSharedPreferences, String paramString1, String paramString2, long paramLong, int paramInt)
  {
    String str1 = paramSharedPreferences.getString("session_id", "");
    String str2 = hjapp.com.umeng.common.b.b.a();
    String str3 = str2.split(" ")[0];
    String str4 = str2.split(" ")[1];
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", "event");
      localJSONObject.put("session_id", str1);
      localJSONObject.put("date", str3);
      localJSONObject.put("time", str4);
      localJSONObject.put("tag", paramString1);
      if (!TextUtils.isEmpty(paramString2))
        localJSONObject.put("label", paramString2);
      if (paramLong > 0L)
        localJSONObject.put("du", paramLong);
      localJSONObject.put("acc", paramInt);
      this.i.post(new b.b(this, this, paramContext, localJSONObject));
      return;
    }
    catch (JSONException localJSONException)
    {
      hjapp.com.umeng.common.a.a("MobclickAgent", "json error in emitCustomLogReport", localJSONException);
    }
  }

  private void a(Context paramContext, SharedPreferences paramSharedPreferences, String paramString, JSONObject paramJSONObject)
  {
    String str = paramSharedPreferences.getString("session_id", "");
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      paramJSONObject.put("id", paramString);
      paramJSONObject.put("ts", System.currentTimeMillis() / 1000L);
      localJSONArray.put(paramJSONObject);
      localJSONObject.put("type", "ekv");
      localJSONObject.put(str, localJSONArray);
      this.i.post(new b.b(this, this, paramContext, localJSONObject));
      return;
    }
    catch (JSONException localJSONException)
    {
      hjapp.com.umeng.common.a.a("MobclickAgent", "json error in emitCustomLogReport", localJSONException);
      localJSONException.printStackTrace();
    }
  }

  private void a(Context paramContext, JSONArray paramJSONArray)
  {
    for (int i1 = 0; ; i1++)
      if (i1 < paramJSONArray.length())
        try
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i1);
          if ((localJSONObject == null) || (!localJSONObject.has("date")) || (!localJSONObject.has("time")) || (!localJSONObject.has("context")))
            continue;
          if (localJSONObject.has("version"))
          {
            if ((localJSONObject.getString("version") != null) && (localJSONObject.getString("version").equals(hjapp.com.umeng.common.b.a(paramContext))))
              localJSONObject.remove("version");
          }
          else
            this.i.post(new b.b(this, this, paramContext, localJSONObject));
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      else
        return;
  }

  private void a(String paramString)
  {
    hjapp.com.umeng.common.a.a("MobclickAgent", paramString);
  }

  private boolean a(SharedPreferences paramSharedPreferences)
  {
    long l1 = paramSharedPreferences.getLong("end_millis", -1L);
    return System.currentTimeMillis() - l1 > d.d;
  }

  private boolean a(String paramString, Context paramContext)
  {
    if ((paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) == 0) && (!hjapp.com.umeng.common.b.h(paramContext)));
    do
    {
      do
      {
        do
        {
          return false;
          if (paramString == "online_config")
            return true;
          if (hjapp.com.umeng.common.b.f(paramContext))
            return true;
          this.g = q(paramContext);
          if (this.g != 3)
            break;
        }
        while (paramString != "flush");
        return true;
        if (paramString == "error")
          return true;
        if ((this.g == 1) && (paramString == "launch"))
          return true;
        if ((this.g == 2) && (paramString == "terminate"))
          return true;
        if (this.g == 0)
          return true;
        if (this.g != 4)
          break;
      }
      while ((f.d(paramContext).getString(hjapp.com.umeng.common.b.c(), "false").equals("true")) || (!paramString.equals("launch")));
      return true;
    }
    while (this.g != 5);
    return hjapp.com.umeng.common.b.f(paramContext);
  }

  private String b(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    Long localLong = Long.valueOf(System.currentTimeMillis());
    Editor localEditor = paramSharedPreferences.edit();
    localEditor.putLong("start_millis", localLong.longValue());
    localEditor.putLong("end_millis", -1L);
    localEditor.commit();
    return paramSharedPreferences.getString("session_id", null);
  }

  private JSONArray b(JSONObject paramJSONObject, JSONArray paramJSONArray)
  {
    if ((paramJSONArray == null) || (paramJSONObject == null))
      return paramJSONArray;
    while (true)
    {
      int i1;
      try
      {
        String str = (String)paramJSONObject.keys().next();
        i1 = -1 + paramJSONArray.length();
        if (i1 < 0)
          break;
        JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i1);
        if (localJSONObject.has(str))
        {
          JSONArray localJSONArray = paramJSONObject.getJSONArray(str);
          localJSONObject.getJSONArray(str).put((JSONObject)localJSONArray.get(0));
          return paramJSONArray;
        }
      }
      catch (Exception localException)
      {
        hjapp.com.umeng.common.a.a("MobclickAgent", "custom log merge error in tryToSendMessage", localException);
        return paramJSONArray;
      }
      i1--;
    }
    paramJSONArray.put(paramJSONObject);
    return paramJSONArray;
  }

  private void b(Context paramContext, int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 5))
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "Illegal value of report policy");
      return;
    }
    f.b(paramContext).edit().putInt("umeng_local_report_policy", paramInt).commit();
  }

  private void b(Context paramContext, String paramString1, String paramString2, long paramLong, int paramInt)
  {
    try
    {
      SharedPreferences localSharedPreferences = f.e(paramContext);
      if (localSharedPreferences == null);
      while (true)
      {
        return;
        a(paramContext, localSharedPreferences, paramString1, paramString2, paramLong, paramInt);
      }
    }
    finally
    {
    }
  }

  private void b(Context paramContext, String paramString, Map paramMap, long paramLong)
  {
    try
    {
      SharedPreferences localSharedPreferences = f.e(paramContext);
      if (localSharedPreferences == null);
      while (true)
      {
        return;
        try
        {
          JSONObject localJSONObject = new JSONObject();
          Iterator localIterator = paramMap.entrySet().iterator();
          int i2;
          for (int i1 = 0; (localIterator.hasNext()) && (i1 < 10); i1 = i2)
          {
            i2 = i1 + 1;
            Entry localEntry = (Entry)localIterator.next();
            localJSONObject.put((String)localEntry.getKey(), (String)localEntry.getValue());
          }
          if (paramLong > 0L)
            localJSONObject.put("du", paramLong);
          a(paramContext, localSharedPreferences, paramString, localJSONObject);
        }
        catch (Exception localException)
        {
          hjapp.com.umeng.common.a.a("MobclickAgent", "exception when convert map to json");
        }
      }
    }
    finally
    {
    }
  }

  private void b(Context paramContext, String paramString1, Map paramMap, String paramString2)
  {
    try
    {
      SharedPreferences localSharedPreferences = f.e(paramContext);
      if (localSharedPreferences == null);
      while (true)
      {
        return;
        try
        {
          f(paramContext, "_kvts" + paramString1 + paramString2);
          JSONObject localJSONObject = new JSONObject();
          Iterator localIterator = paramMap.entrySet().iterator();
          int i2;
          for (int i1 = 0; (localIterator.hasNext()) && (i1 < 10); i1 = i2)
          {
            i2 = i1 + 1;
            Entry localEntry = (Entry)localIterator.next();
            localJSONObject.put((String)localEntry.getKey(), (String)localEntry.getValue());
          }
          localSharedPreferences.edit().putString("_kvvl" + paramString1 + paramString2, localJSONObject.toString()).commit();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    finally
    {
    }
  }

  private void b(Context paramContext, JSONObject paramJSONObject)
  {
    String str = f.g(paramContext);
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("body");
      FileOutputStream localFileOutputStream = paramContext.openFileOutput(str, 0);
      localFileOutputStream.write(localJSONObject.toString().getBytes());
      localFileOutputStream.close();
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "cache message error", localFileNotFoundException);
      return;
    }
    catch (IOException localIOException)
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "cache message error", localIOException);
      return;
    }
    catch (Exception localException)
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "message is null", localException);
    }
  }

  private void c(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    String str1 = paramSharedPreferences.getString("session_id", null);
    if (str1 == null)
    {
      hjapp.com.umeng.common.a.a("MobclickAgent", "Missing session_id, ignore message");
      return;
    }
    String str2 = hjapp.com.umeng.common.b.b.a();
    String str3 = str2.split(" ")[0];
    String str4 = str2.split(" ")[1];
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", "launch");
      localJSONObject.put("session_id", str1);
      localJSONObject.put("date", str3);
      localJSONObject.put("time", str4);
      if (d.g)
      {
        Location localLocation = hjapp.com.umeng.common.b.g(paramContext);
        if (localLocation != null)
        {
          double d1 = localLocation.getLongitude();
          double d2 = localLocation.getAltitude();
          long l1 = localLocation.getTime();
          if (l1 != paramSharedPreferences.getLong("gps_time", 0L))
          {
            localJSONObject.put("lng", d1);
            localJSONObject.put("lat", d2);
            localJSONObject.put("gps_time", l1);
            paramSharedPreferences.edit().putLong("gps_time", l1).commit();
          }
        }
      }
      this.i.post(new b.b(this, this, paramContext, localJSONObject));
      return;
    }
    catch (JSONException localJSONException)
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "json error in emitNewSessionReport", localJSONException);
    }
  }

  private void c(Context paramContext, JSONObject paramJSONObject)
  {
    if (a("online_config", paramContext))
    {
      hjapp.com.umeng.common.a.a("MobclickAgent", "start to check onlineConfig info ...");
      String str = a(paramContext, paramJSONObject, "http://oc.umeng.com/check_config_update", true, "online_config");
      if (str == null)
        str = a(paramContext, paramJSONObject, "http://oc.umeng.co/check_config_update", true, "online_config");
      if (str != null)
      {
        hjapp.com.umeng.common.a.a("MobclickAgent", "get onlineConfig info succeed !");
        d(paramContext, str);
      }
    }
    else
    {
      return;
    }
    if (this.c != null)
      this.c.onDataReceived(null);
    hjapp.com.umeng.common.a.a("MobclickAgent", "get onlineConfig info failed !");
  }

  private void d(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    String str1 = paramSharedPreferences.getString("session_id", null);
    if (str1 == null)
    {
      a("Missing session_id, ignore message in emitLastEndSessionReport");
      return;
    }
    Long localLong = Long.valueOf(paramSharedPreferences.getLong("duration", -1L));
    if (localLong.longValue() <= 0L)
      localLong = Long.valueOf(0L);
    String str2 = hjapp.com.umeng.common.b.b.a();
    String str3 = str2.split(" ")[0];
    String str4 = str2.split(" ")[1];
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", "terminate");
      localJSONObject.put("session_id", str1);
      localJSONObject.put("date", str3);
      localJSONObject.put("time", str4);
      localJSONObject.put("duration", String.valueOf(localLong.longValue() / 1000L));
      if (d.h)
      {
        String str5 = paramSharedPreferences.getString("activities", "");
        if (!"".equals(str5))
        {
          String[] arrayOfString = str5.split(";");
          JSONArray localJSONArray = new JSONArray();
          for (int i1 = 0; i1 < arrayOfString.length; i1++)
            localJSONArray.put(new JSONArray(arrayOfString[i1]));
          localJSONObject.put("activities", localJSONArray);
        }
      }
      long[] arrayOfLong = e(paramContext, paramSharedPreferences);
      if (arrayOfLong != null)
      {
        localJSONObject.put("uptr", arrayOfLong[1]);
        localJSONObject.put("dntr", arrayOfLong[0]);
      }
      if ((d.g) && (paramSharedPreferences.contains("last_terminate_location_time")))
      {
        localJSONObject.put("lat", paramSharedPreferences.getFloat("lat", 0.0F));
        localJSONObject.put("lng", paramSharedPreferences.getFloat("lng", 0.0F));
        localJSONObject.put("gps_time", paramSharedPreferences.getLong("gps_time", 0L));
      }
      this.i.post(new b.b(this, this, paramContext, localJSONObject));
      return;
    }
    catch (JSONException localJSONException)
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "json error in emitLastEndSessionReport", localJSONException);
    }
  }

  // ERROR //
  private void d(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 722	com/umeng/analytics/f:b	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   4: astore_3
    //   5: new 360	org/json/JSONObject
    //   8: dup
    //   9: aload_2
    //   10: invokespecial 850	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13: astore 4
    //   15: aload 4
    //   17: ldc 202
    //   19: invokevirtual 509	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   22: ifeq +30 -> 52
    //   25: aload_3
    //   26: invokeinterface 278 1 0
    //   31: ldc_w 852
    //   34: aload 4
    //   36: ldc 202
    //   38: invokevirtual 505	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   41: invokeinterface 284 3 0
    //   46: invokeinterface 300 1 0
    //   51: pop
    //   52: aload 4
    //   54: ldc 206
    //   56: invokevirtual 509	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   59: ifeq +30 -> 89
    //   62: aload_3
    //   63: invokeinterface 278 1 0
    //   68: ldc_w 854
    //   71: aload 4
    //   73: ldc 206
    //   75: invokevirtual 530	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   78: invokeinterface 728 3 0
    //   83: invokeinterface 300 1 0
    //   88: pop
    //   89: aload 4
    //   91: ldc 210
    //   93: invokevirtual 509	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   96: istore 8
    //   98: aconst_null
    //   99: astore 9
    //   101: iload 8
    //   103: ifeq +165 -> 268
    //   106: new 360	org/json/JSONObject
    //   109: dup
    //   110: aload 4
    //   112: ldc 210
    //   114: invokevirtual 505	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   117: invokespecial 850	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   120: astore 10
    //   122: aload 10
    //   124: invokevirtual 705	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   127: astore 11
    //   129: aload_3
    //   130: invokeinterface 278 1 0
    //   135: astore 12
    //   137: aload 11
    //   139: invokeinterface 746 1 0
    //   144: ifeq +89 -> 233
    //   147: aload 11
    //   149: invokeinterface 711 1 0
    //   154: checkcast 523	java/lang/String
    //   157: astore 14
    //   159: aload 12
    //   161: aload 14
    //   163: aload 10
    //   165: aload 14
    //   167: invokevirtual 505	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   170: invokeinterface 284 3 0
    //   175: pop
    //   176: goto -39 -> 137
    //   179: astore 7
    //   181: ldc 216
    //   183: ldc_w 856
    //   186: aload 7
    //   188: invokestatic 473	com/umeng/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    //   191: return
    //   192: astore 18
    //   194: ldc 216
    //   196: ldc_w 858
    //   199: invokestatic 365	com/umeng/common/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: return
    //   203: astore 5
    //   205: ldc 216
    //   207: ldc_w 860
    //   210: aload 5
    //   212: invokestatic 473	com/umeng/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    //   215: goto -163 -> 52
    //   218: astore 6
    //   220: ldc 216
    //   222: ldc_w 862
    //   225: aload 6
    //   227: invokestatic 473	com/umeng/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    //   230: goto -141 -> 89
    //   233: aload 12
    //   235: invokeinterface 300 1 0
    //   240: pop
    //   241: ldc 216
    //   243: new 236	java/lang/StringBuilder
    //   246: dup
    //   247: ldc_w 864
    //   250: invokespecial 373	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   253: aload 10
    //   255: invokevirtual 867	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 365	com/umeng/common/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload 10
    //   266: astore 9
    //   268: aload_0
    //   269: getfield 86	com/umeng/analytics/b:c	Lcom/umeng/analytics/UmengOnlineConfigureListener;
    //   272: ifnull -81 -> 191
    //   275: aload_0
    //   276: getfield 86	com/umeng/analytics/b:c	Lcom/umeng/analytics/UmengOnlineConfigureListener;
    //   279: aload 9
    //   281: invokeinterface 821 2 0
    //   286: return
    //
    // Exception table:
    //   from	to	target	type
    //   89	98	179	java/lang/Exception
    //   106	137	179	java/lang/Exception
    //   137	176	179	java/lang/Exception
    //   233	264	179	java/lang/Exception
    //   268	286	179	java/lang/Exception
    //   5	15	192	java/lang/Exception
    //   15	52	203	java/lang/Exception
    //   52	89	218	java/lang/Exception
  }

  private void d(Context paramContext, String paramString1, String paramString2)
  {
    while (true)
    {
      SharedPreferences localSharedPreferences;
      int i1;
      try
      {
        localSharedPreferences = f.e(paramContext);
        if (localSharedPreferences == null)
          return;
        try
        {
          i1 = g(paramContext, "_kvts" + paramString1 + paramString2);
          if (i1 >= 0)
            break label78;
          a("event duration less than 0 in ekvEvnetEnd");
        }
        catch (Exception localException)
        {
          a("exception in onLogDurationInternalEnd");
        }
        continue;
      }
      finally
      {
      }
      label78: JSONObject localJSONObject = new JSONObject(localSharedPreferences.getString("_kvvl" + paramString1 + paramString2, null));
      localJSONObject.put("du", i1);
      a(paramContext, localSharedPreferences, paramString1, localJSONObject);
    }
  }

  private void e(Context paramContext, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("type", "online_config");
        localJSONObject.put("appkey", paramString);
        localJSONObject.put("version_code", hjapp.com.umeng.common.b.a(paramContext));
        localJSONObject.put("package", hjapp.com.umeng.common.b.p(paramContext));
        localJSONObject.put("sdk_version", "4.3");
        localJSONObject.put("idmd5", hjapp.com.umeng.common.b.b.b(hjapp.com.umeng.common.b.c(paramContext)));
        localJSONObject.put("channel", h(paramContext));
        localJSONObject.put("report_policy", q(paramContext));
        localJSONObject.put("last_config_time", r(paramContext));
        this.i.post(new b.b(this, this, paramContext, localJSONObject));
        return;
      }
      catch (Exception localException)
      {
        while (true)
          hjapp.com.umeng.common.a.b("MobclickAgent", "exception in onlineConfigInternal");
      }
    }
    finally
    {
    }
  }

  private long[] e(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    try
    {
      Class localClass = Class.forName("android.net.TrafficStats");
      Class[] arrayOfClass1 = new Class[1];
      arrayOfClass1[0] = Integer.TYPE;
      Method localMethod1 = localClass.getMethod("getUidRxBytes", arrayOfClass1);
      Class[] arrayOfClass2 = new Class[1];
      arrayOfClass2[0] = Integer.TYPE;
      Method localMethod2 = localClass.getMethod("getUidTxBytes", arrayOfClass2);
      int i1 = paramContext.getApplicationInfo().uid;
      if (i1 == -1)
        return null;
      long[] arrayOfLong = new long[2];
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(i1);
      arrayOfLong[0] = ((Long)localMethod1.invoke(null, arrayOfObject1)).longValue();
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(i1);
      arrayOfLong[1] = ((Long)localMethod2.invoke(null, arrayOfObject2)).longValue();
      if ((arrayOfLong[0] > 0L) && (arrayOfLong[1] > 0L))
      {
        long l1 = paramSharedPreferences.getLong("traffics_up", -1L);
        long l2 = paramSharedPreferences.getLong("traffics_down", -1L);
        paramSharedPreferences.edit().putLong("traffics_up", arrayOfLong[1]).putLong("traffics_down", arrayOfLong[0]).commit();
        if ((l1 <= 0L) || (l2 <= 0L))
          break label309;
        arrayOfLong[0] -= l2;
        arrayOfLong[1] -= l1;
        if (arrayOfLong[0] > 0L)
        {
          long l3 = arrayOfLong[1];
          if (l3 > 0L);
        }
        else
        {
          return null;
        }
        return arrayOfLong;
      }
    }
    catch (Exception localException)
    {
      a("sdk less than 2.2 has get no traffic");
      return null;
    }
    return null;
    label309: return null;
  }

  private void f(Context paramContext)
  {
    while (true)
    {
      SharedPreferences localSharedPreferences;
      try
      {
        this.h = paramContext;
        localSharedPreferences = f.e(paramContext);
        if (localSharedPreferences == null)
          return;
        if (a(localSharedPreferences))
        {
          String str2 = a(paramContext, g(paramContext), localSharedPreferences);
          hjapp.com.umeng.common.a.a("MobclickAgent", "Start new session: " + str2);
          continue;
        }
      }
      finally
      {
      }
      String str1 = b(paramContext, localSharedPreferences);
      hjapp.com.umeng.common.a.a("MobclickAgent", "Extend current session: " + str1);
    }
  }

  private void f(Context paramContext, String paramString)
  {
    g localg = g.a(paramContext, paramString);
    localg.a(Long.valueOf(System.currentTimeMillis()));
    localg.c();
  }

  private int g(Context paramContext, String paramString)
  {
    g localg = g.a(paramContext, paramString);
    long l1 = localg.a().longValue();
    int i1 = -1;
    if (l1 > 0L)
      i1 = (int)(System.currentTimeMillis() - l1);
    localg.c();
    return i1;
  }

  private String g(Context paramContext)
  {
    if (this.b == null)
      return hjapp.com.umeng.common.b.k(paramContext);
    return this.b;
  }

  private String h(Context paramContext)
  {
    if (this.a == null)
      return hjapp.com.umeng.common.b.o(paramContext);
    return this.a;
  }

  private void i(Context paramContext)
  {
    while (true)
    {
      SharedPreferences localSharedPreferences;
      long l1;
      try
      {
        if (this.h != paramContext)
        {
          hjapp.com.umeng.common.a.b("MobclickAgent", "onPause() called without context from corresponding onResume()");
          return;
        }
        this.h = paramContext;
        localSharedPreferences = f.e(paramContext);
        if (localSharedPreferences == null)
          continue;
        l1 = localSharedPreferences.getLong("start_millis", -1L);
        if (l1 == -1L)
        {
          hjapp.com.umeng.common.a.b("MobclickAgent", "onEndSession called before onStartSession");
          a(paramContext, localSharedPreferences);
          continue;
        }
      }
      finally
      {
      }
      long l2 = System.currentTimeMillis();
      long l3 = l2 - l1;
      long l4 = localSharedPreferences.getLong("duration", 0L);
      Editor localEditor = localSharedPreferences.edit();
      if (d.h)
      {
        String str1 = localSharedPreferences.getString("activities", "");
        String str2 = paramContext.getClass().getName();
        if (!"".equals(str1))
          str1 = str1 + ";";
        String str3 = str1 + "[" + str2 + "," + l3 / 1000L + "]";
        localEditor.remove("activities");
        localEditor.putString("activities", str3);
      }
      localEditor.putLong("start_millis", -1L);
      localEditor.putLong("end_millis", l2);
      localEditor.putLong("duration", l3 + l4);
      localEditor.commit();
    }
  }

  private void j(Context paramContext)
  {
    try
    {
      n(paramContext);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void k(Context paramContext)
  {
    try
    {
      a locala = this.f;
      if (locala == null);
      while (true)
      {
        return;
        JSONArray localJSONArray = this.f.b(paramContext);
        if ((localJSONArray != null) && (localJSONArray.length() != 0))
          a(paramContext, localJSONArray);
      }
    }
    finally
    {
    }
  }

  private String l(Context paramContext)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("Android");
    localStringBuffer1.append("/");
    localStringBuffer1.append("4.3");
    localStringBuffer1.append(" ");
    try
    {
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append(paramContext.getPackageManager().getApplicationLabel(paramContext.getApplicationInfo()).toString());
      localStringBuffer2.append("/");
      localStringBuffer2.append(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName);
      localStringBuffer2.append(" ");
      localStringBuffer2.append(Build.MODEL);
      localStringBuffer2.append("/");
      localStringBuffer2.append(VERSION.RELEASE);
      localStringBuffer2.append(" ");
      localStringBuffer2.append(hjapp.com.umeng.common.b.b.b(hjapp.com.umeng.common.b.c(paramContext)));
      localStringBuffer1.append(URLEncoder.encode(localStringBuffer2.toString()));
      return localStringBuffer1.toString();
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  private JSONObject m(Context paramContext)
  {
    JSONObject localJSONObject1 = new JSONObject();
    String str1;
    String str2;
    try
    {
      str1 = hjapp.com.umeng.common.b.c(paramContext);
      if ((str1 == null) || (str1.equals("")))
      {
        hjapp.com.umeng.common.a.b("MobclickAgent", "No device id");
        return null;
      }
      str2 = g(paramContext);
      if (str2 == null)
      {
        hjapp.com.umeng.common.a.b("MobclickAgent", "No appkey");
        return null;
      }
    }
    catch (Exception localException)
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "getMessageHeader error", localException);
      return null;
    }
    localJSONObject1.put("device_id", str1);
    localJSONObject1.put("idmd5", hjapp.com.umeng.common.b.b.b(str1));
    localJSONObject1.put("mc", hjapp.com.umeng.common.b.l(paramContext));
    localJSONObject1.put("device_model", Build.MODEL);
    localJSONObject1.put("appkey", str2);
    localJSONObject1.put("channel", h(paramContext));
    localJSONObject1.put("app_version", hjapp.com.umeng.common.b.b(paramContext));
    localJSONObject1.put("version_code", hjapp.com.umeng.common.b.a(paramContext));
    localJSONObject1.put("sdk_type", "Android");
    localJSONObject1.put("sdk_version", "4.3");
    localJSONObject1.put("os", "Android");
    localJSONObject1.put("os_version", VERSION.RELEASE);
    localJSONObject1.put("timezone", hjapp.com.umeng.common.b.i(paramContext));
    String[] arrayOfString1 = hjapp.com.umeng.common.b.j(paramContext);
    if (arrayOfString1 != null)
    {
      localJSONObject1.put("country", arrayOfString1[0]);
      localJSONObject1.put("language", arrayOfString1[1]);
    }
    localJSONObject1.put("resolution", hjapp.com.umeng.common.b.m(paramContext));
    String[] arrayOfString2 = hjapp.com.umeng.common.b.e(paramContext);
    if ((arrayOfString2 != null) && (arrayOfString2[0].equals("2G/3G")))
    {
      localJSONObject1.put("access", arrayOfString2[0]);
      localJSONObject1.put("access_subtype", arrayOfString2[1]);
    }
    while (true)
    {
      localJSONObject1.put("carrier", hjapp.com.umeng.common.b.n(paramContext));
      localJSONObject1.put("cpu", hjapp.com.umeng.common.b.a());
      if (!this.d.equals(""))
        localJSONObject1.put("gpu_vender", this.d);
      if (!this.e.equals(""))
        localJSONObject1.put("gpu_renderer", this.e);
      if (d.i)
      {
        JSONObject localJSONObject2 = f.h(paramContext);
        if (localJSONObject2 != null)
          localJSONObject1.put("uinfo", localJSONObject2);
      }
      localJSONObject1.put("package", hjapp.com.umeng.common.b.p(paramContext));
      return localJSONObject1;
      if (arrayOfString2 != null)
        localJSONObject1.put("access", arrayOfString2[0]);
      else
        localJSONObject1.put("access", "Unknown");
    }
  }

  private void n(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", "flush");
      this.i.post(new b.b(this, this, paramContext, localJSONObject));
      return;
    }
    catch (JSONException localJSONException)
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "json error in emitCache");
    }
  }

  private JSONObject o(Context paramContext)
  {
    String str1 = f.g(paramContext);
    try
    {
      FileInputStream localFileInputStream = paramContext.openFileInput(str1);
      byte[] arrayOfByte = new byte[1024];
      int i1;
      for (String str2 = ""; ; str2 = str2 + new String(arrayOfByte, 0, i1))
      {
        i1 = localFileInputStream.read(arrayOfByte);
        if (i1 == -1)
          break;
      }
      localFileInputStream.close();
      int i2 = str2.length();
      if (i2 == 0)
        return null;
      try
      {
        JSONObject localJSONObject = new JSONObject(str2);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        p(paramContext);
        localJSONException.printStackTrace();
        return null;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      return null;
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  private void p(Context paramContext)
  {
    paramContext.deleteFile(f.f(paramContext));
    paramContext.deleteFile(f.g(paramContext));
  }

  private int q(Context paramContext)
  {
    SharedPreferences localSharedPreferences = f.b(paramContext);
    if ((localSharedPreferences.contains("umeng_net_report_policy")) && (localSharedPreferences.getInt("umeng_net_report_policy", -1) != -1))
      return localSharedPreferences.getInt("umeng_net_report_policy", this.g);
    return localSharedPreferences.getInt("umeng_local_report_policy", this.g);
  }

  private String r(Context paramContext)
  {
    return f.b(paramContext).getString("umeng_last_config_time", "");
  }

  JSONObject a(Context paramContext, JSONObject paramJSONObject1, JSONObject paramJSONObject2, JSONObject paramJSONObject3, String paramString)
  {
    SharedPreferences localSharedPreferences = f.c(paramContext);
    long l1 = localSharedPreferences.getLong("req_time", 0L);
    if (l1 != 0L);
    JSONObject localJSONObject;
    try
    {
      paramJSONObject2.put("req_time", l1);
      localSharedPreferences.edit().putString("header", paramJSONObject2.toString()).commit();
      localJSONObject = new JSONObject();
      if (paramString == null)
        return null;
    }
    catch (JSONException localJSONException2)
    {
      while (true)
        hjapp.com.umeng.common.a.a("MobclickAgent", "json error in tryToSendMessage", localJSONException2);
      try
      {
        if (("flush".equals(paramString)) && (paramJSONObject1 == null))
        {
          hjapp.com.umeng.common.a.d("MobclickAgent", "No cache message to flush in constructMessage");
          return null;
        }
      }
      catch (JSONException localJSONException1)
      {
        hjapp.com.umeng.common.a.b("MobclickAgent", "Fail to construct json message in tryToSendMessage.", localJSONException1);
        p(paramContext);
        return null;
      }
      if (!"flush".equals(paramString))
      {
        if (paramJSONObject1 == null)
          paramJSONObject1 = new JSONObject();
        if (!paramJSONObject1.isNull(paramString))
          break label212;
        JSONArray localJSONArray1 = new JSONArray();
        localJSONArray1.put(paramJSONObject3);
        paramJSONObject1.put(paramString, localJSONArray1);
      }
    }
    while (true)
    {
      localJSONObject.put("header", paramJSONObject2);
      localJSONObject.put("body", paramJSONObject1);
      return localJSONObject;
      label212: JSONArray localJSONArray2 = paramJSONObject1.getJSONArray(paramString);
      if ("ekv".equals(paramString))
        b(paramJSONObject3, localJSONArray2);
      else
        localJSONArray2.put(paramJSONObject3);
    }
  }

  void a(Context paramContext)
  {
    if (paramContext == null);
    try
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "unexpected null context in onPause");
      return;
      new b.a(this, paramContext, 0).start();
      return;
    }
    catch (Exception localException)
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "Exception occurred in Mobclick.onRause(). ", localException);
    }
  }

  void a(Context paramContext, int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 5))
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "Illegal value of report policy");
      return;
    }
    this.g = paramInt;
    b(paramContext, paramInt);
  }

  void a(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString == "") || (paramString.length() > 10240));
    do
    {
      return;
      if (paramContext == null)
      {
        hjapp.com.umeng.common.a.b("MobclickAgent", "unexpected null context in reportError");
        return;
      }
    }
    while (this.f == null);
    this.f.a(paramContext, paramString);
  }

  void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      a("invalid params in onEventBegin");
      return;
    }
    f(paramContext, "_tl" + paramString1 + paramString2);
  }

  void a(Context paramContext, String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if (paramContext != null);
    try
    {
      if ((TextUtils.isEmpty(paramString1)) || (paramInt <= 0))
      {
        a("invalid params in onEvent");
        return;
      }
      new b.a(this, paramContext, paramString1, paramString2, paramLong, paramInt, 3).start();
      return;
    }
    catch (Exception localException)
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "Exception occurred in Mobclick.onEvent(). ", localException);
    }
  }

  void a(Context paramContext, String paramString, Map paramMap, long paramLong)
  {
    if (paramContext != null);
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        a("invalid params in onKVEventEnd");
        return;
      }
      if ((paramMap == null) || (paramMap.isEmpty()))
      {
        a("map is null or empty in onEvent");
        return;
      }
    }
    catch (Exception localException)
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "Exception occurred in Mobclick.onEvent(). ", localException);
      return;
    }
    new b.a(this, paramContext, paramString, paramMap, paramLong, 4).start();
  }

  void a(Context paramContext, String paramString1, Map paramMap, String paramString2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      a("invalid params in onKVEventBegin");
      return;
    }
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      a("map is null or empty in onKVEventBegin");
      return;
    }
    new b.a(this, paramContext, paramString1, paramMap, paramString2, 5).start();
  }

  protected void a(Context paramContext, JSONObject paramJSONObject)
  {
    String str = (String)paramJSONObject.remove("type");
    JSONObject localJSONObject = a(paramContext, o(paramContext), m(paramContext), paramJSONObject, str);
    if ((localJSONObject == null) || (localJSONObject.isNull("body")));
    label113: 
    do
    {
      return;
      if (!a(str, paramContext))
      {
        b(paramContext, localJSONObject);
        return;
      }
      Object localObject1 = null;
      int i1 = 0;
      while (i1 < d.n.length)
      {
        localObject2 = a(paramContext, localJSONObject, d.n[i1], false, str);
        if (localObject2 != null)
          break label113;
        i1++;
        localObject1 = localObject2;
      }
      Object localObject2 = localObject1;
      if (localObject2 == null)
        break;
      hjapp.com.umeng.common.a.a("MobclickAgent", "send applog succeed :" + (String)localObject2);
      p(paramContext);
    }
    while (this.g != 4);
    Editor localEditor = f.d(paramContext).edit();
    localEditor.putString(hjapp.com.umeng.common.b.c(), "true");
    localEditor.commit();
    return;
    b(paramContext, localJSONObject);
    hjapp.com.umeng.common.a.a("MobclickAgent", "send applog failed");
  }

  void b(Context paramContext)
  {
    try
    {
      String str = g(paramContext);
      if ((str == null) || (str.length() == 0))
      {
        hjapp.com.umeng.common.a.b("MobclickAgent", "unexpected empty appkey in onError");
        return;
      }
      if (paramContext == null)
      {
        hjapp.com.umeng.common.a.b("MobclickAgent", "unexpected null context in onError");
        return;
      }
    }
    catch (Exception localException)
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "Exception occurred in Mobclick.onError()", localException);
      return;
    }
    if (this.f != null)
      this.f.a(paramContext);
    new b.a(this, paramContext, 2).start();
  }

  void b(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      a("invalid params in onEventBegin");
      return;
    }
    f(paramContext, "_t" + paramString);
  }

  void b(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString2)))
    {
      a("invalid params in onEventEnd");
      return;
    }
    int i1 = g(paramContext, "_tl" + paramString1 + paramString2);
    if (i1 < 0)
    {
      a("event duration less than 0 in onEvnetEnd");
      return;
    }
    a(paramContext, paramString1, paramString2, i1, 1);
  }

  void c(Context paramContext)
  {
    if (paramContext == null);
    try
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "unexpected null context in onResume");
      return;
      new b.a(this, paramContext, 1).start();
      return;
    }
    catch (Exception localException)
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "Exception occurred in Mobclick.onResume(). ", localException);
    }
  }

  void c(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      hjapp.com.umeng.common.a.a("MobclickAgent", "input Context is null or event_id is empty");
      return;
    }
    int i1 = g(paramContext, "_t" + paramString);
    if (i1 < 0)
    {
      hjapp.com.umeng.common.a.a("MobclickAgent", "event duration less than 0 in onEventEnd");
      return;
    }
    a(paramContext, paramString, null, i1, 1);
  }

  void c(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      a("invalid params in onKVEventEnd");
      return;
    }
    new b.a(this, paramContext, paramString1, null, paramString2, 6).start();
  }

  void d(Context paramContext)
  {
    if (paramContext == null);
    try
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "unexpected null context in flush");
      j(paramContext);
      return;
    }
    catch (Exception localException)
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "Exception occurred in Mobclick.flush(). ", localException);
    }
  }

  public void e(Context paramContext)
  {
    if (paramContext == null);
    String str;
    try
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "unexpected null context in updateOnlineConfig");
      return;
      str = g(paramContext);
      if (str == null)
      {
        hjapp.com.umeng.common.a.b("MobclickAgent", "unexpected null appkey in updateOnlineConfig");
        return;
      }
    }
    catch (Exception localException)
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "exception in updateOnlineConfig");
      return;
    }
    new Thread(new c(this, paramContext, str)).start();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     b
 * JD-Core Version:    0.6.2
 */