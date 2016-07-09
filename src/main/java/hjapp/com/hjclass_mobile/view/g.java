package hjapp.com.hjclass_mobile.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class g
  implements OnClickListener
{
  g(d paramd)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    d.h(this.a);
    this.a.f();
    d.b(this.a).a((int)d.i(this.a));
    this.a.a(3000);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     g
 * JD-Core Version:    0.6.2
 */