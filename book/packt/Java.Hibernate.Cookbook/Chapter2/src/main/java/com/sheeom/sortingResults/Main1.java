package com.sheeom.sortingResults;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import com.sheeom.common.Employee;
import com.sheeom.common.HibernateUtil;

public class Main1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Employee.class);   criteria.addOrder(Order.desc("firstName")); // desc() used to add order Descending
		// criteria.addOrder(Order.asc("id")); // asc() used to add order Ascending
		
		List<Employee> employees = criteria.list();
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
		
		session.close();
		HibernateUtil.shutdown();

	}
}
