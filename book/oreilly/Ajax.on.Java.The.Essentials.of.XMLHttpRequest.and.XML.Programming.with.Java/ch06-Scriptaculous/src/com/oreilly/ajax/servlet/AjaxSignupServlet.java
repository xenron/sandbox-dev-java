/*
 * Takes a character, converts it to hex, decimal, binary, octal and html. Then
 * wraps each of the fields with XML and sends it back through the response.
 */
package com.oreilly.ajax.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.ajax.User;
import com.oreilly.ajax.UserManager;

public class AjaxSignupServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException 
    {
        ServletContext sc = getServletContext();
        RequestDispatcher rd = null;
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setFirstName(req.getParameter("firstname"));
        user.setLastName(req.getParameter("lastname"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setAddress(req.getParameter("address"));
        user.setCity(req.getParameter("city"));
        user.setState(req.getParameter("state"));
        user.setZipCode(req.getParameter("zipcode"));
        if(UserManager.addUser(user))
        {
            rd = sc.getRequestDispatcher("/confirmation.html");
            rd.forward(req, res); 
        }
		else 
        {
            rd = sc.getRequestDispatcher("/failure.html");
            rd.forward(req, res);
		}
	}
}
