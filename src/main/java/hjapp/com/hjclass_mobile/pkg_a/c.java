package hjapp.com.hjclass_mobile.pkg_a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Handler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  Context a = null;
  private ProgressDialog b = null;
  private Handler c = new g(this);

  public c(Context paramContext)
  {
    this.a = paramContext;
  }

  private JSONObject a(String paramString)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("action", "update");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("platform", "android");
      localJSONObject2.put("version", paramString);
      localJSONObject2.put("partner", "");
      localJSONObject1.put("data", localJSONObject2);
      JSONObject localJSONObject3 = b(localJSONObject1.toString());
      return localJSONObject3;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }

  private static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    InputStream localInputStream;
    FileOutputStream localFileOutputStream;
    try
    {
      localInputStream = paramContext.getAssets().open(paramString1);
      File localFile = new File(paramString2);
      localFile.createNewFile();
      localFileOutputStream = new FileOutputStream(localFile);
      byte[] arrayOfByte = new byte[1024];
      while (true)
      {
        int i = localInputStream.read(arrayOfByte);
        if (i <= 0)
          break;
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return false;
    }
    localFileOutputStream.close();
    localInputStream.close();
    return true;
  }

  private JSONObject b(String paramString)
  {
    try
    {
      synchronized (new l(this.a))
      {
        String str = ???.a(paramString, "https://msp.alipay.com/x.htm");
        localJSONObject = new JSONObject(str);
        if (localJSONObject != null)
          localJSONObject.toString();
        return localJSONObject;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        JSONObject localJSONObject = null;
      }
    }
  }

  public final String a(PackageInfo paramPackageInfo)
  {
    try
    {
      JSONObject localJSONObject = a(paramPackageInfo.versionName);
      boolean bool = localJSONObject.getString("needUpdate").equalsIgnoreCase("true");
      Object localObject = null;
      if (bool)
      {
        String str = localJSONObject.getString("updateUrl");
        localObject = str;
      }
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  public final boolean a()
  {
    List localList = this.a.getPackageManager().getInstalledPackages(0);
    for (int i = 0; ; i++)
    {
      int j = localList.size();
      boolean bool = false;
      if (i < j)
      {
        if (((PackageInfo)localList.get(i)).packageName.equalsIgnoreCase("com.alipay.android.app"))
          bool = true;
      }
      else
      {
        if (!bool)
        {
          File localFile = this.a.getCacheDir();
          String str = localFile.getAbsolutePath() + "/temp_21.apk";
          a(this.a, "alipay_plugin230_0728.apk", str);
          this.b = b.a(this.a, "正在检测安全支付服务版本");
          new Thread(new d(this, str)).start();
        }
        return bool;
      }
    }
  }

  public final boolean a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = new l(this.a).b(paramString1, paramString2);
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }

  final void b()
  {
    try
    {
      if (this.b != null)
      {
        this.b.dismiss();
        this.b = null;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     c
 * JD-Core Version:    0.6.2
 */