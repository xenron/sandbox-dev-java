/*
 * Takes a character and converts it to decimal and sends back the 
 * value in the response.
 */
package com.oreilly.ajax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxResponseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String key = req.getParameter("key");
        if (key != null) {
            // extract the first character from key
            int keyInt = key.charAt(0);
            String decimalString = Integer.toString(keyInt); 
            // setup the response
            res.setContentType("text/xml");
            res.setHeader("Cache-Control", "no-cache");
            // write out the response string
            res.getWriter().write(decimalString);
        }
        else {
            // If key comes back as a null, return a question mark.
            res.setContentType("text/xml");
            res.setHeader("Cache-Control", "no-cache");
            res.getWriter().write("?");
        }
    }
}