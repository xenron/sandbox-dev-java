package hjapp.com.hjclass_mobile.pkg_g;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import hjapp.com.hjclass_mobile.pkg_h.u;

public class a extends b
  implements OnCompletionListener, g
{
  private String b = null;
  private String c = null;
  private String d = null;

  public a(String paramString1, Context paramContext, String paramString2, String paramString3)
  {
    super(paramContext);
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
  }

  public void a(int paramInt)
  {
    u.c("seek=", String.valueOf(paramInt));
    if (this.a != null)
    {
      if (paramInt >= b())
        paramInt -= 2000;
      this.a.seekTo(paramInt);
    }
  }

  public final boolean a()
  {
    try
    {
      MediaPlayer localMediaPlayer = this.a;
      boolean bool1 = false;
      if (localMediaPlayer != null)
      {
        boolean bool2 = this.a.isPlaying();
        bool1 = false;
        if (bool2)
          bool1 = true;
      }
      return bool1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }

  public final int b()
  {
    try
    {
      MediaPlayer localMediaPlayer = this.a;
      int i = 0;
      if (localMediaPlayer != null)
      {
        int j = this.a.getDuration();
        i = j;
      }
      return i;
    }
    catch (Exception localException)
    {
    }
    return 0;
  }

  public void c()
  {
    k();
  }

  public final int d()
  {
    try
    {
      MediaPlayer localMediaPlayer = this.a;
      int i = 0;
      if (localMediaPlayer != null)
      {
        int j = this.a.getCurrentPosition();
        i = j;
      }
      return i;
    }
    catch (Exception localException)
    {
    }
    return 0;
  }

  public final void e()
  {
    if (this.a != null)
      this.a.pause();
  }

  public final void f()
  {
    if (this.a != null)
      this.a.start();
  }

  public final void g()
  {
  }

  public final void h()
  {
    a(this.b, this.c, this.d);
  }

  public final long i()
  {
    return 0L;
  }

  public final void j()
  {
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     g:    0.6.2
 */