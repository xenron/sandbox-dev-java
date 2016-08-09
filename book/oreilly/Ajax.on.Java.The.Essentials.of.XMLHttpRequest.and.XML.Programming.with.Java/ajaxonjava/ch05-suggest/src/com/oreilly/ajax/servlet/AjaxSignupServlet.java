/*
 * Takes a character, converts it to hex, decimal, binary, octal and html. Then
 * wraps each of the fields with XML and sends it back through the response.
 */
package com.oreilly.ajax.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.ajax.DatabaseConnector;

public class AjaxSignupServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
        ServletContext sc = getServletContext();
        RequestDispatcher rd = null;

        if(addUser(req))
        {
            rd = sc.getRequestDispatcher("/confirmation.html");
            
            rd.forward(req, res); 
        }
		else {
            rd = sc.getRequestDispatcher("/failure.html");
            rd.forward(req, res);
		}
	}

	private boolean addUser(HttpServletRequest req) {
		Connection con = DatabaseConnector.getConnection();
        //Hard coded values. Wouldn't it be better for the form values
        // to just match the database?
        String username = req.getParameter("ajax_username");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String zipcode = req.getParameter("zipcode");
		try {
			Statement add = con.createStatement();
			String sqlstatement = "INSERT USERS (USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,EMAIL,ADDRESS,CITY,STATE,ZIPCODE) " +
					" VALUES('"+username+"','"+password+"','"+firstname+"','"+lastname+"','"+email+"','"+address+"','"+
					city+"','"+state+"','"+zipcode+"');";
			add.execute(sqlstatement);
			
		} catch (SQLException e) {
            // TODO: use log4j or other loggin system instead
            System.out.println("exception in adding user '"+username+"','"+password+"','"+firstname+"','"+lastname+"','"+email+"','"+address+"','"+
                    city+"','"+state+"','"+zipcode+" message"+e.getMessage());
			return false;
		} finally{
            if(con != null)
            {
                try{
                    con.close();
                }catch(SQLException e){}
                
            }
        }
		return true;

	}



}
