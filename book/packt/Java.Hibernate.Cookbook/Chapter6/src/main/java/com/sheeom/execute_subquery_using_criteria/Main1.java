package com.sheeom.execute_subquery_using_criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Subqueries;

import com.sheeom.common.HibernateUtil;
import com.sheeom.performing_aggregate_operation.Category;
import com.sheeom.performing_aggregate_operation.Product;

public class Main1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		/* Line 1 */ DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Category.class);
		/* Line 2 */ detachedCriteria.setProjection(Projections.max("createdOn"));

		/* Line 4 */ Criteria criteria = session.createCriteria(Product.class);
		/* Line 5 */ criteria.createAlias("category", "cat");
		/* Line 6 */ criteria.add(Subqueries.propertyEq("cat.createdOn", detachedCriteria));
					 List<Product> list = criteria.list();
					 for(Product product : list){
						 System.out.println("\nProduct id: " + product.getId());
						 System.out.println("Product name: " + product.getName());
						 System.out.println("Product price: " + product.getPrice());
						 System.out.println("Category name: " + product.getCategory().getName());
					 }

		
		session.close();
		HibernateUtil.shutdown();
	}
}
