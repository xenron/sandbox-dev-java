package hjapp.com.hjclass_mobile;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import hjapp.com.hjclass_mobile.d.s;
import hjapp.com.hjclass_mobile.d.t;
import hjapp.com.hjclass_mobile.view.LessonButton;

import java.util.ArrayList;
import java.util.List;

public class HJCoureseLessonActivity extends BaseActivity
  implements OnClickListener, hjapp.com.hjclass_mobile.c.o
{
  private TextView A;
  private ImageView B;
  private View C;
  private View D;
  private boolean E = true;
  private int F = 0;
  private View G;
  private HJApplication H = null;
  private Button I = null;
  private OnClickListener J = new ak(this);
  private List a;
  private hjapp.com.hjclass_mobile.b.b b = null;
  private ao c = null;
  private boolean d = false;
  private LinearLayout e = null;
  private int f;
  private TextView g = null;
  private Button h = null;
  private an i = null;
  private boolean j = true;
  private LinearLayout k = null;
  private PopupWindow l = null;
  private View m;
  private boolean n = true;
  private TableLayout o;
  private TableLayout p;
  private LessonButton q;
  private TableLayout.LayoutParams r;
  private final int s = -2;
  private final int t = -1;
  private List u;
  private List v;
  private TextView w;
  private TextView x;
  private TextView y;
  private TextView z;

  private int a(s params)
  {
    this.H.b().add(params);
    return -1 + this.H.b().size();
  }

  private void a(int paramInt)
  {
    int i1 = this.a.size();
    for (int i2 = 0; ; i2++)
      if (i2 < i1)
      {
        if (((t)this.a.get(i2)).c() == paramInt)
          c();
      }
      else
        return;
  }

  private void a(List paramList)
  {
    TableRow localTableRow1 = new TableRow(this);
    if (!this.E)
      localTableRow1.setPadding(30, 0, 5, 5);
    int i1;
    while (true)
    {
      this.p.addView(localTableRow1, this.r);
      i1 = paramList.size();
      if (i1 != 0)
        break;
      this.p.setVisibility(8);
      return;
      localTableRow1.setPadding(16, 0, 2, 5);
    }
    this.p.setVisibility(0);
    int i2;
    label88: Object localObject1;
    int i3;
    label94: TableRow localTableRow2;
    if (this.E)
    {
      i2 = 3;
      localObject1 = localTableRow1;
      i3 = 0;
      if (i3 < i1)
      {
        if (i3 % i2 != 0)
          break label437;
        localTableRow2 = new TableRow(this);
        if (this.E)
          break label333;
        localTableRow2.setPadding(18, 5, 5, 5);
        label135: this.p.addView(localTableRow2, this.r);
      }
    }
    label390: label437: for (Object localObject2 = localTableRow2; ; localObject2 = localObject1)
    {
      t localt = (t)paramList.get(i3);
      this.q = new LessonButton(this);
      this.q.setTag(localt);
      int i4 = localt.n();
      label212: LinearLayout localLinearLayout;
      LinearLayout.LayoutParams localLayoutParams;
      if (i4 == 0)
      {
        this.q.setText(getString(2131492938));
        this.q.setTextColor(-10066330);
        this.q.setOnClickListener(this.J);
        this.q.setBackgroundResource(2130837732);
        localLinearLayout = new LinearLayout(this);
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (this.F != 0)
          break label390;
        localLayoutParams.rightMargin = 5;
        localLayoutParams.leftMargin = 10;
      }
      while (true)
      {
        localLinearLayout.addView(this.q, localLayoutParams);
        ((TableRow)localObject2).addView(localLinearLayout);
        i3++;
        localObject1 = localObject2;
        break label94;
        break;
        if (this.F == 1)
        {
          i2 = 4;
          break label88;
        }
        i2 = 5;
        break label88;
        label333: localTableRow2.setPadding(5, 5, 2, 5);
        break label135;
        this.q.setText(getString(2131493025) + i4 + getString(2131493026));
        break label212;
        if (this.F == 1)
          if (this.E)
          {
            localLayoutParams.rightMargin = 3;
            localLayoutParams.leftMargin = 5;
          }
          else
          {
            localLayoutParams.rightMargin = 6;
            localLayoutParams.leftMargin = 12;
          }
      }
    }
  }

  private int b(s params)
  {
    List localList = this.H.b();
    int i1 = localList.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      String str = ((s)localList.get(i2)).i();
      if (TextUtils.isEmpty(str))
        return -1;
      if (str.equals(params.i()))
        return -1;
    }
    return -2;
  }

  private void c()
  {
    this.u.clear();
    this.v.clear();
    int i1 = this.a.size();
    int i2 = 0;
    if (i2 < i1)
    {
      t localt2 = (t)this.a.get(i2);
      if (localt2.b() == 3)
        this.u.add(localt2);
      while (true)
      {
        i2++;
        break;
        this.v.add(localt2);
      }
    }
    this.o.removeAllViews();
    this.p.removeAllViews();
    List localList = this.u;
    TableRow localTableRow1 = new TableRow(this);
    int i3;
    label148: label170: Object localObject1;
    int i5;
    label177: TableRow localTableRow2;
    if (!this.E)
    {
      localTableRow1.setPadding(30, 0, 5, 5);
      if (!this.E)
        break label426;
      i3 = 3;
      int i4 = localList.size();
      if (i4 != 0)
        break label446;
      this.o.setVisibility(8);
      localObject1 = localTableRow1;
      i5 = 0;
      if (i5 >= i4)
        break label561;
      if (i5 % i3 != 0)
        break label570;
      localTableRow2 = new TableRow(this);
      if (this.E)
        break label457;
      localTableRow2.setPadding(18, 5, 5, 5);
      label219: this.o.addView(localTableRow2, this.r);
    }
    label426: label561: label570: for (Object localObject2 = localTableRow2; ; localObject2 = localObject1)
    {
      this.q = new LessonButton(this);
      t localt1 = (t)localList.get(i5);
      if (localt1.j() > 0)
        this.q.a(2130837693);
      this.q.setTag(localt1);
      int i6 = localt1.n();
      label314: LinearLayout localLinearLayout;
      LinearLayout.LayoutParams localLayoutParams;
      if (i6 == 0)
      {
        this.q.setText(getString(2131492938));
        this.q.setTextColor(-1);
        this.q.setOnClickListener(this.J);
        this.q.setBackgroundResource(2130837730);
        localLinearLayout = new LinearLayout(this);
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (this.F != 0)
          break label514;
        localLayoutParams.rightMargin = 5;
        localLayoutParams.leftMargin = 10;
      }
      while (true)
      {
        localLinearLayout.addView(this.q, localLayoutParams);
        ((TableRow)localObject2).addView(localLinearLayout);
        i5++;
        localObject1 = localObject2;
        break label177;
        localTableRow1.setPadding(16, 0, 2, 5);
        break;
        if (this.F == 1)
        {
          i3 = 4;
          break label148;
        }
        i3 = 5;
        break label148;
        label446: this.o.setVisibility(0);
        break label170;
        label457: localTableRow2.setPadding(5, 5, 2, 5);
        break label219;
        this.q.setText(getString(2131493025) + i6 + getString(2131493026));
        break label314;
        if (this.F == 1)
          if (this.E)
          {
            localLayoutParams.rightMargin = 3;
            localLayoutParams.leftMargin = 5;
          }
          else
          {
            localLayoutParams.rightMargin = 6;
            localLayoutParams.leftMargin = 12;
          }
      }
      a(this.v);
      return;
    }
  }

  public final void a(Bitmap paramBitmap, int paramInt, ImageView paramImageView)
  {
    if (paramBitmap != null)
      paramImageView.setImageBitmap(paramBitmap);
  }

  public final void b()
  {
    this.d = false;
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
      Intent localIntent2 = new Intent();
      localIntent2.setClass(this, HJSubDownloadTabActivity.class);
      startActivity(localIntent2);
      return;
    case 2131361871:
      if (this.n)
      {
        this.n = false;
        if (this.l.isShowing())
          this.l.dismiss();
        this.k.setBackgroundResource(2130837606);
        if (this.F == 0)
        {
          this.l.showAtLocation(this.m, 80, 0, 76);
          return;
        }
        this.l.showAtLocation(this.m, 80, 0, 51);
        return;
      }
      this.n = true;
      this.l.dismiss();
      this.k.setBackgroundResource(2130837599);
      return;
    case 2131361857:
    }
    Intent localIntent1 = new Intent();
    localIntent1.setClass(this, HJExchangeAcitvity.class);
    localIntent1.putExtras(getIntent().getExtras());
    startActivity(localIntent1);
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.H = ((HJApplication)getApplicationContext());
    setContentView(2130903051);
    if (this.i == null)
    {
      this.i = new an(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("download_status");
      localIntentFilter.addAction("delete_file");
      registerReceiver(this.i, localIntentFilter);
    }
    z.a(this);
    if ((z.h) && (!z.i))
      Toast.makeText(this, getString(2131492940), 1).show();
    this.m = findViewById(2131361848);
    this.G = findViewById(2131361851);
    this.h = ((Button)findViewById(2131361816));
    this.h.setOnClickListener(this);
    ((Button)findViewById(2131361850)).setOnClickListener(this);
    this.g = ((TextView)findViewById(2131361849));
    this.D = findViewById(2131361818);
    this.w = ((TextView)findViewById(2131361831));
    this.x = ((TextView)findViewById(2131361833));
    this.y = ((TextView)findViewById(2131361834));
    this.z = ((TextView)findViewById(2131361835));
    this.A = ((TextView)findViewById(2131361854));
    this.B = ((ImageView)findViewById(2131361836));
    this.C = findViewById(2131361853);
    this.I = ((Button)findViewById(2131361857));
    this.I.setOnClickListener(this);
    Bundle localBundle = getIntent().getExtras();
    this.b = new hjapp.com.hjclass_mobile.b.b(this);
    this.e = ((LinearLayout)findViewById(2131361852));
    this.o = ((TableLayout)findViewById(2131361855));
    this.p = ((TableLayout)findViewById(2131361856));
    this.r = new TableLayout.LayoutParams(-1, -2);
    this.p.setShrinkAllColumns(true);
    this.o.setShrinkAllColumns(true);
    this.r.gravity = 17;
    this.u = new ArrayList();
    this.v = new ArrayList();
    if (localBundle != null)
    {
      this.d = true;
      this.a = new ArrayList();
      this.f = localBundle.getInt("classid");
      this.g.setText(getString(2131492931));
      this.w.setText(localBundle.getString("classXB"));
      u.b("未开通课程界面，开课需要学币", localBundle.getString("classXB"));
      this.x.setText(localBundle.getString("teacher"));
      this.y.setText(localBundle.getString("opentime").replace("0:00:00", ""));
      this.z.setText(getString(2131492935) + "\n" + localBundle.getString("des"));
      String str = localBundle.getString("iconUrl");
      new hjapp.com.hjclass_mobile.b.n(this, this.B, this.f).execute(new String[] { str });
      this.A.setText(localBundle.getString("classname"));
      this.c = new ao(this, (byte)0);
      if (this.a.size() > 0)
        this.a.clear();
      ao localao = this.c;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = c.a();
      arrayOfObject[1] = Integer.valueOf(this.f);
      arrayOfObject[2] = Integer.valueOf(1);
      localao.execute(arrayOfObject);
    }
  }

  protected void onDestroy()
  {
    unregisterReceiver(this.i);
    z.b(this);
    super.onDestroy();
  }

  protected void onResume()
  {
    super.onResume();
    this.j = true;
  }

  protected void onStart()
  {
    this.j = true;
    super.onStart();
  }

  protected void onStop()
  {
    this.j = false;
    super.onStop();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJCoureseLessonActivity
 * JD-Core Version:    0.6.2
 */