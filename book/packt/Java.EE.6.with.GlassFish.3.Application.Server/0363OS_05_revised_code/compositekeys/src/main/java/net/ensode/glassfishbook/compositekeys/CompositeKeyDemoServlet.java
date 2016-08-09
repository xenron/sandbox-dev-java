package net.ensode.glassfishbook.compositekeys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompositeKeyDemoServlet extends HttpServlet
{
  @PersistenceUnit(unitName = "customerPersistenceUnit")
  private EntityManagerFactory entityManagerFactory;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
  {
    PrintWriter printWriter = response.getWriter();
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    OrderItem orderItem;

    orderItem = entityManager.find(OrderItem.class, new OrderItemPK(1L, 2L));

    response.setContentType("text/html");

    if (orderItem != null)
    {
      printWriter
          .println("Found an instance of Order Item for the supplied primary key:<br/>");
      printWriter.println("OrderItem order id: " + orderItem.getOrderId()
          + "<br/>");
      printWriter.println("OrderItem item id: " + orderItem.getItemId()
          + "<br/>");
    }
    else
    {
      printWriter
          .println("No instance of OrderItem found for the supplied primary key.");
    }
  }
}
