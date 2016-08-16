package QuartzDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDriver {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-quartz.xml");
	     context.getBean("myScheduler");

	}
}
