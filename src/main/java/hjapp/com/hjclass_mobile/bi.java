package hjapp.com.hjclass_mobile;

import android.os.AsyncTask;

final class bi extends AsyncTask
{
  private bi(HJExchangeAcitvity paramHJExchangeAcitvity)
  {
  }

  protected final void onPreExecute()
  {
    HJExchangeAcitvity.a(this.a, h.z.a(this.a, "正在处理…"));
    HJExchangeAcitvity.a(this.a).show();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     bi
 * JD-Core Version:    0.6.2
 */