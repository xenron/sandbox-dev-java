package net.ensode.jasperbook;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;

public class HtmlReportServlet extends HttpServlet {

    public static final String REPORT_DIRECTORY = "/reports";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = this.getServletConfig().getServletContext();
        String reportName = request.getParameter("reportName");
        File file = new File(context.getRealPath(REPORT_DIRECTORY + "/" + reportName + ".jrprint"));
        PrintWriter printWriter = response.getWriter();

        try {

            JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(file.getPath());
            JRHtmlExporter htmlExporter = new JRHtmlExporter();

            response.setContentType("text/html");
            request.getSession().setAttribute(
                    ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

            htmlExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            htmlExporter.setParameter(JRExporterParameter.OUTPUT_WRITER, printWriter);
            htmlExporter.setParameter(JRHtmlExporterParameter.IMAGES_URI,
                    "image?image=");

            htmlExporter.exportReport();
        } catch (Throwable t) {
            // display stack trace in the browser
            t.printStackTrace(printWriter);
        }
    }
}
