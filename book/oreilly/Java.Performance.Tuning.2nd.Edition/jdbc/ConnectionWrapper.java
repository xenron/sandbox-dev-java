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

public class ConnectionWrapper implements Connection
{
  protected Connection realConnection;

  public Connection realConnection () {
    return realConnection;
  }

  public ConnectionWrapper (Connection connection) {
    realConnection = connection;
  }

  public Statement createStatement() throws SQLException {
    return new StatementWrapper(realConnection.createStatement(), this);
  }

  public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
    return new StatementWrapper(realConnection.createStatement(resultSetType, resultSetConcurrency), this);
  }

  public CallableStatement prepareCall(String sql) throws SQLException {
    return new CallableStatementWrapper(realConnection.prepareCall(sql), this, sql);
  }

  public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
    return new CallableStatementWrapper(realConnection.prepareCall(sql, resultSetType, resultSetConcurrency), this, sql);
  }

  public PreparedStatement prepareStatement(String sql) throws SQLException {
    return new PreparedStatementWrapper(realConnection.prepareStatement(sql), this, sql);
  }

  public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
    return new PreparedStatementWrapper(realConnection.prepareStatement(sql, resultSetType, resultSetConcurrency), this, sql);
  }

  public DatabaseMetaData getMetaData() throws SQLException {
    return new DatabaseMetaDataWrapper(realConnection.getMetaData(), this);
  }




  public void clearWarnings() throws SQLException {
    realConnection.clearWarnings();
  }

  public void close() throws SQLException {
    realConnection.close();
  }

  public void commit() throws SQLException {
    realConnection.commit();
  }

  public boolean getAutoCommit() throws SQLException {
    return realConnection.getAutoCommit();
  }

  public String getCatalog() throws SQLException {
    return realConnection.getCatalog();
  }

  public int getTransactionIsolation() throws SQLException {
    return realConnection.getTransactionIsolation();
  }

  public Map getTypeMap() throws SQLException {
    return realConnection.getTypeMap();
  }

  public SQLWarning getWarnings() throws SQLException {
    return realConnection.getWarnings();
  }

  public boolean isClosed() throws SQLException {
    return realConnection.isClosed();
  }

  public boolean isReadOnly() throws SQLException {
    return realConnection.isReadOnly();
  }

  public String nativeSQL(String sql) throws SQLException {
    return realConnection.nativeSQL(sql);
  }

  public void rollback() throws SQLException {
    realConnection.rollback();
  }

  public void setAutoCommit(boolean autoCommit) throws SQLException {
    realConnection.setAutoCommit(autoCommit);
  }

  public void setCatalog(String catalog) throws SQLException {
    realConnection.setCatalog(catalog);
  }

  public void setReadOnly(boolean readOnly) throws SQLException {
    realConnection.setReadOnly(readOnly);
  }

  public void setTransactionIsolation(int level) throws SQLException {
    realConnection.setTransactionIsolation(level);
  }

  public void setTypeMap(Map map) throws SQLException {
    realConnection.setTypeMap(map);
  }

}
