package com.packt.ch09.chapter06eisintegration;

import java.io.IOException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Hello world!
 *
 */
public class App {

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
