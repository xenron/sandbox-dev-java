package hjapp.com.hjclass_mobile;

import android.view.MotionEvent;

final class af
  implements GestureDetector.OnDoubleTapListener
{
  af(HJClassPlayerV3 paramHJClassPlayerV3)
  {
  }

  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    return false;
  }

  public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }

  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
      this.a.g();
    return false;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     af
 * JD-Core Version:    0.6.2
 */