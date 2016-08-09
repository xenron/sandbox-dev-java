package com.oreilly.ajax;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RicoUtil
{
   
    public static String buildRicoXML(HashMap map, String message)
    {
        StringBuffer ricoXML = new StringBuffer("<ajax-response>");
        String key = "";
        String value = "";
        // loop through all the map entries.
        Iterator it = map.entrySet().iterator();

        while (it.hasNext())
        {
            Map.Entry e = (Map.Entry) it.next();
            value = (String) e.getValue();
            key = (String) e.getKey();
            ricoXML.append("\r\n <response type=\"element\" id=\"" + key + "\">" + value + "</response>");
        }
        ricoXML.append("\r\n <response type=\"element\" id=\"message\" name=\"message\">"+message+"</response>");
        ricoXML.append("\r\n</ajax-response>");
        return ricoXML.toString();
    }
    public static String buildRicoXML(HashMap map,String element, String message)
    {
        StringBuffer ricoXML = new StringBuffer("<ajax-response>");
        String key = "";
        String value = "";
        // loop through all the map entries.
        Iterator it = map.entrySet().iterator();

        while (it.hasNext())
        {
            Map.Entry e = (Map.Entry) it.next();
            value = (String) e.getValue();
            key = (String) e.getKey();
            ricoXML.append("\r\n <response type=\"element\" id=\"" + key + "\">" + "<input type=\"text\" id=\"inner"+key+"\" name=\"inner"+key+"\" value=\""+value+"\" /></response>");
        }
        ricoXML.append("\r\n <response type=\"element\" id=\"message\" name=\"message\">"+message+"</response>");
        ricoXML.append("\r\n</ajax-response>");
        return ricoXML.toString();
    }
}
