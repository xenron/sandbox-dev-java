package hjapp.com.hjclass_mobile;

final class cf
  implements Runnable
{
  private final int b;

  public cf(HJLessonListActivity paramHJLessonListActivity, int paramInt)
  {
    this.b = paramInt;
  }

  public final void run()
  {
    float f1 = HJLessonListActivity.l(this.a).getWidth() / 2.0F;
    float f2 = HJLessonListActivity.l(this.a).getHeight() / 2.0F;
    if (this.b >= 0)
    {
      HJLessonListActivity.m(this.a).setVisibility(0);
      HJLessonListActivity.n(this.a).setVisibility(8);
      if (HJLessonListActivity.o(this.a).isShowing())
      {
        HJLessonListActivity.p(this.a);
        HJLessonListActivity.o(this.a).dismiss();
        HJLessonListActivity.q(this.a).setBackgroundResource(2130837599);
      }
    }
    while (true)
    {
      hjapp.com.hjclass_mobile.view.j localj = new hjapp.com.hjclass_mobile.view.j(270.0F, 360.0F, f1, f2);
      localj.setDuration(500L);
      localj.setFillAfter(true);
      HJLessonListActivity.l(this.a).startAnimation(localj);
      return;
      HJLessonListActivity.n(this.a).setVisibility(0);
      HJLessonListActivity.m(this.a).setVisibility(8);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     cf
 * JD-Core Version:    0.6.2
 */