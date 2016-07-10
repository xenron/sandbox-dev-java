package hjapp.com.hjclass_mobile.pkg_a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import hjapp.com.alipay.android.app.IAlixPay.Stub;

final class i
  implements ServiceConnection
{
  i(h paramh)
  {
  }

  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    synchronized (this.a.b)
    {
      this.a.c = IAlixPay.Stub.a(paramIBinder);
      this.a.b.notify();
      return;
    }
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.c = null;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     i
 * JD-Core Version:    0.6.2
 */