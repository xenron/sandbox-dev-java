/*
 * Takes a character, converts it to hex, decimal, binary, octal and html. 
 * Then wraps each of the fields with XML and sends it back through the response.
 */
package com.oreilly.ajax.servlet;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.Document;
import org.jdom.output.XMLOutputter;

public class AjaxResponseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // key is the parameter passed in from the javascript
        // variable named url (see index.html)
        String key = req.getParameter("key");
        StringBuffer returnXML = null; 
        if (key != null) {

            // extract the first character from key
            // as an int, then convert that int to a String
            int keyInt = key.charAt(0);
            
            returnXML = new StringBuffer("\r\n<converted-values>");
            returnXML.append("\r\n<decimal>"+
                                Integer.toString(keyInt)+"</decimal>");
            returnXML.append("\r\n<hexadecimal>0x"+
                                Integer.toString(keyInt,16)+"</hexadecimal>");
            returnXML.append("\r\n<octal>0"+
                                Integer.toString(keyInt,8)+"</octal>");
            returnXML.append("\r\n<hyper>&amp;0x"+
                                Integer.toString(keyInt,16)+";</hyper>");
            returnXML.append("\r\n<binary>"+
                                Integer.toString(keyInt,2)+"B</binary>");
            returnXML.append("\r\n</converted-values>");
            
            // setup the response
            res.setContentType("text/xml");
            res.setHeader("Cache-Control", "no-cache");
            // write out the xml string
            res.getWriter().write(returnXML.toString());
        }
        else {
            // If key comes back as a null, return a question mark.
            res.setContentType("text/xml");
            res.setHeader("Cache-Control", "no-cache");
            res.getWriter().write("?");
        }
    }
 
}