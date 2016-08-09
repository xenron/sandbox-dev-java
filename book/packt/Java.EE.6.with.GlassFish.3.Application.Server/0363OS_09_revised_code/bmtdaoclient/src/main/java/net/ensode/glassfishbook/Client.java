package net.ensode.glassfishbook;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

public class Client
{
  @EJB
  private static CustomerDaoBmt customerDaoBmt;

  public static void main(String[] args)
  {
    ArrayList<Customer> customerList = new ArrayList<Customer>();
    Customer customer;

    customer = new Customer();
    customer.setFirstName("Brenda");
    customer.setLastName("Starr");
    customer.setEmail("brendas@fake.it");
    
    customerList.add(customer);
    
    customer = new Customer();
    customer.setFirstName("George");
    customer.setLastName("Lopez");
    customer.setEmail("jlopez@email.com");
    
    customerList.add(customer);

    try
    {
      customerDaoBmt.saveMultipleNewCustomers(customerList);
    }
    catch (SecurityException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch (IllegalStateException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
