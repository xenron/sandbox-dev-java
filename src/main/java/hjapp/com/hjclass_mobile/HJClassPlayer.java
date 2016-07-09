package hjapp.com.hjclass_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import hjapp.com.hjclass_mobile.g.h;
import hjapp.com.hjclass_mobile.view.FlipperImagePlayer;
import hjapp.com.hjclass_mobile.view.a;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class HJClassPlayer extends BaseActivity
  implements OnClickListener, hjapp.com.hjclass_mobile.b.t, hjapp.com.hjclass_mobile.c.g, hjapp.com.hjclass_mobile.g.n
{
  private static long h = 0L;
  private static long i = 0L;
  private hjapp.com.hjclass_mobile.g.g a = null;
  private hjapp.com.hjclass_mobile.view.a b;
  private FlipperImagePlayer c;
  private hjapp.com.hjclass_mobile.b.s d;
  private LinearLayout e = null;
  private TextView f = null;
  private boolean g = false;
  private hjapp.com.hjclass_mobile.b.b j = null;
  private hjapp.com.hjclass_mobile.d.t k = null;
  private long l = 0L;
  private RelativeLayout m = null;
  private TextView n = null;
  private Button o = null;
  private boolean p;
  private long q;
  private boolean r;
  private boolean s = false;
  private final Handler t = new Handler();
  private Runnable u = new x(this);

  private void s()
  {
    if (this.m != null)
      this.m.setVisibility(8);
  }

  private void t()
  {
    if (this.m != null)
      this.m.setVisibility(0);
    this.t.removeCallbacks(this.u);
    this.t.postDelayed(this.u, 3000L);
  }

  public final void a(int paramInt)
  {
    if (this.a != null)
      this.a.a(paramInt);
  }

  public final void a(long paramLong)
  {
    if (this.a != null)
    {
      int i1 = (int)(100.0D * (paramLong / 1000.0D / (this.a.i() / 1000L)));
      this.f.setText(i1 + "%");
    }
  }

  public final void a(hjapp.com.hjclass_mobile.d.b paramb)
  {
    if (paramb == null)
    {
      Toast.makeText(this, getString(2131493029), 1).show();
      return;
    }
    this.n.setText(paramb.a());
    this.c = ((FlipperImagePlayer)findViewById(2131362020));
    this.c.a(paramb.d());
    int i1 = this.k.a();
    int i2 = this.k.d();
    int i3 = this.j.g(i1, i2, this.k.c());
    this.k.j(i3);
    this.c.a(hjapp.com.hjclass_mobile.h.z.c + i1 + File.separator + i2 + File.separator + this.k.c());
    this.b = new a(this);
    ((LinearLayout)findViewById(2131361902)).addView(this.b);
    this.a = new h(hjapp.com.hjclass_mobile.h.z.c + File.separator + i1 + File.separator + i2 + File.separator + this.k.c() + File.separator + paramb.b(), this);
    try
    {
      this.a.h();
      getWindow().addFlags(128);
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
  }

  public final int b()
  {
    if (this.a != null)
      return this.a.d();
    return 0;
  }

  public final void b(int paramInt)
  {
    this.c.a(paramInt);
  }

  public final void b(hjapp.com.hjclass_mobile.d.b paramb)
  {
  }

  public final int c()
  {
    if (this.a != null)
      return this.a.b();
    return 0;
  }

  public final boolean d()
  {
    if (this.a != null)
      return this.a.a();
    return false;
  }

  public final void e()
  {
    if (this.a != null)
    {
      this.a.e();
      long l1 = new Date().getTime();
      i = l1;
      this.l = (l1 - h + this.l);
    }
  }

  public final void f()
  {
    if (this.a != null)
      h = new Date().getTime();
    this.a.f();
  }

  public final void g()
  {
    this.r = true;
    this.c.setBackgroundResource(2130837857);
    int i1 = this.k.s();
    if (i1 > 0)
      this.a.a(i1);
    h = new Date().getTime();
    this.e.setVisibility(8);
    this.b.a(this);
    this.b.a(3000);
    t();
  }

  public final void h()
  {
    e();
    a(0);
    long l1 = new Date().getTime();
    i = l1;
    long l2 = l1 - h + this.l;
    this.k.j((int)(l2 / 1000L));
    this.p = true;
    this.q = this.k.u();
    if ((this.q >= 180L) && (this.k.d() > 1))
    {
      if ((this.k == null) || (this.s) || (this.k.j() == 0));
      try
      {
        int i2 = this.j.e(this.k.d(), this.k.a());
        if (i2 > 0)
        {
          this.j.d(i2, this.k.a(), this.k.d());
          Intent localIntent = new Intent("open_next_lesson");
          localIntent.putExtra("currentLessonID", this.k.c());
          localIntent.putExtra("nextLessonID", i2);
          sendBroadcast(localIntent);
          this.s = true;
          Log.i("===", "开启下一单元成功");
        }
        while (true)
        {
          label222: this.k.g(1);
          this.k.f(100);
          this.k.i(0);
          this.j.c(this.k);
          int i1 = this.j.f(c.b(), this.k.d());
          hjapp.com.hjclass_mobile.b.b localb = this.j;
          this.k.d();
          localb.g(i1, c.b());
          if (hjapp.com.hjclass_mobile.h.z.h)
          {
            hjapp.com.hjclass_mobile.d.x localx = new d.x();
            localx.a(this.k.d());
            localx.b(this.k.c());
            localx.a(this.q);
            hjapp.com.hjclass_mobile.f.a.a(c.a(), localx, 3);
          }
          String str = getString(2131493046);
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = this.q;
          Toast.makeText(this, hjapp.com.hjclass_mobile.h.y.a(str, arrayOfObject), 0).show();
          return;
          Log.i("===", "开启下一单元失败");
        }
      }
      catch (Exception localException)
      {
        break label222;
      }
    }
    Toast.makeText(this, getString(2131493168), 1).show();
  }

  public final int i()
  {
    return 1000 * this.c.d();
  }

  public final int j()
  {
    return 1000 * this.c.e();
  }

  public final void k()
  {
    this.c.b();
  }

  public final void l()
  {
    this.c.c();
  }

  public final void m()
  {
    if ((this.a != null) && (this.b != null))
    {
      if (this.b.a())
      {
        this.b.b();
        s();
      }
    }
    else
      return;
    this.b.a(3000);
    t();
  }

  public final void n()
  {
  }

  public final void o()
  {
  }

  public void onClick(View paramView)
  {
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(4096);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    y localy = new y(this);
    ((TelephonyManager)getSystemService("phone")).listen(localy, 32);
    setContentView(2130903105);
    hjapp.com.hjclass_mobile.h.z.a(this);
    this.e = ((LinearLayout)findViewById(2131362021));
    this.m = ((RelativeLayout)findViewById(2131362023));
    this.n = ((TextView)findViewById(2131362025));
    this.n.requestFocus();
    this.o = ((Button)findViewById(2131362024));
    this.o.setOnClickListener(this);
    Bundle localBundle = getIntent().getExtras();
    this.f = ((TextView)findViewById(2131362022));
    this.f.setText("0%");
    this.j = new b.b(this);
    int i1;
    if (localBundle != null)
    {
      String str = localBundle.getString("filePath");
      this.k = ((hjapp.com.hjclass_mobile.d.t)localBundle.getSerializable("lesson"));
      if (new File(str).exists())
      {
        this.d = new b.s(this);
        this.d.execute(new String[] { str, "false" });
        i1 = HJSettingActivity.b(this);
        if (i1 != 1)
          break label329;
        setRequestedOrientation(0);
      }
    }
    label329: 
    do
    {
      return;
      Toast.makeText(this, getString(2131493002), 0).show();
      finish();
      break;
      Toast.makeText(this, getString(2131493001), 0).show();
      finish();
      break;
      if (i1 == 2)
      {
        setRequestedOrientation(1);
        return;
      }
    }
    while (i1 != 3);
    setRequestedOrientation(2);
  }

  protected void onDestroy()
  {
    hjapp.com.hjclass_mobile.h.z.b(this);
    super.onDestroy();
    if (this.b != null)
      this.b.d();
    if ((this.r) && (this.k != null))
    {
      this.k.i(this.a.d());
      if (this.j != null)
        this.j.b(this.k);
    }
    if ((this.d != null) && (this.d.getStatus() == AsyncTask.Status.RUNNING))
      this.d.cancel(true);
    if (this.a != null)
    {
      if (!this.r)
      {
        this.a.j();
        this.a.g();
      }
      this.a.c();
    }
  }

  protected void onPause()
  {
    super.onPause();
    if (this.b != null)
      this.b.c();
    if (this.a != null)
      this.a.e();
  }

  protected void onRestart()
  {
    if (this.b != null)
      this.b.a(3000);
    t();
    super.onRestart();
  }

  public final void p()
  {
  }

  public final void q()
  {
  }

  public final boolean r()
  {
    return true;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJClassPlayer
 * JD-Core Version:    0.6.2
 */