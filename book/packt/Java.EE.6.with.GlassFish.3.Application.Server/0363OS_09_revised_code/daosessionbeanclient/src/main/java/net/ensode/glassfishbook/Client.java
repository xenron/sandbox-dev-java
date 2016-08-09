package net.ensode.glassfishbook;

import javax.ejb.EJB;
import javax.naming.InitialContext;
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
  private static CustomerDaoBean customerDao;

  public static void main(String[] args)
  {
    UserTransaction userTransaction;
    Customer customer;

    customer = new Customer();
    customer.setFirstName("David");
    customer.setLastName("Geary");
    customer.setEmail("clarity.training@gmail.com");

    try
    {
      InitialContext initialContext = new InitialContext();
      userTransaction = (UserTransaction)initialContext.lookup("java:comp/UserTransaction");
      
      userTransaction.begin();
      customerDao.saveCustomer(customer);
      userTransaction.commit();
    }
    catch (NotSupportedException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch (SystemException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch (NamingException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
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
    catch (RollbackException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch (HeuristicMixedException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch (HeuristicRollbackException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
   

    
    

  }
}
