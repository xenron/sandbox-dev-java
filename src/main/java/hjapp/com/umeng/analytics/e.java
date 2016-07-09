package hjapp.com.umeng.analytics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import hjapp.com.umeng.common.a;

class e
{
  public static String a(Context paramContext)
  {
    if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) != 0)
      return null;
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null)
        return null;
      if (localNetworkInfo.getType() == 1)
        return null;
      String str = localNetworkInfo.getExtraInfo();
      a.a("TAG", "net type:" + str);
      if (str == null)
        return null;
      if ((str.equals("cmwap")) || (str.equals("3gwap")) || (str.equals("uniwap")))
        return "10.0.0.172";
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     e
 * JD-Core Version:    0.6.2
 */