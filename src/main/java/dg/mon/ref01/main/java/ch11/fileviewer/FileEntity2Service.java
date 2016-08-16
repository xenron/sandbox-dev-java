package ch11.fileviewer;

import java.util.List;

public interface FileEntity2Service {
	public void truncate();
	public void saveAll(List<FileEntity2> list);
	public  List<FileEntity2> findByProperty(String fileName);
}
