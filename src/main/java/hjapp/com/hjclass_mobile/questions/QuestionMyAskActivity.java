package hjapp.com.hjclass_mobile.questions;

import android.os.Bundle;
import android.os.Handler;

public class QuestionMyAskActivity extends QuestionBaseWebViewActivity
{
  protected final a a(Handler paramHandler)
  {
    a locala = new a(paramHandler, this);
    locala.a = false;
    return locala;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(false);
    this.a.setText(2131493148);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     QuestionMyAskActivity
 * JD-Core Version:    0.6.2
 */