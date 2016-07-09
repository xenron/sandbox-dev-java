package hjapp.com.hjclass_mobile;

import android.os.AsyncTask;

final class j extends AsyncTask
{
  private j(HJAlipayActivity paramHJAlipayActivity)
  {
  }

  protected final void onPreExecute()
  {
    HJAlipayActivity.a(this.a, h.z.a(this.a, "正在生成订单…"));
    HJAlipayActivity.e(this.a).show();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     j
 * JD-Core Version:    0.6.2
 */