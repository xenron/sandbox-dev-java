package hjapp.com.hjclass_mobile;

import android.content.Intent;
import android.widget.Toast;
import hjapp.com.hjclass_mobile.pkg_b.e;
import hjapp.com.hjclass_mobile.pkg_f.c;

final class aw
  implements Runnable
{
  aw(HJDownloadActivity paramHJDownloadActivity)
  {
  }

  public final void run()
  {
    e locale = new e(this.a);
    HJApplication localHJApplication = (HJApplication)this.a.getApplication();
    Intent localIntent = localHJApplication.c();
    if (localIntent != null)
    {
      this.a.b();
      this.a.stopService(localIntent);
      localHJApplication.a(new Intent());
      localHJApplication.c().setClass(this.a, DownloadService.class);
      localHJApplication.c().setFlags(67108864);
      this.a.startService(localHJApplication.c());
    }
    locale.a(1);
    HJDownloadActivity.a(this.a).h(1);
    HJDownloadActivity.a(this.a).i(1);
    h.z.d(1);
    if (h.z.j)
    {
      locale.a(c.b());
      HJDownloadActivity.a(this.a).h(c.b());
      HJDownloadActivity.a(this.a).i(c.b());
      h.z.d(c.b());
    }
    HJDownloadActivity.d(this.a).clear();
    HJDownloadActivity.e(this.a).setVisibility(0);
    HJDownloadActivity.f(this.a).setVisibility(8);
    HJDownloadActivity.c(this.a).notifyDataSetChanged();
    Toast.makeText(this.a, this.a.getString(2131492985), 0).show();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     aw
 * JD-Core Version:    0.6.2
 */