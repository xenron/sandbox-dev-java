/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch04.sessionbean;

import com.packt.ch04.entities.Student;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface BeanLoggerLocal {
    public void logInformation(Student entity);
    
}
