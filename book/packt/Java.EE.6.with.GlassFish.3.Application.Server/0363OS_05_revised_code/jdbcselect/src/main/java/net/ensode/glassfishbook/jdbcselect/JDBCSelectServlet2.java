package net.ensode.glassfishbook.jdbcselect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JDBCSelectServlet2 extends HttpServlet
{
  @Resource(name = "jdbc/__CustomerDBPool")
  private javax.sql.DataSource dataSource;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
  {
    String sql = "select us_state_nm, us_state_cd from us_states where "
        + "us_state_nm like ? or us_state_nm like ? order by us_state_nm";
    ArrayList<UsStateBean> stateList = new ArrayList<UsStateBean>();

    try
    {
      Connection connection = dataSource.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, "North%");
      preparedStatement.setString(2, "South%");

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
    catch (SQLException sqlException)
    {
      sqlException.printStackTrace();
    }
  }
}
