package hjapp.com.hjclass_mobile;

import android.os.AsyncTask;

final class bj extends AsyncTask
{
  private bj(HJExchangeAcitvity paramHJExchangeAcitvity)
  {
  }

  protected final void onPreExecute()
  {
    HJExchangeAcitvity.a(this.a, true);
    HJExchangeAcitvity.a(this.a, h.z.a(this.a, "正在获取帐户信息…"));
    HJExchangeAcitvity.a(this.a).show();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     bj
 * JD-Core Version:    0.6.2
 */