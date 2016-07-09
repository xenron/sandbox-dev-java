package hjapp.com.hjclass_mobile.h;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.ParagraphStyle;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

final class g
  implements ContentHandler
{
  private static final float[] a = { 1.5F, 1.4F, 1.3F, 1.2F, 1.1F, 1.0F };
  private static HashMap g = localHashMap;
  private String b;
  private XMLReader c;
  private SpannableStringBuilder d;
  private e e;
  private f f;

  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("aqua", Integer.valueOf(65535));
    localHashMap.put("black", Integer.valueOf(0));
    localHashMap.put("blue", Integer.valueOf(255));
    localHashMap.put("fuchsia", Integer.valueOf(16711935));
    localHashMap.put("green", Integer.valueOf(32768));
    localHashMap.put("grey", Integer.valueOf(8421504));
    localHashMap.put("lime", Integer.valueOf(65280));
    localHashMap.put("maroon", Integer.valueOf(8388608));
    localHashMap.put("navy", Integer.valueOf(128));
    localHashMap.put("olive", Integer.valueOf(8421376));
    localHashMap.put("purple", Integer.valueOf(8388736));
    localHashMap.put("red", Integer.valueOf(16711680));
    localHashMap.put("silver", Integer.valueOf(12632256));
    localHashMap.put("teal", Integer.valueOf(32896));
    localHashMap.put("white", Integer.valueOf(16777215));
    localHashMap.put("yellow", Integer.valueOf(16776960));
  }

  public g(String paramString, hjapp.com.hjclass_mobile.h.a.g paramg)
  {
    this.b = paramString;
    this.d = new SpannableStringBuilder();
    this.e = null;
    this.f = null;
    this.c = paramg;
  }

  private static int a(String paramString)
  {
    int i = 1;
    Integer localInteger = (Integer)g.get(paramString.toLowerCase());
    if (localInteger != null)
      return localInteger.intValue();
    if (paramString == null)
      return -1;
    while (true)
    {
      try
      {
        String str = paramString.toString();
        int j = str.length();
        k = 10;
        if ('-' != str.charAt(0))
          break label162;
        m = -1;
        if ('0' == str.charAt(i))
        {
          if (i == j - 1)
            return 0;
          int n = str.charAt(i + 1);
          if (120 == n)
            break label170;
          if (88 != n)
            break label182;
          break label170;
          return m * Integer.parseInt(str.substring(i1), k);
        }
        int i2 = str.charAt(i);
        if (35 == i2)
        {
          i1 = i + 1;
          k = 16;
          continue;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return -1;
      }
      int i1 = i;
      continue;
      label162: int m = i;
      i = 0;
      continue;
      label170: i1 = i + 2;
      int k = 16;
      continue;
      label182: i1 = i + 1;
      k = 8;
    }
  }

  private static Object a(Spanned paramSpanned, Class paramClass)
  {
    Object[] arrayOfObject = paramSpanned.getSpans(0, paramSpanned.length(), paramClass);
    if (arrayOfObject.length == 0)
      return null;
    return arrayOfObject[0];
  }

  private static void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = paramSpannableStringBuilder.length();
    if ((i > 0) && (paramSpannableStringBuilder.charAt(i - 1) == '\n'))
      if ((i < 2) || (paramSpannableStringBuilder.charAt(i - 2) != '\n'));
    while (i == 0)
    {
      return;
      paramSpannableStringBuilder.append("\n");
      return;
    }
    paramSpannableStringBuilder.append("\n\n");
  }

  private static void a(SpannableStringBuilder paramSpannableStringBuilder, Class paramClass, Object paramObject)
  {
    int i = paramSpannableStringBuilder.length();
    Object localObject = a(paramSpannableStringBuilder, paramClass);
    int j = paramSpannableStringBuilder.getSpanStart(localObject);
    paramSpannableStringBuilder.removeSpan(localObject);
    if (j != i)
      paramSpannableStringBuilder.setSpan(paramObject, j, i, 33);
  }

  private static void a(SpannableStringBuilder paramSpannableStringBuilder, Object paramObject)
  {
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.setSpan(paramObject, i, i, 17);
  }

  private static void b(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = paramSpannableStringBuilder.length();
    Object localObject = a(paramSpannableStringBuilder, l.class);
    int j = paramSpannableStringBuilder.getSpanStart(localObject);
    paramSpannableStringBuilder.removeSpan(localObject);
    while ((i > j) && (paramSpannableStringBuilder.charAt(i - 1) == '\n'))
      i--;
    if (j != i)
    {
      l locall = (l)localObject;
      paramSpannableStringBuilder.setSpan(new RelativeSizeSpan(a[l.a(locall)]), j, i, 33);
      paramSpannableStringBuilder.setSpan(new StyleSpan(1), j, i, 33);
    }
  }

  public final Spanned a()
  {
    int i = 0;
    this.c.setContentHandler(this);
    while (true)
    {
      Object[] arrayOfObject;
      int j;
      int k;
      try
      {
        this.c.parse(new InputSource(new StringReader(this.b)));
        arrayOfObject = this.d.getSpans(0, this.d.length(), ParagraphStyle.class);
        if (i >= arrayOfObject.length)
          break;
        j = this.d.getSpanStart(arrayOfObject[i]);
        k = this.d.getSpanEnd(arrayOfObject[i]);
        if ((k - 2 >= 0) && (this.d.charAt(k - 1) == '\n') && (this.d.charAt(k - 2) == '\n'))
          k--;
        if (k == j)
        {
          this.d.removeSpan(arrayOfObject[i]);
          i++;
          continue;
        }
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException(localIOException);
      }
      catch (SAXException localSAXException)
      {
        throw new RuntimeException(localSAXException);
      }
      this.d.setSpan(arrayOfObject[i], j, k, 51);
    }
    return this.d;
  }

  public final void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramInt2)
    {
      char c1 = paramArrayOfChar[(i + paramInt1)];
      int j;
      int m;
      int k;
      if ((c1 == ' ') || (c1 == '\n'))
      {
        j = localStringBuilder.length();
        if (j == 0)
        {
          m = this.d.length();
          if (m == 0)
          {
            k = 10;
            label70: if ((k != 32) && (k != 10))
              localStringBuilder.append(' ');
          }
        }
      }
      while (true)
      {
        i++;
        break;
        k = this.d.charAt(m - 1);
        break label70;
        k = localStringBuilder.charAt(j - 1);
        break label70;
        localStringBuilder.append(c1);
      }
    }
    this.d.append(localStringBuilder);
  }

  public final void endDocument()
  {
  }

  public final void endElement(String paramString1, String paramString2, String paramString3)
  {
    if (paramString2.equalsIgnoreCase("br"))
      this.d.append("\n");
    label504: 
    do
    {
      SpannableStringBuilder localSpannableStringBuilder1;
      int i;
      int j;
      m localm;
      do
      {
        Object localObject1;
        do
        {
          SpannableStringBuilder localSpannableStringBuilder2;
          int k;
          Object localObject2;
          int m;
          do
          {
            return;
            if (paramString2.equalsIgnoreCase("p"))
            {
              a(this.d);
              return;
            }
            if (paramString2.equalsIgnoreCase("div"))
            {
              a(this.d);
              return;
            }
            if (paramString2.equalsIgnoreCase("em"))
            {
              a(this.d, j.class, new StyleSpan(1));
              return;
            }
            if (paramString2.equalsIgnoreCase("b"))
            {
              a(this.d, j.class, new StyleSpan(1));
              return;
            }
            if (paramString2.equalsIgnoreCase("strong"))
            {
              a(this.d, n.class, new StyleSpan(2));
              return;
            }
            if (paramString2.equalsIgnoreCase("cite"))
            {
              a(this.d, n.class, new StyleSpan(2));
              return;
            }
            if (paramString2.equalsIgnoreCase("dfn"))
            {
              a(this.d, n.class, new StyleSpan(2));
              return;
            }
            if (paramString2.equalsIgnoreCase("i"))
            {
              a(this.d, n.class, new StyleSpan(2));
              return;
            }
            if (paramString2.equalsIgnoreCase("big"))
            {
              a(this.d, h.class, new RelativeSizeSpan(1.25F));
              return;
            }
            if (paramString2.equalsIgnoreCase("small"))
            {
              a(this.d, p.class, new RelativeSizeSpan(0.8F));
              return;
            }
            if (!paramString2.equalsIgnoreCase("font"))
              break;
            localSpannableStringBuilder2 = this.d;
            k = localSpannableStringBuilder2.length();
            localObject2 = a(localSpannableStringBuilder2, k.class);
            m = localSpannableStringBuilder2.getSpanStart(localObject2);
            localSpannableStringBuilder2.removeSpan(localObject2);
          }
          while (m == k);
          k localk = (k)localObject2;
          if (!TextUtils.isEmpty(localk.a))
          {
            if (!localk.a.startsWith("@"))
              break label504;
            Resources localResources = Resources.getSystem();
            int i1 = localResources.getIdentifier(localk.a.substring(1), "color", "android");
            if (i1 != 0)
              localSpannableStringBuilder2.setSpan(new TextAppearanceSpan(null, 0, 0, localResources.getColorStateList(i1), null), m, k, 33);
          }
          while (true)
          {
            if (localk.b != null)
              localSpannableStringBuilder2.setSpan(new TypefaceSpan(localk.b), m, k, 33);
            if (localk.c == null)
              break;
            localSpannableStringBuilder2.setSpan(new AbsoluteSizeSpan(Integer.parseInt(localk.c)), m, k, 33);
            return;
            int n = a(localk.a);
            if (n != -1)
              localSpannableStringBuilder2.setSpan(new ForegroundColorSpan(n | 0xFF000000), m, k, 33);
          }
          if (paramString2.equalsIgnoreCase("blockquote"))
          {
            a(this.d);
            a(this.d, i.class, new QuoteSpan());
            return;
          }
          if (paramString2.equalsIgnoreCase("tt"))
          {
            a(this.d, o.class, new TypefaceSpan("monospace"));
            return;
          }
          if (!paramString2.equalsIgnoreCase("a"))
            break;
          localSpannableStringBuilder1 = this.d;
          i = localSpannableStringBuilder1.length();
          localObject1 = a(localSpannableStringBuilder1, m.class);
          j = localSpannableStringBuilder1.getSpanStart(localObject1);
          localSpannableStringBuilder1.removeSpan(localObject1);
        }
        while (j == i);
        localm = (m)localObject1;
      }
      while (localm.a == null);
      localSpannableStringBuilder1.setSpan(new URLSpan(localm.a), j, i, 33);
      return;
      if (paramString2.equalsIgnoreCase("u"))
      {
        a(this.d, s.class, new UnderlineSpan());
        return;
      }
      if (paramString2.equalsIgnoreCase("sup"))
      {
        a(this.d, r.class, new SuperscriptSpan());
        return;
      }
      if (paramString2.equalsIgnoreCase("sub"))
      {
        a(this.d, q.class, new SubscriptSpan());
        return;
      }
      if ((paramString2.length() == 2) && (Character.toLowerCase(paramString2.charAt(0)) == 'h') && (paramString2.charAt(1) >= '1') && (paramString2.charAt(1) <= '6'))
      {
        a(this.d);
        b(this.d);
        return;
      }
    }
    while (this.f == null);
  }

  public final void endPrefixMapping(String paramString)
  {
  }

  public final void ignorableWhitespace(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
  }

  public final void processingInstruction(String paramString1, String paramString2)
  {
  }

  public final void setDocumentLocator(Locator paramLocator)
  {
  }

  public final void skippedEntity(String paramString)
  {
  }

  public final void startDocument()
  {
  }

  public final void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if (!paramString2.equalsIgnoreCase("br"))
    {
      if (!paramString2.equalsIgnoreCase("p"))
        break label26;
      a(this.d);
    }
    label26: 
    do
    {
      return;
      if (paramString2.equalsIgnoreCase("div"))
      {
        a(this.d);
        return;
      }
      if (paramString2.equalsIgnoreCase("em"))
      {
        a(this.d, new j((byte)0));
        return;
      }
      if (paramString2.equalsIgnoreCase("b"))
      {
        a(this.d, new j((byte)0));
        return;
      }
      if (paramString2.equalsIgnoreCase("strong"))
      {
        a(this.d, new n((byte)0));
        return;
      }
      if (paramString2.equalsIgnoreCase("cite"))
      {
        a(this.d, new n((byte)0));
        return;
      }
      if (paramString2.equalsIgnoreCase("dfn"))
      {
        a(this.d, new n((byte)0));
        return;
      }
      if (paramString2.equalsIgnoreCase("i"))
      {
        a(this.d, new n((byte)0));
        return;
      }
      if (paramString2.equalsIgnoreCase("big"))
      {
        a(this.d, new h((byte)0));
        return;
      }
      if (paramString2.equalsIgnoreCase("small"))
      {
        a(this.d, new p((byte)0));
        return;
      }
      if (paramString2.equalsIgnoreCase("font"))
      {
        SpannableStringBuilder localSpannableStringBuilder3 = this.d;
        String str3 = paramAttributes.getValue("", "color");
        String str4 = paramAttributes.getValue("", "face");
        String str5 = paramAttributes.getValue(paramAttributes.getIndex("size"));
        int k = localSpannableStringBuilder3.length();
        localSpannableStringBuilder3.setSpan(new k(str3, str4, str5), k, k, 17);
        return;
      }
      if (paramString2.equalsIgnoreCase("blockquote"))
      {
        a(this.d);
        a(this.d, new i((byte)0));
        return;
      }
      if (paramString2.equalsIgnoreCase("tt"))
      {
        a(this.d, new o((byte)0));
        return;
      }
      if (paramString2.equalsIgnoreCase("a"))
      {
        SpannableStringBuilder localSpannableStringBuilder2 = this.d;
        String str2 = paramAttributes.getValue("", "href");
        int j = localSpannableStringBuilder2.length();
        localSpannableStringBuilder2.setSpan(new m(str2), j, j, 17);
        return;
      }
      if (paramString2.equalsIgnoreCase("u"))
      {
        a(this.d, new s((byte)0));
        return;
      }
      if (paramString2.equalsIgnoreCase("sup"))
      {
        a(this.d, new r((byte)0));
        return;
      }
      if (paramString2.equalsIgnoreCase("sub"))
      {
        a(this.d, new q((byte)0));
        return;
      }
      if ((paramString2.length() == 2) && (Character.toLowerCase(paramString2.charAt(0)) == 'h') && (paramString2.charAt(1) >= '1') && (paramString2.charAt(1) <= '6'))
      {
        a(this.d);
        a(this.d, new l('ￏ' + paramString2.charAt(1)));
        return;
      }
      if (paramString2.equalsIgnoreCase("img"))
      {
        SpannableStringBuilder localSpannableStringBuilder1 = this.d;
        e locale = this.e;
        String str1 = paramAttributes.getValue("", "src");
        Drawable localDrawable = null;
        if (locale != null)
          localDrawable = locale.a();
        if (localDrawable == null)
        {
          localDrawable = Resources.getSystem().getDrawable(17301504);
          localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
        }
        int i = localSpannableStringBuilder1.length();
        localSpannableStringBuilder1.append("￼");
        localSpannableStringBuilder1.setSpan(new ImageSpan(localDrawable, str1), i, localSpannableStringBuilder1.length(), 33);
        return;
      }
    }
    while (this.f == null);
  }

  public final void startPrefixMapping(String paramString1, String paramString2)
  {
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     g
 * JD-Core Version:    0.6.2
 */