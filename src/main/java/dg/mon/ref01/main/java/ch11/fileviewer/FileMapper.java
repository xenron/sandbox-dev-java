package ch11.fileviewer;

import java.util.List;
import java.util.Map; 

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select; 


public interface FileMapper { 
 
    @Select("select file_name,file_path from t_files where file_name like  concat('%',#{file_name},'%')")
    public List<FileEntity2> getFiles(String file_name );
	
    @Select("select file_name,file_path from t_files where  like  concat('%',#{file_name},'%') ")
    public Map<String, ?> getFilesAsMap(String file_name );

    @Insert("insert into t_files(file_name,file_path) values(#{file_name},#{file_path})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insert(FileEntity2 file);
 
    @Delete("delete from t_files")
    public int truncate();

}