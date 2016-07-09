package hjapp.com.hjclass_mobile;

import android.os.AsyncTask;

final class k extends AsyncTask
{
  private k(HJAlipayActivity paramHJAlipayActivity)
  {
  }

  protected final void onPreExecute()
  {
    HJAlipayActivity.a(this.a, h.z.a(this.a, "正在连接服务器…"));
    HJAlipayActivity.e(this.a).show();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     k
 * JD-Core Version:    0.6.2
 */