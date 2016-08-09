package com.ensode.queryparamsclient;

import com.ensode.queryparamsclient.entity.Customer;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class App {

  private WebResource baseUriWebResource;
  private WebResource webResource;
  private Client client;
  private static final String BASE_URI =
      "http://localhost:8080/queryparams/resources";

  public static void main(String[] args) {
    App app = new App();
    app.initWebResource();
    app.getCustomer();
  }

  private void initWebResource() {
    com.sun.jersey.api.client.config.ClientConfig config =
        new com.sun.jersey.api.client.config.DefaultClientConfig();
    client = Client.create(config);
    baseUriWebResource = client.resource(BASE_URI);
    webResource = baseUriWebResource.path("customer/1");
  }

  public void getCustomer() {
    Customer customer =
        (Customer) webResource.get(Customer.class);
    System.out.println("customer = " + customer);
  }
}
