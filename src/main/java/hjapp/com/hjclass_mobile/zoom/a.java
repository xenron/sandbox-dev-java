package hjapp.com.hjclass_mobile.zoom;

import java.util.Observable;

public final class a extends Observable
{
  private float a;

  public final float a()
  {
    return this.a;
  }

  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f = paramFloat3 / paramFloat4 / (paramFloat1 / paramFloat2);
    if (f != this.a)
    {
      this.a = f;
      setChanged();
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     a
 * JD-Core Version:    0.6.2
 */