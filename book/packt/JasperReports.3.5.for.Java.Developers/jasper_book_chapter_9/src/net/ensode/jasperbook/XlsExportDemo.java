package net.ensode.jasperbook;

import java.io.File;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class XlsExportDemo
{
  public static final String REPORT_DIRECTORY = "reports";

  public void xlsExport(String reportName)
  {
    File file = new File(REPORT_DIRECTORY + "/" + reportName + ".jrprint");

    try
    {
      JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(file);
      JRXlsExporter xlsExporter = new JRXlsExporter();

      xlsExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
      xlsExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
          REPORT_DIRECTORY + "/" + reportName + ".xls");
      System.out.println("Exporting report...");
      xlsExporter.exportReport();
      System.out.println("Done!");
    }
    catch (JRException e)
    {
      e.printStackTrace();
    }
  }

  public static void main(String[] args)
  {
    new XlsExportDemo().xlsExport(args[0]);
  }

}
