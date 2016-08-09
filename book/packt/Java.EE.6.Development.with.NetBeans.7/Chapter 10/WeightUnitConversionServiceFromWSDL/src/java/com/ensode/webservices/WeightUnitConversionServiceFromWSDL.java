/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensode.webservices;

import javax.jws.WebService;

/**
 *
 * @author heffel
 */
@WebService(serviceName = "WeightUnitConversionService",
portName = "WeightUnitConversionServicePort",
endpointInterface = "com.ensode.webservices.WeightUnitConversionService", targetNamespace = "http://webservices.ensode.com/",
wsdlLocation = "WEB-INF/wsdl/WeightUnitConversionServiceFromWSDL/localhost_8080/WeightUnitConversionService/WeightUnitConversionService.wsdl")
public class WeightUnitConversionServiceFromWSDL {

    public double kilosToPounds(double kilos) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public double poundsToKilos(double pounds) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
