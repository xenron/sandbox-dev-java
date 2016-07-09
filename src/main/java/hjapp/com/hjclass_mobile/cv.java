package hjapp.com.hjclass_mobile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class cv extends BroadcastReceiver
{
  cv(HJPersonIndexActivity paramHJPersonIndexActivity)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    HJPersonIndexActivity.t(this.a);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     cv
 * JD-Core Version:    0.6.2
 */