package dg.mon.hw.ch06;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends javax.swing.JFrame{

	private String SearchPath;
	private javax.swing.JTextArea ResText;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main main = new Main();
		main.showUI();//显示界面

	}

	/**
	 * 显示界面
	 */
	public void showUI(){
		this.setTitle("我的文件搜索器v 1.0");//显示窗口
		this.setSize(600,500);

		this.setLayout(new java.awt.FlowLayout());//设置布局方式

		//文件目录栏
		javax.swing.JTextField fileTextPath = new javax.swing.JTextField(15);
		this.add(fileTextPath);



		//添加打开按钮
		javax.swing.JButton jbOpen = new javax.swing.JButton("打开");
		this.add(jbOpen);

		//添加监听事件
		OpenClick clickLisen = new OpenClick(SearchPath,fileTextPath);
		jbOpen.addActionListener(clickLisen);

		//搜索内容
		javax.swing.JTextField Searchfile = new javax.swing.JTextField(15);
		this.add(Searchfile);

		//搜索按钮
		javax.swing.JButton jbSearch = new javax.swing.JButton("搜索");
		this.add(jbSearch);




		//添加标签
		javax.swing.JLabel jlb = new javax.swing.JLabel("搜索结果");
		this.add(jlb);

		//添加文本域
		ResText = new javax.swing.JTextArea(20,45);

		//添加滚动条
		javax.swing.JScrollPane jp=new javax.swing.JScrollPane(ResText);
		this.getContentPane().add(jp);




		//搜索监听事件
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
		chooser.setDialogType(JFileChooser.OPEN_DIALOG);//设置为打开方式的文件选择器
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY );//设置只能开打文件目录
		int t=chooser.showOpenDialog(null);
		if(t==chooser.APPROVE_OPTION){//如果点击的是确定
			path=chooser.getSelectedFile().getAbsolutePath();
			fileTextPath.setText(path);
		}

	}

}

class SearchClick implements ActionListener{

	private javax.swing.JTextArea ResText;
	private javax.swing.JTextField jt1,jt2;
	//private javax.swing.JScrollPane jp;


	public SearchClick(javax.swing.JTextArea ResText, javax.swing.JTextField jt1, javax.swing.JTextField jt2){//构造方法
		this.ResText=ResText;
		this.jt1=jt1;
		this.jt2=jt2;

	}


	public void actionPerformed(ActionEvent e) {
//        if(fileName.equals("")||Mulu.equals("")){
//        	javax.swing.JOptionPane.showMessageDialog(null,"请先填入要搜索的内容");
//        	return ;
//        }

		String fileName = jt1.getText();
		String Mulu = jt2.getText();
		System.out.println(fileName+"------------"+Mulu);

		int result=search (fileName,Mulu);

		System.out.println(">>>>>>>>>>"+result);
	}

	/**
	 * 搜索文件
	 * @param str 搜索文件包含名
	 * @param fileName 搜索目录
	 * @return
	 */
	public int search(String str,String fileName){
		int count=0;//找到的文件个数
		//构造文件对象
		java.io.File file = new java.io.File(fileName);
		java.io.File[] files = file.listFiles();
		//遍历数组
		for(int i=0;i<files.length;i++){
			//如果是一个真实的文件
			if(files[i].isFile()){
				//得到文件绝对路径
				String spath = files[i].getAbsolutePath();
				//如果str在文件路径中出现过
				if(spath.indexOf(str)>=0){
					count++;
					ResText.append("找到文件:"+spath+"\n");
				}
			}
			//如果是一个文件夹
			if(files[i].isDirectory()){
				//递归调用自己
				count+=search(str,files[i].getAbsolutePath());

			}
		}
		return count;
	}

}