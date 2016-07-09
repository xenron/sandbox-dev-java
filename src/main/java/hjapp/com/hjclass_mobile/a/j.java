package hjapp.com.hjclass_mobile.a;

import android.os.Handler;
import android.os.Message;

final class j
  implements Runnable
{
  j(h paramh, String paramString, Handler paramHandler)
  {
  }

  public final void run()
  {
    try
    {
      synchronized (this.d.b)
      {
        if (this.d.c == null)
          this.d.b.wait();
        this.d.c.a(h.a(this.d));
        String str = this.d.c.a(this.a);
        this.d.d = false;
        this.d.c.b(h.a(this.d));
        this.d.e.unbindService(h.b(this.d));
        Message localMessage2 = new Message();
        localMessage2.what = this.b;
        localMessage2.obj = str;
        this.c.sendMessage(localMessage2);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Message localMessage1 = new Message();
      localMessage1.what = this.b;
      localMessage1.obj = localException.toString();
      this.c.sendMessage(localMessage1);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     j
 * JD-Core Version:    0.6.2
 */