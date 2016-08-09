package net.ensode.jasperbook;

import java.io.File;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

public class PlainTextExportDemo
{
  public static final String REPORT_DIRECTORY = "reports";

  public void plainTextExport(String reportName)
  {
    File file = new File(REPORT_DIRECTORY + "/" + reportName + ".jrprint");

    try
    {
      JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(file);
      JRTextExporter textExporter = new JRTextExporter();

      textExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
      textExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
          REPORT_DIRECTORY + "/" + reportName + ".txt");
      textExporter.setParameter(JRTextExporterParameter.CHARACTER_WIDTH,
          new Integer(10));
      textExporter.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT,
          new Integer(10));
      System.out.println("Exporting report...");
      textExporter.exportReport();
      System.out.println("Done!");
    }
    catch (JRException e)
    {
      e.printStackTrace();
    }
  }

  public static void main(String[] args)
  {
    new PlainTextExportDemo().plainTextExport(args[0]);
  }

}
