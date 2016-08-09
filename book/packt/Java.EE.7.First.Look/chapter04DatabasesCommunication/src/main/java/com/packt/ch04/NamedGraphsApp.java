/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch04;

import com.packt.ch04.entities.Department;
import com.packt.ch04.entities.Student;
import java.util.Properties;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.PersistenceUtil;

/**
 *
 * @author Administrator
 */
public class NamedGraphsApp {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04PU");
        EntityManager em = emf.createEntityManager();//create entity manager
        PersistenceUnitUtil pUtil = emf.getPersistenceUnitUtil();

        Department depart = (Department) em.createQuery("Select e from Department e")
                .getResultList().get(0);
        System.out.println("students Was loaded ? "+pUtil.isLoaded(depart, "students"));
        
        EntityGraph includeThis = em.getEntityGraph("includeThis");
        depart = (Department) em.createQuery("Select e from Department e")
                .setHint("javax.persistence.fetchgraph", includeThis)
                .getResultList().get(0);
        System.out.println("students Was loaded ? "+pUtil.isLoaded(depart, "students")); 
    }
}
