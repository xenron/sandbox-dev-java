 package com.oreilly.ajax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnector {
	
	 public static Connection getConnection() {
         Logger log4j = Logger.getLogger("error");
           log4j.setLevel(Level.INFO);
	        Connection con = null;
	        String driver = "com.mysql.jdbc.Driver";
	        try {
	            Class.forName(driver).newInstance();

	        } catch (Exception e) {
	            System.out.println("Failed to load mySQL driver.");
              log4j.info("couldn't load the driver");
              e.printStackTrace();
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
