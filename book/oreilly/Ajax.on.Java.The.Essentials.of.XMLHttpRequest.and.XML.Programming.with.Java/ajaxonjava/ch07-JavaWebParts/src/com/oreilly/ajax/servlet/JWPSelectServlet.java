package com.oreilly.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.ajax.DatabaseConnector;

public class JWPSelectServlet extends HttpServlet
{

  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException
  {
    doPost(req, res);
  }

  public void doPost(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException
  {
    String state = (String) req.getParameter("state");
    if (state != null)
    {
      res.setContentType("text/xml");
      res.setHeader("Cache-Control", "no-cache");
      res.getWriter().write(getCities(state));
    }
  }

  private String getCities(String state)
  {
    Connection con = DatabaseConnector.getConnection();
    StringBuffer sb = new StringBuffer("<select name=\"citySelected\">");
    try
    {
      Statement statement = con.createStatement();
      String sqlString = "SELECT DISTINCT CITY FROM ZIPCODES WHERE STATE='"
          + state + "' ORDER BY CITY;";
      ResultSet resultSet = statement.executeQuery(sqlString);
      while (resultSet.next())
      {
        sb.append("<option>" + resultSet.getString(1) + "</option>\n");
      }
    }
    catch (Exception e)
    {
      System.out.println("exception caught getting cities for " + state);

    }
    finally
    {
      sb
          .append("</select> <ajax:event ajaxRef=\"CitySelectForm/citySelectionChange\"/>");
      if (con != null)
      {
        try
        {
          con.close();
        }
        catch (SQLException e)
        {
        }
      }
    }
    return sb.toString();
  }

  private String getStates(String city)
  {
    Connection con = DatabaseConnector.getConnection();
    StringBuffer sb = new StringBuffer("<select>");
    try
    {
      Statement statement = con.createStatement();
      String sqlString = "SELECT DISTINCT STATE FROM ZIPCODES where CITY='"
          + city + "';";
      ResultSet resultSet = statement.executeQuery(sqlString);
      while (resultSet.next())
      {
        sb.append("<option>" + resultSet.getString(1) + "</option>\n");
      }
    }
    catch (Exception e)
    {
      System.out.println("exception caught getting states from zipcodes table");

    }
    finally
    {
      sb.append("</select>");
      if (con != null)
      {
        try
        {
          con.close();
        }
        catch (SQLException e)
        {
        }
      }
    }
    return sb.toString();
  }
}
