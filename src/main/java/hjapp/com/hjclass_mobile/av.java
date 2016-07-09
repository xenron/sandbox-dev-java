package hjapp.com.hjclass_mobile;

import android.widget.Toast;

final class av
  implements Runnable
{
  av(HJDownloadActivity paramHJDownloadActivity)
  {
  }

  public final void run()
  {
    if (h.z.j)
    {
      HJDownloadActivity.a(this.a).i(f.c.b(), 2);
      HJDownloadActivity.a(this.a).g(f.c.b());
      HJDownloadActivity.b(this.a).a(HJDownloadActivity.a(this.a).f(f.c.b()));
      HJDownloadActivity.a(this.a).i(1, 2);
      HJDownloadActivity.a(this.a).g(1);
      HJDownloadActivity.a(this.a, HJDownloadActivity.b(this.a).b());
      HJDownloadActivity.c(this.a).notifyDataSetChanged();
      if (HJDownloadActivity.d(this.a).size() <= 0)
        break label190;
      HJDownloadActivity.e(this.a).setVisibility(8);
      HJDownloadActivity.f(this.a).setVisibility(0);
    }
    while (true)
    {
      Toast.makeText(this.a, this.a.getString(2131492985), 0).show();
      return;
      HJDownloadActivity.b(this.a).a(HJDownloadActivity.a(this.a).f(1));
      break;
      label190: HJDownloadActivity.e(this.a).setVisibility(0);
      HJDownloadActivity.f(this.a).setVisibility(8);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     av
 * JD-Core Version:    0.6.2
 */