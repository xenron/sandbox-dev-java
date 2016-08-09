package com.oreilly.ajax;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class UserAction extends Action
{
    public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
    {
        String username = ((UserForm)form).getUsername();
        HashMap userInfoMap = getUserInfo(username);
        String firstName =(String)userInfoMap.get("firstName");
        String lastName =(String)userInfoMap.get("lastName");
        ((UserForm)form).setFirstName(firstName);
        ((UserForm)form).setLastName(lastName);
        return mapping.findForward("success");
    }
    private HashMap getUserInfo(String username)
    {
        
        HashMap hashMap = null;
        Connection con = DatabaseConnector.getConnection();
        try
        {
            Statement statement = con.createStatement();
 
            String sqlString = "select FIRST_NAME,LAST_NAME from USERS where USERNAME ='"+username+"';";
            ResultSet resultSet = statement.executeQuery(sqlString);
            if (resultSet.next())
            {
                hashMap = new HashMap();
                hashMap.put("firstName",resultSet.getString(1));
                hashMap.put("lastName",resultSet.getString(2));
            }
        }
        catch (Exception e)
        {
            System.out.println("exception caught getting usernames");

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
        return hashMap;

    }

}
