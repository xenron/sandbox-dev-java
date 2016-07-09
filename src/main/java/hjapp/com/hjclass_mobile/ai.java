package hjapp.com.hjclass_mobile;

import android.telephony.PhoneStateListener;

public final class ai extends PhoneStateListener
{
  private boolean b = false;

  public ai(HJClassPlayerV3 paramHJClassPlayerV3)
  {
  }

  public final void onCallStateChanged(int paramInt, String paramString)
  {
    super.onCallStateChanged(paramInt, paramString);
    if (paramInt == 0);
    try
    {
      if ((!this.b) || (HJClassPlayerV3.d(this.a) == null) || (HJClassPlayerV3.d(this.a).d() == -1))
        return;
      this.b = false;
      HJClassPlayerV3.c(this.a).d();
      HJClassPlayerV3.d(this.a).f();
      return;
      if (paramInt == 2)
      {
        if ((HJClassPlayerV3.d(this.a) == null) || (!HJClassPlayerV3.d(this.a).a()))
          return;
        this.b = true;
        HJClassPlayerV3.c(this.a).d();
        HJClassPlayerV3.d(this.a).e();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    if ((paramInt == 1) && (HJClassPlayerV3.d(this.a) != null) && (HJClassPlayerV3.d(this.a).a()))
    {
      this.b = true;
      HJClassPlayerV3.c(this.a).d();
      HJClassPlayerV3.d(this.a).e();
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ai
 * JD-Core Version:    0.6.2
 */