package hjapp.com.umeng.common;

import android.content.Context;

public class c
{
  private static final String a = c.class.getName();
  private static c b;
  private static Class d = null;
  private static Class e = null;
  private static Class f = null;
  private static Class g = null;
  private static Class h = null;
  private static Class i = null;
  private static Class j = null;
  private Context c;

  private c(Context paramContext)
  {
    this.c = paramContext;
    try
    {
      e = Class.forName(this.c.getPackageName() + ".R$drawable");
    }
    catch (ClassNotFoundException localClassNotFoundException6)
    {
      try
      {
        f = Class.forName(this.c.getPackageName() + ".R$layout");
      }
      catch (ClassNotFoundException localClassNotFoundException6)
      {
        try
        {
          d = Class.forName(this.c.getPackageName() + ".R$id");
        }
        catch (ClassNotFoundException localClassNotFoundException6)
        {
          try
          {
            g = Class.forName(this.c.getPackageName() + ".R$anim");
          }
          catch (ClassNotFoundException localClassNotFoundException6)
          {
            try
            {
              h = Class.forName(this.c.getPackageName() + ".R$style");
            }
            catch (ClassNotFoundException localClassNotFoundException6)
            {
              try
              {
                i = Class.forName(this.c.getPackageName() + ".R$string");
              }
              catch (ClassNotFoundException localClassNotFoundException6)
              {
                try
                {
                  while (true)
                  {
                    j = Class.forName(this.c.getPackageName() + ".R$array");
                    return;
                    localClassNotFoundException1 = localClassNotFoundException1;
                    a.b(a, localClassNotFoundException1.getMessage());
                    continue;
                    localClassNotFoundException2 = localClassNotFoundException2;
                    a.b(a, localClassNotFoundException2.getMessage());
                    continue;
                    localClassNotFoundException3 = localClassNotFoundException3;
                    a.b(a, localClassNotFoundException3.getMessage());
                    continue;
                    localClassNotFoundException4 = localClassNotFoundException4;
                    a.b(a, localClassNotFoundException4.getMessage());
                    continue;
                    localClassNotFoundException5 = localClassNotFoundException5;
                    a.b(a, localClassNotFoundException5.getMessage());
                    continue;
                    localClassNotFoundException6 = localClassNotFoundException6;
                    a.b(a, localClassNotFoundException6.getMessage());
                  }
                }
                catch (ClassNotFoundException localClassNotFoundException7)
                {
                  a.b(a, localClassNotFoundException7.getMessage());
                }
              }
            }
          }
        }
      }
    }
  }

  private static int a(Class paramClass, String paramString)
  {
    if (paramClass == null)
    {
      a.b(a, "getRes(null," + paramString + ")");
      throw new IllegalArgumentException("ResClass is not initialized.");
    }
    try
    {
      int k = paramClass.getField(paramString).getInt(paramString);
      return k;
    }
    catch (Exception localException)
    {
      a.b(a, "getRes(" + paramClass.getName() + ", " + paramString + ")");
      a.b(a, "Error getting resource. Make sure you have copied all resources (res/) from SDK to your project. ");
      a.b(a, localException.getMessage());
    }
    return -1;
  }

  public static int a(String paramString)
  {
    return a(d, paramString);
  }

  public static c a(Context paramContext)
  {
    if (b == null)
      b = new c(paramContext);
    return b;
  }

  public static int b(String paramString)
  {
    return a(e, paramString);
  }

  public static int c(String paramString)
  {
    return a(f, paramString);
  }

  public static int d(String paramString)
  {
    return a(i, paramString);
  }

  public static int e(String paramString)
  {
    return a(j, paramString);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     c
 * JD-Core Version:    0.6.2
 */