package hjapp.com.hjclass_mobile;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import hjapp.com.hjclass_mobile.pkg_d.q;

import java.util.ArrayList;
import java.util.List;

public class HJSubCourseActivity extends BaseActivity
  implements OnItemClickListener, hjapp.com.hjclass_mobile.pkg_c.o
{
  private dm a = null;
  private ListView b = null;
  private List c;
  private List d;
  private dk e = null;
  private dj f = null;
  private boolean g = false;
  private LinearLayout h = null;
  private hjapp.com.hjclass_mobile.pkg_b.b i = null;
  private View j = null;
  private hjapp.com.hjclass_mobile.pkg_h.v k = null;
  private Bitmap l = null;
  private String m = "en";
  private dn n = null;

  private void a(String paramString)
  {
    if (this.g)
      return;
    this.h.setVisibility(0);
    if (this.f != null)
    {
      this.f.cancel(true);
      this.f = null;
    }
    this.g = true;
    this.f = new dj(this, (byte)0);
    dj localdj = this.f;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = c.a();
    arrayOfString[1] = paramString;
    localdj.execute(arrayOfString);
  }

  public final void a(Bitmap paramBitmap, int paramInt, ImageView paramImageView)
  {
    if (paramBitmap != null)
    {
      this.k.a(Integer.valueOf(paramInt), paramBitmap);
      paramImageView.setImageBitmap(paramBitmap);
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.n == null)
    {
      this.n = new dn(this, (byte)0);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("search_course");
      registerReceiver(this.n, localIntentFilter);
    }
    setContentView(2130903049);
    hjapp.com.hjclass_mobile.h.z.a(this);
    this.j = findViewById(2131361845);
    this.d = new ArrayList();
    this.h = ((LinearLayout)findViewById(2131361844));
    this.b = ((ListView)findViewById(2131361846));
    this.b.setCacheColorHint(0);
    this.b.setTextFilterEnabled(true);
    this.b.setOnItemClickListener(this);
    this.i = new hjapp.com.hjclass_mobile.pkg_b.b(this);
    this.k = new pkg_h.v(20);
    this.l = BitmapFactory.decodeResource(getResources(), 2130837515);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      this.m = localBundle.getString("langs");
      a(this.m);
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }

  protected void onDestroy()
  {
    hjapp.com.hjclass_mobile.h.z.b(this);
    unregisterReceiver(this.n);
    super.onDestroy();
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    q localq = (q)this.d.get(paramInt);
    Intent localIntent = new Intent();
    localIntent.putExtra("classname", localq.f());
    localIntent.putExtra("lessonNum", localq.b());
    localIntent.putExtra("iconUrl", localq.j());
    localIntent.putExtra("studyNum", localq.c());
    localIntent.putExtra("classid", localq.a());
    hjapp.com.hjclass_mobile.h.u.b("随意获取的classid", localq.a());
    localIntent.putExtra("classtype", localq.r());
    if (localq.a() == 10022)
    {
      localIntent.setClass(this, HJDemoClassActivity.class);
      startActivity(localIntent);
      return;
    }
    if (localq.o() == 1)
    {
      if ((localq.s() == 1) && (localq.t() == 0))
      {
        String str = getString(2131493128);
        int i1 = localq.a();
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
        localBuilder.setTitle("提示").setMessage(str).setPositiveButton("确定", new di(this, i1));
        localBuilder.show();
        return;
      }
      localIntent.setClass(this, HJLessonListActivity.class);
    }
    while (true)
    {
      localIntent.putExtra("des", localq.k());
      localIntent.putExtra("teacher", localq.l());
      localIntent.putExtra("opentime", localq.g() + "-" + localq.i());
      localIntent.putExtra("mode", "pay");
      startActivity(localIntent);
      return;
      localIntent.setClass(this, HJCoureseLessonActivity.class);
      localIntent.putExtra("classXB", localq.n() + getString(2131493039));
    }
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131362128:
    }
    while (true)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      a(this.m);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJSubCourseActivity
 * JD-Core Version:    0.6.2
 */