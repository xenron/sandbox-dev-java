package hjapp.com.hjclass_mobile.questions;

public final class b
{
  public static String a(String paramString)
  {
    try
    {
      String str = paramString.substring(1 + paramString.lastIndexOf("/"), paramString.indexOf("?"));
      return str;
    }
    catch (Exception localException)
    {
    }
    return "";
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     b
 * JD-Core Version:    0.6.2
 */