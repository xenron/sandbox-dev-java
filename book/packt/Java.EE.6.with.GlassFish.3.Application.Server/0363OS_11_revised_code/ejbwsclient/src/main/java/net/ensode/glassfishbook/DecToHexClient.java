package net.ensode.glassfishbook;

import javax.xml.ws.WebServiceRef;

public class DecToHexClient {

  @WebServiceRef(wsdlLocation =
  "http://localhost:8080/DecToHexBeanService/DecToHexBean?wsdl")
  private static DecToHexBeanService decToHexBeanService;

  public void convert() {
    DecToHexBean decToHexBean = decToHexBeanService.
        getDecToHexBeanPort();

    System.out.println("decimal 4013 in hex is: "
        + decToHexBean.convertDecToHex(4013));
  }

  public static void main(String[] args) {
    new DecToHexClient().convert();
  }
}
