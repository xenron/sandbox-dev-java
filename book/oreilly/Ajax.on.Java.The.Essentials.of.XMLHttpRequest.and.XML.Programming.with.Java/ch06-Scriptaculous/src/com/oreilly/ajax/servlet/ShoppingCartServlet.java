/*
 * Takes a character, converts it to hex, decimal, binary, octal and html. Then
 * wraps each of the fields with XML and sends it back through the response.
 */
package com.oreilly.ajax.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.ajax.JSONUtil;
import com.oreilly.ajax.ShoppingCartManager;
import com.oreilly.ajax.User;

public class ShoppingCartServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        String responseString = "success";
        User user = (User) req.getSession().getAttribute("user");
        String item = req.getParameter("item");
        if (item != null)
        {
            HashMap shoppingCartMap = ShoppingCartManager.addToShoppingCart(
                    user, item);
            if (shoppingCartMap == null)
            {
                responseString = "fail";
            }
            else
            {
                responseString = JSONUtil.convertMapToProducts(shoppingCartMap,
                        "cartcontents");
            }
        }
        if (responseString != null)
        {
            System.out.println(responseString);
            res.setContentType("text/xml");
            res.setHeader("Cache-Control", "no-cache");
            res.getWriter().write(responseString);
        }
        else
        {
            // If key comes back as a null, return a question mark.
            res.setContentType("text/xml");
            res.setHeader("Cache-Control", "no-cache");
            res.getWriter().write("?");
        }
    }

   
}
