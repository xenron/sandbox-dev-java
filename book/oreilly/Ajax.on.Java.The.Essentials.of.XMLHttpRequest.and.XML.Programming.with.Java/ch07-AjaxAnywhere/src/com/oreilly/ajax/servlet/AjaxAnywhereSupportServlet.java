package com.oreilly.ajax.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ajaxanywhere.AAUtils;

import com.oreilly.ajax.DatabaseConnector;

public class AjaxAnywhereSupportServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
  {
    doPost(req, res);
  }

  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
  {
    String state = req.getParameter("state");
    String city = req.getParameter("city");
    String function = req.getParameter("function");
    
    if(AAUtils.isAjaxRequest(req))
    {
      HttpSession session = req.getSession();
      if(function.equals("city"))
      {
        AAUtils.addZonesToRefresh(req, "stateswcityList");
        session.setAttribute("stateList", getStates(city));
      }
      else if(function.equals("state"))
      {
        AAUtils.addZonesToRefresh(req, "citiesList");
        session.setAttribute("cityList", getCities(state));
      }
    }
    String url = "/index.jsp";
    ServletContext sc = getServletContext();
    RequestDispatcher rd = sc.getRequestDispatcher(url);
    rd.forward(req, res);
  }

  private Collection getCities(String state)
  {
    ArrayList cityList = new ArrayList();
    Connection con = DatabaseConnector.getConnection();
    try
    {
      Statement statement = con.createStatement();
      String sqlString = "SELECT DISTINCT CITY FROM ZIPCODES WHERE STATE='" + state + "' ORDER BY CITY;";
      ResultSet resultSet = statement.executeQuery(sqlString);
      while (resultSet.next())
      {
        cityList.add(resultSet.getString(1));
      }
    }
    catch(Exception e)
    {
      System.out.println("exception caught getting cities for " + state);

    }
    finally
    {
      if(con != null)
      {
        try
        {
          con.close();
        }
        catch(SQLException e)
        {
        }
      }
    }
    return cityList;
  }

  private Collection getStates(String city)
  {
    ArrayList stateList = new ArrayList();
    Connection con = DatabaseConnector.getConnection();
    try
    {
      Statement statement = con.createStatement();
      String sqlString = "SELECT DISTINCT STATE FROM ZIPCODES where CITY='" + city + "' ORDER BY STATE;";
      ResultSet resultSet = statement.executeQuery(sqlString);
      while (resultSet.next())
      {
        stateList.add(resultSet.getString(1));
      }
    }
    catch(Exception e)
    {
      System.out.println("exception caught getting states from zipcodes table");

    }
    finally
    {
      if(con != null)
      {
        try
        {
          con.close();
        }
        catch(SQLException e)
        {
        }
      }
    }
    return stateList;
  }
}
