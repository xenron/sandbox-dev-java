package hjapp.com.hjclass_mobile.questions;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import hjapp.com.hjclass_mobile.BaseActivity;
import hjapp.com.hjclass_mobile.h.t;
import hjapp.com.hjclass_mobile.h.z;

import java.net.URLEncoder;
import java.util.HashMap;

public class QuestionAskQuestionActivity extends BaseActivity
  implements OnClickListener
{
  private Button a;
  private Button b;
  private EditText c;
  private ProgressDialog d;
  private String e;

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131362033:
      finish();
      return;
    case 2131362034:
    }
    String str1 = URLEncoder.encode(this.c.getText().toString().trim());
    HashMap localHashMap;
    Object localObject;
    if (!TextUtils.isEmpty(str1))
    {
      this.d.show();
      localHashMap = new HashMap();
      localHashMap.put("cid", this.e);
      localHashMap.put("question", str1);
      localHashMap.put("supply", "");
      localObject = "";
    }
    try
    {
      String str2 = t.a("http://hxjiang.duapp.com/question/AddQuestion?token=" + c.a(), localHashMap);
      localObject = str2;
      label139: this.d.dismiss();
      try
      {
        int j = Integer.parseInt((String)localObject);
        i = j;
        if (i > 0)
        {
          z.a(this, 2131493144);
          finish();
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        while (true)
          int i = 0;
        z.a(this, 2131493145);
        return;
      }
      z.a(this, 2131493146);
      return;
    }
    catch (Exception localException)
    {
      break label139;
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903111);
    this.b = ((Button)findViewById(2131362034));
    this.a = ((Button)findViewById(2131362033));
    this.c = ((EditText)findViewById(2131362035));
    this.b.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.d = new ProgressDialog(this);
    this.d.setTitle(2131493147);
    this.e = getIntent().getStringExtra("cid");
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     QuestionAskQuestionActivity
 * JD-Core Version:    0.6.2
 */