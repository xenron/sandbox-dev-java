package com.sheeom.updateAnObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.Employee;
import com.sheeom.common.HibernateUtil;

public class Main1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Employee employee = (Employee) session.get(Employee.class, new Long(2));

		System.out.println("\nOld Employee...");
		System.out.println(employee.toString());

		session.getTransaction().begin();
		employee.setFirstName("aarush_updated");
		session.update(employee);
		session.getTransaction().commit();

		System.out.println("\nEmployee after Update...");
		System.out.println(employee.toString());
		
		session.close();
		HibernateUtil.shutdown();

	}
}
