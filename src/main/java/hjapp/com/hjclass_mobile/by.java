package hjapp.com.hjclass_mobile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import hjapp.com.hjclass_mobile.questions.QuestionDetailsActivity;

final class by extends WebViewClient
{
  by(HJLessonListActivity paramHJLessonListActivity)
  {
  }

  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.a.a.sendEmptyMessage(2131361793);
  }

  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this.a.a.sendEmptyMessage(2131361792);
  }

  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    h.u.a("错误: errorCode=" + paramInt + ",description=" + paramString1 + ",failingUrl=" + paramString2);
    this.a.a.sendEmptyMessage(2131361794);
  }

  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (paramString.contains("http://hxjiang.duapp.com/question/details/"))
    {
      Intent localIntent1 = new Intent();
      localIntent1.setClass(this.a, QuestionDetailsActivity.class);
      localIntent1.putExtra("url", paramString);
      this.a.startActivity(localIntent1);
    }
    while (true)
    {
      return true;
      if (paramString.contains("http://hxjiang.duapp.com/Authorization/login"))
      {
        Intent localIntent2 = new Intent();
        localIntent2.setClass(this.a, HJLoginActivity.class);
        localIntent2.putExtra("type", "switcher");
        this.a.startActivity(localIntent2);
        this.a.finish();
      }
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     by
 * JD-Core Version:    0.6.2
 */