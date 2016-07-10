package hjapp.com.hjclass_mobile;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

final class at extends BaseAdapter
{
  private Context b = null;

  public at(HJDemoClassActivity paramHJDemoClassActivity, Context paramContext)
  {
    this.b = paramContext;
  }

  public final int getCount()
  {
    return HJDemoClassActivity.a(this.a).size();
  }

  public final Object getItem(int paramInt)
  {
    return HJDemoClassActivity.a(this.a).get(paramInt);
  }

  public final long getItemId(int paramInt)
  {
    return paramInt;
  }

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130903091, null);
      HJDemoClassActivity.a(this.a, new au(this.a, (byte)0));
      HJDemoClassActivity.b(this.a).a = ((TextView)paramView.findViewById(2131361886));
      HJDemoClassActivity.b(this.a).b = ((TextView)paramView.findViewById(2131361891));
      HJDemoClassActivity.b(this.a).c = ((TextView)paramView.findViewById(2131361842));
      paramView.setTag(HJDemoClassActivity.b(this.a));
    }
    while (true)
    {
      paramView.setBackgroundResource(2130837740);
      pkg_d.t localt = (pkg_d.t)HJDemoClassActivity.a(this.a).get(paramInt);
      HJDemoClassActivity.b(this.a).a.setText(localt.g());
      HJDemoClassActivity.b(this.a).b.setText(this.a.getString(2131492911));
      HJDemoClassActivity.b(this.a).c.setText(this.a.getString(2131492937));
      HJDemoClassActivity.b(this.a).c.setTextColor(-39373);
      switch (localt.b())
      {
      default:
        return paramView;
        HJDemoClassActivity.a(this.a, (au)paramView.getTag());
      case 2:
      case 3:
      case 6:
      case 1:
      case 4:
      case 5:
      }
    }
    HJDemoClassActivity.b(this.a).b.setText(this.a.getString(2131492905));
    return paramView;
    HJDemoClassActivity.b(this.a).b.setText(this.a.getString(2131493031));
    paramView.setBackgroundResource(2130837739);
    return paramView;
    HJDemoClassActivity.b(this.a).b.setText(this.a.getString(2131492911));
    return paramView;
    HJDemoClassActivity.b(this.a).b.setText(this.a.getString(2131493030));
    return paramView;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     at
 * JD-Core Version:    0.6.2
 */