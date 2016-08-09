package com.baselogic.javaee6.jaxrs.resources;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.ResponseExceptionMapper;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Collections;

public final class JAXRSClient {

    private CustomerService customerService;
    private String serviceUrl;

    public JAXRSClient(String serviceUrl) {
        this.serviceUrl = serviceUrl;
        customerService = (CustomerService) JAXRSClientFactory.create(
                serviceUrl,
                CustomerService.class,
                Collections.singletonList(new TestResponseExceptionMapper()));
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public static class TestResponseExceptionMapper implements ResponseExceptionMapper<CustomerNotFoundFault> {

        public TestResponseExceptionMapper() {
        }

        public CustomerNotFoundFault fromResponse(Response r) {
            Object value = r.getMetadata().getFirst("CUSTOMER-HEADER");
            if (value != null) {
                return new CustomerNotFoundFault(value.toString());
            }
            throw new WebApplicationException();
        }
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }
}
