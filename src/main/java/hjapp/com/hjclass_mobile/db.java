package hjapp.com.hjclass_mobile;

import android.os.AsyncTask;

final class db extends AsyncTask
{
  db(HJStudyCardActivity paramHJStudyCardActivity)
  {
  }

  protected final void onPreExecute()
  {
    HJStudyCardActivity.d(this.a).setVisibility(0);
    HJStudyCardActivity.e(this.a).setVisibility(8);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     db
 * JD-Core Version:    0.6.2
 */