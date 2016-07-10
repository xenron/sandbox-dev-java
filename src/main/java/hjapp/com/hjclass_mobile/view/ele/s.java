package hjapp.com.hjclass_mobile.view.ele;

import android.content.Context;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import hjapp.com.hjclass_mobile.pkg_c.b;
import hjapp.com.hjclass_mobile.pkg_d.l;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class s extends BaseTextView
  implements b, hjapp.com.hjclass_mobile.pkg_c.e
{
  private hjapp.com.hjclass_mobile.pkg_b.a a = null;
  private hjapp.com.hjclass_mobile.pkg_d.j b = null;
  private Animation c = null;
  private Animation d = null;
  private Boolean e = Boolean.valueOf(false);
  private Boolean f = Boolean.valueOf(false);

  public s(Context paramContext, hjapp.com.hjclass_mobile.pkg_b.a parama)
  {
    super(paramContext);
    setSelectAllOnFocus(false);
    setEnabled(true);
    setScroller(null);
    setTag("txt");
    this.a = parama;
    this.c = AnimationUtils.loadAnimation(paramContext, 2130968577);
    this.d = AnimationUtils.loadAnimation(paramContext, 2130968578);
  }

  public final void a()
  {
  }

  public final void a(l paraml)
  {
    this.b = paraml.e();
    String str1 = this.b.e().replace("{user}", hjapp.com.hjclass_mobile.pkg_f.c.c()).replace("<P", "<d").replace("</P>", "</d><br/>");
    int i = this.a.a(this.b.a());
    int j = this.a.b(this.b.b());
    int k = this.a.c(20 + this.b.d());
    Matcher localMatcher1 = Pattern.compile("<TEXTFORMAT LEADING=\"(\\d+)\">").matcher(str1);
    float f1 = 2.0F;
    if (localMatcher1.find())
      f1 = Float.parseFloat(localMatcher1.group(1));
    Matcher localMatcher2 = Pattern.compile("<d ALIGN=\"(LEFT|CENTER|RIGHT)\">").matcher(str1);
    String str2 = "left";
    if (localMatcher2.find())
      str2 = localMatcher2.group(1);
    setLineSpacing(f1, 1.0F);
    setText(hjapp.com.hjclass_mobile.pkg_h.c.a(str1.replace("<FONT FACE=\"Microsoft Yahei,微软雅黑\" SIZE=\"24\" COLOR=\"#333333\" LETTERSPACING=\"0\" KERNING=\"0\">", "")));
    hjapp.com.hjclass_mobile.pkg_h.u.b("align=" + str2);
    int m;
    if (str2.equals("LEFT"))
    {
      m = this.a.c(60 + this.b.c());
      setGravity(3);
    }
    while (true)
    {
      super.setLayoutParams(a(i, j, m, k));
      if (this.b.h())
        setVisibility(8);
      return;
      if (str2.equals("CENTER"))
      {
        m = this.a.c(this.b.c());
        setGravity(17);
      }
      else
      {
        boolean bool = str2.equals("RIGHT");
        m = 0;
        if (bool)
        {
          m = this.a.c(this.b.c());
          setGravity(5);
        }
      }
    }
  }

  public final void b()
  {
    if (!this.e.booleanValue())
    {
      setVisibility(0);
      this.e = Boolean.valueOf(true);
      startAnimation(this.c);
    }
  }

  public final void c()
  {
    if (!this.f.booleanValue())
    {
      setVisibility(8);
      this.f = Boolean.valueOf(true);
      Log.i("===", this.f + ",执行结束动画");
      startAnimation(this.d);
    }
  }

  public final int d()
  {
    return this.b.f();
  }

  public final int e()
  {
    return this.b.g();
  }

  public final Boolean f()
  {
    return Boolean.valueOf(this.b.h());
  }

  public final void g()
  {
    if ((f().booleanValue()) && ((this.f.booleanValue()) || (this.e.booleanValue())))
    {
      Log.i("===", "reset");
      setVisibility(8);
      this.f = Boolean.valueOf(false);
      this.e = Boolean.valueOf(false);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     s
 * JD-Core Version:    0.6.2
 */