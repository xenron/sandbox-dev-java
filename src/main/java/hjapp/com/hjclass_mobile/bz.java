package hjapp.com.hjclass_mobile;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

final class bz
  implements OnClickListener
{
  bz(HJLessonListActivity paramHJLessonListActivity)
  {
  }

  public final void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
    case 2131361867:
    case 2131361868:
    }
    do
    {
      return;
      HJLessonListActivity.r(this.a).setVisibility(0);
      HJLessonListActivity.s(this.a).setVisibility(8);
      return;
      HJLessonListActivity.r(this.a).setVisibility(8);
      HJLessonListActivity.s(this.a).setVisibility(0);
      if (HJLessonListActivity.o(this.a).isShowing())
        HJLessonListActivity.o(this.a).dismiss();
    }
    while (TextUtils.isEmpty(f.c.a()));
    HJLessonListActivity.t(this.a);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     bz
 * JD-Core Version:    0.6.2
 */