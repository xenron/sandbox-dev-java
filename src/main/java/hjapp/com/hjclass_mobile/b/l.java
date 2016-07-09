package hjapp.com.hjclass_mobile.b;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

final class l extends BitmapDrawable
{
  private final WeakReference a;

  public l(k paramk, Bitmap paramBitmap)
  {
    super(paramBitmap);
    this.a = new WeakReference(paramk);
  }

  public final k a()
  {
    return (k)this.a.get();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     l
 * JD-Core Version:    0.6.2
 */