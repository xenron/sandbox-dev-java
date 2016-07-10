package hjapp.com.hjclass_mobile.view.ele;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public final class f extends RelativeLayout
  implements OnGestureListener, hjapp.com.hjclass_mobile.pkg_c.b
{
  private hjapp.com.hjclass_mobile.pkg_b.a a = null;
  private hjapp.com.hjclass_mobile.pkg_d.f b = null;
  private Button c = null;
  private Button d = null;
  private GestureDetector e = null;
  private LayoutParams f = null;
  private boolean g = false;
  private LinearLayout h = null;
  private int i;
  private int j = 0;

  public f(Context paramContext, hjapp.com.hjclass_mobile.pkg_b.a parama)
  {
    super(paramContext);
    this.a = parama;
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903058, null);
    addView(localView);
    this.c = ((Button)localView.findViewById(2131361896));
    this.c.setClickable(false);
    this.d = ((Button)localView.findViewById(2131361897));
    this.d.setClickable(false);
    this.d.setVisibility(8);
    this.h = ((LinearLayout)localView.findViewById(2131361900));
    this.e = new GestureDetector(this);
    this.e.setOnDoubleTapListener(new g(this));
  }

  public final void a()
  {
  }

  public final void a(hjapp.com.hjclass_mobile.pkg_d.l paraml)
  {
    this.b = paraml.d();
    if (!this.b.e().equals("fullscreen"))
    {
      int k = this.a.a(this.b.a());
      int m = this.a.b(this.b.b());
      LayoutParams localLayoutParams = new LayoutParams(this.a.c(this.b.c()), this.a.c(this.b.d()));
      localLayoutParams.leftMargin = k;
      localLayoutParams.topMargin = m;
      this.f = localLayoutParams;
      setLayoutParams(this.f);
    }
  }

  public final void a(hjapp.com.hjclass_mobile.pkg_g.r paramr)
  {
    if (this.h.getChildCount() == 0)
    {
      paramr.m();
      SurfaceView localSurfaceView = paramr.n();
      this.h.addView(localSurfaceView);
      this.i = paramr.o();
      this.j = paramr.p();
    }
  }

  public final void a(String paramString)
  {
    if (paramString.equals("play"))
    {
      this.d.setVisibility(8);
      this.c.setVisibility(8);
      this.g = false;
    }
    while (!paramString.equals("pause"))
      return;
    this.d.setVisibility(0);
    this.c.setVisibility(8);
    this.g = true;
  }

  public final void b()
  {
    if (this.h.getChildCount() > 0)
      this.h.removeAllViews();
  }

  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }

  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }

  public final void onLongPress(MotionEvent paramMotionEvent)
  {
  }

  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }

  public final void onShowPress(MotionEvent paramMotionEvent)
  {
  }

  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     f
 * JD-Core Version:    0.6.2
 */