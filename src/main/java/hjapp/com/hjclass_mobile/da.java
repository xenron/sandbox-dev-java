package hjapp.com.hjclass_mobile;

import android.view.View;
import android.view.View.OnClickListener;

final class da
  implements OnClickListener
{
  da(HJStudyCardActivity paramHJStudyCardActivity)
  {
  }

  public final void onClick(View paramView)
  {
    String str1 = HJStudyCardActivity.a(this.a).getText().toString().trim();
    if ((str1 != null) && (str1.length() == 15))
    {
      String str2 = str1.toString();
      HJStudyCardActivity.a(this.a, str2);
      HJStudyCardActivity.b(this.a);
      return;
    }
    h.z.a(this.a, 2131493135);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     da
 * JD-Core Version:    0.6.2
 */