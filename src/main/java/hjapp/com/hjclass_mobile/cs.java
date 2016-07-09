package hjapp.com.hjclass_mobile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.io.File;

final class cs extends BroadcastReceiver
{
  private cs(HJPersonIndexActivity paramHJPersonIndexActivity)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!HJPersonIndexActivity.a(this.a));
    Bundle localBundle;
    do
    {
      do
        return;
      while (!paramIntent.getAction().equals("msg_complete"));
      localBundle = paramIntent.getExtras();
    }
    while (localBundle == null);
    Uri localUri = Uri.fromFile(new File(localBundle.getString("filename")));
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(localUri, "application/vnd.android.package-archive");
    this.a.startActivity(localIntent);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     cs
 * JD-Core Version:    0.6.2
 */