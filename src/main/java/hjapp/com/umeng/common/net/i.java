package hjapp.com.umeng.common.net;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONException;
import org.json.JSONObject;

public class i
{
  private static final String a = i.class.getName();
  private Map b;

  private static String a(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 8192);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      while (true)
      {
        String str = localBufferedReader.readLine();
        if (str == null)
          break;
        localStringBuilder.append(str + "\n");
      }
    }
    catch (IOException localIOException2)
    {
      hjapp.com.umeng.common.a.b(a, "Caught IOException in convertStreamToString()", localIOException2);
      try
      {
        paramInputStream.close();
        return null;
        try
        {
          paramInputStream.close();
          return localStringBuilder.toString();
        }
        catch (IOException localIOException4)
        {
          hjapp.com.umeng.common.a.b(a, "Caught IOException in convertStreamToString()", localIOException4);
          return null;
        }
      }
      catch (IOException localIOException3)
      {
        hjapp.com.umeng.common.a.b(a, "Caught IOException in convertStreamToString()", localIOException3);
        return null;
      }
    }
    finally
    {
      try
      {
        paramInputStream.close();
        throw localObject;
      }
      catch (IOException localIOException1)
      {
        hjapp.com.umeng.common.a.b(a, "Caught IOException in convertStreamToString()", localIOException1);
      }
    }
    return null;
  }

  private JSONObject a(String paramString)
  {
    int i = new Random().nextInt(1000);
    while (true)
    {
      try
      {
        String str1 = System.getProperty("line.separator");
        if (paramString.length() <= 1)
        {
          hjapp.com.umeng.common.a.b(a, i + ":\tInvalid baseUrl.");
          return null;
        }
        hjapp.com.umeng.common.a.a(a, i + ":\tget: " + paramString);
        HttpGet localHttpGet = new HttpGet(paramString);
        BasicHttpParams localBasicHttpParams;
        HttpResponse localHttpResponse;
        HttpEntity localHttpEntity;
        InputStream localInputStream;
        Header localHeader;
        Object localObject;
        String str2;
        if ((this.b != null) && (this.b.size() > 0))
        {
          Iterator localIterator = this.b.keySet().iterator();
          if (localIterator.hasNext())
          {
            String str3 = (String)localIterator.next();
            localHttpGet.addHeader(str3, (String)this.b.get(str3));
            continue;
          }
        }
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        hjapp.com.umeng.common.a.c(a, i + ":\tClientProtocolException,Failed to send message." + paramString, localClientProtocolException);
        return null;
        localBasicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
        localHttpResponse = new DefaultHttpClient(localBasicHttpParams).execute(localHttpGet);
        if (localHttpResponse.getStatusLine().getStatusCode() != 200)
          break label513;
        localHttpEntity = localHttpResponse.getEntity();
        if (localHttpEntity == null)
          break label563;
        localInputStream = localHttpEntity.getContent();
        localHeader = localHttpResponse.getFirstHeader("Content-Encoding");
        if ((localHeader != null) && (localHeader.getValue().equalsIgnoreCase("gzip")))
        {
          hjapp.com.umeng.common.a.a(a, i + "  Use GZIPInputStream get data....");
          localObject = new GZIPInputStream(localInputStream);
          str2 = a((InputStream)localObject);
          hjapp.com.umeng.common.a.a(a, i + ":\tresponse: " + str1 + str2);
          if (str2 == null)
            return null;
        }
        else
        {
          if ((localHeader == null) || (!localHeader.getValue().equalsIgnoreCase("deflate")))
            break label565;
          hjapp.com.umeng.common.a.a(a, i + "  Use InflaterInputStream get data....");
          localObject = new InflaterInputStream(localInputStream);
          continue;
        }
      }
      catch (Exception localException)
      {
        hjapp.com.umeng.common.a.c(a, i + ":\tIOException,Failed to send message." + paramString, localException);
        return null;
      }
      return new JSONObject(str2);
      label513: hjapp.com.umeng.common.a.c(a, i + ":\tFailed to send message. StatusCode = " + localHttpResponse.getStatusLine().getStatusCode() + b.a + paramString);
      label563: return null;
      label565: localObject = localInputStream;
    }
  }

  private JSONObject a(String paramString, JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.toString();
    int i = new Random().nextInt(1000);
    hjapp.com.umeng.common.a.c(a, i + ":\trequest: " + paramString + b.a + str1);
    HttpPost localHttpPost = new HttpPost(paramString);
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(localBasicHttpParams);
    while (true)
    {
      InputStream localInputStream;
      try
      {
        if (a())
        {
          byte[] arrayOfByte = hjapp.com.umeng.common.b.a.a("content=" + str1, Charset.defaultCharset().toString());
          localHttpPost.addHeader("Content-Encoding", "deflate");
          localHttpPost.setEntity(new InputStreamEntity(new ByteArrayInputStream(arrayOfByte), arrayOfByte.length));
          localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
          if (localHttpResponse.getStatusLine().getStatusCode() != 200)
            continue;
          HttpEntity localHttpEntity = localHttpResponse.getEntity();
          if (localHttpEntity == null)
            break;
          localInputStream = localHttpEntity.getContent();
          Header localHeader = localHttpResponse.getFirstHeader("Content-Encoding");
          if ((localHeader == null) || (!localHeader.getValue().equalsIgnoreCase("deflate")))
            break label539;
          localObject = new InflaterInputStream(localInputStream);
          str2 = a((InputStream)localObject);
          hjapp.com.umeng.common.a.a(a, i + ":\tresponse: " + b.a + str2);
          if (str2 == null)
            return null;
        }
        else
        {
          ArrayList localArrayList = new ArrayList(1);
          localArrayList.add(new BasicNameValuePair("content", str1));
          localHttpPost.setEntity(new UrlEncodedFormEntity(localArrayList, "UTF-8"));
          continue;
        }
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        HttpResponse localHttpResponse;
        String str2;
        hjapp.com.umeng.common.a.c(a, i + ":\tClientProtocolException,Failed to send message." + paramString, localClientProtocolException);
        return null;
        return new JSONObject(str2);
        hjapp.com.umeng.common.a.c(a, i + ":\tFailed to send message. StatusCode = " + localHttpResponse.getStatusLine().getStatusCode() + b.a + paramString);
        return null;
      }
      catch (IOException localIOException)
      {
        hjapp.com.umeng.common.a.c(a, i + ":\tIOException,Failed to send message." + paramString, localIOException);
        return null;
      }
      catch (JSONException localJSONException)
      {
        hjapp.com.umeng.common.a.c(a, i + ":\tIOException,Failed to send message." + paramString, localJSONException);
        return null;
      }
      label539: Object localObject = localInputStream;
    }
    return null;
  }

  private void b(String paramString)
  {
    if ((b.c(paramString)) || (!(j.b.equals(paramString.trim()) ^ j.a.equals(paramString.trim()))))
      throw new RuntimeException("验证请求方式失败[" + paramString + "]");
  }

  public i a(Map paramMap)
  {
    this.b = paramMap;
    return this;
  }

  public k a(j paramj, Class paramClass)
  {
    String str = paramj.c().trim();
    b(str);
    JSONObject localJSONObject;
    if (j.b.equals(str))
      localJSONObject = a(paramj.b());
    while (true)
      if (localJSONObject == null)
      {
        return null;
        if (j.a.equals(str))
          localJSONObject = a(paramj.c, paramj.a());
      }
      else
      {
        try
        {
          k localk = (k)paramClass.getConstructor(new Class[] { JSONObject.class }).newInstance(new Object[] { localJSONObject });
          return localk;
        }
        catch (SecurityException localSecurityException)
        {
          hjapp.com.umeng.common.a.b(a, "SecurityException", localSecurityException);
          return null;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          while (true)
            hjapp.com.umeng.common.a.b(a, "NoSuchMethodException", localNoSuchMethodException);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          while (true)
            hjapp.com.umeng.common.a.b(a, "IllegalArgumentException", localIllegalArgumentException);
        }
        catch (InstantiationException localInstantiationException)
        {
          while (true)
            hjapp.com.umeng.common.a.b(a, "InstantiationException", localInstantiationException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          while (true)
            hjapp.com.umeng.common.a.b(a, "IllegalAccessException", localIllegalAccessException);
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          while (true)
            hjapp.com.umeng.common.a.b(a, "InvocationTargetException", localInvocationTargetException);
        }
        localJSONObject = null;
      }
  }

  public boolean a()
  {
    return false;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     i
 * JD-Core Version:    0.6.2
 */