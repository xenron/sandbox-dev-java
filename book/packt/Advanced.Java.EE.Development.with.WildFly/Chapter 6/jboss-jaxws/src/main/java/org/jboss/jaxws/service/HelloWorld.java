package org.jboss.jaxws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(portName = "HelloWorldPort",     serviceName = "HelloWorldService", targetNamespace = "http://org.jboss.jaxws.service/", endpointInterface = "org.jboss.jaxws.service.HelloWS")
public class HelloWorld implements HelloWS{

	@WebMethod() 
	public String sayHello( String name) {
	   
	    return "Hello "+name +" Welcome to Web Services!";
	    
	}
}
