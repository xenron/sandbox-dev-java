<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="javax.json.*, java.io.*,javax.json.stream.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSON Array</title>
    </head>
    <body>
        <% 				 
                JsonObjectBuilder builder = Json.createObjectBuilder();
                builder=builder.add("journal", "Oracle Magazine");

                builder=builder.add("edition", Json.createObjectBuilder().add("date","March April 2013").add("cover", "Public Cloud. Private Cloud"));
                builder=builder.add("catalog", Json.createArrayBuilder().add(Json.createObjectBuilder().add("title","PaaS Fits the Enterprise").add("author","David Baum")) .add(Json.createObjectBuilder().add("title","On Becoming Others, Limits, and Restoration").add("author","Tom Kyte")));
                
                JsonObject value = builder.build();
                JsonWriter jsonWriter= Json.createWriter(new FileOutputStream(new File("C:/json/jsonOutput.txt")));
                jsonWriter.writeObject(value); 
                jsonWriter.close();
                out.println("JSON Array output to jsonOutput.txt");
        
     /**    JsonBuilderFactory factory = Json.createBuilderFactory(null);
         JsonObjectBuilder builder = factory.createObjectBuilder();
                builder=builder.add("journal", "Oracle Magazine");

                builder=builder.add("edition", factory.createObjectBuilder().add("date","March April 2013").add("cover", "Public Cloud. Private Cloud"));
                builder=builder.add("catalog", factory.createArrayBuilder().add(factory.createObjectBuilder().add("title","PaaS Fits the Enterprise").add("author","David Baum")) .add(factory.createObjectBuilder().add("title","On Becoming Others, Limits, and Restoration").add("author","Tom Kyte")));
                
                JsonObject value = builder.build();
                JsonWriterFactory jsonWriterFactory = Json.createWriterFactory(null);
                JsonWriter jsonWriter= jsonWriterFactory.createWriter(new FileOutputStream(new File("C:/json/jsonOutput.txt")));
                jsonWriter.writeObject(value); 
                jsonWriter.close();
                out.println("JSON Array output to jsonOutput.txt");
*/
        
    /**    JsonGeneratorFactory factory = Json.createGeneratorFactory(null);
        JsonGenerator generator = factory.createGenerator(new FileOutputStream(new File("C:/json/jsonOutput.txt")));
  
       //  JsonGenerator generator = Json.createGenerator(new FileOutputStream(new File("C:/json/jsonOutput.txt")));
         generator
     .writeStartObject()
         .write("journal", "Oracle Magazine")
         .writeStartObject("edition")
             .write("date", "March April 2013")
             .write("cover", "Public Cloud. Private Cloud")
         .writeEnd()
         .writeStartArray("catalog")
             .writeStartObject()
                 .write("title", "PaaS Fits the Enterprise")
                 .write("author", "David Baum")
             .writeEnd()
             .writeStartObject()
                 .write("title", "On Becoming Others, Limits, and Restoration")
                 .write("author", "Tom Kyte")
             .writeEnd()
         .writeEnd()
     .writeEnd();
 generator.close();
  out.println("JSON Array output to jsonOutput.txt");*/
        %>
    </body>
</html>
