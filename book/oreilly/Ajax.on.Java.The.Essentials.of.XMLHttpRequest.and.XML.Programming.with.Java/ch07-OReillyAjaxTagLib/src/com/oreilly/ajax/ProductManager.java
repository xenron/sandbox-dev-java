package com.oreilly.ajax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ProductManager
{
  static public String imagePath; 
  public static String getImagePath()
{
    return imagePath;
}

public static void setImagePath(String imagePath)
{
    ProductManager.imagePath = imagePath;
}

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
  static public boolean updateProductById(int id, String column, String newValue)
  {
      boolean result = false;
      String  sqlString = "UPDATE PRODUCTS SET "+column+ " = '"+newValue+"' WHERE PRODUCT_ID='" + id + "';";
      Connection con = DatabaseConnector.getConnection();
      try
      {
        Statement select = con.createStatement();
        result = select.execute(sqlString);
      }
        catch(Exception e)
        {
          System.out.println("exception caught updating Product" + sqlString + " " + e.getMessage());
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
      
      
      return result;
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
  static public boolean deleteRow(String productID)
  {
    Product product = new Product();
    Connection con = DatabaseConnector.getConnection();
    String sqlString = "";
    boolean result = false;
    try
    {
      sqlString = "DELETE FROM PRODUCTS WHERE PRODUCT_ID='" + productID + "';";
      Statement select = con.createStatement();
      result = select.execute(sqlString);
    }
    catch(Exception e)
    {
      System.out.println("exception caught deleteing Product" + sqlString + " " + e.getMessage());
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
    return result;
  }
  public static String addProduct()
  {
    
    // move the product photo to the specified directory. The directory path should be stored in a resource file.
    
    //http://jakarta.apache.org/commons/fileupload/using.html
   // File
    
    
    Connection con = DatabaseConnector.getConnection();
    

    try
    {
      PreparedStatement ps = con.prepareStatement("INSERT INTO PRODUCTS (PRODUCT_NAME) values(?)");
      ps.setString(1,"New Product");

      ps.executeUpdate();

    }
    catch(Exception e)
    {
      System.out.println("exception caught inserting New Product into product table");
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

    return getJSONProducts();
  }

  public static String getJSONProducts()
  {
    return getProducts();
  }
  
  public static String getProducts()
  {
    Product product = new Product();
    String title = "products";
    Connection con = DatabaseConnector.getConnection();
    StringBuffer jsonString = new StringBuffer("\r\n{\"" + title + "\": [");
    String sqlString = "";

    try
    {
      sqlString = "SELECT * FROM PRODUCTS ORDER BY PRODUCT_ID DESC;";
      Statement select = con.createStatement();
      ResultSet result = select.executeQuery(sqlString);
      while (result.next())
      { // process results one row at a time

        product.setProductName(result.getString("PRODUCT_NAME"));
        product.setDescription(result.getString("DESCRIPTION"));
        product.setFilename(result.getString("FILENAME"));
        product.setPrice(result.getFloat("PRICE"));
        product.setProductId(result.getInt("PRODUCT_ID"));
        jsonString.append("\r\n{\"description\":\"" + product.getDescription() + 
                                "\",\"name\":\"" + product.getProductName() + 
                                "\",\"filename\":\"" + product.getFilename() + 
                                "\", \"price\":\"" + product.getPrice() +
                                "\", \"id\":\"" + product.getProductId() +
                                "\",\"imagepath\":\"" + imagePath +"/" + product.getFilename() + "\"},");

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
