package ch11.fileviewer;
 
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
  
@Service("fileService3")
public class FileEntity2ServiceImpl implements FileEntity2Service {
	 
	@Resource
    private SqlSessionFactory sessionFactory ;
	
	@Resource
	private FileMapper fileMapper; 
  
	@Override
	public void saveAll(List<FileEntity2> list) { 
		for(FileEntity2 entity : list){
			fileMapper.insert(entity);
		}
	}

	@Override
	public List<FileEntity2> findByProperty(String fileName) {
		return fileMapper.getFiles(fileName);  
	}

	@Override
	public void truncate() { 
		  fileMapper.truncate();
	}
 

}
