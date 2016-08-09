package net.ensode.glassfishbook.entityrelationships;

import java.io.IOException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

public class OneToOneRelationshipDemoServlet extends HttpServlet
{
  @PersistenceUnit(unitName = "customerPersistenceUnit")
  private EntityManagerFactory entityManagerFactory;

  @Resource
  private UserTransaction userTransaction;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
  {
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    Customer customer;
    LoginInfo loginInfo = new LoginInfo();

    loginInfo.setLoginInfoId(1L);
    loginInfo.setLoginName("charlesj");
    loginInfo.setPassword("iwonttellyou");    

    try
    {
      userTransaction.begin();

      customer = entityManager.find(Customer.class, 4L);
      loginInfo.setCustomer(customer);

      entityManager.persist(loginInfo);
      
      userTransaction.commit();

      response.getWriter().println("Database updated successfully.");
    }
    catch (NotSupportedException e)
    {
      e.printStackTrace();
    }
    catch (SystemException e)
    {
      e.printStackTrace();
    }
    catch (SecurityException e)
    {
      e.printStackTrace();
    }
    catch (IllegalStateException e)
    {
      e.printStackTrace();
    }
    catch (RollbackException e)
    {
      e.printStackTrace();
    }
    catch (HeuristicMixedException e)
    {
      e.printStackTrace();
    }
    catch (HeuristicRollbackException e)
    {
      e.printStackTrace();
    }
  }
}
