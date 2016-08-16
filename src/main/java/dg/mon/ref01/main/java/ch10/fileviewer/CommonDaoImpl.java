package ch10.fileviewer;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("commonDao")
public class CommonDaoImpl  implements CommonDao<FileEntity2> {
	
	@Resource
	private JdbcTemplate jdbcTemplate; 
  
	@Override
	public void save(final List<FileEntity2> entities) {
		String InsertSql = "Insert into t_files(file_name,file_path) values(?,?)";
		   jdbcTemplate.batchUpdate(InsertSql, new BatchPreparedStatementSetter(){ 
				@Override
				public int getBatchSize() { 
					return entities.size();
				} 
				@Override
				public void setValues(PreparedStatement ps,
						int index) throws SQLException {
					ps.setString(1, entities.get(index).getFile_name());
					ps.setString(2, entities.get(index).getFile_path());
				}
	        }); 
	}

	//let t extends one base class this class has a base requiremnts such as tableName
	@Override
	public List<FileEntity2>  findByProperty(String propertyName, Object value) {
		String tableName = "";//get from the annotable of entity
		Table tn = FileEntity2.class.getAnnotation(Table.class);
		if(tn==null) return null;
		tableName = tn.name();
		
		List<FileEntity2> list = jdbcTemplate.query(
				"SELECT * FROM "
				+ tableName 
				+ " WHERE " + propertyName + " like '%"
				+ String.valueOf(value) +"%'",
				new BeanPropertyRowMapper<FileEntity2>(FileEntity2.class));
		 
		return list;
	}

	@Override
	public void truncate() { 
		Table tn = FileEntity2.class.getAnnotation(Table.class);
		if(tn==null) return ;
		String tableName = tn.name();
		jdbcTemplate.update("truncate table " + tableName);
	}
 
  
}
