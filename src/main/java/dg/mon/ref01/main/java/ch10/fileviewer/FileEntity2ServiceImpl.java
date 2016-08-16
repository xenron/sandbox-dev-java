package ch10.fileviewer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("fileService2")
public class FileEntity2ServiceImpl implements FileEntity2Service {
	
	@Resource
	private CommonDao<FileEntity2> commonDao ;
 
	@Override
	public void saveAll(List<FileEntity2> list) { 
		commonDao.save(list);
	}

	@Override
	public List<FileEntity2> findByProperty(String pty,
			Object value) {
		return commonDao.findByProperty(pty, value);
	}

	@Override
	public void truncate() { 
		  commonDao.truncate();
	}
 

}
