package hellowebserviceclient;

import hellowebservice.*;
import javax.xml.ws.WebServiceRef;




public class HelloWSClient {
	public static void main(String[] args) {
		
	
	     HelloWSService service=new HelloWSService();
		
	     hellowebserviceclient.HelloWS port = service.getHelloWSPort();
	     String result = port.hello("John Smith");
	     System.out.println(result);
	   }
}

