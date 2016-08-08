package com.sheeom.restrictingUsingCriteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.sheeom.common.Employee;
import com.sheeom.common.HibernateUtil;

public class Main1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.gt("salary", 35000));
		
		List<Employee> employees = criteria.list();
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}

		session.close();
		HibernateUtil.shutdown();

	}
}
