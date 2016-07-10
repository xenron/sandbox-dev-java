package hjapp.com.hjclass_mobile;

import android.os.AsyncTask;
import hjapp.com.hjclass_mobile.pkg_f.a;
import hjapp.com.hjclass_mobile.pkg_f.c;

import java.util.List;

final class u extends AsyncTask
{
  private u(HJClassListActivity paramHJClassListActivity)
  {
  }

  private List a(String[] paramArrayOfString)
  {
    if (h.z.h)
    {
      String str = h.y.a(this.a);
      List localList = a.a(paramArrayOfString[0], Integer.valueOf(paramArrayOfString[1]).intValue(), str);
      if ((h.z.h) && (localList != null));
      try
      {
        HJClassListActivity.a(this.a).b(localList);
        return localList;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return localList;
      }
    }
    return HJClassListActivity.a(this.a).a(c.b(), null, Integer.valueOf(paramArrayOfString[1]).intValue());
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     u
 * JD-Core Version:    0.6.2
 */