package hjapp.com.hjclass_mobile.view.ele;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import hjapp.com.hjclass_mobile.b.a;
import hjapp.com.hjclass_mobile.c.k;
import hjapp.com.hjclass_mobile.c.z;

import java.io.File;

public final class o extends RelativeLayout
  implements k
{
  private ImageView a = null;
  private ImageView b = null;
  private Boolean c = Boolean.valueOf(false);
  private a d = null;
  private String e = null;
  private RadioButton f = null;
  private hjapp.com.hjclass_mobile.c.z g = null;
  private int h = -1;
  private ImageView i = null;

  public o(Context paramContext, a parama)
  {
    super(paramContext);
    this.d = parama;
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903064, null);
    addView(localView);
    this.i = ((ImageView)localView.findViewById(2131361919));
    this.f = ((RadioButton)localView.findViewById(2131361903));
    this.f.setOnCheckedChangeListener(new p(this));
    this.b = ((ImageView)localView.findViewById(2131361906));
    this.a = ((ImageView)localView.findViewById(2131361905));
    this.a.setVisibility(4);
    this.b.setVisibility(4);
  }

  public final void a()
  {
    this.f.setEnabled(true);
    setEnabled(true);
    this.f.setChecked(false);
    this.a.setVisibility(4);
    this.b.setVisibility(4);
  }

  public final void a(z paramz)
  {
    this.g = paramz;
  }

  public final void a(hjapp.com.hjclass_mobile.d.z paramz)
  {
    if (paramz.b().equals(this.e))
    {
      this.f.setChecked(true);
      if (this.c.booleanValue())
        this.b.setVisibility(0);
    }
    else
    {
      return;
    }
    this.a.setVisibility(0);
  }

  public final void a(Boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public final void a(String paramString)
  {
  }

  public final void b()
  {
    hjapp.com.hjclass_mobile.h.u.b("图片题的INIT");
    this.f.setEnabled(false);
    setEnabled(false);
  }

  public final void b(String paramString)
  {
    Options localOptions;
    String str;
    if (this.i != null)
    {
      new Options();
      localOptions = new Options();
      localOptions.inJustDecodeBounds = true;
      localOptions.inSampleSize = hjapp.com.hjclass_mobile.h.z.a(localOptions, Math.min(246, 134), 32964);
      localOptions.inJustDecodeBounds = false;
      localOptions.inInputShareable = true;
      localOptions.inPurgeable = true;
      str = this.d.c() + File.separator + paramString;
    }
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(str, localOptions);
      this.i.setImageBitmap(localBitmap);
      this.e = str;
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }

  public final void c()
  {
    removeAllViews();
    this.a.destroyDrawingCache();
    this.a = null;
    this.b.destroyDrawingCache();
    this.b = null;
    this.f = null;
  }

  public final Boolean d()
  {
    return this.c;
  }

  public final z e()
  {
    return this.g;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     o
 * JD-Core Version:    0.6.2
 */