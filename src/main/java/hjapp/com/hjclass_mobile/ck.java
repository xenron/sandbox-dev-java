package hjapp.com.hjclass_mobile;

import android.app.Activity;
import hjapp.com.hjclass_mobile.f.c;
import hjapp.com.umeng.fb.UMFeedbackService;
import hjapp.com.umeng.fb.util.FeedBackListener;
import java.util.HashMap;
import java.util.Map;

final class ck
  implements FeedBackListener
{
  ck(cj paramcj)
  {
  }

  public final void onResetFB(Activity paramActivity, Map paramMap1, Map paramMap2)
  {
  }

  public final void onSubmitFB(Activity paramActivity)
  {
    HashMap localHashMap = new HashMap();
    String str = this.a.a.getResources().getString(2131493182);
    if (h.z.j)
      str = c.c();
    localHashMap.put(this.a.a.getResources().getString(2131493183), str);
    UMFeedbackService.setContactMap(localHashMap);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ck
 * JD-Core Version:    0.6.2
 */