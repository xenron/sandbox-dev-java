package hjapp.com.hjclass_mobile.view.ele;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import hjapp.com.hjclass_mobile.d.l;

import java.io.File;

public final class e extends ImageView
  implements hjapp.com.hjclass_mobile.c.b, hjapp.com.hjclass_mobile.c.e
{
  private hjapp.com.hjclass_mobile.b.a a = null;
  private hjapp.com.hjclass_mobile.d.d b = null;
  private Bitmap c = null;
  private Animation d = null;
  private Animation e = null;
  private Boolean f = Boolean.valueOf(false);
  private Boolean g = Boolean.valueOf(false);

  public e(Context paramContext, hjapp.com.hjclass_mobile.b.a parama)
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
    this.b = null;
  }

  public final void a(l paraml)
  {
    this.b = paraml.c();
    Object localObject = new Options();
    String str1 = this.b.h();
    Log.i("eleImg", str1);
    int i = this.a.a(this.b.a());
    int j = this.a.b(this.b.b());
    int k = this.a.c(this.b.c());
    int m = this.a.c(this.b.d());
    String str2 = this.a.c() + File.separator + str1;
    Options localOptions1 = new Options();
    localOptions1.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(str2, localOptions1);
    int n = localOptions1.outWidth;
    int i1 = localOptions1.outHeight;
    Options localOptions2;
    int i2;
    if ((n > 0) && (n > 0))
    {
      localOptions2 = new Options();
      localOptions2.inJustDecodeBounds = true;
      if ((n < 500) || (i1 < 400))
        break label453;
      i2 = 2;
    }
    while (true)
    {
      localOptions2.inSampleSize = i2;
      hjapp.com.hjclass_mobile.h.u.b("inSampleSize=" + i2);
      localOptions2.inJustDecodeBounds = false;
      localOptions2.inInputShareable = true;
      localOptions2.inPurgeable = true;
      localObject = localOptions2;
      try
      {
        this.c = BitmapFactory.decodeFile(str2, (Options)localObject);
        if (this.c != null)
        {
          setPadding(0, 0, 0, 0);
          if ((!this.b.j()) || (this.b.i()))
            break label482;
          BlurMaskFilter localBlurMaskFilter = new BlurMaskFilter(10.0F, Blur.NORMAL);
          Paint localPaint = new Paint();
          localPaint.setMaskFilter(localBlurMaskFilter);
          Bitmap localBitmap = this.c.extractAlpha(localPaint, new int[2]).copy(Config.ARGB_8888, true);
          new Canvas(localBitmap).drawBitmap(this.c, 0.0F, 0.0F, null);
          if (!this.c.isRecycled())
            this.c.recycle();
          this.c = localBitmap;
          setImageBitmap(this.c);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, m);
          localLayoutParams.leftMargin = i;
          localLayoutParams.topMargin = j;
          setLayoutParams(localLayoutParams);
          if (this.b.g())
            setVisibility(8);
        }
        return;
        label453: i2 = 1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        while (true)
        {
          ((Options)localObject).inSampleSize = 4;
          System.gc();
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          localException.printStackTrace();
          continue;
          label482: if ((this.b.j()) && (this.b.i()))
          {
            setImageBitmap(this.c);
            if (this.b.k().endsWith("0x00ffffff"))
              setBackgroundResource(2130837805);
            else
              setBackgroundResource(2130837804);
          }
        }
      }
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

  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Rect localRect;
    Paint localPaint;
    if ((this.b.i()) && (!this.b.j()))
    {
      localRect = paramCanvas.getClipBounds();
      localPaint = new Paint();
      localPaint.setStrokeWidth(10.0F);
      if (!this.b.k().endsWith("0x00ffffff"))
        break label79;
      localPaint.setColor(-1);
    }
    while (true)
    {
      localPaint.setStyle(Style.STROKE);
      paramCanvas.drawRect(localRect, localPaint);
      return;
      label79: localPaint.setColor(-3355444);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     e
 * JD-Core Version:    0.6.2
 */