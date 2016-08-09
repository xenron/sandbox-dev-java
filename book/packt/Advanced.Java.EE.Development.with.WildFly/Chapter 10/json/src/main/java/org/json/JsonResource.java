package org.json;

import java.io.StringReader;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.json.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("jaxrs")
public class JsonResource {
	
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public JsonArray getJsonMessage() {
        JsonReader jsonReader = Json.createReader(new StringReader("[{\"title\":\"PaaS Fits the Enterprise\",\"author\":\"David Baum\"},{\"title\":\"On Becoming Others, Limits, and Restoration\",\"author\":\"Tom Kyte\"}]"));

        JsonArray array = jsonReader.readArray();
        jsonReader.close();
        return array;

    }
    
    @Path("jsonp")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public JsonArray getJsonArray(@QueryParam("jsonObject") String jsonObjectStr) {
        JsonReader jsonReader = Json.createReader(new StringReader(jsonObjectStr));
        JsonObject jsonObject = jsonReader.readObject();
        jsonReader.close();
        JsonArray jsonArray = jsonObject.getJsonArray("catalog");
        return jsonArray;


    }

    
    @Path("post")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)  
    @Produces(MediaType.APPLICATION_JSON) 
    public JsonArray post(final JsonObject jsonObject) {
         JsonArray jsonArray = jsonObject.getJsonArray("catalog");

            return jsonArray;
    }

}
