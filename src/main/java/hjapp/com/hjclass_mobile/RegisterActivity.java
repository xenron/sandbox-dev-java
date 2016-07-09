package hjapp.com.hjclass_mobile;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import hjapp.com.core.RegisterLogicProvider;
import hjapp.com.core.listener.OnRegisterResultListener;

import java.util.regex.Pattern;

public class RegisterActivity extends BaseActivity
  implements OnClickListener, OnRegisterResultListener
{
  private static int t;
  private View a = null;
  private View b = null;
  private View c = null;
  private View d = null;
  private View e = null;
  private EditText f = null;
  private EditText g = null;
  private EditText h = null;
  private EditText i = null;
  private EditText j = null;
  private EditText k = null;
  private Button l = null;
  private Button m = null;
  private Button n = null;
  private Button o = null;
  private Button p = null;
  private Button q = null;
  private TextView r = null;
  private boolean s = false;
  private Dialog u = null;

  private void a(View paramView)
  {
    this.f = ((EditText)paramView.findViewById(2131362006));
    this.g = ((EditText)paramView.findViewById(2131362042));
    this.h = ((EditText)paramView.findViewById(2131362044));
    this.i = ((EditText)paramView.findViewById(2131362046));
    RegisterLogicProvider.getInstance().setOnRegisterResultListener(this);
  }

  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    RegisterLogicProvider localRegisterLogicProvider = RegisterLogicProvider.getInstance();
    localRegisterLogicProvider.setOnRegisterResultListener(this);
    c.a(this);
    c.a(localRegisterLogicProvider, paramString1, paramString2, paramString3, paramString4, paramString5);
  }

  private void b(View paramView)
  {
    this.q = ((Button)paramView.findViewById(2131362060));
    this.q.setOnClickListener(this);
    this.r = ((TextView)paramView.findViewById(2131362059));
  }

  private boolean b()
  {
    if (TextUtils.isEmpty(this.f.getText().toString()))
    {
      this.f.requestFocus();
      Toast.makeText(this, getString(2131493061), 0).show();
      return false;
    }
    if ((this.f.getText().toString().length() > 12) || (this.f.getText().toString().length() < 2))
    {
      this.f.requestFocus();
      Toast.makeText(this, getString(2131493073), 0).show();
      return false;
    }
    if (TextUtils.isEmpty(this.g.getText().toString()))
    {
      this.g.requestFocus();
      Toast.makeText(this, getString(2131493062), 0).show();
      return false;
    }
    if ((this.g.getText().toString().length() > 12) || (this.g.getText().toString().length() < 5))
    {
      this.g.requestFocus();
      Toast.makeText(this, getString(2131493075), 0).show();
      return false;
    }
    if (TextUtils.isEmpty(this.h.getText().toString()))
    {
      this.h.requestFocus();
      Toast.makeText(this, getString(2131493063), 0).show();
      return false;
    }
    if ((this.h.getText().toString().length() > 12) || (this.h.getText().toString().length() < 5))
    {
      this.h.requestFocus();
      Toast.makeText(this, getString(2131493076), 0).show();
      return false;
    }
    if (!this.g.getText().toString().equals(this.h.getText().toString()))
    {
      this.g.requestFocus();
      Toast.makeText(this, getString(2131493064), 0).show();
      return false;
    }
    if (TextUtils.isEmpty(this.i.getText().toString()))
    {
      this.i.requestFocus();
      Toast.makeText(this, getString(2131493065), 0).show();
      return false;
    }
    String str = this.i.getText().toString();
    if (!Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*").matcher(str).find())
    {
      this.i.requestFocus();
      Toast.makeText(this, getString(2131493066), 0).show();
      return false;
    }
    if (!this.s)
    {
      if (TextUtils.isEmpty(this.k.getText().toString()))
      {
        this.k.requestFocus();
        Toast.makeText(this, getString(2131493067), 0).show();
        return false;
      }
      if (this.k.getText().toString().length() != 11)
      {
        this.k.requestFocus();
        Toast.makeText(this, "手机格式不正确", 0).show();
        return false;
      }
    }
    return true;
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
    case 2131362054:
    case 2131362055:
    case 2131362058:
    case 2131362047:
      do
      {
        do
        {
          return;
          this.a.setVisibility(8);
          this.b.setVisibility(0);
          View localView2 = this.b;
          a(localView2);
          this.l = ((Button)localView2.findViewById(2131362047));
          this.l.setOnClickListener(this);
          this.s = true;
          return;
          this.a.setVisibility(8);
          this.c.setVisibility(0);
          View localView1 = this.c;
          a(localView1);
          this.k = ((EditText)localView1.findViewById(2131362057));
          this.m = ((Button)localView1.findViewById(2131362058));
          this.m.setOnClickListener(this);
          this.s = false;
          return;
        }
        while (!b());
        a(this.f.getText().toString(), this.g.getText().toString(), this.k.getText().toString(), this.i.getText().toString(), "register_by_mobile");
        return;
      }
      while (!b());
      a(this.f.getText().toString(), this.g.getText().toString(), null, this.i.getText().toString(), "register_by_email");
      return;
    case 2131362063:
      int i1;
      if (TextUtils.isEmpty(this.j.getText().toString()))
      {
        this.j.requestFocus();
        Toast.makeText(this, getString(2131493059), 0).show();
        i1 = 0;
      }
      while (i1 != 0)
      {
        int i2 = t;
        int i3 = Integer.parseInt(this.j.getText().toString());
        RegisterLogicProvider localRegisterLogicProvider = RegisterLogicProvider.getInstance();
        localRegisterLogicProvider.setOnRegisterResultListener(this);
        c.a(this);
        c.a(localRegisterLogicProvider, i2, i3);
        return;
        if (!TextUtils.isDigitsOnly(this.j.getText().toString()))
        {
          this.j.requestFocus();
          Toast.makeText(this, getString(2131493060), 0).show();
          i1 = 0;
        }
        else
        {
          i1 = 1;
        }
      }
    case 2131362060:
    }
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("reg_username", this.f.getText().toString());
    localIntent.putExtras(localBundle);
    setResult(-1, localIntent);
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(3);
    setContentView(2130903114);
    this.a = findViewById(2131362049);
    this.b = findViewById(2131362050);
    this.c = findViewById(2131362051);
    this.d = findViewById(2131362052);
    this.e = findViewById(2131362053);
    this.n = ((Button)this.a.findViewById(2131362054));
    this.n.setOnClickListener(this);
    this.p = ((Button)this.a.findViewById(2131362055));
    this.p.setOnClickListener(this);
  }

  public void registerBegin()
  {
    if (this.u != null)
    {
      this.u.dismiss();
      this.u = null;
    }
    this.u = hjapp.com.hjclass_mobile.h.z.a(this, getString(2131493070));
    this.u.show();
  }

  public void registerFail(String paramString)
  {
    if (this.u != null)
    {
      this.u.dismiss();
      this.u = null;
    }
    Toast.makeText(this, paramString, 0).show();
  }

  public void registerSuccess(String paramString)
  {
    if (this.u != null)
    {
      this.u.dismiss();
      this.u = null;
    }
    if (this.s)
    {
      this.b.setVisibility(8);
      this.e.setVisibility(0);
      b(this.e);
      this.r.setText(getString(2131493015));
      return;
    }
    t = Integer.parseInt(paramString);
    this.c.setVisibility(8);
    this.d.setVisibility(0);
    View localView = this.d;
    this.j = ((EditText)localView.findViewById(2131362062));
    this.o = ((Button)localView.findViewById(2131362063));
    this.o.setOnClickListener(this);
  }

  public void verificationBegin()
  {
    if (this.u != null)
    {
      this.u.dismiss();
      this.u = null;
    }
    this.u = hjapp.com.hjclass_mobile.h.z.a(this, getString(2131493071));
    this.u.show();
  }

  public void verificationFail(String paramString)
  {
    if (this.u != null)
    {
      this.u.dismiss();
      this.u = null;
    }
    Toast.makeText(this, paramString, 0).show();
  }

  public void verificationSuccess(String paramString)
  {
    if (this.u != null)
    {
      this.u.dismiss();
      this.u = null;
    }
    this.c.setVisibility(8);
    this.e.setVisibility(0);
    b(this.e);
    this.r.setText(paramString);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     RegisterActivity
 * JD-Core Version:    0.6.2
 */