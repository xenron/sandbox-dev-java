package net.ensode.jasperbook.struts;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperRunManager;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class GenerateReportAction extends Action
{
    @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response)
      throws Exception
  {
    Connection connection;
    ServletOutputStream servletOutputStream = response.getOutputStream();
    InputStream reportStream = getServlet().getServletConfig()
        .getServletContext().getResourceAsStream("/reports/DbReport.jasper");
    response.setContentType("application/pdf");

    Class.forName("com.mysql.jdbc.Driver");

    connection = DriverManager
        .getConnection("jdbc:mysql://localhost:3306/flightstats?user=user&password=secret");

    JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream,
        new HashMap(), connection);

    connection.close();

    servletOutputStream.flush();
    servletOutputStream.close();

    return mapping.getInputForward();
  }
}
