package hjapp.com.hjclass_mobile.g;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import hjapp.com.hjclass_mobile.c.u;
import hjapp.com.hjclass_mobile.c.v;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class b
  implements OnCompletionListener, OnPreparedListener, u
{
  protected MediaPlayer a;
  private String b = null;
  private String c = null;
  private String d = null;
  private v e = null;
  private Boolean f = Boolean.valueOf(false);
  private Boolean g = Boolean.valueOf(false);
  private Context h = null;
  private Handler i = new Handler();
  private Runnable j = new c(this);

  public b(Context paramContext)
  {
    this.h = paramContext;
  }

  public final void a(v paramv)
  {
    this.e = paramv;
  }

  public final void a(Boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public final void a(String paramString)
  {
    if (this.g.booleanValue())
      hjapp.com.hjclass_mobile.h.u.b("已经停止");
    File localFile;
    do
    {
      do
      {
        do
        {
          return;
          if (paramString != null)
            break;
        }
        while (this.e == null);
        this.e.t();
        return;
        if (!paramString.equals("piracy_info"))
          break;
      }
      while (this.e == null);
      this.e.w();
      return;
      localFile = new File(paramString);
    }
    while (!localFile.exists());
    while (true)
    {
      MediaPlayer localMediaPlayer;
      FileInputStream localFileInputStream;
      try
      {
        localMediaPlayer = new MediaPlayer();
        localMediaPlayer.setOnCompletionListener(this);
        localMediaPlayer.setAudioStreamType(3);
        localMediaPlayer.setOnPreparedListener(this);
        localMediaPlayer.setOnErrorListener(new d(this));
        localFileInputStream = new FileInputStream(localFile);
        if (!this.f.booleanValue())
          break label211;
        localMediaPlayer.setDataSource(localFileInputStream.getFD(), 2012L, localFile.length());
        localMediaPlayer.prepare();
        this.a = localMediaPlayer;
        this.a.start();
        e locale = new e(this);
        this.i.post(locale);
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
      if (this.e == null)
        break;
      this.e.t();
      return;
      label211: localMediaPlayer.setDataSource(localFileInputStream.getFD(), 2112001L, localFile.length());
    }
  }

  protected final void a(String paramString1, String paramString2, String paramString3)
  {
    this.g = Boolean.valueOf(false);
    this.b = paramString1.replace(".dat", ".hjmp3");
    this.c = paramString2;
    this.d = paramString3;
    o localo = new o(this.h);
    localo.a(this);
    if (this.f.booleanValue())
    {
      String[] arrayOfString2 = new String[4];
      arrayOfString2[0] = paramString2;
      arrayOfString2[1] = paramString3;
      arrayOfString2[2] = this.b;
      arrayOfString2[3] = "false";
      localo.execute(arrayOfString2);
      return;
    }
    String[] arrayOfString1 = new String[4];
    arrayOfString1[0] = paramString2;
    arrayOfString1[1] = paramString3;
    arrayOfString1[2] = this.b;
    arrayOfString1[3] = "true";
    localo.execute(arrayOfString1);
  }

  protected final void k()
  {
    this.g = Boolean.valueOf(true);
    if (this.a != null);
    try
    {
      this.a.pause();
      Handler localHandler = new Handler();
      localHandler.removeCallbacks(this.j);
      localHandler.postDelayed(this.j, 1000L);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public final v l()
  {
    return this.e;
  }

  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.e != null)
      this.e.s();
  }

  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     g:    0.6.2
 */