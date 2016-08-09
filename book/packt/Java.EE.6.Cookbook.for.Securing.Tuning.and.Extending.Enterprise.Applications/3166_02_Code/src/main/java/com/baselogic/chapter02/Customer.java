package com.baselogic.chapter02;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
@NamedQuery(name = Constants.FINDALLFINDERNAME,
            query = Constants.FINDALLQUERY)
public class Customer extends AuditableEntity {

    //-----------------------------------------------------------------------//
    // Attributes
    //-----------------------------------------------------------------------//
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String username;
    private String firstName;
    private String lastName;

    @ElementCollection
    @CollectionTable(name = Constants.HOBBIES, joinColumns = @JoinColumn(name = Constants.CUSTOMER_ID))
    @Column(name = Constants.HOBBY_NAME, nullable = true)
    private Collection<String> hobbies = new HashSet<String>();

    @ElementCollection
    @CollectionTable(name = Constants.PHONES, joinColumns = @JoinColumn(name = Constants.CUSTOMER_ID))
    @Column(name = Constants.CUSTOMER_PHONES, nullable = true)
    private List<Phone> phones;

    @ElementCollection
    @CollectionTable(name = Constants.CUSTOMER_ADDRESSES,
            joinColumns = @JoinColumn(name = Constants.CUSTOMER_ID))
    @MapKeyColumn(name = Constants.ADDRESS_KEY)
    private Map<String, Address> addresses = new HashMap<String, Address>();

    @Column(length = 2000, nullable = true)
    private String description;

    //-----------------------------------------------------------------------//
    // Constructors
    //-----------------------------------------------------------------------//

    public Customer() {
    }

    public Customer(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //-----------------------------------------------------------------------//
    // Setters / Getters
    //-----------------------------------------------------------------------//
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Map<String, Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Map<String, Address> addresses) {
        this.addresses = addresses;
    }

    public Collection<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Collection<String> hobbies) {
        this.hobbies = hobbies;
    }
}
