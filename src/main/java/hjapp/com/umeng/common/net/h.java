package hjapp.com.umeng.common.net;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import java.io.File;

final class h extends Handler
{
  h(a parama)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    try
    {
      String str1 = paramMessage.getData().getString("filename");
      DownloadingService.a(this.a.a).cancel(a.a(this.a));
      hjapp.com.umeng.common.a.c(DownloadingService.a(), "Cancel old notification....");
      Notification localNotification = new Notification(17301634, "下载完成，请点击安装", System.currentTimeMillis());
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(268435456);
      localIntent.setDataAndType(Uri.fromFile(new File(str1)), "application/vnd.android.package-archive");
      PendingIntent localPendingIntent = PendingIntent.getActivity(a.b(this.a), 0, localIntent, 134217728);
      localNotification.setLatestEventInfo(a.b(this.a), a.c(this.a).b, "下载完成，请点击安装", localPendingIntent);
      localNotification.flags = 16;
      DownloadingService.a(this.a.a, (NotificationManager)this.a.a.getSystemService("notification"));
      DownloadingService.a(this.a.a).notify(a.a(this.a), localNotification);
      hjapp.com.umeng.common.a.c(DownloadingService.a(), "Show new  notification....");
      boolean bool = DownloadingService.a(a.b(this.a));
      String str2 = DownloadingService.a();
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Boolean.valueOf(bool);
      hjapp.com.umeng.common.a.c(str2, String.format("isAppOnForeground = %1$B", arrayOfObject1));
      if (bool)
      {
        DownloadingService.a(this.a.a).cancel(a.a(this.a));
        a.b(this.a).startActivity(localIntent);
      }
      String str3 = DownloadingService.a();
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = a.c(this.a).b;
      arrayOfObject2[1] = str1;
      hjapp.com.umeng.common.a.a(str3, String.format("%1$10s downloaded. Saved to: %2$s", arrayOfObject2));
      return;
    }
    catch (Exception localException)
    {
      hjapp.com.umeng.common.a.b(DownloadingService.a(), "can not install. " + localException.getMessage());
      DownloadingService.a(this.a.a).cancel(a.a(this.a));
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     h
 * JD-Core Version:    0.6.2
 */