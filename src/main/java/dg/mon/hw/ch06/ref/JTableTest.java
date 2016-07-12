package dg.mon.hw.ch06.ref;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Desktop;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class JTableTest {
    JTable  myTable;

    public JTableTest() {
        JFrame frame = new JFrame("Double Click on Table Test");
        final String[] columnNames = {"S.No. ", "File Name", "File Path", ""};
        final Object[][] tableData = {
                {"1", "test1.txt", "C://test1.txt", "C:/Test/test1.txt"},
                {"2", "test2.txt", "C://test2.txt", "C:/Test/test2.txt"},
                {"3", "test2.txt", "C://test3.txt", "C:/Test/test3.txt"},
                {"4", "city_gdp.txt", "D://tmp//city_gdp.txt", "D:/tmp/city_gdp.txt"},
        };

        TableModel dataModel = new AbstractTableModel() {
            public int getColumnCount() {
                return columnNames.length;
            }

            public int getRowCount() {
                return tableData.length;
            }

            public Object getValueAt(int row, int col) {
                return tableData[row][col];
            }

            public String getColumnName(int column) {
                return columnNames[column];
            }

            public Class getColumnClass(int col) {
                return getValueAt(0, col).getClass();
            }

            public void setValueAt(Object aValue, int row, int column) {
                tableData[row][column] = aValue;
            }
        };

        myTable = new JTable(dataModel);
        myTable.getColumnModel().getColumn(3).setMaxWidth(0);
        myTable.getColumnModel().getColumn(3).setMinWidth(0);
        myTable.getColumnModel().getColumn(3).setPreferredWidth(0);
        myTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        frame.getContentPane().add(myTable);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        myTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = myTable.getSelectedRow();
                    try {
                        Desktop.getDesktop().open(new File((String) myTable.getValueAt(selectedRow, 3)));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        new JTableTest();
    }
}
