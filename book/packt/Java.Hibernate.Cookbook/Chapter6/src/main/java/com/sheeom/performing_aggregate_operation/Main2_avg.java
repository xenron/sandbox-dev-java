package com.sheeom.performing_aggregate_operation;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.sheeom.common.HibernateUtil;

public class Main2_avg {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Product.class);
		ProjectionList projectionList = Projections.projectionList();
		/* Line 4 */projectionList.add(Projections.groupProperty("category"));

		/* Line 6 */ projectionList.add(Projections.alias(Projections.avg("price"), "price"));
		criteria.createAlias("category", "category");
		projectionList.add(Projections.alias(Projections.property("category.name"), "cat_name"));

		criteria.setProjection(projectionList);
		criteria.setResultTransformer(criteria.ALIAS_TO_ENTITY_MAP);

		List list = criteria.list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Map map = (Map) iterator.next();
			System.out.println("Category name: " + map.get("cat_name") + " AVG(price): " + map.get("price"));
		}

		session.close();
		HibernateUtil.shutdown();
	}
}