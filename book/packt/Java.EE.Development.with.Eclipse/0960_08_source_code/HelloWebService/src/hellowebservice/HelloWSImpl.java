package hellowebservice;

import javax.jws.*;

@WebService(portName = "HelloWSPort", serviceName = "HelloWSService", targetNamespace = "http://hellowebservice/", endpointInterface = "hellowebservice.HelloWS")
public class HelloWSImpl implements HelloWS {

	public String hello(String name) {
		 
		 return "Hello "+name +" Welcome to Web Services!";

	}
}
