/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch04.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Administrator
 */
@Entity
@DiscriminatorValue(value = "APPUSER")
public class Appuser extends Person {
    private String userLogin;
    private String userRole;

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }        
}
