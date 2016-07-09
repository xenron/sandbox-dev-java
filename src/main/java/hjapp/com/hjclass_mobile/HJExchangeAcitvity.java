package hjapp.com.hjclass_mobile;

import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HJExchangeAcitvity extends BaseActivity
  implements OnClickListener
{
  private View a;
  private View b;
  private TextView c = null;
  private TextView d = null;
  private TextView e = null;
  private Button f = null;
  private Button g = null;
  private TextView h = null;
  private Button i = null;
  private ProgressDialog j = null;
  private boolean k = false;
  private int l;
  private float m = 0.0F;
  private float n = 0.0F;

  protected final void a()
  {
    Builder localBuilder = new Builder(this);
    localBuilder.setMessage(getString(2131493116));
    localBuilder.setPositiveButton(getString(2131493097), new bg(this));
    localBuilder.setNeutralButton(getString(2131493094), new bh(this));
    localBuilder.create().show();
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 9000))
    {
      bj localbj = new bj(this, (byte)0);
      String[] arrayOfString = new String[2];
      arrayOfString[0] = c.c();
      arrayOfString[1] = hjapp.com.hjclass_mobile.h.z.b(c.d());
      localbj.execute(arrayOfString);
    }
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131361944:
    default:
      return;
    case 2131361942:
      Intent localIntent2 = new Intent();
      localIntent2.setClass(this, HJAlipayActivity.class);
      startActivityForResult(localIntent2, 9000);
      return;
    case 2131361943:
      if (this.n > this.m)
      {
        a();
        return;
      }
      String str = this.c.getText().toString();
      Builder localBuilder = new Builder(this);
      localBuilder.setMessage(hjapp.com.hjclass_mobile.h.y.a(getString(2131493121), new Object[] { str }));
      localBuilder.setPositiveButton(getString(2131493112), new be(this));
      localBuilder.setNeutralButton(getString(2131493094), new bf(this));
      localBuilder.create().show();
      return;
    case 2131361945:
    }
    Intent localIntent1 = new Intent();
    localIntent1.setClass(this, HJLessonListActivity.class);
    localIntent1.putExtras(getIntent().getExtras());
    startActivity(localIntent1);
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903073);
    this.a = findViewById(2131361937);
    this.b = findViewById(2131361938);
    this.c = ((TextView)this.a.findViewById(2131361838));
    this.d = ((TextView)this.a.findViewById(2131361941));
    this.e = ((TextView)this.a.findViewById(2131361824));
    this.f = ((Button)this.a.findViewById(2131361942));
    this.f.setOnClickListener(this);
    this.g = ((Button)this.a.findViewById(2131361943));
    this.g.setOnClickListener(this);
    this.h = ((TextView)this.b.findViewById(2131361944));
    this.i = ((Button)this.b.findViewById(2131361945));
    this.i.setOnClickListener(this);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null)
    {
      Toast.makeText(this, "非法操作", 0).show();
      finish();
    }
    while (true)
    {
      bj localbj = new bj(this, (byte)0);
      String[] arrayOfString = new String[2];
      arrayOfString[0] = c.c();
      arrayOfString[1] = hjapp.com.hjclass_mobile.h.z.b(c.d());
      localbj.execute(arrayOfString);
      return;
      this.n = Float.parseFloat(localBundle.getString("classXB").replace("学币", ""));
      String str1 = "<font color='#ff6102'>" + localBundle.getString("classXB").replace("学币", "") + "</font>" + getText(2131493039);
      this.e.setText(Html.fromHtml(str1));
      this.c.setText(localBundle.getString("classname"));
      String str2 = "<font color='#349917'>" + localBundle.getString("classname") + "</font>";
      this.h.setText(Html.fromHtml(hjapp.com.hjclass_mobile.h.y.a(getString(2131493123), new Object[] { str2 })));
      this.l = localBundle.getInt("classid");
    }
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.k)
      return true;
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJExchangeAcitvity
 * JD-Core Version:    0.6.2
 */