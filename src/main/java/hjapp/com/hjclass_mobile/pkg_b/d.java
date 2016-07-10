package hjapp.com.hjclass_mobile.pkg_b;

import android.content.Context;
import android.os.AsyncTask;
import hjapp.com.hjclass_mobile.pkg_c.a;
import hjapp.com.hjclass_mobile.pkg_h.z;

import java.io.File;

public final class d extends AsyncTask
{
  private a a = null;
  private Context b;
  private f c = null;
  private boolean d;
  private String e;
  private String f;
  private int g;

  public d(Context paramContext, a parama, String paramString)
  {
    this.b = paramContext;
    this.a = parama;
    this.f = paramString;
    this.c = new f();
    hjapp.com.hjclass_mobile.pkg_h.u.b("实例化DownloadAsyncTask");
  }

  private Void a(String[] paramArrayOfString)
  {
    try
    {
      this.d = true;
      String str = paramArrayOfString[0];
      int i = Integer.parseInt(paramArrayOfString[1]);
      try
      {
        hjapp.com.hjclass_mobile.pkg_d.o localo = new hjapp.com.hjclass_mobile.pkg_d.o();
        localo.c(this.f);
        localo.a(str);
        localo.b(z.c + File.separator + i + File.separator);
        localo.a(i);
        e locale = new e(this.b);
        int[] arrayOfInt = locale.a(str, i);
        localo.b(arrayOfInt[0]);
        localo.a(arrayOfInt[1]);
        f localf = this.c;
        localf.a(localo, locale);
        this.c.a(this.a);
        this.c.a();
        return null;
      }
      catch (Exception localException2)
      {
        while (true)
          localException2.printStackTrace();
      }
    }
    catch (Exception localException1)
    {
      while (true)
      {
        c(true);
        localException1.printStackTrace();
      }
    }
  }

  public final void a()
  {
    if (this.c != null)
      this.c.c();
  }

  public final void a(int paramInt)
  {
    this.g = paramInt;
  }

  public final void a(String paramString)
  {
    this.e = paramString;
  }

  public final void a(boolean paramBoolean)
  {
    if (this.c != null)
      this.c.b(paramBoolean);
  }

  public final void b(boolean paramBoolean)
  {
    if (this.c != null)
      this.c.d(paramBoolean);
  }

  public final boolean b()
  {
    if (this.c == null)
      return false;
    return this.c.d();
  }

  public final void c(boolean paramBoolean)
  {
    if (this.c != null)
      this.c.a(paramBoolean);
  }

  public final boolean c()
  {
    if (this.c == null)
      return false;
    return this.c.e();
  }

  public final boolean d()
  {
    if (this.c == null)
      return false;
    return this.c.f();
  }

  public final void e()
  {
    if (this.c == null)
      return;
    this.c.c(true);
  }

  public final void f()
  {
    if (this.c == null)
      return;
    this.c.c(false);
  }

  public final void g()
  {
    if (this.c == null)
      return;
    this.c.g();
  }

  public final boolean h()
  {
    return this.d;
  }

  public final String i()
  {
    return this.e;
  }

  public final int j()
  {
    return this.g;
  }

  protected final void onCancelled()
  {
    if (this.c == null)
      return;
    this.c.c(true);
    super.onCancelled();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     d
 * JD-Core Version:    0.6.2
 */