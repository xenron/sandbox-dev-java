package osa.ora.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import osa.ora.jpa.ProductSpecifications;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-06T23:22:00")
@StaticMetamodel(Specifications.class)
public class Specifications_ { 

    public static volatile SingularAttribute<Specifications, Integer> id;
    public static volatile SingularAttribute<Specifications, String> name;
    public static volatile ListAttribute<Specifications, ProductSpecifications> productSpecificationsList;

}