package hjapp.com.hjclass_mobile.view.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

final class c extends ArrayAdapter
{
  c(b paramb, Context paramContext, CharSequence[] paramArrayOfCharSequence, HuzAlertController.RecycleListView paramRecycleListView)
  {
    super(paramContext, 2130903087, 16908308, paramArrayOfCharSequence);
  }

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.getView(paramInt, paramView, paramViewGroup);
    if ((this.b.z != null) && (this.b.z[paramInt] != 0))
      this.a.setItemChecked(paramInt, true);
    return localView;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     c
 * JD-Core Version:    0.6.2
 */