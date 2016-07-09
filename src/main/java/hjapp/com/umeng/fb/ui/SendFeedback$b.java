package hjapp.com.umeng.fb.ui;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import hjapp.com.umeng.fb.util.ActivityStarter;

import hjapp.com.umeng.fb.*;
import hjapp.com.umeng.fb.a;
import hjapp.com.umeng.fb.b;
import org.json.JSONObject;

class SendFeedback$b
  implements OnClickListener
{
  private SendFeedback$b(SendFeedback paramSendFeedback)
  {
  }

  public void onClick(View paramView)
  {
    int i = -1;
    if (SendFeedback.a(this.a) != null);
    for (String str = SendFeedback.a(this.a).getText().toString(); ; str = null)
    {
      if (hjapp.com.umeng.common.b.b.c(str))
      {
        Toast.makeText(this.a, this.a.getString(b.e.a(this.a)), 0).show();
        return;
      }
      if (str.length() > 140)
      {
        Toast.makeText(this.a, this.a.getString(b.e.b(this.a)), 0).show();
        return;
      }
      if (SendFeedback.b(this.a) != null);
      for (int j = SendFeedback.b(this.a).getSelectedItemPosition(); ; j = i)
      {
        if (SendFeedback.c(this.a) != null)
          i = SendFeedback.c(this.a).getSelectedItemPosition();
        JSONObject localJSONObject1;
        JSONObject localJSONObject2;
        if (SendFeedback.d(this.a) != null)
        {
          SendFeedback.d(this.a).onSubmitFB(this.a);
          SendFeedback.a(this.a, ActivityStarter.contactMap);
          SendFeedback.b(this.a, ActivityStarter.remarkMap);
          localJSONObject1 = new JSONObject();
          localJSONObject2 = new JSONObject();
          if (SendFeedback.e(this.a) == null)
            break label643;
        }
        label643: for (JSONObject localJSONObject3 = SendFeedback.getJSON(SendFeedback.e(this.a)); ; localJSONObject3 = null)
        {
          if (SendFeedback.f(this.a) != null);
          for (JSONObject localJSONObject4 = SendFeedback.getJSON(SendFeedback.f(this.a)); ; localJSONObject4 = null)
          {
            if (localJSONObject3 != null);
            try
            {
              localJSONObject1.put("Json_OtherAttrContact", localJSONObject3);
              if (localJSONObject4 != null)
                localJSONObject2.put("Json_OtherAttrRemark", localJSONObject4);
              label278: Editor localEditor2 = this.a.getSharedPreferences("UmengFb_Nums", 0).edit();
              localEditor2.putInt("ageGroup", j);
              localEditor2.putInt("sex", i);
              if (localJSONObject1.length() > 0)
                localEditor2.putString("OtherAttrContext", localJSONObject1.toString());
              if (localJSONObject2.length() > 0)
                localEditor2.putString("OtherAttrRemark", localJSONObject2.toString());
              localEditor2.commit();
              while (true)
              {
                try
                {
                  SendFeedback.a(this.a, hjapp.com.umeng.fb.util.b.a(this.a, str, j, i, localJSONObject3, localJSONObject4));
                  hjapp.com.umeng.fb.util.c.c(this.a, SendFeedback.g(this.a));
                  a.f localf = new a.f(SendFeedback.g(this.a), this.a);
                  SendFeedback.executorService.submit(localf);
                  Intent localIntent = new Intent(this.a, FeedbackConversations.class).setFlags(131072);
                  this.a.startActivity(localIntent);
                  ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(SendFeedback.a(this.a).getWindowToken(), 0);
                  this.a.finish();
                  return;
                }
                catch (Exception localException3)
                {
                  if (f.h)
                    localException3.printStackTrace();
                  hjapp.com.umeng.fb.util.c.d(this.a, SendFeedback.g(this.a));
                  return;
                }
                Editor localEditor1 = this.a.getSharedPreferences("UmengFb_Nums", 0).edit();
                localEditor1.putInt("ageGroup", j);
                localEditor1.putInt("sex", i);
                localEditor1.commit();
                try
                {
                  SendFeedback.a(this.a, hjapp.com.umeng.fb.util.b.a(this.a, str, j, i, null, null));
                }
                catch (Exception localException1)
                {
                  if (f.h)
                    localException1.printStackTrace();
                  hjapp.com.umeng.fb.util.c.d(this.a, SendFeedback.g(this.a));
                  return;
                }
              }
            }
            catch (Exception localException2)
            {
              break label278;
            }
          }
        }
      }
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     SendFeedback.b
 * JD-Core Version:    0.6.2
 */