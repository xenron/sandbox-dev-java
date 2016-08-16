package ch10.fileviewer;

import java.util.List;


public interface CommonDao<T> {
	
	public void save(List<T> entities);
	  
	public List<T> findByProperty(String propertyName, Object value);
	
	public void truncate();
 
 
}
