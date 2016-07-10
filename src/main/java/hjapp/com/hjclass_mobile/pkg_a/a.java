package hjapp.com.hjclass_mobile.pkg_a;

public final class a
{
  private static final byte[] a;
  private static final char[] b;

  static
  {
    int i = 0;
    a = new byte[''];
    b = new char[64];
    for (int j = 0; j < 128; j++)
      a[j] = -1;
    for (int k = 90; k >= 65; k--)
      a[k] = ((byte)(k - 65));
    for (int m = 122; m >= 97; m--)
      a[m] = ((byte)(26 + (m - 97)));
    for (int n = 57; n >= 48; n--)
      a[n] = ((byte)(52 + (n - 48)));
    a[43] = 62;
    a[47] = 63;
    for (int i1 = 0; i1 <= 25; i1++)
      b[i1] = ((char)(i1 + 65));
    int i2 = 26;
    for (int i3 = 0; i2 <= 51; i3++)
    {
      b[i2] = ((char)(i3 + 97));
      i2++;
    }
    int i4 = 52;
    while (i4 <= 61)
    {
      b[i4] = ((char)(i + 48));
      i4++;
      i++;
    }
    b[62] = '+';
    b[63] = '/';
  }

  public static String a(byte[] paramArrayOfByte)
  {
    int i = 0;
    if (paramArrayOfByte == null)
      return null;
    int j = 8 * paramArrayOfByte.length;
    if (j == 0)
      return "";
    int k = j % 24;
    int m = j / 24;
    int n;
    char[] arrayOfChar;
    int i1;
    int i2;
    label56: int i19;
    int i21;
    int i22;
    int i23;
    int i24;
    int i25;
    int i26;
    label127: int i27;
    if (k != 0)
    {
      n = m + 1;
      arrayOfChar = new char[n * 4];
      i1 = 0;
      i2 = 0;
      if (i1 >= m)
        break label302;
      int i18 = i + 1;
      i19 = paramArrayOfByte[i];
      int i20 = i18 + 1;
      i21 = paramArrayOfByte[i18];
      i22 = i20 + 1;
      i23 = paramArrayOfByte[i20];
      i24 = (byte)(i21 & 0xF);
      i25 = (byte)(i19 & 0x3);
      if ((i19 & 0xFFFFFF80) != 0)
        break label259;
      i26 = (byte)(i19 >> 2);
      if ((i21 & 0xFFFFFF80) != 0)
        break label273;
      i27 = (byte)(i21 >> 4);
      label142: if ((i23 & 0xFFFFFF80) != 0)
        break label287;
    }
    label259: label273: label287: for (int i28 = (byte)(i23 >> 6); ; i28 = (byte)(0xFC ^ i23 >> 6))
    {
      int i29 = i2 + 1;
      arrayOfChar[i2] = b[i26];
      int i30 = i29 + 1;
      arrayOfChar[i29] = b[(i27 | i25 << 4)];
      int i31 = i30 + 1;
      arrayOfChar[i30] = b[(i28 | i24 << 2)];
      int i32 = i31 + 1;
      arrayOfChar[i31] = b[(i23 & 0x3F)];
      i1++;
      i2 = i32;
      i = i22;
      break label56;
      n = m;
      break;
      i26 = (byte)(0xC0 ^ i19 >> 2);
      break label127;
      i27 = (byte)(0xF0 ^ i21 >> 4);
      break label142;
    }
    label302: if (k == 8)
    {
      i12 = paramArrayOfByte[i];
      i13 = (byte)(i12 & 0x3);
      if ((i12 & 0xFFFFFF80) == 0)
      {
        i14 = (byte)(i12 >> 2);
        i15 = i2 + 1;
        arrayOfChar[i2] = b[i14];
        i16 = i15 + 1;
        arrayOfChar[i15] = b[(i13 << 4)];
        i17 = i16 + 1;
        arrayOfChar[i16] = '=';
        arrayOfChar[i17] = '=';
      }
    }
    while (k != 16)
      while (true)
      {
        int i12;
        int i13;
        int i15;
        int i16;
        int i17;
        return new String(arrayOfChar);
        int i14 = (byte)(0xC0 ^ i12 >> 2);
      }
    int i3 = paramArrayOfByte[i];
    int i4 = paramArrayOfByte[(i + 1)];
    int i5 = (byte)(i4 & 0xF);
    int i6 = (byte)(i3 & 0x3);
    int i7;
    if ((i3 & 0xFFFFFF80) == 0)
    {
      i7 = (byte)(i3 >> 2);
      label463: if ((i4 & 0xFFFFFF80) != 0)
        break label560;
    }
    label560: for (int i8 = (byte)(i4 >> 4); ; i8 = (byte)(0xF0 ^ i4 >> 4))
    {
      int i9 = i2 + 1;
      arrayOfChar[i2] = b[i7];
      int i10 = i9 + 1;
      arrayOfChar[i9] = b[(i8 | i6 << 4)];
      int i11 = i10 + 1;
      arrayOfChar[i10] = b[(i5 << 2)];
      arrayOfChar[i11] = '=';
      break;
      i7 = (byte)(0xC0 ^ i3 >> 2);
      break label463;
    }
  }

  private static boolean a(char paramChar)
  {
    return paramChar == '=';
  }

  public static byte[] a(String paramString)
  {
    if (paramString == null)
      return null;
    char[] arrayOfChar = paramString.toCharArray();
    int k;
    int j;
    label35: int n;
    label76: int i1;
    if (arrayOfChar == null)
    {
      k = 0;
      if (k % 4 != 0)
        return null;
    }
    else
    {
      int i = arrayOfChar.length;
      j = 0;
      k = 0;
      if (j < i)
      {
        int m = arrayOfChar[j];
        if ((m != 32) && (m != 13) && (m != 10) && (m != 9))
          break label104;
        n = 1;
        if (n != 0)
          break label682;
        i1 = k + 1;
        arrayOfChar[k] = arrayOfChar[j];
      }
    }
    while (true)
    {
      j++;
      k = i1;
      break label35;
      break;
      label104: n = 0;
      break label76;
      int i2 = k / 4;
      if (i2 == 0)
        return new byte[0];
      byte[] arrayOfByte1 = new byte[i2 * 3];
      int i3 = 0;
      int i4 = 0;
      for (int i5 = 0; i5 < i2 - 1; i5++)
      {
        int i17 = i3 + 1;
        char c5 = arrayOfChar[i3];
        char c6;
        char c7;
        char c8;
        if (b(c5))
        {
          int i18 = i17 + 1;
          c6 = arrayOfChar[i17];
          if (b(c6))
          {
            int i19 = i18 + 1;
            c7 = arrayOfChar[i18];
            if (b(c7))
            {
              i3 = i19 + 1;
              c8 = arrayOfChar[i19];
              if (b(c8))
                break label233;
            }
          }
        }
        return null;
        label233: int i20 = a[c5];
        int i21 = a[c6];
        int i22 = a[c7];
        int i23 = a[c8];
        int i24 = i4 + 1;
        arrayOfByte1[i4] = ((byte)(i20 << 2 | i21 >> 4));
        int i25 = i24 + 1;
        arrayOfByte1[i24] = ((byte)((i21 & 0xF) << 4 | 0xF & i22 >> 2));
        i4 = i25 + 1;
        arrayOfByte1[i25] = ((byte)(i23 | i22 << 6));
      }
      int i6 = i3 + 1;
      char c1 = arrayOfChar[i3];
      int i7;
      char c2;
      if (b(c1))
      {
        i7 = i6 + 1;
        c2 = arrayOfChar[i6];
        if (b(c2));
      }
      else
      {
        return null;
      }
      int i8 = a[c1];
      int i9 = a[c2];
      int i10 = i7 + 1;
      char c3 = arrayOfChar[i7];
      char c4 = arrayOfChar[i10];
      if ((!b(c3)) || (!b(c4)))
      {
        if ((a(c3)) && (a(c4)))
        {
          if ((i9 & 0xF) != 0)
            return null;
          byte[] arrayOfByte3 = new byte[1 + i5 * 3];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 0, i5 * 3);
          arrayOfByte3[i4] = ((byte)(i8 << 2 | i9 >> 4));
          return arrayOfByte3;
        }
        if ((!a(c3)) && (a(c4)))
        {
          int i11 = a[c3];
          if ((i11 & 0x3) != 0)
            return null;
          byte[] arrayOfByte2 = new byte[2 + i5 * 3];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i5 * 3);
          int i12 = i4 + 1;
          arrayOfByte2[i4] = ((byte)(i8 << 2 | i9 >> 4));
          arrayOfByte2[i12] = ((byte)((i9 & 0xF) << 4 | 0xF & i11 >> 2));
          return arrayOfByte2;
        }
        return null;
      }
      int i13 = a[c3];
      int i14 = a[c4];
      int i15 = i4 + 1;
      arrayOfByte1[i4] = ((byte)(i8 << 2 | i9 >> 4));
      int i16 = i15 + 1;
      arrayOfByte1[i15] = ((byte)((i9 & 0xF) << 4 | 0xF & i13 >> 2));
      arrayOfByte1[i16] = ((byte)(i14 | i13 << 6));
      return arrayOfByte1;
      label682: i1 = k;
    }
  }

  private static boolean b(char paramChar)
  {
    return (paramChar < '') && (a[paramChar] != -1);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     a
 * JD-Core Version:    0.6.2
 */