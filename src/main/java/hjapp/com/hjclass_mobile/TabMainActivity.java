package hjapp.com.hjclass_mobile;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabMainActivity extends BaseTabActivity
  implements OnCheckedChangeListener
{
  private TabHost a;
  private Intent b;
  private Intent c;
  private Intent d;
  private Intent e;
  private Intent f;
  private RadioButton g;
  private RadioButton h;
  private RadioButton i;
  private RadioButton j;
  private RadioButton k;
  private eb l = null;

  private TabSpec a(String paramString, Intent paramIntent)
  {
    return this.a.newTabSpec(paramString).setIndicator(getString(2131492864), getResources().getDrawable(2130837687)).setContent(paramIntent);
  }

  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramCompoundButton.getId() != 2131362091) && (paramCompoundButton.getId() != 2131362092));
    for (boolean bool = true; ; bool = false)
    {
      Log.i("===", bool + "===" + hjapp.com.hjclass_mobile.h.z.j);
      if ((paramCompoundButton.getId() == 2131362091) || (paramCompoundButton.getId() == 2131362092) || (hjapp.com.hjclass_mobile.h.z.j))
        break;
      Intent localIntent = new Intent();
      localIntent.setClass(this, HJLoginActivity.class);
      localIntent.putExtra("type", "switcher");
      startActivity(localIntent);
      finish();
      return;
    }
    if (paramBoolean)
    {
      switch (paramCompoundButton.getId())
      {
      default:
        return;
      case 2131362088:
        this.a.setCurrentTabByTag("myclass");
        this.g.setCompoundDrawablesWithIntrinsicBounds(0, 2130837688, 0, 0);
        this.g.setTextColor(-1);
        return;
      case 2131362089:
        this.a.setCurrentTabByTag("feed");
        this.h.setCompoundDrawablesWithIntrinsicBounds(0, 2130837682, 0, 0);
        this.h.setTextColor(-1);
        return;
      case 2131362090:
        this.a.setCurrentTabByTag("study");
        this.i.setCompoundDrawablesWithIntrinsicBounds(0, 2130837679, 0, 0);
        this.i.setTextColor(-1);
        return;
      case 2131362091:
        this.a.setCurrentTabByTag("freelesson");
        this.j.setCompoundDrawablesWithIntrinsicBounds(0, 2130837702, 0, 0);
        this.j.setTextColor(-1);
        return;
      case 2131362092:
      }
      this.a.setCurrentTabByTag("more");
      this.k.setCompoundDrawablesWithIntrinsicBounds(0, 2130837686, 0, 0);
      this.k.setTextColor(-1);
      return;
    }
    switch (paramCompoundButton.getId())
    {
    default:
      return;
    case 2131362088:
      this.g.setCompoundDrawablesWithIntrinsicBounds(0, 2130837687, 0, 0);
      this.g.setTextColor(-13408768);
      return;
    case 2131362089:
      this.h.setCompoundDrawablesWithIntrinsicBounds(0, 2130837681, 0, 0);
      this.h.setTextColor(-13408768);
      return;
    case 2131362090:
      this.i.setCompoundDrawablesWithIntrinsicBounds(0, 2130837677, 0, 0);
      this.i.setTextColor(-13408768);
      return;
    case 2131362091:
      this.j.setCompoundDrawablesWithIntrinsicBounds(0, 2130837701, 0, 0);
      this.j.setTextColor(-13408768);
      return;
    case 2131362092:
    }
    this.k.setCompoundDrawablesWithIntrinsicBounds(0, 2130837685, 0, 0);
    this.k.setTextColor(-13408768);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903128);
    Bundle localBundle = getIntent().getExtras();
    hjapp.com.hjclass_mobile.h.z.a(this);
    if (this.l == null)
    {
      this.l = new eb(this, (byte)0);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("free_lesson_study");
      localIntentFilter.addAction("all_class");
      registerReceiver(this.l, localIntentFilter);
    }
    if (localBundle != null);
    for (boolean bool = localBundle.getString("category").equals("freelesson"); ; bool = false)
    {
      this.b = new Intent(this, HJPersonIndexActivity.class);
      this.c = new Intent(this, HJSubFeedActivity.class);
      this.d = new Intent(this, HJTabCourseActivity.class);
      this.e = new Intent(this, HJFreeLessonListActivity.class);
      this.e.putExtra("mode", "free");
      this.e.putExtra("classname", getString(2131492938));
      this.e.putExtra("classid", 1);
      this.f = new Intent(this, HJMoreActivity.class);
      this.g = ((RadioButton)findViewById(2131362088));
      this.g.setOnCheckedChangeListener(this);
      this.h = ((RadioButton)findViewById(2131362089));
      this.h.setOnCheckedChangeListener(this);
      this.i = ((RadioButton)findViewById(2131362090));
      this.i.setOnCheckedChangeListener(this);
      this.j = ((RadioButton)findViewById(2131362091));
      this.j.setOnCheckedChangeListener(this);
      this.k = ((RadioButton)findViewById(2131362092));
      this.k.setOnCheckedChangeListener(this);
      this.a = getTabHost();
      TabHost localTabHost = this.a;
      localTabHost.addTab(a("myclass", this.b));
      localTabHost.addTab(a("feed", this.c));
      localTabHost.addTab(a("study", this.d));
      localTabHost.addTab(a("freelesson", this.e));
      localTabHost.addTab(a("more", this.f));
      if (bool)
      {
        Log.i("======", "======free");
        this.j.setChecked(true);
        this.j.setCompoundDrawablesWithIntrinsicBounds(0, 2130837702, 0, 0);
        this.j.setTextColor(-1);
        this.a.setCurrentTabByTag("freelesson");
      }
      while (true)
      {
        Intent localIntent = ((HJApplication)getApplicationContext()).c();
        localIntent.setClass(this, DownloadService.class);
        localIntent.setFlags(67108864);
        startService(localIntent);
        return;
        Log.i("======", "======myclass");
        this.g.setChecked(true);
        this.g.setCompoundDrawablesWithIntrinsicBounds(0, 2130837688, 0, 0);
        this.g.setTextColor(-1);
        this.a.setCurrentTabByTag("myclass");
      }
    }
  }

  protected void onDestroy()
  {
    Intent localIntent = ((HJApplication)getApplication()).c();
    if (localIntent != null)
      stopService(localIntent);
    unregisterReceiver(this.l);
    hjapp.com.hjclass_mobile.h.z.b(this);
    super.onDestroy();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     TabMainActivity
 * JD-Core Version:    0.6.2
 */