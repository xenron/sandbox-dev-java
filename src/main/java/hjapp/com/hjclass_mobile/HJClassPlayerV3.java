package hjapp.com.hjclass_mobile;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import hjapp.com.hjclass_mobile.pkg_c.q;
import hjapp.com.hjclass_mobile.pkg_c.v;
import hjapp.com.hjclass_mobile.pkg_d.l;
import hjapp.com.hjclass_mobile.pkg_g.r;
import hjapp.com.hjclass_mobile.view.ele.f;
import hjapp.com.hjclass_mobile.view.page.HJPage;
import hjapp.com.hjclass_mobile.view.page.PageViewer;
import hjapp.com.hjclass_mobile.view.widget.n;
import hjapp.com.hjclass_mobile.view.widget.o;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

public class HJClassPlayerV3 extends BaseActivity
  implements OnGestureListener, hjapp.com.hjclass_mobile.pkg_b.t, hjapp.com.hjclass_mobile.pkg_c.ab, hjapp.com.hjclass_mobile.pkg_c.g, q, v, hjapp.com.hjclass_mobile.pkg_c.x, hjapp.com.hjclass_mobile.pkg_c.y
{
  private static long r = 0L;
  private static long s = 0L;
  private hjapp.com.hjclass_mobile.pkg_c.d A = null;
  private hjapp.com.hjclass_mobile.pkg_c.d B = null;
  private Boolean C = Boolean.valueOf(false);
  private aj D = null;
  private Boolean E = Boolean.valueOf(false);
  private List F = null;
  private Runnable G = new z(this);
  private Runnable H = new aa(this);
  private Runnable I = new ab(this);
  private List J;
  private PagerAdapter K;
  protected long a = 0L;
  String b = null;
  int c = 0;
  private hjapp.com.hjclass_mobile.view.d d;
  private hjapp.com.hjclass_mobile.pkg_g.g e = null;
  private LinearLayout f = null;
  private RelativeLayout g = null;
  private Button h = null;
  private hjapp.com.hjclass_mobile.pkg_d.t i = null;
  private hjapp.com.hjclass_mobile.pkg_b.s j;
  private GestureDetector k = null;
  private hjapp.com.hjclass_mobile.pkg_b.a l = null;
  private int m;
  private int n;
  private boolean o;
  private long p;
  private boolean q = false;
  private PageViewer t = null;
  private hjapp.com.hjclass_mobile.pkg_b.b u = null;
  private HJApplication v = null;
  private boolean w = false;
  private RelativeLayout x = null;
  private f y = null;
  private Handler z = new Handler();

  private void A()
  {
    hjapp.com.hjclass_mobile.pkg_d.ac localac = new pkg_d.ac();
    localac.a(this.i.d());
    localac.b(this.i.c());
    localac.c(this.i.a());
    localac.a("");
    this.u.a(localac);
  }

  private void a(Bundle paramBundle)
  {
    hjapp.com.hjclass_mobile.h.z.a(this);
    if (paramBundle != null)
    {
      this.u = new pkg_b.b(this);
      this.i = ((hjapp.com.hjclass_mobile.pkg_d.t)paramBundle.getSerializable("lesson"));
      String str = paramBundle.getString("filePath");
      File localFile = new File(str);
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      this.m = localDisplayMetrics.widthPixels;
      this.n = localDisplayMetrics.heightPixels;
      hjapp.com.hjclass_mobile.pkg_b.a locala = new pkg_b.a(this.m, this.n);
      if (this.i != null)
        locala.a(hjapp.com.hjclass_mobile.h.z.c + this.i.a() + File.separator + this.i.d() + File.separator + this.i.c());
      this.l = locala;
      this.C = Boolean.valueOf(this.u.d(this.i.d(), this.i.a()));
      this.A = new o(this, this.C.booleanValue());
      this.B = new n(this);
      this.F = this.u.h(this.i.a(), this.i.d(), this.i.c());
      if (this.F != null)
      {
        this.v.d().clear();
        int i1 = this.F.size();
        for (int i2 = 0; i2 < i1; i2++)
        {
          hjapp.com.hjclass_mobile.pkg_d.z localz = (hjapp.com.hjclass_mobile.pkg_d.z)this.F.get(i2);
          this.v.d().put(Integer.valueOf(localz.d()), localz);
        }
      }
      if (localFile.exists())
      {
        this.j = new pkg_b.s(this);
        this.j.execute(new String[] { str, "true" });
        return;
      }
      Toast.makeText(this, getString(2131493002), 0).show();
      finish();
      return;
    }
    Toast.makeText(this, getString(2131493001), 0).show();
    finish();
  }

  private void x()
  {
    if (this.g != null)
      this.g.setVisibility(8);
  }

  private void y()
  {
    if (this.g != null)
      this.g.setVisibility(0);
  }

  private boolean z()
  {
    u.b("开始解锁...");
    int i1 = this.i.j();
    boolean bool = false;
    if (i1 == 0);
    try
    {
      int i2 = this.u.e(this.i.d(), this.i.a());
      u.b("获得需要解锁课程ID=" + i2);
      bool = false;
      if (i2 > 0)
      {
        this.u.d(i2, this.i.a(), this.i.d());
        Intent localIntent = new Intent("open_next_lesson");
        localIntent.putExtra("currentLessonID", this.i.c());
        localIntent.putExtra("nextLessonID", i2);
        sendBroadcast(localIntent);
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public final void a(int paramInt)
  {
    if (this.e != null)
      this.e.a(paramInt);
  }

  public final void a(hjapp.com.hjclass_mobile.pkg_d.b paramb)
  {
    if (paramb == null)
    {
      Toast.makeText(this, getString(2131493029), 1).show();
      return;
    }
    this.d = new hjapp.com.hjclass_mobile.view.d(this);
    ((LinearLayout)findViewById(2131361902)).addView(this.d);
    int i1 = this.i.a();
    int i2 = this.i.d();
    int i3 = this.u.g(i1, i2, this.i.c());
    this.i.j(i3);
    this.c = Integer.parseInt(paramb.e());
    this.b = (hjapp.com.hjclass_mobile.h.z.c + i1 + File.separator + i2 + File.separator + this.i.c() + File.separator + paramb.b());
    String str1 = this.u.c(i2, i1);
    String str4;
    String str5;
    if (this.c == 5)
    {
      hjapp.com.hjclass_mobile.h.z.k = true;
      this.y = new f(this, this.l);
      this.x.addView(this.y);
      str4 = this.b;
      str5 = String.valueOf(i2);
    }
    while (true)
    {
      try
      {
        r localr = new r(str4, this, str5, str1);
        localr.a(this);
        localr.a(this);
        this.e = localr;
        if (!this.E.booleanValue())
          this.e.h();
        this.K = new HJClassPlayerV3.MyPagerAdapter(this, this.J);
        this.t.setAdapter(this.K);
        getWindow().addFlags(128);
        return;
      }
      catch (IOException localIOException2)
      {
        localIOException2.printStackTrace();
        continue;
      }
      hjapp.com.hjclass_mobile.h.z.k = false;
      String str2 = this.b;
      String str3 = String.valueOf(i2);
      try
      {
        hjapp.com.hjclass_mobile.pkg_g.a locala = new pkg_g.a(str2, this, str3, str1);
        locala.a(this);
        this.e = locala;
        this.e.h();
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
      }
    }
  }

  public final void a(l paraml)
  {
    if ((this.x.getVisibility() != 0) && (this.y != null) && (paraml != null))
    {
      this.x.setVisibility(0);
      this.y.a(paraml);
    }
  }

  public final void a(String paramString)
  {
    hjapp.com.hjclass_mobile.pkg_d.ac localac = new pkg_d.ac();
    localac.a(this.i.d());
    localac.b(this.i.c());
    localac.c(this.i.a());
    localac.a(paramString);
    this.u.a(localac);
  }

  public final boolean a(double paramDouble)
  {
    u.b("当前学习mark=" + paramDouble);
    if (this.o)
      this.A.a();
    while (this.o)
      return true;
    long l1 = new Date().getTime();
    s = l1;
    long l2 = l1 - r + this.a;
    u.b("当前学习时间" + l2);
    this.p = ((int)(l2 / 1000L) + this.i.u());
    u.b("当前学习累计时间" + this.p);
    this.i.j((int)(l2 / 1000L));
    if (this.i != null)
    {
      int i1;
      if (this.C.booleanValue())
      {
        if (((this.p >= 180L) || (paramDouble >= 0.8D)) && (this.i.d() > 1))
        {
          if (!this.q)
            this.q = z();
          this.o = true;
        }
      }
      else
      {
        i1 = this.u.f(this.i.a(), this.i.d(), this.i.c());
        if (i1 != 2)
          break label271;
        this.o = true;
        return true;
      }
      this.o = false;
      A();
      return false;
      label271: if (i1 < 2)
        if (((this.p >= 180L) || (paramDouble >= 0.8D)) && (this.i.d() > 1))
        {
          hjapp.com.hjclass_mobile.pkg_d.x localx = new pkg_d.x();
          localx.a(paramDouble);
          localx.b(this.i.c());
          localx.a(this.i.d());
          localx.a(this.p);
          localx.c(this.i.a());
          if (hjapp.com.hjclass_mobile.h.z.h)
          {
            localx.a(this.u.i(this.i.a(), this.i.d(), this.i.c()));
            hjapp.com.hjclass_mobile.f.a.a(c.a(), localx, 4);
            this.i.g(2);
          }
          this.o = true;
          if (!this.o)
            break label635;
          this.i.f(100);
          this.i.i(0);
          this.i.a(paramDouble);
          this.u.c(this.i);
          if ((!this.C.booleanValue()) || (!this.i.x()))
            break label623;
          this.B.a();
        }
      while (true)
      {
        int i2 = this.u.f(c.b(), this.i.d());
        hjapp.com.hjclass_mobile.pkg_b.b localb = this.u;
        this.i.d();
        localb.g(i2, c.b());
        return true;
        this.o = false;
        A();
        this.i.g(0);
        break;
        if ((this.p >= 180L) && (this.i.d() > 1))
        {
          this.o = true;
          this.i.g(1);
          break;
        }
        this.o = false;
        A();
        this.i.g(0);
        break;
        label623: this.A.a();
      }
    }
    label635: return false;
  }

  public final int b()
  {
    if (this.e != null)
      return this.e.d();
    return 0;
  }

  public final void b(int paramInt)
  {
    this.t.a(paramInt);
  }

  public final void b(hjapp.com.hjclass_mobile.pkg_d.b paramb)
  {
    int i3;
    int i4;
    HJPage localHJPage;
    Object localObject;
    int i7;
    int i6;
    if (paramb != null)
    {
      int i1 = paramb.d().size();
      List localList = paramb.d();
      this.J = new ArrayList();
      this.v.e().clear();
      int i2 = 0;
      i3 = 0;
      i4 = 0;
      while (true)
        if ((i2 < i1) && (!this.w))
        {
          localHJPage = new HJPage(this, this.l);
          localHJPage.a(new ac(this));
          localHJPage.a(new ad(this));
          localHJPage.a(new ae(this, localHJPage));
          hjapp.com.hjclass_mobile.pkg_d.y localy1 = (hjapp.com.hjclass_mobile.pkg_d.y)localList.get(i2);
          localHJPage.a(localy1);
          if (i2 == 0)
          {
            localHJPage.c(0);
            localHJPage.d(localy1.d().intValue());
            localObject = null;
            if (!localHJPage.g().equals("100"))
              break label636;
            i7 = i4 + 1;
            if (((paramb.f() != 1) && ((paramb.f() != 2) || (!paramb.g().booleanValue()))) || (this.v.d() == null))
              break label629;
            Enumeration localEnumeration = this.v.d().keys();
            Integer localInteger;
            do
            {
              if (!localEnumeration.hasMoreElements())
                break;
              localInteger = (Integer)localEnumeration.nextElement();
            }
            while (localInteger.intValue() != localHJPage.h());
            hjapp.com.hjclass_mobile.pkg_d.z localz = (hjapp.com.hjclass_mobile.pkg_d.z)this.v.d().get(localInteger);
            if (localz == null)
              break label629;
            localHJPage.a(localz);
            localHJPage.c(-1);
            localHJPage.d(-1);
            if (localObject == null)
              break label629;
            ((hjapp.com.hjclass_mobile.pkg_d.aa)localObject).a(true);
            i6 = i7;
            label325: if (localObject != null)
              this.v.e().add(localObject);
            HJApplication.b(i6);
            HJApplication.c(i6 * 10);
            this.J.add(localHJPage);
            this.t.a(localList);
            if (i2 == 0)
            {
              localHJPage.d();
              localHJPage.c();
            }
            i2++;
            i4 = i6;
          }
          else
          {
            hjapp.com.hjclass_mobile.pkg_d.y localy2 = (hjapp.com.hjclass_mobile.pkg_d.y)localList.get(i2 - 1);
            if (localy1.d().intValue() > 0)
              localHJPage.d(localy1.d().intValue());
            if (localy2.d().intValue() > 0)
            {
              localHJPage.c(localy2.d().intValue());
              label476: if (localHJPage.l() <= 0)
                break label649;
            }
          }
        }
    }
    label649: for (int i5 = localHJPage.l(); ; i5 = i3)
    {
      if (localHJPage.g().equals("100"))
      {
        localObject = new pkg_d.aa();
        ((hjapp.com.hjclass_mobile.pkg_d.aa)localObject).a(i5);
        localHJPage.c(i5);
        localHJPage.d(i5 * 1000);
        ((hjapp.com.hjclass_mobile.pkg_d.aa)localObject).a(false);
      }
      while (true)
      {
        if (localHJPage.g().equals("102"))
        {
          localHJPage.c(i5);
          localHJPage.d(i5);
        }
        if (localHJPage.g().equals("101"))
        {
          localHJPage.c(paramb.c().intValue());
          localHJPage.d(paramb.c().intValue());
        }
        i3 = i5;
        break;
        localHJPage.c(i3);
        break label476;
        return;
        label629: i6 = i7;
        break label325;
        label636: i6 = i4;
        break label325;
        localObject = null;
      }
    }
  }

  public final int c()
  {
    if (this.e != null)
      return this.e.b();
    return 0;
  }

  public final boolean d()
  {
    if (this.e != null)
      return this.e.a();
    return false;
  }

  public final void e()
  {
    if (this.e != null)
    {
      this.e.e();
      if (this.y != null)
        this.y.a("play");
      long l1 = new Date().getTime();
      s = l1;
      this.a = (l1 - r + this.a);
    }
  }

  public final void f()
  {
    if (this.e != null)
      r = new Date().getTime();
    this.e.f();
    if (this.y != null)
      this.y.a("play");
  }

  public final void g()
  {
    if (this.d != null)
    {
      if (this.d.b())
      {
        this.d.c();
        x();
      }
    }
    else
      return;
    this.d.a(3000);
    y();
  }

  public final void h()
  {
    if (this.i != null)
    {
      int i1 = this.u.a(this.i.a(), this.i.c(), this.i.d());
      if (i1 > 0)
        this.e.a(i1);
    }
    if ((this.t != null) && (hjapp.com.hjclass_mobile.h.z.k))
    {
      if (this.y != null)
      {
        this.y.a((r)this.e);
        this.y.a("play");
      }
      if (this.t.b() != null)
        a(this.t.b());
    }
    r = new Date().getTime();
    this.f.setVisibility(8);
    this.d.a(this);
    this.d.a(3000);
    y();
  }

  public final int i()
  {
    return 1000 * this.t.e();
  }

  public final int j()
  {
    return 1000 * this.t.f();
  }

  public final void k()
  {
  }

  public final void l()
  {
  }

  public final void m()
  {
    g();
  }

  public final void n()
  {
    x();
  }

  public final void o()
  {
    y();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setFormat(1);
    this.v = ((HJApplication)getApplicationContext());
    HJApplication.a(0.0F);
    HJApplication.c(0);
    HJApplication.a(0);
    HJApplication.b(0);
    if (this.v.d().size() > 0)
      this.v.d().clear();
    if (this.v.e().size() > 0)
      this.v.e().clear();
    if (this.D == null)
    {
      this.D = new aj(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("restudy");
      registerReceiver(this.D, localIntentFilter);
    }
    getWindow().addFlags(4096);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    setRequestedOrientation(0);
    ai localai = new ai(this);
    ((TelephonyManager)getSystemService("phone")).listen(localai, 32);
    setContentView(2130903106);
    hjapp.com.hjclass_mobile.h.z.a(this);
    this.f = ((LinearLayout)findViewById(2131362021));
    this.x = ((RelativeLayout)findViewById(2131362027));
    this.t = ((PageViewer)findViewById(2131362026));
    this.t.a(this);
    this.t.a(this);
    this.t.a(this);
    this.g = ((RelativeLayout)findViewById(2131362023));
    this.h = ((Button)findViewById(2131362024));
    this.h.setOnClickListener(new ag(this));
    this.k = new GestureDetector(this);
    this.k.setOnDoubleTapListener(new af(this));
    a(getIntent().getExtras());
  }

  protected void onDestroy()
  {
    this.w = true;
    unregisterReceiver(this.D);
    hjapp.com.hjclass_mobile.h.z.b(this);
    super.onDestroy();
    if (this.d != null)
      this.d.a();
    if (this.i != null)
      if (this.e != null)
      {
        u.b("isStop=" + this.o);
        u.b("player.getCurrentionPosition()" + this.e.d());
        if (!this.o)
          break label193;
        this.i.i(0);
      }
    while (true)
    {
      if (this.u != null)
        this.u.b(this.i);
      if ((this.j != null) && (this.j.getStatus() == AsyncTask.Status.RUNNING))
        this.j.cancel(true);
      if (this.e != null)
        this.e.c();
      if (this.t != null)
        this.t.g();
      return;
      label193: this.i.i(this.e.d());
    }
  }

  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }

  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
      this.w = true;
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public void onLongPress(MotionEvent paramMotionEvent)
  {
  }

  protected void onPause()
  {
    super.onPause();
  }

  protected void onRestart()
  {
    super.onRestart();
    if ((this.c == 5) && (this.E.booleanValue()))
    {
      if (this.e.a())
        this.i.i(this.e.d());
      this.f.setVisibility(0);
      ((hjapp.com.hjclass_mobile.pkg_g.a)this.e).c();
      this.z.postDelayed(this.H, 1100L);
    }
  }

  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }

  public void onShowPress(MotionEvent paramMotionEvent)
  {
  }

  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return true;
  }

  protected void onStop()
  {
    super.onStop();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.k.onTouchEvent(paramMotionEvent);
  }

  public final void p()
  {
    this.t.a();
  }

  public final void q()
  {
    this.t.c();
  }

  public final boolean r()
  {
    return this.t.d();
  }

  public final void s()
  {
    if (this.d != null)
    {
      this.d.e();
      this.d.d.setProgress(0);
    }
  }

  public final void t()
  {
    finish();
  }

  public final void u()
  {
    if (this.x.getVisibility() != 8)
      this.x.setVisibility(8);
  }

  public final void v()
  {
    if (this.c == 5)
    {
      if (((r)this.e).q())
        this.y.b();
      this.E = Boolean.valueOf(true);
    }
  }

  public final void w()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle("提示").setMessage(getString(2131492946)).setPositiveButton("确定", new ah(this));
    localBuilder.show();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJClassPlayerV3
 * JD-Core Version:    0.6.2
 */