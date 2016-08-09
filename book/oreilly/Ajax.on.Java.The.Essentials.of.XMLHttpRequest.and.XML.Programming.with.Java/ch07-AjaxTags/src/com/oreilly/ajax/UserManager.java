package com.oreilly.ajax;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserManager {

	static public User login(String username, String password){
		User user = null;
		Connection con = DatabaseConnector.getConnection();
		String sqlString = "";
		try {
			sqlString = "SELECT * FROM USERS WHERE USERNAME='"+username+"' AND PASSWORD ='"+password+"';";
			Statement select = con.createStatement();
			ResultSet result = select.executeQuery(sqlString);

			
			if (result.next()) { // process results one row at a time
                user = new User();
				user.setUsername(username);
				user.setUserId(result.getInt("USER_ID"));
				user.setFirstName(result.getString("FIRST_NAME"));
				user.setLastName(result.getString("LAST_NAME"));
				user.setAddress(result.getString("ADDRESS"));
				user.setCity(result.getString("CITY"));
				user.setState(result.getString("STATE"));
				user.setZipCode(result.getString("ZIPCODE"));
				user.setEmail(result.getString("EMAIL"));
            	//update last login time
                Statement update = con.createStatement();
                SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
                String dateString = sf.format(new Date());
                update.execute("UPDATE USERS SET LAST_LOGIN = '"+dateString+"' where USERNAME = '"
                                + username + "' AND PASSWORD ='"+password+"' ;");
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
		
		
		return user;
	}
    public static boolean addUser(User user) {
        Connection con = DatabaseConnector.getConnection();
        //Hard coded values. Wouldn't it be better for the form values
        // to just match the database?
 
        try {
            Statement add = con.createStatement();
            String state = user.getState();
            user.setState(state.substring(0,2));
            String sqlstatement = "INSERT USERS (USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,EMAIL,ADDRESS,CITY,STATE,ZIPCODE,JOINED) " +
                    " VALUES('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getEmail()+"','"+user.getAddress()+"','"+
                    user.getCity()+"','"+user.getState()+"','"+user.getZipCode()+"','"+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"');";
            add.execute(sqlstatement);
            
        } catch (SQLException e) {
            // TODO: use log4j or other loggin system instead
            System.out.println("exception in adding user"+user.getUsername()+"','"+user.getPassword()+"','"+user.getFirstName()+"','"+user.getEmail()+"','"+user.getAddress()+"','"+
                    user.getCity()+"','"+user.getState()+"','"+user.getZipCode()+"','"+new SimpleDateFormat("MM-dd-yyyy").format(new Date())+" message"+e.getMessage());
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
    static public String getUsersView()
    {
        Connection con = DatabaseConnector.getConnection();
        String sqlString = "";
        String userclass = "";
        int index = 0;
        SimpleDateFormat sf = new SimpleDateFormat("MM-dd-yyyy");
        StringBuffer htmlStringBuffer = new StringBuffer("<table class=\"User\">");
                htmlStringBuffer.append("\n<tr><th class=\"User\">User Name</th>");
                htmlStringBuffer.append("\n<th class=\"User\">First Name</th>");
                htmlStringBuffer.append("\n<th class=\"User\">Last Name</th>");
                htmlStringBuffer.append("\n<th class=\"User\">City</th>");
                htmlStringBuffer.append("\n<th class=\"User\">State</th>");
                htmlStringBuffer.append("\n<th class=\"User\">Joined Date</th>");
                htmlStringBuffer.append("\n<th class=\"User\">Last Login </th></tr>");
        try
        {
            sqlString = "select * from USERS";
            Statement select = con.createStatement();
            ResultSet result = select.executeQuery(sqlString);
            Date tempDate = null;
            while (result.next())
            { // process results one row at a time
              if(index++ % 2 == 0)
                userclass = "UserLight";
              else
                userclass = "UserDark";

                htmlStringBuffer.append("\n<tr class=\""+userclass+"\">");
                htmlStringBuffer.append("\n<td class=\"User\">"+result.getString("USERNAME")+"</td>");
                htmlStringBuffer.append("\n<td class=\"User\">"+result.getString("FIRST_NAME")+"</td>");
                htmlStringBuffer.append("\n<td class=\"User\">"+result.getString("LAST_NAME")+"</td>");
                htmlStringBuffer.append("\n<td class=\"User\">"+result.getString("CITY")+"</td>");
                htmlStringBuffer.append("\n<td class=\"User\">"+result.getString("STATE")+"</td>");
                tempDate = result.getDate("JOINED");
                if (tempDate != null)
                  htmlStringBuffer.append("\n<td class=\"User\">"+sf.format(tempDate)+"</td>");
                else
                  htmlStringBuffer.append("\n<td class=\"User\">N/A</td>");
                  
                tempDate = result.getDate("LAST_LOGIN");
                if (tempDate != null)
                  htmlStringBuffer.append("\n<td class=\"User\">"+sf.format(tempDate)+"</td>");
                else
                  htmlStringBuffer.append("\n<td class=\"User\">N/A</td>");
                
                htmlStringBuffer.append("</tr>");
            }
        }
        catch (Exception e)
        {
            System.out.println("exception caught getting USERS"
                    + sqlString + " " + e.getMessage());
        }
        finally
        {
            if (con != null)
            {
                try
                {
                    con.close();
                }
                catch (SQLException e)
                {
                }
            }
        }
        return htmlStringBuffer.toString();
    }
}
