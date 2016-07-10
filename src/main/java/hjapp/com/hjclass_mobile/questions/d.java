package hjapp.com.hjclass_mobile.questions;

import android.text.Editable;
import android.text.TextWatcher;
import hjapp.com.hjclass_mobile.pkg_h.u;

final class d
  implements TextWatcher
{
  d(QuestionBaseWebViewActivity paramQuestionBaseWebViewActivity)
  {
  }

  public final void afterTextChanged(Editable paramEditable)
  {
    u.c("length=" + paramEditable.toString().length());
    if (paramEditable.toString().length() == 0)
    {
      this.a.b.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(2130837777), null, null, null);
      return;
    }
    this.a.b.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }

  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     d
 * JD-Core Version:    0.6.2
 */