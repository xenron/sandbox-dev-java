package osa.ora.jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import osa.ora.jpa.Product;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-06T23:22:00")
@StaticMetamodel(ProductReviews.class)
public class ProductReviews_ { 

    public static volatile SingularAttribute<ProductReviews, Integer> id;
    public static volatile SingularAttribute<ProductReviews, Integer> stars;
    public static volatile SingularAttribute<ProductReviews, String> name;
    public static volatile SingularAttribute<ProductReviews, String> comment;
    public static volatile SingularAttribute<ProductReviews, Date> date;
    public static volatile SingularAttribute<ProductReviews, Product> productId;

}