package osa.ora.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import osa.ora.jpa.Product;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-06T23:22:00")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, Integer> id;
    public static volatile SingularAttribute<Category, Integer> parentCategory;
    public static volatile ListAttribute<Category, Product> productList;
    public static volatile SingularAttribute<Category, String> name;

}