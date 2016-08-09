/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch08.bean;

import com.packt.ch08.entities.Student;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.AroundTimeout;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Administrator
 */
public class MyInterceptor {
    private Logger logger = Logger.getLogger(
            "studentSessionBean.targetClassInterceptor");
    
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
        return ctx.proceed();
    }
     
      @AroundTimeout
    public Object targetClassTimerInterceptor(InvocationContext ctx) throws Exception{
        logger.info("targetClassTimerInterceptor - method : "+ctx.getMethod().getName()+", timer : "+ctx.getTimer());
        return  ctx.proceed();
    }
}
