package hjapp.com.hjclass_mobile.zoom;

import java.util.Observable;

public final class e extends Observable
{
  private float a;
  private float b;
  private float c;

  public final float a()
  {
    return this.b;
  }

  public final float a(float paramFloat)
  {
    return Math.min(this.a, paramFloat * this.a);
  }

  public final float b()
  {
    return this.c;
  }

  public final float b(float paramFloat)
  {
    return Math.min(this.a, this.a / paramFloat);
  }

  public final float c()
  {
    return this.a;
  }

  public final void c(float paramFloat)
  {
    if (paramFloat != this.b)
    {
      this.b = paramFloat;
      setChanged();
    }
  }

  public final void d(float paramFloat)
  {
    if (paramFloat != this.c)
    {
      this.c = paramFloat;
      setChanged();
    }
  }

  public final void e(float paramFloat)
  {
    if (paramFloat != this.a)
    {
      this.a = paramFloat;
      setChanged();
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     e
 * JD-Core Version:    0.6.2
 */