package hjapp.com.hjclass_mobile.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;

public final class o
  implements hjapp.com.hjclass_mobile.c.d
{
  private Dialog a;
  private Handler b = new Handler();
  private Runnable c = new p(this);

  public o(Context paramContext, boolean paramBoolean)
  {
    this.a = new Dialog(paramContext, 2131558421);
    if (paramBoolean)
      this.a.setContentView(2130903122);
    while (true)
    {
      this.a.setFeatureDrawableAlpha(0, 0);
      this.a.setCanceledOnTouchOutside(true);
      return;
      this.a.setContentView(2130903121);
    }
  }

  public final void a()
  {
    if ((this.a != null) && (!this.a.isShowing()))
    {
      this.a.show();
      this.b.postDelayed(this.c, 2000L);
    }
  }

  public final void b()
  {
    if ((this.a != null) && (this.a.isShowing()))
      this.a.dismiss();
    this.b.removeCallbacks(this.c);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     o
 * JD-Core Version:    0.6.2
 */