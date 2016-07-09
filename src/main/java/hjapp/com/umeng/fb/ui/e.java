package hjapp.com.umeng.fb.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import hjapp.com.umeng.fb.util.ActivityStarter;

class e
  implements OnClickListener
{
  e(SendFeedback paramSendFeedback)
  {
  }

  public void onClick(View paramView)
  {
    ActivityStarter.openFeedbackListActivity(this.a);
    this.a.finish();
    ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(SendFeedback.a(this.a).getWindowToken(), 0);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     e
 * JD-Core Version:    0.6.2
 */