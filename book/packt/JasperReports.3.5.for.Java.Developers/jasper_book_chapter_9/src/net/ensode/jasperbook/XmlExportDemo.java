package net.ensode.jasperbook;

import java.io.File;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class XmlExportDemo
{
  public static final String REPORT_DIRECTORY = "reports";

  public void xmlExport(String reportName)
  {
    File file = new File(REPORT_DIRECTORY + "/" + reportName + ".jrprint");

    try
    {
      JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(file);
      JRXmlExporter xmlExporter = new JRXmlExporter();

      xmlExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
      xmlExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
          REPORT_DIRECTORY + "/" + reportName + ".jrpxml");
      System.out.println("Exporting report...");
      xmlExporter.exportReport();
      System.out.println("Done!");
    }
    catch (JRException e)
    {
      e.printStackTrace();
    }
  }

  public static void main(String[] args)
  {
    new XmlExportDemo().xmlExport(args[0]);
  }

}
