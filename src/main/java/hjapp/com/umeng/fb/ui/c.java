package hjapp.com.umeng.fb.ui;

import android.view.View;
import android.view.View.OnClickListener;
import hjapp.com.umeng.fb.util.ActivityStarter;

class c
  implements OnClickListener
{
  c(FeedbackConversations paramFeedbackConversations)
  {
  }

  public void onClick(View paramView)
  {
    ActivityStarter.openSendFeedbackActivity(this.a);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     c
 * JD-Core Version:    0.6.2
 */