/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch04.sessionbean;

import com.packt.ch04.entities.Student;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class StudentServiceBMT {

   @PersistenceContext
   EntityManager em;
   
   @Resource
   UserTransaction userTx;
   
   public void createStudent() throws Exception {
       try {
           userTx.begin();//begin transaction
           
           Student student = new Student();
           student.setBirthdate(new Date());
           student.setDepartid("GI");
           student.setId(""+ new Date().getTime());
           student.setFirstname("BMT - FIRST NAME");
           student.setLastname("BMT - Last name");
           
           em.persist(student);
           
           userTx.commit(); // commit transaction
       } catch (Exception ex) {
           userTx.rollback();//rollback transaction
           throw ex;
       } 
   }

}
