 package com.oreilly.ajax.server;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {
	
	 public static Connection getConnection() {
	        Connection con = null;
	        String driver = "com.mysql.jdbc.Driver";
	        try {
	            Class.forName(driver).newInstance();

	        } catch (Exception e) {
	            System.out.println("Failed to load mySQL driver.");
	            return null;
	        }
	        try {
	            con = DriverManager
	                    .getConnection("jdbc:mysql:///AJAX?user=ajax&password=aardvark");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return con;
	    }
}
