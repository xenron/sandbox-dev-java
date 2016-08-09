<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="javax.ws.rs.client.*,java.io.StringReader,javax.json.*,javax.json.stream.*,javax.ws.rs.core.*"%>
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
                builder=builder.add("catalog", Json.createArrayBuilder().add(Json.createObjectBuilder().add("title","PaaS Fits the Enterprise").add("author","David Baum")).add(Json.createObjectBuilder().add("title","On Becoming Others, Limits, and Restoration").add("author","Tom Kyte")));
                
                JsonObject jsonObject = builder.build();
                Client client = ClientBuilder.newClient();
 JsonArray array = client.target("http://localhost:8080/json").path("resources").path("jaxrs").path("post").request(MediaType.APPLICATION_JSON).buildPost(Entity.json(jsonObject)).invoke(JsonArray.class);
 JsonObject catalog=array.getJsonObject(0);
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
