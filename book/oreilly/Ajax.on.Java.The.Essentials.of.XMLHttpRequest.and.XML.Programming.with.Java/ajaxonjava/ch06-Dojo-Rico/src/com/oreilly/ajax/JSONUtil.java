package com.oreilly.ajax;

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
}
