package net.ensode.jasperbook;

import java.util.HashMap;
import java.util.Locale;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;

public class LocalizationDemoReportFill {

    public static void main(String[] args) {
        try {
            HashMap parameterMap = new HashMap();

            if (args.length > 0) {
                parameterMap.put(JRParameter.REPORT_LOCALE, new Locale(args[0]));
            }

            System.out.println("Filling report...");
            JasperFillManager.fillReportToFile("reports/LocalizationDemoReport.jasper",
                    parameterMap, new JREmptyDataSource());
            System.out.println("Done!");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
