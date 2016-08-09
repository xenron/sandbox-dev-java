package com.ensode.jaxrsintroclient;

import com.ensode.jaxbxmlconversion.entity.Customer;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterface;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

public class App {

  private WebResource baseUriWebResource;
  private WebResource webResource;
  private Client client;
  private static final String BASE_URI =
      "http://localhost:8080/jaxbxmlconversion/resources";

  public static void main(String[] args) {
    App app = new App();
    app.initWebResource();
    app.getCustomer();
    app.insertCustomer();
  }

  private void initWebResource() {
    com.sun.jersey.api.client.config.ClientConfig config =
        new com.sun.jersey.api.client.config.DefaultClientConfig();
    client = Client.create(config);
    baseUriWebResource = client.resource(BASE_URI);
    webResource = baseUriWebResource.path("customer");
  }

  public void getCustomer() {
    UniformInterface uniformInterface = webResource.type(
        MediaType.TEXT_XML);
    Customer customer =
        uniformInterface.get(Customer.class);
    System.out.println("customer = " + customer);
  }

  public void insertCustomer() {

    Customer customer = new Customer(234L, "Tamara", "A",
        "Graystone");


    UniformInterface uniformInterface = webResource.type(
        MediaType.TEXT_XML);
    uniformInterface.put(customer);

  }
}
