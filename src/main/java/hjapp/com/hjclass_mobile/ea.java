package hjapp.com.hjclass_mobile;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import java.io.PrintStream;

final class ea
  implements OnItemSelectedListener
{
  public final void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    String str = paramAdapterView.getItemAtPosition(paramInt).toString();
    System.out.println(str);
  }

  public final void onNothingSelected(AdapterView paramAdapterView)
  {
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ea
 * JD-Core Version:    0.6.2
 */