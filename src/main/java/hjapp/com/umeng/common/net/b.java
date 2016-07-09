package hjapp.com.umeng.common.net;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import hjapp.com.umeng.common.a;

final class b extends Handler
{
  b(DownloadingService paramDownloadingService)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    a.c(DownloadingService.a(), "IncomingHandler(msg.what:" + paramMessage.what + " msg.arg1:" + paramMessage.arg1 + " msg.arg2:" + paramMessage.arg2 + " msg.replyTo:" + paramMessage.replyTo);
    switch (paramMessage.what)
    {
    default:
      super.handleMessage(paramMessage);
      return;
    case 4:
    }
    Bundle localBundle = paramMessage.getData();
    a.c(DownloadingService.a(), "IncomingHandler(msg.getData():" + localBundle);
    d locald = new d(localBundle.getString("mComponentName"), localBundle.getString("mTitle"), localBundle.getString("mUrl"));
    if (DownloadingService.a(locald))
    {
      a.a(DownloadingService.a(), locald.b + " is already in downloading list. ");
      return;
    }
    DownloadingService.b().put(locald, paramMessage.replyTo);
    DownloadingService.a(this.a, locald);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     b
 * JD-Core Version:    0.6.2
 */