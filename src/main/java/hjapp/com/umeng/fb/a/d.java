package hjapp.com.umeng.fb.a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONArray;
import org.json.JSONException;

public class d extends Thread
{
  private static ExecutorService b = Executors.newFixedThreadPool(3);
  private Context a;

  public d(Context paramContext)
  {
    this.a = paramContext;
  }

  public void run()
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    SharedPreferences localSharedPreferences = this.a.getSharedPreferences("feedback", 0);
    Iterator localIterator1 = localSharedPreferences.getAll().keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str2 = localSharedPreferences.getString((String)localIterator1.next(), null);
      if ((!hjapp.com.umeng.common.b.b.c(str2)) && (str2.indexOf("fail") != -1))
        try
        {
          localArrayList.add(new hjapp.com.umeng.fb.b(new JSONArray(str2)));
        }
        catch (Exception localException)
        {
        }
    }
    Iterator localIterator2 = localArrayList.iterator();
    hjapp.com.umeng.fb.b localb;
    int j;
    label185: a locala;
    String str1;
    while (localIterator2.hasNext())
    {
      localb = (hjapp.com.umeng.fb.b)localIterator2.next();
      if ((localb.b != b.a.d) && (localb.b != b.a.a))
      {
        Iterator localIterator3 = localb.f.iterator();
        j = -1;
        if (!localIterator3.hasNext())
          break label363;
        locala = (a)localIterator3.next();
        j++;
        if (locala.g != a.a.b)
          break label365;
        str1 = localSharedPreferences.getString(localb.c, null);
      }
    }
    while (true)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(str1);
        localJSONArray.put(j, locala.h.put("state", a.a.d));
        localSharedPreferences.edit().putString(localb.c, localJSONArray.toString()).commit();
        f localf = new f(locala.h, this.a);
        b.submit(localf);
        k = 1;
        i = k;
        break label185;
        if (i != 0)
        {
          Intent localIntent = new Intent().setAction("postFeedbackFinished");
          this.a.sendBroadcast(localIntent);
        }
        return;
      }
      catch (JSONException localJSONException)
      {
      }
      break label185;
      label363: break;
      label365: int k = i;
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     aersion:    0.6.2
 */