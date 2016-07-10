package hjapp.com.hjclass_mobile.pkg_g;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import hjapp.com.hjclass_mobile.pkg_h.z;

import java.io.File;

public final class h
  implements OnCompletionListener, g
{
  private MediaPlayer a;
  private File b = null;
  private hjapp.com.hjclass_mobile.pkg_e.a c;
  private Handler d = new Handler();
  private long e;
  private boolean f = false;
  private n g;
  private int h = 0;
  private Runnable i = new i(this);

  public h(String paramString, n paramn)
  {
    this.b = new File(paramString);
    this.g = paramn;
    if (this.b.exists())
    {
      this.e = this.b.length();
      if (this.c == null)
        this.c = new hjapp.com.hjclass_mobile.pkg_e.a(this.b);
    }
  }

  public final void a(int paramInt)
  {
    if (this.a != null)
      this.a.seekTo(paramInt);
  }

  public final boolean a()
  {
    try
    {
      boolean bool1 = this.a.isPlaying();
      boolean bool2 = false;
      if (bool1)
        bool2 = true;
      return bool2;
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
      int j = 0;
      if (localMediaPlayer != null)
      {
        int k = this.a.getDuration();
        j = k;
      }
      return j;
    }
    catch (Exception localException)
    {
    }
    return 0;
  }

  public final void c()
  {
    if (this.a != null);
    try
    {
      this.a.pause();
      Handler localHandler = new Handler();
      localHandler.removeCallbacks(this.i);
      localHandler.postDelayed(this.i, 1000L);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public final int d()
  {
    try
    {
      MediaPlayer localMediaPlayer = this.a;
      int j = 0;
      if (localMediaPlayer != null)
      {
        int k = this.a.getCurrentPosition();
        j = k;
      }
      return j;
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
    File localFile = new File(z.c + File.separator + "temp.hj");
    if (localFile.exists())
      localFile.delete();
    if (this.a != null)
    {
      this.a.stop();
      this.a.release();
    }
  }

  public final void h()
  {
    new Thread(new m(this)).start();
  }

  public final long i()
  {
    return this.e;
  }

  public final void j()
  {
    this.f = true;
  }

  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.g != null)
      this.g.h();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     g:    0.6.2
 */