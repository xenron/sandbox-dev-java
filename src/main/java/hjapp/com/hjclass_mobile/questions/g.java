package hjapp.com.hjclass_mobile.questions;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import hjapp.com.hjclass_mobile.f.c;
import hjapp.com.hjclass_mobile.h.t;
import hjapp.com.hjclass_mobile.h.u;
import hjapp.com.hjclass_mobile.h.z;

import java.net.URLEncoder;
import java.util.HashMap;

final class g
  implements OnClickListener
{
  g(QuestionDetailsActivity paramQuestionDetailsActivity)
  {
  }

  public final void onClick(View paramView)
  {
    String str1 = this.a.b.getText().toString().trim();
    if (TextUtils.isEmpty(str1))
      z.a(this.a, 2131493146);
    while (true)
    {
      return;
      String str2 = URLEncoder.encode(str1);
      String str3 = b.a(this.a.d);
      u.c("qid=" + str3);
      HashMap localHashMap = new HashMap();
      localHashMap.put("qid", str3);
      localHashMap.put("answer", str2);
      u.b("http://hxjiang.duapp.com/answer/addAnswer?token=" + c.a() + ",qid=" + str3 + ",answer=" + str2);
      try
      {
        String str4 = t.a("http://hxjiang.duapp.com/answer/addAnswer?token=" + c.a(), localHashMap);
        u.c(str4);
        if (str4.equals("true"))
        {
          this.a.b();
          z.a(this.a, 2131493144);
          this.a.b.setText("");
          ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.a.b.getWindowToken(), 0);
          return;
        }
      }
      catch (Exception localException)
      {
        u.a(localException.toString());
      }
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     g
 * JD-Core Version:    0.6.2
 */