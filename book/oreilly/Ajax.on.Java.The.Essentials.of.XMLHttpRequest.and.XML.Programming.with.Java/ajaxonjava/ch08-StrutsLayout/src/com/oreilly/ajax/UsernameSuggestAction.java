package com.oreilly.ajax;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import fr.improve.struts.taglib.layout.suggest.SuggestAction;

public class UsernameSuggestAction extends SuggestAction {
  

    private static Collection getUserSuggestions()
    {
        
        ArrayList arrayList = null;
        Connection con = DatabaseConnector.getConnection();
        try
        {
            Statement statement = con.createStatement();
 
            String sqlString = "select username from users;";
            ResultSet resultSet = statement.executeQuery(sqlString);
            arrayList = new ArrayList();
            while (resultSet.next())
            {
                arrayList.add(resultSet.getString(1));
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
        return arrayList;

    }
    public Collection getSuggestionList(HttpServletRequest in_request, 
            String in_word) {
        
        // Get all the user names
        Collection usernames = getUserSuggestions();
        
        // Start to build the suggestions list
        ArrayList suggestions = new ArrayList();
        
        if (in_word != null && in_word.length() > 0)
        {
            Iterator iter = usernames.iterator();
            
            while(iter.hasNext())
            {
                String currentWord = (String) iter.next();
                
                if(currentWord.toLowerCase().startsWith(in_word.toLowerCase()))
                    suggestions.add(currentWord);
            }
        }
        
        return suggestions;
    }
    
}               
            

