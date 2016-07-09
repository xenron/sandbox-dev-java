package hjapp.com.hjclass_mobile;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class bo
  implements OnItemClickListener
{
  bo(HJFreeLessonListActivity paramHJFreeLessonListActivity)
  {
  }

  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    HJFreeLessonListActivity.a(this.a, paramInt);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     bo
 * JD-Core Version:    0.6.2
 */