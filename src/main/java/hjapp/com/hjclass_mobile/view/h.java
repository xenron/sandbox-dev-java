package hjapp.com.hjclass_mobile.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class h
  implements OnClickListener
{
  h(d paramd)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.f();
    d.b(this.a).a(1000 * d.j(this.a));
    this.a.a(3000);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     h
 * JD-Core Version:    0.6.2
 */