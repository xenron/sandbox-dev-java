package hjapp.com.hjclass_mobile.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import hjapp.com.hjclass_mobile.d.*;
import hjapp.com.hjclass_mobile.d.s;

import java.io.ByteArrayInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import hjapp.com.hjclass_mobile.d.q;
import hjapp.com.hjclass_mobile.d.r;
import hjapp.com.hjclass_mobile.d.t;
import hjapp.com.hjclass_mobile.d.u;
import hjapp.com.hjclass_mobile.d.z;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  protected c a = null;
  private SQLiteDatabase b;
  private SQLiteDatabase c;

  public b(Context paramContext)
  {
    this.a = c.a(paramContext);
    this.b = c.a();
    this.c = c.b();
  }

  private static int a(Element paramElement, String paramString)
  {
    String str = paramElement.attributeValue(paramString);
    if (str == null)
      return 0;
    return (int)Float.parseFloat(str);
  }

  private static List a(Document paramDocument)
  {
    Element localElement1 = paramDocument.getRootElement();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localElement1.elementIterator("exam");
    while (localIterator.hasNext())
    {
      hjapp.com.hjclass_mobile.d.z localz = new z();
      Element localElement2 = (Element)localIterator.next();
      localz.a(Boolean.valueOf(true));
      localz.a(a(localElement2, "id"));
      localz.a(a(localElement2, "score"));
      localz.b(a(localElement2, "st"));
      localz.c(a(localElement2, "p"));
      localz.a(localElement2.element("ans").getText());
      localArrayList.add(localz);
    }
    return localArrayList;
  }

  private List l(int paramInt1, int paramInt2)
  {
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = String.valueOf(paramInt1);
    arrayOfString[1] = String.valueOf(paramInt2);
    Cursor localCursor1 = localSQLiteDatabase.rawQuery("select lessonID from app_lesson where userid=? and classid=? and studystatus=1 and islock=0 and lessonVersion>3 order by serialnum asc", arrayOfString);
    StringBuilder localStringBuilder = new StringBuilder();
    while (localCursor1.moveToNext())
    {
      localStringBuilder.append(localCursor1.getInt(0));
      localStringBuilder.append(",");
    }
    String str1 = localStringBuilder.toString();
    String str2 = str1.substring(0, -1 + str1.length());
    Cursor localCursor2 = this.c.rawQuery("select content from APP_QuestionAnswer where lessonID in (?)", new String[] { str2 });
    ArrayList localArrayList = new ArrayList();
    while (localCursor2.moveToNext())
      localArrayList.add(localCursor2.getString(0));
    return localArrayList;
  }

  public final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = String.valueOf(paramInt2);
    arrayOfString[1] = String.valueOf(paramInt3);
    arrayOfString[2] = String.valueOf(paramInt1);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select playtime from app_lesson where status=3 and lessonID=? and classID=? and (userid=? or userid=1)", arrayOfString);
    localCursor.moveToFirst();
    if ((localCursor != null) && (localCursor.getCount() > 0))
      return localCursor.getInt(0);
    localCursor.close();
    return 0;
  }

  public final r a(String paramString1, String paramString2)
  {
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramString1;
    arrayOfString[1] = URLEncoder.encode(paramString2);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select userid,tokenKey, uniqueKey,classnum,lastlogin from APP_USER where username=? and usermd5=? ", arrayOfString);
    localCursor.moveToFirst();
    r localr = null;
    if (localCursor != null)
    {
      int i = localCursor.getCount();
      localr = null;
      if (i > 0)
      {
        localr = new r();
        localr.a(localCursor.getInt(0));
        localr.b(localCursor.getString(1));
        localr.a(localCursor.getString(2));
        localr.b(localCursor.getInt(3));
        localr.a(localCursor.getLong(4));
        localr.d(paramString1);
        localr.b(true);
        localr.a(false);
        localr.c(paramString2);
      }
    }
    localCursor.close();
    return localr;
  }

  public final List a(int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString1 = new String[1];
    arrayOfString1[0] = String.valueOf(paramInt);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select lessonid ,lessonname ,classname ,classid ,userid ,status ,progress ,homeWork ,studyprogress ,studystatus ,score ,zipname ,zipurl,freeADUrl,fileSize,playtime,islock,studytime,islast,lessonversion,mediatype from app_lesson where status=3 and (userid=? or userid=1) order by serialnum asc", arrayOfString1);
    ArrayList localArrayList = new ArrayList();
    if (localCursor.moveToNext())
    {
      t localt = new t();
      localt.c(localCursor.getInt(0));
      localt.b(localCursor.getString(1));
      localt.a(localCursor.getString(2));
      localt.d(localCursor.getInt(3));
      localt.a(localCursor.getInt(4));
      localt.b(localCursor.getInt(5));
      localt.e(localCursor.getInt(6));
      localt.c(localCursor.getString(7));
      localt.f(localCursor.getInt(8));
      localt.g(localCursor.getInt(9));
      localt.a(localCursor.getInt(10));
      localt.d(localCursor.getString(11));
      String str1 = localCursor.getString(11);
      String[] arrayOfString2 = str1.split("/");
      String str2;
      if (arrayOfString2.length == 1)
      {
        str2 = arrayOfString2[0];
        label250: localt.d(str2);
        localt.g(str1);
        localt.h(localCursor.getString(12));
        localt.f(localCursor.getString(13));
        localt.a(Long.parseLong(localCursor.getString(14)));
        localt.i(localCursor.getInt(15));
        localt.e(localt.d() + "_" + localt.c() + "_" + localt.a());
        if (localCursor.getInt(16) != 1)
          break label476;
        localt.a(true);
        label393: localt.j(localCursor.getInt(17));
        if (localCursor.getInt(18) != 1)
          break label485;
        localt.c(true);
      }
      while (true)
      {
        localt.l(localCursor.getInt(19));
        localt.k(localCursor.getInt(20));
        localArrayList.add(localt);
        break;
        str2 = arrayOfString2[1];
        break label250;
        label476: localt.a(false);
        break label393;
        label485: localt.c(false);
      }
    }
    localCursor.close();
    return localArrayList;
  }

  public final List a(int paramInt1, int paramInt2)
  {
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString1 = new String[2];
    arrayOfString1[0] = String.valueOf(paramInt1);
    arrayOfString1[1] = String.valueOf(paramInt2);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select lessonid ,lessonname ,classname ,classid ,userid ,status ,progress ,homeWork ,studyprogress ,studystatus ,score ,zipname ,zipurl,freeADUrl,serialnum,fileSize,playtime,islock,studytime,islast,lessonversion,mediatype from app_lesson where userid=? and classid=? order by serialnum asc", arrayOfString1);
    ArrayList localArrayList = new ArrayList();
    if (localCursor.moveToNext())
    {
      t localt = new t();
      localt.c(localCursor.getInt(0));
      localt.b(localCursor.getString(1));
      localt.a(localCursor.getString(2));
      localt.d(localCursor.getInt(3));
      localt.a(localCursor.getInt(4));
      localt.b(localCursor.getInt(5));
      localt.e(localCursor.getInt(6));
      localt.c(localCursor.getString(7));
      localt.f(localCursor.getInt(8));
      localt.g(localCursor.getInt(9));
      localt.a(localCursor.getInt(10));
      String str1 = localCursor.getString(11);
      String[] arrayOfString2 = str1.split("/");
      String str2;
      if (arrayOfString2.length == 1)
      {
        str2 = arrayOfString2[0];
        label248: localt.d(str2);
        localt.g(str1);
        localt.h(localCursor.getString(12));
        localt.f(localCursor.getString(13));
        localt.h(localCursor.getInt(14));
        localt.a(Long.parseLong(localCursor.getString(15)));
        localt.i(localCursor.getInt(16));
        localt.e(localt.d() + "_" + localt.c() + "_" + localt.a());
        localArrayList.add(localt);
        if (localCursor.getInt(17) != 1)
          break label488;
        localt.a(true);
        label415: localt.j(localCursor.getInt(18));
        if (localCursor.getInt(19) != 1)
          break label497;
        localt.c(true);
      }
      while (true)
      {
        localt.l(localCursor.getInt(20));
        localt.k(localCursor.getInt(21));
        break;
        str2 = arrayOfString2[1];
        break label248;
        label488: localt.a(false);
        break label415;
        label497: localt.c(false);
      }
    }
    localCursor.close();
    return localArrayList;
  }

  public final List a(int paramInt, String paramString)
  {
    Cursor localCursor = this.c.query("app_class", new String[] { "classid", "classname", "lessoncount", "studyCount", "laststudylessonid", "laststudylessonname", "openingtime", "endTime", "userid", "iconUrl", "teacherGroup", "classDes", "openMoney", "letter", "isOpen", "classType", "IsEnsurePass", "IsEnsurePassUser", "downtoken" }, "langs='" + paramString + "'", null, null, null, "classid asc", null);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      q localq = new q();
      localq.a(localCursor.getInt(0));
      localq.b(localCursor.getString(1));
      localq.b(localCursor.getInt(2));
      localq.c(localCursor.getInt(3));
      localq.d(localCursor.getInt(4));
      localq.a(localCursor.getString(5));
      localq.c(localCursor.getString(6));
      localq.d(localCursor.getString(7));
      localq.e(paramInt);
      localq.e(localCursor.getString(9));
      localq.g(localCursor.getString(10));
      localq.f(localCursor.getString(11));
      localq.f(1);
      localq.h(localCursor.getString(12));
      localq.j(localCursor.getString(13));
      localq.g(localCursor.getInt(14));
      localq.h(localCursor.getInt(15));
      localq.i(localCursor.getInt(16));
      localq.j(localCursor.getInt(17));
      localq.k(localCursor.getString(18));
      localq.i(paramString);
      localArrayList.add(localq);
    }
    localCursor.close();
    return localArrayList;
  }

  public final List a(int paramInt1, String paramString, int paramInt2)
  {
    Cursor localCursor = this.c.query("app_class", new String[] { "classid", "classname", "lessoncount", "studyCount", "laststudylessonid", "laststudylessonname", "openingtime", "endTime", "userid", "iconUrl", "teacherGroup", "classDes", "openMoney", "isOpen", "langs", "letter", "classType", "IsEnsurePass", "IsEnsurePassUser", "downtoken" }, "userid=" + paramInt1 + " and isOpen=1 and isexpired=" + paramInt2, null, null, null, "classid asc", paramString);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      q localq = new q();
      localq.a(localCursor.getInt(0));
      localq.b(localCursor.getString(1));
      localq.b(localCursor.getInt(2));
      localq.c(localCursor.getInt(3));
      localq.d(localCursor.getInt(4));
      localq.a(localCursor.getString(5));
      localq.c(localCursor.getString(6));
      localq.d(localCursor.getString(7));
      localq.e(localCursor.getInt(8));
      localq.e(localCursor.getString(9));
      localq.g(localCursor.getString(10));
      localq.f(localCursor.getString(11));
      localq.f(paramInt2);
      localq.h(localCursor.getString(12));
      localq.g(localCursor.getInt(13));
      localq.i(localCursor.getString(14));
      localq.j(localCursor.getString(15));
      localq.h(localCursor.getInt(16));
      localq.i(localCursor.getInt(17));
      localq.j(localCursor.getInt(18));
      localq.k(localCursor.getString(19));
      localArrayList.add(localq);
    }
    localCursor.close();
    return localArrayList;
  }

  // ERROR //
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/hjclass_mobile/b/b:c	Landroid/database/sqlite/SQLiteDatabase;
    //   4: ldc_w 293
    //   7: iconst_3
    //   8: anewarray 124	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: ldc_w 295
    //   16: aastore
    //   17: dup
    //   18: iconst_1
    //   19: ldc_w 309
    //   22: aastore
    //   23: dup
    //   24: iconst_2
    //   25: ldc_w 383
    //   28: aastore
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: invokevirtual 386	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore_1
    //   38: aload_1
    //   39: ifnull +216 -> 255
    //   42: aload_1
    //   43: invokeinterface 181 1 0
    //   48: ifeq +207 -> 255
    //   51: invokestatic 392	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   54: invokevirtual 396	java/util/Calendar:getTime	()Ljava/util/Date;
    //   57: astore_2
    //   58: aload_1
    //   59: invokeinterface 178 1 0
    //   64: pop
    //   65: aload_1
    //   66: invokeinterface 399 1 0
    //   71: ifne +184 -> 255
    //   74: aload_1
    //   75: aload_1
    //   76: ldc_w 309
    //   79: invokeinterface 403 2 0
    //   84: invokeinterface 172 2 0
    //   89: astore 4
    //   91: new 405	java/text/SimpleDateFormat
    //   94: dup
    //   95: ldc_w 407
    //   98: invokespecial 408	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   101: astore 5
    //   103: aload_2
    //   104: aload 5
    //   106: aload 4
    //   108: invokevirtual 414	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   111: invokevirtual 420	java/util/Date:compareTo	(Ljava/util/Date;)I
    //   114: istore 8
    //   116: iload 8
    //   118: ifge +74 -> 192
    //   121: aload_1
    //   122: iconst_2
    //   123: invokeinterface 147 2 0
    //   128: iconst_1
    //   129: if_icmpne +63 -> 192
    //   132: aload_1
    //   133: iconst_0
    //   134: invokeinterface 147 2 0
    //   139: istore 13
    //   141: aload_0
    //   142: getfield 26	com/hjclass_mobile/b/b:b	Landroid/database/sqlite/SQLiteDatabase;
    //   145: astore 15
    //   147: iconst_1
    //   148: anewarray 4	java/lang/Object
    //   151: astore 16
    //   153: aload 16
    //   155: iconst_0
    //   156: iload 13
    //   158: invokestatic 425	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   161: aastore
    //   162: aload 15
    //   164: ldc_w 427
    //   167: aload 16
    //   169: invokevirtual 431	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload_1
    //   173: invokeinterface 143 1 0
    //   178: pop
    //   179: goto -114 -> 65
    //   182: astore 6
    //   184: aload 6
    //   186: invokevirtual 434	java/text/ParseException:printStackTrace	()V
    //   189: goto -17 -> 172
    //   192: iload 8
    //   194: ifle -22 -> 172
    //   197: aload_1
    //   198: iconst_2
    //   199: invokeinterface 147 2 0
    //   204: ifne -32 -> 172
    //   207: aload_1
    //   208: iconst_0
    //   209: invokeinterface 147 2 0
    //   214: istore 9
    //   216: aload_0
    //   217: getfield 26	com/hjclass_mobile/b/b:b	Landroid/database/sqlite/SQLiteDatabase;
    //   220: astore 11
    //   222: iconst_1
    //   223: anewarray 4	java/lang/Object
    //   226: astore 12
    //   228: aload 12
    //   230: iconst_0
    //   231: iload 9
    //   233: invokestatic 425	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   236: aastore
    //   237: aload 11
    //   239: ldc_w 436
    //   242: aload 12
    //   244: invokevirtual 431	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: goto -75 -> 172
    //   250: astore 10
    //   252: goto -80 -> 172
    //   255: return
    //   256: astore 14
    //   258: goto -86 -> 172
    //
    // Exception table:
    //   from	to	target	type
    //   103	116	182	java/text/ParseException
    //   216	247	250	android/database/SQLException
    //   141	172	256	android/database/SQLException
  }

  public final void a(ac paramac)
  {
    int i = 1;
    if (paramac == null)
      return;
    int j = paramac.c();
    int k = paramac.a();
    int m = paramac.b();
    SQLiteDatabase localSQLiteDatabase1 = this.c;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = String.valueOf(j);
    arrayOfString[i] = String.valueOf(k);
    arrayOfString[2] = String.valueOf(m);
    Cursor localCursor = localSQLiteDatabase1.rawQuery("select id from APP_QuestionAnswer where  userid=? and classid=? and lessonid=?", arrayOfString);
    int n = localCursor.getCount();
    localCursor.close();
    if (n > 0);
    while (true)
    {
      if (i != 0)
        this.b.beginTransaction();
      try
      {
        SQLiteDatabase localSQLiteDatabase3 = this.b;
        Object[] arrayOfObject2 = new Object[4];
        arrayOfObject2[0] = paramac.d();
        arrayOfObject2[1] = Integer.valueOf(paramac.c());
        arrayOfObject2[2] = Integer.valueOf(paramac.a());
        arrayOfObject2[3] = Integer.valueOf(paramac.b());
        localSQLiteDatabase3.execSQL("update APP_QuestionAnswer set content=? where  userid=? and classid=? and lessonid=?", arrayOfObject2);
        this.b.setTransactionSuccessful();
        return;
        i = 0;
      }
      finally
      {
        this.b.endTransaction();
      }
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase2 = this.b;
      Object[] arrayOfObject1 = new Object[4];
      arrayOfObject1[0] = paramac.d();
      arrayOfObject1[1] = Integer.valueOf(paramac.c());
      arrayOfObject1[2] = Integer.valueOf(paramac.a());
      arrayOfObject1[3] = Integer.valueOf(paramac.b());
      localSQLiteDatabase2.execSQL("insert into APP_QuestionAnswer (content,userid,classid,lessonid) values(?,?,?,?)", arrayOfObject1);
      this.b.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.b.endTransaction();
    }
  }

  public final void a(r paramr)
  {
    this.b.beginTransaction();
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b;
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = paramr.c();
      arrayOfObject[1] = paramr.b();
      arrayOfObject[2] = Long.valueOf(paramr.f());
      arrayOfObject[3] = Integer.valueOf(paramr.h());
      arrayOfObject[4] = Integer.valueOf(paramr.a());
      localSQLiteDatabase.execSQL("update app_user set tokenKey=?,uniqueKey=?,lastlogin=? ,classnum=? where userid=?", arrayOfObject);
      this.b.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.b.endTransaction();
    }
  }

  public final void a(s params)
  {
    int i = 1;
    int j = params.f();
    int k = params.c();
    int m = params.d();
    SQLiteDatabase localSQLiteDatabase1 = this.c;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = String.valueOf(j);
    arrayOfString[i] = String.valueOf(k);
    arrayOfString[2] = String.valueOf(m);
    Cursor localCursor = localSQLiteDatabase1.rawQuery("select lessonid from app_download where  userid=? and classid=? and lessonid=?", arrayOfString);
    int n = localCursor.getCount();
    localCursor.close();
    if (n > 0);
    while (i != 0)
    {
      return;
      i = 0;
    }
    this.b.beginTransaction();
    try
    {
      SQLiteDatabase localSQLiteDatabase2 = this.b;
      Object[] arrayOfObject = new Object[11];
      arrayOfObject[0] = Integer.valueOf(params.d());
      arrayOfObject[1] = params.b();
      arrayOfObject[2] = params.a();
      arrayOfObject[3] = Integer.valueOf(params.c());
      arrayOfObject[4] = Integer.valueOf(params.f());
      arrayOfObject[5] = Integer.valueOf(params.e());
      arrayOfObject[6] = Integer.valueOf(params.g());
      arrayOfObject[7] = params.k();
      arrayOfObject[8] = params.j();
      arrayOfObject[9] = Long.valueOf(params.l());
      arrayOfObject[10] = Integer.valueOf(params.m());
      localSQLiteDatabase2.execSQL("insert into app_download(lessonid ,lessonname ,classname ,classid ,userid ,status ,progress ,zipname ,zipurl,filesize,lessonversion) values(?,?,?,?,?,?,?,?,?,?,?)", arrayOfObject);
      this.b.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.b.endTransaction();
    }
  }

  public final void a(t paramt)
  {
    this.b.beginTransaction();
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b;
      Object[] arrayOfObject = new Object[6];
      arrayOfObject[0] = Integer.valueOf(paramt.b());
      arrayOfObject[1] = Integer.valueOf(paramt.f());
      arrayOfObject[2] = Integer.valueOf(paramt.u());
      arrayOfObject[3] = Integer.valueOf(paramt.d());
      arrayOfObject[4] = Integer.valueOf(paramt.c());
      arrayOfObject[5] = Integer.valueOf(paramt.a());
      localSQLiteDatabase.execSQL("update app_lesson set status=? ,progress=?,studytime=studytime+? where classid=? and lessonid=? and userid=?", arrayOfObject);
      this.b.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.b.endTransaction();
    }
  }

  public final void a(u paramu)
  {
    int i = 1;
    int j = paramu.a();
    SQLiteDatabase localSQLiteDatabase1 = this.c;
    String[] arrayOfString = new String[i];
    arrayOfString[0] = String.valueOf(j);
    Cursor localCursor = localSQLiteDatabase1.rawQuery("select userid from app_Config where userid=?", arrayOfString);
    int k = localCursor.getCount();
    localCursor.close();
    int m;
    if (k > 0)
      m = i;
    while (m != 0)
    {
      this.b.beginTransaction();
      try
      {
        SQLiteDatabase localSQLiteDatabase3 = this.b;
        Object[] arrayOfObject2 = new Object[7];
        arrayOfObject2[0] = paramu.c();
        arrayOfObject2[1] = Integer.valueOf(paramu.g());
        arrayOfObject2[2] = Float.valueOf(paramu.d());
        arrayOfObject2[3] = Integer.valueOf(paramu.f());
        arrayOfObject2[4] = Integer.valueOf(paramu.e());
        if (paramu.i());
        while (true)
        {
          arrayOfObject2[5] = Integer.valueOf(i);
          arrayOfObject2[6] = Integer.valueOf(paramu.a());
          localSQLiteDatabase3.execSQL("update app_config set UserNo=?, TotalMark=?,TotalXB=?,TotalLesson=? ,TotalTime=?,IsActionCard=? where userid=?", arrayOfObject2);
          this.b.setTransactionSuccessful();
          return;
          m = 0;
          break;
          i = 0;
        }
      }
      finally
      {
        this.b.endTransaction();
      }
    }
    this.b.beginTransaction();
    try
    {
      SQLiteDatabase localSQLiteDatabase2 = this.b;
      Object[] arrayOfObject1 = new Object[8];
      arrayOfObject1[0] = Integer.valueOf(paramu.a());
      arrayOfObject1[1] = paramu.b();
      arrayOfObject1[2] = paramu.c();
      arrayOfObject1[3] = Float.valueOf(paramu.d());
      arrayOfObject1[4] = Integer.valueOf(paramu.g());
      arrayOfObject1[5] = Integer.valueOf(paramu.f());
      arrayOfObject1[6] = Integer.valueOf(paramu.e());
      if (paramu.i());
      while (true)
      {
        arrayOfObject1[7] = Integer.valueOf(i);
        localSQLiteDatabase2.execSQL("insert into app_config(userid,Username,UserNo ,TotalXB ,TotalMark,TotalLesson,TotalTime,IsActionCard) values(?,?,?,?,?,?,?,?)", arrayOfObject1);
        this.b.setTransactionSuccessful();
        return;
        i = 0;
      }
    }
    finally
    {
      this.b.endTransaction();
    }
  }

  public final void a(List paramList)
  {
    int i = paramList.size();
    if (i == 0)
      return;
    int j = 0;
    label14: t localt;
    int k;
    label48: int i3;
    if (j < i)
    {
      localt = (t)paramList.get(j);
      if (localt != null)
      {
        if (localt.j() != 1)
          break label371;
        k = 2;
        int m = localt.a();
        int n = localt.d();
        int i1 = localt.c();
        SQLiteDatabase localSQLiteDatabase1 = this.c;
        String[] arrayOfString = new String[3];
        arrayOfString[0] = String.valueOf(m);
        arrayOfString[1] = String.valueOf(n);
        arrayOfString[2] = String.valueOf(i1);
        Cursor localCursor = localSQLiteDatabase1.rawQuery("select lessonid from app_lesson where  userid=? and classid=? and lessonid=?", arrayOfString);
        int i2 = localCursor.getCount();
        localCursor.close();
        if (i2 <= 0)
          break label381;
        i3 = 1;
        label144: if (i3 == 0)
          break label387;
        SQLiteDatabase localSQLiteDatabase3 = this.b;
        Object[] arrayOfObject2 = new Object[16];
        arrayOfObject2[0] = Integer.valueOf(localt.b());
        arrayOfObject2[1] = Integer.valueOf(localt.f());
        arrayOfObject2[2] = localt.h();
        arrayOfObject2[3] = Integer.valueOf(localt.i());
        arrayOfObject2[4] = Integer.valueOf(k);
        arrayOfObject2[5] = Integer.valueOf(localt.n());
        arrayOfObject2[6] = localt.o();
        arrayOfObject2[7] = Long.valueOf(localt.r());
        arrayOfObject2[8] = Boolean.valueOf(localt.t());
        arrayOfObject2[9] = Integer.valueOf(localt.u());
        arrayOfObject2[10] = Boolean.valueOf(localt.x());
        arrayOfObject2[11] = Integer.valueOf(localt.w());
        arrayOfObject2[12] = Integer.valueOf(localt.v());
        arrayOfObject2[13] = Integer.valueOf(localt.c());
        arrayOfObject2[14] = Integer.valueOf(localt.a());
        arrayOfObject2[15] = Integer.valueOf(localt.d());
        localSQLiteDatabase3.execSQL("update app_lesson set status=? ,progress=? ,homeWork=?,studyprogress=? ,studystatus=? ,serialnum=? ,freeADUrl=? ,fileSize=?,islock=? ,studytime=studytime+?,islast=?,lessonversion=?,mediatype=? where lessonid=? and userid=? and classid=?", arrayOfObject2);
      }
    }
    while (true)
    {
      j++;
      break label14;
      break;
      label371: k = localt.j();
      break label48;
      label381: i3 = 0;
      break label144;
      label387: SQLiteDatabase localSQLiteDatabase2 = this.b;
      Object[] arrayOfObject1 = new Object[22];
      arrayOfObject1[0] = Integer.valueOf(localt.c());
      arrayOfObject1[1] = localt.g();
      arrayOfObject1[2] = localt.e();
      arrayOfObject1[3] = Integer.valueOf(localt.d());
      arrayOfObject1[4] = Integer.valueOf(localt.a());
      arrayOfObject1[5] = Integer.valueOf(localt.b());
      arrayOfObject1[6] = Integer.valueOf(localt.f());
      arrayOfObject1[7] = localt.h();
      arrayOfObject1[8] = Integer.valueOf(localt.i());
      arrayOfObject1[9] = Integer.valueOf(k);
      arrayOfObject1[10] = Double.valueOf(localt.k());
      arrayOfObject1[11] = localt.p();
      arrayOfObject1[12] = localt.q();
      arrayOfObject1[13] = Integer.valueOf(localt.n());
      arrayOfObject1[14] = localt.o();
      arrayOfObject1[15] = Long.valueOf(localt.r());
      arrayOfObject1[16] = Integer.valueOf(0);
      arrayOfObject1[17] = Boolean.valueOf(localt.t());
      arrayOfObject1[18] = Integer.valueOf(localt.u());
      arrayOfObject1[19] = Boolean.valueOf(localt.x());
      arrayOfObject1[20] = Integer.valueOf(localt.w());
      arrayOfObject1[21] = Integer.valueOf(localt.v());
      localSQLiteDatabase2.execSQL("insert into app_lesson(lessonid ,lessonname ,classname ,classid ,userid ,status ,progress ,homeWork ,studyprogress ,studystatus ,score ,zipname ,zipurl,serialnum,freeADUrl,filesize,playtime,islock,studytime,islast,lessonversion,mediatype) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", arrayOfObject1);
    }
  }

  public final r b()
  {
    Cursor localCursor = this.c.query("APP_USER", new String[] { "userid", "tokenKey", "uniqueKey", "userName", "userPassword", "classnum" }, null, null, null, null, "lastlogin desc", "1");
    localCursor.moveToFirst();
    r localr = null;
    if (localCursor != null)
    {
      int i = localCursor.getCount();
      localr = null;
      if (i > 0)
      {
        localr = new r();
        localr.a(localCursor.getInt(0));
        localr.b(localCursor.getString(1));
        localr.a(localCursor.getString(2));
        localr.d(localCursor.getString(3));
        localr.c(localCursor.getString(4));
        localr.b(localCursor.getInt(5));
      }
    }
    localCursor.close();
    return localr;
  }

  public final t b(int paramInt1, int paramInt2, int paramInt3)
  {
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString1 = new String[3];
    arrayOfString1[0] = String.valueOf(paramInt2);
    arrayOfString1[1] = String.valueOf(paramInt3);
    arrayOfString1[2] = String.valueOf(paramInt1);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select lessonid ,lessonname ,classname ,classid ,userid ,status ,progress ,homeWork ,studyprogress ,studystatus ,score ,zipname ,zipurl,freeADUrl,serialnum,fileSize,playtime,islock,studytime,islast,lessonversion,mediatype from app_lesson where lessonID=? and classID=? and (userid=? or userid=1)", arrayOfString1);
    localCursor.moveToFirst();
    Object localObject = null;
    t localt;
    String[] arrayOfString2;
    String str2;
    if (localCursor != null)
    {
      int i = localCursor.getCount();
      localObject = null;
      if (i > 0)
      {
        localt = new t();
        localt.c(localCursor.getInt(0));
        localt.b(localCursor.getString(1));
        localt.a(localCursor.getString(2));
        localt.d(localCursor.getInt(3));
        localt.a(localCursor.getInt(4));
        localt.b(localCursor.getInt(5));
        localt.e(localCursor.getInt(6));
        localt.c(localCursor.getString(7));
        localt.f(localCursor.getInt(8));
        localt.g(localCursor.getInt(9));
        localt.a(localCursor.getInt(10));
        String str1 = localCursor.getString(11);
        arrayOfString2 = str1.split("/");
        if (arrayOfString2.length != 1)
          break label504;
        str2 = arrayOfString2[0];
        localt.d(str2);
        localt.g(str1);
        localt.h(localCursor.getString(12));
        localt.f(localCursor.getString(13));
        localt.h(localCursor.getInt(14));
        localt.a(Long.parseLong(localCursor.getString(15)));
        localt.i(localCursor.getInt(16));
        localt.e(localt.d() + "_" + localt.c() + "_" + localt.a());
        if (localCursor.getInt(17) != 1)
          break label513;
        localt.a(true);
        label429: localt.j(localCursor.getInt(18));
        if (localCursor.getInt(19) != 1)
          break label522;
        localt.c(true);
      }
    }
    while (true)
    {
      localt.l(localCursor.getInt(20));
      localt.k(localCursor.getInt(21));
      localObject = localt;
      localCursor.close();
      return localObject;
      label504: str2 = arrayOfString2[1];
      break;
      label513: localt.a(false);
      break label429;
      label522: localt.c(false);
    }
  }

  public final Hashtable b(int paramInt1, int paramInt2)
  {
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = String.valueOf(paramInt1);
    arrayOfString[1] = String.valueOf(paramInt2);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select lessonid ,status ,progress,studyprogress ,studystatus ,score,playtime,isLock,studytime,islast,lessonversion,mediatype from app_lesson where userid=? and classid=? order by serialnum asc", arrayOfString);
    Hashtable localHashtable = new Hashtable();
    if (localCursor.moveToNext())
    {
      t localt = new t();
      localt.a(paramInt1);
      localt.d(paramInt2);
      localt.c(localCursor.getInt(0));
      localt.e(localt.d() + "_" + localt.c() + "_" + localt.a());
      localt.b(localCursor.getInt(1));
      localt.e(localCursor.getInt(2));
      localt.f(localCursor.getInt(3));
      localt.g(localCursor.getInt(4));
      localt.a(localCursor.getInt(5));
      localt.i(localCursor.getInt(6));
      if (localCursor.getInt(7) == 1)
      {
        localt.a(true);
        label241: localt.j(localCursor.getInt(8));
        if (localCursor.getInt(9) != 1)
          break label330;
        localt.c(true);
      }
      while (true)
      {
        localt.l(localCursor.getInt(10));
        localt.k(localCursor.getInt(11));
        localHashtable.put(Integer.valueOf(localt.c()), localt);
        break;
        localt.a(false);
        break label241;
        label330: localt.c(false);
      }
    }
    localCursor.close();
    return localHashtable;
  }

  public final List b(int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString1 = new String[2];
    arrayOfString1[0] = "1";
    arrayOfString1[1] = String.valueOf(paramInt);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select lessonid ,lessonname ,classname ,classid ,userid ,status ,progress ,homeWork ,studyprogress ,studystatus ,score ,zipname ,zipurl,freeADUrl,serialnum,fileSize,playtime,islock,studytime,islast,lessonversion,mediatype from app_lesson where userid=? and classid=?  order by serialnum asc", arrayOfString1);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    if (localCursor.moveToNext())
    {
      t localt = new t();
      localt.c(localCursor.getInt(0));
      localt.b(localCursor.getString(1));
      localt.a(localCursor.getString(2));
      localt.d(localCursor.getInt(3));
      localt.a(localCursor.getInt(4));
      localt.b(localCursor.getInt(5));
      localt.e(localCursor.getInt(6));
      localt.c(localCursor.getString(7));
      localt.f(localCursor.getInt(8));
      localt.g(localCursor.getInt(9));
      localt.a(localCursor.getInt(10));
      String str1 = localCursor.getString(11);
      String[] arrayOfString2 = str1.split("/");
      String str2;
      if (arrayOfString2.length == 1)
      {
        str2 = arrayOfString2[0];
        label261: localt.d(str2);
        localt.g(str1);
        localt.h(localCursor.getString(12));
        localt.f(localCursor.getString(13));
        localt.h(localCursor.getInt(14));
        localt.a(Long.parseLong(localCursor.getString(15)));
        localt.i(localCursor.getInt(16));
        localt.e(localt.d() + "_" + localt.c() + "_" + localt.a());
        if (!localt.o().equals(""))
          break label515;
        localArrayList3.add(localt);
        label423: if (localCursor.getInt(17) != 1)
          break label528;
        localt.a(true);
        label442: localt.j(localCursor.getInt(18));
        if (localCursor.getInt(19) != 1)
          break label537;
        localt.c(true);
      }
      while (true)
      {
        localt.l(localCursor.getInt(20));
        localt.k(localCursor.getInt(21));
        break;
        str2 = arrayOfString2[1];
        break label261;
        label515: localArrayList2.add(localt);
        break label423;
        label528: localt.a(false);
        break label442;
        label537: localt.c(false);
      }
    }
    localArrayList1.add(localArrayList2);
    localArrayList1.add(localArrayList3);
    localCursor.close();
    return localArrayList1;
  }

  public final void b(r paramr)
  {
    int i = 1;
    int j = paramr.a();
    SQLiteDatabase localSQLiteDatabase1 = this.c;
    String[] arrayOfString = new String[i];
    arrayOfString[0] = String.valueOf(j);
    Cursor localCursor = localSQLiteDatabase1.rawQuery("select userid from app_user where userid=?", arrayOfString);
    int k = localCursor.getCount();
    localCursor.close();
    if (k > 0);
    while (true)
    {
      if (i != 0)
        this.b.beginTransaction();
      try
      {
        SQLiteDatabase localSQLiteDatabase3 = this.b;
        Object[] arrayOfObject2 = new Object[7];
        arrayOfObject2[0] = paramr.c();
        arrayOfObject2[1] = paramr.b();
        arrayOfObject2[2] = paramr.d();
        arrayOfObject2[3] = Long.valueOf(paramr.f());
        arrayOfObject2[4] = Integer.valueOf(paramr.h());
        arrayOfObject2[5] = hjapp.com.hjclass_mobile.h.z.b(paramr.d());
        arrayOfObject2[6] = Integer.valueOf(paramr.a());
        localSQLiteDatabase3.execSQL("update app_user set tokenKey=?,uniqueKey=?,userPassword=? ,lastlogin=? ,classnum=?,usermd5=? where userid=?", arrayOfObject2);
        this.b.setTransactionSuccessful();
        return;
        i = 0;
      }
      finally
      {
        this.b.endTransaction();
      }
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase2 = this.b;
      Object[] arrayOfObject1 = new Object[8];
      arrayOfObject1[0] = Integer.valueOf(paramr.a());
      arrayOfObject1[1] = paramr.c();
      arrayOfObject1[2] = paramr.b();
      arrayOfObject1[3] = paramr.e();
      arrayOfObject1[4] = paramr.d();
      arrayOfObject1[5] = Long.valueOf(paramr.f());
      arrayOfObject1[6] = Integer.valueOf(paramr.h());
      arrayOfObject1[7] = hjapp.com.hjclass_mobile.h.z.b(paramr.d());
      localSQLiteDatabase2.execSQL("insert into app_user(userid,tokenKey,uniqueKey,userName,userPassword,lastlogin,classnum,usermd5) values(?,?,?,?,?,?,?,?)", arrayOfObject1);
      this.b.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.b.endTransaction();
    }
  }

  public final void b(s params)
  {
    this.b.beginTransaction();
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b;
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(params.e());
      arrayOfObject[1] = Integer.valueOf(params.c());
      arrayOfObject[2] = Integer.valueOf(params.d());
      arrayOfObject[3] = Integer.valueOf(params.f());
      localSQLiteDatabase.execSQL("update app_download set status=? where classid=? and lessonid=? and userid=?", arrayOfObject);
      this.b.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.b.endTransaction();
    }
  }

  public final void b(t paramt)
  {
    this.b.beginTransaction();
    try
    {
      Log.i("======", "update study progress");
      SQLiteDatabase localSQLiteDatabase = this.b;
      Object[] arrayOfObject = new Object[6];
      arrayOfObject[0] = Integer.valueOf(paramt.i());
      arrayOfObject[1] = Integer.valueOf(paramt.s());
      arrayOfObject[2] = Integer.valueOf(paramt.u());
      arrayOfObject[3] = Integer.valueOf(paramt.d());
      arrayOfObject[4] = Integer.valueOf(paramt.c());
      arrayOfObject[5] = Integer.valueOf(paramt.a());
      localSQLiteDatabase.execSQL("update app_lesson set studyprogress=?, playtime=?,studytime=studytime+? where classid=? and lessonid=? and userid=?", arrayOfObject);
      this.b.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.b.endTransaction();
    }
  }

  public final void b(List paramList)
  {
    if (!hjapp.com.hjclass_mobile.h.z.j);
    int i;
    do
    {
      return;
      i = paramList.size();
    }
    while (i == 0);
    int j = 0;
    label20: q localq;
    int k;
    int i1;
    if (j < i)
    {
      localq = (q)paramList.get(j);
      k = localq.h();
      int m = localq.a();
      SQLiteDatabase localSQLiteDatabase1 = this.c;
      String[] arrayOfString = new String[2];
      arrayOfString[0] = String.valueOf(k);
      arrayOfString[1] = String.valueOf(m);
      Cursor localCursor = localSQLiteDatabase1.rawQuery("select classid from app_class where  userid=? and classid=?", arrayOfString);
      int n = localCursor.getCount();
      localCursor.close();
      if (n <= 0)
        break label339;
      i1 = 1;
      label117: if (i1 == 0)
        break label345;
      SQLiteDatabase localSQLiteDatabase3 = this.b;
      Object[] arrayOfObject2 = new Object[17];
      arrayOfObject2[0] = Integer.valueOf(localq.b());
      arrayOfObject2[1] = Integer.valueOf(localq.c());
      arrayOfObject2[2] = localq.d();
      arrayOfObject2[3] = Integer.valueOf(localq.e());
      arrayOfObject2[4] = localq.j();
      arrayOfObject2[5] = localq.l();
      arrayOfObject2[6] = localq.k();
      arrayOfObject2[7] = Integer.valueOf(localq.m());
      arrayOfObject2[8] = Integer.valueOf(localq.o());
      arrayOfObject2[9] = localq.p();
      arrayOfObject2[10] = localq.q();
      arrayOfObject2[11] = Integer.valueOf(localq.r());
      arrayOfObject2[12] = Integer.valueOf(localq.s());
      arrayOfObject2[13] = Integer.valueOf(localq.t());
      arrayOfObject2[14] = localq.u();
      arrayOfObject2[15] = Integer.valueOf(k);
      arrayOfObject2[16] = Integer.valueOf(m);
      localSQLiteDatabase3.execSQL("update app_class set lessonCount=?,studyCount=?,lastStudyLessonName=?,lastStudyLessonId=? ,iconUrl=?, teacherGroup=?,classDes=? ,isexpired =? ,isOpen=? ,langs=?,letter=?,classtype=?,IsEnsurePass=?,IsEnsurePassUser=?,downtoken=? where userid=? and classid=?", arrayOfObject2);
    }
    while (true)
    {
      j++;
      break label20;
      break;
      label339: i1 = 0;
      break label117;
      label345: SQLiteDatabase localSQLiteDatabase2 = this.b;
      Object[] arrayOfObject1 = new Object[22];
      arrayOfObject1[0] = Integer.valueOf(localq.a());
      arrayOfObject1[1] = localq.f();
      arrayOfObject1[2] = Integer.valueOf(localq.b());
      arrayOfObject1[3] = Integer.valueOf(localq.c());
      arrayOfObject1[4] = localq.d();
      arrayOfObject1[5] = Integer.valueOf(localq.e());
      arrayOfObject1[6] = localq.g();
      arrayOfObject1[7] = localq.i();
      arrayOfObject1[8] = Integer.valueOf(k);
      arrayOfObject1[9] = Integer.valueOf(0);
      arrayOfObject1[10] = localq.j();
      arrayOfObject1[11] = localq.l();
      arrayOfObject1[12] = localq.k();
      arrayOfObject1[13] = Integer.valueOf(localq.m());
      arrayOfObject1[14] = localq.n();
      arrayOfObject1[15] = Integer.valueOf(localq.o());
      arrayOfObject1[16] = localq.p();
      arrayOfObject1[17] = localq.q();
      arrayOfObject1[18] = Integer.valueOf(localq.r());
      arrayOfObject1[19] = Integer.valueOf(localq.s());
      arrayOfObject1[20] = Integer.valueOf(localq.t());
      arrayOfObject1[21] = localq.u();
      localSQLiteDatabase2.execSQL("insert into app_class(classid,classname,lessonCount,studyCount,lastStudyLessonName,lastStudyLessonId,openingTime,endTime,userid,status,iconUrl,teacherGroup,classDes,isexpired,openMoney,isOpen,langs,letter,classtype,IsEnsurePass,IsEnsurePassUser,downtoken) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", arrayOfObject1);
    }
  }

  public final t c(int paramInt1, int paramInt2, int paramInt3)
  {
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString1 = new String[3];
    arrayOfString1[0] = String.valueOf(paramInt1);
    arrayOfString1[1] = String.valueOf(paramInt2);
    arrayOfString1[2] = String.valueOf(paramInt3);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select lessonid ,lessonname ,classname ,classid ,userid ,status ,progress ,homeWork ,studyprogress ,studystatus ,score ,zipname ,zipurl,freeADUrl,serialnum,fileSize,playtime,islock,studytime,islast,lessonversion,mediatype from app_lesson where userid=? and classid=? and lessonid=? ", arrayOfString1);
    localCursor.moveToFirst();
    Object localObject = null;
    t localt;
    String[] arrayOfString2;
    String str2;
    if (localCursor != null)
    {
      int i = localCursor.getCount();
      localObject = null;
      if (i > 0)
      {
        localt = new t();
        localt.c(localCursor.getInt(0));
        localt.b(localCursor.getString(1));
        localt.a(localCursor.getString(2));
        localt.d(localCursor.getInt(3));
        localt.a(localCursor.getInt(4));
        localt.b(localCursor.getInt(5));
        localt.e(localCursor.getInt(6));
        localt.c(localCursor.getString(7));
        localt.f(localCursor.getInt(8));
        localt.g(localCursor.getInt(9));
        localt.a(localCursor.getInt(10));
        String str1 = localCursor.getString(11);
        arrayOfString2 = str1.split("/");
        if (arrayOfString2.length != 1)
          break label504;
        str2 = arrayOfString2[0];
        localt.d(str2);
        localt.g(str1);
        localt.h(localCursor.getString(12));
        localt.f(localCursor.getString(13));
        localt.h(localCursor.getInt(14));
        localt.a(Long.parseLong(localCursor.getString(15)));
        localt.i(localCursor.getInt(16));
        localt.e(localt.d() + "_" + localt.c() + "_" + localt.a());
        if (localCursor.getInt(17) != 1)
          break label513;
        localt.a(true);
        label429: localt.j(localCursor.getInt(18));
        if (localCursor.getInt(19) != 1)
          break label522;
        localt.c(true);
      }
    }
    while (true)
    {
      localt.l(localCursor.getInt(20));
      localt.k(localCursor.getInt(21));
      localObject = localt;
      localCursor.close();
      return localObject;
      label504: str2 = arrayOfString2[1];
      break;
      label513: localt.a(false);
      break label429;
      label522: localt.c(false);
    }
  }

  public final String c(int paramInt1, int paramInt2)
  {
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = String.valueOf(paramInt2);
    arrayOfString[1] = String.valueOf(paramInt1);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select downtoken from app_class where  userid=? and classid=?", arrayOfString);
    boolean bool = localCursor.moveToFirst();
    String str = null;
    if (bool)
      str = localCursor.getString(0);
    localCursor.close();
    return str;
  }

  public final void c(int paramInt)
  {
    this.b.beginTransaction();
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      localSQLiteDatabase.execSQL("update app_user set userPassword='' where userid=?", arrayOfObject);
      this.b.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.b.endTransaction();
    }
  }

  public final void c(s params)
  {
    this.b.beginTransaction();
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b;
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(params.g());
      arrayOfObject[1] = Integer.valueOf(params.c());
      arrayOfObject[2] = Integer.valueOf(params.d());
      arrayOfObject[3] = Integer.valueOf(params.f());
      localSQLiteDatabase.execSQL("update app_download set progress=? where classid=? and lessonid=? and userid=?", arrayOfObject);
      this.b.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.b.endTransaction();
    }
  }

  public final void c(t paramt)
  {
    this.b.beginTransaction();
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b;
      Object[] arrayOfObject = new Object[7];
      arrayOfObject[0] = Integer.valueOf(paramt.i());
      arrayOfObject[1] = Integer.valueOf(paramt.s());
      arrayOfObject[2] = Integer.valueOf(paramt.u());
      arrayOfObject[3] = Double.valueOf(paramt.k());
      arrayOfObject[4] = Integer.valueOf(paramt.d());
      arrayOfObject[5] = Integer.valueOf(paramt.c());
      arrayOfObject[6] = Integer.valueOf(paramt.a());
      localSQLiteDatabase.execSQL("update app_lesson set studystatus=1, studyprogress=?, playtime=?,studytime=studytime+? ,score=? where classid=? and lessonid=? and userid=?", arrayOfObject);
      this.b.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.b.endTransaction();
    }
  }

  public final u d(int paramInt)
  {
    int i = 1;
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString = new String[i];
    arrayOfString[0] = String.valueOf(paramInt);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select userid,Username,UserNo ,TotalXB ,TotalMark,TotalLesson,TotalTime,IsActionCard from app_config where userid=?", arrayOfString);
    localCursor.moveToFirst();
    u localu2;
    if ((localCursor != null) && (localCursor.getCount() > 0))
    {
      localu2 = new u();
      localu2.a(localCursor.getInt(0));
      localu2.a(localCursor.getString(i));
      localu2.b(localCursor.getString(2));
      localu2.a(localCursor.getInt(3));
      localu2.d(localCursor.getInt(4));
      localu2.c(localCursor.getInt(5));
      localu2.b(localCursor.getInt(6));
      if (localCursor.getInt(7) == i)
        localu2.a(i);
    }
    for (u localu1 = localu2; ; localu1 = null)
    {
      localCursor.close();
      return localu1;
      int j = 0;
      break;
    }
  }

  public final void d(int paramInt1, int paramInt2, int paramInt3)
  {
    SQLiteDatabase localSQLiteDatabase = this.b;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(paramInt3);
    arrayOfObject[1] = Integer.valueOf(paramInt1);
    arrayOfObject[2] = Integer.valueOf(paramInt2);
    localSQLiteDatabase.execSQL("update app_lesson set islock=0 where classid=? and lessonid=? and userid=?", arrayOfObject);
  }

  public final void d(s params)
  {
    this.b.beginTransaction();
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b;
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(params.e());
      arrayOfObject[1] = Integer.valueOf(params.c());
      arrayOfObject[2] = Integer.valueOf(params.d());
      arrayOfObject[3] = Integer.valueOf(params.f());
      localSQLiteDatabase.execSQL("update app_lesson set status=? where classid=? and lessonid=? and userid=?", arrayOfObject);
      this.b.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.b.endTransaction();
    }
  }

  public final boolean d(int paramInt1, int paramInt2)
  {
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = String.valueOf(paramInt2);
    arrayOfString[1] = String.valueOf(paramInt1);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select classtype  from app_class where userid=? and classid=? and isexpired=0", arrayOfString);
    for (int i = -1; localCursor.moveToNext(); i = localCursor.getInt(0));
    localCursor.close();
    return i == 2;
  }

  public final int e(int paramInt1, int paramInt2)
  {
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = String.valueOf(paramInt2);
    arrayOfString[1] = String.valueOf(paramInt1);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select lessonid  from app_lesson where userid=? and classid=? and islock=1 and studystatus=0 order by serialnum asc limit 1 ", arrayOfString);
    for (int i = -1; localCursor.moveToNext(); i = localCursor.getInt(0));
    localCursor.close();
    return i;
  }

  public final List e(int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString1 = new String[1];
    arrayOfString1[0] = String.valueOf(paramInt);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select lessonid ,lessonname ,classname ,classid ,userid ,status ,progress ,zipname ,zipurl,filesize,lessonversion from app_download where userid=? or userid=1", arrayOfString1);
    ArrayList localArrayList = new ArrayList();
    if (localCursor.moveToNext())
    {
      s locals = new s();
      locals.b(localCursor.getInt(0));
      locals.b(localCursor.getString(1));
      locals.a(localCursor.getString(2));
      locals.a(localCursor.getInt(3));
      locals.d(localCursor.getInt(4));
      int i = localCursor.getInt(5);
      label148: String str1;
      String[] arrayOfString2;
      if ((i == 4) || (i == 1))
      {
        locals.c(5);
        locals.e(localCursor.getInt(6));
        str1 = localCursor.getString(7);
        if (str1 != null)
        {
          arrayOfString2 = str1.split("/");
          if (arrayOfString2.length != 1)
            break label333;
        }
      }
      label333: for (String str2 = arrayOfString2[0]; ; str2 = arrayOfString2[1])
      {
        locals.c(str2);
        locals.f(str1);
        locals.e(localCursor.getString(8));
        locals.a(Long.parseLong(localCursor.getString(9)));
        locals.d(locals.c() + "_" + locals.d() + "_" + locals.f());
        locals.f(localCursor.getInt(10));
        localArrayList.add(locals);
        break;
        locals.c(i);
        break label148;
      }
    }
    localCursor.close();
    return localArrayList;
  }

  public final void e(int paramInt1, int paramInt2, int paramInt3)
  {
    Log.i("delete", "classid=" + paramInt2 + "lessonid=" + paramInt3 + "userid=" + paramInt1);
    SQLiteDatabase localSQLiteDatabase = this.b;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    arrayOfObject[1] = Integer.valueOf(paramInt2);
    arrayOfObject[2] = Integer.valueOf(paramInt3);
    localSQLiteDatabase.execSQL("delete from app_download where userid=? and classid=? and lessonid=?", arrayOfObject);
  }

  public final int f(int paramInt1, int paramInt2)
  {
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = String.valueOf(paramInt1);
    arrayOfString[1] = String.valueOf(paramInt2);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select lessonid from app_lesson where  userid=? and classid=? and studystatus=1", arrayOfString);
    int i = localCursor.getCount();
    localCursor.close();
    return i;
  }

  public final int f(int paramInt1, int paramInt2, int paramInt3)
  {
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = String.valueOf(paramInt1);
    arrayOfString[1] = String.valueOf(paramInt2);
    arrayOfString[2] = String.valueOf(paramInt3);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select studystatus from app_lesson where  userid=? and classid=? and lessonid=?", arrayOfString);
    boolean bool = localCursor.moveToFirst();
    int i = 0;
    if (bool)
      i = localCursor.getInt(0);
    localCursor.close();
    return i;
  }

  public final List f(int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString1 = new String[1];
    arrayOfString1[0] = String.valueOf(paramInt);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select lessonid ,lessonname ,classname ,classid ,userid ,status ,progress ,zipname ,zipurl,filesize,lessonversion from app_download where userid=? or userid=1", arrayOfString1);
    ArrayList localArrayList = new ArrayList();
    if (localCursor.moveToNext())
    {
      s locals = new s();
      locals.b(localCursor.getInt(0));
      locals.b(localCursor.getString(1));
      locals.a(localCursor.getString(2));
      locals.a(localCursor.getInt(3));
      locals.d(localCursor.getInt(4));
      locals.c(localCursor.getInt(5));
      locals.e(localCursor.getInt(6));
      String str1 = localCursor.getString(7);
      String[] arrayOfString2;
      if (str1 != null)
      {
        arrayOfString2 = str1.split("/");
        if (arrayOfString2.length != 1)
          break label308;
      }
      label308: for (String str2 = arrayOfString2[0]; ; str2 = arrayOfString2[1])
      {
        locals.c(str2);
        locals.f(str1);
        locals.e(localCursor.getString(8));
        locals.d(locals.c() + "_" + locals.d() + "_" + locals.f());
        locals.a(Long.parseLong(localCursor.getString(9)));
        locals.f(localCursor.getInt(10));
        localArrayList.add(locals);
        break;
      }
    }
    localCursor.close();
    return localArrayList;
  }

  public final int g(int paramInt1, int paramInt2, int paramInt3)
  {
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = String.valueOf(paramInt1);
    arrayOfString[1] = String.valueOf(paramInt2);
    arrayOfString[2] = String.valueOf(paramInt3);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select studytime from app_lesson where  userid=? and classid=? and lessonid=?", arrayOfString);
    boolean bool = localCursor.moveToFirst();
    int i = 0;
    if (bool)
      i = localCursor.getInt(0);
    localCursor.close();
    return i;
  }

  public final void g(int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.b;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    arrayOfObject[1] = Integer.valueOf(2);
    localSQLiteDatabase.execSQL("delete from app_download where userid=? and status=?", arrayOfObject);
  }

  public final void g(int paramInt1, int paramInt2)
  {
    this.b.beginTransaction();
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(paramInt1);
      arrayOfObject[1] = Integer.valueOf(paramInt1);
      arrayOfObject[2] = Integer.valueOf(paramInt2);
      localSQLiteDatabase.execSQL("update app_class set StudyCount=? where classid=? and userid=?", arrayOfObject);
      this.b.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.b.endTransaction();
    }
  }

  public final List h(int paramInt1, int paramInt2, int paramInt3)
  {
    SAXReader localSAXReader = new SAXReader();
    String str = i(paramInt1, paramInt2, paramInt3);
    if (str == null)
      return null;
    try
    {
      List localList = a(localSAXReader.read(new ByteArrayInputStream(str.getBytes("utf-8"))));
      return localList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  public final void h(int paramInt)
  {
    this.b.beginTransaction();
    SQLiteDatabase localSQLiteDatabase = this.b;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    localSQLiteDatabase.execSQL("delete from app_download where userid=?", arrayOfObject);
    this.b.setTransactionSuccessful();
    this.b.endTransaction();
  }

  public final boolean h(int paramInt1, int paramInt2)
  {
    SQLiteDatabase localSQLiteDatabase = this.b;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = Integer.toString(paramInt1);
    arrayOfString[1] = Integer.toString(paramInt2);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select isexpired from app_class where userid=? and classid=?", arrayOfString);
    if ((localCursor != null) && (localCursor.getCount() > 0))
    {
      localCursor.moveToFirst();
      int i = localCursor.getInt(0);
      hjapp.com.hjclass_mobile.h.u.b("是否过期", "isExpired=" + i);
      if (i == 1)
        return true;
    }
    return false;
  }

  public final String i(int paramInt1, int paramInt2, int paramInt3)
  {
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = String.valueOf(paramInt1);
    arrayOfString[1] = String.valueOf(paramInt2);
    arrayOfString[2] = String.valueOf(paramInt3);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select content from APP_QuestionAnswer where  userid=? and classid=? and lessonid=?", arrayOfString);
    boolean bool = localCursor.moveToFirst();
    String str = null;
    if (bool)
      str = localCursor.getString(0);
    localCursor.close();
    return str;
  }

  public final void i(int paramInt)
  {
    this.b.beginTransaction();
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(6);
      arrayOfObject[1] = Integer.valueOf(0);
      arrayOfObject[2] = Integer.valueOf(paramInt);
      localSQLiteDatabase.execSQL("update app_lesson set status=?,progress=? where userid=? and status!=3", arrayOfObject);
      this.b.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.b.endTransaction();
    }
  }

  public final void i(int paramInt1, int paramInt2)
  {
    this.b.beginTransaction();
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b;
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(6);
      arrayOfObject[1] = Integer.valueOf(0);
      arrayOfObject[2] = Integer.valueOf(paramInt1);
      arrayOfObject[3] = Integer.valueOf(paramInt2);
      localSQLiteDatabase.execSQL("update app_lesson set status=?,progress=? where userid=? and status=?", arrayOfObject);
      this.b.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.b.endTransaction();
    }
  }

  public final String j(int paramInt1, int paramInt2)
  {
    List localList = null;
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = String.valueOf(paramInt1);
    arrayOfString[1] = String.valueOf(paramInt2);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select lessonid,studytime,lessonversion,score from app_lesson where userid=? and classid=? and studystatus=1 and islock=0 order by serialnum asc", arrayOfString);
    if ((localCursor == null) || ((localCursor != null) && (localCursor.getCount() == 0)))
      return null;
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("ClassID", paramInt2);
    localJSONObject1.put("UserID", paramInt1);
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (true)
      if (localCursor.moveToNext())
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("LessonID", localCursor.getInt(0));
        if (localCursor.getInt(1) == 0)
        {
          localJSONObject2.put("StudyTime", 600);
          label164: if (localCursor.getInt(2) == 4)
            if ((i == 0) && (localList == null))
              localList = l(paramInt1, paramInt2);
        }
        try
        {
          if (localList.size() > 0)
            localJSONObject2.put("MyAnswer", localList.get(i));
          while (true)
          {
            localJSONObject2.put("StudyRate", localCursor.getDouble(3));
            i++;
            localJSONArray.put(localJSONObject2);
            break;
            localJSONObject2.put("StudyTime", localCursor.getInt(1));
            break label164;
            localJSONObject2.put("MyAnswer", "");
          }
        }
        catch (Exception localException)
        {
          while (true)
          {
            localException.printStackTrace();
            localJSONObject2.put("MyAnswer", "");
          }
        }
      }
    localJSONObject1.put("LessonList", localJSONArray);
    localCursor.close();
    return localJSONObject1.toString();
  }

  public final int k(int paramInt1, int paramInt2)
  {
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = String.valueOf(paramInt1);
    arrayOfString[1] = String.valueOf(paramInt2);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select id from app_class where  userid=? and isexpired=?", arrayOfString);
    int i = localCursor.getCount();
    localCursor.close();
    return i;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     b
 * JD-Core Version:    0.6.2
 */