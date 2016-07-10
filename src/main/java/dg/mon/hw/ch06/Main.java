package dg.mon.hw.ch06;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends javax.swing.JFrame{

	private String SearchPath;
	private javax.swing.JTextArea ResText;

	public static void main(String[] args) {
		Main main = new Main();
		main.showUI();//显示界面

	}

	public void showUI(){
		this.setTitle("文件搜索器");
		this.setSize(600,500);

		this.setLayout(new java.awt.FlowLayout());

		javax.swing.JTextField fileTextPath = new javax.swing.JTextField(15);
		this.add(fileTextPath);

		javax.swing.JButton jbOpen = new javax.swing.JButton("选择目录");
		this.add(jbOpen);

		OpenClick clickLisen = new OpenClick(SearchPath,fileTextPath);
		jbOpen.addActionListener(clickLisen);

		javax.swing.JTextField Searchfile = new javax.swing.JTextField(15);
		this.add(Searchfile);

		javax.swing.JButton jbSearch = new javax.swing.JButton("查询");
		this.add(jbSearch);

		ResText = new javax.swing.JTextArea(20,45);

//		javax.swing.JScrollPane jp=new javax.swing.JScrollPane(ResText);
//		this.getContentPane().add(jp);
		this.getContentPane().add(new LocalFile());

		SearchClick SearchClick = new SearchClick(ResText,Searchfile,fileTextPath);
		jbSearch.addActionListener(SearchClick);

		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}
}

class OpenClick implements ActionListener {
	private JFileChooser chooser;
	private String path;
	javax.swing.JTextField fileTextPath;
	public OpenClick(String path, javax.swing.JTextField fileTextPath){
		this.path=path;
		this.fileTextPath=fileTextPath;
	}
	public void actionPerformed(ActionEvent e) {
		chooser = new JFileChooser();
		chooser.setDialogType(JFileChooser.OPEN_DIALOG);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY );
		int t=chooser.showOpenDialog(null);
		if(t==chooser.APPROVE_OPTION){
			path=chooser.getSelectedFile().getAbsolutePath();
			fileTextPath.setText(path);
		}
	}
}

class SearchClick implements ActionListener{

	private javax.swing.JTextArea ResText;
	private javax.swing.JTextField jt1,jt2;
	public SearchClick(javax.swing.JTextArea ResText, javax.swing.JTextField jt1, javax.swing.JTextField jt2){//构造方法
		this.ResText=ResText;
		this.jt1=jt1;
		this.jt2=jt2;
	}
	public void actionPerformed(ActionEvent e) {
		String fileName = jt1.getText();
		String Mulu = jt2.getText();
		int result=search (fileName,Mulu);
	}

	public int search(String str,String fileName){
		int count=0;
		java.io.File file = new java.io.File(fileName);
		java.io.File[] files = file.listFiles();
		for(int i=0;i<files.length;i++){
			if(files[i].isFile()){
				String spath = files[i].getAbsolutePath();
				if(spath.indexOf(str)>=0){
					count++;
					ResText.append("找到文件:"+spath+"\n");
				}
			}
			// 文件夹
			if(files[i].isDirectory()){
				//递归调用
				count+=search(str,files[i].getAbsolutePath());

			}
		}
		return count;
	}
}

class LocalFile extends JPanel implements ActionListener, MouseListener
{
	private JButton jbUp;
	private JComboBox jcbPath;
	private JTable jtFile;
	private DefaultTableModel dtmFile;
	private JLabel jlLocal;
	private File path;
	private String currentPath;
	private int currentIndex;
	private boolean init = false;

	public LocalFile() {
		super(new BorderLayout());

		JPanel jp = new JPanel(new BorderLayout());
		jbUp = new JButton("Up");
		jbUp.addActionListener(this);
		jcbPath = new JComboBox();
		jcbPath.addActionListener(this);
		jp.add(jbUp, "West");
		jp.add(jcbPath, "Center");
		dtmFile = new LocalTableModel();
		dtmFile.addColumn("名称");
		dtmFile.addColumn("大小");
		dtmFile.addColumn("类型");
		dtmFile.addColumn("修改日期");
		jtFile = new JTable(dtmFile);
		jtFile.setShowGrid(false);
		jtFile.addMouseListener(this);
		jlLocal = new JLabel("本地状态", JLabel.CENTER);

		add(jp, "North");
		add(new JScrollPane(jtFile), "Center");
		add(jlLocal, "South");

		//显示系统分区及文件路径 并 在JTabel中显示当前路径的文件信息
		path = new File(System.getProperty("user.dir"));
		listFiles(path);

		init = true;
	}

	//处理路径的选择事件
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==jbUp && jtFile.getValueAt(0, 0).toString().equals("返回上级")
				&& jtFile.getValueAt(0, 2).toString().equals(""))
		{
			listFiles(new File(currentPath).getParentFile());
			return;
		}
		if (init == false)
		{
			return;
		}
		int index = jcbPath.getSelectedIndex();
		String item = (String)jcbPath.getSelectedItem();
		if (item.startsWith("  "))
		{
			int root = index - 1;
			while (((String)jcbPath.getItemAt(root)).startsWith("  "))
			{
				root--;
			}
			String path = (String)jcbPath.getItemAt(root);
			while (root < index)
			{
				path += ((String)jcbPath.getItemAt(++root)).trim();;
				path += "\\";
			}
			if (listFiles(new File(path)) == false)
			{
				jcbPath.setSelectedIndex(currentIndex);
			}
			else
			{
				currentIndex = index;
			}
		}
		else
		{
			if (listFiles(new File(item)) == false)
			{
				jcbPath.setSelectedIndex(currentIndex);
			}
			else
			{
				currentIndex = index;
			}
		}
	}

	//JTable里文件夹双击事件
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==2) {
			int row = ((JTable)e.getSource()).getSelectedRow();
			if (((JTable)e.getSource()).getValueAt(row, 2).toString().equals("文件夹"))
			{
				File file;
				//判断是否为根目录，作不同处理。一个 \ 的差别
				if (currentPath.split("\\\\").length > 1)
				{
					file = new File(currentPath + "\\" + ((JTable)e.getSource()).getValueAt(row, 0).toString());
				}
				else
				{
					file = new File(currentPath + ((JTable)e.getSource()).getValueAt(row, 0).toString());
				}
				listFiles(file);
			}
			else if (((JTable)e.getSource()).getValueAt(row, 0).toString().equals("返回上级")
					&& ((JTable)e.getSource()).getValueAt(row, 2).toString().equals(""))
			{
				listFiles(new File(currentPath).getParentFile());
			}
		}
	}
	//其他一堆无用的事件
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	//显示系统分区及文件路径 并 在JTabel中显示当前路径的文件信息
	private boolean listFiles(File path) {
		String strPath = path.getAbsolutePath();
		if (path.isDirectory() == false)
		{
			JOptionPane.showMessageDialog(this, "此路径不存在，或无此文件");
			return false;
		}

		currentPath = path.getAbsolutePath();
		init = false;
		jcbPath.removeAllItems();
		File[] roots = File.listRoots();
		int index = 0;
		for (int i=0; i<roots.length; i++)
		{
			String rootPath = roots[i].getAbsolutePath();
			jcbPath.addItem(rootPath);
			if (currentPath.indexOf(rootPath) != -1)
			{
				String[] bufPath = currentPath.split("\\\\");
				for (int j=1; j<bufPath.length; j++)
				{
					String buf = "  ";
					for (int k=1; k<j; k++)
					{
						buf += "  ";
					}
					jcbPath.addItem(buf + bufPath[j]);
					index = i + j;
				}
				if (bufPath.length == 1)
				{
					index = i;
				}
			}
		}
		jcbPath.setSelectedIndex(index);
		init = true;
		currentIndex = index;

		//清空现有数据
		dtmFile.setRowCount(0);

		//如果判断为非分区根目录，则添加 返回上级 一行
		if (strPath.split("\\\\").length > 1)
		{
			dtmFile.addRow(new String[]{"返回上级", "", "", ""});
		}

		//列出当前目录所有目录及文件
		File[] files = path.listFiles();
		for (int i=0; i<files.length; i++)
		{
			String name = files[i].getName();
			if (files[i].isDirectory())
			{
				dtmFile.addRow(new String[]{name, "", "文件夹", ""});
			}
			else
			{
				if (name.lastIndexOf(".") != -1)
				{
					dtmFile.addRow(new String[]{name.substring(0, name.lastIndexOf(".")),
							sizeFormat(files[i].length()),
							name.substring(name.lastIndexOf(".") + 1),
							new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date(files[i].lastModified()))});
				}
				else
				{
					dtmFile.addRow(new String[]{name,
							sizeFormat(files[i].length()),
							"",
							new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date(files[i].lastModified()))});
				}
			}
		}

		jlLocal.setText(currentPath);

		return true;
	}

	//将文件大小转换成相应字符串格式
	private String sizeFormat(long length) {
		long kb;
		if (length < 1024)
		{
			return String.valueOf(length);
		}
		else if ((kb = length / 1024) < 1024)
		{
			return (String.valueOf(kb) + "kb");
		}
		else
		{
			return (String.valueOf(length / 1024 / 1024) + "kb");
		}
	}

	//测试
	public static void main(String[] args) {
		JFrame jf = new JFrame("测试");
		jf.setSize(300, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension di = Toolkit.getDefaultToolkit().getScreenSize();
		jf.setLocation((int)(di.getWidth() - jf.getWidth()) / 2,
				(int)(di.getHeight() - jf.getHeight()) / 2);
		jf.add(new LocalFile());
		jf.setVisible(true);
	}
}

class LocalTableModel extends DefaultTableModel
{
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}