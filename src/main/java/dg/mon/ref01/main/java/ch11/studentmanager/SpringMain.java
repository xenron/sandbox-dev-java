package ch11.studentmanager;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext; 

 import Utils.SpringUtils;

public class SpringMain {

	public static ApplicationContext context;
    public static void main(String[] args) throws IOException { 
    	
        SqlSessionFactory sessionFactory = SpringUtils.getBean("sqlSessionFactory",SqlSessionFactory.class);
        SqlSession session = sessionFactory.openSession();
        
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student u=new Student("student1", 1, "shanghai");
        studentMapper.insert(u);
        System.out.println("insert successfuly:" + u.getId());
        
        Student s1 = studentMapper.getUser(u.getId());
        System.out.println(s1);

        System.out.println("user count :"+studentMapper.getUserCount());
        session.commit();
        
        List<SimpleStudent> list=studentMapper.getSimpleUsers();
        System.out.println(list);
        
        System.out.println("delete affect rows:"+studentMapper.deleteUserById(5));
        System.out.println(studentMapper.getUserAsMap(s1.getId()));
        session.commit();
        session.close();
    }
}
