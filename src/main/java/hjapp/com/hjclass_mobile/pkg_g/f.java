package hjapp.com.hjclass_mobile.pkg_g;

import android.content.Context;
import android.os.AsyncTask;

public final class f extends AsyncTask
{
  private Context a = null;

  public f(Context paramContext)
  {
    this.a = paramContext;
  }

  // ERROR //
  private String a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 18	com/hujiang/util/HJFile
    //   3: dup
    //   4: invokespecial 19	com/hujiang/util/HJFile:<init>	()V
    //   7: astore_2
    //   8: new 21	java/io/File
    //   11: dup
    //   12: aload_1
    //   13: iconst_2
    //   14: aaload
    //   15: invokespecial 24	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore_3
    //   19: aload_3
    //   20: invokevirtual 28	java/io/File:exists	()Z
    //   23: ifeq +29 -> 52
    //   26: aload_2
    //   27: aload_0
    //   28: getfield 13	com/hjclass_mobile/g/f:a	Landroid/content/Context;
    //   31: aload_1
    //   32: iconst_0
    //   33: aaload
    //   34: aload_1
    //   35: iconst_1
    //   36: aaload
    //   37: invokestatic 33	com/hjclass_mobile/h/y:a	(Ljava/lang/String;)[B
    //   40: aload_1
    //   41: iconst_2
    //   42: aaload
    //   43: aload_1
    //   44: iconst_3
    //   45: aaload
    //   46: invokestatic 39	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   49: invokevirtual 43	com/hujiang/util/HJFile:digOut	(Ljava/lang/Object;Ljava/lang/String;[BLjava/lang/String;Z)V
    //   52: aload_3
    //   53: astore 6
    //   55: aload 6
    //   57: invokevirtual 28	java/io/File:exists	()Z
    //   60: ifeq +24 -> 84
    //   63: aload_1
    //   64: iconst_2
    //   65: aaload
    //   66: areturn
    //   67: astore 7
    //   69: aload 7
    //   71: astore 5
    //   73: aconst_null
    //   74: astore 6
    //   76: aload 5
    //   78: invokevirtual 46	java/lang/Exception:printStackTrace	()V
    //   81: goto -26 -> 55
    //   84: aconst_null
    //   85: areturn
    //   86: astore 4
    //   88: aload 4
    //   90: astore 5
    //   92: aload_3
    //   93: astore 6
    //   95: goto -19 -> 76
    //
    // Exception table:
    //   from	to	target	type
    //   8	19	67	java/lang/Exception
    //   19	52	86	java/lang/Exception
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     f:    0.6.2
 */