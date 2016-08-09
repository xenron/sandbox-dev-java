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
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class BeanCollectionDSReportServlet extends HttpServlet {

    private JRDataSource createReportDataSource() {
        JRBeanCollectionDataSource dataSource;
        Collection reportRows = initializeBeanCollection();

        dataSource = new JRBeanCollectionDataSource(reportRows);

        return dataSource;
    }

    private Collection initializeBeanCollection() {
        ArrayList reportRows = new ArrayList();

        reportRows.add(new AircraftData("N263Y", "T-11", "39 ROSCOE TRNR RACER",
                "R1830 SERIES"));
        reportRows.add(new AircraftData("N4087X", "BA100-163", "BRADLEY AEROBAT",
                "R2800 SERIES"));
        reportRows.add(new AircraftData("N43JE", "HAYABUSA 1",
                "NAKAJIMA KI-43 IIIA", "R1830 SERIES"));
        reportRows.add(new AircraftData("N912S", "9973CC", "PA18-150", "R-1820 SER"));

        return reportRows;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletOutputStream servletOutputStream = response.getOutputStream();
        InputStream reportStream = getServletConfig().getServletContext().getResourceAsStream("/reports/BeanDSReport.jasper");

        try {

            JRDataSource dataSource = createReportDataSource();

            JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream,
                    new HashMap(), dataSource);

            response.setContentType("application/pdf");
            servletOutputStream.flush();
            servletOutputStream.close();
        } catch (Exception e) {
            // display stack trace in the browser
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            response.setContentType("text/plain");
            response.getOutputStream().print(stringWriter.toString());
        }
    }
}