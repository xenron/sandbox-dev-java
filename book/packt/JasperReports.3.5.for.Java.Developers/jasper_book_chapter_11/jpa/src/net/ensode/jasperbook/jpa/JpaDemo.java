package net.ensode.jasperbook.jpa;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.query.JRJpaQueryExecuterFactory;

public class JpaDemo {

  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("flightstatsPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    Map parameterMap = new HashMap();

    parameterMap.put(JRJpaQueryExecuterFactory.PARAMETER_JPA_ENTITY_MANAGER, entityManager);
    parameterMap.put("countryCode", args[0]);
    try {
      JasperFillManager.fillReportToFile("reports/JpaQueryDemoReport.jasper", parameterMap);
    } catch (JRException ex) {
      ex.printStackTrace();
    } finally {
      if (entityManager != null && entityManager.isOpen()) {
        entityManager.close();
      }

      if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
        entityManagerFactory.close();
      }
    }
  }
}
