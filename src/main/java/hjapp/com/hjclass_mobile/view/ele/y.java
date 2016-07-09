package hjapp.com.hjclass_mobile.view.ele;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import hjapp.com.hjclass_mobile.c.b;
import hjapp.com.hjclass_mobile.c.s;
import hjapp.com.hjclass_mobile.d.l;

import java.io.File;

public final class y extends RelativeLayout
  implements OnCompletionListener, OnGestureListener, b, hjapp.com.hjclass_mobile.c.e, hjapp.com.hjclass_mobile.c.f
{
  private hjapp.com.hjclass_mobile.b.a a = null;
  private hjapp.com.hjclass_mobile.d.e b = null;
  private hjapp.com.hjclass_mobile.c.s c = null;
  private Button d = null;
  private VideoView e = null;
  private Animation f = null;
  private Animation g = null;
  private Boolean h = Boolean.valueOf(false);
  private Boolean i = Boolean.valueOf(false);
  private ak j = null;
  private GestureDetector k = null;
  private Boolean l = Boolean.valueOf(false);
  private LayoutParams m = null;

  public y(Context paramContext, hjapp.com.hjclass_mobile.b.a parama)
  {
    super(paramContext);
    this.a = parama;
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903072, null);
    addView(localView);
    this.e = ((VideoView)localView.findViewById(2131361936));
    this.d = ((Button)localView.findViewById(2131361896));
    this.d.setClickable(false);
    this.j = new ak(this.e, this);
    this.f = AnimationUtils.loadAnimation(paramContext, 2130968577);
    this.g = AnimationUtils.loadAnimation(paramContext, 2130968578);
    this.k = new GestureDetector(this);
    this.k.setOnDoubleTapListener(new z(this));
  }

  public final void a()
  {
    h();
    if (this.j != null)
      this.j.c();
    this.k = null;
    removeAllViews();
  }

  public final void a(s params)
  {
    this.c = params;
  }

  public final void a(l paraml)
  {
    if (paraml.g() == null);
    do
    {
      return;
      this.b = paraml.g();
      int n = this.a.a(this.b.a());
      int i1 = this.a.b(this.b.b());
      LayoutParams localLayoutParams = new LayoutParams(this.a.c(this.b.g()), this.a.c(this.b.h()));
      localLayoutParams.leftMargin = n;
      localLayoutParams.topMargin = i1;
      this.m = localLayoutParams;
      setLayoutParams(this.m);
      this.j.a(this.a.c() + File.separator + this.b.c());
    }
    while (!this.b.f());
    setVisibility(8);
  }

  public final void b()
  {
    if (!this.h.booleanValue())
    {
      setVisibility(0);
      this.h = Boolean.valueOf(true);
      startAnimation(this.f);
    }
  }

  public final void c()
  {
    if (!this.i.booleanValue())
    {
      setVisibility(8);
      this.i = Boolean.valueOf(true);
      startAnimation(this.g);
    }
  }

  public final int d()
  {
    return this.b.d();
  }

  public final int e()
  {
    return this.b.e();
  }

  public final Boolean f()
  {
    return Boolean.valueOf(this.b.f());
  }

  public final void g()
  {
    if ((f().booleanValue()) && ((this.i.booleanValue()) || (this.h.booleanValue())))
    {
      setVisibility(8);
      this.i = Boolean.valueOf(false);
      this.h = Boolean.valueOf(false);
      this.j.c();
    }
  }

  public final void h()
  {
    if (this.j.a())
    {
      this.j.c();
      this.d.setVisibility(0);
    }
    setVisibility(8);
  }

  public final void i()
  {
    setVisibility(0);
  }

  public final s j()
  {
    return this.c;
  }

  protected final LayoutParams k()
  {
    LayoutParams localLayoutParams = new LayoutParams(this.a.a(), this.a.b());
    localLayoutParams.leftMargin = this.j.a(this.a);
    localLayoutParams.topMargin = 0;
    return localLayoutParams;
  }

  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.d.setVisibility(0);
    this.l = Boolean.valueOf(false);
    setLayoutParams(this.m);
  }

  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }

  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }

  public final void onLongPress(MotionEvent paramMotionEvent)
  {
  }

  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }

  public final void onShowPress(MotionEvent paramMotionEvent)
  {
  }

  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return true;
  }

  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.k.onTouchEvent(paramMotionEvent);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     y
 * JD-Core Version:    0.6.2
 */