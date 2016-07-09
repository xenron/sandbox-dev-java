package hjapp.com.hjclass_mobile.view;

final class e
  implements Runnable
{
  e(d paramd)
  {
  }

  public final void run()
  {
    if ((!d.a(this.a)) && (d.b(this.a) != null) && ((!this.a.g()) || (d.c(this.a))))
    {
      d.a(this.a, d.b(this.a).b());
      d.b(this.a).b(d.b(this.a).b() / 1000);
      d.e(this.a).postDelayed(d.d(this.a), 1000L);
    }
    if (d.c(this.a))
    {
      this.a.f();
      d.a(this.a, false);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     e
 * JD-Core Version:    0.6.2
 */