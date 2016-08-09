/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch08.bean;

import java.util.Arrays;
import java.util.Date;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.interceptor.AroundConstruct;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Administrator
 */
public class AroundConstructInterceptor {
    private Logger logger = Logger.getLogger(
            "AroundConstructInterceptor.interceptorClass");    
    
    @AroundConstruct
    public Object initialize(InvocationContext ctx) throws Exception{
        logger.info("initialize - constructor : "+ctx.getConstructor()+", "
                + "parameters : "+Arrays.toString(ctx.getParameters())+","
                + " execution time : "+new Date());
        return ctx.proceed();
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
