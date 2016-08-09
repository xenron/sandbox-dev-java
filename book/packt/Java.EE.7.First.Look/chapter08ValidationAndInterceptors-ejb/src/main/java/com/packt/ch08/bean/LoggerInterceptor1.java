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
@Log1
@Interceptor
@Priority(2050)
public class LoggerInterceptor1 {
    private Logger MyLogger = Logger.getLogger(LoggerInterceptor1.class.getName());
    
    @AroundInvoke
    public Object loggerMethod(InvocationContext  ctx) throws Exception{
        MyLogger.info("LoggerInterceptor1 - The intercepted method is :" + ctx.getMethod().getName());
        return ctx.proceed();
    }
    
    @AroundTimeout
    public Object targetClassTimerInterceptor(InvocationContext ctx) throws Exception{
        MyLogger.info("LoggerInterceptor1 - method name : "+ctx.getMethod().getName()+", timer : "+ctx.getTimer());
        return  ctx.proceed();
    }
}
