package hjapp.com.hjclass_mobile;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;
import android.widget.RemoteViews;
import android.widget.Toast;
import hjapp.com.hjclass_mobile.pkg_c.ae;

import java.io.File;
import java.io.IOException;

public class UpdateService extends Service
  implements ae
{
  private NotificationManager a = null;
  private Notification b = null;
  private Intent c = null;
  private PendingIntent d = null;
  private hjapp.com.hjclass_mobile.pkg_b.aa e = null;

  public final int a(int paramInt)
  {
    this.b.contentView.setProgressBar(2131362012, 100, paramInt, false);
    this.b.contentView.setTextViewText(2131362010, paramInt + "%");
    this.a.notify(0, this.b);
    return paramInt;
  }

  public final void a()
  {
    Intent localIntent = new Intent("msg_progress");
    localIntent.putExtra("value", 0);
    sendBroadcast(localIntent);
    this.b.contentView.setProgressBar(2131362012, 100, 0, false);
    this.b.contentView.setTextViewText(2131362010, "0%");
  }

  public final void a(File paramFile)
  {
    if (paramFile == null)
    {
      Toast.makeText(this, getString(2131492995), 0);
      return;
    }
    if ((paramFile != null) && (!paramFile.exists()))
    {
      Toast.makeText(this, getString(2131492995), 0);
      return;
    }
    String str = "chmod +x " + paramFile.getPath();
    try
    {
      Runtime.getRuntime().exec(str);
      Uri localUri = Uri.fromFile(paramFile);
      Intent localIntent1 = new Intent("android.intent.action.VIEW");
      localIntent1.setDataAndType(localUri, "application/vnd.android.package-archive");
      this.d = PendingIntent.getActivity(this, 0, localIntent1, 0);
      this.b.defaults = 1;
      this.b.flags = 16;
      this.b.contentIntent = this.d;
      this.b.contentView.setViewVisibility(2131362011, 8);
      this.b.contentView.setTextViewText(2131362010, getString(2131492996));
      this.a.notify(0, this.b);
      stopService(this.c);
      Intent localIntent2 = new Intent("msg_complete");
      localIntent2.putExtra("filename", paramFile.getPath());
      sendBroadcast(localIntent2);
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    this.a = ((NotificationManager)getSystemService("notification"));
    this.b = new Notification();
    this.b.contentView = new RemoteViews(getPackageName(), 2130903101);
    this.c = new Intent(this, TabMainActivity.class);
    this.c.setFlags(541065216);
    this.d = PendingIntent.getActivity(this, 0, this.c, 134217728);
    this.b.icon = 2130837695;
    this.b.contentIntent = this.d;
    this.a.notify(0, this.b);
    super.onCreate();
  }

  public void onStart(Intent paramIntent, int paramInt)
  {
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      this.e = new pkg_b.aa(this);
      hjapp.com.hjclass_mobile.pkg_b.aa localaa = this.e;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = h.z.f;
      localaa.execute(arrayOfString);
    }
    while (true)
    {
      super.onStart(paramIntent, paramInt);
      return;
      Toast.makeText(this, getString(2131492995), 0).show();
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     UpdateService
 * JD-Core Version:    0.6.2
 */