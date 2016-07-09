package hjapp.com.hjclass_mobile.questions;

import android.os.Bundle;
import android.os.Handler;

public class QuestionDetailsActivity extends QuestionBaseWebViewActivity
{
  protected final a a(Handler paramHandler)
  {
    return new h(this, paramHandler, this);
  }

  protected final View.OnClickListener c()
  {
    return new g(this);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(true);
    this.a.setText(2131493142);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     QuestionDetailsActivity
 * JD-Core Version:    0.6.2
 */