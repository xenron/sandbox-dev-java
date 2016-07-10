package hjapp.com.hjclass_mobile.view.ele;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import hjapp.com.hjclass_mobile.HJApplication;
import hjapp.com.hjclass_mobile.pkg_c.w;

public final class ag extends RelativeLayout
  implements hjapp.com.hjclass_mobile.pkg_c.c
{
  private Context a;
  private String b;
  private String c;
  private HJApplication d = null;
  private Boolean e = Boolean.valueOf(false);
  private Boolean f = Boolean.valueOf(false);
  private double g = 0.0D;
  private TextView h;
  private TextView i;
  private TextView j;
  private hjapp.com.hjclass_mobile.pkg_c.w k = null;

  public ag(Context paramContext, HJApplication paramHJApplication)
  {
    super(paramContext);
    this.d = paramHJApplication;
    this.a = paramContext;
  }

  public final void a()
  {
    if (this.e.booleanValue())
      return;
    if (HJApplication.g() > 0)
    {
      float f1 = HJApplication.h();
      float f2 = f1 / HJApplication.i();
      double d1 = 100.0F * f2;
      this.g = f2;
      this.c = ((int)Math.floor(d1) + "%");
      this.b = String.valueOf((int)(f2 * 10.0F));
    }
    this.e = Boolean.valueOf(true);
  }

  public final void a(hjapp.com.hjclass_mobile.pkg_c.w paramw)
  {
    this.k = paramw;
  }

  public final void a(boolean paramBoolean)
  {
    if (this.e.booleanValue())
    {
      if (paramBoolean)
      {
        View localView2 = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2130903067, null);
        this.h = ((TextView)localView2.findViewById(2131361927));
        this.i = ((TextView)localView2.findViewById(2131361928));
        this.j = ((TextView)localView2.findViewById(2131361929));
        LinearLayout localLinearLayout2 = (LinearLayout)localView2.findViewById(2131361924);
        LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        localLayoutParams2.gravity = 17;
        localLinearLayout2.setLayoutParams(localLayoutParams2);
        addView(localView2);
        this.i.setText(this.b);
        this.h.setText(this.c);
        TextView localTextView = this.j;
        String str = this.a.getText(2131493166).toString();
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = String.valueOf(HJApplication.g());
        int m = HJApplication.g();
        arrayOfObject[1] = String.valueOf(m - HJApplication.f());
        localTextView.setText(hjapp.com.hjclass_mobile.pkg_h.y.a(str, arrayOfObject));
      }
    }
    else
      return;
    View localView1 = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2130903068, null);
    LinearLayout localLinearLayout1 = (LinearLayout)localView1.findViewById(2131361924);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams1.gravity = 17;
    localLinearLayout1.setLayoutParams(localLayoutParams1);
    addView(localView1);
    ((Button)localView1.findViewById(2131361931)).setOnClickListener(new ah(this));
  }

  public final double b()
  {
    return this.g;
  }

  public final w c()
  {
    return this.k;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ag
 * JD-Core Version:    0.6.2
 */