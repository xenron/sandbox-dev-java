package hjapp.com.hjclass_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class HJSubDownloadTabActivity extends BaseTabActivity
  implements OnClickListener, OnCheckedChangeListener
{
  private TabHost a;
  private Intent b;
  private Intent c;
  private RadioButton d;
  private RadioButton e;

  private TabSpec a(String paramString, int paramInt1, int paramInt2, Intent paramIntent)
  {
    return this.a.newTabSpec(paramString).setIndicator(getString(paramInt1), getResources().getDrawable(paramInt2)).setContent(paramIntent);
  }

  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      switch (paramCompoundButton.getId())
      {
      default:
        return;
      case 2131362068:
        this.a.setCurrentTabByTag("downing_tab");
        this.d.setTextColor(-1);
        return;
      case 2131362069:
      }
      this.a.setCurrentTabByTag("downed_tab");
      this.e.setTextColor(-1);
      return;
    }
    switch (paramCompoundButton.getId())
    {
    default:
      return;
    case 2131362068:
      this.d.setTextColor(-16777216);
      return;
    case 2131362069:
    }
    this.e.setTextColor(-16777216);
  }

  public void onClick(View paramView)
  {
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903125);
    h.z.a(this);
    this.b = new Intent(this, HJDownloadActivity.class);
    this.c = new Intent(this, HJDownloadCompleteListActivity.class);
    this.d = ((RadioButton)findViewById(2131362068));
    this.d.setOnCheckedChangeListener(this);
    this.e = ((RadioButton)findViewById(2131362069));
    this.e.setOnCheckedChangeListener(this);
    ((Button)findViewById(2131361816)).setOnClickListener(this);
    this.a = getTabHost();
    TabHost localTabHost = this.a;
    localTabHost.addTab(a("downing_tab", 2131492908, 2130837681, this.b));
    localTabHost.addTab(a("downed_tab", 2131492907, 2130837677, this.c));
  }

  protected void onDestroy()
  {
    super.onDestroy();
    h.z.b(this);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJSubDownloadTabActivity
 * JD-Core Version:    0.6.2
 */