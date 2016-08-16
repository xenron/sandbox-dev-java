package dg.mon.hw.ch07;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

import dg.mon.hw.Utils;

class SearchFormMain extends JFrame {

    private String searchPath;
    private JTable resultTable;
    private DefaultTableModel tableModel;
    private JProgressBar processBar = new JProgressBar();;

    public static void main(String[] args) {
        SearchFormMain form = new SearchFormMain();
        form.showUI();
    }

    private void showUI() {
        this.setTitle("File Search");
        this.setSize(600, 500);

        this.setLayout(new java.awt.FlowLayout());

        javax.swing.JTextField fileTextPath = new javax.swing.JTextField(15);
        this.add(fileTextPath);

        javax.swing.JButton jbOpen = new javax.swing.JButton("choose");
        this.add(jbOpen);
        SearchFormOpenClick openClick = new SearchFormOpenClick(searchPath, fileTextPath);
        jbOpen.addActionListener(openClick);

        javax.swing.JTextField searchfile = new javax.swing.JTextField(15);
        this.add(searchfile);

        javax.swing.JButton jbSearch = new javax.swing.JButton("search");
        this.add(jbSearch);

        tableModel = new SearchFormTableModel();
        tableModel.addColumn("seq");
        tableModel.addColumn("name");
        tableModel.addColumn("size");
        tableModel.addColumn("type");
        tableModel.addColumn("modify");
        tableModel.addColumn("fullpath");
        resultTable = new JTable(tableModel);
        resultTable.setShowGrid(false);
        SearchFormMouseClick mouseClick = new SearchFormMouseClick(resultTable, tableModel);
        resultTable.addMouseListener(mouseClick);

        this.add(new JScrollPane(resultTable));

        SearchFormSearchClick searchClick = new SearchFormSearchClick(resultTable, tableModel, searchfile, fileTextPath, processBar);
        jbSearch.addActionListener(searchClick);

        processBar.setVisible(false);
        this.add(processBar);

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

class SearchFormSearchClick implements ActionListener, Runnable {

    private JTable resultTable;
    private DefaultTableModel tableModel;
    private JTextField jt1, jt2;
    private JProgressBar processBar;

    public SearchFormSearchClick(JTable resultTable, DefaultTableModel tableModel, JTextField jt1, JTextField jt2, JProgressBar processBar) {
        this.resultTable = resultTable;
        this.tableModel = tableModel;
        this.jt1 = jt1;
        this.jt2 = jt2;
        this.processBar = processBar;
    }

    public void actionPerformed(ActionEvent e) {
        String fileName = jt1.getText();
        String folder = jt2.getText();
        tableModel.setRowCount(0);
        Thread thread = new Thread(this);
        thread.start();
        processBar.setVisible(true);
        int result = search(fileName, folder);
        processBar.setVisible(false);
        thread.interrupt();
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

    @Override
    public void run() {
        processBar.setStringPainted(true);// 设置进度条上的字符串显示，false则不能显示
        processBar.setBackground(Color.GREEN);
        for (int i = 0; i < 101; i++) {
            try {
                Thread.sleep(100);  //   让当前线程休眠0.1ms
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            processBar.setValue(i); // 设置进度条数值
        }
        processBar.setString("ok");// 设置提示信息
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
