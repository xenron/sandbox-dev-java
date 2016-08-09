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

public class ReportGenerator {

    public void generateReport(ActionEvent actionEvent)
            throws ClassNotFoundException, SQLException, IOException, JRException {
        Connection connection;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        InputStream reportStream = facesContext.getExternalContext().getResourceAsStream("/reports/DbReport.jasper");

        ServletOutputStream servletOutputStream = response.getOutputStream();

        Class.forName("com.mysql.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightstats?user=user&password=secret");

        facesContext.responseComplete();
        response.setContentType("application/pdf");

        JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream,
                new HashMap(), connection);

        connection.close();
        servletOutputStream.flush();
        servletOutputStream.close();

    }
}
