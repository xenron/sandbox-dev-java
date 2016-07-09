package hjapp.com.hjclass_mobile.h.a;

import org.xml.sax.Attributes;

public final class a
  implements Attributes
{
  int a;
  String[] b;

  public a()
  {
    this.a = 0;
    this.b = null;
  }

  public a(Attributes paramAttributes)
  {
    a(paramAttributes);
  }

  private void a(Attributes paramAttributes)
  {
    int i = 0;
    if (this.b != null)
      for (int j = 0; j < 5 * this.a; j++)
        this.b[j] = null;
    this.a = 0;
    this.a = paramAttributes.getLength();
    if (this.a > 0)
    {
      this.b = new String[5 * this.a];
      while (i < this.a)
      {
        this.b[(i * 5)] = paramAttributes.getURI(i);
        this.b[(1 + i * 5)] = paramAttributes.getLocalName(i);
        this.b[(2 + i * 5)] = paramAttributes.getQName(i);
        this.b[(3 + i * 5)] = paramAttributes.getType(i);
        this.b[(4 + i * 5)] = paramAttributes.getValue(i);
        i++;
      }
    }
  }

  private static void b(int paramInt)
  {
    throw new ArrayIndexOutOfBoundsException("Attempt to modify attribute at illegal index: " + paramInt);
  }

  public final void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a))
    {
      if (paramInt < -1 + this.a)
        System.arraycopy(this.b, 5 * (paramInt + 1), this.b, paramInt * 5, 5 * (-1 + (this.a - paramInt)));
      int i = 5 * (-1 + this.a);
      String[] arrayOfString1 = this.b;
      int j = i + 1;
      arrayOfString1[i] = null;
      String[] arrayOfString2 = this.b;
      int k = j + 1;
      arrayOfString2[j] = null;
      String[] arrayOfString3 = this.b;
      int m = k + 1;
      arrayOfString3[k] = null;
      String[] arrayOfString4 = this.b;
      int n = m + 1;
      arrayOfString4[m] = null;
      this.b[n] = null;
      this.a = (-1 + this.a);
      return;
    }
    b(paramInt);
  }

  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((paramInt >= 0) && (paramInt < this.a))
    {
      this.b[(paramInt * 5)] = paramString1;
      this.b[(1 + paramInt * 5)] = paramString2;
      this.b[(2 + paramInt * 5)] = paramString3;
      this.b[(3 + paramInt * 5)] = paramString4;
      this.b[(4 + paramInt * 5)] = paramString5;
      return;
    }
    b(paramInt);
  }

  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    int i = 1 + this.a;
    if (i > 0)
    {
      int j;
      if ((this.b == null) || (this.b.length == 0))
        j = 25;
      while (j < i * 5)
      {
        j *= 2;
        continue;
        if (this.b.length >= i * 5)
          break label109;
        j = this.b.length;
      }
      String[] arrayOfString = new String[j];
      if (this.a > 0)
        System.arraycopy(this.b, 0, arrayOfString, 0, 5 * this.a);
      this.b = arrayOfString;
    }
    label109: this.b[(5 * this.a)] = paramString1;
    this.b[(1 + 5 * this.a)] = paramString2;
    this.b[(2 + 5 * this.a)] = paramString3;
    this.b[(3 + 5 * this.a)] = paramString4;
    this.b[(4 + 5 * this.a)] = paramString5;
    this.a = (1 + this.a);
  }

  public final int getIndex(String paramString)
  {
    int i = 5 * this.a;
    for (int j = 0; j < i; j += 5)
      if (this.b[(j + 2)].equals(paramString))
        return j / 5;
    return -1;
  }

  public final int getIndex(String paramString1, String paramString2)
  {
    int i = 5 * this.a;
    for (int j = 0; j < i; j += 5)
      if ((this.b[j].equals(paramString1)) && (this.b[(j + 1)].equals(paramString2)))
        return j / 5;
    return -1;
  }

  public final int getLength()
  {
    return this.a;
  }

  public final String getLocalName(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a))
      return this.b[(1 + paramInt * 5)];
    return null;
  }

  public final String getQName(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a))
      return this.b[(2 + paramInt * 5)];
    return null;
  }

  public final String getType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a))
      return this.b[(3 + paramInt * 5)];
    return null;
  }

  public final String getType(String paramString)
  {
    int i = 5 * this.a;
    for (int j = 0; j < i; j += 5)
      if (this.b[(j + 2)].equals(paramString))
        return this.b[(j + 3)];
    return null;
  }

  public final String getType(String paramString1, String paramString2)
  {
    int i = 5 * this.a;
    for (int j = 0; j < i; j += 5)
      if ((this.b[j].equals(paramString1)) && (this.b[(j + 1)].equals(paramString2)))
        return this.b[(j + 3)];
    return null;
  }

  public final String getURI(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a))
      return this.b[(paramInt * 5)];
    return null;
  }

  public final String getValue(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a))
      return this.b[(4 + paramInt * 5)];
    return null;
  }

  public final String getValue(String paramString)
  {
    int i = 5 * this.a;
    for (int j = 0; j < i; j += 5)
      if (this.b[(j + 2)].equals(paramString))
        return this.b[(j + 4)];
    return null;
  }

  public final String getValue(String paramString1, String paramString2)
  {
    int i = 5 * this.a;
    for (int j = 0; j < i; j += 5)
      if ((this.b[j].equals(paramString1)) && (this.b[(j + 1)].equals(paramString2)))
        return this.b[(j + 4)];
    return null;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     a   0.6.2
 */