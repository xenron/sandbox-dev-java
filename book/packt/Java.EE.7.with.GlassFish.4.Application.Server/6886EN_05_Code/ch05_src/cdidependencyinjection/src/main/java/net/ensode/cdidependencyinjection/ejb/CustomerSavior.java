package net.ensode.cdidependencyinjection.ejb;

import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import net.ensode.cdidependencyinjection.beans.Customer;

@Stateless
@LocalBean
@Named
public class CustomerSavior {

  private static final Logger logger = Logger.getLogger(
      CustomerSavior.class.getName());
  @Inject
  private Customer customer;

  public String saveCustomer() {

    logger.info("Saving the following information \n" + customer.
        toString());

    return "confirmation";
  }
}
