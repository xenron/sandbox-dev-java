package hjapp.com.hjclass_mobile.view.ele;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import hjapp.com.hjclass_mobile.c.e;
import hjapp.com.hjclass_mobile.c.f;
import hjapp.com.hjclass_mobile.c.s;
import hjapp.com.hjclass_mobile.d.l;
import hjapp.com.hjclass_mobile.h.z;

import java.io.File;

public final class a extends RelativeLayout
  implements OnCompletionListener, OnSeekBarChangeListener, hjapp.com.hjclass_mobile.c.b, e, f
{
  private hjapp.com.hjclass_mobile.b.a a = null;
  private hjapp.com.hjclass_mobile.d.c b = null;
  private s c = null;
  private Button d = null;
  private Button e = null;
  private Animation f = null;
  private Animation g = null;
  private Boolean h = Boolean.valueOf(false);
  private Boolean i = Boolean.valueOf(false);
  private ab j = null;
  private TextView k = null;
  private SeekBar l = null;
  private LinearLayout m = null;
  private long n = 0L;
  private boolean o;
  private Handler p = new d(this);

  public a(Context paramContext, hjapp.com.hjclass_mobile.b.a parama)
  {
    super(paramContext);
    this.a = parama;
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903057, null);
    addView(localView);
    this.d = ((Button)localView.findViewById(2131361896));
    this.d.setOnClickListener(new b(this));
    this.e = ((Button)localView.findViewById(2131361897));
    this.e.setOnClickListener(new c(this));
    this.e.setVisibility(8);
    this.k = ((TextView)localView.findViewById(2131361899));
    this.k.setText("00:00");
    this.l = ((SeekBar)localView.findViewById(2131361898));
    this.l.setOnSeekBarChangeListener(this);
    this.l.setMax(1000);
    this.j = new ab(this);
    this.f = AnimationUtils.loadAnimation(paramContext, 2130968577);
    this.g = AnimationUtils.loadAnimation(paramContext, 2130968578);
    this.m = ((LinearLayout)localView.findViewById(2131361895));
  }

  public final void a()
  {
    h();
    removeAllViews();
    this.p = null;
  }

  public final void a(s params)
  {
    this.c = params;
  }

  public final void a(l paraml)
  {
    if (paraml.i() == null)
      return;
    this.b = paraml.i();
    int i1 = this.a.a(this.b.a());
    int i2 = this.a.b(this.b.b());
    LayoutParams localLayoutParams = new LayoutParams(-2, -2);
    localLayoutParams.leftMargin = i1;
    localLayoutParams.topMargin = i2;
    setLayoutParams(localLayoutParams);
    File localFile = new File(this.a.c() + File.separator + this.b.c());
    hjapp.com.hjclass_mobile.h.u.b("audio_url" + this.a.c() + File.separator + this.b.c());
    if (localFile.exists())
      this.j.a(localFile);
    while (true)
    {
      if (this.b.f())
        setVisibility(8);
      if (!this.b.g().endsWith("TYPE_SHORT"))
        break;
      this.e.setBackgroundResource(2130837538);
      this.d.setBackgroundResource(2130837540);
      this.k.setVisibility(8);
      this.l.setVisibility(8);
      this.m.setBackgroundDrawable(null);
      return;
      hjapp.com.hjclass_mobile.h.u.b("audio_url not exist=>>" + this.a.c() + File.separator + this.b.c());
    }
  }

  public final void b()
  {
    if (!this.h.booleanValue())
    {
      setVisibility(0);
      this.h = Boolean.valueOf(true);
      startAnimation(this.f);
    }
  }

  public final void c()
  {
    if (!this.i.booleanValue())
    {
      setVisibility(0);
      this.i = Boolean.valueOf(true);
      startAnimation(this.g);
    }
  }

  public final int d()
  {
    return this.b.d();
  }

  public final int e()
  {
    return this.b.e();
  }

  public final Boolean f()
  {
    return Boolean.valueOf(this.b.f());
  }

  public final void g()
  {
    if ((f().booleanValue()) && ((this.i.booleanValue()) || (this.h.booleanValue())))
    {
      setVisibility(8);
      this.i = Boolean.valueOf(false);
      this.h = Boolean.valueOf(false);
      this.j.e();
    }
  }

  public final void h()
  {
    if (this.j.a())
    {
      this.j.e();
      this.e.setVisibility(0);
      if (this.b != null)
        this.b.g().endsWith("TYPE_LONG");
      this.p.removeMessages(1000);
    }
    setVisibility(8);
  }

  public final void i()
  {
    setVisibility(0);
  }

  public final hjapp.com.hjclass_mobile.d.c j()
  {
    return this.b;
  }

  public final s k()
  {
    return this.c;
  }

  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.d.setVisibility(0);
    this.e.setVisibility(8);
  }

  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean);
    do
    {
      do
        return;
      while (this.j == null);
      this.n = (this.j.c() * paramInt / 1000L);
    }
    while (this.k == null);
    this.k.setText(z.a((int)this.n));
  }

  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.o = true;
    if (this.b != null)
      this.b.g().endsWith("TYPE_LONG");
    this.p.removeMessages(1000);
  }

  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.o = false;
    if (this.j != null)
      this.j.a((int)this.n);
    if (this.b != null)
      this.b.g().endsWith("TYPE_LONG");
    this.p.sendEmptyMessage(1000);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     a
 * JD-Core Version:    0.6.2
 */