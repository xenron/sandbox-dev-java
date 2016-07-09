package hjapp.com.hjclass_mobile;

import android.telephony.PhoneStateListener;

public final class y extends PhoneStateListener
{
  public y(HJClassPlayer paramHJClassPlayer)
  {
  }

  public final void onCallStateChanged(int paramInt, String paramString)
  {
    super.onCallStateChanged(paramInt, paramString);
    if (paramInt == 0);
    try
    {
      if ((!HJClassPlayer.b(this.a)) || (HJClassPlayer.c(this.a) == null) || (HJClassPlayer.c(this.a).d() == -1))
        return;
      HJClassPlayer.a(this.a, false);
      HJClassPlayer.d(this.a).c();
      HJClassPlayer.c(this.a).f();
      return;
      if (paramInt == 2)
      {
        if ((HJClassPlayer.c(this.a) == null) || (!HJClassPlayer.c(this.a).a()))
          return;
        HJClassPlayer.a(this.a, true);
        HJClassPlayer.d(this.a).c();
        HJClassPlayer.c(this.a).e();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    if ((paramInt == 1) && (HJClassPlayer.c(this.a) != null) && (HJClassPlayer.c(this.a).a()))
    {
      HJClassPlayer.a(this.a, true);
      HJClassPlayer.d(this.a).c();
      HJClassPlayer.c(this.a).e();
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     y
 * JD-Core Version:    0.6.2
 */