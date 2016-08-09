package net.ensode.glassfishbook.jpa.beanvalidation;

import java.io.IOException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@WebServlet(urlPatterns={"/beanvalidation"})
public class JpaBeanValidationDemoServlet extends HttpServlet {

  @PersistenceUnit(unitName = "customerPersistenceUnit")
  private EntityManagerFactory entityManagerFactory;
  @Resource
  private UserTransaction userTransaction;

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    EntityManager entityManager = entityManagerFactory.
        createEntityManager();

    Customer customer = new Customer();
    Customer customer2 = new Customer();
    Customer customer3;

    customer.setCustomerId(10L);
    customer.setFirstName(null);
    customer.setLastName("McKenzie");
    customer.setEmail("jamesm@notreal.com");

    customer2.setCustomerId(11L);
    customer2.setFirstName("Charles");
    customer2.setLastName("Thispersonhasalonglastname");
    customer2.setEmail("cjohnson@phony.org");

    try {
      userTransaction.begin();
      entityManager.persist(customer);
      entityManager.persist(customer2);

      customer3 = entityManager.find(Customer.class, 4L);
      customer3.setLastName("Johnson");
      entityManager.persist(customer3);

      entityManager.remove(customer);

      userTransaction.commit();
    } catch (NotSupportedException e) {
      e.printStackTrace();
    } catch (SystemException e) {
      e.printStackTrace();
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (IllegalStateException e) {
      e.printStackTrace();
    } catch (RollbackException e) {
      e.printStackTrace();
    } catch (HeuristicMixedException e) {
      e.printStackTrace();
    } catch (HeuristicRollbackException e) {
      e.printStackTrace();
    }

    response.getWriter().println("Database Updated Successfully");
  }
}
