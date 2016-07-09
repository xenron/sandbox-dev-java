package hjapp.com.hjclass_mobile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

final class bl extends BroadcastReceiver
{
  private bl(HJFeedActivity paramHJFeedActivity)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle == null);
    int i;
    do
    {
      return;
      i = localBundle.getInt("type");
    }
    while ((!str.equals("refresh_feed")) || (i != HJFeedActivity.a(this.a)));
    HJFeedActivity.b(this.a).clear();
    HJFeedActivity.c(this.a).notifyDataSetChanged();
    HJFeedActivity.d(this.a);
    HJFeedActivity.e(this.a).setVisibility(0);
    HJFeedActivity.a(this.a, HJFeedActivity.f(this.a), HJFeedActivity.a(this.a));
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     bl
 * JD-Core Version:    0.6.2
 */