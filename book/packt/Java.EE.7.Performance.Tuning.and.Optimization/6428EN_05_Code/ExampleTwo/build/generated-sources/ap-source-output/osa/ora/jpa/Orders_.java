package osa.ora.jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import osa.ora.jpa.OrderUserDetails;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-06T23:22:00")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Integer> id;
    public static volatile SingularAttribute<Orders, OrderUserDetails> userDataId;
    public static volatile SingularAttribute<Orders, Integer> status;
    public static volatile SingularAttribute<Orders, String> orderRef;
    public static volatile SingularAttribute<Orders, Date> expectedDate;
    public static volatile SingularAttribute<Orders, Date> date;
    public static volatile SingularAttribute<Orders, Float> totalPrice;

}