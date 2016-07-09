package hjapp.com.hjclass_mobile;

import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class HJSubFeedActivity extends BaseTabActivity
  implements OnClickListener, OnCheckedChangeListener
{
  private TabHost a;
  private Intent b;
  private Intent c;
  private Intent d;
  private Intent e;
  private RadioButton f;
  private RadioButton g;
  private RadioButton h;
  private RadioButton i;
  private int j = 1;
  private Button k = null;

  private TabSpec a(String paramString, int paramInt1, int paramInt2, Intent paramIntent)
  {
    return this.a.newTabSpec(paramString).setIndicator(getString(paramInt1), getResources().getDrawable(paramInt2)).setContent(paramIntent);
  }

  protected final void a()
  {
    Builder localBuilder = new Builder(this);
    localBuilder.setMessage(getString(2131492878));
    localBuilder.setPositiveButton(getString(2131492879), new do(this));
    localBuilder.setNeutralButton(getString(2131492880), new dp(this));
    localBuilder.create().show();
  }

  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      switch (paramCompoundButton.getId())
      {
      default:
        return;
      case 2131362073:
        this.a.setCurrentTabByTag("all_tab");
        this.i.setTextColor(-1);
        this.j = 1;
        return;
      case 2131362074:
        this.a.setCurrentTabByTag("my_tab");
        this.g.setTextColor(-1);
        this.j = 2;
        return;
      case 2131362075:
        this.a.setCurrentTabByTag("my_table_tab");
        this.h.setTextColor(-1);
        this.j = 3;
        return;
      case 2131362076:
      }
      this.a.setCurrentTabByTag("my_class_tab");
      this.f.setTextColor(-1);
      this.j = 4;
      return;
    }
    switch (paramCompoundButton.getId())
    {
    default:
      return;
    case 2131362073:
      this.i.setTextColor(-16777216);
      return;
    case 2131362074:
      this.g.setTextColor(-16777216);
      return;
    case 2131362075:
      this.h.setTextColor(-16777216);
      return;
    case 2131362076:
    }
    this.f.setTextColor(-16777216);
  }

  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("refresh_feed");
    localIntent.putExtra("type", this.j);
    sendBroadcast(localIntent);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903126);
    hjapp.com.hjclass_mobile.h.z.a(this);
    Log.i("=", "sub feed");
    this.e = new Intent(this, HJFeedActivity.class);
    this.e.putExtra("type", 1);
    this.c = new Intent(this, HJFeedActivity.class);
    this.c.putExtra("type", 2);
    this.d = new Intent(this, HJFeedActivity.class);
    this.d.putExtra("type", 3);
    this.b = new Intent(this, HJFeedActivity.class);
    this.b.putExtra("type", 4);
    this.f = ((RadioButton)findViewById(2131362076));
    this.f.setOnCheckedChangeListener(this);
    this.g = ((RadioButton)findViewById(2131362074));
    this.g.setOnCheckedChangeListener(this);
    this.h = ((RadioButton)findViewById(2131362075));
    this.h.setOnCheckedChangeListener(this);
    this.i = ((RadioButton)findViewById(2131362073));
    this.i.setOnCheckedChangeListener(this);
    this.a = getTabHost();
    TabHost localTabHost = this.a;
    localTabHost.addTab(a("all_tab", 2131492900, 2130837681, this.e));
    localTabHost.addTab(a("my_tab", 2131492899, 2130837677, this.c));
    localTabHost.addTab(a("my_table_tab", 2131492901, 2130837675, this.d));
    localTabHost.addTab(a("my_class_tab", 2131492902, 2130837525, this.b));
    this.k = ((Button)findViewById(2131362072));
    this.k.setOnClickListener(this);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    hjapp.com.hjclass_mobile.h.z.b(this);
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
 * Qualified Name:     HJSubFeedActivity
 * JD-Core Version:    0.6.2
 */