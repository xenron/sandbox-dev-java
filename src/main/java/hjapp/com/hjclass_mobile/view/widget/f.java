package hjapp.com.hjclass_mobile.view.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class f
  implements OnItemClickListener
{
  f(b paramb, HuzAlertController.RecycleListView paramRecycleListView, HuzAlertController paramHuzAlertController)
  {
  }

  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.c.z != null)
      this.c.z[paramInt] = this.a.isItemChecked(paramInt);
    this.c.D.onClick(HuzAlertController.g(this.b), paramInt, this.a.isItemChecked(paramInt));
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     f
 * JD-Core Version:    0.6.2
 */