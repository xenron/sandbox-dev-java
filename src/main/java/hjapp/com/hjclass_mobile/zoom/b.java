package hjapp.com.hjclass_mobile.zoom;

import java.util.Observable;
import java.util.Observer;

public final class b
  implements Observer
{
  private final e a = new e();
  private a b;

  private static float a(float paramFloat)
  {
    return Math.max(0.0F, 0.5F * ((paramFloat - 1.0F) / paramFloat));
  }

  private void b()
  {
    if (this.a.c() < 1.0F)
      this.a.e(1.0F);
    while (this.a.c() <= 16.0F)
      return;
    this.a.e(16.0F);
  }

  private void c()
  {
    float f1 = this.b.a();
    float f2 = this.a.a(f1);
    float f3 = this.a.b(f1);
    float f4 = 0.5F - a(f2);
    float f5 = 0.5F + a(f2);
    float f6 = 0.5F - a(f3);
    float f7 = 0.5F + a(f3);
    if (this.a.a() < f4)
      this.a.c(f4);
    if (this.a.a() > f5)
      this.a.c(f5);
    if (this.a.b() < f6)
      this.a.d(f6);
    if (this.a.b() > f7)
      this.a.d(f7);
  }

  public final e a()
  {
    return this.a;
  }

  public final void a(float paramFloat1, float paramFloat2)
  {
    float f = this.b.a();
    this.a.c(this.a.a() + paramFloat1 / this.a.a(f));
    this.a.d(this.a.b() + paramFloat2 / this.a.b(f));
    c();
    this.a.notifyObservers();
  }

  public final void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = this.b.a();
    float f2 = this.a.a(f1);
    float f3 = this.a.b(f1);
    this.a.e(paramFloat1 * this.a.c());
    b();
    float f4 = this.a.a(f1);
    float f5 = this.a.b(f1);
    this.a.c(this.a.a() + (paramFloat2 - 0.5F) * (1.0F / f2 - 1.0F / f4));
    this.a.d(this.a.b() + (paramFloat3 - 0.5F) * (1.0F / f3 - 1.0F / f5));
    c();
    this.a.notifyObservers();
  }

  public final void a(a parama)
  {
    if (this.b != null)
      this.b.deleteObserver(this);
    this.b = parama;
    this.b.addObserver(this);
  }

  public final void update(Observable paramObservable, Object paramObject)
  {
    b();
    c();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     b
 * JD-Core Version:    0.6.2
 */