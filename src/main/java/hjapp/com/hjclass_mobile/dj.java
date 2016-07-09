package hjapp.com.hjclass_mobile;

import android.os.AsyncTask;
import hjapp.com.hjclass_mobile.f.c;

import java.util.List;

final class dj extends AsyncTask
{
  private dj(HJSubCourseActivity paramHJSubCourseActivity)
  {
  }

  private List a(String[] paramArrayOfString)
  {
    if (h.z.h)
    {
      String str1 = paramArrayOfString[0];
      String str2 = paramArrayOfString[1];
      String str3 = h.y.a(this.a);
      f.b.a();
      List localList = f.b.a(str1, str2, str3);
      if ((h.z.h) && (localList != null));
      try
      {
        HJSubCourseActivity.a(this.a).b(localList);
        return localList;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return localList;
      }
    }
    return HJSubCourseActivity.a(this.a).a(c.b(), paramArrayOfString[1]);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     dj
 * JD-Core Version:    0.6.2
 */