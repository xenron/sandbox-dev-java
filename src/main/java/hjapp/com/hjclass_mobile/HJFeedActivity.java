package hjapp.com.hjclass_mobile;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HJFeedActivity extends BaseActivity
  implements OnScrollListener
{
  private int a = 0;
  private View b;
  private View c;
  private ListView d;
  private hjapp.com.hjclass_mobile.b.o e = null;
  private int f = 0;
  private List g = null;
  private bk h = null;
  private int i = 1;
  private int j = 1;
  private bl k = null;
  private View l;
  private View m;

  private void a(int paramInt1, int paramInt2)
  {
    if ((this.g.size() < this.f) || (this.f == 0))
    {
      if ((this.h != null) && (this.h.getStatus() == AsyncTask.Status.RUNNING))
        this.h.cancel(true);
      this.h = new bk(this, (byte)0);
      bk localbk = this.h;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramInt1);
      arrayOfObject[1] = Integer.valueOf(paramInt2);
      localbk.execute(arrayOfObject);
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903082);
    if (this.k == null)
    {
      this.k = new bl(this, (byte)0);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("refresh_feed");
      registerReceiver(this.k, localIntentFilter);
    }
    hjapp.com.hjclass_mobile.h.z.a(this);
    this.b = findViewById(2131361814);
    this.d = ((ListView)findViewById(2131361953));
    this.c = LayoutInflater.from(this).inflate(2130903092, null);
    this.d.addFooterView(this.c, null, false);
    this.d.setOnScrollListener(this);
    this.l = findViewById(2131361818);
    this.m = findViewById(2131361885);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
      this.j = localBundle.getInt("type");
    this.h = new bk(this, (byte)0);
    bk localbk = this.h;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(1);
    arrayOfObject[1] = Integer.valueOf(this.j);
    localbk.execute(arrayOfObject);
    this.g = new ArrayList();
    this.e = new b.o(this, this.g);
    this.d.setAdapter(this.e);
  }

  protected void onDestroy()
  {
    hjapp.com.hjclass_mobile.h.z.b(this);
    unregisterReceiver(this.k);
    super.onDestroy();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = (paramInt1 + paramInt2);
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView.getLastVisiblePosition() == -1 + paramAbsListView.getCount()) && (paramInt == 0))
    {
      int n = 20 + (-1 + this.a);
      int i1 = n % 20;
      this.i = (n / 20);
      if (i1 > 0)
        this.i = (1 + this.i);
      a(this.i, this.j);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJFeedActivity
 * JD-Core Version:    0.6.2
 */