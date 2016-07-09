package hjapp.com.hjclass_mobile.view.ele;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class p
  implements OnCheckedChangeListener
{
  p(o paramo)
  {
  }

  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.a.d().booleanValue())
        break label83;
      o.a(this.a).setVisibility(0);
    }
    while (true)
    {
      if (this.a.e() != null)
      {
        hjapp.com.hjclass_mobile.h.u.b(">>>>>>>>>myAnswer>>>>>>>=" + o.c(this.a));
        this.a.e().a(o.c(this.a));
      }
      return;
      label83: o.b(this.a).setVisibility(0);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     p
 * JD-Core Version:    0.6.2
 */