package hjapp.com.umeng.fb.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  public static String a(Context paramContext, JSONArray paramJSONArray)
  {
    if (paramJSONArray != null);
    try
    {
      if (paramJSONArray.length() == 0)
      {
        localObject1 = "";
        return localObject1;
      }
      Object localObject1 = "";
      int i = 0;
      while (true)
      {
        int j = paramJSONArray.length();
        if (i >= j)
          break;
        try
        {
          JSONArray localJSONArray = paramJSONArray.getJSONArray(i);
          for (int k = 0; k < localJSONArray.length(); k++)
            if (!localJSONArray.getString(k).equals("end"))
            {
              JSONObject localJSONObject = localJSONArray.getJSONObject(k);
              if (("dev_reply".equalsIgnoreCase(localJSONObject.optString("type"))) && (b(paramContext, localJSONObject)))
              {
                String str = d(paramContext, localJSONObject.optString("feedback_id"));
                localObject1 = str;
              }
            }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          i++;
        }
      }
    }
    finally
    {
    }
  }

  public static List a(Context paramContext)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        Iterator localIterator = paramContext.getSharedPreferences("feedback", 0).getAll().values().iterator();
        while (localIterator.hasNext())
          localArrayList.add(new hjapp.com.umeng.fb.b(new JSONArray((String)localIterator.next())));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return localArrayList;
      }
    }
    finally
    {
    }
  }

  public static void a(Context paramContext, hjapp.com.umeng.fb.b paramb, int paramInt)
  {
    while (true)
    {
      int j;
      try
      {
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("feedback", 0);
        Editor localEditor = localSharedPreferences.edit();
        String str1 = paramb.c;
        String str2 = localSharedPreferences.getString(str1, null);
        try
        {
          JSONArray localJSONArray1 = new JSONArray();
          JSONArray localJSONArray2 = new JSONArray(str2);
          int i = localJSONArray2.length();
          j = 0;
          if (i == 1)
          {
            localEditor.remove(paramb.c);
            localEditor.commit();
            paramb.b(paramInt);
            return;
          }
          if (j <= -1 + localJSONArray2.length())
          {
            if (j != paramInt)
              localJSONArray1.put(localJSONArray2.getJSONObject(j));
          }
          else
          {
            localEditor.putString(str1, localJSONArray1.toString());
            continue;
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
      j++;
    }
  }

  public static void a(Context paramContext, String paramString)
  {
    while (true)
    {
      int j;
      try
      {
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("UmengFb_Nums", 0);
        if (!hjapp.com.umeng.common.b.b.c(paramString))
        {
          String[] arrayOfString = localSharedPreferences.getString("newReplyIds", "").split(",");
          int i = arrayOfString.length;
          String str1 = "";
          j = 0;
          if (j < i)
          {
            String str2 = arrayOfString[j];
            if ((!hjapp.com.umeng.common.b.b.c(str2)) && (!str2.equals(paramString)))
              str1 = str1 + "," + str2.trim();
          }
          else
          {
            a(localSharedPreferences, "newReplyIds", str1);
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
      }
      j++;
    }
  }

  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext.getSharedPreferences(paramString1, 0).edit().remove(paramString2).commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static void a(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
  {
    try
    {
      paramSharedPreferences.edit().putString(paramString1, paramString2).commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static boolean a(Context paramContext, hjapp.com.umeng.fb.b paramb)
  {
    return paramContext.getSharedPreferences("UmengFb_Nums", 0).getString("newReplyIds", "").contains(paramb.c);
  }

  public static boolean a(Context paramContext, JSONObject paramJSONObject)
  {
    try
    {
      String str = paramJSONObject.optString("feedback_id");
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("feedback", 0);
      boolean bool1 = hjapp.com.umeng.common.b.b.c(str);
      boolean bool2 = false;
      if (!bool1)
      {
        a(localSharedPreferences, str, "[" + paramJSONObject.toString() + "]");
        bool2 = true;
      }
      return bool2;
    }
    finally
    {
    }
  }

  public static hjapp.com.umeng.fb.b b(Context paramContext, String paramString)
  {
    try
    {
      String str = paramContext.getSharedPreferences("feedback", 0).getString(paramString, null);
      try
      {
        localb = new hjapp.com.umeng.fb.b(new JSONArray(str));
        return localb;
      }
      catch (Exception localException)
      {
        while (true)
        {
          localException.printStackTrace();
          hjapp.com.umeng.fb.b localb = null;
        }
      }
    }
    finally
    {
    }
  }

  public static boolean b(Context paramContext, JSONObject paramJSONObject)
  {
    boolean bool = true;
    try
    {
      String str1 = paramJSONObject.optString("feedback_id");
      SharedPreferences localSharedPreferences1 = paramContext.getSharedPreferences("feedback", 0);
      try
      {
        JSONArray localJSONArray1 = new JSONArray(localSharedPreferences1.getString(str1, null));
        int i;
        if ("user_reply".equals(paramJSONObject.opt("type")))
        {
          hjapp.com.umeng.fb.b localb = new hjapp.com.umeng.fb.b(localJSONArray1);
          i = -1 + localJSONArray1.length();
          if (i >= 0)
          {
            String str2 = localJSONArray1.getJSONObject(i).optString("reply_id", null);
            String str3 = paramJSONObject.optString("reply_id", null);
            if ((str2 != null) && (str2.equalsIgnoreCase(str3)))
              a(paramContext, localb, i);
          }
          else
          {
            JSONArray localJSONArray2 = new JSONArray(localSharedPreferences1.getString(str1, null));
            localJSONArray2.put(paramJSONObject);
            a(localSharedPreferences1, str1, localJSONArray2.toString());
          }
        }
        while (true)
        {
          return bool;
          i--;
          break;
          SharedPreferences localSharedPreferences2 = paramContext.getSharedPreferences("umeng_reply_index", 0);
          String str4 = localSharedPreferences2.getString(str1, "RP0");
          String str5 = paramJSONObject.optString("reply_id");
          if (a.a(str4, str5))
            break label278;
          paramJSONObject.put("datetime", hjapp.com.umeng.common.b.b.a());
          localJSONArray1.put(paramJSONObject);
          a(localSharedPreferences1, str1, localJSONArray1.toString());
          a(localSharedPreferences2, str1, str5);
          a(paramContext.getSharedPreferences("UmengFb_Nums", 0), "maxReplyID", str5);
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          localException.printStackTrace();
          label278: bool = false;
        }
      }
    }
    finally
    {
    }
  }

  public static void c(Context paramContext, String paramString)
  {
    try
    {
      paramContext.getSharedPreferences("feedback", 0).edit().remove(paramString).commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static void c(Context paramContext, JSONObject paramJSONObject)
  {
    try
    {
      b.d(paramJSONObject);
      e(paramContext, paramJSONObject);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static String d(Context paramContext, String paramString)
  {
    try
    {
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("UmengFb_Nums", 0);
      String str = localSharedPreferences.getString("newReplyIds", "");
      boolean bool = str.contains(paramString);
      if (bool);
      while (true)
      {
        return str;
        str = str + "," + paramString;
        a(localSharedPreferences, "newReplyIds", str);
      }
    }
    finally
    {
    }
  }

  public static void d(Context paramContext, JSONObject paramJSONObject)
  {
    try
    {
      b.c(paramJSONObject);
      e(paramContext, paramJSONObject);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static boolean e(Context paramContext, JSONObject paramJSONObject)
  {
    try
    {
      String str1 = paramJSONObject.optString("feedback_id");
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("feedback", 0);
      String str2 = localSharedPreferences.getString(str1, "[]");
      try
      {
        JSONArray localJSONArray = new JSONArray(str2);
        localJSONArray.put(paramJSONObject);
        a(localSharedPreferences, str1, localJSONArray.toString());
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
    }
    finally
    {
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     c
 * JD-Core Version:    0.6.2
 */