package hjapp.com.hjclass_mobile;

import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import hjapp.com.hjclass_mobile.pkg_b.b;
import hjapp.com.hjclass_mobile.pkg_b.w;
import hjapp.com.hjclass_mobile.pkg_d.r;

public class HJUrlScheme extends BaseActivity
{
  private b a = null;
  private r b = null;
  private ds c = null;
  private HJApplication d = null;
  private String e;

  private void a(boolean paramBoolean)
  {
    new Handler().post(new dr(this, paramBoolean));
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
    h.z.b();
    h.z.c();
    this.d = ((HJApplication)getApplicationContext());
    this.a = new b(this);
    this.d.a(this.a.e(1));
    this.b = this.a.b();
    if (this.b != null)
    {
      if ((this.c != null) && (this.c.getStatus() == AsyncTask.Status.RUNNING))
        this.c.cancel(true);
      this.c = new ds(this, (byte)0);
      this.d.a(this.a.e(this.b.a()));
      if (!TextUtils.isEmpty(this.b.d().trim()))
      {
        this.e = this.b.d().trim();
        String str1 = h.z.b(this.b.d());
        String str2 = this.b.e();
        ds localds = this.c;
        String[] arrayOfString3 = new String[3];
        arrayOfString3[0] = str2;
        arrayOfString3[1] = str1;
        arrayOfString3[2] = this.b.b();
        localds.execute(arrayOfString3);
        return;
      }
      w localw2 = new w();
      String[] arrayOfString2 = new String[4];
      arrayOfString2[0] = this.b.e();
      arrayOfString2[1] = this.b.a();
      arrayOfString2[2] = c();
      arrayOfString2[3] = b();
      localw2.execute(arrayOfString2);
      a(true);
      return;
    }
    w localw1 = new w();
    String[] arrayOfString1 = new String[4];
    arrayOfString1[0] = null;
    arrayOfString1[1] = null;
    arrayOfString1[2] = c();
    arrayOfString1[3] = b();
    localw1.execute(arrayOfString1);
    a(true);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJUrlScheme
 * JD-Core Version:    0.6.2
 */