package net.ensode.jasperbook;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;

public class EmptyDSReportFill {

    public void fillReport(String reportName) {
        String reportDirectory = "reports";
        try {
            System.out.println("Filling report...");
            JasperFillManager.fillReportToFile(reportDirectory + "/" + reportName + ".jasper", null, new JREmptyDataSource());
            System.out.println("Done!");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new EmptyDSReportFill().fillReport(args[0]);
    }
}
