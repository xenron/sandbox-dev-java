package tuning.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.util.Map;
import java.sql.SQLWarning;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.ResultSetMetaData;
import java.sql.Array;
import java.io.InputStream;
import java.math.BigDecimal;
import java.io.Reader;
import java.sql.Date;
import java.util.Calendar;
import java.sql.Ref;
import java.sql.Time;
import java.sql.Timestamp;


public class SQLArrayWrapper implements Array
{
  Array realArray;
  StatementWrapper parentStatement;
  String sql;

  public SQLArrayWrapper (Array array, StatementWrapper statement, String sql) {
    parentStatement = statement;
    this.sql = sql;
  }

  public Object getArray() throws SQLException {
    return realArray.getArray();
  }

  public Object getArray(long index, int count) throws SQLException {
    return realArray.getArray(index, count);
  }

  public Object getArray(long index, int count, Map map) throws SQLException {
    return realArray.getArray(index, count, map);
  }

  public Object getArray(Map map) throws SQLException {
    return realArray.getArray(map);
  }

  public int getBaseType() throws SQLException {
    return realArray.getBaseType();
  }

  public String getBaseTypeName() throws SQLException {
    return realArray.getBaseTypeName();
  }

  public ResultSet getResultSet() throws SQLException {
    return new ResultSetWrapper(realArray.getResultSet(), parentStatement, sql);
  }

  public ResultSet getResultSet(long index, int count) throws SQLException {
    return new ResultSetWrapper(realArray.getResultSet(index, count), parentStatement, sql);
  }

  public ResultSet getResultSet(long index, int count, Map map) throws SQLException {
    return new ResultSetWrapper(realArray.getResultSet(index, count, map), parentStatement, sql);
  }

  public ResultSet getResultSet(Map map) throws SQLException {
    return new ResultSetWrapper(realArray.getResultSet(map), parentStatement, sql);
  }

}

