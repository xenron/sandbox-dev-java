package hjapp.com.hjclass_mobile;

import hjapp.com.hjclass_mobile.f.c;

final class cx
  implements Runnable
{
  cx(HJSettingActivity paramHJSettingActivity)
  {
  }

  public final void run()
  {
    HJSettingActivity.a(this.a).i(c.b(), 2);
    HJSettingActivity.a(this.a).i(1, 2);
    HJSettingActivity.a(this.a).g(c.b());
    HJSettingActivity.a(this.a).g(1);
    ((HJApplication)this.a.getApplicationContext()).a(HJSettingActivity.a(this.a).e(c.b()));
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     cx
 * JD-Core Version:    0.6.2
 */