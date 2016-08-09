package net.ensode.jasperbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;

public class DbReportFill
{
  Connection connection;

  public void generateReport()
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");

      connection = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/flightstats?user=dbUser&password=secret");

      System.out.println("Filling report...");
      JasperFillManager.fillReportToFile("reports/DbReport.jasper",
          new HashMap(), connection);
      System.out.println("Done!");

      connection.close();
    }
    catch (JRException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  public static void main(String[] args)
  {
    new DbReportFill().generateReport();
  }
}
