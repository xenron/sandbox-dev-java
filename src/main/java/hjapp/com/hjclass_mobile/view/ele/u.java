package hjapp.com.hjclass_mobile.view.ele;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import hjapp.com.hjclass_mobile.pkg_b.a;
import hjapp.com.hjclass_mobile.pkg_c.b;
import hjapp.com.hjclass_mobile.pkg_c.n;
import hjapp.com.hjclass_mobile.pkg_c.r;
import hjapp.com.hjclass_mobile.pkg_d.k;
import hjapp.com.hjclass_mobile.pkg_d.l;

public final class u extends RelativeLayout
  implements b, n
{
  private Boolean a = Boolean.valueOf(false);
  private Boolean b = Boolean.valueOf(false);
  private Handler c = new Handler();
  private int d = 0;
  private a e = null;
  private r f = null;
  private k g = null;
  private TextView h = null;
  private Button i = null;
  private final Runnable j = new v(this);
  private final Runnable k = new w(this);

  public u(Context paramContext, a parama)
  {
    super(paramContext);
    this.e = parama;
    setClickable(false);
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903070, null);
    addView(localView);
    this.h = ((TextView)localView.findViewById(2131361932));
    this.i = ((Button)localView.findViewById(2131361934));
    this.i.setOnClickListener(new x(this));
  }

  public final void a()
  {
    this.c.removeCallbacks(this.j);
    this.c.removeCallbacks(this.k);
    this.i = null;
  }

  public final void a(r paramr)
  {
    this.f = paramr;
  }

  public final void a(l paraml)
  {
    this.g = paraml.f();
    setVisibility(8);
    if (this.g.c() == 0)
      return;
    int m = this.e.a(this.g.a());
    int n = this.e.b(this.g.b());
    LayoutParams localLayoutParams = new LayoutParams(-2, -2);
    localLayoutParams.leftMargin = m;
    localLayoutParams.topMargin = n;
    setLayoutParams(localLayoutParams);
  }

  public final void b()
  {
    if (!this.a.booleanValue())
    {
      this.b = Boolean.valueOf(true);
      this.a = Boolean.valueOf(true);
      if (this.f != null)
        this.f.a();
      setVisibility(0);
      this.c.removeCallbacks(this.j);
      if (this.g.c() > 0)
      {
        this.d = 0;
        this.c.postDelayed(this.j, 1000L);
      }
    }
    else
    {
      return;
    }
    setVisibility(8);
  }

  public final int c()
  {
    return this.g.d();
  }

  public final void d()
  {
    if (!this.b.booleanValue())
      return;
    this.c.removeCallbacks(this.j);
    setVisibility(8);
    this.b = Boolean.valueOf(false);
    this.c.postDelayed(this.k, 1000L);
  }

  public final Boolean e()
  {
    return this.b;
  }

  public final r f()
  {
    return this.f;
  }

  public final int g()
  {
    return this.g.c();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     u
 * JD-Core Version:    0.6.2
 */