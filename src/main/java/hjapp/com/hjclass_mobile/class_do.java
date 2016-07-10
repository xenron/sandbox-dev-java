package hjapp.com.hjclass_mobile;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

import java.util.Iterator;

final class class_do
  implements DialogInterface.OnClickListener
{
  class_do(HJSubFeedActivity paramHJSubFeedActivity)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    Iterator localIterator = z.g.iterator();
    while (localIterator.hasNext())
      ((Activity)localIterator.next()).finish();
    Intent localIntent = ((HJApplication)this.a.getApplicationContext()).c();
    if (localIntent != null)
      this.a.stopService(localIntent);
    this.a.finish();
    z.a();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     com.hjclass_mobile.do
 * JD-Core Version:    0.6.2
 */