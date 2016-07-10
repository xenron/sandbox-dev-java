package hjapp.com.hjclass_mobile.pkg_a;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import hjapp.com.alipay.android.app.IAlixPay;
import hjapp.com.alipay.android.app.IRemoteServiceCallback;

public final class h
{
  static String a = "MobileSecurePayer";
  Integer b = Integer.valueOf(0);
  IAlixPay c = null;
  boolean d = false;
  Activity e = null;
  private ServiceConnection f = new i(this);
  private IRemoteServiceCallback g = new k(this);

  public final boolean a(String paramString, Handler paramHandler, Activity paramActivity)
  {
    if (this.d)
      return false;
    this.d = true;
    this.e = paramActivity;
    if (this.c == null)
      this.e.bindService(new Intent(IAlixPay.class.getName()), this.f, 1);
    new Thread(new j(this, paramString, paramHandler)).start();
    return true;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     h
 * JD-Core Version:    0.6.2
 */