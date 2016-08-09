package net.ensode.glassfishbook;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;

public class CalculatorServiceClient {

  
  @WebServiceRef(
  wsdlLocation =
  "http://localhost:8080/securecalculatorservice/CalculatorService?wsdl")
  private static CalculatorService calculatorService;

  public void calculate() {
    //add a user named "joe" with a password of "password"
    //to the file realm to successfuly execute the web service.
    //"joe" must belong to the group "appuser".
    Calculator calculator = calculatorService.getCalculatorPort();
    ((BindingProvider) calculator).getRequestContext().put(
        BindingProvider.USERNAME_PROPERTY, "joe");
    ((BindingProvider) calculator).getRequestContext().put(
        BindingProvider.PASSWORD_PROPERTY, "password");

    System.out.println("1 + 2 = " + calculator.add(1, 2));
    System.out.println("1 - 2 = " + calculator.subtract(1, 2));
  }

  public static void main(String[] args) {
    new CalculatorServiceClient().calculate();
  }
}
