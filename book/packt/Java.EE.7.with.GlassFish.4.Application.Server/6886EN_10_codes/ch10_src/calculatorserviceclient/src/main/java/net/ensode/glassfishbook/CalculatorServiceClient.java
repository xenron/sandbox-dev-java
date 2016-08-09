package net.ensode.glassfishbook;

import javax.xml.ws.WebServiceRef;

public class CalculatorServiceClient {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/calculatorservice/CalculatorService?wsdl")
    private static CalculatorService calculatorService;

    public void calculate() {
        Calculator calculator = calculatorService.getCalculatorPort();

        System.out.println("1 + 2 = "
                + calculator.add(1, 2));
        System.out.println("1 - 2 = "
                + calculator.subtract(1, 2));
    }

    public static void main(String[] args) {
        new CalculatorServiceClient().calculate();
    }
}
