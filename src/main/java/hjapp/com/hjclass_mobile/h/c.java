package hjapp.com.hjclass_mobile.h;

import android.text.Spanned;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

public final class c
{
  public static Spanned a(String paramString)
  {
    a.g localg = new a.g();
    try
    {
      localg.setProperty("http://www.ccil.org/~cowan/tagsoup/properties/schema", d.a());
      return new g(paramString, localg).a();
    }
    catch (SAXNotRecognizedException localSAXNotRecognizedException)
    {
      throw new RuntimeException(localSAXNotRecognizedException);
    }
    catch (SAXNotSupportedException localSAXNotSupportedException)
    {
      throw new RuntimeException(localSAXNotSupportedException);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     c
 * JD-Core Version:    0.6.2
 */