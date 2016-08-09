package com.baselogic.javaee6.jaxrs.resources;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.WebFault;

@WebFault
public class CustomerNotFoundFault extends Exception {
    private static final long serialVersionUID = 1L;

    @XmlElement
    private CustomerNotFoundDetails details;

    public CustomerNotFoundFault(String errorMessage) {
        super(errorMessage);
    }

    public CustomerNotFoundFault(String errorMessage, CustomerNotFoundDetails details) {
        super(errorMessage);
        this.details = details;
    }

    public CustomerNotFoundDetails getFaultInfo() {
        return details;
    }
}
