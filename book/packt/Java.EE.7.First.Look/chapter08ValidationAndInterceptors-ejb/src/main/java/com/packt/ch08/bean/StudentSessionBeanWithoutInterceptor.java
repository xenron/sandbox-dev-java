/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch08.bean;

import com.packt.ch08.entities.Student;
import java.util.Date;
import java.util.logging.Logger;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 *
 * @author Administrator
 */
@Interceptors(MyInterceptor.class)
@Stateless
@Log1
@Log
public class StudentSessionBeanWithoutInterceptor {
    private Logger logger = Logger.getLogger(
            "studentSessionBean.targetClassInterceptor");
    
     @Schedule(minute="*/2", hour="*")
    public void executeEvery2Second(){
        logger.info("executeEvery2Second - executeEvery5Second - date : "+new Date());
    }
     
     public Student createEntity(Student std){
        logger.info("createEntity-Name of the student : "+std.getFirstname());        
        return std;
    } 
}
