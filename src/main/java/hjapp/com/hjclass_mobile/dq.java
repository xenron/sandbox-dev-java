package hjapp.com.hjclass_mobile;

import android.view.View;
import android.view.View.OnFocusChangeListener;

final class dq
  implements OnFocusChangeListener
{
  dq(HJTabCourseActivity paramHJTabCourseActivity)
  {
  }

  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView.isFocused())
    {
      HJTabCourseActivity.a(this.a).showSoftInput(paramView, 0);
      return;
    }
    HJTabCourseActivity.a(this.a).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     dq
 * JD-Core Version:    0.6.2
 */