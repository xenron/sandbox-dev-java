package osa.ora.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import osa.ora.jpa.Product;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-06T23:22:00")
@StaticMetamodel(ProductStock.class)
public class ProductStock_ { 

    public static volatile SingularAttribute<ProductStock, Integer> id;
    public static volatile SingularAttribute<ProductStock, Integer> stockSize;
    public static volatile SingularAttribute<ProductStock, Product> productId;

}