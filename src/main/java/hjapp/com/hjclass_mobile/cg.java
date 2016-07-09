package hjapp.com.hjclass_mobile;

import android.os.AsyncTask;

final class cg extends AsyncTask
{
  cg(HJLoginActivity paramHJLoginActivity)
  {
  }

  protected final void onPreExecute()
  {
    super.onPreExecute();
    HJLoginActivity.a(this.a, h.z.a(this.a, this.a.getText(2131492875)));
    HJLoginActivity.a(this.a).show();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     cg
 * JD-Core Version:    0.6.2
 */