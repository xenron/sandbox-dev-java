package com.sheeom.O_2_O_foriegn_key_there_is_more;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;

public class Main2_retrieve_using_child {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria criteria = 	session.createCriteria(PassportDetail.class);
		PassportDetail passportDetail = (PassportDetail) 	criteria.uniqueResult();
		System.out.println(passportDetail.toString());

		session.close();
		HibernateUtil.shutdown();
	}
}
