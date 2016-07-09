package hjapp.com.hjclass_mobile.view.ele;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import java.io.FileInputStream;

public final class ab
{
  private MediaPlayer a = null;
  private FileInputStream b = null;
  private Boolean c = Boolean.valueOf(false);

  public ab(OnCompletionListener paramOnCompletionListener)
  {
    this.a.setOnCompletionListener(paramOnCompletionListener);
    this.a.setAudioStreamType(3);
  }

  public final void a(int paramInt)
  {
    if (this.a != null)
      this.a.seekTo(paramInt);
  }

  // ERROR //
  public final void a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 51	java/io/FileInputStream
    //   4: dup
    //   5: aload_1
    //   6: invokespecial 53	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   9: putfield 19	com/hjclass_mobile/view/ele/ab:b	Ljava/io/FileInputStream;
    //   12: aload_0
    //   13: getfield 17	com/hjclass_mobile/view/ele/ab:a	Landroid/media/MediaPlayer;
    //   16: aload_0
    //   17: getfield 19	com/hjclass_mobile/view/ele/ab:b	Ljava/io/FileInputStream;
    //   20: invokevirtual 57	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   23: invokevirtual 61	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   26: aload_0
    //   27: getfield 17	com/hjclass_mobile/view/ele/ab:a	Landroid/media/MediaPlayer;
    //   30: invokevirtual 64	android/media/MediaPlayer:prepare	()V
    //   33: return
    //   34: astore 6
    //   36: aload 6
    //   38: invokevirtual 67	java/lang/IllegalArgumentException:printStackTrace	()V
    //   41: return
    //   42: astore_2
    //   43: aload_2
    //   44: invokevirtual 68	java/lang/Exception:printStackTrace	()V
    //   47: return
    //   48: astore 5
    //   50: aload 5
    //   52: invokevirtual 69	java/lang/IllegalStateException:printStackTrace	()V
    //   55: return
    //   56: astore_3
    //   57: aload_3
    //   58: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   61: ldc 72
    //   63: aload_3
    //   64: invokevirtual 76	java/io/IOException:toString	()Ljava/lang/String;
    //   67: invokestatic 82	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   70: pop
    //   71: return
    //
    // Exception table:
    //   from	to	target	type
    //   12	33	34	java/lang/IllegalArgumentException
    //   0	12	42	java/lang/Exception
    //   12	33	42	java/lang/Exception
    //   36	41	42	java/lang/Exception
    //   50	55	42	java/lang/Exception
    //   57	71	42	java/lang/Exception
    //   12	33	48	java/lang/IllegalStateException
    //   12	33	56	java/io/IOException
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

  public final boolean b()
  {
    return this.c.booleanValue();
  }

  public final int c()
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
      localException.printStackTrace();
    }
    return 0;
  }

  public final void e()
  {
    if (this.a != null)
    {
      this.a.pause();
      this.c = Boolean.valueOf(true);
    }
  }

  public final void f()
  {
    if (this.a != null)
    {
      this.a.start();
      this.c = Boolean.valueOf(false);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ab
 * JD-Core Version:    0.6.2
 */