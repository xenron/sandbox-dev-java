package net.ensode.jsf;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

public class ReportGenerator
{
  public void generateReport(ActionEvent actionEvent)
      throws ClassNotFoundException, SQLException, IOException, JRException
  {
    Connection connection;
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletResponse response = (HttpServletResponse) context
        .getExternalContext().getResponse();
    InputStream reportStream = context.getExternalContext()
        .getResourceAsStream("/reports/DbReport.jasper");

    ServletOutputStream servletOutputStream = response.getOutputStream();

    Class.forName("com.mysql.jdbc.Driver");

    connection = DriverManager
        .getConnection("jdbc:mysql://localhost:3306/flightstats?user=root&password=password");

    JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream,
        new HashMap(), connection);

    connection.close();

    response.setContentType("application/pdf");
    servletOutputStream.flush();
    servletOutputStream.close();

  }
}
