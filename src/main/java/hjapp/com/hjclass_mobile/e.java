package hjapp.com.hjclass_mobile;

import hjapp.com.hjclass_mobile.pkg_c.i;

import java.io.File;

final class e
  implements pkg_c.h
{
  e(DownloadService paramDownloadService, String paramString)
  {
  }

  public final void a(i parami, String paramString)
  {
    if (parami == i.b)
    {
      DownloadService.a(this.b, paramString);
      int i = DownloadService.b(this.b);
      if (i >= 0)
        DownloadService.a(this.b, i);
    }
  }

  public final void a(i parami, String[] paramArrayOfString)
  {
    if (parami == i.b)
    {
      String str = paramArrayOfString[0];
      if (!hjapp.com.hjclass_mobile.h.y.c(str))
        DownloadService.a(this.b, new File(this.a), str);
    }
  }

  public final void b(i parami, String paramString)
  {
    if (parami == i.b)
    {
      DownloadService.b(this.b, paramString);
      int i = DownloadService.b(this.b);
      if (i >= 0)
        DownloadService.a(this.b, i);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     e
 * JD-Core Version:    0.6.2
 */