package hjapp.com.hjclass_mobile.g;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import hjapp.com.hjclass_mobile.c.x;
import hjapp.com.hjclass_mobile.h.u;

public final class r extends a
  implements Callback
{
  private SurfaceView b = null;
  private SurfaceHolder c = null;
  private Context d = null;
  private int e;
  private int f;
  private boolean g = false;
  private x h = null;

  public r(String paramString1, Context paramContext, String paramString2, String paramString3)
  {
    super(paramString1, paramContext, paramString2, paramString3);
    a(paramContext);
    a(Boolean.valueOf(true));
    this.d = paramContext;
  }

  private void a(Context paramContext)
  {
    u.b("创建");
    this.b = new SurfaceView(paramContext);
    this.c = this.b.getHolder();
    this.c.setType(3);
    this.c.addCallback(this);
  }

  public final void a(int paramInt)
  {
    if (b() - paramInt < 7000)
      paramInt -= 7000;
    u.b(String.valueOf(paramInt));
    super.a(paramInt);
  }

  public final void a(x paramx)
  {
    this.h = paramx;
  }

  public final void c()
  {
    super.c();
    this.b = null;
  }

  public final void m()
  {
    a(this.d);
  }

  public final SurfaceView n()
  {
    return this.b;
  }

  public final int o()
  {
    return this.e;
  }

  public final int p()
  {
    return this.f;
  }

  public final boolean q()
  {
    return this.g;
  }

  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      if (this.a != null)
        this.a.setDisplay(paramSurfaceHolder);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (this.h != null)
      this.h.v();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     g:    0.6.2
 */