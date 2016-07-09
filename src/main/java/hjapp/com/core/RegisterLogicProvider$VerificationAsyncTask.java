package hjapp.com.core;

import android.os.AsyncTask;
import android.text.TextUtils;

class RegisterLogicProvider$VerificationAsyncTask extends AsyncTask
{
  RegisterLogicProvider$VerificationAsyncTask(RegisterLogicProvider paramRegisterLogicProvider)
  {
  }

  protected String doInBackground(Integer[] paramArrayOfInteger)
  {
    if (paramArrayOfInteger.length == 2)
      try
      {
        String str = RegisterLogicProvider.access$0(this.this$0, paramArrayOfInteger[0].intValue(), paramArrayOfInteger[1].intValue());
        return str;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    return null;
  }

  protected void onPostExecute(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      RegisterLogicProvider.access$1(this.this$0, paramString, true);
    while (this.this$0.getOnRegisterResultListener() == null)
      return;
    this.this$0.getOnRegisterResultListener().verificationFail("Registration failed");
  }

  protected void onPreExecute()
  {
    if (this.this$0.getOnRegisterResultListener() != null)
      this.this$0.getOnRegisterResultListener().verificationBegin();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     RegisterLogicProvider.VerificationAsyncTask
 * JD-Core Version:    0.6.2
 */