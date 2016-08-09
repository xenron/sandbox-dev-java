package com.packt.ch09.chapter06eisintegration;

import java.util.Date;
import java.util.concurrent.Future;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Hello world!
 *
 */
public class AppAsynchronousRestfulServer {

    public static void main(String[] args) {    
        String baseURI = "http://localhost:8080/chapter06EISintegration-web";
        String location = "/rs-resources";
        String method = "/students/getListOfAllStudentsAs2";
        Client client = ClientBuilder.newClient();
        WebTarget target = (WebTarget) client.target(baseURI+location+method);   
        System.out.println("Before response : "+new Date());
        System.out.println("Response : "+ target.request(MediaType.APPLICATION_JSON).get(String.class));                    
        System.out.println("After Response : "+new Date());
    }    
}
