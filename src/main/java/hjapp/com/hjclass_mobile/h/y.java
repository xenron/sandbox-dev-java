package hjapp.com.hjclass_mobile.h;

import android.content.Context;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

public final class y
{
  public static String a(Context paramContext)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (localTelephonyManager != null);
    for (String str = localTelephonyManager.getDeviceId(); ; str = null)
    {
      if ((str == null) || (str.startsWith("0")))
        str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return str;
    }
  }

  public static String a(String paramString, Object[] paramArrayOfObject)
  {
    if ((paramString == null) || ("".equals(paramString)))
      paramString = "";
    while (true)
    {
      return paramString;
      if (paramArrayOfObject.length != 0)
      {
        Matcher localMatcher = Pattern.compile("\\{(\\d+)\\}").matcher(paramString);
        while (localMatcher.find())
        {
          int i = Integer.parseInt(localMatcher.group(1));
          if (i < paramArrayOfObject.length)
            paramString = paramString.replace(localMatcher.group(), paramArrayOfObject[i].toString());
        }
      }
    }
  }

  public static byte[] a(String paramString)
  {
    try
    {
      byte[] arrayOfByte = new String(Base64.decode(paramString, 0), "ISO-8859-1").getBytes("ISO-8859-1");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }

  public static String b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return paramString;
    return paramString.trim();
  }

  public static boolean c(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }

  public static String d(String paramString)
  {
    while (true)
    {
      try
      {
        CRC32 localCRC32 = new CRC32();
        String str1 = new URL(paramString).getPath();
        Object localObject;
        if (str1 != null)
          if ("".equals(str1))
          {
            break label101;
            localCRC32.update(paramString.getBytes("UTF-8"));
            return Long.toHexString(localCRC32.getValue()) + "_" + (String)localObject;
          }
          else
          {
            String str2 = str1.substring(1 + str1.lastIndexOf("/"));
            localObject = str2;
            continue;
          }
      }
      catch (Exception localException)
      {
        return null;
      }
      label101: localObject = "index";
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     y
 * JD-Core Version:    0.6.2
 */