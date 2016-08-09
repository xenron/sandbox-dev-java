/*
 * Takes a character, converts it to hex, decimal, binary, octal and html. 
 * Then wraps each of the fields with XML and sends it back through the response.
 */
package com.oreilly.ajax.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

public class AjaxResponseServlet extends HttpServlet
{

  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException
  {
    // key is the parameter passed in from the javascript
    // variable named url (see index.html)
    String key = req.getParameter("key");

    if (key != null)
    {

      // extract the first character from key
      // as an int, then convert that int to a String
      int keyInt = key.charAt(0);
      // setup the response
      res.setContentType("text/xml");
      res.setHeader("Cache-Control", "no-cache");
      // write out the xml string
      String outString = createJSONwithJSONsimple(keyInt);
      res.getWriter().write(outString);
    }
    else
    {
      // If key comes back as a null, return a question mark.
      res.setContentType("text/xml");
      res.setHeader("Cache-Control", "no-cache");
      res.getWriter().write("?");
    }
  }

  public String createJSONwithJSONsimple(int keyInt)
  {
    JSONObject obj=new JSONObject();
    JSONObject obj2 = new JSONObject();
    
    obj2.put("decimal",Integer.toString(keyInt));
    obj2.put("hexadecimal",Integer.toString(keyInt,16));
    obj2.put("octal",Integer.toString(keyInt,8));
    obj2.put("hyper","&0x"+Integer.toString(keyInt,16));
    obj2.put("binary",Integer.toString(keyInt,2)+"B");

    obj.put("conversion",obj2);
    return(obj.toString());
  }
  public String createStringBufferJSON(int keyInt)
  {

    StringBuffer returnJSON = new StringBuffer("\r\n{\"conversion\":{");
    returnJSON.append("\r\n\"decimal\": \""+
            Integer.toString(keyInt)+"\",");
    returnJSON.append("\r\n\"hexadecimal\": \""+
                        Integer.toString(keyInt,16)+"\",");
    returnJSON.append("\r\n\"octal\": \""+
                        Integer.toString(keyInt,8)+"\",");
    returnJSON.append("\r\n\"hyper\": \"&0x"+
                        Integer.toString(keyInt,16)+"\",");
    returnJSON.append("\r\n\"binary\": \""+
                        Integer.toString(keyInt,2)+"B\"");
    returnJSON.append("\r\n}}");
    return returnJSON.toString();
  }
 
}