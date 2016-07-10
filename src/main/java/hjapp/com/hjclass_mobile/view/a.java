package hjapp.com.hjclass_mobile.view;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
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
import hjapp.com.hjclass_mobile.pkg_c.g;
import hjapp.com.hjclass_mobile.pkg_h.z;

public final class a extends LinearLayout
  implements OnClickListener, OnTouchListener, OnSeekBarChangeListener
{
  public TextView a;
  public TextView b;
  public Button c;
  public SeekBar d = null;
  private View e;
  private g f;
  private Context g;
  private boolean h;
  private Button i;
  private Button j;
  private Button k;
  private Button l;
  private boolean m;
  private DisplayMetrics n;
  private c o = null;
  private Handler p = new b(this);
  private long q = 0L;

  public a(Context paramContext)
  {
    super(paramContext);
    this.g = paramContext;
    removeAllViews();
    this.n = new DisplayMetrics();
    ((WindowManager)this.g.getSystemService("window")).getDefaultDisplay().getMetrics(this.n);
    LayoutParams localLayoutParams = new LayoutParams(-1, 150);
    setLayoutParams(localLayoutParams);
    View localView = ((LayoutInflater)this.g.getSystemService("layout_inflater")).inflate(2130903095, null);
    this.e = localView;
    this.b = ((TextView)localView.findViewById(2131361899));
    this.a = ((TextView)localView.findViewById(2131362002));
    this.c = ((Button)localView.findViewById(2131361999));
    this.c.setOnClickListener(this);
    this.c.requestFocus();
    this.j = ((Button)localView.findViewById(2131362000));
    this.i = ((Button)localView.findViewById(2131361998));
    this.k = ((Button)localView.findViewById(2131361997));
    this.l = ((Button)localView.findViewById(2131362001));
    this.l.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.d = ((SeekBar)localView.findViewById(2131362003));
    this.d.setOnSeekBarChangeListener(this);
    this.d.setMax(1000);
    addView(this.e, localLayoutParams);
    setVisibility(8);
    setOnTouchListener(this);
    setFocusable(true);
    setFocusableInTouchMode(true);
    setDescendantFocusability(262144);
    requestFocus();
    if (this.o == null)
    {
      this.o = new c(this, (byte)0);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("zoom_in_enabled");
      localIntentFilter.addAction("zoom_out_enabled");
      localIntentFilter.addAction("zoom_show_toggle");
      this.g.registerReceiver(this.o, localIntentFilter);
    }
  }

  private int e()
  {
    int i1;
    if ((this.f == null) || (this.m))
      i1 = 0;
    do
    {
      return i1;
      i1 = this.f.b();
      int i2 = this.f.c();
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

  private void f()
  {
    if (this.e == null);
    do
    {
      return;
      if (this.c == null)
        this.c = ((Button)this.e.findViewById(2131361999));
    }
    while (this.c == null);
    if ((this.f != null) && (this.f.d()))
    {
      this.c.setBackgroundResource(2130837710);
      return;
    }
    this.c.setBackgroundResource(2130837714);
  }

  public final void a(int paramInt)
  {
    if ((!this.h) && (this.f != null))
    {
      e();
      setVisibility(0);
      this.h = true;
    }
    f();
    this.p.sendEmptyMessage(2);
    Message localMessage = this.p.obtainMessage(1);
    if (paramInt != 0)
    {
      this.p.removeMessages(1);
      this.p.sendMessageDelayed(localMessage, paramInt);
    }
  }

  public final void a(g paramg)
  {
    this.f = paramg;
    f();
    this.p.sendEmptyMessage(3);
  }

  public final boolean a()
  {
    return this.h;
  }

  public final void b()
  {
    if (this.h);
    try
    {
      this.p.removeMessages(2);
      setVisibility(8);
      label21: this.h = false;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label21;
    }
  }

  public final void c()
  {
    if ((this.f != null) && (this.f.d()))
    {
      this.f.e();
      this.p.removeMessages(3);
    }
    while (true)
    {
      f();
      return;
      if (this.f != null)
        this.f.f();
      this.p.sendEmptyMessage(3);
    }
  }

  public final void d()
  {
    if (this.o != null)
      this.g.unregisterReceiver(this.o);
  }

  public final void onClick(View paramView)
  {
    a(3000);
    switch (paramView.getId())
    {
    default:
    case 2131361999:
    case 2131361998:
    case 2131362000:
    case 2131361997:
    case 2131362001:
    }
    do
    {
      do
      {
        return;
        c();
        a(3000);
        return;
        if (this.f != null)
          this.f.a(this.f.j());
        a(3000);
        return;
        if (this.f != null)
          this.f.a(this.f.i());
        a(3000);
        return;
      }
      while (this.f == null);
      this.f.k();
      return;
    }
    while (this.f == null);
    this.f.l();
  }

  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean);
    do
    {
      do
        return;
      while (this.f == null);
      this.q = (this.f.c() * paramInt / 1000L);
    }
    while (this.a == null);
    this.a.setText(z.a((int)this.q));
  }

  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    a(360000);
    this.m = true;
    this.p.removeMessages(2);
    this.p.removeMessages(3);
  }

  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.m = false;
    f();
    this.f.a((int)this.q);
    a(3000);
    this.p.sendEmptyMessage(2);
    this.p.sendEmptyMessage(3);
  }

  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (this.h))
      b();
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
 * Qualified Name:     a
 * JD-Core Version:    0.6.2
 */