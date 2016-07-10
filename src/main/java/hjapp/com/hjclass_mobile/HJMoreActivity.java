package hjapp.com.hjclass_mobile;

import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HJMoreActivity extends BaseActivity
{
  AdapterView.OnItemClickListener a = new cj(this);
  private List b = new ArrayList();
  private hjapp.com.hjclass_mobile.pkg_b.u c = null;
  private ProgressDialog d = null;
  private ListView e;

  public final void b()
  {
    Builder localBuilder = new Builder(this);
    localBuilder.setMessage(getString(2131492958));
    localBuilder.setPositiveButton(getString(2131492879), new ch(this));
    localBuilder.setNeutralButton(getString(2131492880), new ci(this));
    localBuilder.create().show();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903098);
    this.e = ((ListView)findViewById(2131362007));
    this.e.setCacheColorHint(0);
    this.e.setOnItemClickListener(this.a);
    hjapp.com.hjclass_mobile.pkg_d.v localv1 = new pkg_d.v();
    if (h.z.j)
      localv1.a(getString(2131492964));
    while (true)
    {
      localv1.b(c.c());
      localv1.a(2130837676);
      this.b.add(localv1);
      hjapp.com.hjclass_mobile.pkg_d.v localv2 = new pkg_d.v();
      localv2.a(getString(2131492962));
      localv2.a(2130837680);
      this.b.add(localv2);
      hjapp.com.hjclass_mobile.pkg_d.v localv3 = new pkg_d.v();
      localv3.a(getString(2131492984));
      localv3.a(2130837692);
      this.b.add(localv3);
      hjapp.com.hjclass_mobile.pkg_d.v localv4 = new pkg_d.v();
      localv4.a(getString(2131493096));
      localv4.a(2130837689);
      this.b.add(localv4);
      hjapp.com.hjclass_mobile.pkg_d.v localv5 = new pkg_d.v();
      localv5.a(getString(2131493129));
      localv5.a(2130837684);
      this.b.add(localv5);
      hjapp.com.hjclass_mobile.pkg_d.v localv6 = new pkg_d.v();
      localv6.a(getString(2131493040));
      localv6.a(2130837691);
      this.b.add(localv6);
      hjapp.com.hjclass_mobile.pkg_d.v localv7 = new pkg_d.v();
      localv7.a(getString(2131492945));
      localv7.a(2130837675);
      this.b.add(localv7);
      hjapp.com.hjclass_mobile.pkg_d.v localv8 = new pkg_d.v();
      localv8.a(getString(2131493181));
      localv8.a(2130837683);
      this.b.add(localv8);
      hjapp.com.hjclass_mobile.pkg_d.v localv9 = new pkg_d.v();
      localv9.a(getString(2131492955));
      localv9.a(2130837690);
      this.b.add(localv9);
      this.c = new pkg_b.u(this, this.b);
      this.e.setAdapter(this.c);
      h.z.a(this);
      return;
      localv1.a(getString(2131492963));
    }
  }

  protected void onDestroy()
  {
    h.z.b(this);
    super.onDestroy();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      a();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJMoreActivity
 * JD-Core Version:    0.6.2
 */