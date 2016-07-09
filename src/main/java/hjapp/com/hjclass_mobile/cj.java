package hjapp.com.hjclass_mobile;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import hjapp.com.umeng.fb.UMFeedbackService;
import java.util.Iterator;

final class cj
  implements OnItemClickListener
{
  cj(HJMoreActivity paramHJMoreActivity)
  {
  }

  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Intent localIntent1 = new Intent();
    switch (Integer.valueOf(paramInt).intValue())
    {
    default:
      return;
    case 0:
      if (!h.z.j)
      {
        localIntent1.setClass(this.a, HJLoginActivity.class);
        localIntent1.putExtra("type", "switcher");
        this.a.startActivity(localIntent1);
        this.a.finish();
        return;
      }
      this.a.b();
      return;
    case 1:
      localIntent1.setClass(this.a, HJSubDownloadTabActivity.class);
      this.a.startActivity(localIntent1);
      return;
    case 2:
      localIntent1.setClass(this.a, HJSettingActivity.class);
      this.a.startActivity(localIntent1);
      return;
    case 3:
      localIntent1.setClass(this.a, HJAlipayActivity.class);
      this.a.startActivity(localIntent1);
      return;
    case 4:
      localIntent1.setClass(this.a, HJStudyCardActivity.class);
      this.a.startActivity(localIntent1);
      return;
    case 5:
      localIntent1.setClass(this.a, HJAppActivity.class);
      this.a.startActivity(localIntent1);
      return;
    case 6:
      localIntent1.setClass(this.a, AboutActivity.class);
      this.a.startActivity(localIntent1);
      return;
    case 7:
      UMFeedbackService.setGoBackButtonVisible();
      UMFeedbackService.setFeedBackListener(new ck(this));
      UMFeedbackService.openUmengFeedbackSDK(this.a);
      return;
    case 8:
    }
    Iterator localIterator = h.z.g.iterator();
    while (localIterator.hasNext())
      ((Activity)localIterator.next()).finish();
    Intent localIntent2 = ((HJApplication)this.a.getApplicationContext()).c();
    if (localIntent2 != null)
      this.a.stopService(localIntent2);
    this.a.finish();
    h.z.a();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     cj
 * JD-Core Version:    0.6.2
 */