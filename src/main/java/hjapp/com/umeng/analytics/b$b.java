package hjapp.com.umeng.analytics;

import android.content.Context;
import hjapp.com.umeng.common.a;
import org.json.JSONObject;

final class b$b
  implements Runnable
{
  private final Object b = new Object();
  private Context c;
  private JSONObject d;

  b$b(b paramb1, b paramb2, Context paramContext, JSONObject paramJSONObject)
  {
    this.c = paramContext;
    this.d = paramJSONObject;
  }

  public final void run()
  {
    try
    {
      if (this.d.getString("type").equals("online_config"))
      {
        b.a(this.a, this.c, this.d);
        return;
      }
      synchronized (this.b)
      {
        this.a.a(this.c, this.d);
        return;
      }
    }
    catch (Exception localException)
    {
      a.b("MobclickAgent", "Exception occurred in ReportMessageHandler");
      localException.printStackTrace();
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     b.b
 * JD-Core Version:    0.6.2
 */