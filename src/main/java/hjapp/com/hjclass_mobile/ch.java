package hjapp.com.hjclass_mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.NetworkInfo;
import android.widget.Toast;

final class ch
  implements OnClickListener
{
  ch(HJMoreActivity paramHJMoreActivity)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    NetworkInfo localNetworkInfo = h.z.a(this.a);
    if ((localNetworkInfo == null) || (!h.z.b(this.a)))
    {
      h.z.h = false;
      if (!h.z.h)
        break label88;
      new cl(this.a, (byte)0).execute(new Void[0]);
    }
    while (true)
    {
      paramDialogInterface.dismiss();
      return;
      h.z.h = true;
      if (localNetworkInfo.getType() == 1);
      for (boolean bool = true; ; bool = false)
      {
        h.z.i = bool;
        break;
      }
      label88: Toast.makeText(this.a, this.a.getString(2131492957), 1).show();
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ch
 * JD-Core Version:    0.6.2
 */