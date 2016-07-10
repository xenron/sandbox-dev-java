package hjapp.com.hjclass_mobile.view;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import hjapp.com.hjclass_mobile.HJApplication;
import hjapp.com.hjclass_mobile.pkg_d.aa;
import hjapp.com.hjclass_mobile.pkg_h.z;

import java.util.List;

public final class d extends LinearLayout
  implements OnClickListener, OnTouchListener, OnSeekBarChangeListener
{
  public TextView a;
  public TextView b;
  public Button c;
  public SeekBar d = null;
  private long e = 0L;
  private View f;
  private hjapp.com.hjclass_mobile.pkg_c.g g;
  private Context h;
  private boolean i;
  private Button j;
  private Button k;
  private boolean l;
  private DisplayMetrics m;
  private int n = 0;
  private boolean o = false;
  private i p = null;
  private boolean q = false;
  private Handler r = new Handler();
  private Runnable s = new e(this);
  private Handler t = new f(this);
  private long u = 0L;

  public d(Context paramContext)
  {
    super(paramContext);
    u.b("init MediaControllerV3");
    this.h = paramContext;
    removeAllViews();
    this.m = new DisplayMetrics();
    ((WindowManager)this.h.getSystemService("window")).getDefaultDisplay().getMetrics(this.m);
    LayoutParams localLayoutParams = new LayoutParams(-1, -2);
    setLayoutParams(localLayoutParams);
    View localView = ((LayoutInflater)this.h.getSystemService("layout_inflater")).inflate(2130903096, null);
    this.f = localView;
    this.b = ((TextView)localView.findViewById(2131361899));
    this.a = ((TextView)localView.findViewById(2131362002));
    this.c = ((Button)localView.findViewById(2131361999));
    this.c.setOnClickListener(this);
    this.c.requestFocus();
    this.k = ((Button)localView.findViewById(2131362000));
    this.j = ((Button)localView.findViewById(2131361998));
    this.k.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.d = ((SeekBar)localView.findViewById(2131362003));
    this.d.setOnSeekBarChangeListener(this);
    this.d.setMax(1000);
    addView(this.f, localLayoutParams);
    setVisibility(8);
    setOnTouchListener(this);
    setFocusable(true);
    setFocusableInTouchMode(true);
    setDescendantFocusability(262144);
    requestFocus();
    if (this.p == null)
    {
      this.p = new i(this, (byte)0);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("pause_cmd");
      localIntentFilter.addAction("play_cmd");
      localIntentFilter.addAction("seek_cmd");
      localIntentFilter.addAction("show_cmd");
      this.h.registerReceiver(this.p, localIntentFilter);
    }
  }

  private int h()
  {
    int i1;
    if ((this.g == null) || (this.l))
      i1 = 0;
    do
    {
      return i1;
      i1 = this.g.b();
      int i2 = this.g.c();
      if (this.d != null)
      {
        if (i2 > 0)
        {
          long l1 = 1000L * i1 / i2;
          this.d.setProgress((int)l1);
        }
        this.d.setSecondaryProgress(1000);
      }
      if (this.b != null)
        this.b.setText(z.a(i2));
    }
    while (this.a == null);
    this.a.setText(z.a(i1));
    return i1;
  }

  private void i()
  {
    if (this.f == null);
    do
    {
      return;
      if (this.c == null)
        this.c = ((Button)this.f.findViewById(2131361999));
    }
    while (this.c == null);
    if ((this.g != null) && (this.g.d()))
    {
      this.c.setBackgroundResource(2130837711);
      return;
    }
    this.c.setBackgroundResource(2130837715);
  }

  public final void a()
  {
    this.t.removeMessages(2);
    this.r.removeCallbacks(this.s);
    this.t.removeMessages(1);
    removeAllViews();
    if (this.p != null)
    {
      Log.i("=========", "删除广播!!!");
      this.h.unregisterReceiver(this.p);
    }
  }

  public final void a(int paramInt)
  {
    if ((!this.i) && (this.g != null))
    {
      h();
      setVisibility(0);
      this.g.o();
      this.i = true;
    }
    i();
    this.t.sendEmptyMessage(2);
    Message localMessage = this.t.obtainMessage(1);
    if (paramInt != 0)
    {
      this.t.removeMessages(1);
      this.t.sendMessageDelayed(localMessage, paramInt);
    }
  }

  public final void a(hjapp.com.hjclass_mobile.pkg_c.g paramg)
  {
    this.g = paramg;
    i();
    this.r.post(this.s);
  }

  public final void b(int paramInt)
  {
    if (this.g != null)
      this.g.a(paramInt);
  }

  public final boolean b()
  {
    return this.i;
  }

  public final void c()
  {
    if (this.i);
    try
    {
      this.t.removeMessages(2);
      setVisibility(8);
      this.g.n();
      label30: this.i = false;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label30;
    }
  }

  public final void d()
  {
    if ((this.g != null) && (this.g.d()))
    {
      this.g.e();
      this.o = true;
      this.r.removeCallbacks(this.s);
    }
    while (true)
    {
      i();
      return;
      if (this.g != null)
      {
        this.g.f();
        this.o = false;
      }
      this.r.post(this.s);
    }
  }

  public final void e()
  {
    if ((this.g != null) && (this.g.d()))
      this.g.e();
    this.o = true;
    this.r.removeCallbacks(this.s);
    if (this.f == null);
    do
    {
      return;
      if (this.c == null)
        this.c = ((Button)this.f.findViewById(2131361999));
    }
    while (this.c == null);
    this.c.setBackgroundResource(2130837715);
  }

  public final void f()
  {
    if (this.g != null)
      this.g.f();
    this.o = false;
    this.r.postDelayed(this.s, 2000L);
    if (this.f == null);
    do
    {
      return;
      if (this.c == null)
        this.c = ((Button)this.f.findViewById(2131361999));
    }
    while (this.c == null);
    this.c.setBackgroundResource(2130837711);
  }

  public final boolean g()
  {
    return this.o;
  }

  public final void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
    case 2131361999:
    case 2131361998:
    case 2131362000:
    }
    while (true)
    {
      a(3000);
      return;
      if ((this.g == null) || (this.g.r()))
      {
        this.q = false;
        d();
        continue;
        if (this.g != null)
        {
          this.o = true;
          this.g.q();
          continue;
          if (this.g != null)
          {
            this.o = true;
            u.b("<<<<<<<<<<<<<next page>>>>>>>>>>>>>>>>");
            this.g.p();
          }
        }
      }
    }
  }

  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean);
    do
    {
      do
        return;
      while (this.g == null);
      long l1 = this.g.c();
      this.u = (l1 * paramInt / 1000L);
      u.c("seek", "总时长=" + l1 + ",当前时间点=" + this.u);
    }
    while (this.a == null);
    this.a.setText(z.a((int)this.u));
  }

  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    a(360000);
    this.l = true;
    this.t.removeMessages(2);
    this.r.removeCallbacks(this.s);
  }

  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i1 = 0;
    this.l = false;
    long l1 = this.u;
    List localList = ((HJApplication)getContext().getApplicationContext()).e();
    float f1 = (float)(l1 / 1000L);
    if (localList != null)
    {
      int i3 = localList.size();
      if (i1 < i3)
      {
        aa localaa = (aa)localList.get(i1);
        if ((f1 >= localaa.a()) && (!localaa.b()))
        {
          this.n = localaa.a();
          u.b("aaaaaaaa=" + this.n + ">>>>" + this.u);
          if (this.u >= this.n)
            this.u = this.n;
        }
      }
    }
    for (int i2 = i1; ; i2 = -1)
    {
      if (i2 >= 0)
        break label287;
      i();
      this.g.a((int)this.u);
      a(3000);
      this.t.sendEmptyMessage(2);
      if ((this.o) || (!this.q))
      {
        this.e = this.g.b();
        this.g.b(this.g.b() / 1000);
        this.r.postDelayed(this.s, 1000L);
      }
      this.r.post(this.s);
      return;
      i1++;
      break;
    }
    label287: e();
    hjapp.com.hjclass_mobile.view.widget.j localj = new hjapp.com.hjclass_mobile.view.widget.j(getContext());
    localj.a(getContext().getString(2131493160));
    localj.a(getContext().getString(2131493158), new g(this));
    localj.b(getContext().getString(2131493159), new h(this));
    localj.create().show();
  }

  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (this.i))
      c();
    return false;
  }

  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    a(3000);
    return true;
  }

  public final boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    a(3000);
    return false;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     d
 * JD-Core Version:    0.6.2
 */