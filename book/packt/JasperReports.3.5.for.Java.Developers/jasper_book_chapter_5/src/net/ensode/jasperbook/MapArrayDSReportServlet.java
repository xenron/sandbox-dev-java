package net.ensode.jasperbook;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;

public class MapArrayDSReportServlet extends HttpServlet {

    private JRDataSource createReportDataSource() {
        JRMapArrayDataSource dataSource;
        Map[] reportRows = initializeMapArray();

        dataSource = new JRMapArrayDataSource(reportRows);

        return dataSource;
    }

    private Map[] initializeMapArray() {
        HashMap[] reportRows = new HashMap[4];
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

        reportRows[0] = row1Map;
        reportRows[1] = row2Map;
        reportRows[2] = row3Map;
        reportRows[3] = row4Map;

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