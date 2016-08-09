package hellowebservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "HelloWS", targetNamespace = "http://hellowebservice/")
public interface HelloWS {

	@WebMethod(operationName = "hello")
	public String hello(String name);
}