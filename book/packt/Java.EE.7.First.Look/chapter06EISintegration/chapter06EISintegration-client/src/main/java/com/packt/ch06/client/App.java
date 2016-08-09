package com.packt.ch06.client;

import com.packt.ch06.entities.Student;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

/**
 * Enterprise Application Client main class.
 *
 */
public class App {
    
    public static void main( String[] args ) {
//        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target("http://localhost:8080/chapter06EISintegration-web/rs-resources/students");
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/chapter06EISintegration-web/rs-resources/students/getListOfStudents");  
        GenericType<List<Student>> list = new GenericType<List<Student>>() {};
        System.out.println(target.request(MediaType.APPLICATION_JSON).get(list));
    }
}
