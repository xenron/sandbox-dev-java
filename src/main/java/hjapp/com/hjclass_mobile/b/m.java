package hjapp.com.hjclass_mobile.b;

import java.io.FilterInputStream;
import java.io.InputStream;

final class m extends FilterInputStream
{
  public m(InputStream paramInputStream)
  {
    super(paramInputStream);
  }

  public final long skip(long paramLong)
  {
    long l2;
    for (long l1 = 0L; l1 < paramLong; l1 = l2 + l1)
    {
      l2 = this.in.skip(paramLong - l1);
      if (l2 == 0L)
      {
        if (read() < 0)
          break;
        l2 = 1L;
      }
    }
    return l1;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     m
 * JD-Core Version:    0.6.2
 */