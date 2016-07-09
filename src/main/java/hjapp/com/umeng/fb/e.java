package hjapp.com.umeng.fb;

import android.os.Handler;
import android.os.Message;

final class e extends Handler
{
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    UMFeedbackService.a(paramMessage.getData().getString("newReplyContent"));
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     e
 * JD-Core Version:    0.6.2
 */