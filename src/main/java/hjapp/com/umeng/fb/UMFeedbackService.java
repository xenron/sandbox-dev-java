package hjapp.com.umeng.fb;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import hjapp.com.umeng.fb.ui.FeedbackConversations;
import hjapp.com.umeng.fb.util.ActivityStarter;
import hjapp.com.umeng.fb.util.FeedBackListener;

import java.util.Map;

public class UMFeedbackService
{
  private static NotificationType a;
  private static Context b;
  private static boolean c = false;
  public static FeedBackListener fbListener;

  private static void b(String paramString)
  {
    if (a == NotificationType.NotificationBar)
    {
      NotificationManager localNotificationManager = (NotificationManager)b.getSystemService("notification");
      Notification localNotification = new Notification(b.d(b), b.getString(hjapp.com.umeng.fb.b.e.w(b)), System.currentTimeMillis());
      Intent localIntent = new Intent(b, FeedbackConversations.class);
      localIntent.setFlags(131072);
      PendingIntent localPendingIntent = PendingIntent.getActivity(b, 0, localIntent, 0);
      PackageManager localPackageManager = b.getPackageManager();
      try
      {
        CharSequence localCharSequence = localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(b.getPackageName(), 128));
        localObject = localCharSequence;
        if (localObject != null)
          localObject = localObject + " : ";
        localNotification.setLatestEventInfo(b, localObject + b.getString(hjapp.com.umeng.fb.b.e.x(b)), b.getString(hjapp.com.umeng.fb.b.e.y(b)), localPendingIntent);
        localNotification.flags = 16;
        localNotificationManager.notify(0, localNotification);
        return;
      }
      catch (NameNotFoundException localNameNotFoundException)
      {
        while (true)
        {
          if (f.h)
            localNameNotFoundException.printStackTrace();
          Object localObject = null;
        }
      }
    }
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(b).inflate(hjapp.com.umeng.fb.b.d.f(b), null);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(hjapp.com.umeng.fb.b.c.v(b));
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(hjapp.com.umeng.fb.b.c.w(b));
    localTextView2.setText(paramString);
    AlertDialog localAlertDialog = new Builder(b).create();
    localAlertDialog.show();
    localAlertDialog.setContentView(localLinearLayout);
    localTextView1.setText(b.getString(hjapp.com.umeng.fb.b.e.z(b)));
    ((Button)localLinearLayout.findViewById(hjapp.com.umeng.fb.b.c.x(b))).setOnClickListener(new c(localAlertDialog));
    Button localButton = (Button)localLinearLayout.findViewById(hjapp.com.umeng.fb.b.c.y(b));
    d locald = new d(localAlertDialog);
    localButton.setOnClickListener(locald);
    localTextView2.setOnClickListener(locald);
  }

  public static void enableNewReplyNotification(Context paramContext, NotificationType paramNotificationType)
  {
    e locale = new e();
    b = paramContext;
    a = paramNotificationType;
    new a.e(paramContext, locale).start();
    new a.d(paramContext).start();
    c = true;
  }

  public static boolean getHasCheckedReply()
  {
    return c;
  }

  public static void openUmengFeedbackSDK(Context paramContext)
  {
    ActivityStarter.openSendFeedbackActivity(paramContext);
  }

  public static void setContactMap(Map paramMap)
  {
    ActivityStarter.contactMap = paramMap;
  }

  public static void setFeedBackListener(FeedBackListener paramFeedBackListener)
  {
    fbListener = paramFeedBackListener;
  }

  public static void setGoBackButtonVisible()
  {
    ActivityStarter.useGoBackButton = true;
  }

  public static void setRemarkMap(Map paramMap)
  {
    ActivityStarter.remarkMap = paramMap;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     UMFeedbackService
 * JD-Core Version:    0.6.2
 */