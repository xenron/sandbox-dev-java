/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensode.ejbtimer.ejb;

import java.util.Date;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;

/**
 *
 * @author heffel
 */
@Stateless
@LocalBean
public class EJBTimerDemo {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Schedule(hour = "*", minute = "*", second = "*/30")
    public void logMessage() {
        System.out.println("logMessage() method invoked at: "
                + new Date(System.currentTimeMillis()));
    }
}
