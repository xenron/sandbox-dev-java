/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch04;

import com.packt.ch04.entities.Appuser;
import com.packt.ch04.entities.Department;
import com.packt.ch04.entities.Person;
import com.packt.ch04.entities.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Administrator
 */
public class CriteriaApi {

    public static void main(String... args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04PU");
        EntityManager em = emf.createEntityManager();//create entity manager

        //Criteria Query 
        //criteria builder declaration
        CriteriaBuilder cb = em.getCriteriaBuilder();
        //declaration of the object that will be returned by the query
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        //Declaration of the entity to which the request is made
        Root<Student> student = cq.from(Student.class);
        //Query construction
        cq.select(student).where(cb.greaterThan(student.<String>get("id"), "123"));
        TypedQuery<Student> tq = em.createQuery(cq);
        //execution of the query
        System.out.println("result : " + tq.getResultList());


        //bulk update
        CriteriaUpdate cUpdate = cb.createCriteriaUpdate(Student.class);
        Root root = cUpdate.from(Student.class);
        cUpdate.set(root.get("depart"), new Department("GT"))
               .where(cb.equal(root.get("depart"), new Department("GI")));          
        Query q = em.createQuery(cUpdate);
        
        em.getTransaction().begin();//begin transaction
        int num = q.executeUpdate();
        em.getTransaction().commit();//commit transaction
        System.out.println("number of update : "+num);
        
        //Downcasting
        //declaration of the object that will be returned by the query
        CriteriaQuery<Person> cqp = cb.createQuery(Person.class);
        //Declaration of the entity to which the request is made
        Root<Person> person = cqp.from(Person.class);
        //Query construction
        cqp.select(person).where(cb.equal(person.type(),Appuser.class),
                cb.equal(cb.treat(person, Appuser.class).get("userLogin"), "adwiner"));
        TypedQuery<Person> tqp = em.createQuery(cqp);
        //execution of the query
        System.out.println("result : " + tqp.getResultList());
    }
}
