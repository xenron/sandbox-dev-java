/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch06;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.enterprise.inject.spi.CDI;
import javax.enterprise.inject.spi.Unmanaged;

/**
 *
 * @author Administrator
 */
@Singleton
@LocalBean
public class CdiContainerSingleton {

    @PostConstruct
    public void init() {
        CDI container = CDI.current();
//        container.destroy(destroableInstance);
    }
    
}
