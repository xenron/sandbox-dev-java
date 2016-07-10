package hjapp.com.hjclass_mobile.pkg_h;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class a
{
  public static String a(Date paramDate, String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(paramString);
    try
    {
      String str = localSimpleDateFormat.format(paramDate);
      return str;
    }
    catch (Exception localException)
    {
      localException = localException;
      localException.printStackTrace();
      return null;
    }
    finally
    {
    }
  }

  public static Date a(String paramString1, String paramString2)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(paramString2);
    try
    {
      Date localDate = localSimpleDateFormat.parse(paramString1);
      return localDate;
    }
    catch (Exception localException)
    {
      localException = localException;
      localException.printStackTrace();
      return null;
    }
    finally
    {
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     a
 * JD-Core Version:    0.6.2
 */