package ch9.fileviewer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("fileService")
public class FileEntity2ServiceImpl implements FileEntity2Service {
	
	@Resource
	private CommonDao<FileEntity2> cDao ;
 
	@Override
	public void saveAll(List<FileEntity2> list) { 
		cDao.save(list);
	}

	@Override
	public List<FileEntity2> findByProperty(String tableName, String pty,
			Object value) {
		return cDao.findByProperty(tableName, pty, value);
	}

	@Override
	public void truncate(String tableName) { 
		  cDao.truncate(tableName);
	}
 

}
