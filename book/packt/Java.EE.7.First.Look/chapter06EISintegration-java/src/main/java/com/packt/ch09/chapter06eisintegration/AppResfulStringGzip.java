package com.packt.ch09.chapter06eisintegration;

import com.packt.ch06.entities.Student;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

/**
 * Hello world!
 *
 */
public class AppResfulStringGzip {

    public static void main(String[] args) throws IOException {
        String baseURI = "http://localhost:8080/chapter06EISintegration-web";
        String location = "/rs-resources";
        String method = "/students/getListOfAllStudentsGzip";
        Client client = ClientBuilder.newClient().register(MyGzipReaderJaxRsInterceptor.class);
        WebTarget target = (WebTarget) client.target(baseURI + location + method);
        System.out.println("response : " + target.request(MediaType.APPLICATION_JSON).get(String.class));
        
    }
}
