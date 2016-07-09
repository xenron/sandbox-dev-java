package hjapp.com.hjclass_mobile;

import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends BaseActivity
{
  private TextView a;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h.z.a(this);
    setContentView(2130903040);
    this.a = ((TextView)findViewById(2131361797));
    try
    {
      String str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
      this.a.setText(getString(2131493028) + str);
      return;
    }
    catch (NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
  }

  protected void onDestroy()
  {
    h.z.b(this);
    super.onDestroy();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     AboutActivity
 * JD-Core Version:    0.6.2
 */