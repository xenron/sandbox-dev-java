package hjapp.com.hjclass_mobile;

import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import hjapp.com.hjclass_mobile.b.b;
import hjapp.com.hjclass_mobile.b.n;
import hjapp.com.hjclass_mobile.b.q;
import hjapp.com.hjclass_mobile.c.o;
import hjapp.com.hjclass_mobile.d.s;
import hjapp.com.hjclass_mobile.d.t;
import hjapp.com.hjclass_mobile.view.LessonButton;
import hjapp.com.hjclass_mobile.view.j;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HJLessonListActivity extends BaseActivity
  implements OnClickListener, OnItemClickListener, o
{
  private TextView A;
  private TextView B;
  private TextView C;
  private TextView D;
  private TextView E;
  private TextView F;
  private ImageView G;
  private View H;
  private View I;
  private boolean J = true;
  private int K = 0;
  private int L;
  private View M;
  private HJApplication N = null;
  private ListView O = null;
  private q P = null;
  private View Q;
  private View R;
  private Button S;
  private Button T;
  private View U = null;
  private ImageView V;
  private LinearLayout W;
  private LinearLayout X;
  private RadioButton Y;
  private RadioButton Z;
  protected Handler a = new cb(this);
  private WebView aa;
  private OnClickListener ab = new bv(this);
  private LinearLayout ac;
  private TextView ad;
  private TextView ae;
  private TextView af;
  private TextView ag;
  private OnClickListener ah = new bz(this);
  private OnClickListener ai = new ca(this);
  private List b;
  private b c = null;
  private ce d = null;
  private boolean e = false;
  private LinearLayout f = null;
  private int g;
  private int h;
  private TextView i = null;
  private Button j = null;
  private cd k = null;
  private boolean l = true;
  private LinearLayout m = null;
  private PopupWindow n = null;
  private View o;
  private boolean p = true;
  private TableLayout q;
  private TableLayout r;
  private LessonButton s;
  private TableLayout.LayoutParams t;
  private final int u = -2;
  private final int v = -1;
  private List w;
  private List x;
  private TextView y;
  private TextView z;

  private int a(s params)
  {
    this.N.b().add(params);
    return -1 + this.N.b().size();
  }

  private void a(int paramInt)
  {
    j localj = new j(0.0F, 90.0F, this.o.getWidth() / 2.0F, this.o.getHeight() / 2.0F);
    localj.setDuration(100L);
    localj.setFillAfter(true);
    localj.setAnimationListener(new cc(this, paramInt, (byte)0));
    this.o.startAnimation(localj);
  }

  private void a(t paramt)
  {
    if (!z.d())
    {
      Toast.makeText(this, getString(2131492966), 0).show();
      return;
    }
    int i1 = paramt.a();
    int i2 = paramt.d();
    if (this.c.h(i1, i2))
    {
      Toast.makeText(this, getString(2131493141), 0).show();
      return;
    }
    if ((paramt != null) && (paramt.b() == 3));
    for (int i3 = 1; ; i3 = 0)
    {
      int i4 = paramt.a();
      int i5 = paramt.d();
      if ((paramt != null) && (z.a(i4, i5, paramt.c())));
      for (int i6 = 1; ; i6 = 0)
      {
        boolean bool = z.a(i4, paramt.l());
        if ((i6 == 0) && (i3 != 0))
        {
          if (!bool)
            break;
          u.c("===", "isZipValid true");
        }
        if ((i6 != 0) && ((paramt.b() != 5) || (paramt.b() != 1)) && (!bool))
          i3 = 1;
        if (i3 == 0)
          break label400;
        if ((paramt.b() != 3) || (paramt.f() != 100))
        {
          paramt.b(3);
          paramt.e(100);
          this.c.a(paramt);
        }
        if ((!f()) || (paramt.j() != 0) || (!paramt.t()))
          break label268;
        Toast.makeText(this, 2131493127, 0).show();
        return;
      }
      Toast.makeText(this, getString(2131492922), 0).show();
      return;
      label268: Intent localIntent3 = new Intent();
      localIntent3.putExtra("lesson", paramt);
      localIntent3.putExtra("filePath", z.c + i4 + File.separator + i5 + File.separator + paramt.c() + File.separator + "index.xml");
      if (paramt.w() == 3)
        localIntent3.setClass(this, HJClassPlayer.class);
      while (true)
      {
        localIntent3.setFlags(541065216);
        startActivity(localIntent3);
        return;
        localIntent3.setClass(this, HJClassPlayerV3.class);
      }
      label400: s locals = new s();
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
      locals.a(paramt.t());
      locals.f(paramt.w());
      int i7 = b(locals);
      if ((z.h) && (!z.i) && (i7 == -2))
      {
        Builder localBuilder = new Builder(this);
        localBuilder.setMessage(getString(2131493027) + z.a((float)paramt.r()) + "\n" + getString(2131493023));
        localBuilder.setPositiveButton(getString(2131492879), new bw(this, i7, locals, paramt));
        localBuilder.setNeutralButton(getString(2131492880), new bx(this));
        localBuilder.create().show();
        return;
      }
      if (i7 == -1)
      {
        Intent localIntent1 = new Intent();
        localIntent1.setClass(this, HJSubDownloadTabActivity.class);
        startActivity(localIntent1);
        Toast.makeText(this, getString(2131492953), 1).show();
        return;
      }
      long l1 = z.e();
      if (104857600L > l1)
      {
        String str = getString(2131493042);
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Long.valueOf(l1);
        Toast.makeText(this, y.a(str, arrayOfObject), 0).show();
        return;
      }
      int i8 = a(locals);
      paramt.b(4);
      Intent localIntent2 = new Intent("check_task");
      localIntent2.putExtra("position", i8);
      sendBroadcast(localIntent2);
      Toast.makeText(this, getString(2131492952), 0).show();
      return;
    }
  }

  private void a(List paramList)
  {
    TableRow localTableRow1 = new TableRow(this);
    TextView localTextView;
    int i1;
    label69: int i2;
    if (!this.J)
    {
      localTableRow1.setPadding(30, 10, 5, 5);
      localTextView = new TextView(this);
      localTextView.setTextColor(-10066330);
      localTableRow1.addView(localTextView);
      this.q.addView(localTableRow1, this.t);
      if (!this.J)
        break label372;
      i1 = 3;
      if (this.K != 1)
        i1 = this.L / 160;
      i2 = paramList.size();
      if (i2 != 0)
        break label392;
      this.q.setVisibility(8);
      label109: if (i1 != 0)
        break label554;
    }
    label165: label554: for (int i3 = 3; ; i3 = i1)
    {
      int i4 = 0;
      Object localObject1 = localTableRow1;
      label123: TableRow localTableRow2;
      if (i4 < i2)
      {
        if (i4 % i3 != 0)
          break label547;
        localTableRow2 = new TableRow(this);
        if (!this.J)
        {
          localTableRow2.setPadding(18, 5, 5, 5);
          this.q.addView(localTableRow2, this.t);
        }
      }
      for (Object localObject2 = localTableRow2; ; localObject2 = localObject1)
      {
        this.s = new LessonButton(this);
        t localt = (t)paramList.get(i4);
        label225: int i5;
        LinearLayout localLinearLayout;
        LinearLayout.LayoutParams localLayoutParams;
        if (localt.j() > 0)
        {
          this.s.a(2130837693);
          this.s.setTag(localt);
          i5 = localt.n();
          if (i5 != 0)
            break label454;
          this.s.setText(getString(2131492938));
          this.s.setTextColor(-1);
          this.s.setOnClickListener(this.ab);
          this.s.setBackgroundResource(2130837730);
          localLinearLayout = new LinearLayout(this);
          localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
          if (this.K != 0)
            break label499;
          localLayoutParams.rightMargin = 5;
          localLayoutParams.leftMargin = 10;
        }
        while (true)
        {
          localLinearLayout.addView(this.s, localLayoutParams);
          ((TableRow)localObject2).addView(localLinearLayout);
          i4++;
          localObject1 = localObject2;
          break label123;
          localTableRow1.setPadding(16, 10, 2, 5);
          break;
          label372: if (this.K == 1)
          {
            i1 = 4;
            break label69;
          }
          i1 = 5;
          break label69;
          this.q.setVisibility(0);
          localTextView.setText(getString(2131492929));
          break label109;
          localTableRow2.setPadding(5, 5, 2, 5);
          break label165;
          if ((!f()) || (!localt.t()))
            break label225;
          this.s.a(2130837742);
          break label225;
          label454: this.s.setText(getString(2131493025) + i5 + getString(2131493026));
          break label260;
          label499: if (this.K == 1)
            if (this.J)
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
        return;
      }
    }
  }

  private int b(s params)
  {
    int i1 = this.N.b().size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      String str = ((s)this.N.b().get(i2)).i();
      if (TextUtils.isEmpty(str))
        return -1;
      if (str.equals(params.i()))
        return -1;
    }
    return -2;
  }

  private void b(List paramList)
  {
    TableRow localTableRow1 = new TableRow(this);
    if (!this.J)
      localTableRow1.setPadding(30, 10, 5, 5);
    TextView localTextView;
    int i1;
    while (true)
    {
      localTextView = new TextView(this);
      localTextView.setTextColor(-10066330);
      localTableRow1.addView(localTextView);
      this.r.addView(localTableRow1, this.t);
      i1 = paramList.size();
      if (i1 != 0)
        break;
      this.r.setVisibility(8);
      return;
      localTableRow1.setPadding(16, 10, 2, 5);
    }
    this.r.setVisibility(0);
    localTextView.setText(getString(2131492930));
    int i2;
    if (this.J)
    {
      i2 = 3;
      label124: if (this.K != 1)
        i2 = this.L / 160;
      if (i2 != 0)
        break label553;
    }
    label156: label293: label553: for (int i3 = 3; ; i3 = i2)
    {
      int i4 = 0;
      Object localObject1 = localTableRow1;
      TableRow localTableRow2;
      if (i4 < i1)
      {
        if (i4 % i3 != 0)
          break label546;
        localTableRow2 = new TableRow(this);
        if (this.J)
          break label414;
        localTableRow2.setPadding(18, 5, 5, 5);
        label198: this.r.addView(localTableRow2, this.t);
      }
      for (Object localObject2 = localTableRow2; ; localObject2 = localObject1)
      {
        t localt = (t)paramList.get(i4);
        this.s = new LessonButton(this);
        int i5;
        LinearLayout localLinearLayout;
        LinearLayout.LayoutParams localLayoutParams;
        if (localt.j() > 0)
        {
          this.s.a(2130837693);
          this.s.setTag(localt);
          i5 = localt.n();
          if (i5 != 0)
            break label454;
          this.s.setText(getString(2131492938));
          this.s.setTextColor(-10066330);
          this.s.setOnClickListener(this.ab);
          this.s.setBackgroundResource(2130837732);
          localLinearLayout = new LinearLayout(this);
          localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
          if (this.K != 0)
            break label499;
          localLayoutParams.rightMargin = 5;
          localLayoutParams.leftMargin = 10;
        }
        while (true)
        {
          localLinearLayout.addView(this.s, localLayoutParams);
          ((TableRow)localObject2).addView(localLinearLayout);
          i4++;
          localObject1 = localObject2;
          break label156;
          break;
          if (this.K == 1)
          {
            i2 = 4;
            break label124;
          }
          i2 = 5;
          break label124;
          localTableRow2.setPadding(5, 5, 2, 5);
          break label198;
          if ((!f()) || (!localt.t()))
            break label258;
          this.s.a(2130837742);
          break label258;
          label454: this.s.setText(getString(2131493025) + i5 + getString(2131493026));
          break label293;
          label499: if (this.K == 1)
            if (this.J)
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
  }

  private void c()
  {
    int i1 = getResources().getConfiguration().orientation;
    if (i1 == 2)
      this.J = false;
    int i2;
    int i3;
    do
      while (true)
      {
        WindowManager localWindowManager = getWindowManager();
        i2 = localWindowManager.getDefaultDisplay().getWidth();
        this.L = i2;
        i3 = localWindowManager.getDefaultDisplay().getHeight();
        if (((i2 != 480) && (i3 != 480)) || ((i2 != 800) && (i3 != 800)))
          break;
        this.K = 0;
        return;
        if (i1 == 1)
          this.J = true;
      }
    while (((i2 != 320) && (i3 != 320)) || ((i2 != 480) && (i3 != 480)));
    this.K = 1;
  }

  private void d()
  {
    this.w.clear();
    this.x.clear();
    int i1 = this.b.size();
    int i2 = 0;
    if (i2 < i1)
    {
      t localt = (t)this.b.get(i2);
      if (localt.b() == 3)
        this.w.add(localt);
      while (true)
      {
        i2++;
        break;
        this.x.add(localt);
      }
    }
    e();
    a(this.w);
    b(this.x);
  }

  private void e()
  {
    this.q.removeAllViews();
    this.r.removeAllViews();
  }

  private boolean f()
  {
    return this.h == 2;
  }

  public final void a(Bitmap paramBitmap, int paramInt, ImageView paramImageView)
  {
    if (paramBitmap != null)
    {
      paramImageView.setImageBitmap(paramBitmap);
      this.V.setImageBitmap(paramBitmap);
    }
  }

  public final void b()
  {
    this.e = false;
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131361816:
    case 2131361881:
      finish();
      return;
    case 2131361850:
    case 2131361883:
      Intent localIntent = new Intent();
      localIntent.setClass(this, HJSubDownloadTabActivity.class);
      startActivity(localIntent);
      return;
    case 2131361871:
      if (this.p)
      {
        this.p = false;
        if (this.n.isShowing())
          this.n.dismiss();
        this.m.setBackgroundResource(2130837606);
        if (this.K == 0)
        {
          this.n.showAtLocation(this.o, 80, 0, 76);
          return;
        }
        this.n.showAtLocation(this.o, 80, 0, 51);
        return;
      }
      this.p = true;
      this.n.dismiss();
      this.m.setBackgroundResource(2130837599);
      return;
    case 2131361865:
      a(1);
      return;
    case 2131361882:
    }
    a(-1);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    c();
    e();
    a(this.w);
    b(this.x);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903053);
    this.N = ((HJApplication)getApplicationContext());
    if (this.k == null)
    {
      this.k = new cd(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("download_status");
      localIntentFilter.addAction("delete_file");
      localIntentFilter.addAction("open_next_lesson");
      registerReceiver(this.k, localIntentFilter);
    }
    z.a(this);
    if ((z.h) && (!z.i))
      Toast.makeText(this, getString(2131492940), 1).show();
    this.o = findViewById(2131361848);
    this.Q = findViewById(2131361864);
    this.R = findViewById(2131361880);
    this.U = LayoutInflater.from(this).inflate(2130903078, null);
    this.S = ((Button)findViewById(2131361865));
    this.S.setOnClickListener(this);
    this.T = ((Button)findViewById(2131361882));
    this.T.setOnClickListener(this);
    this.M = findViewById(2131361851);
    this.j = ((Button)findViewById(2131361816));
    this.j.setOnClickListener(this);
    ((Button)findViewById(2131361881)).setOnClickListener(this);
    ((Button)findViewById(2131361850)).setOnClickListener(this);
    ((Button)findViewById(2131361883)).setOnClickListener(this);
    this.i = ((TextView)findViewById(2131361849));
    this.m = ((LinearLayout)findViewById(2131361871));
    this.m.setOnClickListener(this);
    this.I = findViewById(2131361818);
    View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903047, null);
    this.y = ((TextView)localView.findViewById(2131361831));
    this.z = ((TextView)localView.findViewById(2131361833));
    this.A = ((TextView)localView.findViewById(2131361834));
    this.B = ((TextView)localView.findViewById(2131361835));
    this.C = ((TextView)findViewById(2131361854));
    this.D = ((TextView)findViewById(2131361870));
    this.G = ((ImageView)findViewById(2131361836));
    this.n = new PopupWindow(localView, -1, -2);
    this.n.setAnimationStyle(2131558410);
    this.H = findViewById(2131361853);
    Bundle localBundle = getIntent().getExtras();
    this.c = new b(this);
    this.f = ((LinearLayout)findViewById(2131361852));
    this.q = ((TableLayout)findViewById(2131361855));
    this.r = ((TableLayout)findViewById(2131361856));
    this.t = new TableLayout.LayoutParams(-1, -2);
    this.r.setShrinkAllColumns(true);
    this.q.setShrinkAllColumns(true);
    this.t.gravity = 17;
    this.w = new ArrayList();
    this.x = new ArrayList();
    this.O = ((ListView)findViewById(2131361884));
    this.O.setCacheColorHint(0);
    this.O.setOnItemClickListener(this);
    this.P = new q(this);
    this.O.addHeaderView(this.U, null, false);
    this.V = ((ImageView)this.U.findViewById(2131361836));
    this.E = ((TextView)this.U.findViewById(2131361854));
    this.F = ((TextView)this.U.findViewById(2131361870));
    if (localBundle != null)
    {
      this.e = true;
      this.b = new ArrayList();
      this.g = localBundle.getInt("classid");
      this.h = localBundle.getInt("classtype");
      this.P.a(f());
      this.i.setText(getString(2131492931));
      this.y.setText(String.valueOf(localBundle.getInt("lessonNum")));
      this.z.setText(localBundle.getString("teacher"));
      this.A.setText(localBundle.getString("opentime").replace("0:00:00", ""));
      this.B.setText(getString(2131492935) + "\n" + localBundle.getString("des"));
      String str = localBundle.getString("iconUrl");
      new n(this, this.G, this.g).execute(new String[] { str });
      this.C.setText(localBundle.getString("classname"));
      this.E.setText(this.C.getText());
      this.D.setText(localBundle.getInt("studyNum") + "/" + localBundle.getInt("lessonNum"));
      this.F.setText(this.D.getText());
      this.d = new ce(this, (byte)0);
      if (this.b.size() > 0)
        this.b.clear();
      ce localce = this.d;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = c.a();
      arrayOfObject[1] = Integer.valueOf(this.g);
      arrayOfObject[2] = Integer.valueOf(1);
      localce.execute(arrayOfObject);
    }
    this.Y = ((RadioButton)findViewById(2131361867));
    this.Z = ((RadioButton)findViewById(2131361868));
    this.Y.setOnClickListener(this.ah);
    this.Z.setOnClickListener(this.ah);
    this.Y.setChecked(true);
    this.ac = ((LinearLayout)findViewById(2131361875));
    this.W = ((LinearLayout)findViewById(2131361869));
    this.X = ((LinearLayout)findViewById(2131361873));
    this.aa = ((WebView)findViewById(2131361874));
    this.aa.getSettings().setJavaScriptEnabled(true);
    this.aa.setWebViewClient(new by(this));
    this.aa.setScrollBarStyle(0);
    this.ad = ((TextView)findViewById(2131361876));
    this.ae = ((TextView)findViewById(2131361877));
    this.af = ((TextView)findViewById(2131361878));
    this.ag = ((TextView)findViewById(2131361879));
    this.ad.setOnClickListener(this.ai);
    this.ae.setOnClickListener(this.ai);
    this.af.setOnClickListener(this.ai);
    this.ag.setOnClickListener(this.ai);
  }

  protected void onDestroy()
  {
    unregisterReceiver(this.k);
    z.b(this);
    super.onDestroy();
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.O.getHeaderViewsCount() > 0)
      paramInt--;
    a((t)this.b.get(paramInt));
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.n.isShowing())
      {
        this.n.dismiss();
        return true;
      }
      if ((this.X.getVisibility() == 0) && (this.aa.canGoBack()))
      {
        this.aa.goBack();
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  protected void onResume()
  {
    super.onResume();
    this.l = true;
    c();
  }

  protected void onStart()
  {
    this.l = true;
    super.onStart();
  }

  protected void onStop()
  {
    this.l = false;
    super.onStop();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJLessonListActivity
 * JD-Core Version:    0.6.2
 */