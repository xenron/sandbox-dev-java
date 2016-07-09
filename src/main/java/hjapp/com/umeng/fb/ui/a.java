package hjapp.com.umeng.fb.ui;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import hjapp.com.umeng.fb.a.f;

import hjapp.com.umeng.fb.b;
import org.json.JSONObject;

class a
  implements OnClickListener
{
  a(FeedbackConversation paramFeedbackConversation)
  {
  }

  public void onClick(View paramView)
  {
    String str = FeedbackConversation.a(this.a).getText().toString();
    if ((str == null) || (str.trim().length() == 0))
      return;
    if (str.length() > 140)
    {
      Toast.makeText(this.a, this.a.getString(b.e.q(this.a)), 0).show();
      return;
    }
    try
    {
      JSONObject localJSONObject2 = hjapp.com.umeng.fb.util.b.a(this.a, str, FeedbackConversation.b(this.a).c);
      localJSONObject1 = localJSONObject2;
      FeedbackConversation.a(this.a).setText("");
      ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(FeedbackConversation.a(this.a).getWindowToken(), 0);
      hjapp.com.umeng.fb.util.c.c(this.a, localJSONObject1);
      FeedbackConversation.a(this.a, hjapp.com.umeng.fb.util.c.b(this.a, FeedbackConversation.b(this.a).c));
      FeedbackConversation.c(this.a).a(FeedbackConversation.b(this.a));
      FeedbackConversation.c(this.a).notifyDataSetChanged();
      this.a.setSelection(-1 + FeedbackConversation.c(this.a).getCount());
      f localf = new f(localJSONObject1, this.a);
      FeedbackConversation.executorService.submit(localf);
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        Toast.makeText(this.a, localException.getMessage(), 0).show();
        hjapp.com.umeng.fb.util.c.d(this.a, null);
        Log.d(FeedbackConversation.c, localException.getMessage());
        JSONObject localJSONObject1 = null;
      }
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     a
 * JD-Core Version:    0.6.2
 */