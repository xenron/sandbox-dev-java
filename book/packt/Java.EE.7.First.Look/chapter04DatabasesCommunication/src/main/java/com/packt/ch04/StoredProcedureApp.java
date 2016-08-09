/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch04;

import com.packt.ch04.entities.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Administrator
 */
public class StoredProcedureApp {
    
    public static void main(String... args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04PU");
        EntityManager em = emf.createEntityManager();//create entity manager
        StoredProcedureQuery spQuery = em.createStoredProcedureQuery("getStudentsName",Student.class);
        List<Student> results = spQuery.getResultList();
        for(Student std : results)
            System.out.println(std.getLastname());
    }
}
