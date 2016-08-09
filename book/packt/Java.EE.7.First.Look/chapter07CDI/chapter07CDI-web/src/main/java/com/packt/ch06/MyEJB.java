/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch06;

import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author Administrator
 */
@Named
@Stateless
public class MyEJB implements IMyEJB {

    public String getHelloWorld() {
        return "Hello world By EJB";
    }
}
