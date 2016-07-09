package hjapp.com.hjclass_mobile;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import hjapp.com.hjclass_mobile.f.c;
import hjapp.com.hjclass_mobile.questions.QuestionAskQuestionActivity;
import hjapp.com.hjclass_mobile.questions.QuestionMyAnswerActivity;
import hjapp.com.hjclass_mobile.questions.QuestionMyAskActivity;
import hjapp.com.hjclass_mobile.questions.QuestionMyFollowActivity;

final class ca
  implements OnClickListener
{
  ca(HJLessonListActivity paramHJLessonListActivity)
  {
  }

  public final void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    switch (paramView.getId())
    {
    default:
      return;
    case 2131361876:
      localIntent.setClass(this.a, QuestionAskQuestionActivity.class);
      localIntent.putExtra("cid", String.valueOf(HJLessonListActivity.k(this.a)));
      this.a.startActivity(localIntent);
      return;
    case 2131361878:
      localIntent.setClass(this.a, QuestionMyAnswerActivity.class);
      localIntent.putExtra("url", "http://hxjiang.duapp.com/question/my?my=answer&token=" + c.a() + "&cid=" + String.valueOf(HJLessonListActivity.k(this.a)));
      this.a.startActivity(localIntent);
      return;
    case 2131361877:
      localIntent.setClass(this.a, QuestionMyAskActivity.class);
      localIntent.putExtra("url", "http://hxjiang.duapp.com/question/list/my?token=" + c.a() + "&cid=" + String.valueOf(HJLessonListActivity.k(this.a)));
      this.a.startActivity(localIntent);
      return;
    case 2131361879:
    }
    localIntent.setClass(this.a, QuestionMyFollowActivity.class);
    localIntent.putExtra("url", "http://hxjiang.duapp.com/question/my?my=follow&token=" + c.a() + "&cid=" + String.valueOf(HJLessonListActivity.k(this.a)));
    this.a.startActivity(localIntent);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ca
 * JD-Core Version:    0.6.2
 */