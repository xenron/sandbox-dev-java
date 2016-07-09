package hjapp.com.hjclass_mobile.g;

final class c
  implements Runnable
{
  c(b paramb)
  {
  }

  public final void run()
  {
    b.b(this.a).removeCallbacks(b.a(this.a));
    if (this.a.a != null)
    {
      this.a.a.stop();
      this.a.a.release();
      this.a.a = null;
    }
    b.a(this.a, b.c(this.a), b.d(this.a), b.e(this.a));
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     c:    0.6.2
 */