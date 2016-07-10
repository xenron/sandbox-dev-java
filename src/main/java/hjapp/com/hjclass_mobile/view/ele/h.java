package hjapp.com.hjclass_mobile.view.ele;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import hjapp.com.hjclass_mobile.pkg_c.aa;
import hjapp.com.hjclass_mobile.pkg_d.ad;
import hjapp.com.hjclass_mobile.pkg_d.l;
import hjapp.com.hjclass_mobile.view.HJLinearLayout;
import hjapp.com.hjclass_mobile.pkg_d.c;
import hjapp.com.hjclass_mobile.pkg_d.z;

import java.io.File;
import java.util.List;

public final class h extends RelativeLayout
  implements hjapp.com.hjclass_mobile.pkg_c.b, hjapp.com.hjclass_mobile.pkg_c.j
{
  OnClickListener a = new hjapp.com.hjclass_mobile.view.ele.k(this);
  private hjapp.com.hjclass_mobile.pkg_b.a b;
  private HJLinearLayout c = null;
  private ImageView d = null;
  private TextView e = null;
  private LinearLayout f = null;
  private String g = null;
  private String h = null;
  private int i = 0;
  private ImageView j = null;
  private String k = null;
  private hjapp.com.hjclass_mobile.pkg_c.aa l = null;
  private float m;
  private float n;
  private float o;

  public h(Context paramContext, hjapp.com.hjclass_mobile.pkg_b.a parama, boolean paramBoolean)
  {
    super(paramContext);
    this.b = parama;
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903061, null);
    addView(localView);
    this.c = ((HJLinearLayout)localView.findViewById(2131361914));
    this.d = ((ImageView)localView.findViewById(2131361915));
    this.e = ((TextView)localView.findViewById(2131361911));
    if (paramBoolean)
    {
      this.j = ((ImageView)localView.findViewById(2131361910));
      this.j.setImageResource(2130837769);
    }
    this.f = ((LinearLayout)localView.findViewById(2131361912));
  }

  private void a(View paramView)
  {
    int i1 = ((LinearLayout)paramView).getChildCount();
    int i2 = 0;
    if (i2 < i1)
    {
      View localView = ((LinearLayout)paramView).getChildAt(i2);
      if ((localView instanceof LinearLayout))
        a(localView);
      while (true)
      {
        i2++;
        break;
        ((hjapp.com.hjclass_mobile.pkg_c.k)localView).c();
      }
    }
  }

  private void a(hjapp.com.hjclass_mobile.pkg_d.z paramz, View paramView)
  {
    if (paramz != null)
    {
      int i1 = ((ViewGroup)paramView).getChildCount();
      int i2 = 0;
      if (i2 < i1)
      {
        View localView = ((ViewGroup)paramView).getChildAt(i2);
        if ((localView instanceof hjapp.com.hjclass_mobile.pkg_c.k))
          ((hjapp.com.hjclass_mobile.pkg_c.k)localView).a(paramz);
        while (true)
        {
          i2++;
          break;
          a(paramz, localView);
        }
      }
    }
  }

  public final void a()
  {
    a(this.c);
    this.f.removeAllViews();
    this.d.destroyDrawingCache();
    this.d = null;
    removeAllViews();
  }

  public final void a(aa paramaa)
  {
    this.l = paramaa;
  }

  public final void a(hjapp.com.hjclass_mobile.pkg_d.l paraml)
  {
    Object localObject1 = null;
    ad localad = paraml.b();
    if (localad == null)
      return;
    this.i = localad.k();
    if (localad.a() != null)
      this.e.setText(hjapp.com.hjclass_mobile.pkg_h.c.a(localad.a().replace("\r\n", "<br/>")));
    String[] arrayOfString5;
    String[] arrayOfString6;
    if ((localad.c() != null) && (localad.c() != "") && (localad.c().length() > 0))
    {
      arrayOfString5 = localad.c().split("\\|");
      if ((localad.i() == null) || (localad.i() == ""))
        break label962;
      arrayOfString6 = localad.i().split("\\|");
      this.g = arrayOfString6[(-1 + Integer.parseInt(localad.f()))];
    }
    while (true)
    {
      String[] arrayOfString1;
      Object localObject2;
      if ((arrayOfString5 != null) && (arrayOfString5.length > 0) && (localad.f() != null) && (Integer.parseInt(localad.f()) > 0))
      {
        this.g = arrayOfString5[(-1 + Integer.parseInt(localad.f()))];
        arrayOfString1 = arrayOfString5;
        localObject2 = arrayOfString6;
      }
      while (true)
      {
        String[] arrayOfString3;
        if ((localad.d() != null) && (localad.d() != ""))
        {
          arrayOfString3 = localad.d().split("\\|");
          if (arrayOfString1 != null)
            this.g = arrayOfString3[Integer.parseInt(localad.f())];
        }
        for (String[] arrayOfString2 = arrayOfString3; ; arrayOfString2 = null)
        {
          if (arrayOfString2 == null)
          {
            int i4 = arrayOfString1.length;
            if (localad.e().booleanValue());
            for (List localList2 = hjapp.com.hjclass_mobile.pkg_h.z.f(i4); ; localList2 = hjapp.com.hjclass_mobile.pkg_h.z.e(i4))
            {
              for (int i5 = 0; i5 < i4; i5++)
              {
                ac localac = new ac(getContext(), this.b);
                localac.a(new i(this, localac));
                int i6 = ((Integer)localList2.get(i5)).intValue();
                localac.b(arrayOfString1[i6]);
                if (i6 == -1 + Integer.parseInt(localad.f()))
                  localac.a(Boolean.valueOf(true));
                if ((localObject2 != null) && (localObject2.length > 0) && (localObject2[i6] != ""))
                  localac.c(localObject2[i6]);
                this.c.addView(localac);
              }
              if ((localad.i() == null) || (localad.i() == ""))
                break label942;
              String[] arrayOfString4 = localad.i().split("\\|");
              this.g = arrayOfString4[(-1 + Integer.parseInt(localad.f()))];
              localObject2 = arrayOfString4;
              arrayOfString1 = null;
              break;
            }
          }
          hjapp.com.hjclass_mobile.pkg_h.u.b("图片选择题");
          int i1 = arrayOfString2.length;
          List localList1;
          int i2;
          label489: o localo;
          int i3;
          Object localObject3;
          if (localad.e().booleanValue())
          {
            localList1 = hjapp.com.hjclass_mobile.pkg_h.z.f(i1);
            i2 = 0;
            if (i2 >= i1)
              break label639;
            localo = new o(getContext(), this.b);
            localo.a(new hjapp.com.hjclass_mobile.view.ele.j(this, localo));
            i3 = ((Integer)localList1.get(i2)).intValue();
            localo.b(arrayOfString2[i3]);
            if (i2 % 2 != 0)
              break label930;
            localObject3 = new LinearLayout(getContext());
            ((LinearLayout)localObject3).setOrientation(0);
            this.c.addView((View)localObject3);
          }
          while (true)
          {
            ((LinearLayout)localObject3).addView(localo);
            if (i3 == -1 + Integer.parseInt(localad.f()))
              localo.a(Boolean.valueOf(true));
            i2++;
            localObject1 = localObject3;
            break label489;
            localList1 = hjapp.com.hjclass_mobile.pkg_h.z.e(i1);
            break;
            label639: if (localad.h() != null)
            {
              LinearLayout localLinearLayout = this.f;
              String str = localad.h();
              hjapp.com.hjclass_mobile.pkg_d.l locall = new l();
              hjapp.com.hjclass_mobile.pkg_d.c localc = new c();
              localc.a(str);
              localc.a(false);
              localc.d("TYPE_LONG");
              localc.a(0);
              localc.b(0);
              locall.a("audio");
              locall.a(localc);
              a locala = new a(getContext(), this.b);
              locala.a(locall);
              localLinearLayout.addView(locala);
              this.f.setVisibility(0);
            }
            Options localOptions;
            if (localad.b() != null)
            {
              new Options();
              localOptions = new Options();
              localOptions.inJustDecodeBounds = true;
              localOptions.inSampleSize = hjapp.com.hjclass_mobile.pkg_h.z.a(localOptions, Math.min(100, 75), 7500);
              localOptions.inJustDecodeBounds = false;
              localOptions.inInputShareable = true;
              localOptions.inPurgeable = true;
              this.k = (this.b.c() + File.separator + localad.b());
            }
            while (true)
            {
              try
              {
                Bitmap localBitmap = BitmapFactory.decodeFile(this.k, localOptions);
                this.d.setImageBitmap(localBitmap);
                this.d.setOnClickListener(this.a);
                this.h = localad.g();
                return;
              }
              catch (OutOfMemoryError localOutOfMemoryError)
              {
                localOutOfMemoryError.printStackTrace();
                continue;
              }
              this.d.setVisibility(8);
            }
            label930: localObject3 = localObject1;
          }
        }
        label942: localObject2 = null;
        arrayOfString1 = null;
        continue;
        arrayOfString1 = arrayOfString5;
        localObject2 = arrayOfString6;
      }
      label962: arrayOfString6 = null;
    }
  }

  public final void a(z paramz)
  {
    a(paramz, this.c);
  }

  public final void b()
  {
    int i1 = this.c.getChildCount();
    for (int i2 = 0; i2 < i1; i2++)
    {
      View localView = this.c.getChildAt(i2);
      if ((localView instanceof hjapp.com.hjclass_mobile.pkg_c.k))
        ((hjapp.com.hjclass_mobile.pkg_c.k)localView).a();
    }
  }

  public final aa c()
  {
    return this.l;
  }

  public final int d()
  {
    return this.i;
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
        this.m = 0.0F;
        this.n = paramMotionEvent.getRawY();
        return bool;
        this.o = paramMotionEvent.getRawY();
        this.m = Math.abs(this.o - this.n);
      }
      while (this.m <= 20.0F);
      this.c.c();
      return bool;
      this.m = Math.abs(this.o - this.n);
      hjapp.com.hjclass_mobile.pkg_h.u.b("yDistance" + this.m + ",optionsLayout.isIntecept()=" + this.c.b());
    }
    while ((this.c.b()) || (this.m >= 5.0F));
    Intent localIntent = new Intent("show_cmd");
    getContext().sendBroadcast(localIntent);
    return bool;
  }

  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    hjapp.com.hjclass_mobile.pkg_h.u.b("onTouchEvent 返回的是" + bool);
    return super.onTouchEvent(paramMotionEvent);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     h
 * JD-Core Version:    0.6.2
 */