/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch05;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
public class NewSessionBean {

    public int addition(int a, int b) {
        return a + b;
    }
}
