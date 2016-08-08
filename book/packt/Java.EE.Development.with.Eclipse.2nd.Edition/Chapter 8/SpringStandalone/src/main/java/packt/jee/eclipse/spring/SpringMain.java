package packt.jee.eclipse.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main (String[] args) {
		//create ApplicationContext
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		//call and print ctx.getBean first time
		CourseService courseService = (CourseService)ctx.getBean("courseService");
		System.out.println("Course DAO - " + courseService.getCourseDAO().getClass().getSimpleName());
	}
}
