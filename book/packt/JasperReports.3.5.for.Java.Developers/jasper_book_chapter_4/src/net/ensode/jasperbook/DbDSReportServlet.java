package net.ensode.jasperbook;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperRunManager;

public class DbDSReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection connection;
        Statement statement;
        ResultSet resultSet;

        response.setContentType("application/pdf");
        ServletOutputStream servletOutputStream = response.getOutputStream();
        InputStream reportStream = getServletConfig().getServletContext().getResourceAsStream("/reports/DbReportDS.jasper");

        try {
            String query = "select a.tail_num, a.aircraft_serial, " + "am.model as aircraft_model, ae.model as engine_model from aircraft a, " + "aircraft_models am, aircraft_engines ae where a.aircraft_engine_code in (" + "select aircraft_engine_code from aircraft_engines " + "where horsepower >= 1000) and am.aircraft_model_code = a.aircraft_model_code " + "and ae.aircraft_engine_code = a.aircraft_engine_code";

            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightstats?user=dbUser&password=secret");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(resultSet);

            JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream,
                    new HashMap(), resultSetDataSource);

            resultSet.close();
            statement.close();
            connection.close();

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
