package hjapp.com.umeng.common.net;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;

import java.util.HashMap;
import java.util.Map;

public class DownloadingService extends Service
{
  private static final String b = DownloadingService.class.getName();
  private static Map e = new HashMap();
  final Messenger a = new Messenger(new b(this));
  private NotificationManager c;
  private String[] d;

  public IBinder onBind(Intent paramIntent)
  {
    a.c(b, "onBind ");
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle != null)
      this.d = localBundle.getStringArray("reporturls");
    return this.a.getBinder();
  }

  public void onCreate()
  {
    super.onCreate();
    a.c(b, "onCreate ");
    this.c = ((NotificationManager)getSystemService("notification"));
  }

  public void onDestroy()
  {
    try
    {
      e.a(getApplicationContext()).a();
      e.a(getApplicationContext()).finalize();
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        a.b(b, localException.getMessage());
    }
  }

  public void onStart(Intent paramIntent, int paramInt)
  {
    a.c(b, "onStart ");
    super.onStart(paramIntent, paramInt);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     DownloadingService
 * JD-Core Version:    0.6.2
 */