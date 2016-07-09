package hjapp.com.umeng.fb.util;

import android.app.Activity;
import java.util.Map;

public abstract interface FeedBackListener
{
  public abstract void onResetFB(Activity paramActivity, Map paramMap1, Map paramMap2);

  public abstract void onSubmitFB(Activity paramActivity);
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     FeedBackListener
 * JD-Core Version:    0.6.2
 */