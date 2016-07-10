package hjapp.com.hjclass_mobile.pkg_b;

import android.os.AsyncTask;
import hjapp.com.hjclass_mobile.pkg_c.ae;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class aa extends AsyncTask
{
  private ae a = null;
  private File b = null;
  private File c = null;

  public aa(ae paramae)
  {
    if (this.b.exists())
      this.b.delete();
    this.c = new File(hjapp.com.hjclass_mobile.pkg_h.z.d + "hjclass_mobile.tmp");
    if (this.c.exists())
      this.c.delete();
    this.a = paramae;
  }

  private File a(String paramString)
  {
    try
    {
      localHttpURLConnection2 = (HttpURLConnection)new URL(paramString).openConnection();
      Object localObject1;
      try
      {
        localHttpURLConnection2.setRequestProperty("User-Agent", "PacificHttpClient");
        localHttpURLConnection2.setConnectTimeout(10000);
        localHttpURLConnection2.setReadTimeout(20000);
        i = localHttpURLConnection2.getContentLength();
        if (localHttpURLConnection2.getResponseCode() != 404)
          break label113;
        throw new Exception("fail!");
      }
      finally
      {
        localObject4 = null;
        localObject5 = null;
        localHttpURLConnection1 = localHttpURLConnection2;
        localObject1 = localObject6;
      }
      if (localHttpURLConnection1 != null)
        localHttpURLConnection1.disconnect();
      if (localObject5 != null)
        localObject5.close();
      if (localObject4 != null)
        localObject4.close();
      throw localObject1;
      label113: localInputStream = localHttpURLConnection2.getInputStream();
    }
    finally
    {
      try
      {
        localFileOutputStream = new FileOutputStream(this.c, false);
      }
      finally
      {
        while (true)
          try
          {
            int i;
            byte[] arrayOfByte = new byte[4096];
            long l = 0L;
            int j = 0;
            int k = localInputStream.read(arrayOfByte);
            if (k > 0)
            {
              localFileOutputStream.write(arrayOfByte, 0, k);
              l += k;
              if ((j == 0) || (-10 + (int)(100L * l / i) > j))
              {
                j += 10;
                Integer[] arrayOfInteger = new Integer[1];
                arrayOfInteger[0] = Integer.valueOf(100 * (int)l / i);
                publishProgress(arrayOfInteger);
              }
            }
            else
            {
              this.c.renameTo(this.b);
              if (localHttpURLConnection2 != null)
                localHttpURLConnection2.disconnect();
              if (localInputStream != null)
                localInputStream.close();
              localFileOutputStream.close();
              return this.b;
              localObject2 = finally;
              localObject4 = null;
              localObject5 = null;
              localHttpURLConnection1 = null;
              continue;
              localObject8 = finally;
              localHttpURLConnection1 = localHttpURLConnection2;
              localObject3 = localObject8;
              localObject5 = localInputStream;
              localObject4 = null;
            }
          }
          finally
          {
            HttpURLConnection localHttpURLConnection2;
            InputStream localInputStream;
            FileOutputStream localFileOutputStream;
            Object localObject5 = localInputStream;
            HttpURLConnection localHttpURLConnection1 = localHttpURLConnection2;
            Object localObject3 = localObject7;
            Object localObject4 = localFileOutputStream;
          }
      }
    }
  }

  private File a(String[] paramArrayOfString)
  {
    try
    {
      File localFile = a(paramArrayOfString[0]);
      return localFile;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  protected final void onPreExecute()
  {
    if (this.a != null)
      this.a.a();
    super.onPreExecute();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     aa
 * JD-Core Version:    0.6.2
 */