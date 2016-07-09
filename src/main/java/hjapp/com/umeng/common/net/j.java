package hjapp.com.umeng.common.net;

import org.json.JSONObject;

public abstract class j
{
  protected static String a = "POST";
  protected static String b = "GET";
  protected String c;

  public j(String paramString)
  {
    this.c = paramString;
  }

  public abstract JSONObject a();

  public void a(String paramString)
  {
    this.c = paramString;
  }

  public abstract String b();

  protected String c()
  {
    return a;
  }

  public String d()
  {
    return this.c;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     j
 * JD-Core Version:    0.6.2
 */