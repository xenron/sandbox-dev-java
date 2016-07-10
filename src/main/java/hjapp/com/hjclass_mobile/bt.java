package hjapp.com.hjclass_mobile;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import hjapp.com.hjclass_mobile.pkg_d.t;

final class bt extends BaseAdapter
{
  private Context b = null;

  public bt(HJFreeLessonListActivity paramHJFreeLessonListActivity, Context paramContext)
  {
    this.b = paramContext;
  }

  public final int getCount()
  {
    return HJFreeLessonListActivity.c(this.a).size();
  }

  public final Object getItem(int paramInt)
  {
    return HJFreeLessonListActivity.c(this.a).get(paramInt);
  }

  public final long getItemId(int paramInt)
  {
    return paramInt;
  }

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    label138: t localt;
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130903091, null);
      HJFreeLessonListActivity.a(this.a, new bu(this.a, (byte)0));
      HJFreeLessonListActivity.i(this.a).a = ((TextView)paramView.findViewById(2131361886));
      HJFreeLessonListActivity.i(this.a).b = ((TextView)paramView.findViewById(2131361891));
      HJFreeLessonListActivity.i(this.a).c = ((TextView)paramView.findViewById(2131361842));
      HJFreeLessonListActivity.i(this.a).d = ((TextView)paramView.findViewById(2131361987));
      HJFreeLessonListActivity.i(this.a).e = paramView.findViewById(2131361986);
      paramView.setTag(HJFreeLessonListActivity.i(this.a));
      paramView.setBackgroundResource(2130837740);
      localt = (t)HJFreeLessonListActivity.c(this.a).get(paramInt);
      if (localt.s() <= 0)
        break label405;
      HJFreeLessonListActivity.i(this.a).e.setVisibility(0);
      if (localt.s() >= 60000)
        break label356;
      HJFreeLessonListActivity.i(this.a).d.setText(this.a.getString(2131493033));
    }
    while (true)
    {
      HJFreeLessonListActivity.i(this.a).a.setText(localt.g());
      HJFreeLessonListActivity.i(this.a).b.setText(this.a.getString(2131492911));
      HJFreeLessonListActivity.i(this.a).c.setText(this.a.getString(2131492937));
      HJFreeLessonListActivity.i(this.a).c.setTextColor(-39373);
      switch (localt.b())
      {
      default:
        return paramView;
        HJFreeLessonListActivity.a(this.a, (bu)paramView.getTag());
        break label138;
        label356: HJFreeLessonListActivity.i(this.a).d.setText(this.a.getString(2131493032) + h.z.b(localt.s()));
        continue;
        label405: HJFreeLessonListActivity.i(this.a).e.setVisibility(8);
      case 2:
      case 3:
      case 6:
      case 1:
      case 4:
      case 5:
      }
    }
    HJFreeLessonListActivity.i(this.a).b.setText(this.a.getString(2131492905));
    return paramView;
    HJFreeLessonListActivity.i(this.a).b.setText(this.a.getString(2131493031));
    paramView.setBackgroundResource(2130837739);
    return paramView;
    HJFreeLessonListActivity.i(this.a).b.setText(this.a.getString(2131492911));
    return paramView;
    HJFreeLessonListActivity.i(this.a).b.setText(this.a.getString(2131493030));
    return paramView;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     bt
 * JD-Core Version:    0.6.2
 */