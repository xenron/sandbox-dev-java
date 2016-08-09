/*
 * Checks the database for a duplicate username. Returns true if the username exists.
 */
package com.oreilly.ajax.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.ajax.ShoppingCartManager;
import com.oreilly.ajax.User;
import com.oreilly.ajax.UserManager;

public class AjaxLoginServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
      res.setContentType("text/xml");
      res.setHeader("Cache-Control", "no-cache");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username != null && password != null)
        {
        	User user = UserManager.login(username,password);
            if (user!=null)
            {
                String responseString = ShoppingCartManager.getJSONShoppingCart(user);
            	HttpSession session = req.getSession();
            	session.setAttribute("user",user);
                res.getWriter().write(responseString);
            }
            else
              res.getWriter().write("fail");
        } 
        else
          res.getWriter().write("fail");
    }
}
