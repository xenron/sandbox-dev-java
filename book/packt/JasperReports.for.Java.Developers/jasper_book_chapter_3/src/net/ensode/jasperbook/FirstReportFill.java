package net.ensode.jasperbook;

import java.util.HashMap;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;

public class FirstReportFill
{
  public static void main(String[] args)
  {
    try
    {
      System.out.println("Filling report...");
      JasperFillManager.fillReportToFile("reports/FirstReport.jasper",
          new HashMap(), new JREmptyDataSource());
      System.out.println("Done!");
    }
    catch (JRException e)
    {
      e.printStackTrace();
    }
  }
}
