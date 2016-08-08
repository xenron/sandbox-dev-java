package com.sheeom.working_with_alias;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.sheeom.common.HibernateUtil;

public class Main1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		/* Line 1 */ Criteria criteria = session.createCriteria(Employee.class);
		/* Line 2 */ criteria.createAlias("department", "dept");
		/* Line 3 */ criteria.add(Restrictions.eq("dept.name", "aarush"));
		/* Line 4*/ List list = criteria.list();


		session.close();
		HibernateUtil.shutdown();
	}
}
