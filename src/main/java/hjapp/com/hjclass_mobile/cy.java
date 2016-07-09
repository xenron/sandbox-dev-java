package hjapp.com.hjclass_mobile;

import android.text.Editable;
import android.text.TextWatcher;

final class cy
  implements TextWatcher
{
  cy(HJStudyCardActivity paramHJStudyCardActivity)
  {
  }

  public final void afterTextChanged(Editable paramEditable)
  {
    String str1 = paramEditable.toString().trim();
    if (str1.length() == 15)
    {
      String str2 = str1.toUpperCase();
      HJStudyCardActivity.a(this.a, str2);
    }
  }

  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     cy
 * JD-Core Version:    0.6.2
 */