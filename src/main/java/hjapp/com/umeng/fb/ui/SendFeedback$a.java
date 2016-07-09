package hjapp.com.umeng.fb.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import hjapp.com.umeng.fb.util.ActivityStarter;

class SendFeedback$a
  implements OnClickListener
{
  private SendFeedback$a(SendFeedback paramSendFeedback)
  {
  }

  public void onClick(View paramView)
  {
    this.a.finish();
    if (ActivityStarter.lastContext != null)
      ((Activity)ActivityStarter.lastContext).finish();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     SendFeedback.a
 * JD-Core Version:    0.6.2
 */