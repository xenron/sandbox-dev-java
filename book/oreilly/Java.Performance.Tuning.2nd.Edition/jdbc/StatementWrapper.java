package tuning.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLWarning;
import java.sql.SQLException;
import java.sql.ResultSet;

public class StatementWrapper implements Statement
{
  protected Statement realStatement;
  protected ConnectionWrapper connectionParent;
  protected String lastSql;

  public StatementWrapper(Statement statement, ConnectionWrapper parent)
  {
    realStatement = statement;
    connectionParent = parent;
  }

  public void addBatch(String sql) throws SQLException {
    realStatement.addBatch(sql);
    lastSql = sql;
  }

  public void cancel() throws SQLException {
    realStatement.cancel();
  }

  public void clearBatch() throws SQLException {
    realStatement.clearBatch();
  }

  public void clearWarnings() throws SQLException {
    realStatement.clearWarnings();
  }

  public void close() throws SQLException {
    realStatement.close();
  }

  public boolean execute(String sql) throws SQLException {
    Thread t = Thread.currentThread();
    JDBCLogger.startLogSqlQuery(t, sql);
    boolean b = realStatement.execute(sql);
    JDBCLogger.endLogSqlQuery(t, sql);
    lastSql = sql;
    return b;
  }

  public int[] executeBatch() throws SQLException {
    Thread t = Thread.currentThread();
    JDBCLogger.startLogSqlQuery(t, "batch");
    int[] i = realStatement.executeBatch();
    JDBCLogger.endLogSqlQuery(t, "batch");
    return i;
  }

  public ResultSet executeQuery(String sql) throws SQLException {
    Thread t = Thread.currentThread();
    JDBCLogger.startLogSqlQuery(t, sql);
    ResultSet r = realStatement.executeQuery(sql);
    JDBCLogger.endLogSqlQuery(t, sql);
    lastSql = sql;
    return new ResultSetWrapper(r, this, sql);
  }

  public int executeUpdate(String sql) throws SQLException {
    Thread t = Thread.currentThread();
    JDBCLogger.startLogSqlQuery(t, sql);
    int i = realStatement.executeUpdate(sql);
    JDBCLogger.endLogSqlQuery(t, sql);
    lastSql = sql;
    return i;
  }

  public Connection getConnection() throws SQLException {
    return connectionParent;
  }

  public int getFetchDirection() throws SQLException {
    return realStatement.getFetchDirection();
  }

  public int getFetchSize() throws SQLException {
    return realStatement.getFetchSize();
  }

  public int getMaxFieldSize() throws SQLException {
    return realStatement.getMaxFieldSize();
  }

  public int getMaxRows() throws SQLException {
    return realStatement.getMaxRows();
  }

  public boolean getMoreResults() throws SQLException {
    return realStatement.getMoreResults();
  }

  public int getQueryTimeout() throws SQLException {
    return realStatement.getQueryTimeout();
  }

  public ResultSet getResultSet() throws SQLException {
    return new ResultSetWrapper(realStatement.getResultSet(), this, lastSql);
  }

  public int getResultSetConcurrency() throws SQLException {
    return realStatement.getResultSetConcurrency();
  }

  public int getResultSetType() throws SQLException {
    return realStatement.getResultSetType();
  }

  public int getUpdateCount() throws SQLException {
    return realStatement.getUpdateCount();
  }

  public SQLWarning getWarnings() throws SQLException {
    return realStatement.getWarnings();
  }

  public void setCursorName(String name) throws SQLException {
    realStatement.setCursorName(name);
  }

  public void setEscapeProcessing(boolean enable) throws SQLException {
    realStatement.setEscapeProcessing(enable);
  }

  public void setFetchDirection(int direction) throws SQLException {
    realStatement.setFetchDirection(direction);
  }

  public void setFetchSize(int rows) throws SQLException {
    realStatement.setFetchSize(rows);
  }

  public void setMaxFieldSize(int max) throws SQLException {
    realStatement.setMaxFieldSize(max);
  }

  public void setMaxRows(int max) throws SQLException {
    realStatement.setMaxRows(max);
  }

  public void setQueryTimeout(int seconds) throws SQLException {
    realStatement.setQueryTimeout(seconds);
  }

}
