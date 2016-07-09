package hjapp.com.hjclass_mobile.view.ele;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.VideoView;

import java.io.IOException;

public final class ak
{
  private Boolean a = Boolean.valueOf(false);
  private VideoView b = null;
  private int c;
  private int d = 0;
  private int e = 0;

  public ak(VideoView paramVideoView, OnCompletionListener paramOnCompletionListener)
  {
    this.b = paramVideoView;
    this.b.requestFocus();
    this.b.setOnCompletionListener(paramOnCompletionListener);
  }

  public final int a(hjapp.com.hjclass_mobile.b.a parama)
  {
    if (this.e > 0)
      return this.e;
    int i = this.c;
    int j = this.d;
    if (parama.a() / i > parama.b() / j);
    for (float f = 1.0F * (parama.a() / i); ; f = 1.0F * (parama.b() / j))
    {
      int k = (int)(f * i);
      this.e = ((int)(0.5D * (parama.a() - k)));
      return this.e;
    }
  }

  public final void a(String paramString)
  {
    MediaPlayer localMediaPlayer = new MediaPlayer();
    try
    {
      localMediaPlayer.setDataSource(paramString);
      localMediaPlayer.prepare();
      localMediaPlayer.start();
      this.c = localMediaPlayer.getVideoWidth();
      this.d = localMediaPlayer.getVideoHeight();
      localMediaPlayer.stop();
      this.b.setVideoPath(paramString);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        localIllegalArgumentException.printStackTrace();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      while (true)
        localIllegalStateException.printStackTrace();
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
  }

  public final boolean a()
  {
    return this.b.isPlaying();
  }

  public final boolean b()
  {
    return this.a.booleanValue();
  }

  public final void c()
  {
    if (this.b != null);
    try
    {
      this.b.stopPlayback();
      this.a = Boolean.valueOf(false);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public final void d()
  {
    if (this.b != null)
    {
      this.b.pause();
      this.a = Boolean.valueOf(true);
    }
  }

  public final void e()
  {
    if (this.b != null)
    {
      this.b.start();
      this.a = Boolean.valueOf(false);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ak
 * JD-Core Version:    0.6.2
 */