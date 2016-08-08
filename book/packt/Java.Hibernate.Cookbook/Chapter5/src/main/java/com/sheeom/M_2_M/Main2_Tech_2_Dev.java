package com.sheeom.M_2_M;

import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.sheeom.common.HibernateUtil;

public class Main2_Tech_2_Dev {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Technology.class);
		criteria.add(Restrictions.eq("id", 1L));

		Technology technology= (Technology) criteria.uniqueResult();

		System.out.println(technology);
		Set<Developer> devs = technology.getDeveloper();
		for(Developer developer : devs){
			System.out.println(developer.toString());
		}

		
		session.close();
		HibernateUtil.shutdown();
	}
}
