package dg.mon.hw.ch06;

public class Main extends javax.swing.JFrame{

	private String SearchPath;
	private javax.swing.JTextArea ResText;//搜索结果框
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
