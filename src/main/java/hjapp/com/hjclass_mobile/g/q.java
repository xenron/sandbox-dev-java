package hjapp.com.hjclass_mobile.g;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;

public final class q extends AsyncTask
{
  protected boolean a = false;
  private int c;
  private int d;
  private int e;
  private String f;
  private String g = null;
  private File h;
  private Context i = null;

  public q(p paramp, Context paramContext)
  {
    this.i = paramContext;
  }

  // ERROR //
  private String a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: new 39	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: iconst_0
    //   9: aaload
    //   10: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: putfield 44	com/hjclass_mobile/g/q:h	Ljava/io/File;
    //   16: aload_0
    //   17: aload_1
    //   18: iconst_1
    //   19: aaload
    //   20: putfield 46	com/hjclass_mobile/g/q:f	Ljava/lang/String;
    //   23: aload_0
    //   24: aload_1
    //   25: iconst_2
    //   26: aaload
    //   27: invokestatic 52	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   30: putfield 54	com/hjclass_mobile/g/q:c	I
    //   33: aload_0
    //   34: aload_1
    //   35: iconst_3
    //   36: aaload
    //   37: invokestatic 52	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   40: putfield 56	com/hjclass_mobile/g/q:d	I
    //   43: aload_0
    //   44: aload_1
    //   45: iconst_4
    //   46: aaload
    //   47: invokestatic 52	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   50: putfield 58	com/hjclass_mobile/g/q:e	I
    //   53: aload_0
    //   54: aload_1
    //   55: iconst_5
    //   56: aaload
    //   57: invokestatic 64	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   60: putfield 30	com/hjclass_mobile/g/q:a	Z
    //   63: aload_0
    //   64: aload_1
    //   65: bipush 6
    //   67: aaload
    //   68: putfield 28	com/hjclass_mobile/g/q:g	Ljava/lang/String;
    //   71: aload_0
    //   72: getfield 44	com/hjclass_mobile/g/q:h	Ljava/io/File;
    //   75: invokevirtual 68	java/io/File:exists	()Z
    //   78: ifeq +233 -> 311
    //   81: aload_0
    //   82: getfield 44	com/hjclass_mobile/g/q:h	Ljava/io/File;
    //   85: aload_0
    //   86: getfield 54	com/hjclass_mobile/g/q:c	I
    //   89: aload_0
    //   90: getfield 56	com/hjclass_mobile/g/q:d	I
    //   93: aload_0
    //   94: getfield 58	com/hjclass_mobile/g/q:e	I
    //   97: invokestatic 73	com/hjclass_mobile/h/z:a	(Ljava/io/File;III)V
    //   100: new 75	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   107: getstatic 78	com/hjclass_mobile/h/z:c	Ljava/lang/String;
    //   110: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: getfield 54	com/hjclass_mobile/g/q:c	I
    //   117: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: ldc 87
    //   122: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_0
    //   126: getfield 56	com/hjclass_mobile/g/q:d	I
    //   129: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: ldc 87
    //   134: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_0
    //   138: getfield 58	com/hjclass_mobile/g/q:e	I
    //   141: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: astore_3
    //   148: new 75	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   155: aload_3
    //   156: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc 87
    //   161: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc 93
    //   166: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: astore 4
    //   174: new 95	com/hujiang/util/HJFile
    //   177: dup
    //   178: invokespecial 96	com/hujiang/util/HJFile:<init>	()V
    //   181: astore 5
    //   183: aload 4
    //   185: ldc 98
    //   187: invokevirtual 104	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   190: astore 9
    //   192: new 75	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   199: aload 9
    //   201: iconst_0
    //   202: aaload
    //   203: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 106
    //   208: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: astore 10
    //   216: new 39	java/io/File
    //   219: dup
    //   220: aload 4
    //   222: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   225: astore 11
    //   227: aload 11
    //   229: invokevirtual 68	java/io/File:exists	()Z
    //   232: ifeq +79 -> 311
    //   235: aload 5
    //   237: aload_0
    //   238: getfield 32	com/hjclass_mobile/g/q:i	Landroid/content/Context;
    //   241: aload_0
    //   242: getfield 56	com/hjclass_mobile/g/q:d	I
    //   245: invokestatic 110	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   248: aload_0
    //   249: getfield 28	com/hjclass_mobile/g/q:g	Ljava/lang/String;
    //   252: invokestatic 115	com/hjclass_mobile/h/y:a	(Ljava/lang/String;)[B
    //   255: aload 4
    //   257: aload 10
    //   259: aload_0
    //   260: getfield 30	com/hjclass_mobile/g/q:a	Z
    //   263: invokevirtual 119	com/hujiang/util/HJFile:decode	(Ljava/lang/Object;Ljava/lang/String;[BLjava/lang/String;Ljava/lang/String;Z)V
    //   266: aload 11
    //   268: invokevirtual 122	java/io/File:delete	()Z
    //   271: pop
    //   272: aload_0
    //   273: getfield 46	com/hjclass_mobile/g/q:f	Ljava/lang/String;
    //   276: astore 14
    //   278: aload 14
    //   280: areturn
    //   281: astore 7
    //   283: aload_2
    //   284: ifnull +15 -> 299
    //   287: aload_2
    //   288: invokevirtual 68	java/io/File:exists	()Z
    //   291: ifeq +8 -> 299
    //   294: aload_2
    //   295: invokevirtual 122	java/io/File:delete	()Z
    //   298: pop
    //   299: ldc 124
    //   301: areturn
    //   302: astore 6
    //   304: aload 6
    //   306: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   309: aconst_null
    //   310: areturn
    //   311: aload_0
    //   312: getfield 46	com/hjclass_mobile/g/q:f	Ljava/lang/String;
    //   315: areturn
    //   316: astore 12
    //   318: aload 11
    //   320: astore_2
    //   321: goto -38 -> 283
    //
    // Exception table:
    //   from	to	target	type
    //   183	227	281	com/hujiang/util/a
    //   183	227	302	java/lang/Exception
    //   227	278	302	java/lang/Exception
    //   227	278	316	com/hujiang/util/a
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     q:    0.6.2
 */