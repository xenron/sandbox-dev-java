package hjapp.com.core;

import android.os.AsyncTask;
import android.text.TextUtils;

class RegisterLogicProvider$RegisterAsyncTask extends AsyncTask
{
  RegisterLogicProvider$RegisterAsyncTask(RegisterLogicProvider paramRegisterLogicProvider)
  {
  }

  protected String doInBackground(Void[] paramArrayOfVoid)
  {
    try
    {
      String str = RegisterLogicProvider.access$2(this.this$0);
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
      RegisterLogicProvider.access$1(this.this$0, paramString, false);
    while (true)
    {
      super.onPostExecute(paramString);
      return;
      if (this.this$0.getOnRegisterResultListener() != null)
        this.this$0.getOnRegisterResultListener().registerFail("Registration failed");
    }
  }

  protected void onPreExecute()
  {
    if (this.this$0.getOnRegisterResultListener() != null)
      this.this$0.getOnRegisterResultListener().registerBegin();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     RegisterLogicProvider.RegisterAsyncTask
 * JD-Core Version:    0.6.2
 */