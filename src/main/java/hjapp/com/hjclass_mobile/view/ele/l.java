package hjapp.com.hjclass_mobile.view.ele;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import hjapp.com.hjclass_mobile.pkg_c.aa;
import hjapp.com.hjclass_mobile.pkg_c.b;
import hjapp.com.hjclass_mobile.pkg_c.j;
import hjapp.com.hjclass_mobile.pkg_c.k;
import hjapp.com.hjclass_mobile.pkg_d.ad;
import hjapp.com.hjclass_mobile.pkg_h.z;
import hjapp.com.hjclass_mobile.view.HJLinearLayout;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class l extends RelativeLayout
  implements b, j
{
  OnClickListener a = new n(this);
  private hjapp.com.hjclass_mobile.pkg_b.a b;
  private HJLinearLayout c = null;
  private TextView d = null;
  private String e = null;
  private String f = null;
  private Button g = null;
  private aa h = null;
  private List i = null;
  private int j = 0;
  private ImageView k = null;
  private LinearLayout l = null;
  private String m = null;
  private float n;
  private float o;
  private float p;

  public l(Context paramContext, hjapp.com.hjclass_mobile.pkg_b.a parama)
  {
    super(paramContext);
    this.b = parama;
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903063, null);
    addView(localView);
    this.g = ((Button)localView.findViewById(2131361917));
    this.k = ((ImageView)localView.findViewById(2131361918));
    this.k.setVisibility(4);
    this.g.setOnClickListener(new m(this));
    this.i = new ArrayList();
    this.c = ((HJLinearLayout)localView.findViewById(2131361914));
    this.d = ((TextView)localView.findViewById(2131361911));
    this.l = ((LinearLayout)localView.findViewById(2131361912));
  }

  private static boolean a(String paramString1, String paramString2)
  {
    String[] arrayOfString = paramString2.split("\\/+");
    int i1 = arrayOfString.length;
    for (int i2 = 0; ; i2++)
    {
      boolean bool = false;
      if (i2 < i1)
      {
        if (arrayOfString[i2].trim().equals(paramString1.trim()))
          bool = true;
      }
      else
        return bool;
    }
  }

  private static LinearLayout.LayoutParams c()
  {
    return new LinearLayout.LayoutParams(-1, -2);
  }

  public final void a()
  {
    int i1 = this.i.size();
    for (int i2 = 0; i2 < i1; i2++)
      ((ae)this.i.get(i2)).c();
    removeAllViews();
  }

  public final void a(aa paramaa)
  {
    this.h = paramaa;
  }

  public final void a(hjapp.com.hjclass_mobile.pkg_d.l paraml)
  {
    LinearLayout localLinearLayout1 = null;
    ad localad = paraml.b();
    if (localad == null)
      return;
    this.j = localad.k();
    if (localad.a() != null)
      this.d.setText(hjapp.com.hjclass_mobile.pkg_h.c.a(localad.a()));
    if ((localad.f() != null) && (localad.f() != ""))
      this.e = localad.f();
    for (String[] arrayOfString = localad.f().split("\\|"); ; arrayOfString = null)
    {
      int i1 = arrayOfString.length;
      LinearLayout localLinearLayout2 = new LinearLayout(getContext());
      localLinearLayout2.setOrientation(1);
      localLinearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      if (localad.b() != null)
      {
        this.k.setVisibility(0);
        new Options();
        Options localOptions = new Options();
        localOptions.inJustDecodeBounds = true;
        localOptions.inSampleSize = z.a(localOptions, Math.min(100, 75), 7500);
        localOptions.inJustDecodeBounds = false;
        localOptions.inInputShareable = true;
        localOptions.inPurgeable = true;
        this.m = (this.b.c() + File.separator + localad.b());
        Bitmap localBitmap = BitmapFactory.decodeFile(this.m, localOptions);
        this.k.setImageBitmap(localBitmap);
        this.k.setOnClickListener(this.a);
      }
      for (int i2 = 0; i2 < i1; i2++)
      {
        if (i2 % 3 == 0)
        {
          localLinearLayout1 = new LinearLayout(getContext());
          localLinearLayout1.setOrientation(0);
          localLinearLayout1.setLayoutParams(c());
          localLinearLayout2.addView(localLinearLayout1);
        }
        ae localae = new ae(getContext(), this.b);
        LinearLayout.LayoutParams localLayoutParams = c();
        localLayoutParams.weight = 1.0F;
        localLayoutParams.leftMargin = 2;
        localLayoutParams.rightMargin = 2;
        localae.setLayoutParams(localLayoutParams);
        localae.b(arrayOfString[i2]);
        localLinearLayout1.addView(localae);
        this.i.add(localae);
      }
      if (localad.h() != null)
      {
        LinearLayout localLinearLayout3 = this.l;
        String str = localad.h();
        hjapp.com.hjclass_mobile.pkg_d.l locall = new hjapp.com.hjclass_mobile.pkg_d.l();
        hjapp.com.hjclass_mobile.pkg_d.c localc = new hjapp.com.hjclass_mobile.pkg_d.c();
        localc.a(str);
        localc.a(false);
        localc.d("TYPE_LONG");
        localc.a(0);
        localc.b(0);
        locall.a("audio");
        locall.a(localc);
        a locala = new a(getContext(), this.b);
        locala.a(locall);
        localLinearLayout3.addView(locala);
        this.l.setVisibility(0);
      }
      this.c.addView(localLinearLayout2);
      this.f = localad.g();
      return;
    }
  }

  public final void a(hjapp.com.hjclass_mobile.pkg_d.z paramz)
  {
    if (paramz != null)
    {
      int i1 = this.i.size();
      String[] arrayOfString = paramz.b().split("\\|");
      int i2 = arrayOfString.length;
      for (int i3 = 0; i3 < i1; i3++)
      {
        View localView = (View)this.i.get(i3);
        if ((localView instanceof k))
        {
          k localk = (k)localView;
          localk.a(paramz);
          if ((i3 < i2) && (arrayOfString[i3] != null))
            localk.a(arrayOfString[i3]);
        }
      }
      this.g.setEnabled(false);
    }
  }

  public final void b()
  {
    int i1 = this.i.size();
    for (int i2 = 0; i2 < i1; i2++)
      ((ae)this.i.get(i2)).a();
    this.g.setEnabled(true);
  }

  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 2:
    case 1:
    }
    do
    {
      do
      {
        return bool;
        this.n = 0.0F;
        this.o = paramMotionEvent.getRawY();
        return bool;
        this.p = paramMotionEvent.getRawY();
        this.n = Math.abs(this.p - this.o);
      }
      while (this.n <= 20.0F);
      this.c.c();
      return bool;
      this.n = Math.abs(this.p - this.o);
      hjapp.com.hjclass_mobile.pkg_h.u.b("yDistance" + this.n + ",optionsLayout.isIntecept()=" + this.c.b());
    }
    while ((this.c.b()) || (this.n >= 5.0F));
    Intent localIntent = new Intent("show_cmd");
    getContext().sendBroadcast(localIntent);
    return bool;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     l
 * JD-Core Version:    0.6.2
 */