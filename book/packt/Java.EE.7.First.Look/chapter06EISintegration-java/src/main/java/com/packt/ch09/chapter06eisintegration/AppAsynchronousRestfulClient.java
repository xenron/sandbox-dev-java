package com.packt.ch09.chapter06eisintegration;

import com.packt.ch06.entities.Student;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;
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
public class AppAsynchronousRestfulClient {

    public static void main(String[] args) {    
        String baseURI = "http://localhost:8080/chapter06EISintegration-web";
        String location = "/rs-resources";
        String method = "/students/getListOfAllStudentsAs";
        Client client = ClientBuilder.newClient();
        WebTarget target = (WebTarget) client.target(baseURI+location+method);   
        System.out.println("Before response : "+new Date());
        Future<String> response = target.request(MediaType.APPLICATION_JSON).async().get(String.class);            
        
        new PassiveWaiting(response).start();   
        
        System.out.println("After PassiveWaiting : "+new Date());
    }
    
    static class PassiveWaiting extends Thread {
        Future<String> response;
        
        public PassiveWaiting(Future<String> response){
            this.response = response;
        }
        
        public void run(){
            try{
            System.out.println("response : "+response.get()+", time : "+new Date());
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
