/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch08.bean;

import java.util.logging.Logger;
import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.AroundTimeout;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Administrator
 */
@Log
@Interceptor
@Priority(2000)
public class LoggerInterceptor {
    private Logger MyLogger = Logger.getLogger(LoggerInterceptor.class.getName());
    
    @AroundInvoke
    public Object loggerMethod(InvocationContext  ctx) throws Exception{
        MyLogger.info("LoggerInterceptor - The intercepted method is :" + ctx.getMethod().getName());
        return ctx.proceed();
    }
    
    @AroundTimeout
    public Object targetClassTimerInterceptor(InvocationContext ctx) throws Exception{
        MyLogger.info("LoggerInterceptor - method name : "+ctx.getMethod().getName()+", timer : "+ctx.getTimer());
        return  ctx.proceed();
    }
}
