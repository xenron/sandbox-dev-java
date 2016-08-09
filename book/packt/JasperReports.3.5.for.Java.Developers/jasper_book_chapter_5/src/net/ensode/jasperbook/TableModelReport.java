package net.ensode.jasperbook;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class TableModelReport {

    JFrame mainFrame;
    BorderLayout borderLayout;
    DefaultTableModel tableModel;
    JTable table = new JTable();
    JButton generateReportButton = new JButton("Generate Report");

    public TableModelReport() {
        mainFrame = new JFrame("Aircraft Data");
        borderLayout = new BorderLayout();
        generateReportButton.addActionListener(new ReportGenerator());

        populateTableModel();

        mainFrame.setSize(640, 150);
        mainFrame.setVisible(true);
        mainFrame.getContentPane().setLayout(borderLayout);
        mainFrame.add(new JLabel("Aircraft Data"), BorderLayout.NORTH);
        table.setModel(tableModel);
        mainFrame.getContentPane().add(table, BorderLayout.CENTER);
        mainFrame.getContentPane().add(generateReportButton, BorderLayout.SOUTH);

        mainFrame.setVisible(true);
    }

    private void populateTableModel() {
        String[] columnNames = {"tail_num", "aircraft_serial", "aircraft_model", "engine_model"};
        String[][] data = {
            {"N263Y", "T-11", " 39 ROSCOE TRNR RACER", "R1830 SERIES"},
            {"N4087X", "BA100-163", "BRADLEY AEROBAT", "R2800 SERIES"},
            {"N43JE", "HAYABUSA 1", "NAKAJIMA KI-43 IIIA", "R1830 SERIES"},
            {"N912S", "9973CC", "PA18-150", "R-1820 SER"}};

        tableModel = new DefaultTableModel(data, columnNames);
    }

    private void displayReport() {
        JasperPrint jasperPrint = generateReport();
        JasperViewer jasperViewer = new JasperViewer(jasperPrint);
        jasperViewer.setVisible(true);
    }

    private JasperPrint generateReport() {
        JasperPrint jasperPrint = null;

        try {
            jasperPrint = JasperFillManager.fillReport(
                    "reports/AircraftReportColumnIndex.jasper", new HashMap(),
                    new JRTableModelDataSource(tableModel));
        } catch (JRException e) {
            e.printStackTrace();
        }

        return jasperPrint;
    }

    private class ReportGenerator implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            displayReport();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new TableModelReport();
    }
}
