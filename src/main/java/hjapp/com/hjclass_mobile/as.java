package hjapp.com.hjclass_mobile;

import android.os.AsyncTask;
import hjapp.com.hjclass_mobile.f.a;
import hjapp.com.hjclass_mobile.f.c;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

final class as extends AsyncTask
{
  private as(HJDemoClassActivity paramHJDemoClassActivity)
  {
  }

  private List a(Object[] paramArrayOfObject)
  {
    new ArrayList();
    List localList;
    if (h.z.h)
    {
      Hashtable localHashtable = HJDemoClassActivity.c(this.a).b(c.b(), ((Integer)paramArrayOfObject[1]).intValue());
      localList = a.a(String.valueOf(paramArrayOfObject[0]), ((Integer)paramArrayOfObject[1]).intValue(), ((Integer)paramArrayOfObject[2]).intValue(), localHashtable, false);
    }
    while (true)
    {
      if (localList != null)
        HJDemoClassActivity.a(this.a).addAll(localList);
      if (h.z.h);
      try
      {
        HJDemoClassActivity.c(this.a).a(HJDemoClassActivity.a(this.a));
        return localList;
        localList = HJDemoClassActivity.c(this.a).a(c.b(), ((Integer)paramArrayOfObject[1]).intValue());
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return localList;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     as
 * JD-Core Version:    0.6.2
 */