package net.ensode.jasperbook;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

public class FirstReportCompile
{
  public static void main(String[] args)
  {
    try
    {
      System.out.println("Compiling report...");
      JasperCompileManager.compileReportToFile("reports/FirstReport.jrxml");
      System.out.println("Done!");
    }
    catch (JRException e)
    {
      e.printStackTrace();
    }
  }
}
