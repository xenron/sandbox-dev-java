package hjapp.com.hjclass_mobile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

final class dn extends BroadcastReceiver
{
  private dn(HJSubCourseActivity paramHJSubCourseActivity)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle == null);
    String str2;
    String str3;
    do
    {
      return;
      str2 = localBundle.getString("langs");
      str3 = localBundle.getString("keyword");
    }
    while ((!str1.equals("search_course")) || (!str2.equals(HJSubCourseActivity.l(this.a))));
    HJSubCourseActivity.c(this.a).getFilter().filter(str3);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     dn
 * JD-Core Version:    0.6.2
 */