package osa.ora.beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import osa.ora.beans.Empolyee;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-16T17:45:12")
@StaticMetamodel(ContactDetails.class)
public class ContactDetails_ { 

    public static volatile SingularAttribute<ContactDetails, Integer> id;
    public static volatile CollectionAttribute<ContactDetails, Empolyee> empolyeeCollection;
    public static volatile SingularAttribute<ContactDetails, String> home;
    public static volatile SingularAttribute<ContactDetails, String> phone;
    public static volatile SingularAttribute<ContactDetails, String> street;
    public static volatile SingularAttribute<ContactDetails, String> zipCode;
    public static volatile SingularAttribute<ContactDetails, String> city;
    public static volatile SingularAttribute<ContactDetails, String> country;

}