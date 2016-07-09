package hjapp.com.hjclass_mobile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

final class dw extends AsyncTask
{
  dw(ImageActivity paramImageActivity)
  {
  }

  private static Bitmap a(String[] paramArrayOfString)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramArrayOfString[0]);
      return localBitmap;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  protected final void onPreExecute()
  {
    ImageActivity.a(this.a).show();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     dw
 * JD-Core Version:    0.6.2
 */