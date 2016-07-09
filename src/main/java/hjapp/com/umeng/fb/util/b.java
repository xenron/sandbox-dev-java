package hjapp.com.umeng.fb.util;

import android.content.Context;
import hjapp.com.umeng.fb.g;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  public static JSONObject a(Context paramContext, String paramString, int paramInt1, int paramInt2, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    while (true)
    {
      JSONObject localJSONObject2;
      try
      {
        JSONObject localJSONObject1 = g.c(paramContext);
        try
        {
          localJSONObject1.put("user_id", localJSONObject1.getString("idmd5"));
          localJSONObject1.put("thread", paramString);
          localJSONObject1.put("content", "Not supported on client yet");
          localJSONObject1.put("datetime", hjapp.com.umeng.common.b.b.a());
          localJSONObject1.put("feedback_id", a.a("FB", localJSONObject1.getString("appkey"), localJSONObject1.getString("user_id")));
          localJSONObject1.put("type", "new_feedback");
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("age_group", paramInt1);
          switch (paramInt2)
          {
          default:
            localJSONObject2.put("contact", paramJSONObject1);
            localJSONObject2.put("remark", paramJSONObject2);
            localJSONObject1.put("userinfo", localJSONObject2);
            return localJSONObject1;
          case 1:
            localJSONObject2.put("gender", "male");
            continue;
          case 2:
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          continue;
        }
      }
      finally
      {
      }
      localJSONObject2.put("gender", "female");
    }
  }

  public static JSONObject a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      String str1 = hjapp.com.umeng.common.b.k(paramContext);
      String str2 = hjapp.com.umeng.common.b.d(paramContext);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("type", "user_reply");
        localJSONObject.put("appkey", str1);
        localJSONObject.put("content", paramString1);
        localJSONObject.put("user_id", str2);
        localJSONObject.put("datetime", hjapp.com.umeng.common.b.b.a());
        localJSONObject.put("feedback_id", paramString2);
        localJSONObject.put("reply_id", a.a());
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        while (true)
          localJSONException.printStackTrace();
      }
    }
    finally
    {
    }
  }

  public static boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null);
    while (true)
    {
      return false;
      try
      {
        if (paramJSONObject.has("state"))
        {
          boolean bool = "ok".equals(paramJSONObject.getString("state"));
          if (bool)
            return true;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }

  public static boolean a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    try
    {
      paramJSONObject.put(paramString1, paramString2);
      bool = true;
      return bool;
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        localJSONException.printStackTrace();
        boolean bool = false;
      }
    }
    finally
    {
    }
  }

  public static boolean b(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("state"))
      {
        paramJSONObject.remove("state");
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public static boolean c(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = a(paramJSONObject, "state", "fail");
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static boolean d(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = a(paramJSONObject, "state", "sending");
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static boolean e(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = a(paramJSONObject, "state", "ok");
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     b
 * JD-Core Version:    0.6.2
 */