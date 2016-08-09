package com.baselogic.javaee6.jaxrs.resources;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public final class JAXWSClient {

    private CustomerService customerService;
    private String serviceUrl;

    public JAXWSClient(String serviceUrl) {
        this.serviceUrl = serviceUrl;
        JaxWsProxyFactoryBean cfb = new JaxWsProxyFactoryBean();
        cfb.setServiceClass(CustomerService.class);
        cfb.setAddress(serviceUrl);
        customerService = (CustomerService) cfb.create();
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }
}