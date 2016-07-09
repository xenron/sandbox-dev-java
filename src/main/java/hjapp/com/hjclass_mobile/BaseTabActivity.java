package hjapp.com.hjclass_mobile;

import android.app.AlertDialog.Builder;
import android.app.TabActivity;
import android.net.NetworkInfo;
import android.os.Bundle;

public class BaseTabActivity extends TabActivity
{
  protected void a()
  {
    Builder localBuilder = new Builder(this);
    localBuilder.setMessage(getString(2131492878));
    localBuilder.setPositiveButton(getString(2131492879), new c(this));
    localBuilder.setNeutralButton(getString(2131492880), new d(this));
    localBuilder.create().show();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    NetworkInfo localNetworkInfo = h.z.a(this);
    if (!h.z.b(this))
      h.z.h = false;
    while (true)
    {
      getWindow().setFormat(1);
      getWindow().addFlags(4096);
      requestWindowFeature(1);
      return;
      h.z.h = true;
      int i = localNetworkInfo.getType();
      boolean bool = false;
      if (i != 1)
        bool = true;
      h.z.i = bool;
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     BaseTabActivity
 * JD-Core Version:    0.6.2
 */