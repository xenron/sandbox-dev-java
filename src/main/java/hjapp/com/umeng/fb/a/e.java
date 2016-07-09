package hjapp.com.umeng.fb.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;

public class e extends Thread
{
  static final String a = e.class.getSimpleName();
  Context b;
  String c = "http://feedback.whalecloud.com/feedback/reply";
  String d;
  String e;
  int f = 0;
  Handler g;

  public e(Context paramContext)
  {
    this.b = paramContext;
    this.d = hjapp.com.umeng.common.b.k(paramContext);
    this.e = hjapp.com.umeng.common.b.d(paramContext);
  }

  public e(Context paramContext, Handler paramHandler)
  {
    this(paramContext);
    this.g = paramHandler;
  }

  public void run()
  {
    Iterator localIterator = this.b.getSharedPreferences("feedback", 0).getAll().keySet().iterator();
    Object localObject = "";
    while (localIterator.hasNext())
    {
      String str4 = (String)localIterator.next();
      if (((String)localObject).length() == 0)
        localObject = str4;
      else
        localObject = (String)localObject + "," + str4;
    }
    String str1 = this.b.getSharedPreferences("UmengFb_Nums", 0).getString("maxReplyID", "RP0");
    if (hjapp.com.umeng.common.b.b.c((String)localObject))
      return;
    this.c = (this.c + "?appkey=" + this.d + "&feedback_id=" + (String)localObject);
    if (!str1.equals("RP0"))
      this.c = (this.c + "&startkey=" + str1);
    Log.d(a, this.c);
    String str2 = hjapp.com.umeng.fb.util.a.a(this.c);
    Intent localIntent = new Intent();
    localIntent.setAction("RetrieveReplyBroadcast");
    if (str2 != null);
    while (true)
    {
      try
      {
        localJSONArray = new JSONArray(str2);
        str3 = c.a(this.b, localJSONArray);
        Log.d(a, "newReplyIds :" + str3);
        if ((str3.length() == 0) || (str3.split(",").length == 0))
        {
          localIntent.putExtra("RetrieveReplyBroadcast", 0);
          this.b.sendBroadcast(localIntent);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        String str3;
        localJSONException.printStackTrace();
        JSONArray localJSONArray = null;
        continue;
        localIntent.putExtra("RetrieveReplyBroadcast", 1);
        if (this.g == null)
          continue;
        String[] arrayOfString = str3.split(",");
        int i = arrayOfString.length;
        hjapp.com.umeng.fb.a locala = c.b(this.b, arrayOfString[(i - 1)]).e;
        Message localMessage = new Message();
        Bundle localBundle = new Bundle();
        localBundle.putString("newReplyContent", locala.a());
        localMessage.setData(localBundle);
        this.g.sendMessage(localMessage);
        continue;
      }
      localIntent.putExtra("RetrieveReplyBroadcast", -1);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     aersion:    0.6.2
 */