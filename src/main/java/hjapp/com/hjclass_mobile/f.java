package hjapp.com.hjclass_mobile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

final class f extends BroadcastReceiver
{
  f(DownloadService paramDownloadService)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    Bundle localBundle = paramIntent.getExtras();
    pkg_d.s locals;
    if (localBundle != null)
    {
      int i = localBundle.getInt("position");
      locals = (pkg_d.s)DownloadService.a(this.a).b().get(i);
      if (!str.equals("check_task"))
        break label68;
      DownloadService.a(this.a, locals, i);
    }
    label68: 
    while (!str.equals("delete_task"))
      return;
    DownloadService.a(this.a, locals);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     f
 * JD-Core Version:    0.6.2
 */