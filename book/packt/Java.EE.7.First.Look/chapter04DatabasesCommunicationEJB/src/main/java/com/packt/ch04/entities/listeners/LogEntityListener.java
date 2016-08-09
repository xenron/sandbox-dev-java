/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch04.entities.listeners;

import com.packt.ch04.entities.Student;
import com.packt.ch04.sessionbean.BeanLoggerLocal;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.persistence.PrePersist;

/**
 *
 * @author Administrator
 */
public class LogEntityListener {
    @EJB
    BeanLoggerLocal beanLogger;
    
    @PrePersist
    public void prePersistCallback(Student entity){
        beanLogger.logInformation(entity);
    }
    
    @PostConstruct
    public void init(){
        System.out.println("Dependency injected in LogEntityListener");
    }
    
    @PreDestroy
    public void destroy(){
        System.out.println("LogEntityListener will be destroy");
    }
}
