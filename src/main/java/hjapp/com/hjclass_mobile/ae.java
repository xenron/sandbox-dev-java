package hjapp.com.hjclass_mobile;

import hjapp.com.hjclass_mobile.c.aa;
import hjapp.com.hjclass_mobile.d.ab;
import hjapp.com.hjclass_mobile.d.z;
import hjapp.com.hjclass_mobile.view.page.HJPage;

final class ae
  implements aa
{
  ae(HJClassPlayerV3 paramHJClassPlayerV3, HJPage paramHJPage)
  {
  }

  public final void a(ab paramab)
  {
    z localz;
    if (this.a.n() == null)
    {
      h.u.b("=========addEvent");
      HJClassPlayerV3.b(this.b).postDelayed(HJClassPlayerV3.e(this.b), 1000L);
      localz = new z();
      localz.a(paramab.a());
      localz.c(this.a.h());
      localz.a(paramab.b());
      localz.a(paramab.c());
      if (paramab.b() != 0.0F)
        break label242;
      localz.b(2);
      HJClassPlayerV3.f(this.b);
      int i = HJApplication.f();
      HJClassPlayerV3.f(this.b);
      HJApplication.a(i + 1);
    }
    while (true)
    {
      if (localz.c() != 0)
      {
        HJApplication localHJApplication = (HJApplication)this.b.getApplicationContext();
        if (!localHJApplication.d().containsKey(Integer.valueOf(this.a.h())))
          localHJApplication.d().put(Integer.valueOf(this.a.h()), localz);
        this.a.c(-1);
        this.a.d(-1);
        this.a.a(Boolean.valueOf(true));
        HJClassPlayerV3.g(this.b);
      }
      return;
      h.u.b("=========removeEvent");
      HJClassPlayerV3.b(this.b).removeCallbacks(HJClassPlayerV3.e(this.b));
      break;
      label242: HJClassPlayerV3.f(this.b);
      float f = HJApplication.h() + paramab.b();
      HJClassPlayerV3.f(this.b);
      HJApplication.a(f);
      localz.b(1);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ae
 * JD-Core Version:    0.6.2
 */