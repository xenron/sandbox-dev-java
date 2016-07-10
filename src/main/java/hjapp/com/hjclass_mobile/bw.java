package hjapp.com.hjclass_mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;

final class bw
  implements OnClickListener
{
  bw(HJLessonListActivity paramHJLessonListActivity, int paramInt, pkg_d.s params, pkg_d.t paramt)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.a == -1)
    {
      Intent localIntent1 = new Intent();
      localIntent1.setClass(this.d, HJSubDownloadTabActivity.class);
      this.d.startActivity(localIntent1);
      return;
    }
    long l = h.z.e();
    if (52428800L > l)
    {
      HJLessonListActivity localHJLessonListActivity = this.d;
      String str = this.d.getString(2131493042);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(l);
      Toast.makeText(localHJLessonListActivity, h.y.a(str, arrayOfObject), 0).show();
      return;
    }
    int i = HJLessonListActivity.a(this.d, this.b);
    this.c.b(4);
    Intent localIntent2 = new Intent("check_task");
    localIntent2.putExtra("position", i);
    this.d.sendBroadcast(localIntent2);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     bw
 * JD-Core Version:    0.6.2
 */