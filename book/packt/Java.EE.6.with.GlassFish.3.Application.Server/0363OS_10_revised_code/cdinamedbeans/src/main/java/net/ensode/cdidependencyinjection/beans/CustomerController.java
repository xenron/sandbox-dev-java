package net.ensode.cdidependencyinjection.beans;

import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CustomerController {

  private static final Logger logger = Logger.getLogger(
      CustomerController.class.getName());
  @Inject
  private Customer customer;

  public String saveCustomer() {

    logger.info("Saving the following information \n" + customer.
        toString());

    return "confirmation";
  }
}
