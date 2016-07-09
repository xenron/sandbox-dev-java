package hjapp.com.hjclass_mobile.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import hjapp.com.hjclass_mobile.c.k;
import hjapp.com.hjclass_mobile.h.u;

public class HJLinearLayout extends LinearLayout
{
  private boolean a = false;

  public HJLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void a(View paramView, boolean paramBoolean)
  {
    int i = ((LinearLayout)paramView).getChildCount();
    int j = 0;
    if (j < i)
    {
      View localView = ((LinearLayout)paramView).getChildAt(j);
      if ((localView instanceof LinearLayout))
        a(localView, paramBoolean);
      while (true)
      {
        j++;
        break;
        ((k)localView).b();
      }
    }
  }

  public final void a()
  {
    a(this, false);
  }

  public final boolean b()
  {
    return this.a;
  }

  public final void c()
  {
    this.a = false;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    default:
      return bool;
    case 0:
      this.a = true;
      u.b("onInterceptTouchEvent_ACTION_DOWN 返回的是" + bool);
      return bool;
    case 2:
      u.b("onInterceptTouchEvent_ACTION_MOVE 返回的是" + bool);
      return bool;
    case 1:
    }
    this.a = false;
    u.b("onInterceptTouchEvent_ACTION_UP 返回的是" + bool);
    return bool;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    u.b("onTouchEvent 返回的是" + bool);
    return super.onTouchEvent(paramMotionEvent);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJLinearLayout
 * JD-Core Version:    0.6.2
 */