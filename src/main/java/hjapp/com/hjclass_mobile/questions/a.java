package hjapp.com.hjclass_mobile.questions;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import hjapp.com.hjclass_mobile.HJLoginActivity;
import hjapp.com.hjclass_mobile.pkg_h.u;

public class a extends WebViewClient
{
  public boolean a = true;
  private Handler b;
  private Context c;

  public a(Handler paramHandler, Context paramContext)
  {
    this.b = paramHandler;
    this.c = paramContext;
  }

  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    Message localMessage = this.b.obtainMessage();
    localMessage.what = 2131361793;
    this.b.sendMessage(localMessage);
  }

  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    Message localMessage = this.b.obtainMessage();
    localMessage.what = 2131361792;
    this.b.sendMessage(localMessage);
  }

  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    u.a("错误: errorCode=" + paramInt + ",description=" + paramString1 + ",failingUrl=" + paramString2);
    paramWebView.stopLoading();
    paramWebView.clearView();
    Message localMessage = this.b.obtainMessage();
    localMessage.what = 2131361794;
    this.b.sendMessage(localMessage);
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Intent localIntent1;
    if (paramString.contains("http://hxjiang.duapp.com/question/details/"))
    {
      localIntent1 = new Intent();
      if (this.a)
      {
        localIntent1.setClass(this.c, QuestionDetailsActivity.class);
        localIntent1.putExtra("url", paramString);
        this.c.startActivity(localIntent1);
      }
    }
    while (true)
    {
      return true;
      localIntent1.setClass(this.c, QuestionMyQuestionDetailsActivity.class);
      break;
      if (paramString.contains("http://hxjiang.duapp.com/Authorization/login"))
      {
        Intent localIntent2 = new Intent();
        localIntent2.setClass(this.c, HJLoginActivity.class);
        localIntent2.putExtra("type", "switcher");
        this.c.startActivity(localIntent2);
      }
      else
      {
        Intent localIntent3 = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        this.c.startActivity(localIntent3);
      }
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     a
 * JD-Core Version:    0.6.2
 */