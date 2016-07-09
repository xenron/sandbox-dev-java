package hjapp.com.hjclass_mobile;

import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class HJPersonIndexActivity extends BaseActivity
  implements OnClickListener, OnItemClickListener, hjapp.com.hjclass_mobile.c.ad, hjapp.com.hjclass_mobile.c.o
{
  private View A = null;
  private int B = 0;
  private TextView a = null;
  private TextView b = null;
  private TextView c = null;
  private TextView d = null;
  private Button e = null;
  private RelativeLayout f = null;
  private hjapp.com.hjclass_mobile.d.u g = null;
  private cu h = null;
  private ListView i = null;
  private List j;
  private ct k = null;
  private cr l = null;
  private boolean m = false;
  private View n = null;
  private Drawable o = null;
  private hjapp.com.hjclass_mobile.b.b p = null;
  private View q = null;
  private BroadcastReceiver r;
  private boolean s = true;
  private cq t = null;
  private cs u = null;
  private Button v = null;
  private View w = null;
  private hjapp.com.hjclass_mobile.h.v x = null;
  private Bitmap y = null;
  private Drawable z = null;

  private void b()
  {
    if (this.m)
      return;
    NetworkInfo localNetworkInfo = z.a(this);
    if (!z.b(this))
    {
      z.h = false;
      this.e.setVisibility(8);
      this.f.setVisibility(0);
      this.n.setVisibility(0);
      if (this.l != null)
      {
        this.l.cancel(true);
        this.l = null;
      }
      this.m = true;
      this.l = new cr(this, (byte)0);
      cr localcr = this.l;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = c.a();
      localcr.execute(arrayOfString);
      return;
    }
    z.h = true;
    if (localNetworkInfo.getType() == 1);
    for (boolean bool = true; ; bool = false)
    {
      z.i = bool;
      break;
    }
  }

  public final void a(Bitmap paramBitmap, int paramInt, ImageView paramImageView)
  {
    if (paramBitmap != null)
    {
      this.x.a(Integer.valueOf(paramInt), paramBitmap);
      hjapp.com.hjclass_mobile.h.u.b(paramBitmap.getWidth() + "<1=1>" + paramBitmap.getHeight());
      paramImageView.setImageBitmap(paramBitmap);
    }
  }

  public final void a(HashMap paramHashMap)
  {
    if (paramHashMap.containsKey("version"))
      z.b = Integer.parseInt((String)paramHashMap.get("version"));
    try
    {
      z.a = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
      if (paramHashMap.containsKey("apkUrl"))
        z.f = (String)paramHashMap.get("apkUrl");
      if (z.a < z.b)
      {
        Builder localBuilder = new Builder(this);
        localBuilder.setTitle(getString(2131492997)).setMessage(getString(2131492998)).setPositiveButton(getString(2131492999), new co(this)).setNegativeButton(getString(2131493000), new cn(this));
        localBuilder.create().show();
      }
      return;
    }
    catch (NameNotFoundException localNameNotFoundException)
    {
      while (true)
        localNameNotFoundException.printStackTrace();
    }
  }

  // ERROR //
  public void onClick(View paramView)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 333	android/view/View:getId	()I
    //   4: lookupswitch	default:+44->48, 2131361811:+45->49, 2131361812:+50->54, 2131361994:+266->270, 2131362127:+281->285
    //   49: aload_0
    //   50: invokespecial 188	com/hjclass_mobile/HJPersonIndexActivity:b	()V
    //   53: return
    //   54: aload_0
    //   55: getfield 77	com/hjclass_mobile/HJPersonIndexActivity:g	Lcom/hjclass_mobile/d/u;
    //   58: ifnull +13 -> 71
    //   61: aload_0
    //   62: getfield 77	com/hjclass_mobile/HJPersonIndexActivity:g	Lcom/hjclass_mobile/d/u;
    //   65: invokevirtual 338	com/hjclass_mobile/d/u:i	()Z
    //   68: ifne -20 -> 48
    //   71: getstatic 134	com/hjclass_mobile/h/z:h	Z
    //   74: ifne +19 -> 93
    //   77: aload_0
    //   78: aload_0
    //   79: ldc_w 339
    //   82: invokevirtual 290	com/hjclass_mobile/HJPersonIndexActivity:getString	(I)Ljava/lang/String;
    //   85: iconst_0
    //   86: invokestatic 345	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   89: invokevirtual 346	android/widget/Toast:show	()V
    //   92: return
    //   93: invokestatic 162	com/hjclass_mobile/f/c:a	()Ljava/lang/String;
    //   96: astore 6
    //   98: invokestatic 351	com/hjclass_mobile/f/b:a	()Lcom/hjclass_mobile/f/b;
    //   101: pop
    //   102: aload 6
    //   104: invokestatic 354	com/hjclass_mobile/f/b:a	(Ljava/lang/String;)Z
    //   107: istore 8
    //   109: iload 8
    //   111: ifeq -63 -> 48
    //   114: aload_0
    //   115: ldc_w 355
    //   118: invokestatic 360	android/media/MediaPlayer:create	(Landroid/content/Context;I)Landroid/media/MediaPlayer;
    //   121: invokevirtual 363	android/media/MediaPlayer:start	()V
    //   124: ldc2_w 364
    //   127: aload_0
    //   128: getfield 77	com/hjclass_mobile/HJPersonIndexActivity:g	Lcom/hjclass_mobile/d/u;
    //   131: invokevirtual 368	com/hjclass_mobile/d/u:d	()F
    //   134: f2d
    //   135: dadd
    //   136: d2f
    //   137: fstore 10
    //   139: aload_0
    //   140: getfield 77	com/hjclass_mobile/HJPersonIndexActivity:g	Lcom/hjclass_mobile/d/u;
    //   143: fload 10
    //   145: invokevirtual 371	com/hjclass_mobile/d/u:a	(F)V
    //   148: aload_0
    //   149: getfield 77	com/hjclass_mobile/HJPersonIndexActivity:g	Lcom/hjclass_mobile/d/u;
    //   152: iconst_1
    //   153: invokevirtual 374	com/hjclass_mobile/d/u:a	(Z)V
    //   156: aload_0
    //   157: getfield 93	com/hjclass_mobile/HJPersonIndexActivity:p	Lcom/hjclass_mobile/b/b;
    //   160: aload_0
    //   161: getfield 77	com/hjclass_mobile/HJPersonIndexActivity:g	Lcom/hjclass_mobile/d/u;
    //   164: invokevirtual 379	com/hjclass_mobile/b/b:a	(Lcom/hjclass_mobile/d/u;)V
    //   167: new 381	java/text/DecimalFormat
    //   170: dup
    //   171: ldc_w 383
    //   174: invokespecial 385	java/text/DecimalFormat:<init>	(Ljava/lang/String;)V
    //   177: astore 11
    //   179: aload_0
    //   180: getfield 67	com/hjclass_mobile/HJPersonIndexActivity:b	Landroid/widget/TextView;
    //   183: aload 11
    //   185: fload 10
    //   187: f2d
    //   188: invokevirtual 389	java/text/DecimalFormat:format	(D)Ljava/lang/String;
    //   191: invokevirtual 395	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   194: aload_0
    //   195: getfield 73	com/hjclass_mobile/HJPersonIndexActivity:e	Landroid/widget/Button;
    //   198: aload_0
    //   199: getfield 91	com/hjclass_mobile/HJPersonIndexActivity:o	Landroid/graphics/drawable/Drawable;
    //   202: invokevirtual 399	android/widget/Button:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   205: aload_0
    //   206: aload_0
    //   207: ldc_w 400
    //   210: invokevirtual 290	com/hjclass_mobile/HJPersonIndexActivity:getString	(I)Ljava/lang/String;
    //   213: iconst_1
    //   214: invokestatic 345	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   217: astore 12
    //   219: aload 12
    //   221: bipush 48
    //   223: aload 12
    //   225: invokevirtual 403	android/widget/Toast:getXOffset	()I
    //   228: iconst_2
    //   229: idiv
    //   230: aload 12
    //   232: invokevirtual 406	android/widget/Toast:getYOffset	()I
    //   235: iconst_2
    //   236: idiv
    //   237: invokevirtual 410	android/widget/Toast:setGravity	(III)V
    //   240: aload 12
    //   242: invokevirtual 346	android/widget/Toast:show	()V
    //   245: return
    //   246: astore 5
    //   248: aload_0
    //   249: getfield 73	com/hjclass_mobile/HJPersonIndexActivity:e	Landroid/widget/Button;
    //   252: aload_0
    //   253: getfield 91	com/hjclass_mobile/HJPersonIndexActivity:o	Landroid/graphics/drawable/Drawable;
    //   256: invokevirtual 399	android/widget/Button:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   259: return
    //   260: astore 9
    //   262: aload 9
    //   264: invokevirtual 411	java/lang/Exception:printStackTrace	()V
    //   267: goto -143 -> 124
    //   270: aload_0
    //   271: new 413	android/content/Intent
    //   274: dup
    //   275: ldc_w 415
    //   278: invokespecial 416	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   281: invokevirtual 420	com/hjclass_mobile/HJPersonIndexActivity:sendBroadcast	(Landroid/content/Intent;)V
    //   284: return
    //   285: new 413	android/content/Intent
    //   288: dup
    //   289: invokespecial 421	android/content/Intent:<init>	()V
    //   292: astore_2
    //   293: aload_2
    //   294: ldc_w 423
    //   297: aload_0
    //   298: getfield 115	com/hjclass_mobile/HJPersonIndexActivity:B	I
    //   301: invokevirtual 427	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   304: pop
    //   305: aload_2
    //   306: aload_0
    //   307: ldc_w 429
    //   310: invokevirtual 433	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   313: pop
    //   314: aload_0
    //   315: aload_2
    //   316: invokevirtual 436	com/hjclass_mobile/HJPersonIndexActivity:startActivity	(Landroid/content/Intent;)V
    //   319: return
    //
    // Exception table:
    //   from	to	target	type
    //   93	109	246	java/lang/Exception
    //   124	245	246	java/lang/Exception
    //   262	267	246	java/lang/Exception
    //   114	124	260	java/lang/Exception
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903043);
    this.a = ((TextView)findViewById(2131361810));
    this.n = findViewById(2131361814);
    this.w = LayoutInflater.from(this).inflate(2130903099, null);
    this.A = LayoutInflater.from(this).inflate(2130903140, null);
    ((Button)this.A.findViewById(2131362127)).setOnClickListener(this);
    this.v = ((Button)this.w.findViewById(2131361994));
    this.v.setOnClickListener(this);
    z.a(this);
    this.q = LayoutInflater.from(this).inflate(2130903046, null);
    this.f = ((RelativeLayout)findViewById(2131361813));
    ((Button)findViewById(2131361811)).setOnClickListener(this);
    this.e = ((Button)findViewById(2131361812));
    this.e.setOnClickListener(this);
    this.b = ((TextView)this.q.findViewById(2131361824));
    this.c = ((TextView)this.q.findViewById(2131361827));
    this.d = ((TextView)this.q.findViewById(2131361829));
    this.i = ((ListView)findViewById(2131361815));
    this.i.setCacheColorHint(0);
    this.i.setOnItemClickListener(this);
    this.i.addHeaderView(this.q, null, false);
    this.a.setText(c.c());
    this.o = getResources().getDrawable(2130837531);
    this.p = new hjapp.com.hjclass_mobile.b.b(this);
    this.x = new h.v(20);
    this.y = BitmapFactory.decodeResource(getResources(), 2130837515);
    this.z = getResources().getDrawable(2130837532);
    b();
    this.u = new cs(this, (byte)0);
    IntentFilter localIntentFilter1 = new IntentFilter("msg_complete");
    registerReceiver(this.u, localIntentFilter1);
    this.t = new cq(this, this);
    this.t.execute(new String[] { "android_hjclass_mobile" });
    this.r = new cv(this);
    IntentFilter localIntentFilter2 = new IntentFilter("com.hjclass.action.updatexb");
    registerReceiver(this.r, localIntentFilter2);
    new cp(this, (byte)0).execute(new Void[0]);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }

  protected void onDestroy()
  {
    z.b(this);
    unregisterReceiver(this.r);
    unregisterReceiver(this.u);
    super.onDestroy();
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i1 = paramInt - 1;
    if (i1 <= 0)
      i1 = 0;
    hjapp.com.hjclass_mobile.d.q localq = (hjapp.com.hjclass_mobile.d.q)this.j.get(i1);
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
      int i2 = localq.a();
      Builder localBuilder = new Builder(this);
      localBuilder.setTitle("提示").setMessage(str).setPositiveButton("确定", new cm(this, i2));
      localBuilder.show();
      return;
    }
    if (localq.a() == 10022)
    {
      localIntent.setClass(this, HJDemoClassActivity.class);
      startActivity(localIntent);
      return;
    }
    localIntent.setClass(this, HJLessonListActivity.class);
    localIntent.putExtra("des", localq.k());
    localIntent.putExtra("teacher", localq.l());
    localIntent.putExtra("opentime", localq.g() + "-" + localq.i());
    localIntent.putExtra("mode", "pay");
    startActivity(localIntent);
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
      b();
    }
  }

  protected void onResume()
  {
    this.s = true;
    super.onResume();
  }

  protected void onStop()
  {
    this.s = false;
    super.onStop();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJPersonIndexActivity
 * JD-Core Version:    0.6.2
 */