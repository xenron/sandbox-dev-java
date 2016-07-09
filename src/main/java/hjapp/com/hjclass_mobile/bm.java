package hjapp.com.hjclass_mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import hjapp.com.hjclass_mobile.d.s;
import hjapp.com.hjclass_mobile.d.t;

final class bm
  implements OnClickListener
{
  bm(HJFreeLessonListActivity paramHJFreeLessonListActivity, int paramInt, s params, t paramt, boolean paramBoolean)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.a == -1)
    {
      Intent localIntent1 = new Intent();
      localIntent1.setClass(this.e, HJSubDownloadTabActivity.class);
      this.e.startActivity(localIntent1);
      return;
    }
    long l = h.z.e();
    if (52428800L > l)
    {
      HJFreeLessonListActivity localHJFreeLessonListActivity = this.e;
      String str = this.e.getString(2131493042);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(l);
      Toast.makeText(localHJFreeLessonListActivity, h.y.a(str, arrayOfObject), 0).show();
      return;
    }
    int i = HJFreeLessonListActivity.a(this.e, this.b);
    this.c.b(4);
    if (this.d)
      HJFreeLessonListActivity.f(this.e).notifyDataSetChanged();
    while (true)
    {
      Intent localIntent2 = new Intent("check_task");
      localIntent2.putExtra("position", i);
      this.e.sendBroadcast(localIntent2);
      return;
      HJFreeLessonListActivity.d(this.e).notifyDataSetChanged();
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     bm
 * JD-Core Version:    0.6.2
 */