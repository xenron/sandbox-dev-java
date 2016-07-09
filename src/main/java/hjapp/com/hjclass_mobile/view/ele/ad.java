package hjapp.com.hjclass_mobile.view.ele;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class ad
  implements OnCheckedChangeListener
{
  ad(ac paramac)
  {
  }

  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.a.d().booleanValue())
        break label58;
      ac.a(this.a).setVisibility(0);
    }
    while (true)
    {
      if (this.a.e() != null)
        this.a.e().a(ac.c(this.a));
      return;
      label58: ac.b(this.a).setVisibility(0);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ad
 * JD-Core Version:    0.6.2
 */