package net.ensode.jasperbook;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

public class FrameDemoServlet extends HttpServlet
{
  private JRDataSource createReportDataSource()
  {
    JRMapCollectionDataSource dataSource;
    Collection reportRows = initializeMapCollection();

    dataSource = new JRMapCollectionDataSource(reportRows);

    return dataSource;
  }

  private Collection initializeMapCollection()
  {
    ArrayList reportRows = new ArrayList();
    HashMap datasourceMap = new HashMap();

    datasourceMap
        .put(
            "lots_of_data",
            "This element contains so much data, "
                + "there is no way it will ever fit in the text field without it stretching.");

    reportRows.add(datasourceMap);

    return reportRows;
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
  {
    ServletOutputStream servletOutputStream = response.getOutputStream();
    
    InputStream reportStream = getServletConfig().getServletContext()
        .getResourceAsStream("/reports/FrameDemo.jasper");

    try
    {

      JRDataSource dataSource = createReportDataSource();
      response.setContentType("application/pdf");

      JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream,
          new HashMap(), dataSource);

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
