package net.ensode.jasperbook;

import java.io.File;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class CsvExportDemo {

    public static final String REPORT_DIRECTORY = "reports";

    public void csvExport(String reportName) {
        File file = new File(REPORT_DIRECTORY + "/" + reportName + ".jrprint");

        try {
            JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(file);
            JRCsvExporter csvExporter = new JRCsvExporter();

            csvExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            csvExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
                    REPORT_DIRECTORY + "/" + reportName + ".csv");
            System.out.println("Exporting report...");
            csvExporter.exportReport();
            System.out.println("Done!");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CsvExportDemo().csvExport(args[0]);
    }
}
