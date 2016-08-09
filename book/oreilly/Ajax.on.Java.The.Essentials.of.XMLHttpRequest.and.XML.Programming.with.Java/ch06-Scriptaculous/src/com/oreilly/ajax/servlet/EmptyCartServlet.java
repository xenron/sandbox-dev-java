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

import com.oreilly.ajax.ShoppingCartManager;
import com.oreilly.ajax.User;

public class EmptyCartServlet extends HttpServlet
{

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException

    {
        res.setContentType("text/xml");
        res.setHeader("Cache-Control", "no-cache");

        User user = (User) req.getSession().getAttribute("user");
        if (user != null)
        {

            ShoppingCartManager.emptyShoppingCart(user);
            String responseString = ShoppingCartManager
                    .getJSONShoppingCart(user);
            res.getWriter().write(responseString);
        }
        else
            res.getWriter().write("fail");
    }

}
