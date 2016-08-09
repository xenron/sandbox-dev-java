<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.json.*, java.io.*,javax.json.stream.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parse JSon</title>
    </head>
    <body>
        <h1></h1>
        <% 
        
    /* JsonParser parser=Json.createParser(new FileInputStream(new File("C:/json/jsonOutput.txt")));
    
    while(parser.hasNext()){
        
        JsonParser.Event parsingState= parser.next();
        
        switch(parsingState){
                 case END_ARRAY:
                      out.println("End of a JSON array");
                      out.println("<br/>");
                     break;
                                case START_ARRAY:
                                   out.println("Start of a JSON array");
                                       out.println("<br/>");
                     break;
                     
                     case END_OBJECT:
                                    out.println("End of a JSON object");
                                        out.println("<br/>");
                     break;
                     
                     case KEY_NAME:
                                    out.println("Name in a name/value pair of a JSON object:");
                                    out.println(parser.getString());
                                        out.println("<br/>");
                     break;
                     	
                       case START_OBJECT:
                                    out.println("Start of a JSON object");
                                 
                                        out.println("<br/>");
                     break;
                     
                      case VALUE_STRING:
                                    out.println("String value in a JSON array or object:");
                                 out.println(parser.getString());
                                        out.println("<br/>");
                     break;
                     
                      case VALUE_NUMBER:
                                    out.println("Number value in a JSON array or object:");
                                 out.println(parser.getString());
                                        out.println("<br/>");
                     break;
                     
                           case VALUE_TRUE:
                                    out.println("true value in a JSON array or object");
                                 
                                        out.println("<br/>");
                     break;
                     
                      case VALUE_NULL:
                                    out.println("null value in a JSON array or object");
                                 
                                        out.println("<br/>");
                     break;
                                                
                                                 case VALUE_FALSE:
                                    out.println("false value in a JSON array or object");
                                 
                                        out.println("<br/>");
                     break;
        }
               
    }
 */
        /**
           // 1  JsonParser parser=Json.createParser(new FileInputStream(new File("C:/json/jsonOutput.txt")));
        
      //2  JsonParserFactory factory = Json.createParserFactory(null);
 //JsonParser parser = factory.createParser(new FileInputStream(new File("C:/json/jsonOutput.txt")));
        
    //3    StringReader reader = new StringReader("{\"journal\":\"Oracle Magazine\",\"edition\":{\"date\":\"March April 2013\",\"cover\":\"Public Cloud. Private Cloud\"},\"catalog\":[{\"title\":\"PaaS Fits the Enterprise\",\"author\":\"David Baum\"},{\"title\":\"On Becoming Others, Limits, and Restoration\",\"author\":\"Tom Kyte\"}]}");
    // JsonParser parser = Json.createParser(reader);
    while(parser.hasNext()){
        
        JsonParser.Event parsingState= parser.next();
        
        switch(parsingState){
                 case END_ARRAY:
                      out.println("End of a JSON array");
                      out.println("<br/>");
                     break;
                                case START_ARRAY:
                                   out.println("Start of a JSON array");
                                       out.println("<br/>");
                     break;
                     
                     case END_OBJECT:
                                    out.println("End of a JSON object");
                                        out.println("<br/>");
                     break;
                     
                     case KEY_NAME:
                                    out.println("Name in a name/value pair of a JSON object:");
                                    out.println(parser.getString());
                                        out.println("<br/>");
                     break;
                     
                       case START_OBJECT:
                                    out.println("Start of a JSON object");
                                 
                                        out.println("<br/>");
                     break;
                     
                      case VALUE_STRING:
                                    out.println("String value in a JSON array or object:");
                                 out.println(parser.getString());
                                        out.println("<br/>");
                     break;
                     
                      case VALUE_NUMBER:
                                    out.println("Number value in a JSON array or object:");
                                 out.println(parser.getString());
                                        out.println("<br/>");
                     break;
                     
                           case VALUE_TRUE:
                                    out.println("true value in a JSON array or object");
                                 
                                        out.println("<br/>");
                     break;
                     
                      case VALUE_NULL:
                                    out.println("null value in a JSON array or object");
                                 
                                        out.println("<br/>");
                     break;
       
                                                 case VALUE_FALSE:
                                    out.println("false value in a JSON array or object");
                                 
                                        out.println("<br/>");
                     break;
             
             
        }
               
    }*/
     
         JsonReaderFactory factory = Json.createReaderFactory(null);
   //    JsonReader jsonReader = Json.createReader(new StringReader("[{\"title\":\"PaaS Fits the Enterprise\",\"author\":\"David Baum\"},{\"title\":\"On Becoming Others, Limits, and Restoration\",\"author\":\"Tom Kyte\"}]"));
 
 JsonReader jsonReader = factory.createReader(new StringReader("[{\"title\":\"PaaS Fits the Enterprise\",\"author\":\"David Baum\"},{\"title\":\"On Becoming Others, Limits, and Restoration\",\"author\":\"Tom Kyte\"}]"));
 JsonArray array = jsonReader.readArray();
 jsonReader.close();
 
  JsonObject catalog = array.getJsonObject(0);
  
  out.println("Title: "+catalog.getString("title"));
   out.println("<br/>");
   out.println("Author: "+catalog.getString("author"));
   out.println("<br/>");
   
   JsonObject catalog2 = array.getJsonObject(1);
  
  out.println("Title: "+catalog2.getString("title"));
   out.println("<br/>");
   out.println("Author: "+catalog2.getString("author"));
   out.println("<br/>");
 
    
        
        %>
    </body>
</html>
