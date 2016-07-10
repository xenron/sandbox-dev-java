package hjapp.com.hjclass_mobile.pkg_b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import hjapp.com.hjclass_mobile.pkg_d.t;

import java.util.List;

public final class q extends BaseAdapter
{
  public List a;
  private Context b = null;
  private r c = null;
  private boolean d = false;

  public q(Context paramContext)
  {
    this.b = paramContext;
  }

  public final void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }

  public final int getCount()
  {
    return this.a.size();
  }

  public final Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }

  public final long getItemId(int paramInt)
  {
    return paramInt;
  }

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    label129: t localt;
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130903091, null);
      this.c = new r(this, (byte)0);
      this.c.a = ((TextView)paramView.findViewById(2131361886));
      this.c.b = ((TextView)paramView.findViewById(2131361891));
      this.c.c = ((TextView)paramView.findViewById(2131361842));
      this.c.d = ((ImageView)paramView.findViewById(2131361893));
      this.c.e = ((TextView)paramView.findViewById(2131361987));
      this.c.f = paramView.findViewById(2131361986);
      paramView.setTag(this.c);
      paramView.setBackgroundResource(2130837740);
      localt = (t)this.a.get(paramInt);
      if (localt.s() <= 0)
        break label378;
      this.c.f.setVisibility(0);
      if (localt.s() >= 60000)
        break label332;
      this.c.e.setText(this.b.getString(2131493033));
      label198: this.c.a.setText(localt.g());
      this.c.b.setText(this.b.getString(2131492911));
      if (localt.j() <= 0)
        break label393;
      this.c.d.setBackgroundResource(2130837525);
      this.c.c.setText(this.b.getString(2131492926));
    }
    while (true)
      switch (localt.b())
      {
      default:
        return paramView;
        this.c = ((r)paramView.getTag());
        break label129;
        label332: this.c.e.setText(this.b.getString(2131493032) + hjapp.com.hjclass_mobile.pkg_h.z.b(localt.s()));
        break label198;
        label378: this.c.f.setVisibility(8);
        break label198;
        label393: this.c.c.setText(this.b.getString(2131492925));
        if ((this.d) && (localt.t()))
          this.c.d.setBackgroundResource(2130837742);
        break;
      case 2:
      case 3:
      case 6:
      case 1:
      case 4:
      case 5:
      }
    this.c.b.setText(this.b.getString(2131492905));
    return paramView;
    this.c.b.setText(this.b.getString(2131493031));
    paramView.setBackgroundResource(2130837739);
    return paramView;
    this.c.b.setText(this.b.getString(2131492911));
    return paramView;
    this.c.b.setText(this.b.getString(2131493030));
    return paramView;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     q
 * JD-Core Version:    0.6.2
 */