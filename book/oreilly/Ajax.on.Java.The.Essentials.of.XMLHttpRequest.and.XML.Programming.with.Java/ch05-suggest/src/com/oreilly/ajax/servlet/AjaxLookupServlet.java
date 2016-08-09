/*
 * Takes a character, converts it to hex, decimal, binary, octal and html. Then
 * wraps each of the fields with XML and sends it back through the response.
 */
package com.oreilly.ajax.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.ajax.DatabaseConnector;
import com.oreilly.ajax.JSONUtil;

public class AjaxLookupServlet extends HttpServlet
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        String responseString = null;
        String username = req.getParameter("username");
        String type = req.getParameter("type");

        int typeInt = Integer.parseInt(type);

        if (username != null)
        {
            switch (typeInt)
            {

            case 1:
                List list = completeUsername(username);
                responseString = JSONUtil.buildJSONArray(list, "usernames");

                break;
            case 2:
                HashMap customer = getCustomerInfo(username);
                responseString = JSONUtil.buildJSON(customer, "customer");
                break;

            case 3:
                responseString = getAllUsers();

                System.out.println("response: " + responseString);
            }
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

    private List completeUsername(String username)
    {
        Connection con = DatabaseConnector.getConnection();
        ArrayList usernameList = new ArrayList();
        ResultSet result = null;
        try
        {
            Statement select = con.createStatement();
            result = select
                    .executeQuery("SELECT USERNAME from USERS where USERNAME like '"
                            + username + "%';");
            while (result.next())
            {
                usernameList.add(result.getString("username"));
            }
        } catch (SQLException e){}
        finally{
            if(con != null)
            {
                try{
                    con.close();
                }catch(SQLException e){}
                
            }
        }
        return usernameList;
    }

    private String getAllUsers()
    {
        Connection con = DatabaseConnector.getConnection();
        ResultSet result = null;
        StringBuffer returnSB = null;
        try
        {
            Statement select = con.createStatement();
            result = select.executeQuery("SELECT USERNAME from USERS;");
            returnSB = new StringBuffer();
            while (result.next())
            {
                returnSB.append(result.getString("username") + ",");
            }
            returnSB.deleteCharAt(returnSB.length() - 1);
        } catch (SQLException e)
        {
            // You could pop up a window with AJAX to let users know there is a
            // problem.
        } finally{
            if(con != null)
            {
                try{
                    con.close();
                }catch(SQLException e){}
                
            }
        }
        return returnSB.toString();
    }

    private HashMap getCustomerInfo(String username)
    {
        Connection con = DatabaseConnector.getConnection();
        ResultSet result = null;
        HashMap map = new HashMap();
        // preload the map with empty strings.
        map.put("email", "");
        map.put("name", "");
        map.put("address", "");
        map.put("city", "");
        map.put("state", "");
        map.put("zipcode", "");

        try
        {
            Statement select = con.createStatement();
            result = select
                    .executeQuery("SELECT * from USERS where USERNAME = '"
                            + username + "';");
            String name = null;
            String value = null;
            if (result != null && result.next())
            {
                ResultSetMetaData metaData = result.getMetaData();
                for (int i = 1; i <= metaData.getColumnCount(); i++)
                {
                    name = metaData.getColumnName(i);
                    value = result.getString(name);
                    loadMap(map, name, value);
                }
            }
        } catch (SQLException e)
        {
            return map;
        } finally{
            if(con != null)
            {
                try{
                    con.close();
                }catch(SQLException e){}
                
            }
        }
        return map;
    }

    private void loadMap(HashMap map, String key, String value)
    {
        map.put(key, value == null ? "?" : value);

    }

}
