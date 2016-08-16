package ch5;

import javax.swing.table.AbstractTableModel;

public class FileTableModel extends AbstractTableModel { 
	private static final long serialVersionUID = 1L;
	private Tuple[]   files;
    private String[] columns = {"File", "Path/name", };

    FileTableModel() {
        this(new Tuple[]{});
    }

    FileTableModel(Tuple[] files) {
        this.files = files;
    }

    public Object getValueAt(int row, int column) {
        Tuple file = files[row];
        switch (column) {
        case 0:
            return file.getLeft();
        case 1:
            return file.getRight();
        default:
            System.err.println("Logic Error");
        }
        return "";
    }

    public int getColumnCount() {
        return columns.length;
    }

    public Class<?> getColumnClass(int column) {
        return String.class;
    }

    public String getColumnName(int column) {
        return columns[column];
    }

    public int getRowCount() {
        return files.length;
    }

    public Tuple getFile(int row) {
        return files[row];
    }

    public void setFiles(Tuple[] files) {
        this.files = files;
        fireTableDataChanged();
    }
}