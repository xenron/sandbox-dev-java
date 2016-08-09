package com.oreilly.ajax;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import fr.improve.struts.taglib.layout.suggest.SuggestAction;

public class UserSuggestAction extends SuggestAction {
    
    public Collection getSuggestionList(HttpServletRequest in_request, String in_word) {
        
        // Get all the country names
        Collection allCountries = CountryCollection.getAllCountries();
        
        // Start to build the suggestions list
        ArrayList suggestions = new ArrayList();
        
        if (in_word != null && in_word.length() > 0)
        {
            Iterator iter = allCountries.iterator();
            
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
            

