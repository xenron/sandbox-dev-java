package hjapp.com.hjclass_mobile;

import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;
import hjapp.com.hjclass_mobile.pkg_b.b;
import hjapp.com.hjclass_mobile.pkg_d.s;
import hjapp.com.hjclass_mobile.pkg_d.t;
import hjapp.com.hjclass_mobile.pkg_h.v;
import hjapp.com.hjclass_mobile.view.HJGallery;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HJFreeLessonListActivity extends BaseActivity
  implements OnClickListener, OnItemClickListener, OnItemSelectedListener, hjapp.com.hjclass_mobile.pkg_c.o
{
  private static v q = new v(10);
  private List a;
  private bq b = null;
  private b c = null;
  private bs d = null;
  private boolean e = false;
  private LinearLayout f = null;
  private bp g = null;
  private boolean h = true;
  private Bitmap i = null;
  private RadioButton j;
  private RadioButton k;
  private RadioButton l;
  private RadioButton m;
  private RadioButton n;
  private RadioButton o;
  private HJGallery p;
  private bu r = null;
  private ListView s = null;
  private List t;
  private bt u = null;
  private View v = null;
  private HJApplication w = null;
  private OnItemClickListener x = new bo(this);

  private int a(s params)
  {
    int i1 = this.w.b().size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      String str = ((s)this.w.b().get(i2)).i();
      if (TextUtils.isEmpty(str))
        return -1;
      if (str.equals(params.i()))
        return -1;
    }
    return -2;
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    if (!hjapp.com.hjclass_mobile.h.z.d())
    {
      Toast.makeText(this, getString(2131492966), 0).show();
      return;
    }
    t localt;
    if (paramBoolean)
    {
      localt = (t)this.t.get(paramInt);
      if ((localt == null) || (localt.b() != 3))
        break label801;
    }
    label794: label801: for (int i1 = 1; ; i1 = 0)
    {
      int i2;
      if ((localt != null) && (hjapp.com.hjclass_mobile.h.z.a(localt.a(), localt.d(), localt.c())))
      {
        i2 = 1;
        label79: int i3 = localt.a();
        localt.d();
        boolean bool = hjapp.com.hjclass_mobile.h.z.a(i3, localt.l());
        if ((i2 == 0) && (i1 != 0))
        {
          if (!bool)
            break label352;
          Log.i("===", "isZipValid true");
        }
        if ((i2 == 0) || ((localt.b() == 5) && (localt.b() == 1)) || (bool))
          break label794;
      }
      for (int i4 = 1; ; i4 = i1)
      {
        if (i4 != 0)
        {
          Intent localIntent1 = new Intent();
          localIntent1.putExtra("lesson", localt);
          localIntent1.putExtra("filePath", hjapp.com.hjclass_mobile.h.z.c + localt.a() + File.separator + localt.d() + File.separator + localt.c() + File.separator + "index.xml");
          if ((localt.b() != 3) || (localt.f() != 100))
          {
            localt.d(1);
            localt.a(1);
            localt.b(3);
            localt.e(100);
            this.c.a(localt);
            this.b.notifyDataSetChanged();
          }
          if (localt.w() == 4)
            localIntent1.setClass(this, HJClassPlayerV3.class);
          while (true)
          {
            localIntent1.setFlags(541065216);
            startActivity(localIntent1);
            return;
            localt = (t)this.a.get(paramInt);
            break;
            i2 = 0;
            break label79;
            label352: Toast.makeText(this, getString(2131492922), 0).show();
            return;
            localIntent1.setClass(this, HJClassPlayer.class);
          }
        }
        s locals = new s();
        locals.a(localt.d());
        locals.a(localt.e());
        locals.d(localt.m());
        locals.c(localt.b());
        locals.b(localt.g());
        locals.b(localt.c());
        locals.e(localt.f());
        locals.d(localt.a());
        locals.e(localt.q());
        locals.c(localt.l());
        locals.f(localt.p());
        locals.a(localt.r());
        locals.f(localt.w());
        int i5 = a(locals);
        if ((hjapp.com.hjclass_mobile.h.z.h) && (!hjapp.com.hjclass_mobile.h.z.i) && (i5 == -2))
        {
          Builder localBuilder = new Builder(this);
          localBuilder.setMessage(getString(2131493023));
          localBuilder.setPositiveButton(getString(2131492879), new bm(this, i5, locals, localt, paramBoolean));
          localBuilder.setNeutralButton(getString(2131492880), new bn(this));
          localBuilder.create().show();
          return;
        }
        if (i5 == -1)
        {
          Intent localIntent2 = new Intent();
          localIntent2.setClass(this, HJSubDownloadTabActivity.class);
          startActivity(localIntent2);
          Toast.makeText(this, getString(2131492953), 0).show();
          return;
        }
        long l1 = hjapp.com.hjclass_mobile.h.z.e();
        if (52428800L > l1)
        {
          String str = getString(2131493042);
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Long.valueOf(l1);
          Toast.makeText(this, hjapp.com.hjclass_mobile.h.y.a(str, arrayOfObject), 0).show();
          return;
        }
        int i6 = b(locals);
        localt.b(4);
        if (paramBoolean)
          this.u.notifyDataSetChanged();
        while (true)
        {
          Intent localIntent3 = new Intent("check_task");
          localIntent3.putExtra("position", i6);
          sendBroadcast(localIntent3);
          Toast.makeText(this, getString(2131492952), 0).show();
          return;
          this.b.notifyDataSetChanged();
        }
      }
    }
  }

  private int b(s params)
  {
    this.w.b().add(params);
    return -1 + this.w.b().size();
  }

  public final void a(Bitmap paramBitmap, int paramInt, ImageView paramImageView)
  {
    if (paramBitmap != null)
    {
      q.a(Integer.valueOf(paramInt), paramBitmap);
      paramImageView.setImageBitmap(paramBitmap);
    }
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131361799:
      a((int)this.p.getSelectedItemId(), false);
      return;
    case 2131361850:
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this, HJSubDownloadTabActivity.class);
    startActivity(localIntent);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("=====islogin_free", hjapp.com.hjclass_mobile.h.z.j);
    setContentView(2130903081);
    this.w = ((HJApplication)getApplicationContext());
    if (this.g == null)
    {
      this.g = new bp(this, (byte)0);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("download_status");
      localIntentFilter.addAction("delete_file");
      registerReceiver(this.g, localIntentFilter);
    }
    this.v = LayoutInflater.from(this).inflate(2130903042, null);
    hjapp.com.hjclass_mobile.h.z.a(this);
    this.i = BitmapFactory.decodeResource(getResources(), 2130837741);
    if ((hjapp.com.hjclass_mobile.h.z.h) && (!hjapp.com.hjclass_mobile.h.z.i))
      Toast.makeText(this, getString(2131492940), 1).show();
    this.c = new b(this);
    this.f = ((LinearLayout)findViewById(2131361852));
    this.s = ((ListView)findViewById(2131361951));
    this.s.setCacheColorHint(0);
    this.s.setOnItemClickListener(this);
    ((Button)findViewById(2131361850)).setOnClickListener(this);
    this.s.setOnCreateContextMenuListener(this);
    this.p = ((HJGallery)this.v.findViewById(2131361800));
    this.p.setOnItemSelectedListener(this);
    this.p.setOnItemClickListener(this.x);
    this.j = ((RadioButton)this.v.findViewById(2131361802));
    this.j.setClickable(false);
    this.k = ((RadioButton)this.v.findViewById(2131361803));
    this.k.setClickable(false);
    this.l = ((RadioButton)this.v.findViewById(2131361804));
    this.l.setClickable(false);
    this.m = ((RadioButton)this.v.findViewById(2131361805));
    this.m.setClickable(false);
    this.n = ((RadioButton)this.v.findViewById(2131361806));
    this.n.setClickable(false);
    this.o = ((RadioButton)this.v.findViewById(2131361807));
    this.o.setClickable(false);
    this.b = new bq(this, this);
    this.a = new ArrayList();
    this.d = new bs(this, (byte)0);
    bs localbs = this.d;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(1);
    arrayOfObject[1] = Integer.valueOf(1);
    localbs.execute(arrayOfObject);
    this.t = new ArrayList();
    this.u = new bt(this, this);
    this.s.addHeaderView(this.v);
    this.s.setAdapter(this.u);
  }

  protected void onDestroy()
  {
    unregisterReceiver(this.g);
    hjapp.com.hjclass_mobile.h.z.b(this);
    super.onDestroy();
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.s.getHeaderViewsCount() > 0)
      paramInt--;
    a(paramInt, true);
  }

  public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramInt)
    {
    default:
      return;
    case 0:
      this.j.setChecked(true);
      return;
    case 1:
      this.k.setChecked(true);
      return;
    case 2:
      this.l.setChecked(true);
      return;
    case 3:
      this.m.setChecked(true);
      return;
    case 4:
      this.n.setChecked(true);
      return;
    case 5:
    }
    this.o.setChecked(true);
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      a();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public void onNothingSelected(AdapterView paramAdapterView)
  {
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJFreeLessonListActivity
 * JD-Core Version:    0.6.2
 */