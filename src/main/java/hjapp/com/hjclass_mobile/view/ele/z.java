package hjapp.com.hjclass_mobile.view.ele;

import android.view.MotionEvent;

final class z
  implements GestureDetector.OnDoubleTapListener
{
  z(y paramy)
  {
  }

  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (!y.c(this.a).booleanValue())
      {
        this.a.setLayoutParams(this.a.k());
        y.a(this.a, Boolean.valueOf(true));
      }
    }
    else
      return false;
    y.a(this.a, Boolean.valueOf(false));
    this.a.setLayoutParams(y.d(this.a));
    return false;
  }

  public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }

  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (y.a(this.a).getVisibility() == 0)
    {
      if ((!y.b(this.a).a()) && (y.b(this.a) != null))
        y.b(this.a).e();
      y.a(this.a).setVisibility(8);
      if (this.a.j() != null)
        this.a.j().a();
      return false;
    }
    if (y.b(this.a).b())
    {
      if (y.b(this.a) != null)
        y.b(this.a).e();
      if (this.a.j() != null)
        this.a.j().a();
      y.a(this.a).setVisibility(8);
      return false;
    }
    if (y.b(this.a) != null)
      y.b(this.a).d();
    y.a(this.a).setVisibility(0);
    return false;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     z
 * JD-Core Version:    0.6.2
 */