package hjapp.com.hjclass_mobile.pkg_b;

public final class a
{
  private int a = 800;
  private int b = 480;
  private float c = 1.0F;
  private int d = 985;
  private int e = 625;
  private int f = 0;
  private int g = 0;
  private String h = null;

  public a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    float f1 = this.a / this.d;
    float f2 = this.b / this.e;
    float f3;
    int i;
    if (f1 < f2)
    {
      f3 = f1;
      this.c = f3;
      if (f1 >= f2)
        break label175;
      i = 1;
      label113: if (i == 0)
        break label181;
    }
    label175: label181: for (this.c = f1; ; this.c = f2)
    {
      this.f = ((this.a - (int)(this.d * this.c)) / 2);
      this.g = ((this.b - (int)(this.e * this.c)) / 2);
      return;
      f3 = f2;
      break;
      i = 0;
      break label113;
    }
  }

  public final int a()
  {
    return this.a;
  }

  public final int a(int paramInt)
  {
    return (int)(paramInt * this.c) + this.f;
  }

  public final void a(String paramString)
  {
    this.h = paramString;
  }

  public final int b()
  {
    return this.b;
  }

  public final int b(int paramInt)
  {
    return (int)(paramInt * this.c) + this.g;
  }

  public final int c(int paramInt)
  {
    return (int)(paramInt * this.c);
  }

  public final String c()
  {
    return this.h;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     a
 * JD-Core Version:    0.6.2
 */