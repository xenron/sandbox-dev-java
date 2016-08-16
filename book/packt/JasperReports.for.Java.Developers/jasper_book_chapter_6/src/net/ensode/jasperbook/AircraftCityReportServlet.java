package net.ensode.jasperbook;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperRunManager;

public class AircraftCityReportServlet extends HttpServlet
{

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
  {
    Connection connection;
    ServletOutputStream servletOutputStream = response.getOutputStream();
    InputStream reportStream = getServletConfig().getServletContext()
        .getResourceAsStream("/reports/AircraftCityReport.jasper");
    HashMap parameters = new HashMap();
    
    parameters.put("state", "AK");
    parameters.put("city", "ANCHORAGE");

    try
    {
      Class.forName("com.mysql.jdbc.Driver");

      connection = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/flightstats?user=root&password=el4dejul");
      

      JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream,
          parameters, connection);
      
      connection.close();

      response.setContentType("application/pdf");
      servletOutputStream.flush();
      servletOutputStream.close();
    }
    catch (Exception e)
    {
      // display stack trace in the browser
      StringWriter stringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(stringWriter);
      e.printStackTrace(printWriter);
      response.setContentType("text/plain");
      response.getOutputStream().print(stringWriter.toString());
    }
  }
}