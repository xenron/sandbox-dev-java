package hjapp.com.umeng.fb;

import android.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;
import hjapp.com.umeng.fb.util.ActivityStarter;

final class d
  implements OnClickListener
{
  d(AlertDialog paramAlertDialog)
  {
  }

  public final void onClick(View paramView)
  {
    ActivityStarter.openFeedbackListActivity(UMFeedbackService.a());
    this.a.dismiss();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     d
 * JD-Core Version:    0.6.2
 */