package osa.ora.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import osa.ora.jpa.Product;
import osa.ora.jpa.ProductSpecificationsPK;
import osa.ora.jpa.Specifications;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-06T23:22:00")
@StaticMetamodel(ProductSpecifications.class)
public class ProductSpecifications_ { 

    public static volatile SingularAttribute<ProductSpecifications, Product> product;
    public static volatile SingularAttribute<ProductSpecifications, ProductSpecificationsPK> productSpecificationsPK;
    public static volatile SingularAttribute<ProductSpecifications, String> value;
    public static volatile SingularAttribute<ProductSpecifications, Specifications> specifications;

}