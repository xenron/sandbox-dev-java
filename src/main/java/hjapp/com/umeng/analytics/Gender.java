package hjapp.com.umeng.analytics;

public enum Gender
{
  static
  {
    Female = new Gender("Female", 1);
    Unknown = new Gender("Unknown", 2);
    Gender[] arrayOfGender = new Gender[3];
    arrayOfGender[0] = Male;
    arrayOfGender[1] = Female;
    arrayOfGender[2] = Unknown;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     Gender
 * JD-Core Version:    0.6.2
 */