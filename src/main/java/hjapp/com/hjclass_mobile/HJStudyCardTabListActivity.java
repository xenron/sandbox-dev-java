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
import android.widget.TextView;
import hjapp.com.hjclass_mobile.d.w;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HJStudyCardTabListActivity extends BaseTabActivity
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
  private List j = new ArrayList();

  private TabSpec a(String paramString, int paramInt, Intent paramIntent)
  {
    return this.a.newTabSpec(paramString).setIndicator(getString(paramInt), getResources().getDrawable(2130837677)).setContent(paramIntent);
  }

  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      switch (paramCompoundButton.getId())
      {
      default:
        return;
      case 2131362078:
        this.a.setCurrentTabByTag("en_course");
        this.f.setTextColor(-1);
        return;
      case 2131362079:
        this.a.setCurrentTabByTag("jp_course");
        this.g.setTextColor(-1);
        return;
      case 2131362080:
        this.a.setCurrentTabByTag("fr_course");
        this.h.setTextColor(-1);
        return;
      case 2131362081:
      }
      this.a.setCurrentTabByTag("kr_course");
      this.i.setTextColor(-1);
      return;
    }
    switch (paramCompoundButton.getId())
    {
    default:
      return;
    case 2131362078:
      this.f.setTextColor(-16777216);
      return;
    case 2131362079:
      this.g.setTextColor(-16777216);
      return;
    case 2131362080:
      this.h.setTextColor(-16777216);
      return;
    case 2131362081:
    }
    this.i.setTextColor(-16777216);
  }

  public void onClick(View paramView)
  {
    paramView.getId();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!hjapp.com.hjclass_mobile.h.z.j)
    {
      Intent localIntent = new Intent();
      localIntent.setClass(this, HJLoginActivity.class);
      localIntent.putExtra("type", "switcher");
      startActivity(localIntent);
      finish();
    }
    setContentView(2130903127);
    Button localButton = (Button)findViewById(2131362077);
    localButton.setOnClickListener(this);
    localButton.setVisibility(4);
    ((TextView)findViewById(2131362066)).setText(2131493129);
    this.j = ((List)getIntent().getExtras().getSerializable("list"));
    hjapp.com.hjclass_mobile.h.u.a("获取到传递来的数据个数：", this.j.size());
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    int k = 0;
    if (k < this.j.size())
    {
      w localw = (w)this.j.get(k);
      String str = localw.i();
      if (str.equals("en"))
        localArrayList1.add(localw);
      while (true)
      {
        k++;
        break;
        if (str.equals("jp"))
          localArrayList2.add(localw);
        else if (str.equals("fr"))
          localArrayList3.add(localw);
        else if (str.equals("kr"))
          localArrayList4.add(localw);
      }
    }
    hjapp.com.hjclass_mobile.h.z.a(this);
    this.b = new Intent(this, HJStudyCardSubCourseActivity.class);
    Bundle localBundle1 = new Bundle();
    localBundle1.putSerializable("list", (Serializable)localArrayList1);
    this.b.putExtras(localBundle1);
    this.c = new Intent(this, HJStudyCardSubCourseActivity.class);
    Bundle localBundle2 = new Bundle();
    localBundle2.putSerializable("list", (Serializable)localArrayList2);
    this.c.putExtras(localBundle2);
    this.d = new Intent(this, HJStudyCardSubCourseActivity.class);
    Bundle localBundle3 = new Bundle();
    localBundle3.putSerializable("list", (Serializable)localArrayList3);
    this.d.putExtras(localBundle3);
    this.e = new Intent(this, HJStudyCardSubCourseActivity.class);
    Bundle localBundle4 = new Bundle();
    localBundle4.putSerializable("list", (Serializable)localArrayList4);
    this.e.putExtras(localBundle4);
    this.f = ((RadioButton)findViewById(2131362078));
    this.f.setOnCheckedChangeListener(this);
    this.g = ((RadioButton)findViewById(2131362079));
    this.g.setOnCheckedChangeListener(this);
    this.h = ((RadioButton)findViewById(2131362080));
    this.h.setOnCheckedChangeListener(this);
    this.i = ((RadioButton)findViewById(2131362081));
    this.i.setOnCheckedChangeListener(this);
    this.a = getTabHost();
    TabHost localTabHost = this.a;
    localTabHost.addTab(a("en_course", 2131493007, this.b));
    localTabHost.addTab(a("jp_course", 2131493008, this.c));
    localTabHost.addTab(a("fr_course", 2131493009, this.d));
    localTabHost.addTab(a("kr_course", 2131493010, this.e));
  }

  protected void onDestroy()
  {
    super.onDestroy();
    hjapp.com.hjclass_mobile.h.z.b(this);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJStudyCardTabListActivity
 * JD-Core Version:    0.6.2
 */