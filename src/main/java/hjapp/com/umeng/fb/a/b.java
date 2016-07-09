package hjapp.com.umeng.fb.a;

import hjapp.com.umeng.common.net.j;
import org.json.JSONObject;

public class b extends j
{
  public String d;
  public JSONObject e;
  public String f;

  public b(String paramString)
  {
    super(paramString);
    this.f = paramString;
  }

  public b(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    super(paramString2);
    this.d = paramString1;
    this.e = paramJSONObject;
    this.f = paramString2;
  }

  public JSONObject a()
  {
    return this.e;
  }

  public String b()
  {
    return this.f;
  }

  public String c()
  {
    return a;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     aersion:    0.6.2
 */