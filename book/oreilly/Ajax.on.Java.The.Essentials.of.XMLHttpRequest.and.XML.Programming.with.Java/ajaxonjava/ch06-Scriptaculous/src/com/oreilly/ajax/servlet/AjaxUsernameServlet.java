/*
 * Checks the database for a duplicate username. Returns true if the username exists.
 */
package com.oreilly.ajax.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.ajax.DatabaseConnector;

public class AjaxUsernameServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        String username = req.getParameter("username");
        if (username != null)
        {
            if (existsUsername(username))
            {
                res.setContentType("text/xml");
                res.setHeader("Cache-Control", "no-cache");
                res.getWriter().write("true");
            }
        } else
        {
            // If key comes back as a null return a message.
            res.setContentType("text/xml");
            res.setHeader("Cache-Control", "no-cache");
            res.getWriter().write("Username null");
        }
    }

    private boolean existsUsername(String username)
    {
        ResultSet result = null;
        Connection con = null;
        try
        {
            con = DatabaseConnector.getConnection();
            Statement select = con.createStatement();
            result = select
                    .executeQuery("SELECT USERNAME from USERS where USERNAME = '"
                            + username + "';");

            if (result == null || result.next())
            {
                return true;
            }
        } catch (SQLException e)
        {
            // use log4j or handle this how you want.
        } finally
        {
            if (con != null)
            {
                try
                {
                    con.close();
                } catch (SQLException e)
                {
                }

            }
        }
        return false;
    }
}
