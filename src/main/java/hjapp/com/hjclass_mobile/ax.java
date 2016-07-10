package hjapp.com.hjclass_mobile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import hjapp.com.hjclass_mobile.pkg_d.s;

final class ax extends BroadcastReceiver
{
  ax(HJDownloadActivity paramHJDownloadActivity)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    Bundle localBundle = paramIntent.getExtras();
    if (str.equals("update_ui_task"))
    {
      HJDownloadActivity.a(this.a, HJDownloadActivity.b(this.a).b());
      if (HJDownloadActivity.d(this.a).size() > 0)
      {
        HJDownloadActivity.e(this.a).setVisibility(8);
        HJDownloadActivity.f(this.a).setVisibility(0);
        HJDownloadActivity.c(this.a).notifyDataSetChanged();
      }
    }
    do
    {
      return;
      HJDownloadActivity.e(this.a).setVisibility(0);
      HJDownloadActivity.f(this.a).setVisibility(8);
      break;
      if (!str.equals("download_progress"))
        break label210;
    }
    while (localBundle == null);
    int i = localBundle.getInt("progressId");
    int j = localBundle.getInt("progressValue");
    int k = localBundle.getInt("totalValue");
    ((s)HJDownloadActivity.d(this.a).get(i)).e(j);
    ((s)HJDownloadActivity.d(this.a).get(i)).a(k);
    HJDownloadActivity.c(this.a).notifyDataSetChanged();
    return;
    label210: str.equals("download_max");
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ax
 * JD-Core Version:    0.6.2
 */