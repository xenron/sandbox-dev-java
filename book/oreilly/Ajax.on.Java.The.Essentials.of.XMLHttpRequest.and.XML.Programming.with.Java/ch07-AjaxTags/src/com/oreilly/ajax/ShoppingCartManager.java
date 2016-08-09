package com.oreilly.ajax;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class ShoppingCartManager
{
  static public void emptyShoppingCart(User user)
  {
    ShoppingCart cart = getShoppingCart(user);
    if (cart != null && cart.getCartId() > 0)
    {
      Connection con = DatabaseConnector.getConnection();
      try
      {
        Statement statement = con.createStatement();
        // now get what is in the cart and build a response string
        String sqlString = "DELETE FROM ITEMS_IN_CART WHERE CART_ID ="
            + cart.getCartId() + ";";
        statement.execute(sqlString);
      }
      catch (Exception e)
      {
        System.out.println("exception caught getting cart items cart id:"
            + cart.getCartId());

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
    }

  }

  static public String getJSONShoppingCart(User user)
  {
    ShoppingCart cart = getShoppingCart(user);
    HashMap cartMap = getCartContents(cart);

    // get totals and append to string.
    // return JSONUtil.convertMapToProducts(cartMap, "cartcontents");
    return ("shopping cart data must be fixt");
  }

  private static HashMap getCartContents(ShoppingCart cart)
  {
    HashMap hashMap = null;
    Connection con = DatabaseConnector.getConnection();
    try
    {
      Statement statement = con.createStatement();
      // Search for item in cart
      // if there is one then update it with count incremented
      // else just add it.
      //            

      // now get what is in the cart and build a response string
      String sqlString = "SELECT ITEM_ID,COUNT from ITEMS_IN_CART WHERE CART_ID ="
          + cart.getCartId() + ";";
      ResultSet resultSet = statement.executeQuery(sqlString);
      hashMap = new HashMap();
      String productID = null;
      String productCount = null;
      while (resultSet.next())
      {
        productID = resultSet.getString(1);
        productCount = resultSet.getString(2);
        hashMap.put(productID, productCount);
      }
    }
    catch (Exception e)
    {
      System.out.println("exception caught getting cart items cart id:"
          + cart.getCartId());

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
    return hashMap;

  }

  static public ShoppingCart getShoppingCart(User user)
  {
    ShoppingCart cart = new ShoppingCart();
    Connection con = DatabaseConnector.getConnection();
    String sqlString = "";
    try
    {
      sqlString = "SELECT * FROM SHOPPING_CART WHERE USER_ID="
          + user.getUserId() + ";";

      Statement select = con.createStatement();
      ResultSet result = select.executeQuery(sqlString);

      if (result.next())
      { // process results one row at a time

        cart.setCartId(result.getInt("CART_ID"));
        cart.setUserId(result.getInt("USER_ID"));
        cart.setLastUpdate(result.getDate("LAST_UPDATED"));
        cart.setStartDate(result.getDate("START_DATE"));
        cart.setActive(result.getBoolean("ACTIVE"));
      }
      else
      // no cart yet, so create one
      {

        String statementString = "INSERT INTO SHOPPING_CART (USER_ID,START_DATE,LAST_UPDATED,ACTIVE)"
            + " values (?,?,?,?)";

        PreparedStatement insertStatement = con
            .prepareStatement(statementString);

        insertStatement.setInt(1, user.getUserId());
        insertStatement.setTimestamp(2, new Timestamp(new Date().getTime()));
        insertStatement.setTimestamp(3, new Timestamp(new Date().getTime()));
        insertStatement.setInt(4, 1);
        System.out.println("query:" + statementString);
        insertStatement.executeUpdate();
      }
    }
    catch (Exception e)
    {
      System.out.println("exception caught getting Shopping Cart" + sqlString
          + " " + e.getMessage());
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

    return cart;
  }

  static public String getShoppingCartView()
  {
    Connection con = DatabaseConnector.getConnection();
    String sqlString = "";
    String cartclass = "";
    SimpleDateFormat sf = new SimpleDateFormat("MM-dd-yyyy");
    StringBuffer htmlStringBuffer = new StringBuffer("<table class=\"Cart\">");
    htmlStringBuffer.append("\n<tr><th class=\"Cart\">User Name</th>");
    htmlStringBuffer.append("\n<th class=\"Cart\">Start Date</th>");
    htmlStringBuffer.append("\n<th class=\"Cart\">Last Updated</th>");
    htmlStringBuffer.append("\n<th class=\"Cart\">Active </th></tr>");
    try
    {
      sqlString = "select  u.USERNAME," + "sc.START_DATE," + "sc.LAST_UPDATED,"
          + "sc.ACTIVE " + "from SHOPPING_CART sc," + "USERS u "
          + "where sc.USER_ID=u.USER_ID;";

      Statement select = con.createStatement();
      ResultSet result = select.executeQuery(sqlString);
      int index = 0;
      while (result.next())
      { // process results one row at a time
        if (index++ % 2 == 0)
          cartclass = "CartLight";
        else
          cartclass = "CartDark";
        htmlStringBuffer.append("\n<tr class=\"" + cartclass + "\">");
        htmlStringBuffer.append("\n<td class=\"" + cartclass + "\">"
            + result.getString("USERNAME") + "</td>");
        htmlStringBuffer.append("\n<td class=\"" + cartclass + "\">"
            + sf.format(result.getDate("START_DATE")) + "</td>");
        htmlStringBuffer.append("\n<td class=\"" + cartclass + "\">"
            + sf.format(result.getDate("LAST_UPDATED")) + "</td>");
        if (result.getBoolean("ACTIVE"))
        {
          htmlStringBuffer
              .append("\n<td class=\"" + cartclass + "\">true</td>");
        }
        else
        {
          htmlStringBuffer.append("\n<td class=\"" + cartclass
              + "\">false</td>");
        }
        htmlStringBuffer.append("</tr>");
      }
    }
    catch (Exception e)
    {
      System.out
          .println("exception caught getting Shoppi                       ng Cart"
              + sqlString + " " + e.getMessage());
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
    return htmlStringBuffer.toString();
  }

  public static HashMap addToShoppingCart(User user, String item)
  {
    Connection con = DatabaseConnector.getConnection();
    String sqlString = "";
    ResultSet resultSet = null;
    Product product = ProductManager.getProduct(item);
    int itemID = product.getProductId();
    ShoppingCart cart = getShoppingCart(user);
    HashMap hashMap = null;
    try
    {
      // Search for item in cart
      // if there is one then update it with count incremented
      // else just add it.
      //			
      int count = 0;
      sqlString = "SELECT COUNT from ITEMS_IN_CART WHERE ITEM_ID=" + itemID
          + " AND " + "CART_ID =" + cart.getCartId() + ";";
      Statement add = con.createStatement();
      resultSet = add.executeQuery(sqlString);
      if (resultSet.next())
      {
        count = resultSet.getInt(1);
        count++;

        sqlString = "UPDATE ITEMS_IN_CART SET COUNT=" + count
            + " WHERE ITEM_ID=" + itemID + " AND " + "CART_ID ="
            + cart.getCartId() + ";";
        add.execute(sqlString);
      }
      else
      {
        sqlString = "INSERT INTO ITEMS_IN_CART (ITEM_ID,CART_ID,COUNT) values("
            + itemID + "," + cart.getCartId() + ",1);";
        add.execute(sqlString);
      }
      // now get what is in the cart and build a response string
      sqlString = "SELECT ITEM_ID,COUNT from ITEMS_IN_CART WHERE CART_ID ="
          + cart.getCartId() + ";";
      resultSet = add.executeQuery(sqlString);
      hashMap = new HashMap();
      String productID = null;
      String productCount = null;
      while (resultSet.next())
      {
        productID = resultSet.getString(1);
        productCount = resultSet.getString(2);
        hashMap.put(productID, productCount);
      }
    }
    catch (Exception e)
    {
      System.out.println("exception caught inserting item" + itemID
          + " into cart id:" + cart.getCartId());

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
    return hashMap;

  }

}
