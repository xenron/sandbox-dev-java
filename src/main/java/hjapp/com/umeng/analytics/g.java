package hjapp.com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.Vector;

class g
{
  private static final int b = 4;
  private Vector a;
  private String c;
  private Context d;

  public g(Context paramContext, String paramString)
  {
    this.a = new Vector(4);
    this.d = paramContext;
    this.c = paramString;
  }

  public g(Context paramContext, String paramString, int paramInt)
  {
    this.c = paramString;
    this.d = paramContext;
    if (paramInt < 0)
    {
      this.a = new Vector(4);
      return;
    }
    this.a = new Vector(paramInt);
  }

  public static g a(Context paramContext, String paramString)
  {
    String str1 = f.e(paramContext).getString(paramString, null);
    g localg = new g(paramContext, paramString);
    if (TextUtils.isEmpty(str1))
      return localg;
    String[] arrayOfString = str1.split(",");
    int i = arrayOfString.length;
    int j = 0;
    while (j < i)
    {
      String str2 = arrayOfString[j].trim();
      if (!TextUtils.isEmpty(str2))
        Long.valueOf(-1L);
      try
      {
        Long localLong = Long.valueOf(Long.parseLong(str2));
        localg.a(localLong);
        label95: j++;
      }
      catch (Exception localException)
      {
        break label95;
      }
    }
  }

  public Long a()
  {
    int i = this.a.size();
    if (i <= 0)
      return Long.valueOf(-1L);
    return (Long)this.a.remove(i - 1);
  }

  public void a(Long paramLong)
  {
    while (this.a.size() >= 4)
      this.a.remove(0);
    this.a.add(paramLong);
  }

  public int b()
  {
    return this.a.size();
  }

  public void c()
  {
    String str = toString();
    Editor localEditor = f.e(this.d).edit();
    if (TextUtils.isEmpty(str))
    {
      localEditor.remove(this.c).commit();
      return;
    }
    localEditor.putString(this.c, str).commit();
  }

  public String toString()
  {
    int i = this.a.size();
    if (i <= 0)
      return null;
    StringBuffer localStringBuffer = new StringBuffer(4);
    for (int j = 0; j < i; j++)
    {
      localStringBuffer.append(this.a.get(j));
      if (j != i - 1)
        localStringBuffer.append(",");
    }
    this.a.clear();
    return localStringBuffer.toString();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     g
 * JD-Core Version:    0.6.2
 */