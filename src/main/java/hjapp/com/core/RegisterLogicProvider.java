package hjapp.com.core;

import android.util.Log;
import hjapp.com.core.listener.OnRegisterResultListener;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import org.json.JSONException;
import org.json.JSONObject;

public class RegisterLogicProvider
{
  private static RegisterLogicProvider mInstance = null;
  private String action;
  private String email;
  private RegisterLogicProvider.RegisterAsyncTask mTask = null;
  private RegisterLogicProvider.VerificationAsyncTask mVerificationTask = null;
  private String method = "POST";
  private String mobile;
  private OnRegisterResultListener onRegisterResultListener = null;
  private String source;
  private int timeOut = 20;
  private String userName;
  private String userPwd;

  public RegisterLogicProvider()
  {
  }

  public RegisterLogicProvider(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    setUserName(paramString1);
    setUserPwd(paramString2);
    if (paramString5.equals("register_by_email"))
      setEmail(paramString3);
    while (true)
    {
      setSource(paramString4);
      setAction(paramString5);
      return;
      setMobile(paramString3);
    }
  }

  private String MD5(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      String str = toHex(localMessageDigest.digest()).substring(8, 24);
      return str;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  public static RegisterLogicProvider getInstance()
  {
    if (mInstance == null)
      mInstance = new RegisterLogicProvider();
    return mInstance;
  }

  private void parseResult(String paramString, boolean paramBoolean)
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject(paramString);
      if (getOnRegisterResultListener() == null)
        return;
      if ((localJSONObject.has("result")) && (localJSONObject.has("msg")))
        break label92;
      if (paramBoolean)
      {
        getOnRegisterResultListener().verificationFail("json Syntax error");
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      if (getOnRegisterResultListener() != null)
        getOnRegisterResultListener().registerFail(localJSONException.getMessage());
      localJSONException.printStackTrace();
      return;
    }
    getOnRegisterResultListener().registerFail("json Syntax error");
    return;
    label92: int i = localJSONObject.getInt("result");
    String str = localJSONObject.getString("msg");
    if (i > 0)
    {
      if (paramBoolean)
      {
        getOnRegisterResultListener().verificationSuccess(str);
        return;
      }
      getOnRegisterResultListener().registerSuccess(str);
      return;
    }
    if (paramBoolean)
    {
      getOnRegisterResultListener().verificationFail(str);
      return;
    }
    getOnRegisterResultListener().registerFail(str);
  }

  private byte[] readStream(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[8192];
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
      {
        localByteArrayOutputStream.close();
        paramInputStream.close();
        return localByteArrayOutputStream.toByteArray();
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
  }

  private String sendRegisterCommand()
  {
    String str1;
    HttpURLConnection localHttpURLConnection;
    if ("register_by_email".equals(getAction()))
    {
      str1 = "username=" + URLEncoder.encode(getUserName(), "UTF-8") + "&userpwd=" + MD5(getUserPwd()) + "&source=" + URLEncoder.encode(getSource(), "UTF-8") + "&email=" + getEmail() + "&action=register_by_email";
      Log.i("===========param", str1);
      if (!getMethod().toLowerCase().equals("post"))
        break label357;
      localHttpURLConnection = (HttpURLConnection)new URL("http://1bulo.hujiang.com/app/api/mobile_BuloRegister_no_validcode.ashx").openConnection();
      localHttpURLConnection.setReadTimeout(1000 * getTimeOut());
      localHttpURLConnection.setConnectTimeout(1000 * getTimeOut());
      localHttpURLConnection.setDoOutput(true);
      localHttpURLConnection.setDoInput(true);
      localHttpURLConnection.setRequestMethod(getMethod());
      localHttpURLConnection.setUseCaches(false);
      localHttpURLConnection.setInstanceFollowRedirects(true);
      localHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      localHttpURLConnection.connect();
      DataOutputStream localDataOutputStream = new DataOutputStream(localHttpURLConnection.getOutputStream());
      localDataOutputStream.writeBytes(str1);
      localDataOutputStream.flush();
      localDataOutputStream.close();
    }
    while (true)
    {
      if (localHttpURLConnection.getResponseCode() == 200)
        break label391;
      throw new Exception("connection fail");
      if ("register_by_mobile".equals(getAction()))
      {
        str1 = "username=" + URLEncoder.encode(getUserName(), "UTF-8") + "&userpwd=" + MD5(getUserPwd()) + "&source=" + URLEncoder.encode(getSource(), "UTF-8") + "&email=" + getEmail() + "&mobile=" + getMobile() + "&action=register_by_mobile";
        break;
      }
      throw new Exception("action value not set!!");
      label357: localHttpURLConnection = (HttpURLConnection)new URL("http://1bulo.hujiang.com/app/api/mobile_BuloRegister_no_validcode.ashx?" + str1).openConnection();
    }
    label391: String str2 = new String(readStream(localHttpURLConnection.getInputStream()));
    localHttpURLConnection.disconnect();
    return str2;
  }

  private String sendVerificationMobileCode(int paramInt1, int paramInt2)
  {
    String str1 = "userid=" + paramInt1 + "&code=" + paramInt2 + "&action=register_valid_mobile";
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("http://1bulo.hujiang.com/app/api/mobile_BuloRegister_no_validcode.ashx?" + str1).openConnection();
    if (localHttpURLConnection.getResponseCode() != 200)
      throw new Exception("connection fail");
    String str2 = new String(readStream(localHttpURLConnection.getInputStream()));
    localHttpURLConnection.disconnect();
    return str2;
  }

  private String toHex(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    StringBuffer localStringBuffer = new StringBuffer(i * 2);
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return localStringBuffer.toString();
      localStringBuffer.append(Character.forDigit((0xF0 & paramArrayOfByte[j]) >> 4, 16));
      localStringBuffer.append(Character.forDigit(0xF & paramArrayOfByte[j], 16));
    }
  }

  public String getAction()
  {
    return this.action;
  }

  public String getEmail()
  {
    return this.email;
  }

  public String getMethod()
  {
    return this.method;
  }

  public String getMobile()
  {
    return this.mobile;
  }

  public OnRegisterResultListener getOnRegisterResultListener()
  {
    return this.onRegisterResultListener;
  }

  public String getSource()
  {
    return this.source;
  }

  public int getTimeOut()
  {
    return this.timeOut;
  }

  public String getUserName()
  {
    return this.userName;
  }

  public String getUserPwd()
  {
    return this.userPwd;
  }

  public void register()
  {
    if ((this.mTask != null) && (this.mTask.getStatus() == AsyncTask.Status.RUNNING))
    {
      this.mTask.cancel(true);
      this.mTask = null;
    }
    this.mTask = new RegisterLogicProvider.RegisterAsyncTask(this);
    this.mTask.execute(new Void[0]);
  }

  public void setAction(String paramString)
  {
    this.action = paramString;
  }

  public void setEmail(String paramString)
  {
    this.email = paramString;
  }

  public void setMethod(String paramString)
  {
    this.method = paramString;
  }

  public void setMobile(String paramString)
  {
    this.mobile = paramString;
  }

  public void setOnRegisterResultListener(OnRegisterResultListener paramOnRegisterResultListener)
  {
    this.onRegisterResultListener = paramOnRegisterResultListener;
  }

  public void setSource(String paramString)
  {
    this.source = paramString;
  }

  public void setTimeOut(int paramInt)
  {
    this.timeOut = paramInt;
  }

  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }

  public void setUserPwd(String paramString)
  {
    this.userPwd = paramString;
  }

  public void verificationMobileCode(int paramInt1, int paramInt2)
  {
    if ((this.mVerificationTask != null) && (this.mVerificationTask.getStatus() == AsyncTask.Status.RUNNING))
    {
      this.mVerificationTask.cancel(true);
      this.mTask = null;
    }
    if ((paramInt1 <= 0) && (paramInt2 <= 0))
      throw new Exception("code is error");
    this.mVerificationTask = new RegisterLogicProvider.VerificationAsyncTask(this);
    RegisterLogicProvider.VerificationAsyncTask localVerificationAsyncTask = this.mVerificationTask;
    Integer[] arrayOfInteger = new Integer[2];
    arrayOfInteger[0] = Integer.valueOf(paramInt1);
    arrayOfInteger[1] = Integer.valueOf(paramInt2);
    localVerificationAsyncTask.execute(arrayOfInteger);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     RegisterLogicProvider
 * JD-Core Version:    0.6.2
 */