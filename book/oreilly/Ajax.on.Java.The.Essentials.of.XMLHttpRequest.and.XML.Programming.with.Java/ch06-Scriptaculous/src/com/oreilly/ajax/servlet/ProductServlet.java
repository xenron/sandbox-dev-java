/*
 * Takes a character, converts it to hex, decimal, binary, octal and html. Then
 * wraps each of the fields with XML and sends it back through the response.
 */
package com.oreilly.ajax.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.ajax.ProductManager;

public class ProductServlet extends HttpServlet
{

  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
  {

    res.setContentType("text/xml");
    res.setHeader("Cache-Control", "no-cache");

    String responseString = ProductManager.getJSONProducts();
    if(responseString != null)
    {
      res.getWriter().write(responseString);
    }
    else
      res.getWriter().write("fail");
  }
}
