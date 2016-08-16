package ch5;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.data.redis.core.RedisTemplate;

//create index file for the specified directory
//filename fulldirectoryfilename
//can put the filename to redis cluster, then find will become faster

public class FileIndexTask implements Runnable {

	public FileIndexTask() {

	}

	private File dir;

	public File getDir() {
		return dir;
	}

	public void setDir(File dir) {
		this.dir = dir;
	}

	private String[] extensions = { "java" };

	@Resource
	private RedisTemplate<String, String> jedisTemplate;

	private String indexFile;

	public void setIndexFile(String _indexfile){
		this.indexFile = _indexfile ;
	}
	@Override
	public void run() {
		System.out.println(dir.getAbsolutePath());
		List<File> files = (List<File>) FileUtils.listFiles(dir, extensions, true);
		StringBuilder sb = new StringBuilder();
		for (File file : files) {
			sb.append(file.getName() + "|" + file.getAbsolutePath() + "\n");
		}
		try {
			FileUtils.writeStringToFile(new File(indexFile),
					sb.toString(), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
