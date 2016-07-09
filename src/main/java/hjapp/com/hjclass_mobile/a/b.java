package hjapp.com.hjclass_mobile.a;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import hjapp.com.hjclass_mobile.i;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

public final class b
{
  public static ProgressDialog a(Context paramContext, CharSequence paramCharSequence)
  {
    ProgressDialog localProgressDialog = new ProgressDialog(paramContext);
    localProgressDialog.setTitle(null);
    localProgressDialog.setMessage(paramCharSequence);
    localProgressDialog.setIndeterminate(false);
    localProgressDialog.setCancelable(false);
    localProgressDialog.setOnCancelListener(new i((Activity)paramContext));
    localProgressDialog.show();
    return localProgressDialog;
  }

  public static String a(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      while (true)
      {
        String str = localBufferedReader.readLine();
        if (str == null)
          break;
        localStringBuilder.append(str);
      }
    }
    catch (IOException localIOException2)
    {
      localIOException2 = localIOException2;
      localIOException2.printStackTrace();
      try
      {
        paramInputStream.close();
        while (true)
        {
          return localStringBuilder.toString();
          try
          {
            paramInputStream.close();
          }
          catch (IOException localIOException4)
          {
            localIOException4.printStackTrace();
          }
        }
      }
      catch (IOException localIOException3)
      {
        while (true)
          localIOException3.printStackTrace();
      }
    }
    finally
    {
    }
    try
    {
      paramInputStream.close();
      throw localObject;
    }
    catch (IOException localIOException1)
    {
      while (true)
        localIOException1.printStackTrace();
    }
  }

  public static JSONObject a(String paramString1, String paramString2)
  {
    int i = 0;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      String[] arrayOfString1 = paramString1.split(paramString2);
      while (i < arrayOfString1.length)
      {
        String[] arrayOfString2 = arrayOfString1[i].split("=");
        localJSONObject.put(arrayOfString2[0], arrayOfString1[i].substring(1 + arrayOfString2[0].length()));
        i++;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONObject;
  }

  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    localBuilder.setIcon(paramInt);
    localBuilder.setTitle(paramString1);
    localBuilder.setMessage(paramString2);
    localBuilder.setPositiveButton(2131493093, null);
    localBuilder.show();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     b
 * JD-Core Version:    0.6.2
 */