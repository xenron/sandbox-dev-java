package hjapp.com.hjclass_mobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import hjapp.com.hjclass_mobile.b.b;
import hjapp.com.hjclass_mobile.d.r;

public class HJLoginActivity extends BaseActivity
  implements OnClickListener
{
  private EditText a;
  private EditText b;
  private cg c = null;
  private r d = null;
  private boolean e = false;
  private b f = null;
  private String g;
  private String h;
  private String i = "";
  private ProgressDialog j = null;
  private HJApplication k = null;
  private boolean l = false;

  private void c()
  {
    hjapp.com.hjclass_mobile.h.z.j = true;
    Intent localIntent1 = new Intent();
    Log.e("是否来自学习卡", this.l);
    if (this.l)
    {
      localIntent1.setClass(this, HJStudyCardActivity.class);
      Intent localIntent2 = new Intent();
      localIntent2.setAction("com.hjclass.action.updatexb");
      sendBroadcast(localIntent2);
    }
    while (true)
    {
      startActivity(localIntent1);
      finish();
      return;
      localIntent1.setClass(this, TabMainActivity.class);
      localIntent1.putExtra("category", "myclass");
    }
  }

  public final String b()
  {
    return this.h;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 777))
    {
      Bundle localBundle = paramIntent.getExtras();
      if (localBundle != null)
        this.a.setText(localBundle.getString("reg_username"));
    }
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
    case 2131361994:
    case 2131361816:
    case 2131361995:
    case 2131361993:
    }
    do
    {
      return;
      hjapp.com.hjclass_mobile.h.z.j = false;
      Intent localIntent = new Intent();
      localIntent.setClass(this, TabMainActivity.class);
      localIntent.putExtra("category", "freelesson");
      startActivity(localIntent);
      return;
      a();
      return;
      startActivityForResult(new Intent(this, RegisterActivity.class), 777);
      return;
      if (TextUtils.isEmpty(this.a.getText().toString()))
      {
        Toast.makeText(this, getString(2131492870), 0).show();
        return;
      }
      if (TextUtils.isEmpty(this.b.getText().toString()))
      {
        Toast.makeText(this, getString(2131492871), 0).show();
        return;
      }
    }
    while (this.e);
    if ((this.c != null) && (this.c.getStatus() == AsyncTask.Status.RUNNING))
      this.c.cancel(true);
    this.e = true;
    this.c = new cg(this);
    String str1 = this.b.getText().toString().trim();
    this.h = str1;
    String str2 = hjapp.com.hjclass_mobile.h.z.b(str1);
    String str3 = this.a.getText().toString().trim();
    this.g = str3;
    cg localcg = this.c;
    String[] arrayOfString = new String[4];
    arrayOfString[0] = str3;
    arrayOfString[1] = str2;
    arrayOfString[2] = this.i;
    arrayOfString[3] = Build.MODEL;
    localcg.execute(arrayOfString);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    hjapp.com.hjclass_mobile.h.z.a(this);
    hjapp.com.hjclass_mobile.h.z.j = false;
    this.k = ((HJApplication)getApplicationContext());
    setContentView(2130903093);
    this.f = new b(this);
    this.a = ((EditText)findViewById(2131361991));
    this.b = ((EditText)findViewById(2131361992));
    Button localButton = (Button)findViewById(2131361995);
    ((Button)findViewById(2131361993)).setOnClickListener(this);
    localButton.setOnClickListener(this);
    this.d = this.f.b();
    ((Button)findViewById(2131361994)).setOnClickListener(this);
    this.l = getIntent().getBooleanExtra("isFromStudyCard", false);
    Log.e("onCreate中获取的isFromStudyCard", this.l);
    Bundle localBundle = getIntent().getExtras();
    if (this.d != null)
    {
      this.a.setText(this.d.e());
      this.b.setText(this.d.d());
      this.i = this.d.b();
      this.k.a(this.f.e(this.d.a()));
      if ((localBundle != null) && (localBundle.getString("type").equals("switcher")))
      {
        if (this.f != null)
          this.f.c(c.b());
        this.b.setText("");
      }
    }
    do
    {
      do
      {
        return;
        c.b(this.d.b());
        c.a(this.d.a());
        c.c(this.d.e());
        c();
        return;
        if (localBundle == null)
          break;
      }
      while (!localBundle.getString("type").equals("switcher"));
      if (this.f != null)
        this.f.c(c.b());
      this.b.setText("");
      return;
    }
    while ((this.d == null) || (hjapp.com.hjclass_mobile.h.z.h));
    c();
  }

  protected void onDestroy()
  {
    if (this.j != null)
      this.j.dismiss();
    hjapp.com.hjclass_mobile.h.z.b(this);
    super.onDestroy();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
      a();
    return false;
  }

  protected void onRestart()
  {
    hjapp.com.hjclass_mobile.h.z.j = false;
    super.onRestart();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJLoginActivity
 * JD-Core Version:    0.6.2
 */