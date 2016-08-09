/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch06;

import com.packt.ch06.entities.Student;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.Unmanaged;
import javax.enterprise.inject.spi.Unmanaged.UnmanagedInstance;

/**
 *
 * @author Administrator
 */
@ApplicationScoped
public class MySingletonBean {
    //...

    public void obtaineNoncontextual() {
        Unmanaged<Student> unmanagedBean = new Unmanaged<Student>(Student.class);
        UnmanagedInstance<Student> beanInstance = unmanagedBean.newInstance();
        Student foo = beanInstance.produce().inject().postConstruct().get();
        // Usage of the injected bean
        beanInstance.preDestroy().dispose();
    }
}
