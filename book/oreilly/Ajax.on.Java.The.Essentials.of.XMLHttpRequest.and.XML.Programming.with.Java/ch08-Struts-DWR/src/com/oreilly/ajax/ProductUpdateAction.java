package com.oreilly.ajax;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

public class ProductUpdateAction {
  
/**
 * the product information class that supports Ajax (using JSON)
 * @return
 */
    private static String getProducts()
    {
        return ProductManager.getProducts();
    }
  
    private static String addProduct(){
        return null;
    }
}               
            

