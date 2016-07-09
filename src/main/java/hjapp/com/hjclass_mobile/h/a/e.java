package hjapp.com.hjclass_mobile.h.a;

import java.io.BufferedReader;
import java.io.PushbackReader;
import java.io.Reader;
import org.xml.sax.Locator;

public final class e
  implements j, Locator
{
  private static int[] f = { 1, 47, 5, 22, 1, 61, 4, 3, 1, 62, 6, 28, 1, 0, 27, 1, 1, -1, 6, 21, 1, 32, 4, 24, 1, 10, 4, 24, 1, 9, 4, 24, 2, 39, 7, 34, 2, 0, 27, 2, 2, -1, 8, 21, 2, 32, 29, 2, 2, 10, 29, 2, 2, 9, 29, 2, 3, 39, 28, 2, 3, 34, 28, 31, 3, 62, 8, 28, 3, 0, 27, 32, 3, -1, 8, 21, 3, 32, 28, 3, 3, 10, 28, 3, 3, 9, 28, 3, 4, 67, 28, 5, 4, 0, 28, 19, 4, -1, 28, 21, 5, 68, 28, 6, 5, 0, 28, 19, 5, -1, 28, 21, 6, 65, 28, 7, 6, 0, 28, 19, 6, -1, 28, 21, 7, 84, 28, 8, 7, 0, 28, 19, 7, -1, 28, 21, 8, 65, 28, 9, 8, 0, 28, 19, 8, -1, 28, 21, 9, 91, 28, 12, 9, 0, 28, 19, 9, -1, 28, 21, 10, 60, 27, 11, 10, 0, 27, 10, 10, -1, 23, 21, 11, 47, 32, 25, 11, 0, 27, 10, 11, -1, 32, 21, 12, 93, 27, 13, 12, 0, 27, 12, 12, -1, 28, 21, 13, 93, 27, 14, 13, 0, 27, 12, 13, -1, 28, 21, 14, 62, 9, 28, 14, 0, 27, 12, 14, -1, 28, 21, 15, 45, 28, 16, 15, 0, 27, 16, 15, -1, 10, 21, 16, 45, 28, 17, 16, 0, 27, 16, 16, -1, 10, 21, 17, 45, 28, 18, 17, 0, 20, 16, 17, -1, 10, 21, 18, 45, 22, 18, 18, 62, 10, 28, 18, 0, 21, 16, 18, -1, 10, 21, 19, 45, 28, 15, 19, 91, 28, 4, 19, 62, 28, 28, 19, 0, 27, 20, 19, -1, 28, 21, 20, 62, 11, 28, 20, 0, 27, 20, 20, -1, 28, 21, 22, 62, 12, 28, 22, 0, 27, 1, 22, 32, 28, 34, 22, 10, 28, 34, 22, 9, 28, 34, 23, 0, 13, 23, 23, -1, 13, 21, 24, 61, 28, 3, 24, 62, 3, 28, 24, 0, 2, 1, 24, -1, 3, 21, 24, 32, 28, 24, 24, 10, 28, 24, 24, 9, 28, 24, 25, 62, 15, 28, 25, 0, 27, 25, 25, -1, 15, 21, 25, 32, 28, 25, 25, 10, 28, 25, 25, 9, 28, 25, 26, 47, 28, 22, 26, 62, 17, 28, 26, 0, 27, 26, 26, -1, 28, 21, 26, 32, 16, 34, 26, 10, 16, 34, 26, 9, 16, 34, 27, 0, 13, 27, 27, -1, 13, 21, 28, 38, 14, 23, 28, 60, 23, 33, 28, 0, 27, 28, 28, -1, 23, 21, 29, 62, 24, 28, 29, 0, 27, 29, 29, -1, 24, 21, 30, 62, 26, 28, 30, 0, 27, 30, 30, -1, 26, 21, 30, 32, 25, 29, 30, 10, 25, 29, 30, 9, 25, 29, 31, 34, 7, 34, 31, 0, 27, 31, 31, -1, 8, 21, 31, 32, 29, 31, 31, 10, 29, 31, 31, 9, 29, 31, 32, 62, 8, 28, 32, 0, 27, 32, 32, -1, 8, 21, 32, 32, 7, 34, 32, 10, 7, 34, 32, 9, 7, 34, 33, 33, 28, 19, 33, 63, 28, 30, 33, 47, 28, 25, 33, 60, 27, 33, 33, 0, 27, 26, 33, -1, 19, 21, 33, 32, 18, 28, 33, 10, 18, 28, 33, 9, 18, 28, 34, 47, 28, 22, 34, 62, 30, 28, 34, 0, 27, 1, 34, -1, 30, 21, 34, 32, 28, 34, 34, 10, 28, 34, 34, 9, 28, 34, 35, 0, 13, 35, 35, -1, 13, 21 };
  private static final String[] g = { "", "A_ADUP", "A_ADUP_SAVE", "A_ADUP_STAGC", "A_ANAME", "A_ANAME_ADUP", "A_ANAME_ADUP_STAGC", "A_AVAL", "A_AVAL_STAGC", "A_CDATA", "A_CMNT", "A_DECL", "A_EMPTYTAG", "A_ENTITY", "A_ENTITY_START", "A_ETAG", "A_GI", "A_GI_STAGC", "A_LT", "A_LT_PCDATA", "A_MINUS", "A_MINUS2", "A_MINUS3", "A_PCDATA", "A_PI", "A_PITARGET", "A_PITARGET_PI", "A_SAVE", "A_SKIP", "A_SP", "A_STAGC", "A_UNGET", "A_UNSAVE_PCDATA" };
  private static final String[] h = { "", "S_ANAME", "S_APOS", "S_AVAL", "S_BB", "S_BBC", "S_BBCD", "S_BBCDA", "S_BBCDAT", "S_BBCDATA", "S_CDATA", "S_CDATA2", "S_CDSECT", "S_CDSECT1", "S_CDSECT2", "S_COM", "S_COM2", "S_COM3", "S_COM4", "S_DECL", "S_DECL2", "S_DONE", "S_EMPTYTAG", "S_ENT", "S_EQ", "S_ETAG", "S_GI", "S_NCR", "S_PCDATA", "S_PI", "S_PITARGET", "S_QUOT", "S_STAGC", "S_TAG", "S_TAGWS", "S_XNCR" };
  int a;
  int b;
  char[] c = new char['È'];
  int d;
  int[] e = { 8364, 65533, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 65533, 381, 65533, 65533, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 65533, 382, 376 };
  private String i;
  private String j;
  private int k;
  private int l;
  private int m;
  private int n;

  private void a(int paramInt, i parami)
  {
    if (this.d >= -20 + this.c.length)
    {
      if ((this.a != 28) && (this.a != 10))
        break label78;
      parami.g(this.c, this.d);
      this.d = 0;
    }
    while (true)
    {
      char[] arrayOfChar1 = this.c;
      int i1 = this.d;
      this.d = (i1 + 1);
      arrayOfChar1[i1] = ((char)paramInt);
      return;
      label78: char[] arrayOfChar2 = new char[2 * this.c.length];
      System.arraycopy(this.c, 0, arrayOfChar2, 0, 1 + this.d);
      this.c = arrayOfChar2;
    }
  }

  private static void a(PushbackReader paramPushbackReader, int paramInt)
  {
    if (paramInt != -1)
      paramPushbackReader.unread(paramInt);
  }

  private void b()
  {
    this.l = this.n;
    this.k = this.m;
  }

  public final void a()
  {
    this.b = 10;
  }

  public final void a(Reader paramReader, i parami)
  {
    this.a = 28;
    PushbackReader localPushbackReader;
    label18: label37: int i2;
    if ((paramReader instanceof PushbackReader))
    {
      localPushbackReader = (PushbackReader)paramReader;
      int i1 = localPushbackReader.read();
      if (i1 != 65279)
        a(localPushbackReader, i1);
      if (this.a == 21)
        break label1718;
      i2 = localPushbackReader.read();
      if ((i2 >= 128) && (i2 <= 159))
        i2 = this.e[(i2 - 128)];
      if (i2 != 13)
        break label1730;
      i2 = localPushbackReader.read();
      if (i2 == 10)
        break label1730;
      a(localPushbackReader, i2);
    }
    label133: label419: label1191: label1718: label1730: for (int i3 = 10; ; i3 = i2)
    {
      int i4;
      int i5;
      if (i3 == 10)
      {
        this.m = (1 + this.m);
        this.n = 0;
        if ((i3 < 32) && (i3 != 10) && (i3 != 9) && (i3 != -1))
          break label37;
        i4 = 0;
        i5 = 0;
        if (i4 < f.length)
        {
          if (this.a == f[i4])
            break label419;
          if (i5 == 0)
            break label452;
        }
      }
      while (true)
        switch (i5)
        {
        default:
          throw new Error("Can't process state " + i5);
          if ((paramReader instanceof BufferedReader))
          {
            localPushbackReader = new PushbackReader(paramReader);
            break label18;
          }
          localPushbackReader = new PushbackReader(new BufferedReader(paramReader, 200));
          break label18;
          this.n = (1 + this.n);
          break label133;
          if (f[(i4 + 1)] == 0)
          {
            i5 = f[(i4 + 2)];
            this.b = f[(i4 + 3)];
          }
          label452: 
          while (f[(i4 + 1)] != i3)
          {
            i4 += 4;
            break;
          }
          i5 = f[(i4 + 2)];
          this.b = f[(i4 + 3)];
        case 0:
        case 1:
        case 28:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 14:
        case 13:
        case 15:
        case 11:
        case 16:
        case 17:
        case 18:
        case 19:
        case 23:
        case 10:
        case 22:
        case 21:
        case 20:
        case 24:
        case 25:
        case 26:
        case 27:
        case 29:
        case 30:
        case 12:
        case 31:
        case 32:
        }
      throw new Error("HTMLScanner can't cope with " + Integer.toString(i3) + " in state " + Integer.toString(this.a));
      parami.a();
      this.d = 0;
      while (true)
      {
        this.a = this.b;
        break;
        parami.a();
        this.d = 0;
        a(i3, parami);
        continue;
        parami.a();
        this.d = 0;
        parami.j(this.c, this.d);
        continue;
        parami.a(this.c, this.d);
        this.d = 0;
        continue;
        parami.a(this.c, this.d);
        this.d = 0;
        parami.a();
        continue;
        parami.a(this.c, this.d);
        this.d = 0;
        parami.a();
        parami.j(this.c, this.d);
        continue;
        parami.b(this.c, this.d);
        this.d = 0;
        continue;
        parami.b(this.c, this.d);
        this.d = 0;
        parami.j(this.c, this.d);
        continue;
        b();
        if (this.d > 1)
          this.d = (-2 + this.d);
        parami.g(this.c, this.d);
        this.d = 0;
        continue;
        parami.g(this.c, this.d);
        this.d = 0;
        a(i3, parami);
        continue;
        b();
        char c1 = (char)i3;
        if ((this.a == 23) && (c1 == '#'))
        {
          this.b = 27;
          a(i3, parami);
        }
        else if ((this.a == 27) && ((c1 == 'x') || (c1 == 'X')))
        {
          this.b = 35;
          a(i3, parami);
        }
        else if ((this.a == 23) && (Character.isLetterOrDigit(c1)))
        {
          a(i3, parami);
        }
        else if ((this.a == 27) && (Character.isDigit(c1)))
        {
          a(i3, parami);
        }
        else if ((this.a == 35) && ((Character.isDigit(c1)) || ("abcdefABCDEF".indexOf(c1) != -1)))
        {
          a(i3, parami);
        }
        else
        {
          parami.c(this.c, -1 + this.d);
          int i6 = parami.c();
          if (i6 != 0)
          {
            this.d = 0;
            if ((i6 >= 128) && (i6 <= 159))
              i6 = this.e[(i6 - 128)];
            if ((i6 >= 32) && ((i6 < 55296) || (i6 > 57343)))
            {
              if (i6 > 65535)
                break label1191;
              a(i6, parami);
            }
          }
          while (true)
          {
            if (i3 != 59)
            {
              a(localPushbackReader, i3);
              this.n = (-1 + this.n);
            }
            this.b = 28;
            break;
            int i7 = i6 - 65536;
            a(55296 + (i7 >> 10), parami);
            a(56320 + (i7 & 0x3FF), parami);
          }
          parami.d(this.c, this.d);
          this.d = 0;
          continue;
          parami.e(this.c, this.d);
          this.d = 0;
          continue;
          parami.f(this.c, this.d);
          this.d = 0;
          continue;
          parami.f(this.c, this.d);
          this.d = 0;
          parami.j(this.c, this.d);
          continue;
          b();
          a(60, parami);
          a(i3, parami);
          continue;
          b();
          a(60, parami);
          parami.g(this.c, this.d);
          this.d = 0;
          continue;
          b();
          parami.g(this.c, this.d);
          this.d = 0;
          continue;
          b();
          parami.l(this.c, this.d);
          this.d = 0;
          continue;
          a(45, parami);
          a(32, parami);
          continue;
          a(45, parami);
          a(32, parami);
          a(45, parami);
          a(i3, parami);
          continue;
          b();
          parami.i(this.c, this.d);
          this.d = 0;
          continue;
          parami.h(this.c, this.d);
          this.d = 0;
          continue;
          parami.h(this.c, this.d);
          this.d = 0;
          parami.i(this.c, this.d);
          continue;
          a(i3, parami);
          continue;
          a(32, parami);
          continue;
          parami.j(this.c, this.d);
          this.d = 0;
          continue;
          b();
          if (this.d > 0)
            parami.f(this.c, this.d);
          this.d = 0;
          parami.k(this.c, this.d);
          continue;
          a(localPushbackReader, i3);
          this.n = (-1 + this.n);
          continue;
          if (this.d > 0)
            this.d = (-1 + this.d);
          parami.g(this.c, this.d);
          this.d = 0;
        }
      }
      parami.b();
      return;
    }
  }

  public final void a(String paramString1, String paramString2)
  {
    this.i = paramString1;
    this.j = paramString2;
    this.n = 0;
    this.m = 0;
    this.l = 0;
    this.k = 0;
  }

  public final int getColumnNumber()
  {
    return this.l;
  }

  public final int getLineNumber()
  {
    return this.k;
  }

  public final String getPublicId()
  {
    return this.i;
  }

  public final String getSystemId()
  {
    return this.j;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     a   0.6.2
 */