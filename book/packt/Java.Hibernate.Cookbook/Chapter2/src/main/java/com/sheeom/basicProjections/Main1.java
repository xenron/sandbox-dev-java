package com.sheeom.basicProjections;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import com.sheeom.common.Employee;
import com.sheeom.common.HibernateUtil;

public class Main1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Employee.class);
		
		//Scenario 1
		criteria.setProjection(Projections.property("id"));
		System.out.println(criteria.list());
		
		//Scenario 2
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.alias(Projections.property("id"), "empId"));
		projectionList.add(Projections.alias(Projections.property("firstName"), "empFirstName"));
		criteria.setProjection(projectionList);
		criteria.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List list = criteria.list();
		System.out.println(list);


		
		session.close();
		HibernateUtil.shutdown();

	}
}
