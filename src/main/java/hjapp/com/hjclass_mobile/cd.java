package hjapp.com.hjclass_mobile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import hjapp.com.hjclass_mobile.d.t;

final class cd extends BroadcastReceiver
{
  cd(HJLessonListActivity paramHJLessonListActivity)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    Bundle localBundle = paramIntent.getExtras();
    if ((str.equals("download_status")) && (localBundle != null))
      HJLessonListActivity.a(this.a, localBundle.getString("downkey"), localBundle.getBoolean("isOK"));
    do
    {
      do
      {
        return;
        if ((!str.equals("delete_file")) || (localBundle == null))
          break;
      }
      while (localBundle.getInt("classId") != HJLessonListActivity.k(this.a));
      HJLessonListActivity.a(this.a, localBundle.getString("downkey"));
      return;
    }
    while ((!str.equals("open_next_lesson")) || (localBundle == null));
    int i = localBundle.getInt("nextLessonID");
    int j = localBundle.getInt("currentLessonID");
    int k = HJLessonListActivity.c(this.a).size();
    int m = 0;
    int n = 0;
    while (m < k)
    {
      t localt = (t)HJLessonListActivity.c(this.a).get(m);
      if (localt.c() == i)
      {
        localt.a(false);
        n++;
      }
      if (localt.c() == j)
      {
        localt.g(1);
        n++;
      }
      if (n >= 2)
        break;
      m++;
    }
    HJLessonListActivity.d(this.a);
    HJLessonListActivity.f(this.a).a = HJLessonListActivity.c(this.a);
    HJLessonListActivity.f(this.a).notifyDataSetChanged();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     cd
 * JD-Core Version:    0.6.2
 */