package hjapp.com.hjclass_mobile.pkg_b;

final class g
  implements Runnable
{
  g(f paramf)
  {
  }

  public final void run()
  {
    if (this.a.b())
    {
      f.b(this.a).removeCallbacks(f.a(this.a));
      return;
    }
    f.c(this.a);
    f.b(this.a).postDelayed(f.a(this.a), 1000L);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     g
 * JD-Core Version:    0.6.2
 */