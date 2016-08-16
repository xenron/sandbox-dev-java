package dg.mon.hw.ch06;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dg.mon.hw.Utils;

class SearchFormMain extends javax.swing.JFrame {

    private String searchPath;
    private JTable resultTable;
    private DefaultTableModel tablemodel;

    public static void main(String[] args) {
        SearchFormMain form = new SearchFormMain();
        form.showUI();
    }

    private void showUI() {
        this.setTitle("文件搜索器");
        this.setSize(600, 500);

        this.setLayout(new java.awt.FlowLayout());

        javax.swing.JTextField fileTextPath = new javax.swing.JTextField(15);
        this.add(fileTextPath);

        javax.swing.JButton jbOpen = new javax.swing.JButton("选择目录");
        this.add(jbOpen);
        SearchFormOpenClick openClick = new SearchFormOpenClick(searchPath, fileTextPath);
        jbOpen.addActionListener(openClick);

        javax.swing.JTextField searchfile = new javax.swing.JTextField(15);
        this.add(searchfile);

        javax.swing.JButton jbSearch = new javax.swing.JButton("查询");
        this.add(jbSearch);

        tablemodel = new SearchFormTableModel();
        tablemodel.addColumn("序号");
        tablemodel.addColumn("名称");
        tablemodel.addColumn("大小");
        tablemodel.addColumn("类型");
        tablemodel.addColumn("修改日期");
        tablemodel.addColumn("全路径");
        resultTable = new JTable(tablemodel);
        resultTable.setShowGrid(false);
        SearchFormMouseClick mouseClick = new SearchFormMouseClick(resultTable, tablemodel);
        resultTable.addMouseListener(mouseClick);

        this.add(new JScrollPane(resultTable));

        SearchFormSearchClick searchClick = new SearchFormSearchClick(resultTable, tablemodel, searchfile, fileTextPath);
        jbSearch.addActionListener(searchClick);

        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }
}

class SearchFormOpenClick implements ActionListener {
    private JFileChooser chooser;
    private String path;
    javax.swing.JTextField fileTextPath;

    public SearchFormOpenClick(String path, javax.swing.JTextField fileTextPath) {
        this.path = path;
        this.fileTextPath = fileTextPath;
    }

    public void actionPerformed(ActionEvent e) {
        chooser = new JFileChooser();
        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int t = chooser.showOpenDialog(null);
        if (t == chooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getAbsolutePath();
            fileTextPath.setText(path);
        }
    }
}

class SearchFormSearchClick implements ActionListener {

    private JTable resultTable;
    private DefaultTableModel tableModel;
    private JTextField jt1, jt2;

    public SearchFormSearchClick(JTable resultTable, DefaultTableModel tableModel, JTextField jt1, JTextField jt2) {
        this.resultTable = resultTable;
        this.tableModel = tableModel;
        this.jt1 = jt1;
        this.jt2 = jt2;
    }

    public void actionPerformed(ActionEvent e) {
        String fileName = jt1.getText();
        String directory = jt2.getText();
        tableModel.setRowCount(0);
        int result = search(fileName, directory);
    }

    public int search(String str, String fileName) {

        int count = 0;
        java.io.File file = new java.io.File(fileName);
        java.io.File[] files = file.listFiles();
        for (File currentFile : files) {
            if (currentFile.isFile()) {
                String spath = currentFile.getAbsolutePath();
                if (spath.indexOf(str) >= 0) {
                    count++;
                    String name = currentFile.getName();
                    tableModel.addRow(new String[]{
                            String.valueOf(count),
                            name.substring(0, name.lastIndexOf(".")),
                            Utils.sizeFormat(currentFile.length()),
                            name.substring(name.lastIndexOf(".") + 1),
                            Utils.getSimpleDateString(currentFile.lastModified()),
                            currentFile.getAbsolutePath()
                    });
                }
            }
            if (currentFile.isDirectory()) {
                count += search(str, currentFile.getAbsolutePath());
            }
        }
        return count;
    }
}

class SearchFormTableModel extends DefaultTableModel {
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}

class SearchFormMouseClick implements MouseListener {
    DefaultTableModel tableModel;
    JTable resultTable;

    public SearchFormMouseClick(JTable resultTable, DefaultTableModel tableModel) {
        this.tableModel = tableModel;
        this.resultTable = resultTable;
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            int selectedRow = resultTable.getSelectedRow();
            try {
                Desktop.getDesktop().open(new File((String) tableModel.getValueAt(selectedRow, 5)));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}
}