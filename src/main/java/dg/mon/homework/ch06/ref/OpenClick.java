package dg.mon.hw.ch06.ref;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
/**
 * 打开按钮被单击事件
 *
 */
public class OpenClick implements ActionListener{


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

