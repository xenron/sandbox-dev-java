package ch9.fileviewer;

import java.util.List;

public interface FileEntity2Service {
	public void truncate(String tableName);
	public void saveAll(List<FileEntity2> list);
	public  List<FileEntity2> findByProperty(String tableName,String pty,Object value);
}
