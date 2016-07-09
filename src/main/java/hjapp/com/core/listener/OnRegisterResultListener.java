package hjapp.com.core.listener;

public abstract interface OnRegisterResultListener
{
  public abstract void registerBegin();

  public abstract void registerFail(String paramString);

  public abstract void registerSuccess(String paramString);

  public abstract void verificationBegin();

  public abstract void verificationFail(String paramString);

  public abstract void verificationSuccess(String paramString);
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     OnRegisterResultListener
 * JD-Core Version:    0.6.2
 */