package hjapp.com.hjclass_mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class bg
  implements OnClickListener
{
  bg(HJExchangeAcitvity paramHJExchangeAcitvity)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.a, HJAlipayActivity.class);
    this.a.startActivity(localIntent);
    paramDialogInterface.dismiss();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     bg
 * JD-Core Version:    0.6.2
 */