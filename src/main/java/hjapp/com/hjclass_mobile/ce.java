package hjapp.com.hjclass_mobile;

import android.os.AsyncTask;

final class ce extends AsyncTask
{
  private ce(HJLessonListActivity paramHJLessonListActivity)
  {
  }

  // ERROR //
  private java.util.List a(Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 23	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 24	java/util/ArrayList:<init>	()V
    //   7: pop
    //   8: getstatic 30	com/hjclass_mobile/h/z:h	Z
    //   11: ifeq +189 -> 200
    //   14: aload_0
    //   15: getfield 10	com/hjclass_mobile/ce:a	Lcom/hjclass_mobile/HJLessonListActivity;
    //   18: invokestatic 35	com/hjclass_mobile/HJLessonListActivity:a	(Lcom/hjclass_mobile/HJLessonListActivity;)Lcom/hjclass_mobile/b/b;
    //   21: invokestatic 41	com/hjclass_mobile/f/c:b	()I
    //   24: aload_1
    //   25: iconst_1
    //   26: aaload
    //   27: checkcast 43	java/lang/Integer
    //   30: invokevirtual 46	java/lang/Integer:intValue	()I
    //   33: invokevirtual 52	com/hjclass_mobile/b/b:j	(II)Ljava/lang/String;
    //   36: astore 8
    //   38: aload 8
    //   40: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifne +26 -> 69
    //   46: ldc 60
    //   48: aload 8
    //   50: invokestatic 66	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   53: pop
    //   54: invokestatic 69	com/hjclass_mobile/f/c:a	()Ljava/lang/String;
    //   57: astore 11
    //   59: invokestatic 74	com/hjclass_mobile/f/b:a	()Lcom/hjclass_mobile/f/b;
    //   62: aload 8
    //   64: aload 11
    //   66: invokevirtual 78	com/hjclass_mobile/f/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: getfield 10	com/hjclass_mobile/ce:a	Lcom/hjclass_mobile/HJLessonListActivity;
    //   73: invokestatic 35	com/hjclass_mobile/HJLessonListActivity:a	(Lcom/hjclass_mobile/HJLessonListActivity;)Lcom/hjclass_mobile/b/b;
    //   76: invokestatic 41	com/hjclass_mobile/f/c:b	()I
    //   79: aload_1
    //   80: iconst_1
    //   81: aaload
    //   82: checkcast 43	java/lang/Integer
    //   85: invokevirtual 46	java/lang/Integer:intValue	()I
    //   88: invokevirtual 81	com/hjclass_mobile/b/b:b	(II)Ljava/util/Hashtable;
    //   91: astore 7
    //   93: aload_1
    //   94: iconst_0
    //   95: aaload
    //   96: invokestatic 87	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   99: aload_1
    //   100: iconst_1
    //   101: aaload
    //   102: checkcast 43	java/lang/Integer
    //   105: invokevirtual 46	java/lang/Integer:intValue	()I
    //   108: aload_1
    //   109: iconst_2
    //   110: aaload
    //   111: checkcast 43	java/lang/Integer
    //   114: invokevirtual 46	java/lang/Integer:intValue	()I
    //   117: aload 7
    //   119: aload_0
    //   120: getfield 10	com/hjclass_mobile/ce:a	Lcom/hjclass_mobile/HJLessonListActivity;
    //   123: invokestatic 90	com/hjclass_mobile/HJLessonListActivity:b	(Lcom/hjclass_mobile/HJLessonListActivity;)Z
    //   126: invokestatic 95	com/hjclass_mobile/f/a:a	(Ljava/lang/String;IILjava/util/Hashtable;Z)Ljava/util/List;
    //   129: astore_3
    //   130: aload_3
    //   131: ifnull +17 -> 148
    //   134: aload_0
    //   135: getfield 10	com/hjclass_mobile/ce:a	Lcom/hjclass_mobile/HJLessonListActivity;
    //   138: invokestatic 99	com/hjclass_mobile/HJLessonListActivity:c	(Lcom/hjclass_mobile/HJLessonListActivity;)Ljava/util/List;
    //   141: aload_3
    //   142: invokeinterface 105 2 0
    //   147: pop
    //   148: getstatic 30	com/hjclass_mobile/h/z:h	Z
    //   151: ifeq +20 -> 171
    //   154: aload_0
    //   155: getfield 10	com/hjclass_mobile/ce:a	Lcom/hjclass_mobile/HJLessonListActivity;
    //   158: invokestatic 35	com/hjclass_mobile/HJLessonListActivity:a	(Lcom/hjclass_mobile/HJLessonListActivity;)Lcom/hjclass_mobile/b/b;
    //   161: aload_0
    //   162: getfield 10	com/hjclass_mobile/ce:a	Lcom/hjclass_mobile/HJLessonListActivity;
    //   165: invokestatic 99	com/hjclass_mobile/HJLessonListActivity:c	(Lcom/hjclass_mobile/HJLessonListActivity;)Ljava/util/List;
    //   168: invokevirtual 108	com/hjclass_mobile/b/b:a	(Ljava/util/List;)V
    //   171: aload_0
    //   172: getfield 10	com/hjclass_mobile/ce:a	Lcom/hjclass_mobile/HJLessonListActivity;
    //   175: invokestatic 111	com/hjclass_mobile/HJLessonListActivity:d	(Lcom/hjclass_mobile/HJLessonListActivity;)V
    //   178: aload_3
    //   179: areturn
    //   180: astore 10
    //   182: aload 10
    //   184: invokevirtual 114	java/lang/Exception:printStackTrace	()V
    //   187: goto -118 -> 69
    //   190: astore 6
    //   192: aload 6
    //   194: invokevirtual 115	org/json/JSONException:printStackTrace	()V
    //   197: goto -128 -> 69
    //   200: aload_0
    //   201: getfield 10	com/hjclass_mobile/ce:a	Lcom/hjclass_mobile/HJLessonListActivity;
    //   204: invokestatic 35	com/hjclass_mobile/HJLessonListActivity:a	(Lcom/hjclass_mobile/HJLessonListActivity;)Lcom/hjclass_mobile/b/b;
    //   207: invokestatic 41	com/hjclass_mobile/f/c:b	()I
    //   210: aload_1
    //   211: iconst_1
    //   212: aaload
    //   213: checkcast 43	java/lang/Integer
    //   216: invokevirtual 46	java/lang/Integer:intValue	()I
    //   219: invokevirtual 118	com/hjclass_mobile/b/b:a	(II)Ljava/util/List;
    //   222: astore_3
    //   223: goto -93 -> 130
    //   226: astore 4
    //   228: aload 4
    //   230: invokevirtual 114	java/lang/Exception:printStackTrace	()V
    //   233: goto -62 -> 171
    //
    // Exception table:
    //   from	to	target	type
    //   54	69	180	java/lang/Exception
    //   14	54	190	org/json/JSONException
    //   54	69	190	org/json/JSONException
    //   182	187	190	org/json/JSONException
    //   154	171	226	java/lang/Exception
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ce
 * JD-Core Version:    0.6.2
 */