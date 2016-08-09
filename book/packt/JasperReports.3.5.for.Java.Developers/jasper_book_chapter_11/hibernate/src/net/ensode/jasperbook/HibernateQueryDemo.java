package net.ensode.jasperbook;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateQueryDemo
{
  Session session;
  SessionFactory sessionFactory;

  public static void main(String[] args)
  {
    new HibernateQueryDemo().fillReport(args[0]);
  }

  public void fillReport(String countryCode)
  {
    String reportDirectory = "reports";
    session = createSession();

    Map parameterMap = new HashMap();
    parameterMap.put(
        JRHibernateQueryExecuterFactory.PARAMETER_HIBERNATE_SESSION, session);
    parameterMap.put("countryCode", countryCode);

    try
    {
      System.out.println("Filling report...");
      JasperFillManager.fillReportToFile(reportDirectory
          + "/HibernateQueryDemoReport.jasper", parameterMap);
      System.out.println("Done!");
    }
    catch (JRException e)
    {
      System.out.println("There was an error filling the report.");
      e.printStackTrace();
    }
  }

  private Session createSession()
  {
    SessionFactory sessionFactory = new Configuration().configure()
        .buildSessionFactory();
    return sessionFactory.openSession();
  }
}
