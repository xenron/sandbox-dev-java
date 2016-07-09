package hjapp.com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.json.JSONArray;
import org.json.JSONObject;

class a
  implements Thread.UncaughtExceptionHandler
{
  private static final String c = "com_umeng__crash.cache";
  private Thread.UncaughtExceptionHandler a;
  private Context b;

  private void a(Throwable paramThrowable)
  {
    if (paramThrowable == null)
    {
      hjapp.com.umeng.common.a.d("MobclickAgent", "Exception is null in handleException");
      return;
    }
    a(this.b, paramThrowable);
  }

  public void a(Context paramContext)
  {
    if (Thread.getDefaultUncaughtExceptionHandler() == this)
    {
      hjapp.com.umeng.common.a.a("MobclickAgent", "can't call onError more than once!");
      return;
    }
    this.b = paramContext;
    this.a = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
  }

  void a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
      return;
    try
    {
      String str1 = hjapp.com.umeng.common.b.b.a();
      String str2 = str1.split(" ")[0];
      String str3 = str1.split(" ")[1];
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("date", str2);
      localJSONObject.put("time", str3);
      localJSONObject.put("context", paramString);
      localJSONObject.put("type", "error");
      localJSONObject.put("version", hjapp.com.umeng.common.b.a(paramContext));
      JSONArray localJSONArray = b(paramContext);
      if (localJSONArray == null)
        localJSONArray = new JSONArray();
      localJSONArray.put(localJSONObject);
      FileOutputStream localFileOutputStream = paramContext.openFileOutput("com_umeng__crash.cache", 0);
      localFileOutputStream.write(localJSONArray.toString().getBytes());
      localFileOutputStream.flush();
      localFileOutputStream.close();
      return;
    }
    catch (Exception localException)
    {
      hjapp.com.umeng.common.a.b("MobclickAgent", "an error occured while writing report file...", localException);
      localException.printStackTrace();
    }
  }

  void a(Context paramContext, Throwable paramThrowable)
  {
    if ((paramContext == null) || (paramThrowable == null))
      return;
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    paramThrowable.printStackTrace(localPrintWriter);
    for (Throwable localThrowable = paramThrowable.getCause(); localThrowable != null; localThrowable = localThrowable.getCause())
      localThrowable.printStackTrace(localPrintWriter);
    String str = localStringWriter.toString();
    localPrintWriter.close();
    a(paramContext, str);
  }

  JSONArray b(Context paramContext)
  {
    Object localObject = null;
    if (paramContext == null);
    File localFile;
    FileInputStream localFileInputStream;
    StringBuffer localStringBuffer;
    while (true)
    {
      return null;
      localFile = new File(paramContext.getFilesDir(), "com_umeng__crash.cache");
      try
      {
        if (localFile.exists())
        {
          localFileInputStream = paramContext.openFileInput("com_umeng__crash.cache");
          localStringBuffer = new StringBuffer();
          byte[] arrayOfByte = new byte[1024];
          while (true)
          {
            int i = localFileInputStream.read(arrayOfByte);
            if (i == -1)
              break;
            localStringBuffer.append(new String(arrayOfByte, 0, i));
          }
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    }
    try
    {
      localFile.delete();
      return localObject;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
      return localObject;
    }
    localFileInputStream.close();
    if (localStringBuffer.length() != 0);
    for (JSONArray localJSONArray = new JSONArray(localStringBuffer.toString()); ; localJSONArray = null)
    {
      localObject = localJSONArray;
      break;
    }
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    a(paramThrowable);
    if (this.a != null)
      this.a.uncaughtException(paramThread, paramThrowable);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     a
 * JD-Core Version:    0.6.2
 */