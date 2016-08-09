package osa.ora.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import osa.ora.jpa.Orders;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-06T23:22:00")
@StaticMetamodel(OrderUserDetails.class)
public class OrderUserDetails_ { 

    public static volatile SingularAttribute<OrderUserDetails, Integer> id;
    public static volatile SingularAttribute<OrderUserDetails, String> creditCard;
    public static volatile SingularAttribute<OrderUserDetails, String> name;
    public static volatile ListAttribute<OrderUserDetails, Orders> ordersList;
    public static volatile SingularAttribute<OrderUserDetails, String> address1;
    public static volatile SingularAttribute<OrderUserDetails, String> address2;

}