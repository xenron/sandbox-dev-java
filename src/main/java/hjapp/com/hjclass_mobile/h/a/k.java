package hjapp.com.hjclass_mobile.h.a;

import java.util.HashMap;

public abstract class k
{
  private HashMap a = new HashMap();
  private HashMap b = new HashMap();
  private String c = "";
  private String d = "";
  private d e = null;

  public final d a()
  {
    return this.e;
  }

  public final d a(String paramString)
  {
    return (d)this.b.get(paramString.toLowerCase());
  }

  public final void a(String paramString, int paramInt)
  {
    this.a.put(paramString, new Integer(paramInt));
  }

  public final void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    d locald = new d(paramString, paramInt1, paramInt2, paramInt3, this);
    this.b.put(paramString.toLowerCase(), locald);
    if (paramInt2 == -2147483648)
      this.e = locald;
  }

  public final void a(String paramString1, String paramString2)
  {
    d locald1 = a(paramString1);
    d locald2 = a(paramString2);
    if (locald1 == null)
      throw new Error("No child " + paramString1 + " for parent " + paramString2);
    if (locald2 == null)
      throw new Error("No parent " + paramString2 + " for child " + paramString1);
    locald1.b(locald2);
  }

  public final void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    d locald = a(paramString1);
    if (locald == null)
      throw new Error("Attribute " + paramString2 + " specified for unknown element type " + paramString1);
    locald.a(paramString2, paramString3, paramString4);
  }

  public final int b(String paramString)
  {
    Integer localInteger = (Integer)this.a.get(paramString);
    if (localInteger == null)
      return 0;
    return localInteger.intValue();
  }

  public final String b()
  {
    return this.c;
  }

  public final String c()
  {
    return this.d;
  }

  public final void c(String paramString)
  {
    this.c = paramString;
  }

  public final void d(String paramString)
  {
    this.d = paramString;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     k   0.6.2
 */