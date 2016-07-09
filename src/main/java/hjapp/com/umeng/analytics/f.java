package hjapp.com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import java.net.URLEncoder;
import org.json.JSONObject;

class f
{
  static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("mobclick_agent_user_" + paramContext.getPackageName(), 0);
  }

  static SharedPreferences b(Context paramContext)
  {
    return paramContext.getSharedPreferences("mobclick_agent_online_setting_" + paramContext.getPackageName(), 0);
  }

  static SharedPreferences c(Context paramContext)
  {
    return paramContext.getSharedPreferences("mobclick_agent_header_" + paramContext.getPackageName(), 0);
  }

  static SharedPreferences d(Context paramContext)
  {
    return paramContext.getSharedPreferences("mobclick_agent_update_" + paramContext.getPackageName(), 0);
  }

  static SharedPreferences e(Context paramContext)
  {
    return paramContext.getSharedPreferences("mobclick_agent_state_" + paramContext.getPackageName(), 0);
  }

  static String f(Context paramContext)
  {
    return "mobclick_agent_header_" + paramContext.getPackageName();
  }

  static String g(Context paramContext)
  {
    return "mobclick_agent_cached_" + paramContext.getPackageName();
  }

  static JSONObject h(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    SharedPreferences localSharedPreferences = a(paramContext);
    try
    {
      if (localSharedPreferences.getInt("gender", -1) != -1)
        localJSONObject.put("sex", localSharedPreferences.getInt("gender", -1));
      if (localSharedPreferences.getInt("age", -1) != -1)
        localJSONObject.put("age", localSharedPreferences.getInt("age", -1));
      if (!"".equals(localSharedPreferences.getString("user_id", "")))
        localJSONObject.put("id", localSharedPreferences.getString("user_id", ""));
      if (!"".equals(localSharedPreferences.getString("id_source", "")))
        localJSONObject.put("url", URLEncoder.encode(localSharedPreferences.getString("id_source", "")));
      int i = localJSONObject.length();
      if (i > 0)
        return localJSONObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     f
 * JD-Core Version:    0.6.2
 */