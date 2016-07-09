package hjapp.com.hjclass_mobile.h.a;

public final class d
{
  private String a;
  private String b;
  private String c;
  private int d;
  private int e;
  private int f;
  private a g;
  private d h;
  private k i;

  public d(String paramString, int paramInt1, int paramInt2, int paramInt3, k paramk)
  {
    this.a = paramString;
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramInt3;
    this.g = new a();
    this.i = paramk;
    this.b = a(paramString, false);
    this.c = a(paramString);
  }

  private static String a(String paramString)
  {
    int j = paramString.indexOf(':');
    if (j == -1)
      return paramString;
    return paramString.substring(j + 1).intern();
  }

  private String a(String paramString, boolean paramBoolean)
  {
    int j = paramString.indexOf(':');
    if (j == -1)
    {
      if (paramBoolean)
        return "";
      return this.i.b();
    }
    String str = paramString.substring(0, j);
    if (str.equals("xml"))
      return "http://www.w3.org/XML/1998/namespace";
    return ("urn:x-prefix:" + str).intern();
  }

  private static String b(String paramString)
  {
    if (paramString == null);
    do
    {
      return paramString;
      paramString = paramString.trim();
    }
    while (paramString.indexOf("  ") == -1);
    int j = paramString.length();
    StringBuffer localStringBuffer = new StringBuffer(j);
    int k = 0;
    int m = 0;
    if (k < j)
    {
      char c1 = paramString.charAt(k);
      if (c1 == ' ')
        if (m == 0)
          localStringBuffer.append(c1);
      for (m = 1; ; m = 0)
      {
        k++;
        break;
        localStringBuffer.append(c1);
      }
    }
    return localStringBuffer.toString();
  }

  public final String a()
  {
    return this.a;
  }

  public final void a(a parama, String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1.equals("xmlns")) || (paramString1.startsWith("xmlns:")))
      return;
    String str1 = a(paramString1, true);
    String str2 = a(paramString1);
    int j = parama.getIndex(paramString1);
    String str5;
    if (j == -1)
    {
      str5 = paramString1.intern();
      if (paramString2 != null)
        break label157;
    }
    label157: for (String str6 = "CDATA"; ; str6 = paramString2)
    {
      if (!str6.equals("CDATA"));
      for (String str7 = b(paramString3); ; str7 = paramString3)
      {
        parama.a(str1, str2, str5, str6, str7);
        return;
        if (paramString2 == null);
        for (String str3 = parama.getType(j); ; str3 = paramString2)
        {
          if (!str3.equals("CDATA"));
          for (String str4 = b(paramString3); ; str4 = paramString3)
          {
            parama.a(j, str1, str2, paramString1, str3, str4);
            return;
          }
        }
      }
    }
  }

  public final void a(String paramString1, String paramString2, String paramString3)
  {
    a(this.g, paramString1, paramString2, paramString3);
  }

  public final boolean a(d paramd)
  {
    return (this.d & paramd.e) != 0;
  }

  public final String b()
  {
    return this.b;
  }

  public final void b(d paramd)
  {
    this.h = paramd;
  }

  public final String c()
  {
    return this.c;
  }

  public final int d()
  {
    return this.d;
  }

  public final int e()
  {
    return this.f;
  }

  public final a f()
  {
    return this.g;
  }

  public final d g()
  {
    return this.h;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     a   0.6.2
 */