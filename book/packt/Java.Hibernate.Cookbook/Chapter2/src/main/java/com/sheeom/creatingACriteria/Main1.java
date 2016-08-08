package com.sheeom.creatingACriteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.Employee;
import com.sheeom.common.HibernateUtil;

public class Main1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> employees = criteria.list();
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}

		session.close();
		HibernateUtil.shutdown();

	}
}
