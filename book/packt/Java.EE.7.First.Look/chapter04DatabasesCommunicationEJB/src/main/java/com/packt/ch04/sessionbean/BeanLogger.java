/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch04.sessionbean;

import com.packt.ch04.entities.Student;
import javax.ejb.Stateless;

/**
 *
 * @author Administrator
 */
@Stateless
public class BeanLogger implements BeanLoggerLocal {

   public void logInformation(Student entity){
       System.out.println(entity.getFirstname()+" student was created");
   }

}
