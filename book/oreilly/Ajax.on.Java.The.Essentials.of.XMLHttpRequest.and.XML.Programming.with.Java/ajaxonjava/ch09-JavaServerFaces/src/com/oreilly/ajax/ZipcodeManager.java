package com.oreilly.ajax;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ZipcodeManager {

    static public Location getZipcode(String zip){
        Location location = null;
        Connection con = DatabaseConnector.getConnection();
        String sqlString = "";
        location = new Location();
        location.setZipCode(zip);//put original zipcode in.
        
        try {
            sqlString = "SELECT CITY,STATE,ZIPCODE FROM ZIPCODES WHERE ZIPCODE='"+zip+"';";
            Statement select = con.createStatement();
            ResultSet result = select.executeQuery(sqlString);
            if (result.next()) { // process results one row at a time
                location.setCity(result.getString(1));
                location.setState(result.getString(2));
                location.setZipCode(result.getString(3));
               }

        } catch (Exception e) {
            System.out.println("exception in login"+e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
        return location;
    }
}
