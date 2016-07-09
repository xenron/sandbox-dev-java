package hjapp.com.hjclass_mobile;

import android.view.View;
import android.view.View.OnClickListener;

final class dt
  implements OnClickListener
{
  dt(ImageActivity paramImageActivity)
  {
  }

  public final void onClick(View paramView)
  {
    if (ImageActivity.c(this.a) != null)
    {
      float f = ImageActivity.c(this.a).a().c();
      if (f < 3.0F)
      {
        ImageActivity.c(this.a).a().e(f + 0.5F);
        ImageActivity.c(this.a).a().notifyObservers();
        if (ImageActivity.c(this.a).a().c() < 3.0F)
          break label92;
        ImageActivity.b(this.a).setIsZoomInEnabled(false);
      }
    }
    return;
    label92: ImageActivity.b(this.a).setIsZoomInEnabled(true);
    ImageActivity.b(this.a).setIsZoomOutEnabled(true);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     dt
 * JD-Core Version:    0.6.2
 */