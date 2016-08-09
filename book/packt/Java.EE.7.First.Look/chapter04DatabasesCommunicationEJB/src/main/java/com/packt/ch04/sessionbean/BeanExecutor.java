/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch04.sessionbean;

import com.packt.ch04.entities.Student;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 */
@Singleton
@LocalBean
@Startup
public class BeanExecutor {

    @EJB
    StudentServiceBMT studentBMT;
    @EJB
    StudentServiceCMT studentCMT;

    @PostConstruct
    public void init() {
        try {
            studentBMT.createStudent();
            Thread.sleep(20);
            studentCMT.createStudent();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
