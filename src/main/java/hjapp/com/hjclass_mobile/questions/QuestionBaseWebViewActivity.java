package hjapp.com.hjclass_mobile.questions;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextWatcher;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import hjapp.com.hjclass_mobile.BaseActivity;

public class QuestionBaseWebViewActivity extends BaseActivity
{
  protected TextView a;
  protected EditText b;
  protected Button c;
  protected String d;
  protected Handler e = new c(this);
  private Button f;
  private Button g;
  private WebView h;
  private LinearLayout i;
  private LinearLayout j;
  private TextWatcher k = new d(this);
  private View.OnClickListener l = new e(this);
  private View.OnClickListener m = new f(this);

  protected a a(Handler paramHandler)
  {
    return new a(paramHandler, this);
  }

  protected final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.j.setVisibility(0);
      return;
    }
    this.j.setVisibility(8);
  }

  protected final void b()
  {
    this.h.loadUrl(this.d);
  }

  protected View.OnClickListener c()
  {
    return null;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903112);
    this.i = ((LinearLayout)findViewById(2131361875));
    this.j = ((LinearLayout)findViewById(2131362038));
    this.f = ((Button)findViewById(2131362033));
    this.g = ((Button)findViewById(2131362036));
    this.c = ((Button)findViewById(2131362040));
    this.h = ((WebView)findViewById(2131362037));
    this.b = ((EditText)findViewById(2131362039));
    this.a = ((TextView)findViewById(2131361849));
    this.b.clearFocus();
    this.d = getIntent().getStringExtra("url");
    a(getIntent().getBooleanExtra("setPostAreaVisibility", false));
    this.b.addTextChangedListener(this.k);
    this.g.setOnClickListener(this.l);
    this.f.setOnClickListener(this.m);
    this.c.setOnClickListener(c());
    WebSettings localWebSettings = this.h.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setDefaultTextEncodingName("UTF-8");
    this.h.setFocusableInTouchMode(true);
    this.h.setScrollBarStyle(0);
    this.h.setWebViewClient(a(this.e));
    b();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     QuestionBaseWebViewActivity
 * JD-Core Version:    0.6.2
 */