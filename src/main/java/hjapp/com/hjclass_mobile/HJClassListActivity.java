package hjapp.com.hjclass_mobile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import hjapp.com.hjclass_mobile.pkg_b.b;
import hjapp.com.hjclass_mobile.pkg_d.a;
import hjapp.com.hjclass_mobile.pkg_d.q;
import hjapp.com.hjclass_mobile.view.widget.k;
import java.util.List;

public class HJClassListActivity extends BaseActivity
  implements OnClickListener, OnItemClickListener, hjapp.com.hjclass_mobile.pkg_c.o
{
  OnItemClickListener a = new t(this);
  private w b = null;
  private ListView c = null;
  private List d;
  private v e = null;
  private u f = null;
  private boolean g = false;
  private LinearLayout h = null;
  private b i = null;
  private Button j = null;
  private View k = null;
  private hjapp.com.hjclass_mobile.pkg_h.v l = null;
  private Bitmap m = null;
  private int n = 0;
  private k o = null;
  private Button p = null;

  private void a(int paramInt)
  {
    NetworkInfo localNetworkInfo = hjapp.com.hjclass_mobile.h.z.a(this);
    if (!hjapp.com.hjclass_mobile.h.z.b(this))
    {
      hjapp.com.hjclass_mobile.h.z.h = false;
      this.h.setVisibility(0);
      if ((this.f != null) && (this.g))
      {
        this.f.cancel(true);
        this.f = null;
      }
      this.g = true;
      this.f = new u(this, (byte)0);
      u localu = this.f;
      String[] arrayOfString = new String[2];
      arrayOfString[0] = c.a();
      arrayOfString[1] = String.valueOf(paramInt);
      localu.execute(arrayOfString);
      return;
    }
    hjapp.com.hjclass_mobile.h.z.h = true;
    if (localNetworkInfo.getType() == 1);
    for (boolean bool = true; ; bool = false)
    {
      hjapp.com.hjclass_mobile.h.z.i = bool;
      break;
    }
  }

  public final void a(Bitmap paramBitmap, int paramInt, ImageView paramImageView)
  {
    if (paramBitmap != null)
    {
      this.l.a(Integer.valueOf(paramInt), paramBitmap);
      paramImageView.setImageBitmap(paramBitmap);
    }
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131361816:
      finish();
      return;
    case 2131361994:
      sendBroadcast(new Intent("free_lesson_study"));
      return;
    case 2131361850:
      Intent localIntent = new Intent();
      localIntent.setClass(this, HJSubDownloadTabActivity.class);
      startActivity(localIntent);
      return;
    case 2131361950:
    }
    this.o.a(paramView);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903077);
    hjapp.com.hjclass_mobile.h.z.a(this);
    this.k = findViewById(2131361845);
    this.j = ((Button)this.k.findViewById(2131361994));
    this.j.setOnClickListener(this);
    this.p = ((Button)findViewById(2131361950));
    this.p.setOnClickListener(this);
    ((Button)findViewById(2131361816)).setOnClickListener(this);
    this.h = ((LinearLayout)findViewById(2131361844));
    this.c = ((ListView)findViewById(2131361846));
    this.c.setCacheColorHint(0);
    this.c.setOnItemClickListener(this);
    ((Button)findViewById(2131361850)).setOnClickListener(this);
    this.i = new b(this);
    this.l = new pkg_h.v(20);
    this.m = BitmapFactory.decodeResource(getResources(), 2130837515);
    this.n = 0;
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
      this.n = localBundle.getInt("more_type");
    this.o = new k(this);
    a locala1 = new a();
    locala1.a(0);
    locala1.a(true);
    locala1.a(getString(2131493184));
    a locala2 = new a();
    locala2.a(2);
    locala2.a(false);
    locala2.a(getString(2131493185));
    a locala3 = new a();
    locala3.a(1);
    locala3.a(false);
    locala3.a(getString(2131493186));
    a[] arrayOfa = { locala1, locala2, locala3 };
    this.o.a(arrayOfa);
    this.o.a(this.a);
    switch (this.n)
    {
    default:
      this.p.setText(locala1.b());
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      a(this.n);
      return;
      this.p.setText(locala1.b());
      continue;
      this.p.setText(locala3.b());
      continue;
      this.p.setText(locala2.b());
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623937, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }

  protected void onDestroy()
  {
    hjapp.com.hjclass_mobile.h.z.b(this);
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
    localIntent.putExtra("classtype", localq.r());
    if ((localq.s() == 1) && (localq.t() == 0))
    {
      String str = getString(2131493128);
      int i1 = localq.a();
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
      localBuilder.setTitle("提示").setMessage(str).setPositiveButton("确定", new s(this, i1));
      localBuilder.show();
      return;
    }
    if (localq.a() == 10022)
    {
      localIntent.setClass(this, HJDemoClassActivity.class);
      startActivity(localIntent);
      return;
    }
    if (this.n == 2)
    {
      localIntent.setClass(this, HJCoureseLessonActivity.class);
      localIntent.putExtra("classXB", localq.n() + getString(2131493039));
    }
    while (true)
    {
      localIntent.putExtra("des", localq.k());
      localIntent.putExtra("teacher", localq.l());
      localIntent.putExtra("opentime", localq.g() + "-" + localq.i());
      localIntent.putExtra("mode", "pay");
      startActivity(localIntent);
      return;
      localIntent.setClass(this, HJLessonListActivity.class);
    }
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
      a(this.n);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJClassListActivity
 * JD-Core Version:    0.6.2
 */