package net.ensode.glassfishbook.criteriaapi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/criteriaapi"})
public class CriteriaApiDemoServlet extends HttpServlet {

  @PersistenceUnit(unitName = "customerPersistenceUnit")
  private EntityManagerFactory entityManagerFactory;

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    PrintWriter printWriter = response.getWriter();
    List<UsState> matchingStatesList;

    EntityManager entityManager = entityManagerFactory.
        createEntityManager();
    CriteriaBuilder criteriaBuilder = entityManager.
        getCriteriaBuilder();
    CriteriaQuery<UsState> criteriaQuery = criteriaBuilder.
        createQuery(UsState.class);
    Root<UsState> root = criteriaQuery.from(UsState.class);

    Metamodel metamodel = entityManagerFactory.getMetamodel();
    EntityType<UsState> usStateEntityType = metamodel.entity(
        UsState.class);
    SingularAttribute<UsState, String> usStateAttribute =
        usStateEntityType.getDeclaredSingularAttribute("usStateNm",
        String.class);
    Path<String> path = root.get(usStateAttribute);
    Predicate predicate = criteriaBuilder.like(
        path, "New%");
   criteriaQuery = criteriaQuery.where(predicate);

    TypedQuery typedQuery = entityManager.createQuery(
        criteriaQuery);

    matchingStatesList = typedQuery.getResultList();

    response.setContentType("text/html");

    printWriter.println(
        "The following states match the criteria:<br/>");
    for (UsState state : matchingStatesList) {
      printWriter.println(state.getUsStateNm() + "<br/>");
    }
  }
}
