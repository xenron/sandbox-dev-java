package hjapp.com.umeng.fb.ui;

import android.app.ListActivity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import hjapp.com.umeng.fb.UMFeedbackService;
import hjapp.com.umeng.fb.util.ActivityStarter;

public class FeedbackConversations extends ListActivity
{
  private static final int c = 0;
  private static final int d = 1;
  private static final int e = 2;
  private static final int f = 3;
  private static final int g = 4;
  FeedbackConversations.a a;
  ImageButton b;

  private void a()
  {
    d locald = (d)getListAdapter();
    locald.a(hjapp.com.umeng.fb.util.c.a(this));
    locald.notifyDataSetChanged();
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    int i = ((AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo()).position;
    hjapp.com.umeng.fb.b localb = ((d)getListAdapter()).b(i);
    switch (paramMenuItem.getItemId())
    {
    default:
    case 0:
    case 2:
    case 1:
    case 4:
    case 3:
    }
    while (true)
    {
      return super.onContextItemSelected(paramMenuItem);
      hjapp.com.umeng.fb.util.c.a(this, localb.c);
      ActivityStarter.openDetailActivity(this, localb);
      continue;
      hjapp.com.umeng.fb.util.c.c(this, localb.c);
      a();
      continue;
      hjapp.com.umeng.fb.util.c.c(this, localb.c);
      a();
      continue;
      ActivityStarter.openSendFeedbackActivity(this, localb);
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(hjapp.com.umeng.fb.b.d.c(this));
    this.b = ((ImageButton)findViewById(hjapp.com.umeng.fb.b.c.k(this)));
    if (this.b != null)
      this.b.setOnClickListener(new c(this));
    if (!UMFeedbackService.getHasCheckedReply())
    {
      new hjapp.com.umeng.fb.a.e(this).start();
      new hjapp.com.umeng.fb.a.d(this).start();
    }
    registerForContextMenu(getListView());
    setListAdapter(new d(this, hjapp.com.umeng.fb.util.c.a(this)));
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    int i = ((AdapterView.AdapterContextMenuInfo)paramContextMenuInfo).position;
    hjapp.com.umeng.fb.b.a locala = ((d)getListAdapter()).b(i).b;
    if (locala == b.a.d)
    {
      paramContextMenu.add(0, 0, 0, getString(hjapp.com.umeng.fb.b.e.l(this)));
      paramContextMenu.add(0, 1, 0, getString(hjapp.com.umeng.fb.b.e.m(this)));
    }
    do
    {
      return;
      if (locala == b.a.a)
      {
        paramContextMenu.add(0, 2, 0, getString(hjapp.com.umeng.fb.b.e.n(this)));
        paramContextMenu.add(0, 4, 0, getString(hjapp.com.umeng.fb.b.e.o(this)));
        return;
      }
    }
    while (locala != b.a.b);
    paramContextMenu.add(0, 3, 0, getString(hjapp.com.umeng.fb.b.e.p(this)));
    paramContextMenu.add(0, 4, 0, getString(hjapp.com.umeng.fb.b.e.o(this)));
  }

  protected void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    super.onListItemClick(paramListView, paramView, paramInt, paramLong);
    synchronized (((d)getListAdapter()).b(paramInt))
    {
      hjapp.com.umeng.fb.b localb2 = ((d)getListAdapter()).b(paramInt);
      hjapp.com.umeng.fb.b.a locala = localb2.b;
      hjapp.com.umeng.fb.util.c.a(this, localb2.c);
      switch (FeedbackConversations.1.a[locala.ordinal()])
      {
      default:
        ActivityStarter.openDetailActivity(this, localb2);
        return;
      case 1:
      }
      ActivityStarter.openSendFeedbackActivity(this, localb2);
    }
  }

  protected void onRestart()
  {
    super.onRestart();
    a();
  }

  protected void onStart()
  {
    super.onStart();
    this.a = new FeedbackConversations.a(this, (d)getListAdapter());
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("postFeedbackFinished");
    localIntentFilter.addAction("RetrieveReplyBroadcast");
    registerReceiver(this.a, localIntentFilter);
  }

  protected void onStop()
  {
    super.onStop();
    unregisterReceiver(this.a);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     FeedbackConversations
 * JD-Core Version:    0.6.2
 */