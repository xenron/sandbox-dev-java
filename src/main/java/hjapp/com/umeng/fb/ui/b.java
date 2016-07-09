package hjapp.com.umeng.fb.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class b extends BaseAdapter
{
  Context a;
  LayoutInflater b;
  String c;
  String d = "FeedbackAdapter";
  hjapp.com.umeng.fb.b e;

  public b(Context paramContext, hjapp.com.umeng.fb.b paramb)
  {
    this.a = paramContext;
    this.e = paramb;
    this.b = LayoutInflater.from(paramContext);
  }

  private void a(hjapp.com.umeng.fb.a parama, TextView paramTextView)
  {
    String str;
    switch (b.1.a[parama.g.ordinal()])
    {
    default:
      str = hjapp.com.umeng.fb.util.a.b(parama.e, this.a);
      if ("".equals(str))
      {
        paramTextView.setText("");
        return;
      }
      break;
    case 1:
      paramTextView.setText(this.a.getString(e.t(this.a)));
      paramTextView.setTextColor(-7829368);
      return;
    case 2:
      paramTextView.setText(this.a.getString(e.u(this.a)));
      paramTextView.setTextColor(-65536);
      return;
    case 3:
      paramTextView.setText(this.a.getString(e.v(this.a)));
      paramTextView.setTextColor(-65536);
      return;
    }
    paramTextView.setText(str);
    paramTextView.setTextColor(-7829368);
  }

  public void a(hjapp.com.umeng.fb.b paramb)
  {
    this.e = paramb;
  }

  public int getCount()
  {
    if (this.e == null)
      return 0;
    return this.e.f.size();
  }

  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    b.a locala2;
    if (paramView == null)
    {
      paramView = this.b.inflate(d.e(this.a), null);
      locala2 = new b.a(this);
      locala2.a = ((LinearLayout)paramView.findViewById(c.p(this.a)));
      locala2.b = ((RelativeLayout)locala2.a.findViewById(c.q(this.a)));
      locala2.c = ((TextView)locala2.a.findViewById(c.r(this.a)));
      locala2.d = ((TextView)locala2.a.findViewById(c.s(this.a)));
      locala2.e = paramView.findViewById(c.t(this.a));
      locala2.f = paramView.findViewById(c.u(this.a));
      paramView.setTag(locala2);
    }
    for (b.a locala1 = locala2; ; locala1 = (b.a)paramView.getTag())
    {
      hjapp.com.umeng.fb.a locala = this.e.a(paramInt);
      a(locala, locala1.d);
      locala1.c.setText(locala.a());
      if (locala.f != a.b.c)
        break;
      locala1.a.setGravity(5);
      locala1.b.setBackgroundResource(hjapp.com.umeng.fb.b.b.b(this.a));
      locala1.f.setVisibility(8);
      locala1.e.setVisibility(0);
      return paramView;
    }
    locala1.a.setGravity(3);
    locala1.b.setBackgroundResource(hjapp.com.umeng.fb.b.b.c(this.a));
    locala1.f.setVisibility(0);
    locala1.e.setVisibility(8);
    return paramView;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     b
 * JD-Core Version:    0.6.2
 */