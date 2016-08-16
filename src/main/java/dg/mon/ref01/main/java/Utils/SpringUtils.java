package Utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			new String[] { "applicationContext.xml",
					"applicationContext-redis.xml" 
					,"applicationContext-FileIndex.xml"});

	public static Object getBean(String beanName) {
		return ctx.getBean(beanName);
	}
	
	public static <T> T getBean(String beanName,Class<T> clazz){
		return ctx.getBean(beanName, clazz);
	}
	
	public static <T> T getBean(Class<T> clazz){
		return ctx.getBean(clazz);
	}
	
}
