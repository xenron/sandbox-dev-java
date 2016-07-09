package hjapp.com.hjclass_mobile.zoom;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import hjapp.com.hjclass_mobile.c.t;

public final class c
  implements OnTouchListener
{
  private t a;
  private b b;
  private Context c;
  private d d = d.a;
  private float e;
  private float f;
  private float g;
  private float h;

  public final void a(Context paramContext)
  {
    this.c = paramContext;
  }

  public final void a(t paramt)
  {
    this.a = paramt;
  }

  public final void a(b paramb)
  {
    this.b = paramb;
  }

  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    case 1:
    default:
      return true;
    case 0:
      if (this.a != null)
        this.a.a();
      this.g = f1;
      this.h = f2;
    case 2:
    }
    while (true)
    {
      this.e = f1;
      this.f = f2;
      break;
      float f3 = (f1 - this.e) / paramView.getWidth();
      float f4 = (f2 - this.f) / paramView.getHeight();
      if (this.d == d.b)
        this.b.a((float)Math.pow(20.0D, -f4), this.g / paramView.getWidth(), this.h / paramView.getHeight());
      else
        this.b.a(-f3, -f4);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     c
 * JD-Core Version:    0.6.2
 */