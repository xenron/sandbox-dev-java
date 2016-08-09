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

public class MapCollectionDSReportServlet extends HttpServlet {

    private JRDataSource createReportDataSource() {
        JRMapCollectionDataSource dataSource;
        Collection reportRows = initializeMapCollection();

        dataSource = new JRMapCollectionDataSource(reportRows);

        return dataSource;
    }

    private Collection initializeMapCollection() {
        ArrayList reportRows = new ArrayList();
        HashMap row1Map = new HashMap();
        HashMap row2Map = new HashMap();
        HashMap row3Map = new HashMap();
        HashMap row4Map = new HashMap();

        row1Map.put("tail_num", "N263Y");
        row1Map.put("aircraft_serial", "T-11");
        row1Map.put("aircraft_model", "39 ROSCOE TRNR RACER");
        row1Map.put("engine_model", "R1830 SERIES");

        row2Map.put("tail_num", "N4087X");
        row2Map.put("aircraft_serial", "BA100-163");
        row2Map.put("aircraft_model", "BRADLEY AEROBAT");
        row2Map.put("engine_model", "R2800 SERIES");

        row3Map.put("tail_num", "N43JE");
        row3Map.put("aircraft_serial", "HAYABUSA 1");
        row3Map.put("aircraft_model", "NAKAJIMA KI-43 IIIA");
        row3Map.put("engine_model", "R1830 SERIES");

        row4Map.put("tail_num", "N912S");
        row4Map.put("aircraft_serial", "9973CC");
        row4Map.put("aircraft_model", "PA18-150");
        row4Map.put("engine_model", "R-1820 SER");

        reportRows.add(row1Map);
        reportRows.add(row2Map);
        reportRows.add(row3Map);
        reportRows.add(row4Map);

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