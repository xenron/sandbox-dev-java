package com.oreilly.ajax;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductManager
{


  static public Product getProduct(String productName)
  {
    Product product = new Product();
    Connection con = DatabaseConnector.getConnection();
    String sqlString = "";
    try
    {
      sqlString = "SELECT * FROM PRODUCTS WHERE PRODUCT_NAME='" + productName + "';";
      Statement select = con.createStatement();
      ResultSet result = select.executeQuery(sqlString);

      if(result.next())
      { // process results one row at a time

        product.setProductName(result.getString("PRODUCT_NAME"));
        product.setDescription(result.getString("DESCRIPTION"));
        product.setFilename(result.getString("FILENAME"));
        product.setPrice(result.getFloat("PRICE"));
        product.setProductId(result.getInt("PRODUCT_ID"));
 
      }

    }
    catch(Exception e)
    {
      System.out.println("exception caught getting Product" + sqlString + " " + e.getMessage());
    }
    finally
    {
      if(con != null)
      {
        try
        {
          con.close();
        }
        catch(SQLException e)
        {
        }
      }
    }

    return product;
  }

  static public Product getProductById(String productID)
  {
    Product product = new Product();
    Connection con = DatabaseConnector.getConnection();
    String sqlString = "";
    try
    {
      sqlString = "SELECT * FROM PRODUCTS WHERE PRODUCT_ID='" + productID + "';";
      Statement select = con.createStatement();
      ResultSet result = select.executeQuery(sqlString);

      if(result.next())
      { // process results one row at a time

        product.setProductName(result.getString("PRODUCT_NAME"));
        product.setDescription(result.getString("DESCRIPTION"));
        product.setFilename(result.getString("FILENAME"));
        product.setPrice(result.getFloat("PRICE"));
        product.setProductId(result.getInt("PRODUCT_ID"));
 
      }

    }
    catch(Exception e)
    {
      System.out.println("exception caught getting Product" + sqlString + " " + e.getMessage());
    }
    finally
    {
      if(con != null)
      {
        try
        {
          con.close();
        }
        catch(SQLException e)
        {
        }
      }
    }
    return product;
  }

  public static String getJSONProducts()
  {
    return getProducts();
  }

  private static String getProducts()
  {
    Product product = new Product();
    String title = "products";
    Connection con = DatabaseConnector.getConnection();
    StringBuffer jsonString = new StringBuffer("\r\n{\"" + title + "\": [");
    String sqlString = "";

    try
    {
      sqlString = "SELECT * FROM PRODUCTS;";
      Statement select = con.createStatement();
      ResultSet result = select.executeQuery(sqlString);
      while (result.next())
      { // process results one row at a time

        product.setProductName(result.getString("PRODUCT_NAME"));
        product.setDescription(result.getString("DESCRIPTION"));
        product.setFilename(result.getString("FILENAME"));
        product.setPrice(result.getFloat("PRICE"));
        product.setProductId(result.getInt("PRODUCT_ID"));
        jsonString.append("\r\n{\"description\":\"" + product.getDescription() + "\",\"name\":\"" + product.getProductName() + "\",\"filename\":\"" + product.getFilename() + "\", \"price\":\"" + product.getPrice() + "\"},");

      }
      int lastCharIndex = jsonString.length();
      jsonString.deleteCharAt(lastCharIndex - 1);
      jsonString.append("\r\n]}");
    }
    catch(Exception e)
    {
      System.out.println("exception caught getting Product" + sqlString + " " + e.getMessage());
    }
    finally
    {
      if(con != null)
      {
        try
        {
          con.close();
        }
        catch(SQLException e)
        {
        }
      }
    }
    return jsonString.toString();
  }

}
