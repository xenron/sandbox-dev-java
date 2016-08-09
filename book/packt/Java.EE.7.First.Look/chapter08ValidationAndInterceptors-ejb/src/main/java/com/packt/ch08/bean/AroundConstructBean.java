/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch08.bean;

import java.util.Date;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 *
 * @author Administrator
 */
@Stateless
@Interceptors(AroundConstructInterceptor.class)
public class AroundConstructBean  {
    
    private Logger logger = Logger.getLogger(
            "AroundConstructManagedBean.interceptorClass");
    
    private Date dateTime;
    
    public AroundConstructBean(){     
        dateTime = new Date();
        logger.info("AroundConstructManagedBean - Execution time : "+dateTime);
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }        

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
