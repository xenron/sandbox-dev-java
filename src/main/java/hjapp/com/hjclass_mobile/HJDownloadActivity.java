package hjapp.com.hjclass_mobile;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import hjapp.com.hjclass_mobile.pkg_b.d;

import java.util.List;
import java.util.Map;

public class HJDownloadActivity extends BaseActivity
  implements OnCreateContextMenuListener, OnItemClickListener
{
  private az a = null;
  private ListView b = null;
  private List c;
  private ay d = null;
  private hjapp.com.hjclass_mobile.pkg_b.b e = null;
  private ax f = null;
  private Handler g = null;
  private View h;
  private View i;
  private HJApplication j = null;

  public final void b()
  {
    Map localMap = this.j.a();
    List localList = this.j.b();
    int k = localMap.size();
    for (int m = 0; (m < k) && (localMap.size() != 0); m++)
    {
      hjapp.com.hjclass_mobile.pkg_d.s locals = (hjapp.com.hjclass_mobile.pkg_d.s)localList.get(m);
      if (localMap.containsKey(locals.i()))
      {
        d locald = (d)localMap.get(locals.i());
        if ((locald != null) && ((locald.b()) || (locald.d())))
        {
          locald.cancel(true);
          locald.g();
        }
      }
    }
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 0:
    }
    while (true)
    {
      return super.onContextItemSelected(paramMenuItem);
      AdapterContextMenuInfo localAdapterContextMenuInfo = (AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
      Intent localIntent = new Intent("delete_task");
      localIntent.putExtra("position", localAdapterContextMenuInfo.position);
      sendBroadcast(localIntent);
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903056);
    this.j = ((HJApplication)getApplicationContext());
    this.g = new Handler();
    hjapp.com.hjclass_mobile.h.z.a(this);
    if (this.f == null)
    {
      this.f = new ax(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("update_ui_task");
      localIntentFilter.addAction("download_progress");
      registerReceiver(this.f, localIntentFilter);
    }
    this.h = findViewById(2131361818);
    this.i = findViewById(2131361885);
    this.e = new hjapp.com.hjclass_mobile.pkg_b.b(this);
    this.b = ((ListView)findViewById(2131361894));
    this.b.setCacheColorHint(0);
    this.b.setOnItemClickListener(this);
    this.b.setOnCreateContextMenuListener(this);
    c.b();
    this.c = this.j.b();
    this.d = new ay(this, this);
    this.b.setAdapter(this.d);
    if (this.c.size() > 0)
    {
      this.h.setVisibility(8);
      this.i.setVisibility(0);
      return;
    }
    this.h.setVisibility(0);
    this.i.setVisibility(8);
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenu.setHeaderTitle(getString(2131492962));
    paramContextMenu.add(0, 0, 0, getString(2131492993));
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623938, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }

  protected void onDestroy()
  {
    unregisterReceiver(this.f);
    hjapp.com.hjclass_mobile.h.z.b(this);
    super.onDestroy();
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!hjapp.com.hjclass_mobile.h.z.d())
    {
      Toast.makeText(this, getString(2131492966), 0).show();
      return;
    }
    Intent localIntent = new Intent("check_task");
    localIntent.putExtra("position", paramInt);
    sendBroadcast(localIntent);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131362129:
    case 2131362130:
    }
    while (true)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      if ((this.c == null) && (this.c.size() == 0))
        return super.onOptionsItemSelected(paramMenuItem);
      av localav = new av(this);
      this.g.post(localav);
      continue;
      if ((this.c == null) && (this.c.size() == 0))
        return super.onOptionsItemSelected(paramMenuItem);
      aw localaw = new aw(this);
      this.g.post(localaw);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJDownloadActivity
 * JD-Core Version:    0.6.2
 */