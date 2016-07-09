package hjapp.com.hjclass_mobile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

final class ba extends BroadcastReceiver
{
  private ba(HJDownloadCompleteListActivity paramHJDownloadCompleteListActivity)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    Bundle localBundle = paramIntent.getExtras();
    if ((str.equals("download_status")) && (localBundle != null) && (localBundle.getBoolean("isOK")))
    {
      HJDownloadCompleteListActivity.a(this.a, new bb(this.a, (byte)0));
      HJDownloadCompleteListActivity.h(this.a).execute(new Object[0]);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ba
 * JD-Core Version:    0.6.2
 */