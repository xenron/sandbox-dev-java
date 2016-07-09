package hjapp.com.umeng.fb.ui;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import hjapp.com.umeng.fb.*;
import hjapp.com.umeng.fb.util.ActivityStarter;
import hjapp.com.umeng.fb.util.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SendFeedback extends Activity
{
  static boolean a = true;
  private static final String b = SendFeedback.class.getName();
  public static ExecutorService executorService = Executors.newFixedThreadPool(3);
  private Spinner c;
  private Spinner d;
  private EditText e;
  private TextView f;
  private TextView g;
  private ImageButton h;
  private FeedBackListener i;
  private Map j;
  private Map k;
  private JSONObject l;

  private void a()
  {
    this.c = ((Spinner)findViewById(hjapp.com.umeng.fb.b.c.a(this)));
    this.d = ((Spinner)findViewById(hjapp.com.umeng.fb.b.c.b(this)));
    this.f = ((TextView)findViewById(hjapp.com.umeng.fb.b.c.c(this)));
    if (ActivityStarter.useGoBackButton)
    {
      this.g = ((TextView)findViewById(hjapp.com.umeng.fb.b.c.d(this)));
      this.g.setVisibility(0);
    }
    while (true)
    {
      this.e = ((EditText)findViewById(hjapp.com.umeng.fb.b.c.e(this)));
      this.h = ((ImageButton)findViewById(hjapp.com.umeng.fb.b.c.f(this)));
      if (this.c != null)
      {
        ArrayAdapter localArrayAdapter1 = new ArrayAdapter(this, 17367048, getResources().getStringArray(hjapp.com.umeng.fb.b.a.a(this)));
        localArrayAdapter1.setDropDownViewResource(17367049);
        this.c.setAdapter(localArrayAdapter1);
      }
      if (this.d != null)
      {
        ArrayAdapter localArrayAdapter2 = new ArrayAdapter(this, 17367048, getResources().getStringArray(hjapp.com.umeng.fb.b.a.b(this)));
        localArrayAdapter2.setDropDownViewResource(17367049);
        this.d.setAdapter(localArrayAdapter2);
      }
      if (this.h != null)
        this.h.setOnClickListener(new e(this));
      b();
      c();
      return;
      this.g = ((TextView)findViewById(hjapp.com.umeng.fb.b.c.d(this)));
      this.g.setVisibility(4);
    }
  }

  private void b()
  {
    if (this.e != null)
      this.e.setHint(getString(hjapp.com.umeng.fb.b.e.d(this)));
    if (this.f != null)
      this.f.setText(getString(hjapp.com.umeng.fb.b.e.e(this)));
    if (this.g != null)
      this.g.setText(getString(hjapp.com.umeng.fb.b.e.f(this)));
  }

  private void c()
  {
    String str1 = getIntent().getStringExtra("feedback_id");
    String str2;
    if ((str1 != null) && (this.e != null))
    {
      str2 = getSharedPreferences("feedback", 0).getString(str1, null);
      if (b.c(str2));
    }
    try
    {
      String str3 = new hjapp.com.umeng.fb.a(new JSONArray(str2).getJSONObject(0)).a();
      this.e.setText(str3);
      hjapp.com.umeng.fb.util.c.a(this, "feedback", str1);
      if (this.c != null)
      {
        int n = d();
        if (n != -1)
          this.c.setSelection(n);
      }
      if (this.d != null)
      {
        int m = e();
        if (m != -1)
          this.d.setSelection(m);
      }
      f();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        if (f.h)
          localException.printStackTrace();
    }
  }

  private int d()
  {
    return getSharedPreferences("UmengFb_Nums", 0).getInt("ageGroup", -1);
  }

  private int e()
  {
    return getSharedPreferences("UmengFb_Nums", 0).getInt("sex", -1);
  }

  private void f()
  {
    while (true)
    {
      try
      {
        SharedPreferences localSharedPreferences = getSharedPreferences("UmengFb_Nums", 0);
        String str1 = localSharedPreferences.getString("OtherAttrContext", "");
        String str2 = localSharedPreferences.getString("OtherAttrRemark", "");
        if ((str1 != null) && (str1.length() > 0))
        {
          this.j = getMap(new JSONObject(str1).getJSONObject("Json_OtherAttrContact"));
          if ((str2 != null) && (str2.length() > 0))
          {
            this.k = getMap(new JSONObject(str2).getJSONObject("Json_OtherAttrRemark"));
            if (this.i == null)
              break;
            this.i.onResetFB(this, this.j, this.k);
          }
        }
        else
        {
          this.j = null;
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      this.k = null;
    }
  }

  public static JSONObject getJSON(Map paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      while (localIterator.hasNext())
      {
        Entry localEntry = (Entry)localIterator.next();
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue().toString());
      }
    }
    catch (Exception localException)
    {
      System.out.println(localException.getMessage());
    }
    return localJSONObject;
  }

  public static Map getMap(JSONObject paramJSONObject)
  {
    HashMap localHashMap;
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      localHashMap = new HashMap();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramJSONObject.get(str).toString());
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return null;
    }
    return localHashMap;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(d.a(this));
    setFBListener(UMFeedbackService.fbListener);
    a();
    if (this.f != null)
    {
      this.f.setOnClickListener(new SendFeedback.b(this, null));
      if (this.e != null)
        ((InputMethodManager)getSystemService("input_method")).toggleSoftInput(2, 0);
    }
    if (this.g != null)
    {
      this.g.setOnClickListener(new SendFeedback.a(this, null));
      ((InputMethodManager)getSystemService("input_method")).toggleSoftInput(2, 0);
    }
  }

  protected void onPause()
  {
    try
    {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.e.getWindowToken(), 0);
      super.onPause();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        Log.e(b, localException.getMessage());
    }
  }

  public void setFBListener(FeedBackListener paramFeedBackListener)
  {
    this.i = paramFeedBackListener;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     SendFeedback
 * JD-Core Version:    0.6.2
 */