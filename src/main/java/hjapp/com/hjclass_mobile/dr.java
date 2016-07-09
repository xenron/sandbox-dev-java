package hjapp.com.hjclass_mobile;

import android.content.Intent;

final class dr
  implements Runnable
{
  dr(HJUrlScheme paramHJUrlScheme, boolean paramBoolean)
  {
  }

  public final void run()
  {
    if (this.a)
    {
      Intent localIntent1 = new Intent();
      localIntent1.setClass(this.b, HJLoginActivity.class);
      this.b.startActivity(localIntent1);
    }
    while (true)
    {
      Intent localIntent2 = ((HJApplication)this.b.getApplicationContext()).c();
      localIntent2.setClass(this.b, DownloadService.class);
      localIntent2.setFlags(67108864);
      this.b.startService(localIntent2);
      this.b.finish();
      return;
      HJUrlScheme.a(this.b);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     dr
 * JD-Core Version:    0.6.2
 */