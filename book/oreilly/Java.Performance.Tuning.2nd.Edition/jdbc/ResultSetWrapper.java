package tuning.jdbc;

import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Map;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.ResultSetMetaData;
import java.sql.Array;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.sql.Ref;
import java.sql.Time;
import java.sql.Timestamp;
import java.io.InputStream;
import java.io.Reader;
import java.sql.ResultSetMetaData;
import java.sql.SQLWarning;


public class ResultSetWrapper implements ResultSet
{
  ResultSet realResultSet;
  StatementWrapper parentStatement;
  String sql;

  public byte[] getBytes(String s) throws SQLException {
    return realResultSet.getBytes(s);
  }

  public byte[] getBytes(int i) throws SQLException {
    return realResultSet.getBytes(i);
  }


  public ResultSetWrapper(ResultSet resultSet, StatementWrapper statement, String sql) {
    realResultSet = resultSet;
    parentStatement = statement;
    this.sql = sql;
  }

  public boolean absolute(int row) throws SQLException {
    return realResultSet.absolute(row);
  }

  public void afterLast() throws SQLException {
    realResultSet.afterLast();
  }

  public void beforeFirst() throws SQLException {
    realResultSet.beforeFirst();
  }

  public void cancelRowUpdates() throws SQLException {
    realResultSet.cancelRowUpdates();
  }

  public void clearWarnings() throws SQLException {
    realResultSet.clearWarnings();
  }

  public void close() throws SQLException {
    realResultSet.close();
  }

  public void deleteRow() throws SQLException {
    realResultSet.deleteRow();
  }

  public int findColumn(String columnName) throws SQLException {
    return realResultSet.findColumn(columnName);
  }

  public boolean first() throws SQLException {
    return realResultSet.first();
  }

  public Array getArray(int i) throws SQLException {
    return new SQLArrayWrapper(realResultSet.getArray(i), parentStatement, sql);
  }

  public Array getArray(String colName) throws SQLException {
    return new SQLArrayWrapper(realResultSet.getArray(colName), parentStatement, sql);
  }

  public InputStream getAsciiStream(int columnIndex) throws SQLException {
    return realResultSet.getAsciiStream(columnIndex);
  }

  public InputStream getAsciiStream(String columnName) throws SQLException {
    return realResultSet.getAsciiStream(columnName);
  }

  public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
    return realResultSet.getBigDecimal(columnIndex);
  }

  public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
    return realResultSet.getBigDecimal(columnIndex, scale);
  }

  public BigDecimal getBigDecimal(String columnName) throws SQLException {
    return realResultSet.getBigDecimal(columnName);
  }

  public BigDecimal getBigDecimal(String columnName, int scale) throws SQLException {
    return realResultSet.getBigDecimal(columnName, scale);
  }

  public InputStream getBinaryStream(int columnIndex) throws SQLException {
    return realResultSet.getBinaryStream(columnIndex);
  }

  public InputStream getBinaryStream(String columnName) throws SQLException {
    return realResultSet.getBinaryStream(columnName);
  }

  public Blob getBlob(int i) throws SQLException {
    return realResultSet.getBlob(i);
  }

  public Blob getBlob(String colName) throws SQLException {
    return realResultSet.getBlob(colName);
  }

  public boolean getBoolean(int columnIndex) throws SQLException {
    return realResultSet.getBoolean(columnIndex);
  }

  public boolean getBoolean(String columnName) throws SQLException {
    return realResultSet.getBoolean(columnName);
  }

  public byte getByte(int columnIndex) throws SQLException {
    return realResultSet.getByte(columnIndex);
  }

  public byte getByte(String columnName) throws SQLException {
    return realResultSet.getByte(columnName);
  }

  public Reader getCharacterStream(int columnIndex) throws SQLException {
    return realResultSet.getCharacterStream(columnIndex);
  }

  public Reader getCharacterStream(String columnName) throws SQLException {
    return realResultSet.getCharacterStream(columnName);
  }

  public Clob getClob(int i) throws SQLException {
    return realResultSet.getClob(i);
  }

  public Clob getClob(String colName) throws SQLException {
    return realResultSet.getClob(colName);
  }

  public int getConcurrency() throws SQLException {
    return realResultSet.getConcurrency();
  }

  public String getCursorName() throws SQLException {
    return realResultSet.getCursorName();
  }

  public Date getDate(int columnIndex) throws SQLException {
    return realResultSet.getDate(columnIndex);
  }

  public Date getDate(int columnIndex, Calendar cal) throws SQLException {
    return realResultSet.getDate(columnIndex, cal);
  }

  public Date getDate(String columnName) throws SQLException {
    return realResultSet.getDate(columnName);
  }

  public Date getDate(String columnName, Calendar cal) throws SQLException {
    return realResultSet.getDate(columnName, cal);
  }

  public double getDouble(int columnIndex) throws SQLException {
    return realResultSet.getDouble(columnIndex);
  }

  public double getDouble(String columnName) throws SQLException {
    return realResultSet.getDouble(columnName);
  }

  public int getFetchDirection() throws SQLException {
    return realResultSet.getFetchDirection();
  }

  public int getFetchSize() throws SQLException {
    return realResultSet.getFetchSize();
  }

  public float getFloat(int columnIndex) throws SQLException {
    return realResultSet.getFloat(columnIndex);
  }

  public float getFloat(String columnName) throws SQLException {
    return realResultSet.getFloat(columnName);
  }

  public int getInt(int columnIndex) throws SQLException {
    return realResultSet.getInt(columnIndex);
  }

  public int getInt(String columnName) throws SQLException {
    return realResultSet.getInt(columnName);
  }

  public long getLong(int columnIndex) throws SQLException {
    return realResultSet.getLong(columnIndex);
  }

  public long getLong(String columnName) throws SQLException {
    return realResultSet.getLong(columnName);
  }

  public ResultSetMetaData getMetaData() throws SQLException {
    return realResultSet.getMetaData();
  }

  public Object getObject(int columnIndex) throws SQLException {
    return realResultSet.getObject(columnIndex);
  }

  public Object getObject(int i, Map map) throws SQLException {
    return realResultSet.getObject(i, map);
  }

  public Object getObject(String columnName) throws SQLException {
    return realResultSet.getObject(columnName);
  }

  public Object getObject(String colName, Map map) throws SQLException {
    return realResultSet.getObject(colName, map);
  }

  public Ref getRef(int i) throws SQLException {
    return realResultSet.getRef(i);
  }

  public Ref getRef(String colName) throws SQLException {
    return realResultSet.getRef(colName);
  }

  public int getRow() throws SQLException {
    return realResultSet.getRow();
  }

  public short getShort(int columnIndex) throws SQLException {
    return realResultSet.getShort(columnIndex);
  }

  public short getShort(String columnName) throws SQLException {
    return realResultSet.getShort(columnName);
  }

  public Statement getStatement() throws SQLException {
    return parentStatement;
  }

  public String getString(int columnIndex) throws SQLException {
    return realResultSet.getString(columnIndex);
  }

  public String getString(String columnName) throws SQLException {
    return realResultSet.getString(columnName);
  }

  public Time getTime(int columnIndex) throws SQLException {
    return realResultSet.getTime(columnIndex);
  }

  public Time getTime(int columnIndex, Calendar cal) throws SQLException {
    return realResultSet.getTime(columnIndex, cal);
  }

  public Time getTime(String columnName) throws SQLException {
    return realResultSet.getTime(columnName);
  }

  public Time getTime(String columnName, Calendar cal) throws SQLException {
    return realResultSet.getTime(columnName, cal);
  }

  public Timestamp getTimestamp(int columnIndex) throws SQLException {
    return realResultSet.getTimestamp(columnIndex);
  }

  public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
    return realResultSet.getTimestamp(columnIndex, cal);
  }

  public Timestamp getTimestamp(String columnName) throws SQLException {
    return realResultSet.getTimestamp(columnName);
  }

  public Timestamp getTimestamp(String columnName, Calendar cal) throws SQLException {
    return realResultSet.getTimestamp(columnName, cal);
  }

  public int getType() throws SQLException {
    return realResultSet.getType();
  }

  public InputStream getUnicodeStream(int columnIndex) throws SQLException {
    return realResultSet.getUnicodeStream(columnIndex);
  }

  public InputStream getUnicodeStream(String columnName) throws SQLException {
    return realResultSet.getUnicodeStream(columnName);
  }

  public SQLWarning getWarnings() throws SQLException {
    return realResultSet.getWarnings();
  }

  public void insertRow() throws SQLException {
    realResultSet.insertRow();
  }

  public boolean isAfterLast() throws SQLException {
    return realResultSet.isAfterLast();
  }

  public boolean isBeforeFirst() throws SQLException {
    return realResultSet.isBeforeFirst();
  }

  public boolean isFirst() throws SQLException {
    return realResultSet.isFirst();
  }

  public boolean isLast() throws SQLException {
    return realResultSet.isLast();
  }

  public boolean last() throws SQLException {
    return realResultSet.last();
  }

  public void moveToCurrentRow() throws SQLException {
    realResultSet.moveToCurrentRow();
  }

  public void moveToInsertRow() throws SQLException {
    realResultSet.moveToInsertRow();
  }

  public boolean next() throws SQLException {
    Thread t = Thread.currentThread();
    JDBCLogger.startLogSqlNext(t, sql);
    boolean b = realResultSet.next();
    JDBCLogger.endLogSqlNext(t, sql);
    return b;
  }

  public boolean previous() throws SQLException {
    boolean b = realResultSet.previous();
    return b;
  }

  public void refreshRow() throws SQLException {
    realResultSet.refreshRow();
  }

  public boolean relative(int rows) throws SQLException {
    return realResultSet.relative(rows);
  }

  public boolean rowDeleted() throws SQLException {
    return realResultSet.rowDeleted();
  }

  public boolean rowInserted() throws SQLException {
    return realResultSet.rowInserted();
  }

  public boolean rowUpdated() throws SQLException {
    return realResultSet.rowUpdated();
  }

  public void setFetchDirection(int direction) throws SQLException {
    realResultSet.setFetchDirection(direction);
  }

  public void setFetchSize(int rows) throws SQLException {
    realResultSet.setFetchSize(rows);
  }

  public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
    realResultSet.updateAsciiStream(columnIndex, x, length);
  }

  public void updateAsciiStream(String columnName, InputStream x, int length) throws SQLException {
    realResultSet.updateAsciiStream(columnName, x, length);
  }

  public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
    realResultSet.updateBigDecimal(columnIndex, x);
  }

  public void updateBigDecimal(String columnName, BigDecimal x) throws SQLException {
    realResultSet.updateBigDecimal(columnName, x);
  }

  public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
    realResultSet.updateBinaryStream(columnIndex, x, length);
  }

  public void updateBinaryStream(String columnName, InputStream x, int length) throws SQLException {
    realResultSet.updateBinaryStream(columnName, x, length);
  }

  public void updateBoolean(int columnIndex, boolean x) throws SQLException {
    realResultSet.updateBoolean(columnIndex, x);
  }

  public void updateBoolean(String columnName, boolean x) throws SQLException {
    realResultSet.updateBoolean(columnName, x);
  }

  public void updateByte(int columnIndex, byte x) throws SQLException {
    realResultSet.updateByte(columnIndex, x);
  }

  public void updateByte(String columnName, byte x) throws SQLException {
    realResultSet.updateByte(columnName, x);
  }

  public void updateBytes(int columnIndex, byte[] x) throws SQLException {
    realResultSet.updateBytes(columnIndex, x);
  }

  public void updateBytes(String columnName, byte[] x) throws SQLException {
    realResultSet.updateBytes(columnName, x);
  }

  public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
    realResultSet.updateCharacterStream(columnIndex, x, length);
  }

  public void updateCharacterStream(String columnName, Reader reader, int length) throws SQLException {
    realResultSet.updateCharacterStream(columnName, reader, length);
  }

  public void updateDate(int columnIndex, Date x) throws SQLException {
    realResultSet.updateDate(columnIndex, x);
  }

  public void updateDate(String columnName, Date x) throws SQLException {
    realResultSet.updateDate(columnName, x);
  }

  public void updateDouble(int columnIndex, double x) throws SQLException {
    realResultSet.updateDouble(columnIndex, x);
  }

  public void updateDouble(String columnName, double x) throws SQLException {
    realResultSet.updateDouble(columnName, x);
  }

  public void updateFloat(int columnIndex, float x) throws SQLException {
    realResultSet.updateFloat(columnIndex, x);
  }

  public void updateFloat(String columnName, float x) throws SQLException {
    realResultSet.updateFloat(columnName, x);
  }

  public void updateInt(int columnIndex, int x) throws SQLException {
    realResultSet.updateInt(columnIndex, x);
  }

  public void updateInt(String columnName, int x) throws SQLException {
    realResultSet.updateInt(columnName, x);
  }

  public void updateLong(int columnIndex, long x) throws SQLException {
    realResultSet.updateLong(columnIndex, x);
  }

  public void updateLong(String columnName, long x) throws SQLException {
    realResultSet.updateLong(columnName, x);
  }

  public void updateNull(int columnIndex) throws SQLException {
    realResultSet.updateNull(columnIndex);
  }

  public void updateNull(String columnName) throws SQLException {
    realResultSet.updateNull(columnName);
  }

  public void updateObject(int columnIndex, Object x) throws SQLException {
    realResultSet.updateObject(columnIndex, x);
  }

  public void updateObject(int columnIndex, Object x, int scale) throws SQLException {
    realResultSet.updateObject(columnIndex, x, scale);
  }

  public void updateObject(String columnName, Object x) throws SQLException {
    realResultSet.updateObject(columnName, x);
  }

  public void updateObject(String columnName, Object x, int scale) throws SQLException {
    realResultSet.updateObject(columnName, x, scale);
  }

  public void updateRow() throws SQLException {
    realResultSet.updateRow();
  }

  public void updateShort(int columnIndex, short x) throws SQLException {
    realResultSet.updateShort(columnIndex, x);
  }

  public void updateShort(String columnName, short x) throws SQLException {
    realResultSet.updateShort(columnName, x);
  }

  public void updateString(int columnIndex, String x) throws SQLException {
    realResultSet.updateString(columnIndex, x);
  }

  public void updateString(String columnName, String x) throws SQLException {
    realResultSet.updateString(columnName, x);
  }

  public void updateTime(int columnIndex, Time x) throws SQLException {
    realResultSet.updateTime(columnIndex, x);
  }

  public void updateTime(String columnName, Time x) throws SQLException {
    realResultSet.updateTime(columnName, x);
  }

  public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
    realResultSet.updateTimestamp(columnIndex, x);
  }

  public void updateTimestamp(String columnName, Timestamp x) throws SQLException {
    realResultSet.updateTimestamp(columnName, x);
  }

  public boolean wasNull() throws SQLException {
    return realResultSet.wasNull();
  }

}
