package com.sheeom.saveAnObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.Department;
import com.sheeom.common.Employee;
import com.sheeom.common.HibernateUtil;

public class Main1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory =  HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();

		// begin a transaction 
		session.getTransaction().begin(); 

		//creating a department object
		Department department = new Department();
		department.setDeptName("developement");

		// save department object
		session.save(department); 
		System.out.println("Department saved, id:  " + department.getId());

		//creating an employee object
		Employee employee = new Employee();
		employee.setFirstName("yogesh");
		employee.setSalary(50000);
		//  set department of employee
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
