package ch8.pattern.forkjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
 
public class IndexFileTask extends RecursiveTask<List<String>>{ 
	private static final long serialVersionUID = 2L;
	private String rootPath = "";
	
    public IndexFileTask(String filePath){
         this.rootPath = filePath;
    }
    
    public List<String> compute(){
    		List<String> list = new ArrayList<String>();
            ArrayList<IndexFileTask> subTasks=new ArrayList<IndexFileTask>(); 
            
            File file = new File(rootPath);
            boolean isDirectory = file.isDirectory();
            if(!isDirectory)
            {
            	  list.add(file.getName() + "|" + file.getAbsolutePath());
            	  return list;
            }
            else
            {
            	File[] files = file.listFiles();
               for(int i=0;i<files.length;i++){ 
            	if(files[i].isDirectory())
            	{	 
            		IndexFileTask subTask=new IndexFileTask(files[i].getAbsolutePath());
	                subTasks.add(subTask);
	                subTask.fork();
	            }
            	else
            		list.add(files[i].getName() + " " + files[i].getAbsolutePath());
            }
            for(IndexFileTask  t:subTasks){
                list.addAll(t.join());
            }
        }
        return  list;
    }
    
    public static void main(String[]args){
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        IndexFileTask task = new IndexFileTask("/home/student/logs");
        ForkJoinTask<List<String>> result = forkJoinPool.submit(task);
        try{
            List<String> list = result.get(); 
            for(String str : list)
            	System.out.println(str);
        }catch(InterruptedException e){
            e.printStackTrace();
        }catch(ExecutionException e){
            e.printStackTrace();
        } 
    }
} 