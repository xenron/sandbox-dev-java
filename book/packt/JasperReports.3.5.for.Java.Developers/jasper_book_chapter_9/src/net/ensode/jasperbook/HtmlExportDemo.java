package net.ensode.jasperbook;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class HtmlExportDemo
{
  public static final String REPORT_DIRECTORY = "reports";

  public void htmlExport(String reportName)
  {
    File file = new File(REPORT_DIRECTORY + "/" + reportName + ".jrprint");

    try
    {
      JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(file);
      JRHtmlExporter htmlExporter = new JRHtmlExporter();

      htmlExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
      htmlExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
          REPORT_DIRECTORY + "/" + reportName + ".html");
      System.out.println("Exporting report...");
      htmlExporter.exportReport();
      System.out.println("Done!");
    }
    catch (JRException e)
    {
//    display stack trace in the browser
      StringWriter stringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(stringWriter);
      e.printStackTrace(printWriter);
    }
  }

  public static void main(String[] args)
  {
    new HtmlExportDemo().htmlExport(args[0]);
  }

}
