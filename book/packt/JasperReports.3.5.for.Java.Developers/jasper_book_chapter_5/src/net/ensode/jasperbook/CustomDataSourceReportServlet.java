package net.ensode.jasperbook;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperRunManager;

public class CustomDataSourceReportServlet extends HttpServlet {

    private JRDataSource createReportDataSource() {

        String[] headers = {"tail_num", "aircraft_serial", "aircraft_model", "engine_model"};
        ListOfArraysDataSource dataSource;
        List<String[]> reportRows = initializeListOfArrays();
        dataSource = new ListOfArraysDataSource(reportRows);

        dataSource.setFieldNames(headers);
        return dataSource;
    }

    private List<String[]> initializeListOfArrays() {
        List<String[]> reportRows = new ArrayList<String[]>();

        String[] row1 = {"N263Y", "T-11", "39 ROSCOE TRNR RACER", "R1830 SERIES"};
        String[] row2 = {"N4087X", "BA100-163", "BRADLEY AEROBAT", "R2800 SERIES"};
        String[] row3 = {"N43JE", "HAYABUSA 1", "NAKAJIMA KI-43 IIIA", "R1830 SERIES"};
        String[] row4 = {"N912S", "9973CC", "PA18-150", "R-1820 SER"};

        reportRows.add(row1);
        reportRows.add(row2);
        reportRows.add(row3);
        reportRows.add(row4);

        return reportRows;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletOutputStream servletOutputStream = response.getOutputStream();
        InputStream reportStream = getServletConfig().getServletContext().getResourceAsStream("/reports/AircraftReport.jasper");

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