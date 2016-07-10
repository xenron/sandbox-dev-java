package hjapp.com.hjclass_mobile;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;
import hjapp.com.hjclass_mobile.pkg_b.d;
import hjapp.com.hjclass_mobile.pkg_c.a;
import hjapp.com.hjclass_mobile.pkg_d.s;
import hjapp.com.hjclass_mobile.pkg_d.t;
import hjapp.com.hjclass_mobile.pkg_g.p;
import hjapp.com.hjclass_mobile.pkg_g.q;

import java.io.File;
import java.util.List;
import java.util.Map;

public class DownloadService extends Service
  implements a
{
  private static int g = -1;
  private hjapp.com.hjclass_mobile.pkg_b.b a = null;
  private NotificationManager b = null;
  private Notification c = null;
  private Intent d = null;
  private PendingIntent e = null;
  private f f = null;
  private HJApplication h = null;
  private boolean i = true;
  private p j = null;

  private void a()
  {
    sendBroadcast(new Intent("update_ui_task"));
  }

  private void a(int paramInt1, int paramInt2)
  {
    Map localMap = this.h.a();
    s locals = (s)this.h.b().get(paramInt1);
    d locald = (d)localMap.get(locals.i());
    switch (paramInt2)
    {
    case 2:
    case 3:
    default:
    case 5:
    case 4:
    case 1:
    }
    while (true)
    {
      this.a.b(locals);
      localMap.remove(locals.i());
      if (locald != null)
        localMap.put(locals.i(), locald);
      return;
      if (locald != null)
      {
        locald.b(false);
        locald.a(false);
        locald.e();
        locals.c(5);
        a();
        this.b.cancelAll();
        continue;
        if (locald != null)
        {
          g = paramInt1;
          if (locald.h())
            locald.f();
          while (true)
          {
            a(locals.b(), 4, false, locals.g());
            locald.b(false);
            locald.a(true);
            locals.c(4);
            a();
            break;
            if (!locald.b())
            {
              String[] arrayOfString = new String[2];
              arrayOfString[0] = locald.i();
              arrayOfString[1] = String.valueOf(locald.j());
              locald.execute(arrayOfString);
            }
          }
          if (locald != null)
          {
            locald.b(true);
            locald.a(false);
            locald.e();
            locals.c(1);
            a();
          }
        }
      }
    }
  }

  private void a(s params)
  {
    List localList = this.h.b();
    int k = localList.size();
    for (int m = 0; ; m++)
      if (m < k)
      {
        if (((s)localList.get(m)).i().equals(params.i()))
          localList.remove(m);
      }
      else
        return;
  }

  private void a(String paramString)
  {
    Map localMap = this.h.a();
    List localList = this.h.b();
    if ((localList == null) || (localList.size() == 0));
    do
    {
      return;
      s locals = b(paramString);
      if ((d)localMap.get(locals.i()) != null)
      {
        localMap.remove(locals.i());
        locals.e(0);
        locals.c(2);
        a(locals.b(), 2, false, 0);
        this.a.b(locals);
        this.a.d(locals);
        Intent localIntent = new Intent("download_status");
        localIntent.putExtra("downkey", paramString);
        localIntent.putExtra("isOK", false);
        sendBroadcast(localIntent);
        a();
      }
    }
    while (localList.size() != 0);
    g = -1;
  }

  private void a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    String str = "";
    switch (paramInt1)
    {
    default:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      if (paramBoolean)
        str = getString(2131492915) + "：" + paramString;
      this.c.tickerText = str;
      this.c.contentView.setTextViewText(2131362009, str);
      this.b.notify(0, this.c);
      return;
      this.c.icon = 17301634;
      this.c.contentView.setViewVisibility(2131362011, 8);
      this.c.contentView.setViewVisibility(2131362010, 8);
      str = getString(2131492905) + "：" + paramString;
      continue;
      str = getString(2131492907) + "：" + paramString;
      this.c.contentView.setViewVisibility(2131362011, 8);
      this.c.contentView.setViewVisibility(2131362010, 8);
      this.c.icon = 17301634;
      continue;
      str = getString(2131492908) + "：" + paramString;
      this.c.contentView.setViewVisibility(2131362011, 0);
      this.c.contentView.setViewVisibility(2131362010, 0);
      this.c.contentView.setProgressBar(2131362012, 100, paramInt2, false);
      this.c.contentView.setTextViewText(2131362010, paramInt2 + "%");
      this.c.icon = 17301633;
    }
  }

  private boolean a(int paramInt)
  {
    Map localMap = this.h.a();
    List localList = this.h.b();
    if (paramInt >= -1 + localList.size())
      return false;
    d locald = (d)localMap.get(((s)localList.get(paramInt)).i());
    if (locald == null)
      return false;
    return locald.c();
  }

  private int b()
  {
    Map localMap = this.h.a();
    List localList = this.h.b();
    int k = 0;
    int m = localList.size();
    while (k < m)
    {
      d locald = (d)localMap.get(((s)localList.get(k)).i());
      if ((locald != null) && ((locald.b()) || (locald.d())))
        return k;
      k++;
    }
    return -1;
  }

  private s b(String paramString)
  {
    List localList = this.h.b();
    int k = localList.size();
    for (int m = 0; m < k; m++)
    {
      s locals = (s)localList.get(m);
      if (locals.i().equals(paramString))
        return locals;
    }
    return null;
  }

  private int c()
  {
    Map localMap = this.h.a();
    List localList = this.h.b();
    int k = 0;
    int m = localList.size();
    while (k < m)
    {
      d locald = (d)localMap.get(((s)localList.get(k)).i());
      if ((locald != null) && (locald.b()))
        return k;
      k++;
    }
    return -1;
  }

  private int d()
  {
    Map localMap = this.h.a();
    List localList = this.h.b();
    int k = 0;
    int m = localList.size();
    while (k < m)
    {
      d locald = (d)localMap.get(((s)localList.get(k)).i());
      if ((locald != null) && (locald.d()))
        return k;
      k++;
    }
    return -1;
  }

  public final void a(int paramInt1, String paramString, double paramDouble, int paramInt2)
  {
    if (!this.i);
    d locald;
    do
    {
      s locals;
      do
      {
        return;
        locals = b(paramString);
      }
      while (locals == null);
      locals.e(paramInt1);
      locals.a(paramInt2);
      locals.a(paramDouble);
      this.c.contentView.setTextViewText(2131362010, paramInt1 + "%");
      a();
      this.a.c(locals);
      hjapp.com.hjclass_mobile.h.u.b("更新通知下载进度" + paramInt1);
      locald = (d)this.h.a().get(locals.i());
    }
    while ((locald == null) || (locald.c()));
    this.c.contentView.setProgressBar(2131362012, 100, paramInt1, false);
    this.b.notify(0, this.c);
    this.i = true;
  }

  public final void a(boolean paramBoolean, String paramString)
  {
    s locals;
    if (paramBoolean)
    {
      locals = b(paramString);
      if (locals != null);
    }
    label290: int k;
    do
    {
      do
        return;
      while (!Environment.getExternalStorageState().equals("mounted"));
      a(locals.b(), 3, true, 100);
      String str1 = hjapp.com.hjclass_mobile.h.z.c + locals.f() + File.separator + locals.h();
      if (locals.m() == 4)
      {
        this.j = new p(new e(this, str1));
        t localt = this.a.c(locals.f(), locals.c(), locals.d());
        Boolean localBoolean = Boolean.valueOf(false);
        if (localt != null)
          if (localt.v() != 3)
            break label290;
        for (boolean bool = true; ; bool = false)
        {
          localBoolean = Boolean.valueOf(bool);
          String str2 = this.a.c(locals.c(), locals.f());
          p localp = this.j;
          String str3 = String.valueOf(paramString);
          String str4 = String.valueOf(locals.f());
          String str5 = String.valueOf(locals.c());
          String str6 = String.valueOf(locals.d());
          String str7 = localBoolean.toString();
          new q(localp, this).execute(new String[] { str1, str3, str4, str5, str6, str7, str2 });
          return;
        }
      }
      g localg = new g(this);
      String[] arrayOfString = new String[5];
      arrayOfString[0] = str1;
      arrayOfString[1] = String.valueOf(paramString);
      arrayOfString[2] = String.valueOf(locals.f());
      arrayOfString[3] = String.valueOf(locals.c());
      arrayOfString[4] = String.valueOf(locals.d());
      localg.execute(arrayOfString);
      return;
      a(paramString);
      k = d();
    }
    while (k < 0);
    a(k, 4);
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    Log.i("DownLoadService", "onCreate");
    super.onCreate();
    this.h = ((HJApplication)getApplicationContext());
    if (this.f == null)
    {
      this.f = new f(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("check_task");
      localIntentFilter.addAction("delete_task");
      localIntentFilter.addAction("stop_tasks");
      registerReceiver(this.f, localIntentFilter);
    }
    this.b = ((NotificationManager)getSystemService("notification"));
    this.c = new Notification();
    this.c.contentView = new RemoteViews(getPackageName(), 2130903101);
    this.d = new Intent(this, HJLessonListActivity.class);
    this.d.setClass(this, HJSubDownloadTabActivity.class);
    this.d.setFlags(541065216);
    this.e = PendingIntent.getActivity(this, 0, this.d, 0);
    this.c.icon = 2130837695;
    this.c.contentIntent = this.e;
    this.a = new hjapp.com.hjclass_mobile.pkg_b.b(this);
  }

  public void onDestroy()
  {
    this.b.cancelAll();
    unregisterReceiver(this.f);
    d locald = null;
    Map localMap = this.h.a();
    List localList = this.h.b();
    int k = localList.size();
    for (int m = 0; (m < k) && (localMap.size() != 0); m++)
    {
      s locals = (s)localList.get(m);
      if (localMap.containsKey(locals.i()))
        locald = (d)localMap.get(locals.i());
      if ((locald != null) && ((locald.b()) || (locald.d())))
      {
        locald.e();
        locald.cancel(true);
        locald.g();
        locals.c(5);
        this.a.b(locals);
      }
    }
    localMap.clear();
    this.b.cancelAll();
    super.onDestroy();
  }

  public void onStart(Intent paramIntent, int paramInt)
  {
    Log.i("DownLoadService", "onStart");
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     DownloadService
 * JD-Core Version:    0.6.2
 */