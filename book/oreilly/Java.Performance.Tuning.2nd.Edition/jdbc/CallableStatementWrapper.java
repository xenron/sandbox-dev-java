package tuning.jdbc;

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

public class CallableStatementWrapper extends PreparedStatementWrapper implements CallableStatement
{
  CallableStatement realCallableStatement;
  public CallableStatementWrapper(CallableStatement statement, ConnectionWrapper parent, String sql)
  {
    super(statement, parent, sql);
    realCallableStatement = statement;
  }

  public Array getArray(int i) throws SQLException {
    return new SQLArrayWrapper(realCallableStatement.getArray(i), this, sql);
  }

  public BigDecimal getBigDecimal(int parameterIndex) throws SQLException {
    return realCallableStatement.getBigDecimal(parameterIndex);
  }

  public BigDecimal getBigDecimal(int parameterIndex, int scale) throws SQLException {
    return realCallableStatement.getBigDecimal(parameterIndex, scale);
  }

  public Blob getBlob(int i) throws SQLException {
    return realCallableStatement.getBlob(i);
  }

  public boolean getBoolean(int parameterIndex) throws SQLException {
    return realCallableStatement.getBoolean(parameterIndex);
  }

  public byte getByte(int parameterIndex) throws SQLException {
    return realCallableStatement.getByte(parameterIndex);
  }

  public byte[] getBytes(int parameterIndex) throws SQLException {
    return realCallableStatement.getBytes(parameterIndex);
  }

  public Clob getClob(int i) throws SQLException {
    return realCallableStatement.getClob(i);
  }

  public Date getDate(int parameterIndex) throws SQLException {
    return realCallableStatement.getDate(parameterIndex);
  }

  public Date getDate(int parameterIndex, Calendar cal) throws SQLException {
    return realCallableStatement.getDate(parameterIndex, cal);
  }

  public double getDouble(int parameterIndex) throws SQLException {
    return realCallableStatement.getDouble(parameterIndex);
  }

  public float getFloat(int parameterIndex) throws SQLException {
    return realCallableStatement.getFloat(parameterIndex);
  }

  public int getInt(int parameterIndex) throws SQLException {
    return realCallableStatement.getInt(parameterIndex);
  }

  public long getLong(int parameterIndex) throws SQLException {
    return realCallableStatement.getLong(parameterIndex);
  }

  public Object getObject(int parameterIndex) throws SQLException {
    return realCallableStatement.getObject(parameterIndex);
  }

  public Object getObject(int i, Map map) throws SQLException {
    return realCallableStatement.getObject(i, map);
  }

  public Ref getRef(int i) throws SQLException {
    return realCallableStatement.getRef(i);
  }

  public short getShort(int parameterIndex) throws SQLException {
    return realCallableStatement.getShort(parameterIndex);
  }

  public String getString(int parameterIndex) throws SQLException {
    return realCallableStatement.getString(parameterIndex);
  }

  public Time getTime(int parameterIndex) throws SQLException {
    return realCallableStatement.getTime(parameterIndex);
  }

  public Time getTime(int parameterIndex, Calendar cal) throws SQLException {
    return realCallableStatement.getTime(parameterIndex, cal);
  }

  public Timestamp getTimestamp(int parameterIndex) throws SQLException {
    return realCallableStatement.getTimestamp(parameterIndex);
  }

  public Timestamp getTimestamp(int parameterIndex, Calendar cal) throws SQLException {
    return realCallableStatement.getTimestamp(parameterIndex, cal);
  }

  public void registerOutParameter(int parameterIndex, int sqlType) throws SQLException {
    realCallableStatement.registerOutParameter(parameterIndex, sqlType);
  }

  public void registerOutParameter(int parameterIndex, int sqlType, int scale) throws SQLException {
    realCallableStatement.registerOutParameter(parameterIndex, sqlType, scale);
  }

  public void registerOutParameter(int paramIndex, int sqlType, String typeName) throws SQLException {
    realCallableStatement.registerOutParameter(paramIndex, sqlType, typeName);
  }

  public boolean wasNull() throws SQLException {
    return realCallableStatement.wasNull();
  }

}
