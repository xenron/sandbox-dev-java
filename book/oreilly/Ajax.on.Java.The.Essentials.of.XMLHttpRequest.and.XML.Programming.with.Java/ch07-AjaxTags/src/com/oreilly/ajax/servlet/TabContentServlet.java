package com.oreilly.ajax.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajaxtags.servlets.BaseAjaxServlet;

import com.oreilly.ajax.ProductManager;
import com.oreilly.ajax.ShoppingCartManager;
import com.oreilly.ajax.UserManager;

public class TabContentServlet extends BaseAjaxServlet
{

  public String getXmlContent(HttpServletRequest request,
      HttpServletResponse response) throws Exception
  {
    String tab = request.getParameter("tab");
    String returnString = "<H1>Tab parameter is null, please make sure you pass it in the request.</H1>";
    if (tab == null)
    {
      return (returnString);
    }
    if (tab.equals("Users"))
    {
      returnString = UserManager.getUsersView();
    }
    else if (tab.equalsIgnoreCase("Products"))
    {
      returnString = ProductManager.getProductsView();
    }
    else if (tab.equalsIgnoreCase("Carts"))
    {
      returnString = ShoppingCartManager.getShoppingCartView();
    }
    System.out.println(returnString);
    return (returnString);
  }
}
