package hjapp.com.hjclass_mobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HJAlipayActivity extends BaseActivity
  implements OnClickListener
{
  private TextView a = null;
  private Button b = null;
  private View c;
  private View d;
  private TextView e;
  private Button f;
  private ProgressDialog g = null;
  private TextView h;
  private Handler i = new h(this);

  final void b()
  {
    try
    {
      if (this.g != null)
      {
        this.g.dismiss();
        this.g = null;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131361942:
      if (TextUtils.isEmpty(this.h.getText()))
      {
        Toast.makeText(this, 2131493108, 0).show();
        return;
      }
      if (this.h.getText().toString().length() != 11)
      {
        Toast.makeText(this, "手机格式不正确", 0).show();
        return;
      }
      if (TextUtils.isEmpty(this.a.getText()))
      {
        Toast.makeText(this, 2131493104, 0).show();
        return;
      }
      try
      {
        if (Integer.parseInt(this.a.getText().toString()) > 3000)
        {
          Toast.makeText(this, 2131493106, 0).show();
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Toast.makeText(this, 2131493106, 0).show();
        return;
      }
      if (Float.parseFloat(this.a.getText().toString()) < 1.0F)
      {
        Toast.makeText(this, 2131493105, 0).show();
        return;
      }
      if (!hjapp.com.hjclass_mobile.h.z.h)
      {
        Toast.makeText(this, 2131492921, 0).show();
        return;
      }
      j localj = new j(this, (byte)0);
      String[] arrayOfString = new String[4];
      arrayOfString[0] = c.c();
      arrayOfString[1] = c.d();
      arrayOfString[2] = this.a.getText().toString();
      arrayOfString[3] = this.h.getText().toString();
      localj.execute(arrayOfString);
      return;
    case 2131362017:
    }
    setResult(-1, new Intent());
    finish();
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
    if (!hjapp.com.hjclass_mobile.h.z.h)
      Toast.makeText(this, 2131492921, 0).show();
    setContentView(2130903102);
    this.c = findViewById(2131362013);
    this.d = findViewById(2131362014);
    this.d.setVisibility(8);
    this.a = ((TextView)this.c.findViewById(2131362019));
    this.b = ((Button)this.c.findViewById(2131361942));
    this.h = ((TextView)this.c.findViewById(2131362018));
    this.b.setOnClickListener(this);
    this.e = ((TextView)this.d.findViewById(2131362015));
    this.f = ((Button)this.d.findViewById(2131362017));
    this.f.setOnClickListener(this);
    k localk = new k(this, (byte)0);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = c.c();
    arrayOfString[1] = hjapp.com.hjclass_mobile.h.z.b(c.d());
    localk.execute(arrayOfString);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.g != null)
        this.g.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJAlipayActivity
 * JD-Core Version:    0.6.2
 */