package hjapp.com.hjclass_mobile.questions;

import android.os.Handler;
import android.os.Message;
import hjapp.com.hjclass_mobile.h.u;

final class c extends Handler
{
  c(QuestionBaseWebViewActivity paramQuestionBaseWebViewActivity)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      return;
    case 2131361792:
      u.c("handler 中 load 被执行了");
      QuestionBaseWebViewActivity.a(this.a).setVisibility(0);
      QuestionBaseWebViewActivity.b(this.a).setVisibility(4);
      return;
    case 2131361793:
      u.c("handler 中 normal 被执行了");
      QuestionBaseWebViewActivity.a(this.a).setVisibility(8);
      QuestionBaseWebViewActivity.b(this.a).setVisibility(0);
      return;
    case 2131361794:
    }
    u.c("handler 中 error 被执行了");
    QuestionBaseWebViewActivity.a(this.a).setVisibility(8);
    QuestionBaseWebViewActivity.b(this.a).setVisibility(8);
    QuestionBaseWebViewActivity.b(this.a).loadDataWithBaseURL(null, this.a.getText(2131493143).toString(), "text/html", "UTF-8", null);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     c
 * JD-Core Version:    0.6.2
 */