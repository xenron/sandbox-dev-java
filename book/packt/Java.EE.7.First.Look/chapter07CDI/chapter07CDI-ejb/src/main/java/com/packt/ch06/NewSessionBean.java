/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch06;

import com.packt.ch06.annotation.Logout;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
public class NewSessionBean {

    @Logout
    public void businessMethod() {
        //...
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
