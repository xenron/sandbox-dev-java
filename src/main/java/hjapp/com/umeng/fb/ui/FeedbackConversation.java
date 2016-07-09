package hjapp.com.umeng.fb.ui;

import android.app.ListActivity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import hjapp.com.umeng.fb.a.b;
import hjapp.com.umeng.fb.util.ActivityStarter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FeedbackConversation extends ListActivity
{
  static Context a = null;
  static final String c = FeedbackConversation.class.getSimpleName();
  static boolean d = true;
  public static ExecutorService executorService = Executors.newFixedThreadPool(3);
  boolean b = false;
  private hjapp.com.umeng.fb.b e;
  private b f;
  private TextView g;
  private EditText h;
  private Button i;
  private FeedbackConversation.a j;

  private void a()
  {
    this.g.setText(getString(e.r(this)));
    this.i.setText(getString(e.s(this)));
  }

  public static void setUserContext(Context paramContext)
  {
    a = paramContext;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(d.d(this));
    String str = getIntent().getStringExtra("feedback_id");
    if (str != null)
      this.e = hjapp.com.umeng.fb.util.c.b(this, str);
    try
    {
      this.f = new b(this, this.e);
      setListAdapter(this.f);
      setSelection(-1 + this.f.getCount());
      this.g = ((TextView)findViewById(hjapp.com.umeng.fb.b.c.m(this)));
      this.h = ((EditText)findViewById(hjapp.com.umeng.fb.b.c.n(this)));
      this.i = ((Button)findViewById(hjapp.com.umeng.fb.b.c.o(this)));
      this.i.setOnClickListener(new a(this));
      this.h.requestFocus();
      registerForContextMenu(getListView());
      a();
      if (this.e.b != b.a.d)
      {
        this.h.setEnabled(false);
        this.i.setEnabled(false);
      }
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.e(c, "In Feedback class,fail to initialize feedback adapter.");
        finish();
      }
    }
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (a != null)
        ActivityStarter.openFeedbackListActivity(a);
      while (true)
      {
        finish();
        return true;
        ActivityStarter.openFeedbackListActivity(this);
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  protected void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    super.onListItemClick(paramListView, paramView, paramInt, paramLong);
    hjapp.com.umeng.fb.a locala = this.e.a(paramInt);
    if (locala.g == a.a.b)
    {
      if (locala.f == a.b.a)
      {
        ActivityStarter.openSendFeedbackActivity(this, this.e);
        finish();
      }
    }
    else
      return;
    String str = locala.a();
    this.h.setText(str);
    this.h.setEnabled(true);
    this.i.setEnabled(true);
    hjapp.com.umeng.fb.util.c.a(this, this.e, paramInt);
    this.f.a(this.e);
    this.f.notifyDataSetChanged();
  }

  protected void onStart()
  {
    super.onStart();
    this.j = new FeedbackConversation.a(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("postFeedbackFinished");
    localIntentFilter.addAction("RetrieveReplyBroadcast");
    registerReceiver(this.j, localIntentFilter);
  }

  protected void onStop()
  {
    super.onStop();
    unregisterReceiver(this.j);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     FeedbackConversation
 * JD-Core Version:    0.6.2
 */