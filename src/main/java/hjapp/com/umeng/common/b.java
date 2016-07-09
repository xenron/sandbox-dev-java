package hjapp.com.umeng.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.microedition.khronos.opengles.GL10;

public class b
{
  protected static final String a = b.class.getName();

  public static String a()
  {
    String str1 = null;
    try
    {
      FileReader localFileReader = new FileReader("/proc/cpuinfo");
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(localFileReader, 1024);
        str1 = localBufferedReader.readLine();
        localBufferedReader.close();
        localFileReader.close();
        str2 = str1;
        if (str2 != null)
          str2 = str2.substring(1 + str2.indexOf(':'));
        return str2.trim();
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          Log.e(a, "Could not read from file /proc/cpuinfo", localIOException);
          str2 = str1;
        }
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      while (true)
      {
        Log.e(a, "Could not open file /proc/cpuinfo", localFileNotFoundException);
        String str2 = str1;
      }
    }
  }

  public static String a(Context paramContext)
  {
    try
    {
      String str = String.valueOf(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode);
      return str;
    }
    catch (NameNotFoundException localNameNotFoundException)
    {
    }
    return "Unknown";
  }

  public static String a(Date paramDate)
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(paramDate);
  }

  private static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0;
  }

  public static String[] a(GL10 paramGL10)
  {
    try
    {
      String[] arrayOfString = new String[2];
      String str1 = paramGL10.glGetString(7936);
      String str2 = paramGL10.glGetString(7937);
      arrayOfString[0] = str1;
      arrayOfString[1] = str2;
      return arrayOfString;
    }
    catch (Exception localException)
    {
      Log.e(a, "Could not read gpu infor:", localException);
    }
    return new String[0];
  }

  public static String b(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return str;
    }
    catch (NameNotFoundException localNameNotFoundException)
    {
    }
    return "Unknown";
  }

  public static boolean b()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }

  public static String c()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yyyy-MM-dd").format(localDate);
  }

  public static String c(Context paramContext)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (localTelephonyManager == null)
      Log.w(a, "No IMEI.");
    try
    {
      if (a(paramContext, "android.permission.READ_PHONE_STATE"))
      {
        String str2 = localTelephonyManager.getDeviceId();
        str1 = str2;
        if (TextUtils.isEmpty(str1))
        {
          Log.w(a, "No IMEI.");
          str1 = l(paramContext);
          if (TextUtils.isEmpty(str1))
          {
            Log.w(a, "Failed to take mac as IMEI. Try to use Secure.ANDROID_ID instead.");
            str1 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
            Log.w(a, "getDeviceId: Secure.ANDROID_ID: " + str1);
          }
        }
        return str1;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.w(a, "No IMEI.", localException);
        String str1 = "";
      }
    }
  }

  public static String d(Context paramContext)
  {
    return b.b.b(c(paramContext));
  }

  public static String[] e(Context paramContext)
  {
    String[] arrayOfString = { "Unknown", "Unknown" };
    if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) != 0)
    {
      arrayOfString[0] = "Unknown";
      return arrayOfString;
    }
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localConnectivityManager == null)
    {
      arrayOfString[0] = "Unknown";
      return arrayOfString;
    }
    if (localConnectivityManager.getNetworkInfo(1).getState() == State.CONNECTED)
    {
      arrayOfString[0] = "Wi-Fi";
      return arrayOfString;
    }
    NetworkInfo localNetworkInfo = localConnectivityManager.getNetworkInfo(0);
    if (localNetworkInfo.getState() == State.CONNECTED)
    {
      arrayOfString[0] = "2G/3G";
      arrayOfString[1] = localNetworkInfo.getSubtypeName();
      return arrayOfString;
    }
    return arrayOfString;
  }

  public static boolean f(Context paramContext)
  {
    return "Wi-Fi".equals(e(paramContext)[0]);
  }

  public static Location g(Context paramContext)
  {
    try
    {
      LocationManager localLocationManager = (LocationManager)paramContext.getSystemService("location");
      if (a(paramContext, "android.permission.ACCESS_FINE_LOCATION"))
      {
        Location localLocation2 = localLocationManager.getLastKnownLocation("gps");
        if (localLocation2 != null)
        {
          Log.i(a, "get location from gps:" + localLocation2.getLatitude() + "," + localLocation2.getLongitude());
          return localLocation2;
        }
      }
      if (a(paramContext, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        Location localLocation1 = localLocationManager.getLastKnownLocation("network");
        if (localLocation1 != null)
        {
          Log.i(a, "get location from network:" + localLocation1.getLatitude() + "," + localLocation1.getLongitude());
          return localLocation1;
        }
      }
    }
    catch (Exception localException)
    {
      Log.e(a, localException.getMessage());
      return null;
    }
    Log.i(a, "Could not get location from GPS or Cell-id, lack ACCESS_COARSE_LOCATION or ACCESS_COARSE_LOCATION permission?");
    return null;
  }

  public static boolean h(Context paramContext)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        boolean bool = localNetworkInfo.isConnectedOrConnecting();
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
    }
    return true;
  }

  public static int i(Context paramContext)
  {
    try
    {
      Locale localLocale = Locale.getDefault();
      Configuration localConfiguration = new Configuration();
      Settings.System.getConfiguration(paramContext.getContentResolver(), localConfiguration);
      if (localConfiguration.locale != null)
        localLocale = localConfiguration.locale;
      Calendar localCalendar = Calendar.getInstance(localLocale);
      if (localCalendar != null)
      {
        int i = localCalendar.getTimeZone().getRawOffset() / 3600000;
        return i;
      }
    }
    catch (Exception localException)
    {
      Log.i(a, "error in getTimeZone", localException);
    }
    return 8;
  }

  public static String[] j(Context paramContext)
  {
    String[] arrayOfString = { "Unknown", "Unknown" };
    try
    {
      Configuration localConfiguration = new Configuration();
      Settings.System.getConfiguration(paramContext.getContentResolver(), localConfiguration);
      if (localConfiguration.locale != null)
      {
        arrayOfString[0] = localConfiguration.locale.getCountry();
        arrayOfString[1] = localConfiguration.locale.toString();
      }
      while (true)
      {
        if (TextUtils.isEmpty(arrayOfString[0]))
          arrayOfString[0] = "Unknown";
        if (!TextUtils.isEmpty(arrayOfString[1]))
          break;
        arrayOfString[1] = "Unknown";
        return arrayOfString;
        Locale localLocale = Locale.getDefault();
        if (localLocale != null)
        {
          arrayOfString[0] = localLocale.getCountry();
          arrayOfString[1] = localLocale.getLanguage();
        }
      }
    }
    catch (Exception localException)
    {
      Log.e(a, "error in getLocaleInfo", localException);
    }
    return arrayOfString;
  }

  public static String k(Context paramContext)
  {
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (localApplicationInfo != null)
      {
        String str = localApplicationInfo.metaData.getString("UMENG_APPKEY");
        if (str != null)
          return str.trim();
        Log.e(a, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
      }
      return null;
    }
    catch (Exception localException)
    {
      while (true)
        Log.e(a, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", localException);
    }
  }

  public static String l(Context paramContext)
  {
    try
    {
      WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
      if (a(paramContext, "android.permission.ACCESS_WIFI_STATE"))
        return localWifiManager.getConnectionInfo().getMacAddress();
      Log.w(a, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
      return "";
    }
    catch (Exception localException)
    {
      while (true)
        Log.w(a, "Could not get mac address." + localException.toString());
    }
  }

  public static String m(Context paramContext)
  {
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i = localDisplayMetrics.widthPixels;
      int j = localDisplayMetrics.heightPixels;
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(i);
      localStringBuffer.append("*");
      localStringBuffer.append(j);
      String str = localStringBuffer.toString();
      return str;
    }
    catch (Exception localException)
    {
      Log.e(a, "read resolution fail", localException);
    }
    return "Unknown";
  }

  public static String n(Context paramContext)
  {
    try
    {
      String str = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperatorName();
      return str;
    }
    catch (Exception localException)
    {
      Log.i(a, "read carrier fail", localException);
    }
    return "Unknown";
  }

  public static String o(Context paramContext)
  {
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if ((localApplicationInfo != null) && (localApplicationInfo.metaData != null))
      {
        Object localObject = localApplicationInfo.metaData.get("UMENG_CHANNEL");
        if (localObject != null)
        {
          String str = localObject.toString();
          if (str != null)
            return str;
          Log.i(a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
        }
      }
      return "Unknown";
    }
    catch (Exception localException)
    {
      Log.i(a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
      localException.printStackTrace();
    }
    return "Unknown";
  }

  public static String p(Context paramContext)
  {
    return paramContext.getPackageName();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     b
 * JD-Core Version:    0.6.2
 */