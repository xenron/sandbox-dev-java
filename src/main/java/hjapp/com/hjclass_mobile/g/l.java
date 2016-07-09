package hjapp.com.hjclass_mobile.g;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.util.Log;

final class l
  implements OnErrorListener
{
  l(h paramh)
  {
  }

  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    Log.e(getClass().getName(), "Error in MediaPlayer: (" + paramInt1 + ") with extra (" + paramInt2 + ")");
    return false;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     g:    0.6.2
 */