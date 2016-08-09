/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensode.primefacesdemo.managedbeans;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author heffel
 */
@ManagedBean
@RequestScoped
public class Customer {

    /** Creates a new instance of Customer */
    public Customer() {
    }
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
    private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFormattedBirthDate() {
        return sdf.format(birthDate);
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
