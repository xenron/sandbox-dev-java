package hjapp.com.hjclass_mobile.a;

import org.json.JSONObject;

public final class n
{
  String a;

  public n(String paramString)
  {
    this.a = paramString;
  }

  public final int a()
  {
    try
    {
      String str1 = b.a(this.a, ";").getString("result");
      String str2 = str1.substring(1, -1 + str1.length());
      String str3 = str2.substring(0, str2.indexOf("&sign_type="));
      JSONObject localJSONObject = b.a(str2, "&");
      String str4 = localJSONObject.getString("sign_type").replace("\"", "");
      String str5 = localJSONObject.getString("sign").replace("\"", "");
      if (str4.equalsIgnoreCase("RSA"))
      {
        boolean bool = o.a(str3, str5, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCAJxL0uEBR2kNU9mYEQxnftT6VMntHDmBFcK+d+sYODJloCPR2xN8HTkOUc7BJ9wvBO6/qjtNFILrtl9a06ii/J0VzXzQ7JhCHKrPtBIiyg6souWGiAn7jLamJzl0cK5sWDyXUlgyrbzjweRfjCBb/h82A6bDZOg9BikINqCoY2wIDAQAB");
        if (!bool)
          return 1;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return 0;
    }
    return 2;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     n
 * JD-Core Version:    0.6.2
 */