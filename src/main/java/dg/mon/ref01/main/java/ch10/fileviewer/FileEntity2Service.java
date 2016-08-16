package ch10.fileviewer;

import java.util.List;

public interface FileEntity2Service {
	public void truncate();
	public void saveAll(List<FileEntity2> list);
	public  List<FileEntity2> findByProperty(String pty,Object value);
}
