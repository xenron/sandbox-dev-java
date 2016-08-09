package tuning.jdbc;

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

public class PreparedStatementWrapper extends StatementWrapper implements PreparedStatement
{
  PreparedStatement realPreparedStatement;
  String sql;
  public PreparedStatementWrapper(PreparedStatement statement, ConnectionWrapper parent, String sql)
  {
    super(statement, parent);
    realPreparedStatement = statement;
    this.sql = sql;
  }

  public void addBatch() throws SQLException {
    realPreparedStatement.addBatch();
  }

  public void clearParameters() throws SQLException {
    realPreparedStatement.clearParameters();
  }

  public boolean execute() throws SQLException {
    Thread t = Thread.currentThread();
    JDBCLogger.startLogSqlQuery(t, sql);
    boolean b = realPreparedStatement.execute();
    JDBCLogger.endLogSqlQuery(t, sql);
    return b;
  }

  public ResultSet executeQuery() throws SQLException {
    Thread t = Thread.currentThread();
    JDBCLogger.startLogSqlQuery(t, sql);
    ResultSet r = realPreparedStatement.executeQuery();
    JDBCLogger.endLogSqlQuery(t, sql);
    return new ResultSetWrapper(r, this, sql);
  }

  public int executeUpdate() throws SQLException {
    Thread t = Thread.currentThread();
    JDBCLogger.startLogSqlQuery(t, sql);
    int i = realPreparedStatement.executeUpdate();
    JDBCLogger.endLogSqlQuery(t, sql);
    return i;
  }

  public ResultSetMetaData getMetaData() throws SQLException {
    return realPreparedStatement.getMetaData();
  }

  public void setArray(int i, Array x) throws SQLException {
    if (x instanceof SQLArrayWrapper)
      realPreparedStatement.setArray(i, ((SQLArrayWrapper) x).realArray);
    else
      realPreparedStatement.setArray(i, x);
  }

  public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
    realPreparedStatement.setAsciiStream(parameterIndex, x, length);
  }

  public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
    realPreparedStatement.setBigDecimal(parameterIndex, x);
  }

  public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
    realPreparedStatement.setBinaryStream(parameterIndex, x, length);
  }

  public void setBlob(int i, Blob x) throws SQLException {
    realPreparedStatement.setBlob(i, x);
  }

  public void setBoolean(int parameterIndex, boolean x) throws SQLException {
    realPreparedStatement.setBoolean(parameterIndex, x);
  }

  public void setByte(int parameterIndex, byte x) throws SQLException {
    realPreparedStatement.setByte(parameterIndex, x);
  }

  public void setBytes(int parameterIndex, byte[] x) throws SQLException {
    realPreparedStatement.setBytes(parameterIndex, x);
  }

  public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
    realPreparedStatement.setCharacterStream(parameterIndex, reader, length);
  }

  public void setClob(int i, Clob x) throws SQLException {
    realPreparedStatement.setClob(i, x);
  }

  public void setDate(int parameterIndex, Date x) throws SQLException {
    realPreparedStatement.setDate(parameterIndex, x);
  }

  public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
    realPreparedStatement.setDate(parameterIndex, x, cal);
  }

  public void setDouble(int parameterIndex, double x) throws SQLException {
    realPreparedStatement.setDouble(parameterIndex, x);
  }

  public void setFloat(int parameterIndex, float x) throws SQLException {
    realPreparedStatement.setFloat(parameterIndex, x);
  }

  public void setInt(int parameterIndex, int x) throws SQLException {
    realPreparedStatement.setInt(parameterIndex, x);
  }

  public void setLong(int parameterIndex, long x) throws SQLException {
    realPreparedStatement.setLong(parameterIndex, x);
  }

  public void setNull(int parameterIndex, int sqlType) throws SQLException {
    realPreparedStatement.setNull(parameterIndex, sqlType);
  }

  public void setNull(int paramIndex, int sqlType, String typeName) throws SQLException {
    realPreparedStatement.setNull(paramIndex, sqlType, typeName);
  }

  public void setObject(int parameterIndex, Object x) throws SQLException {
    realPreparedStatement.setObject(parameterIndex, x);
  }

  public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
    realPreparedStatement.setObject(parameterIndex, x, targetSqlType);
  }

  public void setObject(int parameterIndex, Object x, int targetSqlType, int scale) throws SQLException {
    realPreparedStatement.setObject(parameterIndex, x, targetSqlType, scale);
  }

  public void setRef(int i, Ref x) throws SQLException {
    realPreparedStatement.setRef(i, x);
  }

  public void setShort(int parameterIndex, short x) throws SQLException {
    realPreparedStatement.setShort(parameterIndex, x);
  }

  public void setString(int parameterIndex, String x) throws SQLException {
    realPreparedStatement.setString(parameterIndex, x);
  }

  public void setTime(int parameterIndex, Time x) throws SQLException {
    realPreparedStatement.setTime(parameterIndex, x);
  }

  public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
    realPreparedStatement.setTime(parameterIndex, x, cal);
  }

  public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
    realPreparedStatement.setTimestamp(parameterIndex, x);
  }

  public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
    realPreparedStatement.setTimestamp(parameterIndex, x, cal);
  }

  public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
    realPreparedStatement.setUnicodeStream(parameterIndex, x, length);
  }

}
