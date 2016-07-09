package hjapp.com.hjclass_mobile.view.page;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import hjapp.com.hjclass_mobile.c.b;
import hjapp.com.hjclass_mobile.c.j;
import hjapp.com.hjclass_mobile.c.m;
import hjapp.com.hjclass_mobile.c.n;
import hjapp.com.hjclass_mobile.d.*;
import hjapp.com.hjclass_mobile.view.ele.a;
import hjapp.com.hjclass_mobile.view.ele.aa;
import hjapp.com.hjclass_mobile.view.ele.h;
import hjapp.com.hjclass_mobile.view.ele.l;
import hjapp.com.hjclass_mobile.view.ele.q;
import hjapp.com.hjclass_mobile.view.ele.r;
import hjapp.com.hjclass_mobile.view.ele.s;
import hjapp.com.hjclass_mobile.view.ele.t;
import hjapp.com.hjclass_mobile.view.ele.u;
import hjapp.com.hjclass_mobile.view.ele.y;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HJPage extends RelativeLayout
{
  private boolean A = false;
  int a = 0;
  int b = 0;
  int c = 0;
  int d = 0;
  private hjapp.com.hjclass_mobile.d.y e = null;
  private hjapp.com.hjclass_mobile.b.a f;
  private Context g = null;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private z l = null;
  private List m = null;
  private List n = null;
  private hjapp.com.hjclass_mobile.c.l o = null;
  private j p = null;
  private Boolean q = Boolean.valueOf(true);
  private List r = null;
  private Boolean s = Boolean.valueOf(false);
  private hjapp.com.hjclass_mobile.c.r t = null;
  private hjapp.com.hjclass_mobile.c.s u = null;
  private hjapp.com.hjclass_mobile.c.aa v = null;
  private m w = null;
  private hjapp.com.hjclass_mobile.d.l x = null;
  private int y = 1;
  private RelativeLayout z = null;

  public HJPage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public HJPage(Context paramContext, hjapp.com.hjclass_mobile.b.a parama)
  {
    super(paramContext);
    this.f = parama;
    this.z = new RelativeLayout(paramContext);
    this.z.setBackgroundResource(17170443);
    this.a = parama.a(0);
    this.b = parama.b(0);
    this.c = parama.c(985);
    this.d = parama.c(625);
    t();
    this.g = paramContext;
    this.m = new ArrayList();
    this.n = new ArrayList();
    this.r = new ArrayList();
  }

  private void t()
  {
    RelativeLayout localRelativeLayout = this.z;
    int i1 = this.a;
    int i2 = this.b;
    LayoutParams localLayoutParams = new LayoutParams(this.c, this.d);
    localLayoutParams.leftMargin = i1;
    localLayoutParams.topMargin = i2;
    localRelativeLayout.setLayoutParams(localLayoutParams);
    addView(this.z);
  }

  public final void a()
  {
    int i1 = this.n.size();
    for (int i2 = 0; i2 < i1; i2++)
      ((hjapp.com.hjclass_mobile.c.f)this.n.get(i2)).h();
  }

  public final void a(int paramInt)
  {
    int i1 = this.m.size();
    int i2 = 0;
    if (i2 < i1)
    {
      hjapp.com.hjclass_mobile.c.e locale = (hjapp.com.hjclass_mobile.c.e)this.m.get(i2);
      if (locale.f().booleanValue())
      {
        if (locale.d() > 0)
        {
          if (paramInt < locale.d())
            break label107;
          locale.b();
        }
        label73: if (locale.e() > 0)
        {
          if (paramInt < locale.e())
            break label117;
          locale.c();
        }
      }
      while (true)
      {
        i2++;
        break;
        label107: locale.g();
        break label73;
        label117: if (paramInt < locale.d())
          locale.g();
      }
    }
  }

  public final void a(hjapp.com.hjclass_mobile.c.aa paramaa)
  {
    this.v = paramaa;
  }

  public final void a(hjapp.com.hjclass_mobile.c.r paramr)
  {
    this.t = paramr;
  }

  public final void a(hjapp.com.hjclass_mobile.c.s params)
  {
    this.u = params;
  }

  public final void a(hjapp.com.hjclass_mobile.d.y paramy)
  {
    this.e = paramy;
  }

  public final void a(z paramz)
  {
    this.l = paramz;
  }

  public final void a(Boolean paramBoolean)
  {
    this.q = paramBoolean;
  }

  public final void a(boolean paramBoolean)
  {
    this.w.a(paramBoolean);
  }

  public final void b()
  {
    int i1 = this.n.size();
    for (int i2 = 0; i2 < i1; i2++)
      ((hjapp.com.hjclass_mobile.c.f)this.n.get(i2)).i();
  }

  public final void b(int paramInt)
  {
    int i1 = this.r.size();
    int i2 = 0;
    if (i2 < i1)
    {
      hjapp.com.hjclass_mobile.c.n localn = (n)this.r.get(i2);
      if ((localn != null) && (paramInt == localn.c()))
        if (!localn.e().booleanValue())
          localn.b();
      while (true)
      {
        i2++;
        break;
        if (localn.e().booleanValue())
          localn.d();
      }
    }
  }

  public final void c()
  {
    int i1 = this.r.size();
    for (int i2 = 0; i2 < i1; i2++)
      ((n)this.r.get(i2)).d();
  }

  public final void c(int paramInt)
  {
    if (paramInt >= 0)
      this.j = paramInt;
    this.h = paramInt;
  }

  public final void d()
  {
    int i1 = this.m.size();
    for (int i2 = 0; i2 < i1; i2++)
      ((hjapp.com.hjclass_mobile.c.e)this.m.get(i2)).g();
  }

  public final void d(int paramInt)
  {
    if (paramInt >= 0)
      this.k = paramInt;
    this.i = paramInt;
  }

  public final void e()
  {
    if (this.s.booleanValue());
    hjapp.com.hjclass_mobile.d.l locall;
    label348: label364: Context localContext;
    String str2;
    hjapp.com.hjclass_mobile.b.a locala;
    while (true)
    {
      return;
      this.s = Boolean.valueOf(true);
      int i1 = getChildCount();
      for (int i2 = 0; i2 < i1; i2++)
        if ((getChildAt(i2) instanceof b))
          ((b)getChildAt(i2)).a();
      super.removeAllViews();
      t();
      Object localObject1;
      String str1;
      int i5;
      if (!TextUtils.isEmpty(this.e.b()))
      {
        localObject1 = new Options();
        str1 = this.f.c() + File.separator + this.e.b();
        Options localOptions1 = new Options();
        localOptions1.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str1, localOptions1);
        int i3 = localOptions1.outWidth;
        int i4 = localOptions1.outHeight;
        if ((i3 > 0) && (i3 > 0))
        {
          Options localOptions2 = new Options();
          localOptions2.inJustDecodeBounds = true;
          if ((i3 < 500) || (i4 < 400))
            break label348;
          i5 = 2;
          localOptions2.inSampleSize = i5;
          hjapp.com.hjclass_mobile.h.u.b("inSampleSize=" + i5);
          localOptions2.inJustDecodeBounds = false;
          localOptions2.inInputShareable = true;
          localOptions2.inPurgeable = true;
          localObject1 = localOptions2;
        }
      }
      try
      {
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(BitmapFactory.decodeFile(str1, (Options)localObject1));
        this.z.setBackgroundDrawable(localBitmapDrawable);
        setBackgroundResource(2130837522);
        Iterator localIterator = this.e.e().iterator();
        while (localIterator.hasNext())
        {
          locall = (hjapp.com.hjclass_mobile.d.l)localIterator.next();
          if (!locall.a().equals("videomark"))
            break label364;
          this.x = locall;
        }
        i5 = 1;
      }
      catch (Exception localException)
      {
        while (true)
          localException.printStackTrace();
        localContext = this.g;
        str2 = locall.a();
        locala = this.f;
        if (!str2.endsWith("txt"))
          break label762;
      }
    }
    Object localObject2 = new s(localContext, locala);
    label407: if (localObject2 != null)
    {
      View localView = (View)localObject2;
      addView(localView);
      ((b)localObject2).a(locall);
      if (((localObject2 instanceof hjapp.com.hjclass_mobile.view.ele.e)) && ((locall.c().c() == 985) || (locall.c().d() == 625)))
        setBackgroundResource(2130837522);
      if ((localObject2 instanceof hjapp.com.hjclass_mobile.c.e))
      {
        hjapp.com.hjclass_mobile.c.e locale = (hjapp.com.hjclass_mobile.c.e)localObject2;
        if (locale.f().booleanValue())
        {
          if (locale.d() > 0)
            localView.setVisibility(8);
          this.m.add(locale);
        }
      }
      if ((localObject2 instanceof n))
      {
        this.r.add((n)localObject2);
        if (this.t != null)
          ((hjapp.com.hjclass_mobile.view.ele.u)localObject2).a(this.t);
      }
      if ((localObject2 instanceof hjapp.com.hjclass_mobile.c.f))
      {
        this.n.add((hjapp.com.hjclass_mobile.c.f)localObject2);
        if (this.u != null)
        {
          if (!(localObject2 instanceof hjapp.com.hjclass_mobile.view.ele.y))
            break label1099;
          ((hjapp.com.hjclass_mobile.view.ele.y)localObject2).a(this.u);
        }
      }
    }
    while (true)
    {
      if ((localObject2 instanceof j))
      {
        this.p = ((j)localObject2);
        this.p.a(this.v);
        this.q = Boolean.valueOf(false);
        if (((this.y == 1) || ((this.y == 2) && (this.A))) && (this.l != null))
        {
          this.p.a(this.l);
          this.q = Boolean.valueOf(true);
          this.h = -1;
          this.i = -1;
        }
      }
      if ((localObject2 instanceof hjapp.com.hjclass_mobile.c.l))
        this.o = ((hjapp.com.hjclass_mobile.c.l)localObject2);
      if (!(localObject2 instanceof m))
        break;
      this.w = ((m)localObject2);
      break;
      label762: if (str2.endsWith("pic"))
      {
        localObject2 = new hjapp.com.hjclass_mobile.view.ele.e(localContext, locala);
        break label407;
      }
      if (str2.endsWith("textarea"))
      {
        localObject2 = new t(localContext, locala);
        break label407;
      }
      if (str2.endsWith("wordart"))
      {
        localObject2 = new aa(localContext, locala);
        break label407;
      }
      if (str2.endsWith("timer"))
      {
        localObject2 = new u(localContext, locala);
        break label407;
      }
      if (str2.endsWith("audio"))
      {
        localObject2 = new a(localContext, locala);
        break label407;
      }
      if (str2.endsWith("summaryPage"))
      {
        localObject2 = new r(localContext);
        break label407;
      }
      str2.endsWith("swf");
      if (str2.endsWith("summaryQestion"))
      {
        localObject2 = new q(localContext);
        break label407;
      }
      if (str2.endsWith("timer"))
      {
        localObject2 = new u(localContext, locala);
        break label407;
      }
      if (str2.endsWith("video"))
      {
        localObject2 = new y(localContext, locala);
        break label407;
      }
      if (str2.endsWith("1"))
      {
        localObject2 = new h(localContext, locala, false);
        break label407;
      }
      if (str2.endsWith("3"))
      {
        localObject2 = new h(localContext, locala, true);
        break label407;
      }
      if (str2.endsWith("2"))
      {
        localObject2 = new l(localContext, locala);
        break label407;
      }
      localObject2 = null;
      break label407;
      break;
      label1099: ((hjapp.com.hjclass_mobile.view.ele.a)localObject2).a(this.u);
    }
  }

  public final void f()
  {
    if (g().endsWith("102"))
      this.o.b();
  }

  public final String g()
  {
    if (this.e != null)
      return this.e.c();
    return "0";
  }

  public final int h()
  {
    if (this.e != null)
      return this.e.a().intValue();
    return 0;
  }

  public final void i()
  {
    this.m.clear();
    this.n.clear();
    this.o = null;
    this.r.clear();
    this.l = null;
    int i1 = getChildCount();
    for (int i2 = 0; i2 < i1; i2++)
      if ((getChildAt(i2) instanceof b))
        ((b)getChildAt(i2)).a();
    removeAllViews();
  }

  public final double j()
  {
    return this.w.b();
  }

  public final int k()
  {
    return this.h;
  }

  public final int l()
  {
    return this.i;
  }

  public final Boolean m()
  {
    return this.q;
  }

  public final z n()
  {
    return this.l;
  }

  public final hjapp.com.hjclass_mobile.c.l o()
  {
    return this.o;
  }

  public final hjapp.com.hjclass_mobile.d.l p()
  {
    return this.x;
  }

  public final int q()
  {
    return this.j;
  }

  public final int r()
  {
    return this.k;
  }

  public final j s()
  {
    return this.p;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJPage
 * JD-Core Version:    0.6.2
 */