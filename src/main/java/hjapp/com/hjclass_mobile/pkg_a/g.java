package hjapp.com.hjclass_mobile.pkg_a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

final class g extends Handler
{
  g(c paramc)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      default:
      case 2:
      }
      while (true)
      {
        super.handleMessage(paramMessage);
        return;
        this.a.b();
        String str = (String)paramMessage.obj;
        c localc = this.a;
        Context localContext = this.a.a;
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(localContext);
        localBuilder.setIcon(2130837728);
        localBuilder.setTitle(localContext.getResources().getString(2131493091));
        localBuilder.setMessage(localContext.getResources().getString(2131493092));
        localBuilder.setPositiveButton(2131493093, new e(localc, str, localContext));
        localBuilder.setNegativeButton(localContext.getResources().getString(2131493094), new f(localc));
        localBuilder.show();
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     g
 * JD-Core Version:    0.6.2
 */