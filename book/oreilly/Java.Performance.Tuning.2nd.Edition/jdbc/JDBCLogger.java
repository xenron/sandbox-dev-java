package tuning.jdbc;

import java.util.*;

public class JDBCLogger
{
  private static Hashtable QueryTime = new Hashtable();

  public static void startLogSqlQuery(Thread t, String sql)
  {
     if (QueryTime.get(t) != null)
       System.out.println("WARNING: overwriting sql query log time for " + sql);
     QueryTime.put(t, new Long(System.currentTimeMillis()));
  }

  public static void endLogSqlQuery(Thread t, String sql)
  {
     long time = System.currentTimeMillis();
     time -= ((Long) QueryTime.get(t)).longValue();
     System.out.println("Time: " + time + " millis for SQL query " + sql);
     QueryTime.remove(t);
  }

  public static void startLogSqlNext(Thread t, String sql) {}
  public static void endLogSqlNext(Thread t, String sql) {}

}
/*
public class JDBCLogger
{
  public static void startLogSqlQuery(Thread t, String sql) {}
  public static void endLogSqlQuery(Thread t, String sql) {}
  public static void startLogSqlNext(Thread t, String sql) {}
  public static void endLogSqlNext(Thread t, String sql) {}

}
*/
