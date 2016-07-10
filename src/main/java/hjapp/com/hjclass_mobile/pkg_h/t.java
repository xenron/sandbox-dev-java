package hjapp.com.hjclass_mobile.pkg_h;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

public final class t
{
  public static String a(String paramString, Map paramMap)
  {
    return a(paramString, paramMap, "UTF-8");
  }

  private static String a(String paramString1, Map paramMap, String paramString2)
  {
    String str = "";
    if ((paramString1 == null) || ("".equals(paramString1)))
      str = "";
    while (true)
    {
      return str;
      try
      {
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 20000);
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
        HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
        HttpClientParams.setRedirecting(localBasicHttpParams, true);
        HttpProtocolParams.setUserAgent(localBasicHttpParams, "Mozilla/5.0 (Linux; U; Android 0.5; en-us) AppleWebKit/522+ (KHTML, like Gecko) Safari/419.3");
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(localBasicHttpParams);
        HttpPost localHttpPost = new HttpPost(paramString1);
        if ((paramString2 == null) || ("".equals(paramString2)));
        for (UrlEncodedFormEntity localUrlEncodedFormEntity = new UrlEncodedFormEntity(a(paramMap)); ; localUrlEncodedFormEntity = new UrlEncodedFormEntity(a(paramMap), paramString2))
        {
          localHttpPost.setEntity(localUrlEncodedFormEntity);
          HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
          if (localHttpResponse.getStatusLine().getStatusCode() != 200)
            break;
          return EntityUtils.toString(localHttpResponse.getEntity(), "UTF-8");
        }
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        localClientProtocolException.printStackTrace();
        return "";
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return "";
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return "";
  }

  private static List a(Map paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0))
      return null;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Entry localEntry = (Entry)localIterator.next();
      localArrayList.add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    return localArrayList;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     t
 * JD-Core Version:    0.6.2
 */