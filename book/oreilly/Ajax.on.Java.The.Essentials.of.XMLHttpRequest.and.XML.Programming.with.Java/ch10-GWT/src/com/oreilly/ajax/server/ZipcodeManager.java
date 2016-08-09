package com.oreilly.ajax.server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ZipcodeManager {

    static public Zipcode getZipcode(String zip){
        Zipcode zipcode = null;
        Connection con = DatabaseConnector.getConnection();
        String sqlString = "";
        zipcode = new Zipcode();
        zipcode.setZipcode(zip);//put original zipcode in.
        
        try {
            sqlString = "SELECT CITY,STATE,ZIPCODE FROM ZIPCODES WHERE ZIPCODE='"+zip+"';";
            Statement select = con.createStatement();
            ResultSet result = select.executeQuery(sqlString);
            if (result.next()) { // process results one row at a time
                zipcode.setCity(result.getString(1));
                zipcode.setState(result.getString(2));
                zipcode.setZipcode(result.getString(3));
               }

        } catch (Exception e) {
            System.out.println("exception in login, you might need the mysql jar in the lib directory: "+e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
        return zipcode;
    }
}
