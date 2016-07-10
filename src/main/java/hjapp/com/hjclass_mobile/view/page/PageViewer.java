package hjapp.com.hjclass_mobile.view.page;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Toast;
import hjapp.com.hjclass_mobile.HJClassPlayerV3.MyPagerAdapter;
import hjapp.com.hjclass_mobile.pkg_c.ab;
import hjapp.com.hjclass_mobile.pkg_c.ac;
import hjapp.com.hjclass_mobile.pkg_c.q;
import hjapp.com.hjclass_mobile.pkg_c.y;
import hjapp.com.hjclass_mobile.pkg_h.u;
import hjapp.com.hjclass_mobile.pkg_d.l;

import java.util.List;

public class PageViewer extends ViewPager
{
  private int a = 0;
  private boolean b = false;
  private HJPage c = null;
  private List d = null;
  private y e = null;
  private q f = null;
  private ac g = null;
  private ab h = null;

  public PageViewer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void b(int paramInt)
  {
    u.b("开始手动翻页Pageindex=" + paramInt);
    this.c = ((HJPage)((HJClassPlayerV3.MyPagerAdapter)getAdapter()).a.get(paramInt));
    if (this.c != null)
    {
      if (Integer.parseInt(this.c.g()) != Integer.parseInt("102"))
        break label159;
      getContext().sendBroadcast(new Intent("pause_cmd"));
      this.c.f();
      if (this.e != null)
      {
        String str = this.c.o().c();
        if (str != null)
          this.e.a(str);
      }
    }
    while (true)
    {
      this.c.d();
      this.c.c();
      this.c.b();
      this.a = paramInt;
      setCurrentItem(paramInt);
      return;
      label159: if (this.c.g().endsWith("100"))
      {
        u.b("开始手动翻页Pageindex=" + paramInt);
        getContext().sendBroadcast(new Intent("pause_cmd"));
      }
      else if (this.c.g().endsWith("101"))
      {
        double d1 = this.c.j();
        if (this.h != null)
        {
          boolean bool = this.h.a(d1);
          this.c.a(bool);
        }
        Intent localIntent2 = new Intent("seek_cmd");
        localIntent2.putExtra("timeStamp", this.c.k());
        getContext().sendBroadcast(localIntent2);
      }
      else
      {
        if (this.f != null)
          this.f.a(b());
        Intent localIntent1 = new Intent("seek_cmd");
        localIntent1.putExtra("timeStamp", this.c.k());
        getContext().sendBroadcast(localIntent1);
      }
    }
  }

  private HJPage c(int paramInt)
  {
    u.b("index=========" + paramInt);
    HJClassPlayerV3.MyPagerAdapter localMyPagerAdapter = (HJClassPlayerV3.MyPagerAdapter)getAdapter();
    if ((paramInt >= 0) && (paramInt < localMyPagerAdapter.a.size()))
    {
      if (this.c != null)
      {
        if (paramInt == -1 + this.c.h())
          return null;
        if (this.f != null)
          this.f.u();
        this.c.a();
      }
      setCurrentItem(paramInt);
      this.c = ((HJPage)localMyPagerAdapter.a.get(paramInt));
      if (this.c != null)
      {
        this.c.d();
        this.c.c();
        this.c.b();
        this.a = paramInt;
        if (this.f != null)
          this.f.a(b());
        return this.c;
      }
    }
    return null;
  }

  public final void a()
  {
    int i = 1 + this.a;
    int j = getAdapter().getCount();
    if (j == 1)
      return;
    if (i >= j)
      i = j - 1;
    if (this.c != null)
    {
      this.c.a();
      if (this.f != null)
        this.f.u();
      if ((!this.c.m().booleanValue()) && (this.c.g().endsWith("100")))
      {
        Toast.makeText(getContext(), getContext().getString(2131493161), 0).show();
        return;
      }
    }
    u.b("setShowPageAt2");
    b(i);
  }

  public final void a(int paramInt)
  {
    if (paramInt <= 0)
      c(0);
    HJClassPlayerV3.MyPagerAdapter localMyPagerAdapter;
    do
    {
      return;
      localMyPagerAdapter = (HJClassPlayerV3.MyPagerAdapter)getAdapter();
    }
    while (localMyPagerAdapter == null);
    int i = localMyPagerAdapter.getCount();
    for (int j = 0; ; j++)
    {
      if (j < i)
      {
        HJPage localHJPage2 = (HJPage)localMyPagerAdapter.a.get(j);
        if (paramInt >= localHJPage2.l())
          continue;
        if (this.a != j)
        {
          u.b(paramInt + "<==>" + localHJPage2.l());
          if (c(j) != null)
          {
            if (Integer.parseInt(this.c.g()) != Integer.parseInt("102"))
              break label214;
            getContext().sendBroadcast(new Intent("pause_cmd"));
            this.c.f();
            if (this.e != null)
            {
              String str = this.c.o().c();
              if (str != null)
                this.e.a(str);
            }
          }
        }
      }
      while (this.c != null)
      {
        HJPage localHJPage1 = this.c;
        localHJPage1.b(paramInt);
        localHJPage1.a(paramInt);
        return;
        label214: if (this.c.g().endsWith("100"))
        {
          getContext().sendBroadcast(new Intent("pause_cmd"));
        }
        else if (this.c.g().endsWith("101"))
        {
          double d1 = this.c.j();
          if (this.h != null)
          {
            u.b("mark=========" + d1);
            boolean bool = this.h.a(d1);
            this.c.a(bool);
          }
        }
      }
      break;
    }
  }

  public final void a(ab paramab)
  {
    this.h = paramab;
  }

  public final void a(q paramq)
  {
    this.f = paramq;
  }

  public final void a(y paramy)
  {
    this.e = paramy;
  }

  public final void a(List paramList)
  {
    this.d = paramList;
  }

  public final l b()
  {
    if (this.c != null)
      return this.c.p();
    this.c = ((HJPage)((HJClassPlayerV3.MyPagerAdapter)getAdapter()).a.get(0));
    return this.c.p();
  }

  public final void c()
  {
    if (getAdapter().getCount() == 1)
      return;
    int i = -1 + this.a;
    if (i < 0)
      i = 0;
    if (this.c != null)
    {
      if (this.f != null)
        this.f.u();
      this.c.a();
    }
    u.b("setShowPageAt3");
    b(i);
  }

  public final boolean d()
  {
    if (this.c != null)
    {
      if ((!this.c.m().booleanValue()) && (this.c.g().endsWith("100")))
      {
        Toast.makeText(getContext(), getContext().getString(2131493161), 0).show();
        return false;
      }
      if ((this.c.m().booleanValue()) && (this.c.g().endsWith("102")))
      {
        u.b("setShowPageAt1");
        b(this.c.h());
      }
    }
    return true;
  }

  public final int e()
  {
    if (this.c != null)
      return this.c.l();
    return 0;
  }

  public final int f()
  {
    HJClassPlayerV3.MyPagerAdapter localMyPagerAdapter = (HJClassPlayerV3.MyPagerAdapter)getAdapter();
    int i = -2 + this.a;
    if (i < 0)
      return 0;
    HJPage localHJPage = (HJPage)localMyPagerAdapter.a.get(i);
    if (localHJPage != null)
      return localHJPage.l();
    return 0;
  }

  public final void g()
  {
    if (getAdapter() == null);
    while (true)
    {
      return;
      HJClassPlayerV3.MyPagerAdapter localMyPagerAdapter = (HJClassPlayerV3.MyPagerAdapter)getAdapter();
      if (localMyPagerAdapter != null)
      {
        int i = localMyPagerAdapter.getCount();
        for (int j = 0; j < i; j++)
        {
          HJPage localHJPage = (HJPage)localMyPagerAdapter.a.get(j);
          if (localHJPage != null)
            localHJPage.i();
        }
      }
    }
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b)
      super.onInterceptTouchEvent(paramMotionEvent);
    return false;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b)
      return super.onTouchEvent(paramMotionEvent);
    return false;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     PageViewer
 * JD-Core Version:    0.6.2
 */