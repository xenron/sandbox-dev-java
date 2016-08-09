/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch08.bean;

import com.packt.ch08.entities.Student;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.Schedule;
import javax.inject.Named;
import javax.interceptor.AroundInvoke;
import javax.interceptor.AroundTimeout;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Administrator
 */
@Stateless
public class StudentSessionBean {    

    private Logger logger = Logger.getLogger(
            "studentSessionBean.targetClassInterceptor");
    
    public Student createEntity(Student std){
        logger.info("createEntity-Name of the student : "+std.getFirstname());        
        return std;
    }
    
    @AroundInvoke
    public Object targetClassMethodInterceptor(InvocationContext ctx) throws Exception{
        logger.info("targetClassMethodInterceptor - method : "+ctx.getMethod().getName()+", "
                + "parameters : "+Arrays.toString(ctx.getParameters())+", date : "+new Date());
        if(ctx.getMethod().getName().equals("createEntity")){
            Student std = (Student) ctx.getParameters()[0];
           logger.info("targetClassMethodInterceptor - Name of student before : "+std.getFirstname());
           if(!std.getFirstname().startsWith("Sir")){
              std.setFirstname("Sir "+std.getFirstname());
           }
        }  
        return  ctx.proceed();
    }
    
    @Schedule(minute="*/2", hour="*")
    public void executeEvery2Second(){
        logger.info("executeEvery2Second - executeEvery5Second - date : "+new Date());
    }
    
    @AroundTimeout
    public Object targetClassTimerInterceptor(InvocationContext ctx) throws Exception{
        logger.info("targetClassTimerInterceptor - method : "+ctx.getMethod().getName()+", timer : "+ctx.getTimer());
        return  ctx.proceed();
    }
}
