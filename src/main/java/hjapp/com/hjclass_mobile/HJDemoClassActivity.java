package hjapp.com.hjclass_mobile;

import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import hjapp.com.hjclass_mobile.d.t;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HJDemoClassActivity extends BaseActivity
  implements OnClickListener, OnItemClickListener, hjapp.com.hjclass_mobile.c.o
{
  private View a = null;
  private au b = null;
  private as c = null;
  private ListView d = null;
  private boolean e = true;
  private List f;
  private LinearLayout g = null;
  private hjapp.com.hjclass_mobile.b.b h = null;
  private ar i = null;
  private at j = null;
  private TextView k;
  private TextView l;
  private ImageView m;
  private HJApplication n = null;

  private int a(hjapp.com.hjclass_mobile.d.s params)
  {
    List localList = this.n.b();
    int i1 = localList.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      String str = ((hjapp.com.hjclass_mobile.d.s)localList.get(i2)).i();
      if (TextUtils.isEmpty(str))
        return -1;
      if (str.equals(params.i()))
        return -1;
    }
    return -2;
  }

  private static hjapp.com.hjclass_mobile.d.s a(t paramt)
  {
    hjapp.com.hjclass_mobile.d.s locals = new d.s();
    locals.a(paramt.d());
    locals.a(paramt.e());
    locals.d(paramt.m());
    locals.c(paramt.b());
    locals.b(paramt.g());
    locals.b(paramt.c());
    locals.e(paramt.f());
    locals.d(paramt.a());
    locals.e(paramt.q());
    locals.c(paramt.l());
    locals.f(paramt.p());
    locals.a(paramt.r());
    if (paramt.w() == 4)
      locals.f(paramt.w());
    return locals;
  }

  private int b(hjapp.com.hjclass_mobile.d.s params)
  {
    List localList = this.n.b();
    localList.add(params);
    return -1 + localList.size();
  }

  public final void a(Bitmap paramBitmap, int paramInt, ImageView paramImageView)
  {
    if (paramBitmap != null)
      paramImageView.setImageBitmap(paramBitmap);
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
    case 2131361850:
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this, HJSubDownloadTabActivity.class);
    startActivity(localIntent);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903079);
    this.n = ((HJApplication)getApplicationContext());
    if (this.i == null)
    {
      this.i = new ar(this, (byte)0);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("download_status");
      registerReceiver(this.i, localIntentFilter);
    }
    this.a = LayoutInflater.from(this).inflate(2130903078, null);
    hjapp.com.hjclass_mobile.h.z.a(this);
    if ((hjapp.com.hjclass_mobile.h.z.h) && (!hjapp.com.hjclass_mobile.h.z.i))
      Toast.makeText(this, getString(2131492940), 1).show();
    ((Button)findViewById(2131361816)).setOnClickListener(this);
    this.h = new hjapp.com.hjclass_mobile.b.b(this);
    this.g = ((LinearLayout)findViewById(2131361852));
    this.d = ((ListView)findViewById(2131361951));
    this.d.setCacheColorHint(0);
    this.d.setOnItemClickListener(this);
    ((Button)findViewById(2131361850)).setOnClickListener(this);
    this.j = new at(this, this);
    this.f = new ArrayList();
    this.d.addHeaderView(this.a, null, false);
    this.d.setAdapter(this.j);
    if (this.f.size() > 0)
      this.f.clear();
    this.m = ((ImageView)this.a.findViewById(2131361836));
    this.k = ((TextView)findViewById(2131361854));
    this.l = ((TextView)findViewById(2131361870));
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      String str = localBundle.getString("iconUrl");
      new hjapp.com.hjclass_mobile.b.n(this, this.m, 10022).execute(new String[] { str });
      this.k.setText(localBundle.getString("classname"));
      this.l.setText(localBundle.getInt("studyNum") + "/" + localBundle.getInt("lessonNum"));
    }
    this.c = new as(this, (byte)0);
    as localas = this.c;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = c.a();
    arrayOfObject[1] = Integer.valueOf(10022);
    arrayOfObject[2] = Integer.valueOf(1);
    localas.execute(arrayOfObject);
  }

  protected void onDestroy()
  {
    unregisterReceiver(this.i);
    hjapp.com.hjclass_mobile.h.z.b(this);
    super.onDestroy();
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.d.getHeaderViewsCount() > 0)
      paramInt--;
    if (!hjapp.com.hjclass_mobile.h.z.d())
    {
      Toast.makeText(this, getString(2131492966), 0).show();
      return;
    }
    t localt = (t)this.f.get(paramInt);
    if ((localt != null) && (localt.b() == 3));
    for (int i1 = 1; ; i1 = 0)
    {
      int i2;
      if ((localt != null) && (hjapp.com.hjclass_mobile.h.z.a(localt.a(), localt.d(), localt.c())))
      {
        i2 = 1;
        int i3 = localt.a();
        localt.d();
        boolean bool = hjapp.com.hjclass_mobile.h.z.a(i3, localt.l());
        if ((i2 == 0) && (i1 != 0))
        {
          if (!bool)
            break label384;
          Log.i("===", "isZipValid true");
        }
        if ((i2 == 0) || ((localt.b() == 5) && (localt.b() == 1)) || (bool))
          break label696;
      }
      label384: label696: for (int i4 = 1; ; i4 = i1)
      {
        if (i4 != 0)
        {
          Intent localIntent1 = new Intent();
          localIntent1.putExtra("lesson", localt);
          localIntent1.putExtra("filePath", hjapp.com.hjclass_mobile.h.z.c + localt.a() + File.separator + localt.d() + File.separator + localt.c() + File.separator + "index.xml");
          if ((localt.b() != 3) || (localt.f() != 100))
          {
            localt.d(localt.d());
            localt.a(localt.a());
            localt.b(3);
            localt.e(100);
            this.h.a(localt);
            this.j.notifyDataSetChanged();
          }
          if (localt.w() == 3)
            localIntent1.setClass(this, HJClassPlayer.class);
          while (true)
          {
            localIntent1.setFlags(541065216);
            startActivity(localIntent1);
            return;
            i2 = 0;
            break;
            Toast.makeText(this, getString(2131492922), 0).show();
            return;
            localIntent1.setClass(this, HJClassPlayerV3.class);
          }
        }
        hjapp.com.hjclass_mobile.d.s locals = a(localt);
        int i5 = a(locals);
        if ((hjapp.com.hjclass_mobile.h.z.h) && (!hjapp.com.hjclass_mobile.h.z.i) && (i5 == -2))
        {
          Builder localBuilder = new Builder(this);
          localBuilder.setMessage(getString(2131493023));
          localBuilder.setPositiveButton(getString(2131492879), new ap(this, i5, locals, localt));
          localBuilder.setNeutralButton(getString(2131492880), new aq(this));
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
        int i6 = b(a(localt));
        localt.b(4);
        this.j.notifyDataSetChanged();
        Intent localIntent3 = new Intent("check_task");
        localIntent3.putExtra("position", i6);
        sendBroadcast(localIntent3);
        Toast.makeText(this, getString(2131492952), 0).show();
        return;
      }
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJDemoClassActivity
 * JD-Core Version:    0.6.2
 */