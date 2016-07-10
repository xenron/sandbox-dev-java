package hjapp.com.hjclass_mobile;

import android.graphics.drawable.AnimationDrawable;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import hjapp.com.hjclass_mobile.pkg_d.r;
import hjapp.com.umeng.analytics.MobclickAgent;

public class MainActivity extends BaseActivity
{
  private hjapp.com.hjclass_mobile.pkg_b.b a = null;
  private r b = null;
  private dz c = null;
  private AnimationDrawable d;
  private ImageView e;
  private HJApplication f = null;
  private String g;
  private Handler h = new Handler();
  private Runnable i = new dx(this);

  protected static void a(AnimationDrawable paramAnimationDrawable)
  {
    if ((paramAnimationDrawable != null) && (!paramAnimationDrawable.isRunning()))
      paramAnimationDrawable.run();
  }

  private void a(boolean paramBoolean)
  {
    new Handler().postDelayed(new dy(this, paramBoolean), 1000L);
  }

  protected static String b()
  {
    return Build.MODEL + " " + VERSION.RELEASE;
  }

  private String c()
  {
    return ((WifiManager)getSystemService("wifi")).getConnectionInfo().getMacAddress();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    super.onCreate(paramBundle);
    hjapp.com.hjclass_mobile.h.z.b();
    hjapp.com.hjclass_mobile.h.z.c();
    setContentView(2130903094);
    this.f = ((HJApplication)getApplicationContext());
    this.e = ((ImageView)findViewById(2131361996));
    this.e.setBackgroundResource(2130968576);
    this.d = ((AnimationDrawable)this.e.getBackground());
    this.d.setOneShot(false);
    MobclickAgent.onError(this);
    this.a = new hjapp.com.hjclass_mobile.pkg_b.b(this);
    this.f.a(this.a.e(1));
    this.b = this.a.b();
    if (this.b != null)
    {
      if ((this.c != null) && (this.c.getStatus() == AsyncTask.Status.RUNNING))
        this.c.cancel(true);
      this.c = new dz(this, (byte)0);
      this.f.a(this.a.e(this.b.a()));
      if (!TextUtils.isEmpty(this.b.d().trim()))
      {
        this.g = this.b.d().trim();
        String str1 = hjapp.com.hjclass_mobile.h.z.b(this.b.d());
        String str2 = this.b.e();
        dz localdz = this.c;
        String[] arrayOfString3 = new String[3];
        arrayOfString3[0] = str2;
        arrayOfString3[1] = str1;
        arrayOfString3[2] = this.b.b();
        localdz.execute(arrayOfString3);
        return;
      }
      hjapp.com.hjclass_mobile.pkg_b.w localw2 = new hjapp.com.hjclass_mobile.pkg_b.w();
      String[] arrayOfString2 = new String[4];
      arrayOfString2[0] = this.b.e();
      arrayOfString2[1] = this.b.a();
      arrayOfString2[2] = c();
      arrayOfString2[3] = b();
      localw2.execute(arrayOfString2);
      a(true);
      return;
    }
    hjapp.com.hjclass_mobile.pkg_b.w localw1 = new hjapp.com.hjclass_mobile.pkg_b.w();
    String[] arrayOfString1 = new String[4];
    arrayOfString1[0] = null;
    arrayOfString1[1] = null;
    arrayOfString1[2] = c();
    arrayOfString1[3] = b();
    localw1.execute(arrayOfString1);
    a(true);
  }

  protected void onDestroy()
  {
    if (this.h != null)
      this.h.removeCallbacks(this.i);
    AnimationDrawable localAnimationDrawable = this.d;
    if ((localAnimationDrawable != null) && (localAnimationDrawable.isRunning()))
      localAnimationDrawable.stop();
    super.onDestroy();
  }

  protected void onStart()
  {
    this.h.removeCallbacks(this.i);
    this.h.postDelayed(this.i, 100L);
    super.onStart();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     MainActivity
 * JD-Core Version:    0.6.2
 */