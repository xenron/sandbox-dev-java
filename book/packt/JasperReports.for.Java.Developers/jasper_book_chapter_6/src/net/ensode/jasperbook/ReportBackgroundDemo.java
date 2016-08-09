package net.ensode.jasperbook;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;

public class ReportBackgroundDemo
{
  public void generateReport()
  {
    try
    {
      JasperFillManager.fillReportToFile("reports/BackgroundDemoReport.jasper", null, new JREmptyDataSource());
    }
    catch (JRException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    new ReportBackgroundDemo().generateReport();

  }

}
