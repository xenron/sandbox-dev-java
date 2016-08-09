package net.ensode.glassfishbook.jdbcselect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class JDBCSelectServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    String sql = "select us_state_nm, us_state_cd from us_states order by us_state_nm";
    ArrayList<UsStateBean> stateList = new ArrayList<UsStateBean>();

    try
    {
      InitialContext initialContext = new InitialContext();

      DataSource dataSource = (DataSource) initialContext
          .lookup("jdbc/__CustomerDBPool");
      Connection connection = dataSource.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();

      response.setContentType("text/html");

      while (resultSet.next())
      {
        stateList.add(new UsStateBean(resultSet.getString("us_state_nm"),
            resultSet.getString("us_state_cd")));
      }
      
      connection.close();

      request.setAttribute("stateList", stateList);
      
      request.getRequestDispatcher("us_states.jsp").forward(request, response);
    }
    catch (NamingException namingException)
    {
      namingException.printStackTrace();
    }
    catch (SQLException sqlException)
    {
      sqlException.printStackTrace();
    }
  }
}
