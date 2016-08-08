package com.sheeom.worrking_with_interceptor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sheeom.common.HibernateUtil;

public class InterceptorTest {
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		/* Line 1 */ CustomInterceptor interceptor = new CustomInterceptor();
		
		/* Line 2 */ Session session = sessionFactory.withOptions().interceptor(interceptor).openSession();
		/* Line 3 */ Transaction tx = null;
		/* Line 4 */ tx = session.beginTransaction();

		/* Line 6 */ Employee employee = new Employee();
		/* Line 7 */ employee.setName("Vishal");
		/* Line 8 */ session.saveOrUpdate(employee);

		/* Line 9 */ tx.commit();
		/* Line 10 */ session.close();
		/* Line 11 */ sessionFactory.close();

	}
}
