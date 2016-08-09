package osa.ora.beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import osa.ora.beans.ContactDetails;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-16T17:45:12")
@StaticMetamodel(Empolyee.class)
public class Empolyee_ { 

    public static volatile SingularAttribute<Empolyee, Integer> id;
    public static volatile SingularAttribute<Empolyee, String> title;
    public static volatile SingularAttribute<Empolyee, String> name;
    public static volatile SingularAttribute<Empolyee, String> role;
    public static volatile SingularAttribute<Empolyee, Integer> salary;
    public static volatile SingularAttribute<Empolyee, Integer> rating;
    public static volatile SingularAttribute<Empolyee, ContactDetails> contact;

}