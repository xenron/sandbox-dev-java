package hjapp.com.umeng.fb.util;

import android.content.Context;
import android.content.Intent;
import hjapp.com.umeng.fb.b;
import hjapp.com.umeng.fb.ui.FeedbackConversation;
import hjapp.com.umeng.fb.ui.FeedbackConversations;
import hjapp.com.umeng.fb.ui.SendFeedback;
import java.util.Map;

public class ActivityStarter
{
  public static Map contactMap = null;
  public static Context lastContext;
  public static Map remarkMap = null;
  public static boolean useGoBackButton = false;
  public static Context userContext = null;

  static
  {
    lastContext = null;
  }

  public static void openDetailActivity(Context paramContext, b paramb)
  {
    if (userContext == null)
      userContext = paramContext;
    FeedbackConversation.setUserContext(paramContext);
    Intent localIntent = new Intent(paramContext, FeedbackConversation.class);
    localIntent.setFlags(131072);
    localIntent.putExtra("feedback_id", paramb.c);
    paramContext.startActivity(localIntent);
  }

  public static void openFeedbackListActivity(Context paramContext)
  {
    if (userContext == null)
      userContext = paramContext;
    Intent localIntent = new Intent(paramContext, FeedbackConversations.class);
    localIntent.setFlags(131072);
    paramContext.startActivity(localIntent);
  }

  public static void openSendFeedbackActivity(Context paramContext)
  {
    if (userContext == null)
      userContext = paramContext;
    while (true)
    {
      openSendFeedbackActivity(paramContext, null);
      return;
      if ((paramContext instanceof FeedbackConversations))
        lastContext = paramContext;
    }
  }

  public static void openSendFeedbackActivity(Context paramContext, b paramb)
  {
    Intent localIntent = new Intent(paramContext, SendFeedback.class);
    localIntent.setFlags(131072);
    if ((paramb != null) && (paramb.b == b.a.b))
      localIntent.putExtra("feedback_id", paramb.c);
    paramContext.startActivity(localIntent);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ActivityStarter
 * JD-Core Version:    0.6.2
 */