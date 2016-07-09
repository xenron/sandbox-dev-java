package hjapp.com.hjclass_mobile.h.a;

public final class c
{
  private d a;
  private a b;
  private c c;
  private boolean d;

  public c(d paramd, boolean paramBoolean)
  {
    this.a = paramd;
    if (paramBoolean);
    for (this.b = new a(paramd.f()); ; this.b = new a())
    {
      this.c = null;
      this.d = false;
      return;
    }
  }

  public final a a()
  {
    return this.b;
  }

  public final void a(c paramc)
  {
    this.c = paramc;
  }

  public final void a(String paramString1, String paramString2)
  {
    this.a.a(this.b, paramString1, null, paramString2);
  }

  public final c b()
  {
    return this.c;
  }

  public final boolean b(c paramc)
  {
    return this.a.a(paramc.a);
  }

  public final String c()
  {
    return this.a.a();
  }

  public final String d()
  {
    return this.a.b();
  }

  public final String e()
  {
    return this.a.c();
  }

  public final int f()
  {
    return this.a.d();
  }

  public final int g()
  {
    return this.a.e();
  }

  public final d h()
  {
    return this.a.g();
  }

  public final void i()
  {
    for (int i = -1 + this.b.getLength(); i >= 0; i--)
      if ((this.b.getType(i).equals("ID")) || (this.b.getQName(i).equals("name")))
        this.b.a(i);
  }

  public final void j()
  {
    for (int i = -1 + this.b.getLength(); i >= 0; i--)
    {
      String str = this.b.getLocalName(i);
      if ((this.b.getValue(i) == null) || (str == null) || (str.length() == 0))
        this.b.a(i);
    }
  }

  public final void k()
  {
    this.d = true;
  }

  public final boolean l()
  {
    return this.d;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     a   0.6.2
 */