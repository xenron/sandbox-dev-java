package hjapp.com.hjclass_mobile;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.List;

final class t
  implements OnItemClickListener
{
  t(HJClassListActivity paramHJClassListActivity)
  {
  }

  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = HJClassListActivity.k(this.a).a().size();
    List localList = HJClassListActivity.k(this.a).a();
    int j = 0;
    if (j < i)
    {
      if (paramInt == j)
      {
        ((pkg_d.a)localList.get(j)).a(true);
        HJClassListActivity.a(this.a, ((pkg_d.a)localList.get(j)).a());
        HJClassListActivity.l(this.a).setText(((pkg_d.a)localList.get(j)).b());
      }
      while (true)
      {
        j++;
        break;
        ((pkg_d.a)localList.get(j)).a(false);
      }
    }
    HJClassListActivity.k(this.a).a(localList);
    HJClassListActivity.k(this.a).b();
    HJClassListActivity.k(this.a).c();
    HJClassListActivity.b(this.a, HJClassListActivity.m(this.a));
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     t
 * JD-Core Version:    0.6.2
 */