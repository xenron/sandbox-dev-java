package hjapp.com.hjclass_mobile.pkg_h.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

public final class g extends DefaultHandler
  implements i, XMLReader, LexicalHandler
{
  private static char[] M = { 60, 47, 62 };
  private static String O = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-'()+,./:=?;!*#@$_%";
  private static boolean i = true;
  private static boolean j = false;
  private static boolean k = false;
  private static boolean l = true;
  private static boolean m = true;
  private static boolean n = false;
  private static boolean o = true;
  private static boolean p = false;
  private static boolean q = true;
  private HashMap A = new HashMap();
  private c B;
  private String C;
  private boolean D;
  private String E;
  private String F;
  private String G;
  private String H;
  private c I;
  private c J;
  private c K;
  private int L;
  private boolean N;
  private char[] P;
  private ContentHandler a = this;
  private LexicalHandler b = this;
  private DTDHandler c = this;
  private ErrorHandler d = this;
  private EntityResolver e = this;
  private k f;
  private j g;
  private b h;
  private boolean r = i;
  private boolean s = j;
  private boolean t = k;
  private boolean u = l;
  private boolean v = m;
  private boolean w = n;
  private boolean x = o;
  private boolean y = p;
  private boolean z = q;

  public g()
  {
    this.A.put("http://xml.org/sax/features/namespaces", a(i));
    this.A.put("http://xml.org/sax/features/namespace-prefixes", Boolean.FALSE);
    this.A.put("http://xml.org/sax/features/external-general-entities", Boolean.FALSE);
    this.A.put("http://xml.org/sax/features/external-parameter-entities", Boolean.FALSE);
    this.A.put("http://xml.org/sax/features/is-standalone", Boolean.FALSE);
    this.A.put("http://xml.org/sax/features/lexical-handler/parameter-entities", Boolean.FALSE);
    this.A.put("http://xml.org/sax/features/resolve-dtd-uris", Boolean.TRUE);
    this.A.put("http://xml.org/sax/features/string-interning", Boolean.TRUE);
    this.A.put("http://xml.org/sax/features/use-attributes2", Boolean.FALSE);
    this.A.put("http://xml.org/sax/features/use-locator2", Boolean.FALSE);
    this.A.put("http://xml.org/sax/features/use-entity-resolver2", Boolean.FALSE);
    this.A.put("http://xml.org/sax/features/validation", Boolean.FALSE);
    this.A.put("http://xml.org/sax/features/xmlns-uris", Boolean.FALSE);
    this.A.put("http://xml.org/sax/features/xmlns-uris", Boolean.FALSE);
    this.A.put("http://xml.org/sax/features/xml-1.1", Boolean.FALSE);
    this.A.put("http://www.ccil.org/~cowan/tagsoup/features/ignore-bogons", a(j));
    this.A.put("http://www.ccil.org/~cowan/tagsoup/features/bogons-empty", a(k));
    this.A.put("http://www.ccil.org/~cowan/tagsoup/features/root-bogons", a(l));
    this.A.put("http://www.ccil.org/~cowan/tagsoup/features/default-attributes", a(m));
    this.A.put("http://www.ccil.org/~cowan/tagsoup/features/translate-colons", a(n));
    this.A.put("http://www.ccil.org/~cowan/tagsoup/features/restart-elements", a(o));
    this.A.put("http://www.ccil.org/~cowan/tagsoup/features/ignorable-whitespace", a(p));
    this.A.put("http://www.ccil.org/~cowan/tagsoup/features/cdata-elements", a(q));
    this.B = null;
    this.C = null;
    this.D = false;
    this.E = null;
    this.F = null;
    this.G = null;
    this.H = null;
    this.I = null;
    this.J = null;
    this.K = null;
    this.L = 0;
    this.N = true;
    this.P = new char[2000];
  }

  private int a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0)
      return 0;
    if ((paramArrayOfChar[paramInt1] != '#') || ((paramInt2 > 1) && ((paramArrayOfChar[(paramInt1 + 1)] == 'x') || (paramArrayOfChar[(paramInt1 + 1)] == 'X'))));
    try
    {
      int i2 = Integer.parseInt(new String(paramArrayOfChar, paramInt1 + 2, paramInt2 - 2), 16);
      return i2;
      try
      {
        int i1 = Integer.parseInt(new String(paramArrayOfChar, paramInt1 + 1, paramInt2 - 1), 10);
        return i1;
        return this.f.b(new String(paramArrayOfChar, paramInt1, paramInt2));
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        return 0;
      }
    }
    catch (NumberFormatException localNumberFormatException2)
    {
    }
    return 0;
  }

  private Reader a(InputSource paramInputSource)
  {
    Reader localReader = paramInputSource.getCharacterStream();
    InputStream localInputStream = paramInputSource.getByteStream();
    String str1 = paramInputSource.getEncoding();
    paramInputSource.getPublicId();
    String str2 = paramInputSource.getSystemId();
    if (localReader == null)
    {
      if (localInputStream == null)
        localInputStream = new URL(new URL("file", "", System.getProperty("user.dir") + "/."), str2).openConnection().getInputStream();
      if (str1 == null)
        localReader = this.h.a(localInputStream);
    }
    else
    {
      return localReader;
    }
    try
    {
      InputStreamReader localInputStreamReader = new InputStreamReader(localInputStream, str1);
      return localInputStreamReader;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return new InputStreamReader(localInputStream);
  }

  private static Boolean a(boolean paramBoolean)
  {
    if (paramBoolean)
      return Boolean.TRUE;
    return Boolean.FALSE;
  }

  private String a(String paramString)
  {
    int i1 = paramString.length();
    char[] arrayOfChar = new char[i1];
    int i2 = 0;
    int i3 = 0;
    int i4 = -1;
    int i5;
    int i6;
    if (i2 < i1)
    {
      char c1 = paramString.charAt(i2);
      i5 = i3 + 1;
      arrayOfChar[i3] = c1;
      if ((c1 == '&') && (i4 == -1))
        i4 = i5;
      while ((i4 == -1) || (Character.isLetter(c1)) || (Character.isDigit(c1)) || (c1 == '#'))
      {
        i2++;
        i3 = i5;
        break;
      }
      if (c1 == ';')
      {
        i6 = a(arrayOfChar, i4, -1 + (i5 - i4));
        if (i6 > 65535)
        {
          int i7 = i6 - 65536;
          arrayOfChar[(i4 - 1)] = ((char)(55296 + (i7 >> 10)));
          arrayOfChar[i4] = ((char)(56320 + (i7 & 0x3FF)));
          i4++;
        }
      }
    }
    while (true)
    {
      i5 = i4;
      i4 = -1;
      break;
      if (i6 != 0)
      {
        arrayOfChar[(i4 - 1)] = ((char)i6);
        continue;
        i4 = -1;
        break;
        return new String(arrayOfChar, 0, i3);
      }
      i4 = i5;
    }
  }

  private void a(c paramc)
  {
    while ((this.J != null) && (this.I.b(this.J)) && ((paramc == null) || (this.J.b(paramc))))
    {
      c localc = this.J.b();
      b(this.J);
      this.J = localc;
    }
  }

  private boolean a(String paramString1, String paramString2)
  {
    return (!paramString1.equals("")) && (!paramString2.equals("")) && (!paramString2.equals(this.f.b()));
  }

  private static String b(String paramString)
  {
    int i1 = paramString.indexOf(':');
    String str = "";
    if (i1 != -1)
      str = paramString.substring(0, i1);
    return str;
  }

  private String b(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 + 2);
    int i1 = 1;
    int i2 = 0;
    int i3 = paramInt2 - 1;
    char c1;
    int i5;
    int i6;
    if (paramInt2 > 0)
    {
      c1 = paramArrayOfChar[paramInt1];
      if ((Character.isLetter(c1)) || (c1 == '_'))
      {
        localStringBuffer.append(c1);
        i5 = 0;
        i6 = i2;
      }
    }
    while (true)
    {
      paramInt1++;
      i2 = i6;
      paramInt2 = i3;
      i1 = i5;
      break;
      if ((Character.isDigit(c1)) || (c1 == '-') || (c1 == '.'))
      {
        if (i1 != 0)
          localStringBuffer.append('_');
        localStringBuffer.append(c1);
        i6 = i2;
        i5 = 0;
      }
      else if ((c1 == ':') && (i2 == 0))
      {
        if (i1 != 0)
          localStringBuffer.append('_');
        if (this.w)
          c1 = '_';
        localStringBuffer.append(c1);
        i5 = 1;
        i6 = 1;
        continue;
        int i4 = localStringBuffer.length();
        if ((i4 == 0) || (localStringBuffer.charAt(i4 - 1) == ':'))
          localStringBuffer.append('_');
        return localStringBuffer.toString().intern();
      }
      else
      {
        i5 = i1;
        i6 = i2;
      }
    }
  }

  private void b(c paramc)
  {
    String str1 = paramc.c();
    Object localObject = paramc.e();
    String str2 = paramc.d();
    String str3 = b(str1);
    paramc.j();
    if (!this.r)
    {
      str2 = "";
      localObject = str2;
    }
    if ((this.N) && (((String)localObject).equalsIgnoreCase(this.G)));
    try
    {
      this.e.resolveEntity(this.E, this.F);
      label77: if (a(str3, str2))
        this.a.startPrefixMapping(str3, str2);
      a locala = paramc.a();
      int i1 = locala.getLength();
      for (int i2 = 0; i2 < i1; i2++)
      {
        String str4 = locala.getURI(i2);
        String str5 = b(locala.getQName(i2));
        if (a(str5, str4))
          this.a.startPrefixMapping(str5, str4);
      }
      this.a.startElement(str2, (String)localObject, str1, paramc.a());
      paramc.a(this.I);
      this.I = paramc;
      this.N = false;
      if ((this.z) && ((0x2 & this.I.g()) != 0))
        this.g.a();
      return;
    }
    catch (IOException localIOException)
    {
      break label77;
    }
  }

  private static String c(String paramString)
  {
    if (paramString == null);
    int i1;
    int i2;
    do
    {
      do
      {
        return paramString;
        i1 = paramString.length();
      }
      while (i1 == 0);
      i2 = paramString.charAt(0);
    }
    while ((i2 != paramString.charAt(i1 - 1)) || ((i2 != 39) && (i2 != 34)));
    return paramString.substring(1, -1 + paramString.length());
  }

  private void c(c paramc)
  {
    c localc1;
    while (true)
    {
      for (localc1 = this.I; (localc1 != null) && (!localc1.b(paramc)); localc1 = localc1.b());
      if (localc1 != null)
        break;
      d locald = paramc.h();
      if (locald == null)
        break;
      c localc3 = new c(locald, this.v);
      localc3.a(paramc);
      paramc = localc3;
    }
    if (localc1 == null)
      return;
    while ((this.I != localc1) && (this.I != null) && (this.I.b() != null) && (this.I.b().b() != null))
      e();
    while (paramc != null)
    {
      c localc2 = paramc.b();
      if (!paramc.c().equals("<pcdata>"))
        b(paramc);
      a(localc2);
      paramc = localc2;
    }
    this.B = null;
  }

  private void d()
  {
    if (this.I == null)
      return;
    String str1 = this.I.c();
    Object localObject = this.I.e();
    String str2 = this.I.d();
    String str3 = b(str1);
    if (!this.r)
    {
      str2 = "";
      localObject = str2;
    }
    this.a.endElement(str2, (String)localObject, str1);
    if (a(str3, str2))
      this.a.endPrefixMapping(str3);
    a locala = this.I.a();
    for (int i1 = -1 + locala.getLength(); i1 >= 0; i1--)
    {
      String str4 = locala.getURI(i1);
      String str5 = b(locala.getQName(i1));
      if (a(str5, str4))
        this.a.endPrefixMapping(str5);
    }
    this.I = this.I.b();
  }

  private static String[] d(String paramString)
  {
    String str = paramString.trim();
    if (str.length() == 0)
      return new String[0];
    ArrayList localArrayList = new ArrayList();
    int i1 = str.length();
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    if (i5 < i1)
    {
      char c1 = str.charAt(i5);
      if ((i3 == 0) && (c1 == '\'') && (i2 != 92))
        if (i4 == 0)
        {
          i4 = 1;
          label86: if (i6 < 0)
            i6 = i5;
        }
      while (true)
      {
        i5++;
        i2 = c1;
        break;
        i4 = 0;
        break label86;
        if ((i4 == 0) && (c1 == '"') && (i2 != 92))
        {
          if (i3 == 0);
          for (i3 = 1; ; i3 = 0)
          {
            if (i6 >= 0)
              break label154;
            i6 = i5;
            break;
          }
        }
        else
        {
          label154: if ((i4 == 0) && (i3 == 0))
            if (Character.isWhitespace(c1))
            {
              if (i6 >= 0)
                localArrayList.add(str.substring(i6, i5));
              i6 = -1;
            }
            else if ((i6 < 0) && (c1 != ' '))
            {
              i6 = i5;
            }
        }
      }
    }
    localArrayList.add(str.substring(i6, i5));
    return (String[])localArrayList.toArray(new String[0]);
  }

  private static String e(String paramString)
  {
    if (paramString == null)
      return null;
    int i1 = paramString.length();
    StringBuffer localStringBuffer = new StringBuffer(i1);
    int i2 = 0;
    int i3 = 1;
    if (i2 < i1)
    {
      char c1 = paramString.charAt(i2);
      if (O.indexOf(c1) != -1)
      {
        localStringBuffer.append(c1);
        i3 = 0;
      }
      while (true)
      {
        i2++;
        break;
        if (i3 == 0)
        {
          localStringBuffer.append(' ');
          i3 = 1;
        }
      }
    }
    return localStringBuffer.toString().trim();
  }

  private void e()
  {
    c localc = this.I;
    d();
    if ((this.x) && ((0x1 & localc.g()) != 0))
    {
      localc.i();
      localc.a(this.J);
      this.J = localc;
    }
  }

  private void m(char[] paramArrayOfChar, int paramInt)
  {
    this.B = null;
    d locald;
    if (paramInt != 0)
    {
      String str2 = b(paramArrayOfChar, 0, paramInt);
      locald = this.f.a(str2);
      if (locald != null);
    }
    int i1;
    c localc2;
    do
    {
      return;
      for (String str1 = locald.a(); ; str1 = this.I.c())
      {
        c localc1 = this.I;
        i1 = 0;
        for (localc2 = localc1; (localc2 != null) && (!localc2.c().equals(str1)); localc2 = localc2.b())
          if ((0x4 & localc2.g()) != 0)
            i1 = 1;
      }
    }
    while ((localc2 == null) || (localc2.b() == null) || (localc2.b().b() == null));
    if (i1 != 0)
      localc2.k();
    while (true)
    {
      if (!this.I.l())
      {
        a(null);
        return;
        while (this.I != localc2)
          e();
      }
      d();
    }
  }

  public final void a()
  {
    if ((this.B == null) || (this.C == null))
      return;
    this.B.a(this.C, this.C);
    this.C = null;
  }

  public final void a(char[] paramArrayOfChar, int paramInt)
  {
    if (this.B == null)
      return;
    this.C = b(paramArrayOfChar, 0, paramInt).toLowerCase();
  }

  public final void b()
  {
    if (this.N)
      c(this.K);
    while (this.I.b() != null)
      d();
    if (!this.f.b().equals(""))
      this.a.endPrefixMapping(this.f.c());
    this.a.endDocument();
  }

  public final void b(char[] paramArrayOfChar, int paramInt)
  {
    if ((this.B == null) || (this.C == null))
      return;
    String str = a(new String(paramArrayOfChar, 0, paramInt));
    this.B.a(this.C, str);
    this.C = null;
  }

  public final int c()
  {
    return this.L;
  }

  public final void c(char[] paramArrayOfChar, int paramInt)
  {
    this.L = a(paramArrayOfChar, 1, paramInt);
  }

  public final void comment(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
  }

  public final void d(char[] paramArrayOfChar, int paramInt)
  {
    int i1 = 1;
    String str = this.I.c();
    int i2;
    int i3;
    if ((this.z) && ((0x2 & this.I.g()) != 0))
      if (paramInt == str.length())
      {
        i2 = i1;
        if (i2 != 0)
        {
          i3 = 0;
          label50: if (i3 < paramInt)
          {
            if (Character.toLowerCase(paramArrayOfChar[(i3 + 0)]) == Character.toLowerCase(str.charAt(i3)))
              break label146;
            i2 = 0;
          }
        }
        if (i2 != 0)
          break label152;
        this.a.characters(M, 0, 2);
        this.a.characters(paramArrayOfChar, 0, paramInt);
        this.a.characters(M, 2, i1);
        this.g.a();
      }
    while (true)
    {
      if (i1 == 0)
        break label157;
      return;
      i2 = 0;
      break;
      label146: i3++;
      break label50;
      label152: i1 = 0;
    }
    label157: m(paramArrayOfChar, paramInt);
  }

  public final void e(char[] paramArrayOfChar, int paramInt)
  {
    String str1 = null;
    String[] arrayOfString = d(new String(paramArrayOfChar, 0, paramInt));
    String str2;
    String str3;
    if ((arrayOfString.length > 0) && ("DOCTYPE".equals(arrayOfString[0])))
    {
      if (this.D)
        return;
      this.D = true;
      if (arrayOfString.length > 1)
      {
        str2 = arrayOfString[1];
        if ((arrayOfString.length > 3) && ("SYSTEM".equals(arrayOfString[2])))
          str3 = arrayOfString[3];
      }
    }
    while (true)
    {
      String str4 = c(str1);
      String str5 = c(str3);
      if (str2 == null)
        break;
      String str6 = e(str4);
      this.b.startDTD(str2, str6, str5);
      this.b.endDTD();
      this.G = str2;
      this.E = str6;
      if (!(this.g instanceof Locator))
        break;
      this.F = ((Locator)this.g).getSystemId();
      try
      {
        this.F = new URL(new URL(this.F), str5).toString();
        return;
      }
      catch (Exception localException)
      {
        return;
      }
      if ((arrayOfString.length > 3) && ("PUBLIC".equals(arrayOfString[2])))
      {
        str1 = arrayOfString[3];
        if (arrayOfString.length > 4)
          str3 = arrayOfString[4];
        else
          str3 = "";
      }
      else
      {
        str1 = null;
        str3 = null;
        continue;
        str1 = null;
        str2 = null;
        str3 = null;
      }
    }
  }

  public final void endCDATA()
  {
  }

  public final void endDTD()
  {
  }

  public final void endEntity(String paramString)
  {
  }

  public final void f(char[] paramArrayOfChar, int paramInt)
  {
    int i1 = -1;
    if (this.B != null);
    String str;
    d locald;
    do
    {
      do
      {
        return;
        str = b(paramArrayOfChar, 0, paramInt);
      }
      while (str == null);
      locald = this.f.a(str);
      if (locald != null)
        break;
    }
    while (this.s);
    int i2;
    if (this.t)
    {
      i2 = 0;
      if (!this.u)
        break label138;
    }
    while (true)
    {
      this.f.a(str, i2, i1, 0);
      if (!this.u)
        this.f.a(str, this.f.a().a());
      locald = this.f.a(str);
      this.B = new c(locald, this.v);
      return;
      i2 = i1;
      break;
      label138: i1 = 2147483647;
    }
  }

  public final void g(char[] paramArrayOfChar, int paramInt)
  {
    if (paramInt == 0);
    do
    {
      return;
      int i1 = 1;
      for (int i2 = 0; i2 < paramInt; i2++)
        if (!Character.isWhitespace(paramArrayOfChar[(i2 + 0)]))
          i1 = 0;
      if ((i1 == 0) || (this.I.b(this.K)))
        break;
    }
    while (!this.y);
    this.a.ignorableWhitespace(paramArrayOfChar, 0, paramInt);
    return;
    c(this.K);
    this.a.characters(paramArrayOfChar, 0, paramInt);
  }

  public final ContentHandler getContentHandler()
  {
    if (this.a == this)
      return null;
    return this.a;
  }

  public final DTDHandler getDTDHandler()
  {
    if (this.c == this)
      return null;
    return this.c;
  }

  public final EntityResolver getEntityResolver()
  {
    if (this.e == this)
      return null;
    return this.e;
  }

  public final ErrorHandler getErrorHandler()
  {
    if (this.d == this)
      return null;
    return this.d;
  }

  public final boolean getFeature(String paramString)
  {
    Boolean localBoolean = (Boolean)this.A.get(paramString);
    if (localBoolean == null)
      throw new SAXNotRecognizedException("Unknown feature " + paramString);
    return localBoolean.booleanValue();
  }

  public final Object getProperty(String paramString)
  {
    if (paramString.equals("http://xml.org/sax/properties/lexical-handler"))
    {
      if (this.b == this)
        return null;
      return this.b;
    }
    if (paramString.equals("http://www.ccil.org/~cowan/tagsoup/properties/scanner"))
      return this.g;
    if (paramString.equals("http://www.ccil.org/~cowan/tagsoup/properties/schema"))
      return this.f;
    if (paramString.equals("http://www.ccil.org/~cowan/tagsoup/properties/auto-detector"))
      return this.h;
    throw new SAXNotRecognizedException("Unknown property " + paramString);
  }

  public final void h(char[] paramArrayOfChar, int paramInt)
  {
    if (this.B != null)
      return;
    this.H = b(paramArrayOfChar, 0, paramInt).replace(':', '_');
  }

  public final void i(char[] paramArrayOfChar, int paramInt)
  {
    if ((this.B != null) || (this.H == null));
    while ("xml".equalsIgnoreCase(this.H))
      return;
    if ((paramInt > 0) && (paramArrayOfChar[(paramInt - 1)] == '?'))
      paramInt--;
    this.a.processingInstruction(this.H, new String(paramArrayOfChar, 0, paramInt));
    this.H = null;
  }

  public final void j(char[] paramArrayOfChar, int paramInt)
  {
    if (this.B == null);
    do
    {
      return;
      c(this.B);
    }
    while (this.I.f() != 0);
    m(paramArrayOfChar, paramInt);
  }

  public final void k(char[] paramArrayOfChar, int paramInt)
  {
    if (this.B == null)
      return;
    c(this.B);
    m(paramArrayOfChar, paramInt);
  }

  public final void l(char[] paramArrayOfChar, int paramInt)
  {
    this.b.comment(paramArrayOfChar, 0, paramInt);
  }

  public final void parse(String paramString)
  {
    parse(new InputSource(paramString));
  }

  public final void parse(InputSource paramInputSource)
  {
    if (this.f == null)
      this.f = new f();
    if (this.g == null)
      this.g = new e();
    if (this.h == null)
      this.h = new h(this);
    this.I = new c(this.f.a("<root>"), this.v);
    this.K = new c(this.f.a("<pcdata>"), this.v);
    this.B = null;
    this.C = null;
    this.H = null;
    this.J = null;
    this.L = 0;
    this.N = true;
    this.F = null;
    this.E = null;
    this.G = null;
    Reader localReader = a(paramInputSource);
    this.a.startDocument();
    this.g.a(paramInputSource.getPublicId(), paramInputSource.getSystemId());
    if ((this.g instanceof Locator))
      this.a.setDocumentLocator((Locator)this.g);
    if (!this.f.b().equals(""))
      this.a.startPrefixMapping(this.f.c(), this.f.b());
    this.g.a(localReader, this);
  }

  public final void setContentHandler(ContentHandler paramContentHandler)
  {
    if (paramContentHandler == null)
      paramContentHandler = this;
    this.a = paramContentHandler;
  }

  public final void setDTDHandler(DTDHandler paramDTDHandler)
  {
    if (paramDTDHandler == null)
      paramDTDHandler = this;
    this.c = paramDTDHandler;
  }

  public final void setEntityResolver(EntityResolver paramEntityResolver)
  {
    if (paramEntityResolver == null)
      paramEntityResolver = this;
    this.e = paramEntityResolver;
  }

  public final void setErrorHandler(ErrorHandler paramErrorHandler)
  {
    if (paramErrorHandler == null)
      paramErrorHandler = this;
    this.d = paramErrorHandler;
  }

  public final void setFeature(String paramString, boolean paramBoolean)
  {
    if ((Boolean)this.A.get(paramString) == null)
      throw new SAXNotRecognizedException("Unknown feature " + paramString);
    if (paramBoolean)
    {
      this.A.put(paramString, Boolean.TRUE);
      if (!paramString.equals("http://xml.org/sax/features/namespaces"))
        break label85;
      this.r = paramBoolean;
    }
    label85: 
    do
    {
      return;
      this.A.put(paramString, Boolean.FALSE);
      break;
      if (paramString.equals("http://www.ccil.org/~cowan/tagsoup/features/ignore-bogons"))
      {
        this.s = paramBoolean;
        return;
      }
      if (paramString.equals("http://www.ccil.org/~cowan/tagsoup/features/bogons-empty"))
      {
        this.t = paramBoolean;
        return;
      }
      if (paramString.equals("http://www.ccil.org/~cowan/tagsoup/features/root-bogons"))
      {
        this.u = paramBoolean;
        return;
      }
      if (paramString.equals("http://www.ccil.org/~cowan/tagsoup/features/default-attributes"))
      {
        this.v = paramBoolean;
        return;
      }
      if (paramString.equals("http://www.ccil.org/~cowan/tagsoup/features/translate-colons"))
      {
        this.w = paramBoolean;
        return;
      }
      if (paramString.equals("http://www.ccil.org/~cowan/tagsoup/features/restart-elements"))
      {
        this.x = paramBoolean;
        return;
      }
      if (paramString.equals("http://www.ccil.org/~cowan/tagsoup/features/ignorable-whitespace"))
      {
        this.y = paramBoolean;
        return;
      }
    }
    while (!paramString.equals("http://www.ccil.org/~cowan/tagsoup/features/cdata-elements"));
    this.z = paramBoolean;
  }

  public final void setProperty(String paramString, Object paramObject)
  {
    if (paramString.equals("http://xml.org/sax/properties/lexical-handler"))
    {
      if (paramObject == null)
      {
        this.b = this;
        return;
      }
      if ((paramObject instanceof LexicalHandler))
      {
        this.b = ((LexicalHandler)paramObject);
        return;
      }
      throw new SAXNotSupportedException("Your lexical handler is not a LexicalHandler");
    }
    if (paramString.equals("http://www.ccil.org/~cowan/tagsoup/properties/scanner"))
    {
      if ((paramObject instanceof j))
      {
        this.g = ((j)paramObject);
        return;
      }
      throw new SAXNotSupportedException("Your scanner is not a Scanner");
    }
    if (paramString.equals("http://www.ccil.org/~cowan/tagsoup/properties/schema"))
    {
      if ((paramObject instanceof k))
      {
        this.f = ((k)paramObject);
        return;
      }
      throw new SAXNotSupportedException("Your schema is not a Schema");
    }
    if (paramString.equals("http://www.ccil.org/~cowan/tagsoup/properties/auto-detector"))
    {
      if ((paramObject instanceof b))
      {
        this.h = ((b)paramObject);
        return;
      }
      throw new SAXNotSupportedException("Your auto-detector is not an AutoDetector");
    }
    throw new SAXNotRecognizedException("Unknown property " + paramString);
  }

  public final void startCDATA()
  {
  }

  public final void startDTD(String paramString1, String paramString2, String paramString3)
  {
  }

  public final void startEntity(String paramString)
  {
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     a   0.6.2
 */