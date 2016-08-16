package ch9.fileviewer;

import java.util.List;


public interface CommonDao<T> {
	
	public void save(List<T> entities);
	  
	public List<T> findByProperty(String tableName, String propertyName, Object value);
	
	public void truncate(String tableName);

//	public List<T> findByProperty(Map<String, Object> conditionMap);
 
}
