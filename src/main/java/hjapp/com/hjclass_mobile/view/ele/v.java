package hjapp.com.hjclass_mobile.view.ele;

final class v
  implements Runnable
{
  v(u paramu)
  {
  }

  public final void run()
  {
    u.a(this.a);
    if ((u.b(this.a) >= this.a.g()) && (this.a.g() > 0))
    {
      this.a.setVisibility(8);
      u.a(this.a, Boolean.valueOf(false));
      u.c(this.a).setText("00:00");
      if (this.a.f() != null)
        this.a.f().b();
      return;
    }
    int i = this.a.g() - u.b(this.a);
    u.c(this.a).setText(hjapp.com.hjclass_mobile.pkg_h.z.a(i * 1000));
    u.e(this.a).postDelayed(u.d(this.a), 1000L);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     v
 * JD-Core Version:    0.6.2
 */