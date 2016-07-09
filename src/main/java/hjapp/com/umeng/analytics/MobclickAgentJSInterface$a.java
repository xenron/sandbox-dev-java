package hjapp.com.umeng.analytics;

import android.graphics.Bitmap;
import android.os.Message;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

final class MobclickAgentJSInterface$a extends WebChromeClient
{
  WebChromeClient a = null;
  private final String c = "ekv";
  private final String d = "event";

  public MobclickAgentJSInterface$a(MobclickAgentJSInterface paramMobclickAgentJSInterface, WebChromeClient paramWebChromeClient)
  {
    if (paramWebChromeClient == null)
    {
      this.a = new WebChromeClient();
      return;
    }
    this.a = paramWebChromeClient;
  }

  public final void onCloseWindow(WebView paramWebView)
  {
    this.a.onCloseWindow(paramWebView);
  }

  public final boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    return this.a.onCreateWindow(paramWebView, paramBoolean1, paramBoolean2, paramMessage);
  }

  public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return this.a.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
  }

  public final boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return this.a.onJsBeforeUnload(paramWebView, paramString1, paramString2, paramJsResult);
  }

  public final boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return this.a.onJsConfirm(paramWebView, paramString1, paramString2, paramJsResult);
  }

  public final boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    JSONObject localJSONObject2;
    HashMap localHashMap;
    String str1;
    int i;
    if ("ekv".equals(paramString2))
      try
      {
        localJSONObject2 = new JSONObject(paramString3);
        localHashMap = new HashMap();
        str1 = (String)localJSONObject2.remove("id");
        if (localJSONObject2.isNull("duration"))
        {
          i = 0;
          Iterator localIterator = localJSONObject2.keys();
          while (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            localHashMap.put(str2, localJSONObject2.getString(str2));
          }
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    while (true)
    {
      paramJsPromptResult.confirm();
      return true;
      i = ((Integer)localJSONObject2.remove("duration")).intValue();
      break;
      MobclickAgent.a().a(MobclickAgentJSInterface.a(this.b), str1, localHashMap, i);
      continue;
      if (!"event".equals(paramString2))
        break label220;
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString3);
        MobclickAgent.a().a(MobclickAgentJSInterface.a(this.b), localJSONObject1.getString("tag"), localJSONObject1.optString("label"), localJSONObject1.optInt("duration"), 1);
      }
      catch (Exception localException1)
      {
      }
    }
    label220: return this.a.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
  }

  public final void onProgressChanged(WebView paramWebView, int paramInt)
  {
    this.a.onProgressChanged(paramWebView, paramInt);
  }

  public final void onReceivedIcon(WebView paramWebView, Bitmap paramBitmap)
  {
    this.a.onReceivedIcon(paramWebView, paramBitmap);
  }

  public final void onReceivedTitle(WebView paramWebView, String paramString)
  {
    this.a.onReceivedTitle(paramWebView, paramString);
  }

  public final void onRequestFocus(WebView paramWebView)
  {
    this.a.onRequestFocus(paramWebView);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     MobclickAgentJSInterface.a
 * JD-Core Version:    0.6.2
 */