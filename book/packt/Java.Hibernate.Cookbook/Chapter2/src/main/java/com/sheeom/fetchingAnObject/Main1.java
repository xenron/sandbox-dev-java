package com.sheeom.fetchingAnObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.Employee;
import com.sheeom.common.HibernateUtil;

public class Main1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session =  sessionFactory.openSession();
		Employee employee =  (Employee) session.get(Employee.class, 1l);
		if(employee != null){
			System.out.println(employee.toString());
		}
		session.close();
		HibernateUtil.shutdown();

	}
}
