package hjapp.com.hjclass_mobile.view.widget;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

final class a
  implements OnClickListener
{
  a(HuzAlertController paramHuzAlertController)
  {
  }

  public final void onClick(View paramView)
  {
    Message localMessage1;
    if ((paramView == HuzAlertController.a(this.a)) && (HuzAlertController.b(this.a) != null))
      localMessage1 = Message.obtain(HuzAlertController.b(this.a));
    while (true)
    {
      if (localMessage1 != null)
        localMessage1.sendToTarget();
      HuzAlertController.h(this.a).obtainMessage(1, HuzAlertController.g(this.a)).sendToTarget();
      return;
      if ((paramView == HuzAlertController.c(this.a)) && (HuzAlertController.d(this.a) != null))
      {
        localMessage1 = Message.obtain(HuzAlertController.d(this.a));
      }
      else
      {
        Button localButton = HuzAlertController.e(this.a);
        localMessage1 = null;
        if (paramView == localButton)
        {
          Message localMessage2 = HuzAlertController.f(this.a);
          localMessage1 = null;
          if (localMessage2 != null)
            localMessage1 = Message.obtain(HuzAlertController.f(this.a));
        }
      }
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     a
 * JD-Core Version:    0.6.2
 */