package ch10.fileviewer;

import java.io.IOException;

import Utils.SpringUtils;
 
public class FileFinder {
	public static void main(String[] args) {
   	 CliHandler task =   (CliHandler) SpringUtils.getBean("cliCmd2");	
   	 	try {
			task.handleCmd();
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
}