package com.sheeom.saveAnObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.Department;
import com.sheeom.common.Employee;
import com.sheeom.common.HibernateUtil;

public class ThereIsMore {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		// begin a transaction
		session.getTransaction().begin();

		// creating department object
		Department department = new Department();
		department.setId(1l);

		// creating an employee object
		Employee employee = new Employee();
		employee.setFirstName("aarush");
		employee.setSalary(35000);
		// set department of employee
		employee.setDepartment(department);

		// save employee object
		session.save(employee);
		System.out.println("Employee saved, id:  " + employee.getId());

		// commit transaction
		session.getTransaction().commit();
		session.close();
		HibernateUtil.shutdown();

	}
}
