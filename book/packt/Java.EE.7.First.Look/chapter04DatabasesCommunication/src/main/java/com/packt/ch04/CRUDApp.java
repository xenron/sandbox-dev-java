package com.packt.ch04;

import com.packt.ch04.entities.Student;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class CRUDApp 
{
    public static void main( String[] args ) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04PU");
        EntityManager em = emf.createEntityManager();//create entity manager
        
        Student student = createStudent();
        
        em.getTransaction().begin();//begin transaction
        em.persist(student);//save the student
        em.getTransaction().commit(); // commit transaction
        
        Student std = em.find(Student.class, student.getId());//find student
        
        System.out.println("ID : "+std.getId()+", last name : "+std.getLastname());       
        em.getTransaction().begin();//begin transaction
        std.setLastname("NGANBEL");//Update student's last name
        em.getTransaction().commit(); // commit transaction
        
        std = em.find(Student.class, student.getId());//find student
        System.out.println("ID : "+std.getId()+", last name : "+std.getLastname()); 
        
        em.getTransaction().begin();//begin transaction
        em.remove(std);//remove student
        em.getTransaction().commit(); // commit transaction
        
    }
    
    public static Student createStudent(){
        Student student = new Student("AB78531679");
        student.setBirthdate(new Date());
        student.setEmail("jstuard@yahoo.fr");
        student.setFirstname("John");
        student.setLastname("STUARD");
        student.setPhone("869-41-74");
        return student;
    }    
}
