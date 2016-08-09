package net.ensode.glassfishbook.jsfjpa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;

@ManagedBean
public class CustomerController {

  @Resource(name = "jdbc/__CustomerDBPool")
  private DataSource dataSource;
  @PersistenceUnit(unitName = "customerPersistenceUnit")
  private EntityManagerFactory entityManagerFactory;
  @Resource
  private UserTransaction userTransaction;
  @ManagedProperty(value = "#{customer}")
  private Customer customer;

  public String saveCustomer() {
    String returnValue = "customer_saved";
    EntityManager entityManager = entityManagerFactory.
        createEntityManager();

    try {
      userTransaction.begin();
      entityManager.persist(customer);
      userTransaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
      returnValue = "error_saving_customer";
    }

    return returnValue;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}
