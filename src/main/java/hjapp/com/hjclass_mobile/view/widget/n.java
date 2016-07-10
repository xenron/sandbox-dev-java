package hjapp.com.hjclass_mobile.view.widget;

import android.app.Dialog;
import android.content.Context;

public final class n
  implements hjapp.com.hjclass_mobile.pkg_c.d
{
  private Dialog a;

  public n(Context paramContext)
  {
    this.a = new Dialog(paramContext, 2131558421);
    this.a.setContentView(2130903120);
    this.a.setFeatureDrawableAlpha(0, 0);
    this.a.setCanceledOnTouchOutside(true);
  }

  public final void a()
  {
    if ((this.a != null) && (!this.a.isShowing()))
      this.a.show();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     n
 * JD-Core Version:    0.6.2
 */