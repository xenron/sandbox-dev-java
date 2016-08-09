package spring.catalog;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SpringClient {

	public static void main(String[] args) {

		// reference the proxy through the Spring container

		// getBean proxyBean Interceptor method invoked.

		/**
		 * * Load up the Spring container
		 */
		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(
				"beanDefinition.xml"));

		// getBean proxyBean Interceptor method invoked.

		Catalog catalog = (Catalog) beanFactory.getBean("proxyBean");

		String test = catalog.getTestMessage();
		System.out.println(test);

		catalog.setJournal("Oracle Magazine");
		catalog.setPublisher("Oracle Publishing");
		catalog.setEdition("November-December 2010");
		catalog.setTitle("Agile Enterprise Architecture");
		catalog.setAuthor("Bob Rhubart");
		System.out.println(catalog.journal);
		System.out.println(catalog.publisher);
		System.out.println(catalog.edition);
		System.out.println(catalog.title);
		System.out.println(catalog.author);

	}
}
