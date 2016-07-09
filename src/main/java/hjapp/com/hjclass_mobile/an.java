package hjapp.com.hjclass_mobile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

final class an extends BroadcastReceiver
{
  an(HJCoureseLessonActivity paramHJCoureseLessonActivity)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    Bundle localBundle = paramIntent.getExtras();
    if ((str.equals("download_status")) && (localBundle != null))
      HJCoureseLessonActivity.a(this.a, localBundle.getString("downkey"), localBundle.getBoolean("isOK"));
    while ((!str.equals("delete_file")) || (localBundle == null) || (localBundle.getInt("classId") != HJCoureseLessonActivity.h(this.a)))
      return;
    HJCoureseLessonActivity.a(this.a, localBundle.getString("downkey"));
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     an
 * JD-Core Version:    0.6.2
 */