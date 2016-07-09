package hjapp.com.hjclass_mobile;

import android.os.Handler;
import android.os.Message;

final class cb extends Handler
{
  cb(HJLessonListActivity paramHJLessonListActivity)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      return;
    case 2131361792:
      HJLessonListActivity.u(this.a).setVisibility(0);
      return;
    case 2131361793:
      HJLessonListActivity.u(this.a).setVisibility(8);
      return;
    case 2131361794:
    }
    HJLessonListActivity.u(this.a).setVisibility(8);
    HJLessonListActivity.v(this.a).loadDataWithBaseURL(null, this.a.getText(2131493143).toString(), "text/html", "UTF-8", null);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     cb
 * JD-Core Version:    0.6.2
 */