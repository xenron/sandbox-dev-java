/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch06.annotation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

/**
 *
 * @author Administrator
 */
@Stateless
public class MySessionBean {

    @javax.annotation.Resource
    DataSource datasource;
    
    private String helloMessage = "Hello world";
    public String getHelloWorld(){
        return "Hello world";
    }

    public String getHelloMessage() {
        return helloMessage;
    }

    public void setHelloMessage(String helloMessage) {
        this.helloMessage = helloMessage;
    }    
}
