package hjapp.com.hjclass_mobile.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import hjapp.com.hjclass_mobile.h.z;

final class i extends BroadcastReceiver
{
  private i(d paramd)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    Bundle localBundle = paramIntent.getExtras();
    if (str.equals("pause_cmd"))
    {
      Log.i("broadcast", "pause");
      d.a(this.a, true);
      this.a.e();
    }
    do
    {
      do
      {
        return;
        if (str.equals("play_cmd"))
        {
          Log.i("broadcast", "resume");
          d.a(this.a, false);
          this.a.f();
          return;
        }
        if (str.equals("seek_cmd"))
        {
          Log.i("broadcast", "seek");
          if (z.k)
            this.a.b(5000 + 1000 * localBundle.getInt("timeStamp"));
          while (true)
          {
            d.a(this.a, false);
            this.a.f();
            return;
            this.a.b(1000 * localBundle.getInt("timeStamp"));
          }
        }
      }
      while (!str.equals("show_cmd"));
      Log.i("broadcast", "show");
    }
    while (d.b(this.a) == null);
    d.b(this.a).m();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     i
 * JD-Core Version:    0.6.2
 */