package hjapp.com.hjclass_mobile.b;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageView;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class h
{
  private static final HashMap a = new i();
  private static final ConcurrentHashMap b = new ConcurrentHashMap(5);
  private final Handler c = new Handler();
  private final Runnable d = new j(this);

  private static Bitmap a(String paramString)
  {
    synchronized (a)
    {
      Bitmap localBitmap = (Bitmap)a.get(paramString);
      if (localBitmap != null)
      {
        a.remove(paramString);
        a.put(paramString, localBitmap);
      }
      do
      {
        return localBitmap;
        SoftReference localSoftReference = (SoftReference)b.get(paramString);
        if (localSoftReference == null)
          break;
        localBitmap = (Bitmap)localSoftReference.get();
      }
      while (localBitmap != null);
      b.remove(paramString);
      return null;
    }
  }

  public static void a()
  {
    a.clear();
    b.clear();
  }

  private static k b(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      Drawable localDrawable = paramImageView.getDrawable();
      if ((localDrawable instanceof l))
        return ((l)localDrawable).a();
    }
    return null;
  }

  public final void a(String paramString, ImageView paramImageView, Bitmap paramBitmap)
  {
    this.c.removeCallbacks(this.d);
    this.c.postDelayed(this.d, 120000L);
    Bitmap localBitmap = a(paramString);
    if (localBitmap == null)
    {
      k localk1 = new k(this, paramImageView);
      paramImageView.setImageDrawable(new l(localk1, paramBitmap));
      localk1.execute(new String[] { paramString });
      return;
    }
    k localk2 = b(paramImageView);
    if (localk2 != null)
    {
      String str = k.a(localk2);
      if ((str == null) || (!str.equals(paramString)))
        localk2.cancel(true);
    }
    paramImageView.setImageBitmap(localBitmap);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     h
 * JD-Core Version:    0.6.2
 */