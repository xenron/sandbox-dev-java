package osa.ora.jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import osa.ora.jpa.Category;
import osa.ora.jpa.ProductReviews;
import osa.ora.jpa.ProductSpecifications;
import osa.ora.jpa.ProductStock;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-06T23:22:00")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile SingularAttribute<Product, Date> startDate;
    public static volatile SingularAttribute<Product, Float> price;
    public static volatile SingularAttribute<Product, Integer> shippingDays;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, Category> categoryId;
    public static volatile ListAttribute<Product, ProductStock> productStockList;
    public static volatile SingularAttribute<Product, Boolean> active;
    public static volatile ListAttribute<Product, ProductSpecifications> productSpecificationsList;
    public static volatile SingularAttribute<Product, byte[]> image;
    public static volatile ListAttribute<Product, ProductReviews> productReviewsList;

}