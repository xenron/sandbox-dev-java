package hjapp.com.hjclass_mobile.b;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

final class i extends LinkedHashMap
{
  i()
  {
    super(5, 0.75F, true);
  }

  protected final boolean removeEldestEntry(Map.Entry paramEntry)
  {
    if (size() > 10)
    {
      h.b().put(paramEntry.getKey(), new SoftReference(paramEntry.getValue()));
      return true;
    }
    return false;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     i
 * JD-Core Version:    0.6.2
 */