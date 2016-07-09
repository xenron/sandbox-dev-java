package hjapp.com.hjclass_mobile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.util.List;

public class HJClassExpiredListActivity extends BaseActivity
  implements OnClickListener, OnItemClickListener, hjapp.com.hjclass_mobile.c.o
{
  private q a = null;
  private ListView b = null;
  private List c;
  private p d = null;
  private o e = null;
  private boolean f = false;
  private LinearLayout g = null;
  private hjapp.com.hjclass_mobile.b.b h = null;
  private Button i = null;
  private View j = null;
  private hjapp.com.hjclass_mobile.h.v k = null;
  private Bitmap l = null;
  private int m = 1;

  private void a(int paramInt)
  {
    if (this.f)
      return;
    this.g.setVisibility(0);
    if (this.e != null)
    {
      this.e.cancel(true);
      this.e = null;
    }
    this.f = true;
    this.e = new o(this, (byte)0);
    o localo = this.e;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = c.a();
    arrayOfString[1] = String.valueOf(paramInt);
    localo.execute(arrayOfString);
  }

  public final void a(Bitmap paramBitmap, int paramInt, ImageView paramImageView)
  {
    if (paramBitmap != null)
    {
      this.k.a(Integer.valueOf(paramInt), paramBitmap);
      paramImageView.setImageBitmap(paramBitmap);
    }
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131361994:
      sendBroadcast(new Intent("free_lesson_study"));
      finish();
      return;
    case 2131361850:
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this, HJDownloadActivity.class);
    startActivity(localIntent);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903080);
    hjapp.com.hjclass_mobile.h.z.a(this);
    this.j = findViewById(2131361845);
    this.i = ((Button)this.j.findViewById(2131361994));
    this.i.setOnClickListener(this);
    this.g = ((LinearLayout)findViewById(2131361844));
    this.b = ((ListView)findViewById(2131361846));
    this.b.setCacheColorHint(0);
    this.b.setOnItemClickListener(this);
    ((Button)findViewById(2131361850)).setOnClickListener(this);
    this.h = new hjapp.com.hjclass_mobile.b.b(this);
    this.k = new h.v(20);
    this.l = BitmapFactory.decodeResource(getResources(), 2130837515);
    a(this.m);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623939, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }

  protected void onDestroy()
  {
    hjapp.com.hjclass_mobile.h.z.b(this);
    super.onDestroy();
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    hjapp.com.hjclass_mobile.d.q localq = (hjapp.com.hjclass_mobile.d.q)this.c.get(paramInt);
    Intent localIntent = new Intent();
    localIntent.setClass(this, HJLessonListActivity.class);
    localIntent.putExtra("classid", localq.a());
    localIntent.putExtra("classname", localq.f());
    localIntent.putExtra("des", localq.k());
    localIntent.putExtra("teacher", localq.l());
    localIntent.putExtra("lessonNum", localq.b());
    localIntent.putExtra("iconUrl", localq.j());
    localIntent.putExtra("studyNum", localq.c());
    localIntent.putExtra("opentime", localq.g() + "-" + localq.i());
    localIntent.putExtra("mode", "pay");
    startActivity(localIntent);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    case 2131362129:
    case 2131362130:
    default:
    case 2131362128:
    case 2131362131:
    }
    while (true)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      a(this.m);
      continue;
      finish();
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJClassExpiredListActivity
 * JD-Core Version:    0.6.2
 */