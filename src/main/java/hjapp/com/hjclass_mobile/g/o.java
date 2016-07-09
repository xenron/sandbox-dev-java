package hjapp.com.hjclass_mobile.g;

import android.content.Context;
import android.os.AsyncTask;
import hjapp.com.hjclass_mobile.c.u;

public final class o extends AsyncTask
{
  private Context a = null;
  private u b = null;

  public o(Context paramContext)
  {
    this.a = paramContext;
  }

  // ERROR //
  private String a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 24	com/hujiang/util/HJFile
    //   3: dup
    //   4: invokespecial 25	com/hujiang/util/HJFile:<init>	()V
    //   7: astore_2
    //   8: new 27	java/io/File
    //   11: dup
    //   12: aload_1
    //   13: iconst_2
    //   14: aaload
    //   15: invokespecial 30	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore_3
    //   19: aload_3
    //   20: invokevirtual 34	java/io/File:exists	()Z
    //   23: ifeq +29 -> 52
    //   26: aload_2
    //   27: aload_0
    //   28: getfield 15	com/hjclass_mobile/g/o:a	Landroid/content/Context;
    //   31: aload_1
    //   32: iconst_0
    //   33: aaload
    //   34: aload_1
    //   35: iconst_1
    //   36: aaload
    //   37: invokestatic 39	com/hjclass_mobile/h/y:a	(Ljava/lang/String;)[B
    //   40: aload_1
    //   41: iconst_2
    //   42: aaload
    //   43: aload_1
    //   44: iconst_3
    //   45: aaload
    //   46: invokestatic 45	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   49: invokevirtual 49	com/hujiang/util/HJFile:fillBack	(Ljava/lang/Object;Ljava/lang/String;[BLjava/lang/String;Z)V
    //   52: aload_3
    //   53: astore 6
    //   55: aload 6
    //   57: invokevirtual 34	java/io/File:exists	()Z
    //   60: ifeq +34 -> 94
    //   63: aload_1
    //   64: iconst_2
    //   65: aaload
    //   66: areturn
    //   67: astore 7
    //   69: aload 7
    //   71: invokevirtual 52	com/hujiang/util/a:printStackTrace	()V
    //   74: ldc 54
    //   76: areturn
    //   77: astore 8
    //   79: aload 8
    //   81: astore 5
    //   83: aconst_null
    //   84: astore 6
    //   86: aload 5
    //   88: invokevirtual 55	java/lang/Exception:printStackTrace	()V
    //   91: goto -36 -> 55
    //   94: aconst_null
    //   95: areturn
    //   96: astore 4
    //   98: aload 4
    //   100: astore 5
    //   102: aload_3
    //   103: astore 6
    //   105: goto -19 -> 86
    //
    // Exception table:
    //   from	to	target	type
    //   0	19	67	com/hujiang/util/a
    //   19	52	67	com/hujiang/util/a
    //   0	19	77	java/lang/Exception
    //   19	52	96	java/lang/Exception
  }

  public final void a(u paramu)
  {
    this.b = paramu;
  }

  protected final void onPreExecute()
  {
    super.onPreExecute();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     g:    0.6.2
 */