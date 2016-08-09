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
public class JpqlApp {
    public static void main(String... args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04PU");
        EntityManager em = emf.createEntityManager();//create entity manager
        
        //List of student whose id is greater than 123
        String queryString = "SELECT a FROM Student a WHERE a.id > 123";
        Query query = em.createQuery(queryString);
        System.out.println("result : "+query.getResultList());
        
        //Join with ON condition
        queryString= "SELECT a FROM Student a JOIN Department b ON a.depart= b";
        query = em.createQuery(queryString);
        System.out.println("result : "+query.getResultList());
        
        //List of students born in July
        queryString= "SELECT a FROM Student a WHERE FUNCTION('MONTH',a.birthdate) = 7 ";        
        query = em.createQuery(queryString);
        System.out.println("result : "+query.getResultList());
        
        //Entity downcasting
        queryString = "SELECT  a FROM Person a "
                       + "   WHERE TYPE(a) = Appuser AND "
                       + "TREAT(a AS Appuser).userLogin = 'adwiner'";
        query = em.createQuery(queryString);
        System.out.println("result : "+query.getResultList());
    }                    
}
