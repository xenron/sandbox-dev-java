package hjapp.com.hjclass_mobile;

import android.view.View;
import android.view.View.OnClickListener;

final class du
  implements OnClickListener
{
  du(ImageActivity paramImageActivity)
  {
  }

  public final void onClick(View paramView)
  {
    if (ImageActivity.c(this.a) != null)
    {
      float f = ImageActivity.c(this.a).a().c();
      if (f > 1.0F)
      {
        ImageActivity.c(this.a).a().e(f - 0.5F);
        ImageActivity.c(this.a).a().notifyObservers();
        if (ImageActivity.c(this.a).a().c() > 1.0F)
          break label90;
        ImageActivity.b(this.a).setIsZoomOutEnabled(false);
      }
    }
    return;
    label90: ImageActivity.b(this.a).setIsZoomInEnabled(true);
    ImageActivity.b(this.a).setIsZoomOutEnabled(true);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     du
 * JD-Core Version:    0.6.2
 */