package hjapp.com.hjclass_mobile.pkg_b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class c extends SQLiteOpenHelper
{
  private static c a = null;
  private static SQLiteDatabase b = null;
  private static SQLiteDatabase c = null;

  private c(Context paramContext)
  {
    super(paramContext, "hj_download.db", null, 14);
  }

  public static SQLiteDatabase a()
  {
    if ((b == null) && (a != null))
      b = a.getWritableDatabase();
    return b;
  }

  public static c a(Context paramContext)
  {
    if (a == null)
      a = new c(paramContext);
    return a;
  }

  public static SQLiteDatabase b()
  {
    if ((c == null) && (a != null))
      c = a.getReadableDatabase();
    return c;
  }

  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS APP_lesson (id integer primary key autoincrement,lessonid INTEGER, lessonname VARCHAR(200),classname VARCHAR(200),classid INTEGER,userid INTEGER,status INTEGER,progress INTEGER,homeWork text,studyprogress INTEGER,studystatus INTEGER,score INTEGER,zipname VARCHAR(100),zipurl text,serialnum INTEGER,freeadurl text,filesize text,playtime int,islock INTEGER,studytime INTEGER,iscommnet INTEGER,islast INTEGER,mediatype INTEGER,lessonversion INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS filedownlog (id INTEGER primary key autoincrement, downpath VARCHAR(100), threadid INTEGER, downlength INTEGER,userid INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS APP_CLASS  (id integer primary key autoincrement,classID INTEGER ,classname VARCHAR(200),lessoncount INTEGER,studycount INTEGER,laststudylessonname VARCHAR(200),laststudylessonid INTEGER,openingTime VARCHAR(32),endTime VARCHAR(32),status INTEGER,userid INTEGER,iconUrl text,teacherGroup text,classDes text,isexpired INTEGER,openMoney text,isOpen INTEGER,langs TEXT,Letter CHAR,classtype INTEGER,IsEnsurePass INTEGER,IsEnsurePassUser INTEGER,downtoken CHAR)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS APP_USER (userid INTEGER primary key,username VARCHAR(100),tokenKey VARCHAR(100),uniquekey VARCHAR(100),userpassword VARCHAR(100),lastlogin INTEGER,classnum INTEGER,usermd5 VARCHAR(100))");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS APP_CONFIG (userid INTEGER primary key,Username VARCHAR(32),UserNo VARCHAR(32),TotalXB NUMBER,TotalMark INTEGER,TotalLesson INTEGER,TotalTime INTEGER,IsActionCard INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS app_download (id integer primary key autoincrement,lessonid INTEGER ,lessonname VARCHAR(200),classname VARCHAR(200),classid INTEGER,userid INTEGER,status INTEGER,progress INTEGER,zipname VARCHAR(100),zipurl text,filesize text,lessonversion INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS app_recommend (id INTEGER primary key autoincrement, marketurl VARCHAR(500), appname VARCHAR(200), app_desc text,app_icon varchar(200))");
    paramSQLiteDatabase.execSQL("CREATE INDEX [index_class] ON [APP_CLASS] ([userid])");
    paramSQLiteDatabase.execSQL("CREATE INDEX [index_lesson] ON [APP_lesson] ([lessonid], [classid],[userid])");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS APP_QuestionAnswer (id integer primary key autoincrement,classID INTEGER,lessonid INTEGER,userid INTEGER,content text)");
  }

  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 14)
      paramSQLiteDatabase.execSQL("ALTER TABLE APP_class ADD downtoken CHAR");
    if (paramInt1 < 13)
      paramSQLiteDatabase.execSQL("DELETE FROM filedownlog");
    if (paramInt1 < 12)
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE APP_lesson ADD iscommnet INTEGER");
      paramSQLiteDatabase.execSQL("ALTER TABLE APP_lesson ADD islast INTEGER");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS APP_QuestionAnswer (id integer primary key autoincrement,classID INTEGER,lessonid INTEGER,userid INTEGER,content text)");
      paramSQLiteDatabase.execSQL("ALTER TABLE APP_lesson ADD mediatype INTEGER");
      paramSQLiteDatabase.execSQL("ALTER TABLE APP_lesson ADD lessonversion INTEGER");
      paramSQLiteDatabase.execSQL("ALTER TABLE app_download ADD lessonversion INTEGER");
      paramSQLiteDatabase.execSQL("CREATE INDEX [index_class] ON [APP_CLASS] ([userid])");
      paramSQLiteDatabase.execSQL("CREATE INDEX [index_lesson] ON [APP_lesson] ([lessonid], [classid],[userid])");
      return;
    }
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS app_lesson");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS app_class");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS app_user");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS app_cofnig");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS filedownlog");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS app_download");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS app_recommend");
    onCreate(paramSQLiteDatabase);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     c
 * JD-Core Version:    0.6.2
 */