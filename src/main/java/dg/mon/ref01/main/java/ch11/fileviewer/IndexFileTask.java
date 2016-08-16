package ch11.fileviewer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import javax.annotation.Resource;
import Utils.SpringUtils;
 
public class IndexFileTask extends RecursiveTask<List<FileEntity2>>{ 
	
	@Resource
	private FileEntity2Service fileService3;
	private static final long serialVersionUID = 2L;
	private String rootPath = "";
	 
    public IndexFileTask(String filePath){
         this.rootPath = filePath;
    }
    
    public List<FileEntity2> compute(){
    		List<FileEntity2> list = new ArrayList<FileEntity2>();
            ArrayList<IndexFileTask> subTasks=new ArrayList<IndexFileTask>(); 
            
            File file = new File(rootPath);
            boolean isDirectory = file.isDirectory();
            if(!isDirectory)
            { 
            	  list.add( new FileEntity2(file.getName(),file.getAbsolutePath()) );
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
            		list.add( new FileEntity2(files[i].getName(),files[i].getAbsolutePath()) );
            }
            for(IndexFileTask  t:subTasks){
                list.addAll(t.join());
            }
        }
        return  list;
    }
 
    public void save(List<FileEntity2> result)
    {
    	fileService3.truncate();
    	fileService3.saveAll(result);
    }
    
    public void save(){
    	save(compute());
    }
     
    public static void main(String[]args) throws InterruptedException, ExecutionException{
    	 IndexFileTask task =  SpringUtils.getBean("fileIndexTask3",IndexFileTask.class);
         ForkJoinPool forkJoinPool = new ForkJoinPool();
         task.save(forkJoinPool.submit(task).get()); 
        		
    } 
}