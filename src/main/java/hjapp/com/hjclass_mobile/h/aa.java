package hjapp.com.hjclass_mobile.h;

import android.os.Process;

final class aa
  implements Runnable
{
  public final void run()
  {
    Process.killProcess(Process.myPid());
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     aa
 * JD-Core Version:    0.6.2
 */