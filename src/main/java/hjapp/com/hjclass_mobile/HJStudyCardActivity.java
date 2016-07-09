package hjapp.com.hjclass_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class HJStudyCardActivity extends BaseActivity
{
  private EditText a;
  private ProgressBar b;
  private LinearLayout c;
  private Button d;
  private LinearLayout e;
  private TextView f;
  private Button g;
  private boolean h = false;
  private String i = "";

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!hjapp.com.hjclass_mobile.h.z.j)
    {
      Intent localIntent = new Intent();
      localIntent.setClass(this, HJLoginActivity.class);
      localIntent.putExtra("type", "switcher");
      localIntent.putExtra("isFromStudyCard", true);
      startActivity(localIntent);
      finish();
    }
    if (!hjapp.com.hjclass_mobile.h.z.h)
      Toast.makeText(this, 2131492921, 0).show();
    setContentView(2130903139);
    this.a = ((EditText)findViewById(2131362120));
    String str = hjapp.com.hjclass_mobile.h.z.d(this);
    if (!hjapp.com.hjclass_mobile.h.y.c(str))
      this.a.setText(str);
    this.b = ((ProgressBar)findViewById(2131362121));
    this.c = ((LinearLayout)findViewById(2131362122));
    this.d = ((Button)findViewById(2131362123));
    this.e = ((LinearLayout)findViewById(2131362124));
    this.f = ((TextView)findViewById(2131362125));
    this.g = ((Button)findViewById(2131362126));
    this.a.addTextChangedListener(new cy(this));
    this.d.setOnClickListener(new cz(this));
    this.g.setOnClickListener(new da(this));
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJStudyCardActivity
 * JD-Core Version:    0.6.2
 */