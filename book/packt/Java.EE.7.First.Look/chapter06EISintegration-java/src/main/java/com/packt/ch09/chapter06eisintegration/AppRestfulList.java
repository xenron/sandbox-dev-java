package com.packt.ch09.chapter06eisintegration;

import com.packt.ch06.entities.Student;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

/**
 * Hello world!
 *
 */
public class AppRestfulList {

    public static void main(String[] args) throws IOException {    
        String baseURI = "http://localhost:8080/chapter06EISintegration-web";
        String location = "/rs-resources";
        String method = "/students/getListOfAllStudents";
        Client client = ClientBuilder.newClient();
        WebTarget target = (WebTarget) client.target(baseURI+location+method);     
       
        GenericType<List<Student>> result = new GenericType<List<Student>>() {};        
        List<Student> listOfStudents = client.target(baseURI+location+method)
//                       .request(MediaType.APPLICATION_XML)
                       .request(MediaType.APPLICATION_JSON)
                       .get(result);
        
        System.out.println("listMusic : "+listOfStudents);
    }
}
