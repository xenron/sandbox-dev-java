package com.oreilly.ajax;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JSONUtil
{

    public static String buildJSONArray(List list, String title)
    {
        StringBuffer returnJSON = new StringBuffer("\r\n{\"" + title + "\": [");
        String key = "username";
        String value = "";
        // loop through all the map entries.
        Iterator it = list.iterator();

        while (it.hasNext())
        {
            value = (String) it.next();
            returnJSON.append("\r\n{\"" + key + "\": \"" + value + "\"},");
        }
        // remove the last comma
        int lastCharIndex = returnJSON.length();
        returnJSON.deleteCharAt(lastCharIndex - 1);
        returnJSON.append("\r\n]}");
        return returnJSON.toString();
    }

    public static String buildJSON(HashMap map, String title)
    {
        StringBuffer returnJSON = new StringBuffer("\r\n{\"" + title + "\":{");
        String key = "";
        String value = "";
        // loop through all the map entries.
        Iterator it = map.entrySet().iterator();

        while (it.hasNext())
        {
            Map.Entry e = (Map.Entry) it.next();
            value = (String) e.getValue();
            key = (String) e.getKey();
            returnJSON.append("\r\n\"" + key + "\": \"" + value + "\",");
        }
        // remove the last comma
        int lastCharIndex = returnJSON.length();
        returnJSON.deleteCharAt(lastCharIndex - 1);
        returnJSON.append("\r\n}}");
        return returnJSON.toString();
    }

public static String convertMapToProducts(HashMap map, String title)
{
    StringBuffer returnJSON = new StringBuffer("\r\n{\"" + title + "\":[ ");
    String key = "";
    String value = "";
    // loop through all the map entries.
    Iterator it = map.entrySet().iterator();
    Product product = null;
    String totalCostFormatted="";
    
    DecimalFormat nf = new DecimalFormat("###,###.##");
    float itemTotalCost = 0.0F;
    float totalCost = 0.0F;
    while (it.hasNext())
    {
        Map.Entry e = (Map.Entry) it.next();
        value = (String) e.getValue();  //Item quantity
        key = (String) e.getKey();      //Item id
        product = ProductManager.getProductById(key);
        if (value!=null) //if the count is null, we don't care (not in shopping cart)
        {
        int intValue = Integer.parseInt(value);
        itemTotalCost =  intValue * product.getPrice();
        totalCost += itemTotalCost;
      
        returnJSON.append("\r\n{\"product\":\"" + product.getProductName() + 
                "\",\"price\":\"" + nf.format(product.getPrice()) + 
                "\",\"filename\":\"" + product.getFilename() + 
                "\",\"total\":\"" +  nf.format(itemTotalCost) + 
                "\",\"description\":\"" + product.getDescription() + 
                "\", \"value\":\"" + value + "\"},");
        }
    }
    totalCostFormatted = nf.format(totalCost);
    
    returnJSON.append("\r\n{\"total\":\""+totalCostFormatted+"\"}");
    returnJSON.append("\r\n]}");
    
    return returnJSON.toString();
}
}
