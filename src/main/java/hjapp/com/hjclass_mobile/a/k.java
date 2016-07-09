package hjapp.com.hjclass_mobile.a;

import android.content.Intent;
import android.os.Bundle;
import hjapp.com.alipay.android.app.IRemoteServiceCallback.Stub;

final class k extends IRemoteServiceCallback.Stub
{
  k(h paramh)
  {
  }

  public final void a(String paramString1, String paramString2, int paramInt, Bundle paramBundle)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN", null);
    if (paramBundle == null)
      paramBundle = new Bundle();
    try
    {
      paramBundle.putInt("CallingPid", paramInt);
      localIntent.putExtras(paramBundle);
      localIntent.setClassName(paramString1, paramString2);
      this.a.e.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     k
 * JD-Core Version:    0.6.2
 */