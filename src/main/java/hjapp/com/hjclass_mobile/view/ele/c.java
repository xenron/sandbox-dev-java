package hjapp.com.hjclass_mobile.view.ele;

import android.view.View;
import android.view.View.OnClickListener;

final class c
  implements OnClickListener
{
  c(a parama)
  {
  }

  public final void onClick(View paramView)
  {
    if (!a.a(this.a).b())
    {
      if (a.a(this.a) != null)
        a.a(this.a).e();
      a.c(this.a).setVisibility(0);
      a.d(this.a).setVisibility(8);
      if (this.a.j() != null)
        this.a.j().g().endsWith("TYPE_LONG");
      a.b(this.a).removeMessages(1000);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     c
 * JD-Core Version:    0.6.2
 */