package net.ensode.glassfishbook.jsfjpa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;

public class CustomerController
{
  @Resource(name = "jdbc/__CustomerDBPool")
  private DataSource dataSource;

  @PersistenceUnit(unitName = "customerPersistenceUnit")
  private EntityManagerFactory entityManagerFactory;

  @Resource
  private UserTransaction userTransaction;

  private Customer customer;

  public String saveCustomer()
  {
    String returnValue = "success";
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    try
    {
      userTransaction.begin();
      
      Long customerId = getNewCustomerId();
      customer.setCustomerId(customerId);
      entityManager.persist(customer);
      
      userTransaction.commit();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      returnValue = "failure";
    }

    return returnValue;
  }

  private Long getNewCustomerId()
  {
    Connection connection;
    Long newCustomerId = null;
    try
    {
      connection = dataSource.getConnection();
      PreparedStatement preparedStatement = connection
          .prepareStatement("select max(customer_id)+1 as new_customer_id from customers");

      ResultSet resultSet = preparedStatement.executeQuery();

      if (resultSet != null && resultSet.next())
      {
        newCustomerId = resultSet.getLong("new_customer_id");
      }

      connection.close();

    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    return newCustomerId;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public void setCustomer(Customer customer)
  {
    this.customer = customer;
  }
}
