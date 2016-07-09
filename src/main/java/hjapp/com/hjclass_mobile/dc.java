package hjapp.com.hjclass_mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import hjapp.com.hjclass_mobile.f.c;

final class dc
  implements OnClickListener
{
  dc(HJStudyCardCourseLessonActivity paramHJStudyCardCourseLessonActivity)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    de localde = new de(this.a, (byte)0);
    String[] arrayOfString = new String[3];
    arrayOfString[0] = c.a();
    arrayOfString[1] = Integer.toString(HJStudyCardCourseLessonActivity.a(this.a));
    arrayOfString[2] = c.e();
    localde.execute(arrayOfString);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     dc
 * JD-Core Version:    0.6.2
 */