package hjapp.com.hjclass_mobile.view.ele;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import hjapp.com.hjclass_mobile.pkg_b.a;
import hjapp.com.hjclass_mobile.pkg_c.b;
import hjapp.com.hjclass_mobile.pkg_c.e;
import hjapp.com.hjclass_mobile.pkg_d.l;
import hjapp.com.hjclass_mobile.pkg_d.m;

import java.io.File;

public final class aa extends ImageView
  implements b, e
{
  private a a = null;
  private m b = null;
  private Bitmap c = null;
  private Animation d = null;
  private Animation e = null;
  private Boolean f = Boolean.valueOf(false);
  private Boolean g = Boolean.valueOf(false);

  public aa(Context paramContext, a parama)
  {
    super(paramContext);
    this.a = parama;
    setScaleType(ScaleType.FIT_XY);
    this.d = AnimationUtils.loadAnimation(paramContext, 2130968577);
    this.e = AnimationUtils.loadAnimation(paramContext, 2130968578);
  }

  public final void a()
  {
    if ((this.c != null) && (!this.c.isRecycled()))
    {
      this.c.recycle();
      this.c = null;
    }
    setImageBitmap(null);
  }

  public final void a(l paraml)
  {
    this.b = paraml.h();
    Options localOptions = new Options();
    String str = this.a.c() + File.separator + this.b.h();
    int i = this.a.a(this.b.a());
    int j = this.a.b(this.b.b());
    int k = this.a.c(this.b.c());
    int m = this.a.c(this.b.d());
    if ((k > 0) && (m > 0))
    {
      localOptions = new Options();
      localOptions.inJustDecodeBounds = true;
      localOptions.inSampleSize = hjapp.com.hjclass_mobile.pkg_h.z.a(localOptions, Math.min(k, m), k * m);
      localOptions.inJustDecodeBounds = false;
      localOptions.inInputShareable = true;
      localOptions.inPurgeable = true;
    }
    try
    {
      this.c = BitmapFactory.decodeFile(str, localOptions);
      setImageBitmap(this.c);
      label192: setPadding(0, 0, 0, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, m);
      localLayoutParams.leftMargin = i;
      localLayoutParams.topMargin = j;
      setLayoutParams(localLayoutParams);
      if (this.b.g())
        setVisibility(8);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label192;
    }
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
    return this.b.e();
  }

  public final int e()
  {
    return this.b.f();
  }

  public final Boolean f()
  {
    return Boolean.valueOf(this.b.g());
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
 * Qualified Name:     aa
 * JD-Core Version:    0.6.2
 */