package hjapp.com.hjclass_mobile;

import android.view.View;
import android.view.View.OnClickListener;
import hjapp.com.hjclass_mobile.pkg_d.t;

final class bv
  implements OnClickListener
{
  bv(HJLessonListActivity paramHJLessonListActivity)
  {
  }

  public final void onClick(View paramView)
  {
    t localt = (t)paramView.getTag();
    HJLessonListActivity.a(this.a, localt);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     bv
 * JD-Core Version:    0.6.2
 */