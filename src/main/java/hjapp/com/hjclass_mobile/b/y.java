package hjapp.com.hjclass_mobile.b;

import android.text.TextUtils;
import hjapp.com.hjclass_mobile.d.b;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public final class y extends DefaultHandler
{
  private b a;
  private List b;
  private hjapp.com.hjclass_mobile.d.y c;
  private String d;

  public final b a()
  {
    return this.a;
  }

  public final void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    String str;
    if (this.d != null)
    {
      str = new String(paramArrayOfChar, paramInt1, paramInt2);
      if (!TextUtils.isEmpty(str))
      {
        if (!"className".equals(this.d))
          break label49;
        this.a.a(str);
      }
    }
    label49: 
    do
    {
      return;
      if ("classID".equals(this.d))
      {
        this.a.a(Integer.valueOf(Integer.parseInt(str)));
        return;
      }
      if ("lessonID".equals(this.d))
      {
        this.a.b(Integer.valueOf(Integer.parseInt(str)));
        return;
      }
      if ("classAudio".equals(this.d))
      {
        this.a.b(str);
        return;
      }
      if ("totalTime".equals(this.d))
      {
        this.a.c(Integer.valueOf(Integer.parseInt(str)));
        return;
      }
    }
    while (!"mediaType".equals(this.d));
    this.a.c(str);
  }

  public final void endDocument()
  {
    this.a.a(this.b);
    super.endDocument();
  }

  public final void endElement(String paramString1, String paramString2, String paramString3)
  {
    if ("page".equals(paramString2))
    {
      this.b.add(this.c);
      this.c = null;
    }
    this.d = null;
  }

  public final void startDocument()
  {
    this.a = new b();
    this.b = new ArrayList();
  }

  public final void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if ("page".equals(paramString2))
    {
      this.c = new hjapp.com.hjclass_mobile.d.y();
      this.c.b(new Integer(paramAttributes.getValue(0)));
      this.c.a(new Integer(paramAttributes.getValue(1)));
      this.c.a(this.c.a());
      this.c.b(paramAttributes.getValue(2));
    }
    this.d = paramString2;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     y
 * JD-Core Version:    0.6.2
 */