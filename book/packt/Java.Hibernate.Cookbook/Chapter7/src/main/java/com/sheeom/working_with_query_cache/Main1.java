package com.sheeom.working_with_query_cache;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;
import com.sheeom.first_level_cache.Employee;

public class Main1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		for (int i = 0; i < 5; i++) {
			/* Line 3 */ Criteria criteria = session.createCriteria(Employee.class).setCacheable(true);
			List<Employee> employees = criteria.list();
			System.out.println("Employees found: " + employees.size());
		}


		session.close();
		HibernateUtil.shutdown();
	}
}
