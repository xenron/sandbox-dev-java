package hjapp.com.hjclass_mobile.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

final class c extends BroadcastReceiver
{
  private c(a parama)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    Bundle localBundle = paramIntent.getExtras();
    if ((str.equals("zoom_in_enabled")) && (localBundle != null))
      a.f(this.a).setEnabled(localBundle.getBoolean("flag"));
    do
    {
      return;
      if ((str.equals("zoom_out_enabled")) && (localBundle != null))
      {
        a.g(this.a).setEnabled(localBundle.getBoolean("flag"));
        return;
      }
    }
    while ((!str.equals("zoom_show_toggle")) || (a.d(this.a) == null));
    a.d(this.a).m();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     c
 * JD-Core Version:    0.6.2
 */