/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch06;

import com.packt.ch06.entities.Student;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrator
 */
@ManagedBean
public class MyManagedBean {
    
    @Inject
    IHelloWorld hw;
    
    @EJB
    IMyEJB ejb;
    
    public String getMyHelloWorld(){
        return hw.getHelloWorld();
    }
    
    public String getMyEjbHelloWorld(){
        return ejb.getHelloWorld();
    }
    
    public void saveStudent(){
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("chap07PU");
        EntityManager em = emf.createEntityManager();
        Student std = new Student(""+new Date().getTime());
        em.persist(std);
    }
}
