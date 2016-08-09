package org.jboss.ajax.controller;

import java.io.*;
import java.sql.*;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class AjaxFormServlet extends HttpServlet {

 

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Obtain value of Catalog Id field to be validated.
			String catalogId = request.getParameter("catalogId");

			// Obtain Connection
			InitialContext initialContext = new InitialContext();
			DataSource ds = (DataSource) initialContext.lookup("java:jboss/datasources/MySQLDS");
			java.sql.Connection conn = ds.getConnection();

			// Obtain result set
			PreparedStatement pstmt = conn.prepareStatement("SELECT * from CATALOG WHERE CatalogId = ?");
pstmt.setString(1, catalogId);
    
			ResultSet rs = pstmt.executeQuery();

			// set headers before accessing the Writer
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");

			PrintWriter out = response.getWriter();

			// then send the response
			// If result set is empty set valid element to true
			if (rs.next()) {
			out.println("<catalog>" + "<valid>false</valid>" + "<journal>"
					+ rs.getString(2) + "</journal>" + "<publisher>"
					+ rs.getString(3) + "</publisher>" + "<edition>"
					+ rs.getString(4) + "</edition>" + "<title>"
					+ rs.getString(5) + "</title>" + "<author>"
					+ rs.getString(6) + "</author>" + "</catalog>");
			} else {
				out.println("<valid>true</valid>");
			} 

			rs.close();
			pstmt.close();
			conn.close();

		} catch (javax.naming.NamingException e) {System.err.println(e.getMessage());
		} catch (SQLException e) {System.err.println(e.getMessage());
		}
	}

 

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Obtain Connection
			InitialContext initialContext = new InitialContext();
			DataSource ds = (DataSource) initialContext.lookup("java:jboss/datasources/MySQLDS");
			java.sql.Connection conn = ds.getConnection();

			String catalogId = request.getParameter("catalogId");
			String journal = request.getParameter("journal");
			String publisher = request.getParameter("publisher");
			String edition = request.getParameter("edition");
			String title = request.getParameter("title");
			String author = request.getParameter("author");

			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO Catalog VALUES(" + "\'" + catalogId
					+ "\'" + "," + "\'" + journal + "\'" + "," + "\'"
					+ publisher + "\'" + "," + "\'" + edition + "\'" + ","
					+ "\'" + title + "\'" + "," + "\'" + author + "\'" + ")"; 

			stmt.execute(sql);

			response.sendRedirect("catalog.jsp");

			stmt.close();
			conn.close();

		} catch (javax.naming.NamingException e) {
			response.sendRedirect("error.jsp");
		} catch (SQLException e) {
			response.sendRedirect("error.jsp");
		}
	}
}
