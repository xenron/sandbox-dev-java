package hjapp.com.hjclass_mobile.pkg_b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public final class e
{
  protected c a;
  private SQLiteDatabase b;
  private SQLiteDatabase c;

  public e(Context paramContext)
  {
    this.a = c.a(paramContext);
    this.b = c.a();
    this.c = c.b();
  }

  public final void a(int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.b;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    localSQLiteDatabase.execSQL("delete from filedownlog where userid=?", arrayOfObject);
  }

  public final void a(String paramString, long[] paramArrayOfLong, int paramInt)
  {
    this.b.beginTransaction();
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b;
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Long.valueOf(paramArrayOfLong[0]);
      arrayOfObject[2] = Long.valueOf(paramArrayOfLong[1]);
      arrayOfObject[3] = Integer.valueOf(paramInt);
      localSQLiteDatabase.execSQL("insert into filedownlog(downpath, threadid, downlength,userid) values(?,?,?,?)", arrayOfObject);
      this.b.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.b.endTransaction();
    }
  }

  public final int[] a(String paramString, int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.c;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramString;
    arrayOfString[1] = String.valueOf(paramInt);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select threadid, downlength from filedownlog where downpath=? and userid=?", arrayOfString);
    int[] arrayOfInt = new int[2];
    while (localCursor.moveToNext())
    {
      arrayOfInt[0] = localCursor.getInt(0);
      arrayOfInt[1] = localCursor.getInt(1);
    }
    localCursor.close();
    return arrayOfInt;
  }

  public final void b(String paramString, int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.b;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    localSQLiteDatabase.execSQL("delete from filedownlog where downpath=? and userid=?", arrayOfObject);
  }

  public final void b(String paramString, long[] paramArrayOfLong, int paramInt)
  {
    this.b.beginTransaction();
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b;
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Long.valueOf(paramArrayOfLong[0]);
      arrayOfObject[1] = paramString;
      arrayOfObject[2] = Long.valueOf(paramArrayOfLong[1]);
      arrayOfObject[3] = Integer.valueOf(paramInt);
      localSQLiteDatabase.execSQL("update filedownlog set downlength=? where downpath=? and threadid=? and userid=?", arrayOfObject);
      this.b.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.b.endTransaction();
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     e
 * JD-Core Version:    0.6.2
 */