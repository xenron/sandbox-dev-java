package hjapp.com.hjclass_mobile.view.ele;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import hjapp.com.hjclass_mobile.HJApplication;
import hjapp.com.hjclass_mobile.c.c;
import hjapp.com.hjclass_mobile.c.w;

public final class ai extends RelativeLayout
  implements c
{
  protected HJApplication a = null;
  private Boolean b = Boolean.valueOf(false);
  private boolean c = false;
  private Context d = null;
  private w e = null;

  public ai(Context paramContext, HJApplication paramHJApplication)
  {
    super(paramContext);
    this.a = paramHJApplication;
    setGravity(17);
    this.d = paramContext;
  }

  public final void a()
  {
    this.b = Boolean.valueOf(true);
  }

  public final void a(w paramw)
  {
    this.e = paramw;
  }

  public final void a(boolean paramBoolean)
  {
    if (this.b.booleanValue())
    {
      if (paramBoolean)
      {
        View localView2 = ((LayoutInflater)this.d.getSystemService("layout_inflater")).inflate(2130903069, null);
        TextView localTextView = (TextView)localView2.findViewById(2131361928);
        LinearLayout localLinearLayout2 = (LinearLayout)localView2.findViewById(2131361924);
        LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        localLayoutParams2.gravity = 17;
        localLinearLayout2.setLayoutParams(localLayoutParams2);
        addView(localView2);
        localTextView.setText("10");
      }
    }
    else
      return;
    View localView1 = ((LayoutInflater)this.d.getSystemService("layout_inflater")).inflate(2130903068, null);
    LinearLayout localLinearLayout1 = (LinearLayout)localView1.findViewById(2131361924);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams1.gravity = 17;
    ((TextView)localView1.findViewById(2131361930)).setVisibility(8);
    localLinearLayout1.setLayoutParams(localLayoutParams1);
    addView(localView1);
    ((Button)localView1.findViewById(2131361931)).setOnClickListener(new aj(this));
  }

  public final double b()
  {
    return -1.0D;
  }

  public final w c()
  {
    return this.e;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ai
 * JD-Core Version:    0.6.2
 */