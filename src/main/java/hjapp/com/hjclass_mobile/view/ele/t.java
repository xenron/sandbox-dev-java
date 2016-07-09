package hjapp.com.hjclass_mobile.view.ele;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import hjapp.com.hjclass_mobile.b.a;
import hjapp.com.hjclass_mobile.c.b;
import hjapp.com.hjclass_mobile.d.l;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class t extends ScrollView
  implements b, hjapp.com.hjclass_mobile.c.e
{
  private a a = null;
  private BaseTextView b = null;
  private hjapp.com.hjclass_mobile.d.j c = null;
  private Animation d = null;
  private Animation e = null;
  private Boolean f = Boolean.valueOf(false);
  private Boolean g = Boolean.valueOf(false);

  public t(Context paramContext, a parama)
  {
    super(paramContext);
    setTag("textarea");
    setBackgroundColor(15658734);
    this.b = new BaseTextView(paramContext);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLinearLayout.addView(this.b);
    setBackgroundResource(2130837823);
    localLinearLayout.setLayoutParams(localLayoutParams);
    addView(localLinearLayout);
    this.a = parama;
    this.d = AnimationUtils.loadAnimation(paramContext, 2130968577);
    this.e = AnimationUtils.loadAnimation(paramContext, 2130968578);
  }

  public final void a()
  {
    removeAllViews();
    this.b = null;
  }

  public final void a(l paraml)
  {
    this.c = paraml.e();
    String str = this.c.e();
    int i = this.a.a(this.c.a());
    int j = this.a.b(this.c.b());
    int k = this.a.c(this.c.c());
    int m = this.a.c(this.c.d());
    Matcher localMatcher = Pattern.compile("<TEXTFORMAT LEADING=\"(\\d+)\">").matcher(str);
    float f1 = 2.0F;
    if (localMatcher.find())
      f1 = Float.parseFloat(localMatcher.group(1));
    this.b.setLineSpacing(f1, 1.0F);
    this.b.setText(c.a(str));
    super.setLayoutParams(BaseTextView.a(i, j, k, m));
    if (this.c.h())
      setVisibility(8);
  }

  public final void b()
  {
    if (!this.f.booleanValue())
    {
      setVisibility(0);
      this.f = Boolean.valueOf(true);
      startAnimation(this.d);
    }
  }

  public final void c()
  {
    if (!this.g.booleanValue())
    {
      setVisibility(8);
      this.g = Boolean.valueOf(true);
      startAnimation(this.e);
    }
  }

  public final int d()
  {
    return this.c.f();
  }

  public final int e()
  {
    return this.c.g();
  }

  public final Boolean f()
  {
    return Boolean.valueOf(this.c.h());
  }

  public final void g()
  {
    if ((f().booleanValue()) && ((this.g.booleanValue()) || (this.f.booleanValue())))
    {
      setVisibility(8);
      this.g = Boolean.valueOf(false);
      this.f = Boolean.valueOf(false);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     t
 * JD-Core Version:    0.6.2
 */