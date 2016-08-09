package com.oreilly.ajax;

public class JavaScriptCode
{
  public static String getZipCodeScript(String stateId, String cityId, String zipcodeId,String url)
  {
    StringBuffer sb = new StringBuffer();
    sb.append("<script>    ");
    sb.append("function retrieveCityState(){ ");
    sb.append("   var zip = document.getElementById('"+zipcodeId+"');\n");
    sb.append("   var url = '"+url+"?zip=' + escape(zip.value);\n ");
    sb.append("   if (window.XMLHttpRequest){ \n");
    sb.append("             req = new XMLHttpRequest(); \n");
    sb.append("         } \n" );
    sb.append("         else if (window.ActiveXObject){ \n");
    sb.append("             req = new ActiveXObject('Microsoft.XMLHTTP'); \n");
    sb.append("        } ");
    sb.append("        req.open('Get',url,true); ");
    sb.append("       req.onreadystatechange = callbackCityState; ");
    sb.append("   alert ('sending request to '+url);");
    sb.append("        req.send(null);");
    sb.append("    }                   ");
    sb.append("function populateCityState(){");
    sb.append("   var jsonData = req.responseText;");
    sb.append("   var myJSONObject = eval('(' + jsonData + ')');");
    sb.append("   var city = document.getElementById('"+cityId+"');");
    sb.append("   city.value=myJSONObject.location.city;");
    sb.append("   var state = document.getElementById('"+stateId+"');");
    sb.append("   state.value=myJSONObject.location.state;");
    sb.append("}");
    sb.append("function callbackCityState(){ ");
    sb.append("   if (req.readyState==4){ ");
    sb.append("       if (req.status == 200){ ");
    sb.append("           populateCityState();");
    sb.append("       }");
    sb.append("   }");
    sb.append("}");
    sb.append("</script> "); 
    return sb.toString();
  }
}