package hjapp.com.hjclass_mobile;

import android.content.Intent;

final class dy
  implements Runnable
{
  dy(MainActivity paramMainActivity, boolean paramBoolean)
  {
  }

  public final void run()
  {
    Intent localIntent = new Intent();
    if (this.a)
      localIntent.putExtra("category", "freelesson");
    while (true)
    {
      localIntent.setClass(this.b, TabMainActivity.class);
      this.b.startActivity(localIntent);
      this.b.finish();
      return;
      localIntent.putExtra("category", "myclass");
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     dy
 * JD-Core Version:    0.6.2
 */