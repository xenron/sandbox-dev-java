package net.ensode.jasperbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;

public class DbReportDSFill
{
  Connection connection;
  Statement statement;
  ResultSet resultSet;

  public void generateReport()
  {
    try
    {
      String query = "select a.tail_num, a.aircraft_serial, "
        + "am.model as aircraft_model, ae.model as engine_model from aircraft a, "
        + "aircraft_models am, aircraft_engines ae where a.aircraft_engine_code in ("
        + "select aircraft_engine_code from aircraft_engines "
        + "where horsepower >= 1000) and am.aircraft_model_code = a.aircraft_model_code "
        + "and ae.aircraft_engine_code = a.aircraft_engine_code";
      
      Class.forName("com.mysql.jdbc.Driver");

      connection = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/flightstats?user=dbUser&password=secret");
      statement = connection.createStatement();
      resultSet = statement.executeQuery(query);
      
      JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(resultSet);

      System.out.println("Filling report...");
      JasperFillManager.fillReportToFile("reports/DbReportDS.jasper",
          new HashMap(), resultSetDataSource);
      System.out.println("Done!");
      
      resultSet.close();
      statement.close();
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
    new DbReportDSFill().generateReport();
  }
}
