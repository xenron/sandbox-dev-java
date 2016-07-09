package hjapp.com.umeng.fb.a;

import android.content.Context;
import android.content.Intent;

import java.util.concurrent.Callable;

import org.json.JSONObject;

public class f
  implements Callable
{
  static String a = "MsgWorker";
  JSONObject b;
  Context c;

  public f(JSONObject paramJSONObject, Context paramContext)
  {
    this.b = paramJSONObject;
    this.c = paramContext;
  }

  public Boolean a()
  {
    String str1 = this.b.optString("type");
    String str2 = this.b.optString("feedback_id");
    String str3;
    String str4;
    String str5;
    if ("user_reply".equals(str1))
    {
      str3 = "user_reply";
      str4 = "http://feedback.whalecloud.com/feedback/reply";
      str5 = "reply";
    }
    try
    {
      while (true)
      {
        JSONObject localJSONObject2 = a.a(str4, str5, this.b).a();
        localJSONObject1 = localJSONObject2;
        localIntent = new Intent().setAction("postFeedbackFinished").putExtra("type", str3).putExtra("feedback_id", str2);
        if (!b.a(localJSONObject1))
          break;
        b.e(this.b);
        localIntent.putExtra("PostFeedbackBroadcast", "succeed");
        if (!"user_reply".equals(str1))
          break label192;
        hjapp.com.umeng.fb.util.c.b(this.c, this.b);
        this.c.sendBroadcast(localIntent);
        return null;
        str3 = "new_feedback";
        str4 = "http://feedback.whalecloud.com/feedback/feedbacks";
        str5 = "feedback";
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        Intent localIntent;
        localException.printStackTrace();
        JSONObject localJSONObject1 = null;
        continue;
        b.c(this.b);
        localIntent.putExtra("PostFeedbackBroadcast", "fail");
        continue;
        label192: hjapp.com.umeng.fb.util.c.a(this.c, "feedback", str2);
        hjapp.com.umeng.fb.util.c.a(this.c, this.b);
      }
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     aersion:    0.6.2
 */