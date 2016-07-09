package hjapp.com.hjclass_mobile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class HJStudyCardSubCourseActivity extends BaseActivity
  implements OnItemClickListener, hjapp.com.hjclass_mobile.c.o
{
  private dh a = null;
  private ListView b = null;
  private List c;
  private dg d = null;
  private df e = null;
  private boolean f = false;
  private LinearLayout g = null;
  private View h = null;
  private hjapp.com.hjclass_mobile.h.v i = null;
  private Bitmap j = null;

  public final void a(Bitmap paramBitmap, int paramInt, ImageView paramImageView)
  {
    if (paramBitmap != null)
    {
      this.i.a(Integer.valueOf(paramInt), paramBitmap);
      paramImageView.setImageBitmap(paramBitmap);
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903049);
    hjapp.com.hjclass_mobile.h.z.a(this);
    this.h = findViewById(2131361845);
    ((TextView)findViewById(2131362008)).setText(2131493137);
    ((Button)findViewById(2131361994)).setVisibility(8);
    this.g = ((LinearLayout)findViewById(2131361844));
    this.b = ((ListView)findViewById(2131361846));
    this.b.setCacheColorHint(0);
    this.b.setTextFilterEnabled(true);
    this.b.setOnItemClickListener(this);
    this.i = new h.v(20);
    this.j = BitmapFactory.decodeResource(getResources(), 2130837515);
    this.c = ((List)getIntent().getExtras().getSerializable("list"));
    if (!this.f)
    {
      this.g.setVisibility(0);
      if (this.e != null)
      {
        this.e.cancel(true);
        this.e = null;
      }
      this.f = true;
      this.e = new df(this, (byte)0);
      df localdf = this.e;
      String[] arrayOfString = new String[2];
      arrayOfString[0] = c.a();
      arrayOfString[1] = "";
      localdf.execute(arrayOfString);
    }
  }

  protected void onDestroy()
  {
    hjapp.com.hjclass_mobile.h.z.b(this);
    super.onDestroy();
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    hjapp.com.hjclass_mobile.d.w localw = (hjapp.com.hjclass_mobile.d.w)this.c.get(paramInt);
    Intent localIntent = new Intent();
    localIntent.setClass(this, HJStudyCardCourseLessonActivity.class);
    localIntent.putExtra("classname", localw.b());
    localIntent.putExtra("iconUrl", localw.c());
    localIntent.putExtra("classid", localw.a());
    localIntent.putExtra("classXB", localw.d() + getString(2131493039));
    localIntent.putExtra("des", localw.h().replace("{br}", "\r\n    "));
    localIntent.putExtra("teacher", localw.e());
    localIntent.putExtra("opentime", localw.f() + "-" + localw.g());
    localIntent.putExtra("mode", "pay");
    startActivity(localIntent);
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJStudyCardSubCourseActivity
 * JD-Core Version:    0.6.2
 */