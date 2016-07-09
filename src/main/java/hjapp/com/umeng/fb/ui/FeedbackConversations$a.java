package hjapp.com.umeng.fb.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.List;

class FeedbackConversations$a extends BroadcastReceiver
{
  d a;

  public FeedbackConversations$a(FeedbackConversations paramFeedbackConversations, d paramd)
  {
    this.a = paramd;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    List localList = hjapp.com.umeng.fb.util.c.a(this.b);
    this.a.a(localList);
    this.a.notifyDataSetChanged();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     FeedbackConversations.a
 * JD-Core Version:    0.6.2
 */