package com.sheeom.batch_processing;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sheeom.common.HibernateUtil;

public class BatchProcessingMain {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		for (int i = 0; i < 10000; i++) {
			Employee employee = new Employee();
			employee.setName("Name : " + String.valueOf(i));
			session.save(employee);
		/* Line 7 */	if (i % 50 == 0) {
		/* Line 8 */ 	session.flush();
		/* Line 9*/ 	session.clear();
			}
		}
		transaction.commit();
		session.close();

		HibernateUtil.shutdown();
	}
}
