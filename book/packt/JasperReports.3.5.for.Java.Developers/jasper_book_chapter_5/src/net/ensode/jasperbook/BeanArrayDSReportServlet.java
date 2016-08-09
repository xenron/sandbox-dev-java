package net.ensode.jasperbook;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;

public class BeanArrayDSReportServlet extends HttpServlet {

    private JRDataSource createReportDataSource() {
        JRBeanArrayDataSource dataSource;
        AircraftData[] reportRows = initializeBeanArray();

        dataSource = new JRBeanArrayDataSource(reportRows);

        return dataSource;
    }

    private AircraftData[] initializeBeanArray() {
        AircraftData[] reportRows = new AircraftData[4];

        reportRows[0] = new AircraftData("N263Y", "T-11", "39 ROSCOE TRNR RACER",
                "R1830 SERIES");
        reportRows[1] = new AircraftData("N4087X", "BA100-163", "BRADLEY AEROBAT",
                "R2800 SERIES");
        reportRows[2] = new AircraftData("N43JE", "HAYABUSA 1",
                "NAKAJIMA KI-43 IIIA", "R1830 SERIES");
        reportRows[3] = new AircraftData("N912S", "9973CC", "PA18-150",
                "R-1820 SER");

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