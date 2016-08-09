package net.ensode.jasperbook;

import java.io.File;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class OdtExportDemo {

    public static final String REPORT_DIRECTORY = "reports";

    public void odtExport(String reportName) {
        File file = new File(REPORT_DIRECTORY + "/" + reportName + ".jrprint");

        try {
            JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(file);
            JROdtExporter odtExporter = new JROdtExporter();

            odtExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            odtExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
                    REPORT_DIRECTORY + "/" + reportName + ".ods");
            System.out.println("Exporting report...");
            odtExporter.exportReport();
            System.out.println("Done!");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new OdtExportDemo().odtExport(args[0]);
    }
}
