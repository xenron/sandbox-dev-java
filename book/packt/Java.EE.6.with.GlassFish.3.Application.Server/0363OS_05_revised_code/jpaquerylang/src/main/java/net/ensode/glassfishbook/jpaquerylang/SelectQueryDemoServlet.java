package net.ensode.glassfishbook.jpaquerylang;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectQueryDemoServlet extends HttpServlet
{
  @PersistenceUnit(unitName = "customerPersistenceUnit")
  private EntityManagerFactory entityManagerFactory;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
  {
    PrintWriter printWriter = response.getWriter();
    List<UsState> matchingStatesList;

    EntityManager entityManager = entityManagerFactory.createEntityManager();

    Query query = entityManager
        .createQuery("SELECT s FROM UsState s WHERE s.usStateNm LIKE :name");

    query.setParameter("name", "New%");
    matchingStatesList = query.getResultList();

    response.setContentType("text/html");

    printWriter.println("The following states match the criteria:<br/>");
    for (UsState state : matchingStatesList)
    {
      printWriter.println(state.getUsStateNm() + "<br/>");
    }
  }
}
