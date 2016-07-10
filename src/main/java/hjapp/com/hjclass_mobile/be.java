package hjapp.com.hjclass_mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import hjapp.com.hjclass_mobile.pkg_f.c;

final class be
  implements OnClickListener
{
  be(HJExchangeAcitvity paramHJExchangeAcitvity)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bi localbi = new bi(this.a, (byte)0);
    String[] arrayOfString = new String[3];
    arrayOfString[0] = c.c();
    arrayOfString[1] = h.z.b(c.d());
    arrayOfString[2] = String.valueOf(HJExchangeAcitvity.e(this.a));
    localbi.execute(arrayOfString);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     be
 * JD-Core Version:    0.6.2
 */