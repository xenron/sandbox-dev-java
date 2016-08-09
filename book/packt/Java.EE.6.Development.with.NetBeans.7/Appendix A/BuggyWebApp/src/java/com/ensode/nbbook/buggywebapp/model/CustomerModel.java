/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensode.nbbook.buggywebapp.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author heffel
 */
@Named
@RequestScoped
public class CustomerModel {

    private String firstName;
    private String lastName;

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

    @Override
    public String toString() {
        return "CustomerModel{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
    }
}
