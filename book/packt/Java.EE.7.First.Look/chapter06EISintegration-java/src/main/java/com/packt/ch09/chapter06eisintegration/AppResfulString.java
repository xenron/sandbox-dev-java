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
public class AppResfulString {

    public static void main(String[] args) throws IOException {    
        String baseURI = "http://localhost:8080/chapter06EISintegration-web";
        String location = "/rs-resources";
        String method = "/students/getListOfAllStudents";
        Client client = ClientBuilder.newClient();
        WebTarget target = (WebTarget) client.target(baseURI+location+method);     
        System.out.println("response : "+target.request(MediaType.APPLICATION_JSON).get(String.class));       
//        ObjectMapper mapper = new ObjectMapper();
//        List<Student> list = new ArrayList<Student>();
//        String value = target.request(MediaType.APPLICATION_JSON).get(String.class);
//        list = mapper.readValue(value, list.getClass());
//        System.out.println(list);
    }
}
