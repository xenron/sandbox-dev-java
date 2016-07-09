package hjapp.com.hjclass_mobile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

final class aj extends BroadcastReceiver
{
  aj(HJClassPlayerV3 paramHJClassPlayerV3)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("restudy"))
    {
      Bundle localBundle = paramIntent.getExtras();
      if (localBundle != null)
      {
        if (localBundle.getBoolean("flag"))
        {
          HJClassPlayerV3.f(this.a);
          HJApplication.a(0.0F);
          HJClassPlayerV3.f(this.a);
          HJApplication.a(0);
          HJClassPlayerV3.f(this.a).d().clear();
          HJClassPlayerV3.h(this.a);
        }
        this.a.a(0);
        HJClassPlayerV3.c(this.a).d();
      }
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     aj
 * JD-Core Version:    0.6.2
 */