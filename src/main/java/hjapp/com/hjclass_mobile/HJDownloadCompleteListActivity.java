package hjapp.com.hjclass_mobile;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import hjapp.com.hjclass_mobile.d.t;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HJDownloadCompleteListActivity extends BaseActivity
  implements OnCreateContextMenuListener, OnItemClickListener
{
  private bd a = null;
  private ListView b = null;
  private List c;
  private hjapp.com.hjclass_mobile.b.b d = null;
  private bc e = null;
  private bb f = null;
  private ba g = null;
  private View h;
  private View i;
  private View j;

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    int k = 1;
    if (!hjapp.com.hjclass_mobile.h.z.d())
    {
      Toast.makeText(this, getString(2131492966), 0).show();
      return false;
    }
    int m = ((AdapterContextMenuInfo)paramMenuItem.getMenuInfo()).position;
    if (this.b.getHeaderViewsCount() > 0);
    for (int n = m - 1; ; n = m)
    {
      t localt = (t)this.c.get(n);
      if ((localt != null) && (localt.b() == 3));
      for (int i1 = k; ; i1 = 0)
      {
        int i2 = localt.a();
        int i3 = localt.d();
        boolean bool;
        if ((localt != null) && (hjapp.com.hjclass_mobile.h.z.a(i2, i3, localt.c())))
        {
          bool = hjapp.com.hjclass_mobile.h.z.a(i2, localt.l());
          switch (paramMenuItem.getItemId())
          {
          default:
          case 0:
          }
        }
        do
        {
          return super.onContextItemSelected(paramMenuItem);
          k = 0;
          break;
        }
        while ((k == 0) && (i1 == 0) && (!bool));
        hjapp.com.hjclass_mobile.h.z.a(i2, i3, localt.c(), localt.l());
        localt.b(6);
        localt.e(0);
        this.d.a(localt);
        this.c.remove(n);
        this.e.notifyDataSetChanged();
        if ((this.c != null) && (this.c.size() > 0))
        {
          this.h.setVisibility(8);
          this.i.setVisibility(0);
        }
        while (true)
        {
          Intent localIntent = new Intent("delete_file");
          localIntent.putExtra("downkey", localt.m());
          localIntent.putExtra("classId", localt.d());
          sendBroadcast(localIntent);
          break;
          this.h.setVisibility(0);
          this.i.setVisibility(8);
        }
      }
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903054);
    hjapp.com.hjclass_mobile.h.z.a(this);
    this.h = findViewById(2131361818);
    this.i = findViewById(2131361885);
    this.j = findViewById(2131361814);
    this.d = new hjapp.com.hjclass_mobile.b.b(this);
    this.b = ((ListView)findViewById(2131361884));
    this.b.setCacheColorHint(0);
    this.b.setOnItemClickListener(this);
    this.b.setOnCreateContextMenuListener(this);
    this.c = new ArrayList();
    if (this.g == null)
    {
      this.g = new ba(this, (byte)0);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("download_status");
      registerReceiver(this.g, localIntentFilter);
    }
    if (this.c.size() > 0)
      this.c.clear();
    this.f = new bb(this, (byte)0);
    this.f.execute(new Object[0]);
    this.e = new bc(this, this);
    this.b.setAdapter(this.e);
    this.b.setFastScrollEnabled(false);
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenu.setHeaderTitle(getString(2131492954));
    paramContextMenu.add(0, 0, 0, getString(2131492948));
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }

  protected void onDestroy()
  {
    unregisterReceiver(this.g);
    hjapp.com.hjclass_mobile.h.z.b(this);
    super.onDestroy();
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!hjapp.com.hjclass_mobile.h.z.d())
      Toast.makeText(this, getString(2131492966), 0).show();
    t localt;
    int k;
    int m;
    int n;
    int i1;
    do
    {
      return;
      localt = (t)this.c.get(paramInt);
      k = 0;
      if (localt != null)
      {
        int i2 = localt.b();
        k = 0;
        if (i2 == 3)
          k = 1;
      }
      m = localt.a();
      n = localt.d();
      if (this.d.h(m, n))
      {
        Toast.makeText(this, getString(2131493140), 0).show();
        return;
      }
      if ((localt == null) || (!hjapp.com.hjclass_mobile.h.z.a(m, n, localt.c())))
        break;
      i1 = 1;
      boolean bool = hjapp.com.hjclass_mobile.h.z.a(m, localt.l());
      if ((i1 == 0) && (k != 0))
      {
        if (!bool)
          break label331;
        Log.i("===", "isZipValid true");
      }
      if ((i1 != 0) && ((localt.b() != 5) || (localt.b() != 1)) && (!bool))
        k = 1;
    }
    while (k == 0);
    if ((localt.b() != 3) || (localt.f() != 100))
    {
      localt.a(localt.a());
      localt.b(3);
      localt.e(100);
      this.d.a(localt);
      this.e.notifyDataSetChanged();
      if ((this.c == null) || (this.c.size() <= 0))
        break label347;
      this.h.setVisibility(8);
      this.i.setVisibility(0);
    }
    while (true)
    {
      if ((localt.j() != 0) || (!localt.t()))
        break label367;
      Toast.makeText(this, 2131493127, 0).show();
      return;
      i1 = 0;
      break;
      label331: Toast.makeText(this, getString(2131492922), 0).show();
      return;
      label347: this.h.setVisibility(0);
      this.i.setVisibility(8);
    }
    label367: Intent localIntent = new Intent();
    localIntent.putExtra("lesson", localt);
    localIntent.putExtra("filePath", hjapp.com.hjclass_mobile.h.z.c + m + File.separator + n + File.separator + localt.c() + File.separator + "index.xml");
    if (localt.w() == 3)
      localIntent.setClass(this, HJClassPlayer.class);
    while (true)
    {
      localIntent.setFlags(541065216);
      startActivity(localIntent);
      return;
      localIntent.setClass(this, HJClassPlayerV3.class);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJDownloadCompleteListActivity
 * JD-Core Version:    0.6.2
 */