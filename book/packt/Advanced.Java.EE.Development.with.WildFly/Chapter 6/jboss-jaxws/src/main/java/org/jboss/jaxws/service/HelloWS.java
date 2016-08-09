package org.jboss.jaxws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "HelloWS",   targetNamespace = "http://org.jboss.jaxws.service/")
public interface HelloWS {
	@WebMethod(operationName = "hello")
	public String sayHello(String name);

}
