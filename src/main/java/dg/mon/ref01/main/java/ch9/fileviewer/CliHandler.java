package ch9.fileviewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.annotation.Resource;


public class CliHandler {
	
	@Resource
	private FileEntity2Service fileService;
	
	private void search(String keyword){
		
 		List<FileEntity2> list = fileService.findByProperty("t_files", "file_name", keyword);
		for(FileEntity2 entity : list)
			System.out.println(entity.getFile_path());
	}
	 
	public void handleCmd() throws IOException
	{
	 	
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please input the keyword you want to search:");
		String keyword = bfr.readLine();
		while(!keyword.equals("exit")){
			search(keyword);
	 		System.out.println("Please input the keyword you want to search:");
			keyword = bfr.readLine();
		}
	}
	 
	 
}

