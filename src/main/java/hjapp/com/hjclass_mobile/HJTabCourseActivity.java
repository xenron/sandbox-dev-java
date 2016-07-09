package hjapp.com.hjclass_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class HJTabCourseActivity extends BaseTabActivity
  implements TextWatcher, OnClickListener, OnCheckedChangeListener
{
  private TabHost a;
  private Intent b;
  private Intent c;
  private Intent d;
  private Intent e;
  private Intent f;
  private Intent g;
  private Intent h;
  private RadioButton i;
  private RadioButton j;
  private RadioButton k;
  private RadioButton l;
  private RadioButton m;
  private RadioButton n;
  private RadioButton o;
  private Button p;
  private View q = null;
  private EditText r = null;
  private InputMethodManager s;
  private String t = "en";

  private TabSpec a(String paramString, int paramInt, Intent paramIntent)
  {
    return this.a.newTabSpec(paramString).setIndicator(getString(paramInt), getResources().getDrawable(2130837677)).setContent(paramIntent);
  }

  public void afterTextChanged(Editable paramEditable)
  {
    String str = paramEditable.toString();
    Intent localIntent = new Intent();
    localIntent.setAction("search_course");
    localIntent.putExtra("langs", this.t);
    localIntent.putExtra("keyword", str);
    sendBroadcast(localIntent);
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
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
        this.i.setTextColor(-1);
        this.t = "en";
        return;
      case 2131362079:
        this.a.setCurrentTabByTag("jp_course");
        this.j.setTextColor(-1);
        this.t = "jp";
        return;
      case 2131362080:
        this.a.setCurrentTabByTag("fr_course");
        this.k.setTextColor(-1);
        this.t = "fr";
        return;
      case 2131362081:
        this.a.setCurrentTabByTag("kr_course");
        this.l.setTextColor(-1);
        this.t = "kr";
        return;
      case 2131362082:
        this.a.setCurrentTabByTag("interest_course");
        this.n.setTextColor(-1);
        this.t = "interest";
        return;
      case 2131362083:
        this.a.setCurrentTabByTag("wk_course");
        this.o.setTextColor(-1);
        this.t = "wk";
        return;
      case 2131362084:
      }
      this.a.setCurrentTabByTag("k12_course");
      this.m.setTextColor(-1);
      this.t = "k12";
      return;
    }
    switch (paramCompoundButton.getId())
    {
    default:
      return;
    case 2131362078:
      this.i.setTextColor(-16777216);
      return;
    case 2131362079:
      this.j.setTextColor(-16777216);
      return;
    case 2131362080:
      this.k.setTextColor(-16777216);
      return;
    case 2131362081:
      this.l.setTextColor(-16777216);
      return;
    case 2131362082:
      this.n.setTextColor(-16777216);
      return;
    case 2131362083:
      this.o.setTextColor(-16777216);
      return;
    case 2131362084:
    }
    this.m.setTextColor(-16777216);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131362077:
    }
    if (this.q.getVisibility() == 0)
    {
      if (!TextUtils.isEmpty(this.r.getText()))
      {
        this.r.setText("");
        Intent localIntent = new Intent();
        localIntent.setAction("search_course");
        localIntent.putExtra("langs", this.t);
        localIntent.putExtra("keyword", "");
        sendBroadcast(localIntent);
      }
      this.q.setVisibility(8);
      return;
    }
    this.q.setVisibility(0);
    this.r.requestFocus();
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
    this.q = findViewById(2131362085);
    this.r = ((EditText)findViewById(2131362086));
    this.r.addTextChangedListener(this);
    this.s = ((InputMethodManager)getSystemService("input_method"));
    this.r.setOnFocusChangeListener(new dq(this));
    this.p = ((Button)findViewById(2131362077));
    this.p.setOnClickListener(this);
    hjapp.com.hjclass_mobile.h.z.a(this);
    this.b = new Intent(this, HJSubCourseActivity.class);
    this.b.putExtra("langs", "en");
    this.c = new Intent(this, HJSubCourseActivity.class);
    this.c.putExtra("langs", "jp");
    this.d = new Intent(this, HJSubCourseActivity.class);
    this.d.putExtra("langs", "fr");
    this.e = new Intent(this, HJSubCourseActivity.class);
    this.e.putExtra("langs", "kr");
    this.f = new Intent(this, HJSubCourseActivity.class);
    this.f.putExtra("langs", "k12");
    this.g = new Intent(this, HJSubCourseActivity.class);
    this.g.putExtra("langs", "interest");
    this.h = new Intent(this, HJSubCourseActivity.class);
    this.h.putExtra("langs", "career");
    this.i = ((RadioButton)findViewById(2131362078));
    this.i.setOnCheckedChangeListener(this);
    this.j = ((RadioButton)findViewById(2131362079));
    this.j.setOnCheckedChangeListener(this);
    this.k = ((RadioButton)findViewById(2131362080));
    this.k.setOnCheckedChangeListener(this);
    this.l = ((RadioButton)findViewById(2131362081));
    this.l.setOnCheckedChangeListener(this);
    this.o = ((RadioButton)findViewById(2131362083));
    this.o.setOnCheckedChangeListener(this);
    this.n = ((RadioButton)findViewById(2131362082));
    this.n.setOnCheckedChangeListener(this);
    this.m = ((RadioButton)findViewById(2131362084));
    this.m.setOnCheckedChangeListener(this);
    this.a = getTabHost();
    TabHost localTabHost = this.a;
    localTabHost.addTab(a("en_course", 2131493007, this.b));
    localTabHost.addTab(a("jp_course", 2131493008, this.c));
    localTabHost.addTab(a("fr_course", 2131493009, this.d));
    localTabHost.addTab(a("kr_course", 2131493010, this.e));
    localTabHost.addTab(a("interest_course", 2131493010, this.g));
    localTabHost.addTab(a("wk_course", 2131493010, this.h));
    localTabHost.addTab(a("k12_course", 2131493010, this.f));
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
      if (this.q.getVisibility() == 0)
      {
        if (!TextUtils.isEmpty(this.r.getText()))
        {
          this.r.setText("");
          Intent localIntent = new Intent();
          localIntent.setAction("search_course");
          localIntent.putExtra("langs", this.t);
          localIntent.putExtra("keyword", "");
          sendBroadcast(localIntent);
        }
        this.q.setVisibility(8);
      }
      while (true)
      {
        return true;
        a();
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJTabCourseActivity
 * JD-Core Version:    0.6.2
 */