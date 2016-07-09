package hjapp.com.umeng.fb.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class FeedbackConversation$a extends BroadcastReceiver
{
  private FeedbackConversation$a(FeedbackConversation paramFeedbackConversation)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("feedback_id");
    if (FeedbackConversation.b(this.a).c.equalsIgnoreCase(str))
    {
      FeedbackConversation.a(this.a, hjapp.com.umeng.fb.util.c.b(this.a, str));
      FeedbackConversation.c(this.a).a(FeedbackConversation.b(this.a));
      FeedbackConversation.c(this.a).notifyDataSetChanged();
    }
    if (FeedbackConversation.b(this.a).b != b.a.d)
    {
      FeedbackConversation.a(this.a).setEnabled(false);
      FeedbackConversation.d(this.a).setEnabled(false);
      return;
    }
    FeedbackConversation.a(this.a).setEnabled(true);
    FeedbackConversation.d(this.a).setEnabled(true);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     FeedbackConversation.a
 * JD-Core Version:    0.6.2
 */