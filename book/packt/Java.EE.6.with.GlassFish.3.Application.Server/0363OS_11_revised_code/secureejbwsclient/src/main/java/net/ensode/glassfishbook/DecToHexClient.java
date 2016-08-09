package net.ensode.glassfishbook;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;

public class DecToHexClient {


  @WebServiceRef(
  wsdlLocation =
  "http://localhost:8080/SecureDecToHexBeanService/SecureDecToHexBean?wsdl")
  private static SecureDecToHexBeanService secureDecToHexBeanService;

  public void convert() {
    SecureDecToHexBean secureDecToHexBean = secureDecToHexBeanService.
        getSecureDecToHexBeanPort();
    ((BindingProvider) secureDecToHexBean).getRequestContext().put(
        BindingProvider.USERNAME_PROPERTY, "joe");
    ((BindingProvider) secureDecToHexBean).getRequestContext().put(
        BindingProvider.PASSWORD_PROPERTY, "password");

    System.out.println("decimal 4013 in hex is: "
        + secureDecToHexBean.convertDecToHex(4013));
  }

  public static void main(String[] args) {
    new DecToHexClient().convert();
  }
}
