package hjapp.com.hjclass_mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;

final class s
  implements OnClickListener
{
  s(HJClassListActivity paramHJClassListActivity, int paramInt)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://hxjiang.duapp.com/" + this.a));
    this.b.startActivity(localIntent);
    paramDialogInterface.dismiss();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     s
 * JD-Core Version:    0.6.2
 */