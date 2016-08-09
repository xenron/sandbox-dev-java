package net.ensode.glassfishbook.jdbcupdate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class JdbcUpdateServlet extends HttpServlet
{
  @Resource(name = "jdbc/__CustomerDBPool")
  private DataSource dataSource;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
  {
    String insertCustomerSql = "insert into customers (customer_id, first_name, last_name, email) values (?,?,?,?)";
    String updateCustomerLastNameSql = "update customers set last_name = ? where customer_id = ?";
    String deleteCustomerSql = "delete from customers where customer_id = ?";

    PreparedStatement insertCustomerStatement;
    PreparedStatement updateCustomerLastNameStatement;
    PreparedStatement deleteCustomerStatement;

    try
    {
      Connection connection = dataSource.getConnection();
      
      insertCustomerStatement = connection
          .prepareStatement(insertCustomerSql);
      updateCustomerLastNameStatement = connection
          .prepareStatement(updateCustomerLastNameSql);
      deleteCustomerStatement = connection.prepareStatement(deleteCustomerSql);
      
      insertCustomerStatement.setInt(1, 1);
      insertCustomerStatement.setString(2, "Leo");
      insertCustomerStatement.setString(3, "Smith");
      insertCustomerStatement.setString(4, "lsmith@fake.com");
      insertCustomerStatement.executeUpdate();
      
      insertCustomerStatement.setInt(1, 2);
      insertCustomerStatement.setString(2, "Jane");
      insertCustomerStatement.setString(3, "Davis");
      insertCustomerStatement.setString(4, null);
      insertCustomerStatement.executeUpdate();
      
      updateCustomerLastNameStatement.setString(1, "Jones");
      updateCustomerLastNameStatement.setInt(2, 2);
      updateCustomerLastNameStatement.executeUpdate();
      
      deleteCustomerStatement.setInt(1, 1);
      deleteCustomerStatement.executeUpdate();
      
      connection.close();
      
      response.getWriter().println("Database Updated Successfully");
      
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
