package hjapp.com.hjclass_mobile;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class cc
  implements AnimationListener
{
  private final int b;

  private cc(HJLessonListActivity paramHJLessonListActivity, int paramInt)
  {
    this.b = paramInt;
  }

  public final void onAnimationEnd(Animation paramAnimation)
  {
    HJLessonListActivity.l(this.a).post(new cf(this.a, this.b));
  }

  public final void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public final void onAnimationStart(Animation paramAnimation)
  {
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     cc
 * JD-Core Version:    0.6.2
 */