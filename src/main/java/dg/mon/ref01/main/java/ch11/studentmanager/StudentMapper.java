package ch11.studentmanager;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface StudentMapper {
    @Select("select * from t_student where id=#{id}")
    public Student getUser(int id);

    @Select("select * from t_student where id=#{id}")
    public Map<String, ?> getUserAsMap(int id);

    @Insert("insert into t_student(name,sex,location) values(#{name},#{sex},#{location})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insert(Student user);

    @Select("select count(*) from t_student")
    public int getUserCount();

    @Select("select * from t_student")
    @Results(value = {
            @Result(property = "name", column = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "loc", column = "location", javaType = String.class, jdbcType = JdbcType.VARCHAR) })
    public List<SimpleStudent> getSimpleUsers();

    @Delete("delete from t_student where id=#{id}")
    public int deleteUserById(int id);

}