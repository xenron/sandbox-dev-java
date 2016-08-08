package com.sheeom.transformingAResult;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import com.sheeom.common.Employee;
import com.sheeom.common.HibernateUtil;
import com.sheeom.sortingResults.EmployeeDetail;

public class Main1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		
		// for List, Scenario 1
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setResultTransformer(Transformers.TO_LIST);
		List<?> employees = criteria.list();
		System.out.println(employees.get(0));
		
		//for Map, Scenario 2
//		Criteria criteria = session.createCriteria(Employee.class);
//		criteria.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//		List list = criteria.list();
//		System.out.println("List: " + list);
//		Map map = (Map) list.get(0);
//		Employee employeeMap = (Employee) map.get(Criteria.ROOT_ALIAS);
//		System.out.println(employeeMap.toString());
		
		//for use define bean, scenario 3
//		Criteria criteria = session.createCriteria(Employee.class);
//		criteria.createAlias("department", "_department");
//
//		ProjectionList projectionList = Projections.projectionList();
//		projectionList.add(Projections.alias(Projections.property("id"), "empId"));
//		projectionList.add(Projections.alias(Projections.property("firstName"), "empFirstName"));
//		projectionList.add(Projections.alias(Projections.property("salary"), "empSalary"));
//		projectionList.add(Projections.alias(Projections.property("_department.deptName"), "empDeptName"));
//		criteria.setProjection(projectionList);
//
//		criteria.setResultTransformer(Transformers.aliasToBean(EmployeeDetail.class));
//		List<EmployeeDetail> employeeDetails = criteria.list();
//
//		EmployeeDetail employeeDetail = employeeDetails.get(0);
//		System.out.println(employeeDetail.toString());

		
		session.close();
		HibernateUtil.shutdown();

	}
}
