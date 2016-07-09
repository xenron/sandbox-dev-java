package hjapp.com.hjclass_mobile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class eb extends BroadcastReceiver
{
  private eb(TabMainActivity paramTabMainActivity)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (str.equals("free_lesson_study"))
    {
      TabMainActivity.a(this.a).setChecked(true);
      TabMainActivity.b(this.a).setCurrentTabByTag("freelesson");
    }
    while (!str.equals("all_class"))
      return;
    TabMainActivity.c(this.a).setChecked(true);
    TabMainActivity.b(this.a).setCurrentTabByTag("study");
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     eb
 * JD-Core Version:    0.6.2
 */