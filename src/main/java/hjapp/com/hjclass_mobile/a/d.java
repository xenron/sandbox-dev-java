package hjapp.com.hjclass_mobile.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Message;

final class d
  implements Runnable
{
  d(c paramc, String paramString)
  {
  }

  public final void run()
  {
    Context localContext = this.b.a;
    String str1 = this.a;
    PackageInfo localPackageInfo = localContext.getPackageManager().getPackageArchiveInfo(str1, 128);
    String str2 = this.b.a(localPackageInfo);
    if (str2 != null)
    {
      c localc = this.b;
      localc.a(str2, this.a);
    }
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.obj = this.a;
    c.a(this.b).sendMessage(localMessage);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     d
 * JD-Core Version:    0.6.2
 */