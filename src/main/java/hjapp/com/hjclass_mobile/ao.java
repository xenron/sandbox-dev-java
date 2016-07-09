package hjapp.com.hjclass_mobile;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

final class ao extends AsyncTask
{
  private ao(HJCoureseLessonActivity paramHJCoureseLessonActivity)
  {
  }

  private List a(Object[] paramArrayOfObject)
  {
    new ArrayList();
    List localList;
    if (h.z.h)
    {
      Hashtable localHashtable = HJCoureseLessonActivity.a(this.a).b(f.c.b(), ((Integer)paramArrayOfObject[1]).intValue());
      localList = f.a.a(String.valueOf(paramArrayOfObject[0]), ((Integer)paramArrayOfObject[1]).intValue(), ((Integer)paramArrayOfObject[2]).intValue(), localHashtable, false);
    }
    while (true)
    {
      if (localList != null)
        HJCoureseLessonActivity.b(this.a).addAll(localList);
      if (h.z.h);
      try
      {
        HJCoureseLessonActivity.a(this.a).a(HJCoureseLessonActivity.b(this.a));
        HJCoureseLessonActivity.c(this.a);
        return localList;
        localList = HJCoureseLessonActivity.a(this.a).a(f.c.b(), ((Integer)paramArrayOfObject[1]).intValue());
      }
      catch (Exception localException)
      {
        while (true)
          localException.printStackTrace();
      }
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ao
 * JD-Core Version:    0.6.2
 */