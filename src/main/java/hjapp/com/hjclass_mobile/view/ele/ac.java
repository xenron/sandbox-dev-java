package hjapp.com.hjclass_mobile.view.ele;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import hjapp.com.hjclass_mobile.c.k;
import hjapp.com.hjclass_mobile.d.c;
import hjapp.com.hjclass_mobile.d.l;

public final class ac extends RelativeLayout
  implements k
{
  private ImageView a = null;
  private ImageView b = null;
  private Boolean c = Boolean.valueOf(false);
  private LinearLayout d = null;
  private hjapp.com.hjclass_mobile.b.a e = null;
  private RadioButton f = null;
  private String g = null;
  private hjapp.com.hjclass_mobile.c.z h = null;
  private int i = -1;

  public ac(Context paramContext, hjapp.com.hjclass_mobile.b.a parama)
  {
    super(paramContext);
    this.e = parama;
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903060, null);
    addView(localView);
    this.f = ((RadioButton)localView.findViewById(2131361903));
    this.f.setOnCheckedChangeListener(new ad(this));
    this.b = ((ImageView)localView.findViewById(2131361906));
    this.a = ((ImageView)localView.findViewById(2131361905));
    this.a.setVisibility(4);
    this.b.setVisibility(4);
    this.d = ((LinearLayout)localView.findViewById(2131361904));
  }

  public final void a()
  {
    this.f.setEnabled(true);
    setEnabled(true);
    this.f.setChecked(false);
    this.a.setVisibility(4);
    this.b.setVisibility(4);
  }

  public final void a(hjapp.com.hjclass_mobile.c.z paramz)
  {
    this.h = paramz;
  }

  public final void a(hjapp.com.hjclass_mobile.d.z paramz)
  {
    if (paramz.b().equals(this.g))
    {
      this.f.setChecked(true);
      if (this.c.booleanValue())
        this.b.setVisibility(0);
    }
    else
    {
      return;
    }
    this.a.setVisibility(0);
  }

  public final void a(Boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public final void a(String paramString)
  {
  }

  public final void b()
  {
    this.f.setEnabled(false);
    setEnabled(false);
  }

  public final void b(String paramString)
  {
    this.f.setText(Html.fromHtml(paramString));
    this.g = paramString;
  }

  public final void c()
  {
    removeAllViews();
    this.a.destroyDrawingCache();
    this.a = null;
    this.b.destroyDrawingCache();
    this.b = null;
    this.d.removeAllViews();
    this.f = null;
    this.d = null;
  }

  public final void c(String paramString)
  {
    l locall = new l();
    c localc = new c();
    localc.a(paramString);
    localc.a(false);
    localc.d("TYPE_SHORT");
    localc.a(0);
    localc.b(0);
    locall.a("audio");
    locall.a(localc);
    a locala = new a(getContext(), this.e);
    locala.a(locall);
    this.d.addView(locala);
  }

  public final Boolean d()
  {
    return this.c;
  }

  public final hjapp.com.hjclass_mobile.c.z e()
  {
    return this.h;
  }

  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    default:
      return bool;
    case 0:
      hjapp.com.hjclass_mobile.h.u.b("onInterceptTouchEvent_ACTION_DOWN 返回的是" + bool);
      return bool;
    case 2:
      hjapp.com.hjclass_mobile.h.u.b("onInterceptTouchEvent_ACTION_MOVE 返回的是" + bool);
      return bool;
    case 1:
    }
    hjapp.com.hjclass_mobile.h.u.b("onInterceptTouchEvent_ACTION_UP 返回的是" + bool);
    return bool;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ac
 * JD-Core Version:    0.6.2
 */