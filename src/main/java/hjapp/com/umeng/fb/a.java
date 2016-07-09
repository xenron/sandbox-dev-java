package hjapp.com.umeng.fb;

import java.util.Date;
import org.json.JSONObject;

public class a
  implements Comparable
{
  String a;
  String b;
  public String c;
  public String d;
  public Date e;
  public a.b f;
  public a.a g = a.a.c;
  public JSONObject h;

  public a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
      throw new Exception("invalid atom");
    this.h = paramJSONObject;
    String str1 = paramJSONObject.optString("type");
    String str2;
    if ("new_feedback".equals(str1))
    {
      this.f = a.b.a;
      str2 = paramJSONObject.optString("state");
      if (!"sending".equalsIgnoreCase(str2))
        break label188;
      this.g = a.a.a;
    }
    while (true)
    {
      if (this.f == a.b.a)
        this.a = paramJSONObject.optString("thread");
      this.b = paramJSONObject.optString("thread");
      if (b.c(this.b))
        this.b = paramJSONObject.optString("content");
      this.c = paramJSONObject.optString("feedback_id");
      this.e = g.a(paramJSONObject.optString("datetime"));
      return;
      if ("dev_reply".equals(str1))
      {
        this.f = a.b.c;
        break;
      }
      if (!"user_reply".equals(str1))
        break;
      this.f = a.b.b;
      break;
      label188: if ("fail".equalsIgnoreCase(str2))
        this.g = a.a.b;
      else if ("ok".equalsIgnoreCase(str2))
        this.g = a.a.c;
      else if ("ReSending".equalsIgnoreCase(str2))
        this.g = a.a.d;
    }
  }

  public int a(a parama)
  {
    Date localDate = parama.e;
    if ((this.e == null) || (localDate == null) || (localDate.equals(this.e)))
      return 0;
    if (localDate.after(this.e))
      return -1;
    return 1;
  }

  public String a()
  {
    if (this.f == a.b.a)
      return this.a;
    return this.b;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     a
 * JD-Core Version:    0.6.2
 */