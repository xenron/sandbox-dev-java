package hjapp.com.hjclass_mobile;

import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.widget.TextView;
import hjapp.com.hjclass_mobile.a.b;
import hjapp.com.hjclass_mobile.a.n;
import hjapp.com.hjclass_mobile.h.y;

final class h extends Handler
{
  h(HJAlipayActivity paramHJAlipayActivity)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    while (true)
    {
      String str2;
      String str3;
      try
      {
        String str1 = (String)paramMessage.obj;
        switch (paramMessage.what)
        {
        default:
          super.handleMessage(paramMessage);
          return;
        case 1:
        }
        this.a.b();
        try
        {
          str2 = str1.substring(str1.indexOf("resultStatus={") + "resultStatus={".length(), str1.indexOf("};memo="));
          str3 = str1.substring(str1.indexOf("memo={") + "memo={".length(), str1.indexOf("};result="));
          if (new n(str1).a() != 1)
            break label162;
          b.a(this.a, "提示", this.a.getResources().getString(2131493095), 17301543);
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          b.a(this.a, "提示", str1, 2130837729);
        }
        continue;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        return;
      }
      label162: if (str2.equals("9000"))
      {
        TextView localTextView = HJAlipayActivity.b(this.a);
        String str4 = this.a.getString(2131493101);
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = ("<font color='#ff6e00'>" + HJAlipayActivity.a(this.a).getText().toString() + "</font>");
        localTextView.setText(Html.fromHtml(y.a(str4, arrayOfObject)));
        HJAlipayActivity.c(this.a).setVisibility(0);
        HJAlipayActivity.d(this.a).setVisibility(8);
      }
      else
      {
        b.a(this.a, "提示", str3 + "(" + str2 + ")", 2130837729);
      }
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     h
 * JD-Core Version:    0.6.2
 */