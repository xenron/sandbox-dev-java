/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.beans;

import java.text.DateFormat;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Ndjobo Armel Fabrice
 */
@ManagedBean(name = "studentBean")
public class StudentBean {

    private String identity = "12346789";
    private String lastName = "Edward";
    private String password;
    private String firstName;
    public static String staticField = "STATIC VALUE";

    public String onclickValidateListener() {
        String outcome = "failure";
        if ("arnoldp".equals(identity) && "123456".equals(password)) {
            outcome = "connected";
        }
        return outcome;
    }

    public void onclickCancelListener(ActionEvent evt) {
        password = "";
        identity = "";
        System.out.println("onclickCancelListener");
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
