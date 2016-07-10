package hjapp.com.hjclass_mobile.pkg_h;

import java.util.LinkedHashMap;

final class w extends LinkedHashMap
{
  w(v paramv, int paramInt)
  {
    super(16, 0.75F, true);
  }

  protected final boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > this.a;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     w
 * JD-Core Version:    0.6.2
 */