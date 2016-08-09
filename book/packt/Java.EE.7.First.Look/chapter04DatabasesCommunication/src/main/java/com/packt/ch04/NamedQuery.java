/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class NamedQuery {
    public static void main(String... args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04PU");        
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("SELECT a FROM Student a");
        emf.addNamedQuery("runtimeNamedQuery", query);
        
        System.out.println("result : "+em.createNamedQuery("runtimeNamedQuery").getResultList());
        
    }                
}
