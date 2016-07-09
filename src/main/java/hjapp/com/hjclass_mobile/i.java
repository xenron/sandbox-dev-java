package hjapp.com.hjclass_mobile;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public final class i
  implements OnCancelListener
{
  Activity a;

  public i(Activity paramActivity)
  {
    this.a = paramActivity;
  }

  public final void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.onKeyDown(4, null);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     i
 * JD-Core Version:    0.6.2
 */