package net.ensode.jasperbook;

import java.io.File;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class RtfExportDemo
{
  public static final String REPORT_DIRECTORY = "reports";

  public void rtfExport(String reportName)
  {
    File file = new File(REPORT_DIRECTORY + "/" + reportName + ".jrprint");

    try
    {
      JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(file);
      JRRtfExporter rtfExporter = new JRRtfExporter();

      rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
      rtfExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
          REPORT_DIRECTORY + "/" + reportName + ".rtf");
      System.out.println("Exporting report...");
      rtfExporter.exportReport();
      System.out.println("Done!");
    }
    catch (JRException e)
    {
      e.printStackTrace();
    }
  }

  public static void main(String[] args)
  {
    new RtfExportDemo().rtfExport(args[0]);
  }

}
