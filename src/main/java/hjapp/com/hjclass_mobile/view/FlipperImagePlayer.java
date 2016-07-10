package hjapp.com.hjclass_mobile.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
import hjapp.com.hjclass_mobile.pkg_c.p;
import hjapp.com.hjclass_mobile.pkg_d.y;
import java.io.File;
import java.util.List;

public class FlipperImagePlayer extends LinearLayout
  implements p
{
  private int a = -1;
  private String b;
  private View c;
  private ZoomImageView d;
  private ZoomImageView e;
  private ZoomImageView f;
  private FrameLayout g;
  private FrameLayout h;
  private FrameLayout i;
  private ViewFlipper j;
  private Context k;
  private int l = 0;
  private List m;

  public FlipperImagePlayer(Context paramContext)
  {
    super(paramContext);
  }

  public FlipperImagePlayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.k = paramContext;
    this.c = LayoutInflater.from(paramContext).inflate(2130903076, this);
    this.j = ((ViewFlipper)this.c.findViewById(2131361946));
    this.g = ((FrameLayout)this.c.findViewById(2131361947));
    this.h = ((FrameLayout)this.c.findViewById(2131361948));
    this.i = ((FrameLayout)this.c.findViewById(2131361949));
    this.e = ((ZoomImageView)this.g.findViewById(2131362031));
    this.e.a(this);
    this.f = ((ZoomImageView)this.h.findViewById(2131362031));
    this.f.a(this);
    this.d = ((ZoomImageView)this.i.findViewById(2131362031));
    this.d.a(this);
    this.j.setInAnimation(this.k, 2130968583);
    this.j.setOutAnimation(this.k, 2130968584);
    ZoomImageView localZoomImageView = this.e;
    if (this.m != null);
    for (Bitmap localBitmap = BitmapFactory.decodeFile(this.b + File.separator + ((y)this.m.get(0)).b()); ; localBitmap = null)
    {
      localZoomImageView.a(localBitmap);
      return;
    }
  }

  private void b(int paramInt)
  {
    String str;
    if (this.m != null)
    {
      str = this.b + File.separator + ((y)this.m.get(paramInt)).b();
      this.a = paramInt;
    }
    try
    {
      this.f.a(null);
      this.d.a(null);
      this.e.a(BitmapFactory.decodeFile(str));
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public final void a()
  {
    Intent localIntent = new Intent("zoom_show_toggle");
    this.k.sendBroadcast(localIntent);
  }

  public final void a(int paramInt)
  {
    int n = 0;
    if (this.m == null)
      return;
    if (paramInt <= 0)
    {
      this.l = 0;
      b(0);
      return;
    }
    int i1 = this.m.size();
    int i2 = -1;
    y localy;
    if (n < i1)
    {
      localy = (y)this.m.get(n);
      if (paramInt < localy.d().intValue())
        i2 = n;
    }
    else
    {
      if (paramInt >= this.l)
        break label197;
      if (this.a != i2)
      {
        this.j.setInAnimation(this.k, 2130968585);
        this.j.setOutAnimation(this.k, 2130968586);
        ZoomImageView localZoomImageView2 = this.e;
        this.e = this.d;
        this.d = this.f;
        this.f = localZoomImageView2;
        this.j.showPrevious();
        b(i2);
      }
      label157: this.l = paramInt;
      return;
    }
    if ((n == i1 - 1) && (paramInt >= localy.d().intValue()));
    for (int i3 = i1 - 1; ; i3 = i2)
    {
      n++;
      i2 = i3;
      break;
      label197: if (this.a == i2)
        break label157;
      this.j.setInAnimation(this.k, 2130968583);
      this.j.setOutAnimation(this.k, 2130968584);
      ZoomImageView localZoomImageView1 = this.e;
      this.e = this.f;
      this.f = this.d;
      this.d = localZoomImageView1;
      this.j.showNext();
      b(i2);
      break label157;
    }
  }

  public final void a(String paramString)
  {
    this.b = paramString;
  }

  public final void a(List paramList)
  {
    this.m = paramList;
  }

  public final void b()
  {
    if (this.e != null)
      this.e.c();
  }

  public final void c()
  {
    if (this.e != null)
      this.e.b();
  }

  public final int d()
  {
    return ((y)this.m.get(this.a)).d().intValue();
  }

  public final int e()
  {
    int n = -2 + this.a;
    if (n < 0)
      return 0;
    return ((y)this.m.get(n)).d().intValue();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     FlipperImagePlayer
 * JD-Core Version:    0.6.2
 */