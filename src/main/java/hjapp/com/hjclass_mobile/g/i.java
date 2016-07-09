package hjapp.com.hjclass_mobile.g;

final class i
  implements Runnable
{
  i(h paramh)
  {
  }

  public final void run()
  {
    h.b(this.a).removeCallbacks(h.a(this.a));
    h.c(this.a).stop();
    h.c(this.a).release();
    h.d(this.a);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     g:    0.6.2
 */