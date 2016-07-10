package hjapp.com.hjclass_mobile.pkg_h;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class x extends WeakReference
{
  Object a;

  public x(Object paramObject1, Object paramObject2, ReferenceQueue paramReferenceQueue)
  {
    super(paramObject2, paramReferenceQueue);
    this.a = paramObject1;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     x
 * JD-Core Version:    0.6.2
 */