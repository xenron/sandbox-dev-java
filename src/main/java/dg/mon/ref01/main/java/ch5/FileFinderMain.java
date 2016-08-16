package ch5;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ProgressMonitor;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import Utils.SpringUtils;

public class FileFinderMain {

	private JTextField keyword;
	/** Used to open/edit/print files. */
	private Desktop desktop;
	private JPanel gui;
	private JTable table;
	private JButton search;
	private FileTableModel fileTableModel;
	private ListSelectionListener listSelectionListener;
	private CliHandler myhandler = null;

	private JTextField Textdir;
	private JButton BtnIndex;
	private JLabel label1;
	private JLabel label2;	

	private JPanel Pcondition;
	 
	private JFrame frame;
    
	public void setCliHandler(CliHandler cli) {
		myhandler = cli;
	}

	public static void main(String[] args) throws IOException {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				CliHandler clihandler = (CliHandler) SpringUtils
						.getBean("myCliHandler");
				FileFinderMain fs = new FileFinderMain();
				fs.setCliHandler(clihandler);
				fs.createAndShowGUI();
			}
		});
	}

	private void createAndShowGUI() {
		// Create and set up the window.
		frame = new JFrame("FileSearch");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(addComponentsToPane());
		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public Container addComponentsToPane() {
		desktop = Desktop.getDesktop();
		gui = new JPanel(new BorderLayout(3, 3));
		Pcondition = new JPanel(new GridLayout(2, 3));

		gui.add(Pcondition, BorderLayout.NORTH);

		label1 = new JLabel("index dir:");
		Textdir = new JTextField(40);
		Textdir.setText("/git/ccms-monitor/");
		BtnIndex = new JButton("Index");
		Pcondition.add(label1);
		Pcondition.add(Textdir);
		Pcondition.add(BtnIndex);
		label2 = new JLabel("keyword:");
		keyword = new JTextField(40);
		Pcondition.add(label2);
		Pcondition.add(keyword);
		search = new JButton("Search");
		search.setPreferredSize(new Dimension(200, 100));
		Pcondition.add(search);

		BtnIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// index the file index file
				FileIndexTask myFileIndex = SpringUtils.getBean("myFileIndex",
						FileIndexTask.class);
				new Thread(myFileIndex).start();
			}
		});
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// search the file and send data to table  
				final JOptionPane pane = new JOptionPane(); 
				final JDialog jd = pane.createDialog("waiting for file search....");
				new Thread( 
						new Runnable(){ 
							@Override
							public void run() { 
									jd.setVisible(true); 
							}}
						).start(); 
				setTableData(myhandler.filterKeyword(keyword.getText())); 
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) { 
					e.printStackTrace();
				}
			    jd.dispose();
			}
		});

			
		
		listSelectionListener = new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent lse) {
				int row = table.getSelectionModel().getLeadSelectionIndex();
				openFile(((FileTableModel) table.getModel()).getFile(row));
			}
		};

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoCreateRowSorter(true);
		table.setShowVerticalLines(false);

		JScrollPane tableScroll = new JScrollPane(table);
		tableScroll.setSize(240, 240);
		gui.add(tableScroll, BorderLayout.CENTER);
		
		table.getModel().addTableModelListener(
				new TableModelListener() { 
					@Override
					public void tableChanged(
							TableModelEvent paramTableModelEvent) { 
						JOptionPane.getRootFrame().dispose(); 
					}
				}
				); 
		
		return gui;
	}

	protected void openFile(Tuple file) {
		try {
			desktop.open(new File(file.getRight()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setTableData(final Tuple[] files) {
 
		SwingUtilities.invokeLater(new Runnable() { 
			public void run() { 
			
				if (fileTableModel == null) {
					fileTableModel = new FileTableModel();
					table.setModel(fileTableModel);
				}
				table.getSelectionModel().removeListSelectionListener(
						listSelectionListener);
				fileTableModel.setFiles(files);
				table.getSelectionModel().addListSelectionListener(
						listSelectionListener); 
				 
			}
		});
		 
	}
}
