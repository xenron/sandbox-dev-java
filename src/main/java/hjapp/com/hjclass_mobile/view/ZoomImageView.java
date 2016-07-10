package hjapp.com.hjclass_mobile.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.Toast;
import hjapp.com.hjclass_mobile.pkg_c.p;
import hjapp.com.hjclass_mobile.pkg_c.t;
import hjapp.com.hjclass_mobile.zoom.ImageZoomView;
import hjapp.com.hjclass_mobile.zoom.b;
import hjapp.com.hjclass_mobile.zoom.c;

public class ZoomImageView extends FrameLayout
  implements t
{
  private p a;
  private b b;
  private c c;
  private Context d = null;
  private ImageZoomView e;
  private Bitmap f;
  private boolean g;
  private boolean h;

  public ZoomImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = paramContext;
    ((LayoutInflater)this.d.getSystemService("layout_inflater")).inflate(2130903089, this);
    this.b = new b();
    this.c = new c();
    this.c.a(this);
    this.c.a(this.b);
    this.c.a(this.d);
    this.e = ((ImageZoomView)findViewById(2131361980));
    this.e.a(this.b.a());
    this.e.setOnTouchListener(this.c);
    this.b.a(this.e.a());
    d();
  }

  private void d()
  {
    this.b.a().c(0.5F);
    this.b.a().d(0.5F);
    this.b.a().e(1.0F);
    this.b.a().notifyObservers();
  }

  public final void a()
  {
    if (this.a != null)
      this.a.a();
  }

  public final void a(Bitmap paramBitmap)
  {
    if ((this.f != null) && (this.f.isRecycled()))
    {
      this.f.recycle();
      this.f = null;
    }
    this.f = paramBitmap;
    this.e.a(this.f);
    d();
  }

  public final void a(p paramp)
  {
    this.a = paramp;
  }

  public final void b()
  {
    if (this.h)
      Toast.makeText(this.d, this.d.getString(2131493041), 0).show();
    do
    {
      do
      {
        float f1;
        do
        {
          return;
          f1 = this.b.a().c();
        }
        while (f1 >= 3.0F);
        this.b.a().e(f1 + 0.2F);
        this.b.a().notifyObservers();
        if (this.b.a().c() < 3.0F)
          break;
      }
      while (this.a == null);
      this.h = true;
      return;
    }
    while (this.a == null);
    this.h = false;
    this.g = false;
  }

  public final void c()
  {
    if (this.g)
      Toast.makeText(this.d, this.d.getString(2131493043), 0).show();
    do
    {
      do
      {
        float f1;
        do
        {
          return;
          f1 = this.b.a().c();
        }
        while (f1 <= 1.0F);
        this.b.a().c(0.5F);
        this.b.a().d(0.5F);
        this.b.a().e(f1 - 0.2F);
        this.b.a().notifyObservers();
        if (this.b.a().c() > 1.0F)
          break;
        d();
      }
      while (this.a == null);
      this.g = true;
      return;
    }
    while (this.a == null);
    this.g = false;
    this.h = false;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ZoomImageView
 * JD-Core Version:    0.6.2
 */