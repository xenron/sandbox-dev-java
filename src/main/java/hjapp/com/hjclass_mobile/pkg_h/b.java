package hjapp.com.hjclass_mobile.pkg_h;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public final class b
{
  public static String a(Context paramContext)
  {
    String str = b(paramContext);
    if (TextUtils.isEmpty(str))
      str = c(paramContext);
    u.b("uuid", str);
    return str;
  }

  private static String b(Context paramContext)
  {
    try
    {
      String str = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return str;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  private static String c(Context paramContext)
  {
    try
    {
      String str = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
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