package hjapp.com.hjclass_mobile.zoom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import java.util.Observable;
import java.util.Observer;

public class ImageZoomView extends View
  implements Observer
{
  private final Paint a = new Paint(2);
  private final Rect b = new Rect();
  private final Rect c = new Rect();
  private final a d = new a();
  private Bitmap e;
  private e f;

  public ImageZoomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public final a a()
  {
    return this.d;
  }

  public final void a(Bitmap paramBitmap)
  {
    this.e = paramBitmap;
    if (this.e != null)
    {
      this.d.a(getWidth(), getHeight(), this.e.getWidth(), this.e.getHeight());
      this.d.notifyObservers();
      invalidate();
    }
  }

  public final void a(e parame)
  {
    if (this.f != null)
      this.f.deleteObserver(this);
    this.f = parame;
    this.f.addObserver(this);
    invalidate();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.e != null) && (this.f != null))
    {
      float f1 = this.d.a();
      int i = getWidth();
      int j = getHeight();
      int k = this.e.getWidth();
      int m = this.e.getHeight();
      float f2 = this.f.a();
      float f3 = this.f.b();
      float f4 = this.f.a(f1) * i / k;
      float f5 = this.f.b(f1) * j / m;
      this.b.left = ((int)(f2 * k - i / (f4 * 2.0F)));
      this.b.top = ((int)(f3 * m - j / (f5 * 2.0F)));
      this.b.right = ((int)(this.b.left + i / f4));
      this.b.bottom = ((int)(this.b.top + j / f5));
      this.c.left = getLeft();
      this.c.top = getTop();
      this.c.right = getRight();
      this.c.bottom = getBottom();
      if (this.b.left < 0)
      {
        Rect localRect4 = this.c;
        localRect4.left = ((int)(localRect4.left + f4 * -this.b.left));
        this.b.left = 0;
      }
      if (this.b.right > k)
      {
        Rect localRect3 = this.c;
        localRect3.right = ((int)(localRect3.right - f4 * (this.b.right - k)));
        this.b.right = k;
      }
      if (this.b.top < 0)
      {
        Rect localRect2 = this.c;
        localRect2.top = ((int)(localRect2.top + f5 * -this.b.top));
        this.b.top = 0;
      }
      if (this.b.bottom > m)
      {
        Rect localRect1 = this.c;
        localRect1.bottom = ((int)(localRect1.bottom - f5 * (this.b.bottom - m)));
        this.b.bottom = m;
      }
      paramCanvas.drawBitmap(this.e, this.b, this.c, this.a);
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.e != null)
    {
      this.d.a(paramInt3 - paramInt1, paramInt4 - paramInt2, this.e.getWidth(), this.e.getHeight());
      this.d.notifyObservers();
    }
  }

  public void update(Observable paramObservable, Object paramObject)
  {
    invalidate();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ImageZoomView
 * JD-Core Version:    0.6.2
 */