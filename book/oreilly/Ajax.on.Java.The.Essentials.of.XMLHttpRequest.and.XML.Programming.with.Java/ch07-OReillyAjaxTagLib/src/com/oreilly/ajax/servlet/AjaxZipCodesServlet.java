package com.oreilly.ajax.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.ajax.DatabaseConnector;
import com.oreilly.ajax.JSONUtil;

public class AjaxZipCodesServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        String responseString = null;

        String zipCode = req.getParameter("zip");
        if (zipCode != null)
        {
            HashMap location = getCityState(zipCode);
            responseString = JSONUtil.buildJSON(location, "location");
        }
        if (responseString != null)
        {
            res.setContentType("text/xml");
            res.setHeader("Cache-Control", "no-cache");
            res.getWriter().write(responseString);
        } else
        {
            // If key comes back as a null, return a question mark.
            res.setContentType("text/xml");
            res.setHeader("Cache-Control", "no-cache");
            res.getWriter().write("?");
        }
    }

    private HashMap getCityState(String zipCode)
    {
        Connection con = DatabaseConnector.getConnection();
        HashMap cityStateMap = new HashMap();
        cityStateMap.put("zip", "zipCode");
        String queryString = "";
        try
        {
            queryString = "SELECT CITY, STATE FROM ZIPCODES where ZIPCODE="
                + zipCode + ";";
            Statement select = con.createStatement();
            ResultSet result = select
                    .executeQuery(queryString);

            while (result.next())
            { // process results one row at a time
                String city;
                String state;

                city = result.getString("CITY");
                if (result.wasNull())
                {
                    city = "";
                }
                cityStateMap.put("city", city);
                state = result.getString("state");
                if (result.wasNull())
                {
                    state = "";
                }
                cityStateMap.put("state", state);
            }
        } catch (Exception e)
        {
            System.out.println("exception caught getting city/state:"+queryString+" "+e.getMessage());
        } finally
        {
            if (con != null)
            {
                try
                {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
        return cityStateMap;
    }
}
