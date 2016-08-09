package net.ensode.glassfishbook;

import javax.ejb.EJB;

public class Client
{
  @EJB
  private static CustomerDaoRollback customerDaoRollback;

  public static void main(String[] args)
  {
    Customer customer;

    customer = new Customer();
    customer.setFirstName("Jason");
    customer.setLastName("Hunter");
    customer.setEmail("jhunter@servlets.com");
    
    customerDaoRollback.updateCustomer(customer);
  }
}
