package com.oreilly.ajax.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.oreilly.ajax.client.ResponseService;

public class ResponseServiceImpl extends RemoteServiceServlet
        implements ResponseService  {
    public String displayResponse(String req) {
        if(req.length() < 1) {
            throw new IllegalArgumentException(
                    "Blank submissions from the client are invalid.");
        }
        Zipcode zipcode = ZipcodeManager.getZipcode(req);
        String state = zipcode.getState();
        String city = zipcode.getCity();
        if((state==null || state.length()<1) || (city==null || city.length()<1))
          return null;
        String jsonString = "{\"state\":\""+state+"\", \"city\":\""+city+"\"}"; 
        return jsonString;
    }
}