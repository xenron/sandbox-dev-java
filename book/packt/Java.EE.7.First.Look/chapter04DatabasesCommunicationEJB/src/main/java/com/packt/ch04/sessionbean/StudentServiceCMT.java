/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch04.sessionbean;

import com.packt.ch04.entities.Student;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class StudentServiceCMT {

   @PersistenceContext
   EntityManager em;  
   
   public void createStudent(){
       Student student = new Student();
       student.setBirthdate(new Date());
       student.setDepartid("GI");
       student.setId(""+ new Date().getTime());
       student.setFirstname("CMT - FIRST NAME");
       student.setLastname("CMT - Last name");
       
       em.persist(student);
   }
}
