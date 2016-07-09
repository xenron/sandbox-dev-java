package hjapp.com.hjclass_mobile.view.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class e
  implements OnItemClickListener
{
  e(b paramb, HuzAlertController paramHuzAlertController)
  {
  }

  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.b.s.onClick(HuzAlertController.g(this.a), paramInt);
    if (!this.b.B)
      HuzAlertController.g(this.a).dismiss();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     e
 * JD-Core Version:    0.6.2
 */