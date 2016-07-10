package hjapp.com.hjclass_mobile.view.ele;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import hjapp.com.hjclass_mobile.HJApplication;
import hjapp.com.hjclass_mobile.pkg_c.c;
import hjapp.com.hjclass_mobile.pkg_c.m;
import hjapp.com.hjclass_mobile.pkg_c.w;

public final class r extends RelativeLayout
  implements hjapp.com.hjclass_mobile.pkg_c.b, m, w
{
  private c a = null;

  public r(Context paramContext)
  {
    super(paramContext);
  }

  public final void a()
  {
    removeAllViews();
  }

  public final void a(hjapp.com.hjclass_mobile.pkg_d.l paraml)
  {
    HJApplication localHJApplication = (HJApplication)getContext().getApplicationContext();
    switch (paraml.k().a())
    {
    default:
      this.a = new ag(getContext(), localHJApplication);
    case 1:
    case 2:
    }
    while (true)
    {
      this.a.a(this);
      addView((View)this.a);
      return;
      this.a = new ag(getContext(), localHJApplication);
      continue;
      this.a = new ai(getContext(), localHJApplication);
    }
  }

  public final void a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }

  public final double b()
  {
    this.a.a();
    return this.a.b();
  }

  public final void b(boolean paramBoolean)
  {
    Intent localIntent = new Intent("restudy");
    localIntent.putExtra("flag", paramBoolean);
    getContext().sendBroadcast(localIntent);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     r
 * JD-Core Version:    0.6.2
 */