package dg.mon.hw.ch06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchClick implements ActionListener{

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
