package hjapp.com.hjclass_mobile.pkg_a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import java.io.IOException;

final class e
  implements OnClickListener
{
  e(c paramc, String paramString, Context paramContext)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str1 = this.a;
    try
    {
      String str2 = "chmod " + "777" + " " + str1;
      Runtime.getRuntime().exec(str2);
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(268435456);
      localIntent.setDataAndType(Uri.parse("file://" + this.a), "application/vnd.android.package-archive");
      this.b.startActivity(localIntent);
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     e
 * JD-Core Version:    0.6.2
 */