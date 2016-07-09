package hjapp.com.hjclass_mobile;

import android.app.Application;
import android.content.Intent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class HJApplication extends Application
{
  private static float g = 0.0F;
  private static int h = 0;
  private static int i = 0;
  private static int j = 0;
  private Map a = null;
  private List b = null;
  private Intent c = null;
  private Hashtable d = null;
  private List e = null;
  private String f = null;

  public static void a(float paramFloat)
  {
    g = paramFloat;
  }

  public static void a(int paramInt)
  {
    i = paramInt;
  }

  public static void b(int paramInt)
  {
    j = paramInt;
  }

  public static void c(int paramInt)
  {
    h = paramInt;
  }

  public static int f()
  {
    return i;
  }

  public static int g()
  {
    return j;
  }

  public static float h()
  {
    return g;
  }

  public static int i()
  {
    return h;
  }

  public final Map a()
  {
    if (this.a == null)
      this.a = new HashMap();
    return this.a;
  }

  public final void a(Intent paramIntent)
  {
    this.c = paramIntent;
  }

  public final void a(List paramList)
  {
    this.b = paramList;
  }

  public final List b()
  {
    if (this.b == null)
      this.b = new ArrayList();
    return this.b;
  }

  public final Intent c()
  {
    if (this.c == null)
      this.c = new Intent();
    return this.c;
  }

  public final Hashtable d()
  {
    if (this.d == null)
      this.d = new Hashtable();
    return this.d;
  }

  public final List e()
  {
    if (this.e == null)
      this.e = new ArrayList();
    return this.e;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJApplication
 * JD-Core Version:    0.6.2
 */